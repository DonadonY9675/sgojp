/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.service;

import java.util.List;
import pe.com.unmsm.sgojp.api.model.Place;

/**
 *
 * @author Miguel
 */
public interface PlaceService {
    public Place get(String id);
    public List<Place> getAll();
    public Place getFilterByCode(String code);
}
