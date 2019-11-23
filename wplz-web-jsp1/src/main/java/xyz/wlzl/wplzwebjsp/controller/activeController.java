package xyz.wlzl.wplzwebjsp.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import xyz.wlzl.wplzwebjsp.client.ActiveClient;
import xyz.wlzl.wplzwebjsp.entity.ActiveTbl;
import xyz.wlzl.wplzwebjsp.entity.Message;

import java.util.List;
import java.util.Map;

@Controller
public class activeController {

    @Autowired
    ActiveClient activeClient;
  /*  @ResponseBody
    @RequestMapping("/addActive")
    public Message activeAdd(ActiveTbl activeTbl, Model model) throws Exception{
        System.out.println(activeTbl.toString());
        Message message = new Message();
        try {
            activeClient.activeAdd(activeTbl);
            *//*model.addAttribute("msg","提交成功");*//*

            message.setMsg("成功");
            return message;
        }catch(Exception e){
           *//* model.addAttribute("msg","提交失败");*//*

            message.setMsg("失败");
            return message;
        }
    }*/
    /*@ResponseBody
    @RequestMapping("/activeList")
    public List<ActiveTbl> activeTblList(){
        List<ActiveTbl> activeTbls = activeClient.activeList();

        return activeTbls;

    }*/
    //修改
    @PutMapping("/active")
    public String activeAdd(ActiveTbl activeTbl){
        System.out.println(activeTbl.toString());
        activeClient.activeAdd(activeTbl);
        return "redirect:/activeList";

    }
    //添加
    @PostMapping ("/active")
    public String activeUpdate(ActiveTbl activeTbl){
        activeClient.activeAdd(activeTbl);
        return "redirect:/activeList";
    }
    @RequestMapping("/activeUp/{id}")
    public String activeFind(@PathVariable("id") Integer id,Model model){
        System.out.println(id);
        ActiveTbl activeTbl = activeClient.activeFindOne(id);
        model.addAttribute("active",activeTbl);

        return "/add";
    }
    @RequestMapping("/activeList")
    public String activeList(Model model){
        List<ActiveTbl> activeTbls = activeClient.activeList();
        model.addAttribute("activeList",activeTbls);

        return "list";
    }

    @RequestMapping("/active/{id}")
    public String adctiveDel(@PathVariable("id") Integer id){
        ActiveTbl activeTbl = new ActiveTbl();
        activeTbl.setId(id);
        activeClient.activeDel(activeTbl);
        return "redirect:/activeList";
    }


    /*@RequestMapping("/activeDel")
    public String activeDel(ActiveTbl activeTbl){
        activeClient.activeDel(activeTbl);
        return "redirect:/actieList";
    }*/

}
