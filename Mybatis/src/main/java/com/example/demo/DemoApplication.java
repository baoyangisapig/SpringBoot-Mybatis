package com.example.demo;

import com.winter.model.User;
import com.winter.service.UserService;
import com.winter.service.impl.UserServiceImpl;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@SpringBootApplication
@MapperScan("com.winter.mapper")//将项目中对应的mapper类的路径加进来就可以了
@ComponentScan("com.winter.*")
@Controller
public class DemoApplication {

    @Autowired
    private UserService userService; // 自动装配UserService的实现类，前提是该实现类已经被扫描并注入spring容器



    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    @ResponseBody
    @RequestMapping(value="/")
    int index()
    {
        User user=new User();
        user.setId(4);
        user.setName("Mike");
        return userService.addUser(user);

    }
}
