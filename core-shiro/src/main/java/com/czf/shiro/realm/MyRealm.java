package com.czf.shiro.realm;

import com.czf.base.common.Constant;
import com.czf.sys.entity.MenuEntity;
import com.czf.sys.entity.RoleEntity;
import com.czf.sys.entity.UserEntity;
import com.czf.sys.service.MenuService;
import com.czf.sys.service.RoleService;
import com.czf.sys.service.UserService;
import com.czf.utils.ShiroUtils;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authc.credential.CredentialsMatcher;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * shiro 认证
 */
public class MyRealm extends AuthorizingRealm {

    private static final Logger logger = LoggerFactory.getLogger(MyRealm.class);

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        UserEntity user = (UserEntity) principals.getPrimaryPrincipal();
        if (user != null) {
            //根据用户id查询该用户所有角色，并加入到shiro的SimpleAuthorizationInfo
            List<RoleEntity> roles = roleService.queryByUserId(user.getId(), Constant.YESNO.YES.getValue());
            for (RoleEntity role:roles) {
                info.addRole(role.getId());
            }
            //查询所有该用户授权菜单，并加到shiro的SimpleAuthorizationInfo做菜单按钮权限控制
            Set<String> permissions = new HashSet<>();
            List<MenuEntity> menuEntities = null;
            //超级管理员拥有最高权限
            if (Constant.SUPERR_USER.equalsIgnoreCase(user.getId())) {
                menuEntities = menuService.queryList(new HashedMap());
            } else {
                //普通账户权限查询
                menuEntities = menuService.queryByUserId(user.getId());
            }
            for (MenuEntity menuEntity:menuEntities) {
                if (StringUtils.isNotEmpty(menuEntity.getPermission())) {
                    permissions.add(menuEntity.getPermission());
                }
            }
            info.addStringPermissions(permissions);
        }
        return info;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String userLoginName = (String) token.getPrincipal();
        System.out.println(userLoginName);
        UserEntity user = userService.queryByLoginName(userLoginName);
        if (user == null) {
            throw new AuthenticationException("账号密码错误");
        }
        if (Constant.ABLE_STATUS.NO.getValue().equals(user.getStatus())) {
            throw new LockedAccountException("账号被禁用，请联系管理员!");
        }
        //用户对应的机构集合
        List<String> baidList = userService.queryBapidByUserIdArray(user.getId());
        //用户对应的部门集合
        List<String> bapidList = userService.queryBaidByUserIdArray(user.getId());
        user.setBapidList(bapidList);
        user.setBaidList(baidList);
        SimpleAuthenticationInfo sainfo = new SimpleAuthenticationInfo(user, user.getPassWord(), ByteSource.Util.bytes(user.getSalt()), getName());
        return sainfo;
    }

    @Override
    public void setCredentialsMatcher(CredentialsMatcher credentialsMatcher) {
        HashedCredentialsMatcher shaCredentialsMatcher = new HashedCredentialsMatcher();
        shaCredentialsMatcher.setHashAlgorithmName(ShiroUtils.algorithmName);
        shaCredentialsMatcher.setHashIterations(ShiroUtils.hashIterations);
        super.setCredentialsMatcher(shaCredentialsMatcher);
    }
}
