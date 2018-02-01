package com.czf.sys.service.impl;

import com.czf.sys.dao.MenuDao;
import com.czf.sys.entity.MenuEntity;
import com.czf.sys.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("menuService")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<MenuEntity> queryList(Map<String, Object> map) {
        return menuDao.queryList(map);
    }

    @Override
    public List<MenuEntity> queryByUserId(String userId) {
        return menuDao.queryByUserId(userId);
    }

}
