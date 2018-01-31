package com.czf.sys.service;


import com.czf.sys.entity.RoleEntity;

import java.util.List;
import java.util.Map;

/**
 * 角色表
 */
public interface RoleService {

    RoleEntity queryObject(String id);

    List<RoleEntity> queryList(Map<String, Object> map);

    int queryTotal(Map<String, Object> map);

    void save(RoleEntity role) throws Exception;

    void update(RoleEntity role);

    void delete(String id);

    void deleteBatch(String[] ids) throws Exception;

    /**
     * 根据用户id查询用户所有的可用角色
     * @param userId
     * @param status
     * @return
     */
    List<RoleEntity> queryByUserId(String userId, String status);

}
