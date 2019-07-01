/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.service;

import java.util.List;
import pe.com.unmsm.sgojp.api.model.service.Question;

/**
 *
 * @author Miguel
 */
public interface QuestionService extends AbstractService<String, Question> {

    public List<Question> getQuestionFilterCode(String code);

    public Boolean getQuestionRegisterRating(String code, String idQuestion, Integer rating);
}
