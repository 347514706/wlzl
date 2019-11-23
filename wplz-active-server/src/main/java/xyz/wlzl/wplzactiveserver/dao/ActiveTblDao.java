package xyz.wlzl.wplzactiveserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.wlzl.wplzactiveserver.entity.ActiveTbl;

import java.util.List;

public interface ActiveTblDao extends JpaRepository<ActiveTbl,Integer> {


}
