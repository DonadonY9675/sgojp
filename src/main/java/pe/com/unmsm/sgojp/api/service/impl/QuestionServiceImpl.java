/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.service.impl;

import java.util.List;
import pe.com.unmsm.sgojp.api.dao.QuestionDAO;
import pe.com.unmsm.sgojp.api.dao.impl.QuestionDAOImpl;
import pe.com.unmsm.sgojp.api.model.service.Question;
import pe.com.unmsm.sgojp.api.service.QuestionService;

/**
 *
 * @author Miguel
 */
public class QuestionServiceImpl implements QuestionService {

    private QuestionDAO u = new QuestionDAOImpl();

    @Override
    public Question get(String id) {
        return u.get(id);
    }

    @Override
    public List<Question> getAll() {
        return u.getAll();
    }

}
