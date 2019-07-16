/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;
import pe.com.unmsm.sgojp.api.dao.PlaceDAO;
import pe.com.unmsm.sgojp.api.dao.QuestionDAO;
import pe.com.unmsm.sgojp.api.dao.SportDAO;
import pe.com.unmsm.sgojp.api.dao.UserDAO;
import pe.com.unmsm.sgojp.api.dao.impl.FactoryDAO;
import pe.com.unmsm.sgojp.api.model.Place;
import pe.com.unmsm.sgojp.api.model.User;
import pe.com.unmsm.sgojp.api.model.querys.BetterQualifiedComment;
import pe.com.unmsm.sgojp.api.model.querys.BetterQualifiedServices;
import pe.com.unmsm.sgojp.api.model.querys.MostRatedGames;
import pe.com.unmsm.sgojp.api.model.querys.SportsMoreDefendants;
import pe.com.unmsm.sgojp.api.model.service.Question;
import pe.com.unmsm.sgojp.api.model.sport.Event;
import pe.com.unmsm.sgojp.api.model.sport.Sport;
import pe.com.unmsm.sgojp.api.service.PlaceService;
import pe.com.unmsm.sgojp.api.service.QuerysService;

/**
 *
 * @author
 */
public class QuerysServiceImpl implements QuerysService {
    
    private final SportDAO sportDao = FactoryDAO.getSportDAO();
    private final QuestionDAO questionDao = FactoryDAO.getQuestionDAO();
    private final PlaceDAO placeService = FactoryDAO.getPlaceDAO();
    private final UserDAO userDao = FactoryDAO.getUserDAO();
    
    @Override
    public List<MostRatedGames> getMostRatedGames() {
        List<Sport> lsSport = sportDao.getAll();
        List<MostRatedGames> lsMostRatedGames = new ArrayList<>();
        lsSport.stream().forEach((sport) -> {
            sport.getEvents().stream().forEach((event) -> {
                lsMostRatedGames.add(MostRatedGames.builder()
                        .sport(sport.getName())
                        .event(event.getName())
                        .rating(event.getRating().entrySet().stream()
                                .mapToDouble(entry -> entry.getValue())
                                .average()
                                .orElse(Double.NaN))
                        .build());
            });
        });
        
        return lsMostRatedGames.stream()
                .sorted((e2, e1) -> e1.getRating().compareTo(e2.getRating()))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<BetterQualifiedServices> getBetterQualifiedServices() {
        List<Place> lsPlace = placeService.getAll();
        List<Question> lsQuestion = questionDao.getAll();
        List<Sport> lsSport = sportDao.getAll();
        List<User> lsUser = userDao.getAll();
        
        List<BetterQualifiedServices> lsBetterQualifiedServices = new ArrayList<>();
        System.out.println("INGRESO");
        lsQuestion.stream().forEach(q -> {
            q.getPlace().stream().forEach(p -> {
                lsBetterQualifiedServices.add(BetterQualifiedServices.builder()
                        .name(q.getName())
                        .question(q.getQuestion())
                        .place(lsPlace.stream().filter(e -> e.getId().equals(p)).findAny().orElse(null).getName())
                        .averageRating(q.getRatings().entrySet().stream()
                                .filter(entry -> {
                                    String sport_id = lsUser.stream()
                                            .filter(e -> e.getId().equals(entry.getKey()))
                                            .findAny()
                                            .get()
                                            .getSport_id();
                                    
                                    return lsSport.stream()
                                            .filter(e -> e.getId().equals(sport_id))
                                            .findAny()
                                            .get()
                                            .getPlace()
                                            .equals(p);
                                })
                                .mapToDouble(entry -> entry.getValue())
                                .average()
                                .orElse(Double.NaN)
                        ).build());
                System.out.println("Agregando");
            });
        });
        
        return lsBetterQualifiedServices.stream()
                .filter(e -> !e.getAverageRating().equals(Double.NaN))
                .sorted((e1, e2) -> e2.getAverageRating().compareTo(e1.getAverageRating()))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<BetterQualifiedComment> getBetterQualifiedComment() {
        System.out.println("INGRESO");
        List<Sport> lsSport = sportDao.getAll();
        List<BetterQualifiedComment> lsMostRatedGames = new ArrayList<>();
        lsSport.stream().forEach((sport) -> {
            sport.getEvents().stream().forEach((event) -> {
                event.getComments().stream().forEach(comments -> {
                    System.out.println("ITERANDO");
                    lsMostRatedGames.add(BetterQualifiedComment.builder()
                            .sport(sport.getName())
                            .event(event.getName())
                            .comment(comments.getComment())
                            .likes(comments.getLikes().entrySet().stream()
                                    .filter(e -> e.getValue()).count())
                            .dislikes(comments.getLikes().entrySet().stream()
                                    .filter(e -> !e.getValue()).count())
                            .build());
                });
                
            });
        });
        
        return lsMostRatedGames.stream()
                .sorted((e2, e1) -> e1.getLikes().compareTo(e2.getLikes()))
                .collect(Collectors.toList());
    }
    
    @Override
    public List<SportsMoreDefendants> getSportsMoreDefendants() {
        List<SportsMoreDefendants> ls = new ArrayList<>();
        List<User> lsUser = userDao.getAll();
        List<Sport> lsSport = sportDao.getAll();
        
        lsSport.stream()
                .forEach(e -> {
                    ls.add(SportsMoreDefendants.builder()
                            .sport(e.getName())
                            .quantity(lsUser.stream()
                                    .filter(s -> s.getSport_id().equals(e.getId()))
                                    .count())
                            .build());
                });
        
        List<SportsMoreDefendants> aux = ls.stream()
                .sorted((d1, d2) -> d2.getQuantity().compareTo(d1.getQuantity()))
                .collect(Collectors.toList());
        List<SportsMoreDefendants> retornar = new ArrayList<>();
        long cant = 0;
        for (int i = 0; i < ls.size(); i++) {
            if (i < 5) {
                retornar.add(aux.get(i));
            }
            cant += aux.get(i).getQuantity();
        }
        retornar.add(SportsMoreDefendants.builder()
                .sport("Otros")
                .quantity(cant).build());
        return retornar;
    }
    
}
