package xyz.wlzl.wplzactiveserver.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import xyz.wlzl.wplzactiveserver.dao.ActiveTblDao;
import xyz.wlzl.wplzactiveserver.entity.ActiveTbl;
import xyz.wlzl.wplzactiveserver.service.ActiveService;

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

        activeTbl.setTrueViews("1");
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
}
