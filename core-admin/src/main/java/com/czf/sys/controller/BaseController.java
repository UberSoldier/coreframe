package com.czf.sys.controller;

import com.czf.sys.entity.UserEntity;
import com.czf.utils.UserUtils;
import org.apache.log4j.Logger;


/**
 * 类的功能描述
 * 公共的控制器，可在类中实现一些共同的方法和属性
 */
public class BaseController {

    private Logger logger = Logger.getLogger(getClass());

    /**
     * 获取当前登录用户
     * @return
     */
    public UserEntity getUser() {
        //return UserUtils.getCurrentUser();
        return null;
    }

    public String getUserId() {
        UserEntity user = getUser();
        if (null != user && null != user.getId()) {
            return user.getId();
        }
        return "";
    }

}
