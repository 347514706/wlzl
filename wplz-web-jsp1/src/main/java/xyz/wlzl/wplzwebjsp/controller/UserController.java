package xyz.wlzl.wplzwebjsp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.wlzl.wplzwebjsp.client.UserClient;
import xyz.wlzl.wplzwebjsp.entity.User;

import javax.servlet.http.HttpSession;

@Controller
public class UserController {


    @Autowired
    private UserClient userClient;

    @RequestMapping({"/","index.html"})
    public String index(){


        return "login";
    }

    @RequestMapping("/user/login")
    public String login(User user, HttpSession session, Model model){
        String pwd = userClient.login(user);
        if (pwd.equals(user.getPassword())){
            session.setAttribute("loginUser",user.getUsername());
            return "add";
        }else {
           model.addAttribute("msg","用户名密码错误");
            return "login";
        }



    }
}
