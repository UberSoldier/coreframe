package com.czf.utils;

import com.czf.sys.entity.UserEntity;
import com.czf.sys.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 类的功能描述.
 * 用户工具类
 */
public class UserUtils {

    @Autowired
    private UserService userService;

    /**
     * 从shiro中获取当前登陆用户
     * @return
     */
    public static UserEntity getCurrentUser() {
        UserEntity user = ShiroUtils.getUserEntity();
        return user;
    }

}
