package xyz.wlzl.wplzwebjsp.entity;

import org.springframework.context.annotation.Bean;

import java.io.Serializable;

public class Message implements Serializable{
    private String msg;


    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }


}
