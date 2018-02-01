package com.czf.sys.dao;

import com.czf.sys.entity.MenuEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuDao extends BaseDao<MenuEntity> {

    List<MenuEntity> queryByUserId(String userId);

}
