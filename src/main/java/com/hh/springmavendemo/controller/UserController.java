package com.hh.springmavendemo.controller;

import com.hh.springmavendemo.common.ExceptionEnum;
import com.hh.springmavendemo.common.exception.ProjectException;
import com.hh.springmavendemo.common.model.ResultDTO;
import com.hh.springmavendemo.common.model.ResultMap;
import com.hh.springmavendemo.model.dto.RegisterRequest;
import com.hh.springmavendemo.model.dto.ShowRequest;
import com.hh.springmavendemo.model.po.User;
import com.hh.springmavendemo.service.AuthService;
import com.hh.springmavendemo.service.UserService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;

@Slf4j
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
    public ResultDTO register(HttpServletResponse httpServletResponse, @RequestBody RegisterRequest registerRequest) throws Throwable{
        if (!authService.isValidPass(registerRequest.getAppId(), registerRequest.getAppSecret())) {
//            return ResultMap.getCustomException(ExceptionEnum.AUTHENTIFICATION_FAILED);
            throw new ProjectException(ExceptionEnum.AUTHENTIFICATION_FAILED);
        }
        if(registerRequest.getUsername().isEmpty()||registerRequest.getPassword().isEmpty()) {
//            return ResultMap.getCustomException(ExceptionEnum.ILLEGAL_ARGUMENT);
            throw new ProjectException(ExceptionEnum.ILLEGAL_ARGUMENT);
        }
        for(User user: userService.showAllUser()){
            if(user.getUsername().equals(registerRequest.getUsername())){
//                return ResultMap.getCustomException(ExceptionEnum.USER_EXISTS);
                throw new ProjectException(ExceptionEnum.USER_EXISTS);
            }
        }
        User user = new User(registerRequest.getUsername(), registerRequest.getPassword());
        userService.insertUser(user);
        log.info("Successfully add user: " + user.getUsername());
        return ResultMap.successMsg();
    }


    @RequestMapping(value = "/show", method = RequestMethod.POST)
    @ApiOperation(value = "Show userList", notes = "Show UserList")
    public ResultDTO show(HttpServletResponse httpServletResponse, @RequestBody ShowRequest showRequest) throws Throwable {
        if (!authService.isValidPass(showRequest.getAppId(), showRequest.getAppSecret())) {
//            return ResultMap.getCustomException(ExceptionEnum.AUTHENTIFICATION_FAILED);
            throw new ProjectException(ExceptionEnum.ILLEGAL_ARGUMENT);
        }
        if(showRequest.getUsername().isEmpty()) {
//            return ResultMap.getCustomException(ExceptionEnum.ILLEGAL_ARGUMENT);
            throw new ProjectException(ExceptionEnum.ILLEGAL_ARGUMENT);
        }
        for(User user: userService.showAllUser()){
            if(user.getUsername().equals(showRequest.getUsername())) {
                log.info("Successfully show user: " + user.getUsername());
                return ResultMap.successWithObject(user);
            }
        }
//        return ResultMap.getCustomException(ExceptionEnum.USER_NOTFOUND);
        throw new ProjectException(ExceptionEnum.USER_NOTFOUND);
    }
}
