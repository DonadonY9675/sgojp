package pe.com.unmsm.sgojp.api.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import pe.com.unmsm.sgojp.api.model.service.Opinion;

/**
 *
 * @author Miguel
 */
public interface OpinionDAO extends AbstractDAO<String, Opinion> {
    public List<Opinion>filterUserId(String userId);
}
