/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import pe.com.unmsm.sgojp.api.dao.SportDAO;
import pe.com.unmsm.sgojp.api.dao.UserDAO;
import pe.com.unmsm.sgojp.api.dao.impl.FactoryDAO;
import pe.com.unmsm.sgojp.api.model.User;
import pe.com.unmsm.sgojp.api.model.sport.Sport;
import pe.com.unmsm.sgojp.api.service.SportService;

/**
 *
 * @author Miguel
 */
public class SportServiceImpl implements SportService {

    private SportDAO sportDao = FactoryDAO.getSportDAO();
    private UserDAO usersDao = FactoryDAO.getUserDAO();

    @Override
    public Sport get(String id) {
        return sportDao.get(id);
    }

    @Override
    public List<Sport> getAll() {
        return sportDao.getAll();
    }

    @Override
    public boolean update(Sport sport) {
        return sportDao.update(sport);
    }
    
    @Override
    public List<Sport> getSportFilterCode(String code) {
        User user = usersDao.get(code);
        List<Sport> lsSport = sportDao.getAll();
        if (user != null) {
            String sportId = user.getSport_id();
            List<Sport> aux = lsSport.stream()
                    .filter((s)
                            -> s.getId().equals(user.getSport_id())
                    ).collect(Collectors.toList());
            if(aux.isEmpty()){
                return lsSport;
            }
            return aux;
        } else {
            return null;
        }
    }

    

}
