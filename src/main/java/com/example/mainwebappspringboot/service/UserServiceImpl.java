package com.example.mainwebappspringboot.service;

import com.example.mainwebappspringboot.dao.UserDAO;
import com.example.mainwebappspringboot.entity.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDAO userDAO;

    @Override
    @Transactional
    public List<Users> getAllUsers() {

    return userDAO.getAllUsers();
    }

    @Override
    @Transactional
    public void saveUser(Users user) {
        userDAO.saveUser(user);
    }

    @Override
    @Transactional
    public Users getUser(int id) {

        return userDAO.getUser(id);
    }

    @Override
    @Transactional
    public void deleteUser(int id) {
        userDAO.deleteUser(id);
    }
}
