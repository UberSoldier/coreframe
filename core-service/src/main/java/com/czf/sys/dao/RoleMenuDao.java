package com.czf.sys.dao;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface RoleMenuDao {
    int delete(Map<String, Object> map);

    int deleteBatch(Object[] ids);

    int delete(Object id);

    void save(Map<String, Object> map);

    List<String> queryListByRoleId(String roleId);
}
