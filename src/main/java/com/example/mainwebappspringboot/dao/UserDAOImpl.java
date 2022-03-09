package com.example.mainwebappspringboot.dao;

import com.example.mainwebappspringboot.entity.Users;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Users> getAllUsers() {

        Session session = entityManager.unwrap(Session.class);
        Query<Users> query = session.createQuery("from Users", Users.class);

        return query.getResultList();
    }

    @Override
    public void saveUser(Users user) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(user);
    }

    @Override
    public Users getUser(int id) {
        Session session = entityManager.unwrap(Session.class);
        Users user = session.get(Users.class, id);

        return user;
    }

    @Override
    public void deleteUser(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query<Users> query = session.createQuery("delete from Users"+"where id =:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
