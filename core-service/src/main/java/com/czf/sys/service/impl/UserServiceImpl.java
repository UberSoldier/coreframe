package com.czf.sys.service.impl;

import com.czf.base.common.Constant;
import com.czf.base.exception.MyException;
import com.czf.sys.dao.UserDao;
import com.czf.sys.entity.UserEntity;
import com.czf.sys.service.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity queryByLoginName(String loginName) {
        return userDao.queryByLoginName(loginName);
    }

    @Override
    public List<String> queryBapidByUserIdArray(String userId) {
        if (StringUtils.isEmpty(userId)) {
            throw new MyException("用户id为空，获取用户组织机构权限失败");
        }
        return userDao.queryOrganIdByUserIdArray(userId, Constant.OrganType.DEPART.getValue());
    }

    @Override
    public List<String> queryBaidByUserIdArray(String userId) {
        if (StringUtils.isEmpty(userId)) {
            throw new MyException("用户id为空，获取用户组织机构权限失败");
        }
        return userDao.queryOrganIdByUserIdArray(userId, Constant.OrganType.ORGAN.getValue());
    }
}
