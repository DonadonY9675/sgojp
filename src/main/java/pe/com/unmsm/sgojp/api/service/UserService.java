/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.service;

import java.util.List;
import pe.com.unmsm.sgojp.api.model.User;

/**
 *
 * @author Miguel
 */
public interface UserService {
    public User get(String id);
    public List<User> getAll();

}
