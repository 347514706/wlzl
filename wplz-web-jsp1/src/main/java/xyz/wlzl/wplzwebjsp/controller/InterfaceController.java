package xyz.wlzl.wplzwebjsp.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONAware;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import xyz.wlzl.wplzwebjsp.client.ActiveClient;
import xyz.wlzl.wplzwebjsp.entity.Active;
import xyz.wlzl.wplzwebjsp.entity.Title;

import java.util.List;

@RestController
public class InterfaceController {

    @Autowired
    private ActiveClient activeClient;
    @RequestMapping("/active/findAll")
    public String findAll(@RequestParam("isVip") Integer isVip){
        List<Title> actives = activeClient.activeFindAll(isVip);
        String s = com.alibaba.fastjson.JSONArray.toJSONString(actives);

        return s;
    }

    @RequestMapping("/active/findOne")
    public String findOne(@RequestParam("id") Integer id){
        Active active = activeClient.findOne(id);
        String s1 = com.alibaba.fastjson.JSONObject.toJSONString(active);
        return s1;

    }
}
