package xyz.wlzl.wplzuserserver.service;

import net.bytebuddy.implementation.bytecode.assign.TypeCasting;
import xyz.wlzl.wplzuserserver.entity.User;

import java.util.List;

public interface UserService {

    void userAdd(User usre);

    String findByUsernama(String  username);

    void userUpdate(User user);

    List<User> findAll();
}
