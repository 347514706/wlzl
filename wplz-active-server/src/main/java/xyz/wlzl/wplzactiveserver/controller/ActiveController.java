package xyz.wlzl.wplzactiveserver.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.wlzl.wplzactiveserver.entity.ActiveTbl;
import xyz.wlzl.wplzactiveserver.service.ActiveService;
import xyz.wlzl.wplzactiveserver.service.impl.ActiveServiceImpl;

import java.util.List;

@RestController
public class ActiveController {
    @Autowired
    private ActiveServiceImpl activeService;
    @RequestMapping("/activeAdd")
    public void activeAdd(@RequestBody ActiveTbl activeTbl){

        activeService.save(activeTbl);
    }

    @RequestMapping("/activeList")
    public List<ActiveTbl> activeTblPage(){

        Page<ActiveTbl> activeTblPage = activeService.findAll();

        List<ActiveTbl> list =activeTblPage.getContent();

        return list;
    }

    @RequestMapping("/activeDel")
    public void activeDel(@RequestBody ActiveTbl activeTbl){

        activeService.activeDel(activeTbl);
    }
    @RequestMapping("/activeFindOne")
    public ActiveTbl activeFindOne(@RequestParam(value = "id") Integer id){
        ActiveTbl activeTbl = activeService.activeFindOne(id);
        return activeTbl;
    }
}
