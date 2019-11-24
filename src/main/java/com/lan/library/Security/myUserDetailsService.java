package com.lan.library.Security;

import com.lan.library.Dao.UserDao;
import com.lan.library.Entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Xiang Lan
 * Created on 2019-07-08 21:28
 */

@Slf4j
@Service
public class myUserDetailsService implements UserDetailsService {

    @Autowired
    private UserDao userDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        User user = userDao.findUserByName(username);
        System.err.println("loadbyname");
        if (user == null) {
            throw new UsernameNotFoundException("UserName " + username + " not found");
        }

        List<GrantedAuthority> authorities = user.getUserRoles()
                .stream()
                .map(userRole -> new SimpleGrantedAuthority(userRole.getRole().name())).collect(Collectors.toList());
        return new UserDetailsImpl(user.getId(),user.getName(),user.getPassword(),authorities);
    }

    // This method is used by JWTAuthenticationFilter
    public UserDetails loadUserById(Integer id) {
        User user = userDao.findById(id.intValue()).orElseThrow(
                () -> new UsernameNotFoundException("User not found with id : " + id)
        );
        log.info(user.toString());
        List<GrantedAuthority> authorities = user.getUserRoles()
                .stream()
                .map(userRole -> new SimpleGrantedAuthority(userRole.getRole().name())).collect(Collectors.toList());
        return new UserDetailsImpl(user.getId(),user.getName(),user.getPassword(),authorities);
    }
}
