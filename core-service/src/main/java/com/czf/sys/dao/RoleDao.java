package com.czf.sys.dao;

import com.czf.sys.entity.RoleEntity;

import java.util.List;

public interface RoleDao extends BaseDao<RoleEntity> {

    /**
     * 根据用户查询角色集合
     * @param userid
     * @param status
     * @return
     */
    List<RoleEntity> queryByUserId(String userid, String status);

}
