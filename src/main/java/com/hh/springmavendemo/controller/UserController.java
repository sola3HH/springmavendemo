package com.hh.springmavendemo.controller;

import com.hh.springmavendemo.common.model.ResultDTO;
import com.hh.springmavendemo.common.model.ResultMap;
import com.hh.springmavendemo.model.po.User;
import com.hh.springmavendemo.model.dto.RegisterRequest;
import com.hh.springmavendemo.model.dto.ShowRequest;
import com.hh.springmavendemo.service.AuthService;
import com.hh.springmavendemo.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private final AuthService authService;
    private final UserService userService;

    @Autowired
    public UserController(AuthService authService, UserService userService) {
        this.authService = authService;
        this.userService = userService;
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @ApiOperation(value = "Register a new user", notes = "Register User")
    public ResultDTO register(HttpServletResponse httpServletResponse, @RequestBody RegisterRequest registerRequest) {
        if (!authService.isValidPass(registerRequest.getAppId(), registerRequest.getAppSecret())) {
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }
        User user = new User(registerRequest.getName(), registerRequest.getPassword());
        userService.insertUser(user);
        return ResultMap.successMsg();
    }

    @RequestMapping(value = "/show", method = RequestMethod.POST)
    @ApiOperation(value = "Show userList", notes = "Show UserList   ")
    public ResultDTO show(HttpServletResponse httpServletResponse, @RequestBody ShowRequest showRequest) {
        if (!authService.isValidPass(showRequest.getAppId(), showRequest.getAppSecret())) {
            httpServletResponse.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return null;
        }
        return ResultMap.successWithObject(userService.showAllUser());
    }
}
