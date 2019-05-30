/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.service.impl;

import java.util.List;
import pe.com.unmsm.sgojp.api.dao.UserDAO;
import pe.com.unmsm.sgojp.api.dao.impl.UserDAOImpl;
import pe.com.unmsm.sgojp.api.model.User;
import pe.com.unmsm.sgojp.api.service.UserService;

/**
 *
 * @author Miguel
 */
public class UserServiceImpl implements UserService {

    private UserDAO u = new UserDAOImpl();

    @Override
    public User get(String id) {
        return u.get(id);
    }

    @Override
    public List<User> getAll() {
        return u.getAll();
    }

}
