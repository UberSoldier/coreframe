package com.czf.sys.service.impl;

import com.czf.base.utils.Utils;
import com.czf.sys.dao.RoleDao;
import com.czf.sys.dao.RoleMenuDao;
import com.czf.sys.entity.RoleEntity;
import com.czf.sys.entity.UserEntity;
import com.czf.sys.service.RoleService;
import com.czf.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("roleService")
@Transactional
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Autowired
    private RoleMenuDao roleMenuDao;

    @Override
    public RoleEntity queryObject(String id) {
        return roleDao.queryObject(id);
    }

    @Override
    public List<RoleEntity> queryList(Map<String, Object> map) {
        return roleDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return roleDao.queryTotal(map);
    }

    @Override
    @Transactional
    public void save(RoleEntity role) throws Exception {
        UserEntity currentUser = UserUtils.getCurrentUser();
        role.setBapid(currentUser.getBapid());
        role.setBaid(currentUser.getBaid());
        role.setCreateId(currentUser.getId());
        role.setId(Utils.uuid());
        role.setCreateTime(new Date());
        roleDao.save(role);
        saveRtable(role);
    }

    public void saveRtable(RoleEntity role) {
        if (role.getMenuIdList() != null && role.getMenuIdList().size()>0) {
            Map map = new HashMap();
            map.put("roleId", role.getId());
            map.put("menuIdList", role.getMenuIdList());
            roleMenuDao.save(map);
        }
        if (role.getOrganIdList() != null && role.getOrganIdList().size()>0) {
            Map organ = new HashMap();
            organ.put("role_id", role.getId());
            organ.put("organIdList", role.getOrganIdList());
            roleDao.batchSaveRoleOrgan(organ);
        }
    }

    @Override
    public void update(RoleEntity role) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public void deleteBatch(String[] ids) throws Exception {

    }

    @Override
    public List<RoleEntity> queryByUserId(String userId, String status) {
        return roleDao.queryByUserId(userId, status);
    }
}
