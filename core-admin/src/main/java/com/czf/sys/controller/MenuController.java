package com.czf.sys.controller;

import com.czf.base.utils.Result;
import com.czf.sys.entity.MenuEntity;
import com.czf.sys.service.MenuService;
import com.czf.utils.ShiroUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/sys/menu")
public class MenuController extends BaseController {

    @Autowired
    private MenuService menuService;

    @RequestMapping(value = "/userMenu")
    public Result userMenu() {
        List<MenuEntity> menuEntities = menuService.queryListUser(ShiroUtils.getUserId());
        return Result.ok().put("menuList", menuEntities);
    }

}
