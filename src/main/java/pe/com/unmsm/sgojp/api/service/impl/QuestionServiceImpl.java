/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.service.impl;

import java.util.List;
import pe.com.unmsm.sgojp.api.dao.QuestionDAO;
import pe.com.unmsm.sgojp.api.dao.impl.FactoryDAO;
import pe.com.unmsm.sgojp.api.dao.impl.QuestionDAOImpl;
import pe.com.unmsm.sgojp.api.model.service.Question;
import pe.com.unmsm.sgojp.api.service.QuestionService;

/**
 *
 * @author Miguel
 */
public class QuestionServiceImpl implements QuestionService {

    private QuestionDAO u = FactoryDAO.getQuestionDAO();

    @Override
    public boolean register(Question e) {
        return u.register(e);
    }

    @Override
    public boolean update(Question e) {
        return u.update(e);
    }

    @Override
    public boolean remove(String id) {
        return u.remove(id);
    }

    @Override
    public Question get(String id) {
        Question aux = u.get(id);
        aux.setId(id);
        return aux;
    }

    @Override
    public List<Question> getAll() {
        List<Question> aux = u.getAll();
        aux.forEach(e->e.setValue(-1));
        System.out.println("RETORNANDO:" + u.getAll());
        return aux;
    }

    @Override
    public List<Question> getQuestionFilterCode(String code) {
        List<Question> lsQuestions = u.getAll();
        System.out.println("getQuestionFilterCode= " + code);
        lsQuestions.forEach(q -> {
            q.setValue((q.getRatings().get(code)!=null)?q.getRatings().get(code):-1);
        });             
        lsQuestions.forEach(q -> q.setRatings(null));
        return lsQuestions;
    }

    @Override
    public Boolean getQuestionRegisterRating(String code, String idQuestion, Integer rating) {
        try {
            System.out.println("idQuestion="+idQuestion + ", CODE = "+code+" ,rating="+rating);
            Question q = u.get(idQuestion);
            System.out.println("Q = " + q);
            q.getRatings().put(code, rating);
            return u.update(q);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }

}
