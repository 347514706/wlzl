package xyz.wlzl.wplzactiveserver.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import xyz.wlzl.wplzactiveserver.dao.ActiveTblDao;
import xyz.wlzl.wplzactiveserver.entity.Active;
import xyz.wlzl.wplzactiveserver.entity.ActiveTbl;
import xyz.wlzl.wplzactiveserver.entity.Title;
import xyz.wlzl.wplzactiveserver.service.ActiveService;
import xyz.wlzl.wplzactiveserver.utils.ToHtml;

import java.util.*;

@Service
public class ActiveServiceImpl implements ActiveService{
    @Autowired
    private ActiveTblDao activeTblDao;


    @Override
    public void save(ActiveTbl activeTbl) {
        activeTbl.setCreateTime(new Date());

        activeTbl.setTrueViews(0);
        activeTbl.setUserId(1);
        activeTblDao.save(activeTbl);



    }

    @Override
    public Page<ActiveTbl> findAll() {

        Pageable pageable = PageRequest.of(0, 100, Sort.Direction.DESC, "createTime");

        Page<ActiveTbl> page = activeTblDao.findAll(pageable);
        return page;
    }

    @Override
    public void activeDel(ActiveTbl activeTbl) {
        activeTblDao.delete(activeTbl);
    }

    @Override
    public ActiveTbl activeFindOne(Integer id) {
        ActiveTbl activeTbl = activeTblDao.findById(id).get();
        return activeTbl;
    }

    @Override
    public List<Active> findActives() {
        List<Active> list =new ArrayList<>();
        Sort sort = new Sort(Sort.Direction.DESC, "createTime");

        List<ActiveTbl> actives = activeTblDao.findAll(sort);

        for (ActiveTbl activeTbl:actives
             ) {


            if (activeTbl.getIssue()==1){
            Active active=new Active();
             active.setTitle(activeTbl.getTitle());
             active.setIsVip(activeTbl.getIsVip());
             active.setId(activeTbl.getId());
             active.setFalseViews(activeTbl.getFalseViews());
             active.setCreateTime(activeTbl.getCreateTime());
             active.setActiveDesc(activeTbl.getActiveDesc());
             list.add(active);}

        }
        return list;
    }

    @Override
    public Active findOne(Integer id) {
        Optional<ActiveTbl> byId = activeTblDao.findById(id);
        ActiveTbl activeTbl = byId.get();
        activeTbl.setTrueViews(activeTbl.getTrueViews()+1);
        activeTbl.setFalseViews(activeTbl.getFalseViews()+1);
        activeTblDao.save(activeTbl);
        Active active = new Active();
        active.setActiveDesc(activeTbl.getActiveDesc());
        active.setCreateTime(activeTbl.getCreateTime());
        active.setFalseViews(activeTbl.getFalseViews());
        active.setId(activeTbl.getId());
        active.setIsVip(activeTbl.getIsVip());
        active.setTitle(activeTbl.getTitle());
        return active;
    }

    @Override
    public void update(ActiveTbl activeTbl) {
        activeTblDao.save(activeTbl);
    }

    @Override
    public List<Title> findList(Integer isVip) {
        List<Map<String, Object>> maps = activeTblDao.findList(isVip, 1);
        List<Title> list = new ArrayList<Title>();
        if(maps==null){
            return null;
        }else {
            for (Map map : maps) {
                Title title = new Title();
                title.setCreateTime((Date) map.get("create_time"));
                title.setFalseViews((int) map.get("false_views"));
                title.setId((int) map.get("id"));
                ToHtml toHtml = new ToHtml();
                String src = toHtml.toImg(map.get("active_desc").toString());
                title.setImg(src);
                String span = toHtml.toSpan(map.get("active_desc").toString());
                title.setTitleDesc(span);
                title.setTitle(map.get("title").toString());
                list.add(title);
            }


            return list;
        }
    }
}
