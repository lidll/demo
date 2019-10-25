package com.noah.demo.config;

import com.noah.demo.controller.WebSocketServer;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 描述：
 *
 * @author caojing
 * @create 2019-01-27-13:57
 */
@Slf4j
public class CustomRealm extends AuthorizingRealm {

    /**
     *
     * @Author yz
     * @Description 初始化当前用户权限 权限认证
     * @Date 2019-10-25 11:15
     * @param principalCollection
     * @return org.apache.shiro.authz.AuthorizationInfo
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Set<String> stringSet = new HashSet<>();
        stringSet.add("user:show");
        stringSet.add("user:admin");
        info.setStringPermissions(stringSet);
        return info;
    }

    /**
     *
     * @Author yz
     * @Description 身份验证 通过登录的账号密码来验证登录人信息
     * @Date 2019-10-25 11:21
     * @param authenticationToken
     * @return org.apache.shiro.authc.AuthenticationInfo
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal();
        log.info("-------CustomRealm身份认证------登录用户:" + userName);
        ConcurrentHashMap<String, WebSocketServer> socketMap = WS.socketMap;
        log.info(socketMap.toString());
        if (socketMap.get(userName) != null) {
            throw new AccountException("当前名称已被使用");
        }

//        String userPwd = new String((char[]) authenticationToken.getCredentials());
//        //根据用户名从数据库获取密码
//        String password = "123";
//        if (userName == null) {
//            throw new AccountException("用户名不正确");
//        } else if (!userPwd.equals(password )) {
//            throw new AccountException("密码不正确");
//        }
        return new SimpleAuthenticationInfo(userName, "aaa",getName());
    }
}
