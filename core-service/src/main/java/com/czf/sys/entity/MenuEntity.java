package com.czf.sys.entity;

import com.czf.base.entity.BaseEntity;

import java.util.List;

/**
 * 菜单表
 */
public class MenuEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    //主键id
    private String id;
    //父菜单id
    private String parentId;
    //所有父id
    private String parentIds;
    //菜单名称
    private String name;
    //菜单链接
    private String url;
    //菜单图标
    private String icon;
    //排序
    private Integer sort;
    //状态（0显示，-1隐藏)
    private String status;
    //权限标识
    private String permission;
    //备注
    private String remark;
    //菜单类型
    private String type;
    //父菜单名字
    private String parentName;
    //子类菜单
    private List list;
    //是否展开 true是 false否
    private String open;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    public String getParentIds() {
        return parentIds;
    }

    public void setParentIds(String parentIds) {
        this.parentIds = parentIds;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPermission() {
        return permission;
    }

    public void setPermission(String permission) {
        this.permission = permission;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public String getOpen() {
        return open;
    }

    public void setOpen(String open) {
        this.open = open;
    }
}
