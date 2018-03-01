package com.czf.sys.dao;

import com.czf.sys.entity.MenuEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao extends BaseDao<MenuEntity> {

    /**
     *根据登陆用户Id,查询出所有授权菜单
     * @param userId
     * @return
     */
    List<MenuEntity> queryByUserId(String userId);

    /**
     * 根据父菜单Id查询菜单
     * @param parentId
     * @return
     */
    List<MenuEntity> queryListParentId(String parentId);

    /**
     * 查询所有不包括按钮 的菜单
     * @return
     */
    List<MenuEntity> queryNotButtonnList(String[] types);
}
