package cn.tbs.service;

import cn.tbs.mapper.UserMapper;
import cn.tbs.pojo.Role;
import cn.tbs.pojo.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Resource
    PasswordEncoder passwordEncoder;
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
      UserInfo  userInfo = userMapper.findUserByUserName(s);
      User user = null;
      if(userInfo != null){
           user = new User(
                  userInfo.getUsername(),
                  userInfo.getPassword(),
                  userInfo.getStatus() == 0 ? false : true,//校验用户是否开启
                  true, //帐号是否过期 不过期
                  true, //证号 不过期
                  true, //帐号 不锁定
                   getAuthority(userInfo.getRoles()));
      }
      return  user;
    }

    private List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for(Role role : roles){
            System.out.println("对应角色:"+role.getRoleName());
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<UserInfo> findAllUsers() {
        System.out.println(userMapper.findAllUsers());
        return userMapper.findAllUsers();
    }
}
