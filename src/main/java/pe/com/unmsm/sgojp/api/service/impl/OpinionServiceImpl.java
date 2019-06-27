/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.service.impl;

import java.util.List;
import pe.com.unmsm.sgojp.api.dao.OpinionDAO;
import pe.com.unmsm.sgojp.api.dao.impl.OpinionDAOImpl;
import pe.com.unmsm.sgojp.api.model.service.Opinion;
import pe.com.unmsm.sgojp.api.service.OpinionService;

/**
 *
 * @author Miguel
 */
public class OpinionServiceImpl implements OpinionService {

    private OpinionDAO u = new OpinionDAOImpl();

    @Override
    public boolean register(Opinion e) {
        return u.register(e);
    }

    @Override
    public Opinion get(String id) {
        return u.get(id);
    }

    @Override
    public List<Opinion> getAll() {
        return u.getAll();
    }

    @Override
    public boolean update(Opinion e) {
        return u.update(e);
    }

    @Override
    public boolean remove(String id) {
        return u.remove(id);
    }

}
