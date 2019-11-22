package xyz.wlzl.wplzwebjsp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.wlzl.wplzwebjsp.entity.User;

import java.util.List;

@FeignClient(value = "wplz-user-server")
public interface UserClient {

    @RequestMapping("/login")
    public String login(User user);
    @RequestMapping("/userAdd")
    public void userAdd(User user );
    @RequestMapping("/userUpdate")
    public void userUpdate(User user);
    @RequestMapping("/userFindAll")
    public List<User> userFindAll();
}
