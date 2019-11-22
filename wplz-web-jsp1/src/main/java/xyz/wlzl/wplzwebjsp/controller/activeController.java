package xyz.wlzl.wplzwebjsp.controller;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import xyz.wlzl.wplzwebjsp.client.ActiveClient;
import xyz.wlzl.wplzwebjsp.entity.ActiveTbl;
import xyz.wlzl.wplzwebjsp.entity.Message;

import java.util.List;
import java.util.Map;

@Controller
public class activeController {

    @Autowired
    ActiveClient activeClient;
    @ResponseBody
    @RequestMapping("/addActive")
    public Message activeAdd(ActiveTbl activeTbl, Model model) throws Exception{
        System.out.println(activeTbl.toString());
        Message message = new Message();
        try {
            activeClient.activeAdd(activeTbl);
            /*model.addAttribute("msg","提交成功");*/

            message.setMsg("成功");
            return message;
        }catch(Exception e){
           /* model.addAttribute("msg","提交失败");*/

            message.setMsg("失败");
            return message;
        }
    }
    @ResponseBody
    @RequestMapping("/activeList")
    public List<ActiveTbl> activeTblList(){
        List<ActiveTbl> activeTbls = activeClient.activeList();

        return activeTbls;

    }
    @ResponseBody
    @RequestMapping("/activeDel")
    public void activeDel(ActiveTbl activeTbl){
        activeClient.activeDel(activeTbl);

    }

}
