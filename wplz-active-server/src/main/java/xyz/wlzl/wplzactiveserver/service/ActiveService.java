package xyz.wlzl.wplzactiveserver.service;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import xyz.wlzl.wplzactiveserver.entity.Active;
import xyz.wlzl.wplzactiveserver.entity.ActiveTbl;


import java.util.List;

public interface ActiveService {

     void save(ActiveTbl activeTbl);

     Page<ActiveTbl> findAll();

     void activeDel(ActiveTbl activeTbl);

     ActiveTbl activeFindOne(Integer id);

     List<Active> findActives();

     Active findOne(Integer id);
}
