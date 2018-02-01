package com.czf.sys.dao;

import com.czf.sys.entity.UserEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao extends BaseDao<UserEntity> {

    /**
     * 根据登陆用户查询有效的用户
     * @param loginName
     * @return
     */
    UserEntity queryByLoginName(String loginName);

    /**
     * 用户对应的机构id,数据权限控制
     * @param userId
     * @param type 结点类型：0=根节点 ，1=机构，2=部门 具体见:Constant 类
     */
    List<String> queryOrganIdByUserIdArray(String userId, String type);
}
