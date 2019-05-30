/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.service.impl;

import java.util.List;
import pe.com.unmsm.sgojp.api.dao.SportDAO;
import pe.com.unmsm.sgojp.api.dao.impl.SportDAOImpl;
import pe.com.unmsm.sgojp.api.model.sport.Sport;
import pe.com.unmsm.sgojp.api.service.SportService;

/**
 *
 * @author Miguel
 */
public class SportServiceImpl implements SportService{

    private SportDAO sportDao = new SportDAOImpl();

    @Override
    public Sport get(String id) {
        return sportDao.get(id);
    }

    @Override
    public List<Sport> getAll() {
        return sportDao.getAll();
    }

}
