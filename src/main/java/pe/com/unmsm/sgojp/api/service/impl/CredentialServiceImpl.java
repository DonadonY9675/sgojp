/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.service.impl;

import java.util.List;
import pe.com.unmsm.sgojp.api.dao.CredentialDAO;
import pe.com.unmsm.sgojp.api.dao.impl.CredentialDAOImpl;
import pe.com.unmsm.sgojp.api.model.Credential;
import pe.com.unmsm.sgojp.api.service.CredentialService;

/**
 *
 * @author Miguel
 */
public class CredentialServiceImpl implements CredentialService {

    private CredentialDAO u = new CredentialDAOImpl();

    @Override
    public Credential get(String id) {
        return u.get(id);
    }

    @Override
    public List<Credential> getAll() {
        return u.getAll();
    }

    @Override
    public Credential verificar(String user, String password) {
        Credential cred = u.getAll().stream()
                .filter(e->e.getId().equals(user) && e.getPassword().equals(password))
                .findAny().orElse(null);
        return cred;
    }

}
