package com.zjx.rbacredis.entity;




import lombok.*;

import java.io.Serializable;
import java.util.Date;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class LoginUser implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long userId;
    private String token;
    private Date loginTime;
    private String ipaddr;
    private String loginLocation;
    private String browser;
    private String os;
    private User user;

}
