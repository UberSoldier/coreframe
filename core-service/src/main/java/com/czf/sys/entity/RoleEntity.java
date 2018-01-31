package com.czf.sys.entity;

import com.czf.base.entity.BaseEntity;

import java.io.Serializable;
import java.util.List;

/**
 * 角色表
 */
public class RoleEntity extends BaseEntity implements Serializable {

    private static final long serialVersionUTD = 1L;

    //菜单列表
    private List<String> menuIdList;

    //组织机构列表
    private List<String> organIdList;

    //角色id
    private String id;
    //角色名称
    private String name;
    //角色代码
    private String code;
    //角色状态(0正常   1禁用)
    private String status;
    //角色类型
    private String roleType;

    public List<String> getMenuIdList() {
        return menuIdList;
    }

    public void setMenuIdList(List<String> menuIdList) {
        this.menuIdList = menuIdList;
    }

    public List<String> getOrganIdList() {
        return organIdList;
    }

    public void setOrganIdList(List<String> organIdList) {
        this.organIdList = organIdList;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getRoleType() {
        return roleType;
    }

    public void setRoleType(String roleType) {
        this.roleType = roleType;
    }
}
