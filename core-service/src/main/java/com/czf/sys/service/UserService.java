package com.czf.sys.service;

import com.czf.sys.entity.UserEntity;

import java.util.List;

/**
 * 系统用户服务
 */
public interface UserService {

    /**
     * 根据登录用户查询有效的用户
     * @param userLoginName
     * @return
     */
    UserEntity queryByLoginName(String userLoginName);

    /**
     * 用户对应的机构id,数据权限控制
     * @param userId
     */
    List<String> queryBapidByUserIdArray(String userId);

    /**
     * 用户对应的部门id,数据权限控制
     * @param userId
     */
    List<String> queryBaidByUserIdArray(String userId);
}
