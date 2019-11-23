package xyz.wlzl.wplzuserserver.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.wlzl.wplzuserserver.entity.User;

public interface UserDao extends JpaRepository<User,Integer> {

}
