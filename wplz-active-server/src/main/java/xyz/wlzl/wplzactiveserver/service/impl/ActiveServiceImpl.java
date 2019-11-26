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
import xyz.wlzl.wplzactiveserver.service.ActiveService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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
}
