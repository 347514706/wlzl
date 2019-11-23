package xyz.wlzl.wplzuserserver.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import xyz.wlzl.wplzuserserver.dao.UserDao;
import xyz.wlzl.wplzuserserver.entity.User;
import xyz.wlzl.wplzuserserver.service.UserService;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void userAdd(User user) {
        userDao.save(user);
    }

    @Override
    public String findByUsernama(String username) {
        User user = new User();
        user.setUsername(username);
        Example<User> example = Example.of(user);
        Optional<User> optUser = userDao.findOne(example);
        if(optUser.isPresent()){
            User user1 = optUser.get();
            return user1.getPassword();
        }else {
            return "无此用户";
        }


    }

    @Override
    public void userUpdate(User user) {
        userDao.saveAndFlush(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }
}
