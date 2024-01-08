package com.zjx.rbacredis.aspect;

import com.zjx.rbacredis.annotation.HasPermission;
import com.zjx.rbacredis.annotation.HasRole;
import com.zjx.rbacredis.configuration.RedisUtil;
import com.zjx.rbacredis.constant.Constant;
import com.zjx.rbacredis.exception.HasNotPermissionException;
import com.zjx.rbacredis.exception.HasNotRoleException;
import com.zjx.rbacredis.util.CustomUtil;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * aop切面配置
 * 通过注解作为切入点来进行权限验证
 */
@Aspect
@Component
public class PermissionAspect {
    @Resource
    private RedisUtil redisUtil;

    @Before("@annotation(hasRole)")
    public void roleBefore(JoinPoint joinPoint,HasRole hasRole) throws HasNotRoleException {
        String[] needRoles = new String[]{hasRole.value()};
        HttpServletRequest request = CustomUtil.getRequest();
        String token = request.getHeader(Constant.HEAD_AUTHORIZATION);
        List<String> roles = (List<String>) redisUtil.get(Constant.ROLE_PREFIX + token);
        boolean flag = false;
        for(String needRole : needRoles){
            if(roles.contains(needRole)){
                flag = true;
                break;
            }
        }
        if(flag == false){
            throw new HasNotRoleException("Not have permission");
        }
    }

    @Before("@annotation(hasPermission)")
    public void permBefore(JoinPoint joinPoint, HasPermission hasPermission) throws HasNotRoleException, HasNotPermissionException {
        String[] needPermissions= new String[]{hasPermission.value()};
        HttpServletRequest request = CustomUtil.getRequest();
        String token = request.getHeader(Constant.HEAD_AUTHORIZATION);
        List<String> permissions = (List<String>) redisUtil.get(Constant.PERM_PREFIX + token);
        boolean flag = false;
        for(String needPerm : needPermissions){
            if(permissions.contains(needPerm)){
                flag = true;
                break;
            }
        }
        if(flag == false){
            throw new HasNotPermissionException("Not have permission");
        }
    }
}
