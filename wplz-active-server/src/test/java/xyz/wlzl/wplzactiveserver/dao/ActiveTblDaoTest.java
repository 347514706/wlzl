package xyz.wlzl.wplzactiveserver.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import xyz.wlzl.wplzactiveserver.entity.Active;
import xyz.wlzl.wplzactiveserver.entity.ActiveTbl;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ActiveTblDaoTest {
    @Test
    public void findList() throws Exception {

        List<Map<String, Object>> list = activeTblDao.findList(0, 1);
        for (Map map:list
             ) {
            Object active_desc = map.get("active_Desc");
            System.out.println(active_desc.toString());

        }
    }


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