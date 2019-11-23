package xyz.wlzl.wplzactiveserver.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.wlzl.wplzactiveserver.entity.ActiveTbl;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveTblDaoTest {
    @Autowired
    private  ActiveTblDao activeTblDao;

    @Test
    public void findAllOrderById() throws Exception {



       List<ActiveTbl> list =activeTblDao.findAll();
        Sort sort = new Sort(Sort.Direction.DESC,"id");
       activeTblDao.findAll(sort);
       return;
    }

}