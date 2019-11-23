package xyz.wlzl.wplzuserserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.wlzl.wplzuserserver.entity.User;
import xyz.wlzl.wplzuserserver.service.UserService;
import xyz.wlzl.wplzuserserver.service.impl.UserServiceImpl;

import java.util.List;

@RestController
public class Controller {
    @Autowired
    private UserServiceImpl userService;

    @RequestMapping("/login")
    public String login(@RequestBody User user){
        String password = userService.findByUsernama(user.getUsername());
        return password;

    }
    @RequestMapping("/userAdd")
    public void userAdd(@RequestBody User user ){
        userService.userAdd(user);
    }
    @RequestMapping("/userUpdate")
    public void userUpdate(@RequestBody User user){
        userService.userUpdate(user);

    }
    @RequestMapping("/userFindAll")
    public List<User> userFindAll(){
        List<User> list = userService.findAll();
        return list;
    }

}
