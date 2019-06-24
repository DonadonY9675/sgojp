/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.service.impl;

import java.util.List;
import pe.com.unmsm.sgojp.api.dao.PlaceDAO;
import pe.com.unmsm.sgojp.api.dao.impl.PlaceDAOImpl;
import pe.com.unmsm.sgojp.api.model.Place;
import pe.com.unmsm.sgojp.api.service.PlaceService;

/**
 *
 * @author Miguel
 */
public class PlaceServiceImpl implements PlaceService {

    private PlaceDAO u = new PlaceDAOImpl();

    @Override
    public Place get(String id) {
        return u.get(id);
    }

    @Override
    public List<Place> getAll() {
        return u.getAll();
    }

}
