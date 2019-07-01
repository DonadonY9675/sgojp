/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.service;

import java.util.List;
import pe.com.unmsm.sgojp.api.model.sport.Sport;

/**
 *
 * @author Miguel
 */
public interface SportService {

    public Sport get(String id);
    
    public boolean update(Sport sport);

    public List<Sport> getAll();

    public List<Sport> getSportFilterCode(String code);

}
