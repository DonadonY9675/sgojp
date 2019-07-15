/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.dao.impl;

import pe.com.unmsm.sgojp.api.dao.*;

/**
 *
 * @author Miguel
 */
public class FactoryDAO {
    
    public static UserDAO getUserDAO(){
        return new UserDAOImpl();
    }
    public static SportDAO getSportDAO(){
        return new SportDAOImpl();
    }
    public static QuestionDAO getQuestionDAO(){
        return new QuestionDAOImpl();
    }
    public static PlaceDAO getPlaceDAO(){
        return new PlaceDAOImpl();
    }
    public static OpinionDAO getOpinionDAO(){
        return new OpinionDAOImpl();
    }
    public static ActivityDAO getAcitvityDAO(){
        return new ActivityDAOImpl();
    }
}
