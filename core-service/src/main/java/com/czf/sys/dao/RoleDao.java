package com.czf.sys.dao;

import com.czf.sys.entity.RoleEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleDao extends BaseDao<RoleEntity> {

    /**
     * 根据用户查询角色集合
     * @param userid
     * @param status
     * @return
     */
    List<RoleEntity> queryByUserId(String userid, String status);

    /**
     * 批量保存组织机构与角色关系表
     * @param map
     * @return
     */
    int batchSaveRoleOrgan(Map map);

}
