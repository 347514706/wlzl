package xyz.wlzl.wplzactiveserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import xyz.wlzl.wplzactiveserver.entity.Active;
import xyz.wlzl.wplzactiveserver.entity.ActiveTbl;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface ActiveTblDao extends JpaRepository<ActiveTbl,Integer> {

   /* private Integer id;
    private  String title;
    private Date createTime;
    private Integer isVip;
    private String falseViews;
    private String activeDesc;*/

    @Query(value = "select a.id ,a.title,a.create_time,a.is_vip,a.false_views,a.active_desc from active_tbl a where a.issue=1",nativeQuery = true)
     List<ActiveTbl> findActives();
    @Query(value="select a.id ,a.title,a.create_time,a.is_vip,a.false_views,a.active_desc from active_tbl a where a.is_vip=?1 and a.issue=?2 order by id DESC ",nativeQuery = true)
    List<Map<String,Object>> findList(Integer isVip, Integer issue);

    @Query(value = "select a.id ,a.title,a.create_time,a.is_vip,a.false_views,a.active_desc from active_tbl a where a.is_vip=?1 and a.issue=?2 order by id DESC LIMIT ?3,10",nativeQuery = true)
    List<Map<String,Object>> findTwos(Integer isVip,Integer issue,Integer pageNo);
}
