package xyz.wlzl.wplzactiveserver.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ToHtml {


    public String toImg(String htmlStr){
        List<String> pics = new ArrayList<String>();
        String img = "";
        Pattern p_image;
        Matcher m_image;
        //     String regEx_img = "<img.*src=(.*?)[^>]*?>"; //图片链接地址
        String regEx_img = "<img.*src\\s*=\\s*(.*?)[^>]*?>";
        p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
        m_image = p_image.matcher(htmlStr);
        while (m_image.find()) {
            // 得到<img />数据
            img = m_image.group();
            // 匹配<img>中的src数据
            Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
            while (m.find()) {
                pics.add(m.group(1));
            }
        }
        if(pics.size()==0){
            return htmlStr;
        }
        return pics.get(0);
    }
    public String toSpan(String htmlStr){
        String regEx_span = "<span[^>]*>([\\s\\S]*?)</span>";
        Pattern p_span;
        Matcher m_span;
        String span;
        List<String> list =new ArrayList<String>();
        p_span=Pattern.compile(regEx_span,Pattern.CASE_INSENSITIVE);
        m_span=p_span.matcher(htmlStr);
        while (m_span.find()){
            span=m_span.group();
            Matcher m1=Pattern.compile(regEx_span).matcher(span);
            while (m1.find()){
                list.add(m1.group(1));
            }

        }
        if(list.size()==0){
            return htmlStr;
        }
        return list.get(0);

    }

}
