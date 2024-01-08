package com.zjx.rbacredis.interceptor;



import com.zjx.rbacredis.configuration.CustomObjectMapper;
import com.zjx.rbacredis.configuration.RedisUtil;
import com.zjx.rbacredis.constant.Constant;
import com.zjx.rbacredis.entity.LoginUser;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.HandlerInterceptor;


/**
 * 拦截器实现类
 */
public class LoginInterceptor implements HandlerInterceptor {
    @Resource
    private RedisUtil redisUtil;

    @Resource
    private CustomObjectMapper objectMapper;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
      /*  //1.设置一个白名单
//        List<String> whiteNames = new ArrayList<>();
//        whiteNames.add("/admin/login");
//        if(whiteNames.contains(request.getRequestURI())) return true;
        //2.如果不是白名单，检测
        //判断有没有Authoriza，拿到首部信息的Authoriza的值
        response.setCharacterEncoding("utf-8");
        response.getOutputStream().println("intercepted");
        ResponseEntity<String> response1 = ResponseEntity.status(401).body("Bad Credentials!");
        String token = request.getHeader(Constant.HEAD_AUTHORIZATION);
        String tokenKey = Constant.TOKEN_PREFIX + request.getHeader("username") + ":" + token;
        if(token == null){
            response.setStatus(401);
            response.getOutputStream().write(objectMapper.writeValueAsString(response1).getBytes());
            return false;
        }
        //3.使用token去redis中查看有没有对应的user
        LoginUser user = (LoginUser) redisUtil.get(tokenKey);
        if(user == null){
            response.setStatus(401);
            response.getOutputStream().write(objectMapper.writeValueAsString(response1).getBytes());
            return false;
        }
        redisUtil.addTTL(tokenKey,Constant.TOKEN_TTL);*/
        return true;
    }
}
