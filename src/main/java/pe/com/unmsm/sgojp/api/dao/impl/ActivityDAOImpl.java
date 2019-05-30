package pe.com.unmsm.sgojp.api.dao.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;
import pe.com.unmsm.sgojp.api.dao.ActivityDAO;
import pe.com.unmsm.sgojp.api.model.Activity;

/**
 *
 * @author Miguel
 */
public class ActivityDAOImpl implements ActivityDAO {

    @Override
    public boolean register(Activity e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Activity e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Activity get(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Activity> getAll() {
        Activity act1 = new Activity();
        act1.setId(1);
        act1.setName("Futbol");
        
        Activity act2 = new Activity();
        act2.setId(2);
        act2.setName("Natacion");
        
        Activity act3 = new Activity();
        act2.setId(3);
        act2.setName("Voley");
        
        Activity act4 = new Activity();
        act2.setId(4);
        act2.setName("Salto largo");
        
        Activity act5 = new Activity();
        act2.setId(5);
        act2.setName("Dormir");
        
        List<Activity> lsActivity = new ArrayList<>();
        lsActivity.add(act1);
        lsActivity.add(act2);
        lsActivity.add(act3);
        lsActivity.add(act4);
        lsActivity.add(act5);
        return lsActivity;
    }

    @Override
    public boolean remove(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
