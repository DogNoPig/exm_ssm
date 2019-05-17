package com.xw.ssm.service.impl;

import com.xw.ssm.dao.IUserDao;
import com.xw.ssm.domain.Role;
import com.xw.ssm.domain.UserInfo;
import com.xw.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author xw
 * @date 2019/5/16 13:39
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try{
            userInfo = userDao.findByUserName(s);
        }catch (Exception e){
            e.printStackTrace();
        }
        //处理自己的用户对象封装成userDetails
//        User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        String userName =  userInfo.getUserName();
        User user = new User(userInfo.getUserName(),userInfo.getPassword(),userInfo.getStatus() == 0 ? false:true,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }


    /**
     * 返回一个角色的描述
     * @return
     */
    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        //循环为用户赋予角色
        for (Role r:roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+r.getRoleName()));
        }


        return list;
    }

    @Override
    public void save(UserInfo userInfo) {

        //对密码进行加密
        String encodePassword = bCryptPasswordEncoder.encode(userInfo.getPassword());
        userInfo.setPassword(encodePassword);
        userDao.save(userInfo);
    }

    @Override
    public UserInfo findById(Integer id) {
        return userDao.findById(id);
    }
}
