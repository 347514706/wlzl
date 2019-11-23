package xyz.wlzl.wplzwebjsp.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import xyz.wlzl.wplzwebjsp.entity.ActiveTbl;

import java.util.List;

@FeignClient(value = "wplz-active-server3")
public interface ActiveClient {

    @RequestMapping("/activeAdd")
    void activeAdd(ActiveTbl activeTbl);

    @RequestMapping("/activeList")
    List<ActiveTbl> activeList();

    @RequestMapping("/activeDel")
    void activeDel(ActiveTbl activeTbl);

    @RequestMapping("/activeFindOne")
    ActiveTbl activeFindOne(@RequestParam(value = "id") Integer id);
}
