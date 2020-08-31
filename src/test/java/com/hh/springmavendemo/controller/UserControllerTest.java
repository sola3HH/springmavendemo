package com.hh.springmavendemo.controller;

import com.hh.springmavendemo.SpringmavendemoApplication;
import com.hh.springmavendemo.model.dto.RegisterRequest;
import com.hh.springmavendemo.model.dto.ShowRequest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import java.util.Map;

/**
 * @author YAOSHUNYU
 * @Date 2019/9/17
 * @Time 15:36
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SpringmavendemoApplication.class)
public class UserControllerTest {

    private MockMvc mockMvc; //对非Restcontroller可用mockmvc进行调用测试，Restcontroller还是老老实实用swagger吧

    @Autowired
    private WebApplicationContext webApplicationContext;
//  @Autowired
//  private UserController userController;  替代方案

    public UserControllerTest() {
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("--------测试初始化--------");
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
//      mockMvc = MockMvcBuilders.standaloneSetup(userController).build();  替代方案
    }

    @Test
    public void register() throws Exception {
        RestTemplate restTemplate = new RestTemplate(); //用于测试在服务器中运行的controller
        String url = "http://localhost:8080/user/save";
        RegisterRequest registerRequest = new RegisterRequest();
        registerRequest.setAppId("101");
        registerRequest.setAppSecret("101");
        registerRequest.setUsername("ysy");
        registerRequest.setPassword("123");
        Map result = restTemplate.postForObject(url, registerRequest, Map.class);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.get("code"));
        Assert.assertNotNull(result.get("msg"));
        Assert.assertEquals(20000, result.get("code"));
        Assert.assertEquals("成功", result.get("msg"));
        System.out.println("code: " + result.get("code"));
        System.out.println("msg: " + result.get("msg"));
    }

    @Test
    public void show() {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8080/user/show";
        ShowRequest showRequest = new ShowRequest();
        showRequest.setAppId("101");
        showRequest.setAppSecret("101");
        showRequest.setUsername("ysy");
        Map result = restTemplate.postForObject(url, showRequest, Map.class);

        Assert.assertNotNull(result);
        Assert.assertNotNull(result.get("code"));
        Assert.assertNotNull(result.get("msg"));
        Assert.assertEquals(20000, result.get("code"));
        Assert.assertEquals("成功", result.get("msg"));
        System.out.println("code: " + result.get("code"));
        System.out.println("msg: " + result.get("msg"));
        System.out.println("result: " + result.get("result"));
    }
}