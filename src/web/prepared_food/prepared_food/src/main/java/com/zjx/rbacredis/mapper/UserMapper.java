package com.zjx.rbacredis.mapper;

import com.zjx.rbacredis.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


@Mapper
public interface UserMapper {
    User queryByUsername(String username);

    User queryInfo(Long userId);

    User queryByUserId(int userId);
}
