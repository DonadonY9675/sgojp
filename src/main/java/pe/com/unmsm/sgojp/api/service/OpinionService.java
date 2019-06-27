/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.service;

import java.util.List;
import pe.com.unmsm.sgojp.api.model.service.Opinion;

/**
 *
 * @author Miguel
 */
public interface OpinionService {

    public boolean register(Opinion e);

    public Opinion get(String id);

    public List<Opinion> getAll();

    public boolean update(Opinion e);

    public boolean remove(String id);
}
