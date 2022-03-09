package com.example.mainwebappspringboot.dao;

import com.example.mainwebappspringboot.entity.Users;

import java.util.List;

public interface UserDAO {

    public List<Users> getAllUsers();

    public void saveUser(Users user);

    public Users getUser(int id);

    public void deleteUser(int id);
}
