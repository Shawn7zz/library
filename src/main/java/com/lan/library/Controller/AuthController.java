package com.lan.library.Controller;

import com.lan.library.Dao.UserDao;
import com.lan.library.Entity.RoleName;
import com.lan.library.Entity.User;
import com.lan.library.Entity.UserRole;
import com.lan.library.Security.JwtTokenProvider;
import com.lan.library.Service.UserService;
import com.lan.library.api.request.LoginRequest;
import com.lan.library.api.request.SignUpRequest;
import com.lan.library.api.response.JwtAuthenticationResponse;
import com.lan.library.api.response.UserOperationResponse;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;


/**
 * @author Xiang Lan
 * Created on 2019-06-25 16:47
 */
@RestController
@RequestMapping("/api/auth")
@Api(value = "Auth")
public class AuthController {


    @Autowired
    private UserService userService;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @PostMapping("/user/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
//        if (userService.findUserByUserName(loginRequest.getUsername(), loginRequest.getPassword()) != null) {
//            return new ResponseEntity<>(new UserOperationResponse(true, "login successfully"), HttpStatus.OK);
//        }
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        String jwt = jwtTokenProvider.generateToken(authentication);
//        return new ResponseEntity<>(new UserOperationResponse(true, "login successfully"), HttpStatus.OK);
        return new ResponseEntity<>(new JwtAuthenticationResponse(jwt),HttpStatus.OK);
    }

    @PostMapping("/user")
    public ResponseEntity<UserOperationResponse> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

        User user = new User();
        user.setName(signUpRequest.getUsername());
        user.setPassword(passwordEncoder.encode(signUpRequest.getPassword()));
        user.setEmail(signUpRequest.getEmail());
        user.setRegisterTime(new Timestamp(new Date().getTime()));
        Set<UserRole> roles = new HashSet<>();
        roles.add(new UserRole(RoleName.ROLE_USER));
        if(signUpRequest.getAdmin()){
           roles.add(new UserRole(RoleName.ROLE_ADMIN));
        }
        user.setUserRoles(roles);
        for (UserRole userRole : roles){
            userRole.setUser(user);
        }

        userDao.save(user);
        return new ResponseEntity<>(new UserOperationResponse(true, "register successfully"), HttpStatus.OK);
    }

}
