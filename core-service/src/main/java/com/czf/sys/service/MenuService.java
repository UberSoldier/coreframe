package com.czf.sys.service;

import com.czf.sys.entity.MenuEntity;
import org.apache.commons.collections.map.HashedMap;

import java.util.List;
import java.util.Map;

/**
 * 菜单表
 */
public interface MenuService {

    List<MenuEntity> queryList(Map<String, Object> map);

    /**
     * 根据登陆用户Id,查询出所有授权菜单 按钮 登陆授权
     * @param userId
     * @return
     */
    List<MenuEntity> queryByUserId(String userId);
}
