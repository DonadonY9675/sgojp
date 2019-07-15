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
import pe.com.unmsm.sgojp.api.dao.SportDAO;
import pe.com.unmsm.sgojp.api.dao.UserDAO;
import pe.com.unmsm.sgojp.api.dao.impl.FactoryDAO;
import pe.com.unmsm.sgojp.api.model.querys.MostRatedGames;
import pe.com.unmsm.sgojp.api.model.sport.Event;
import pe.com.unmsm.sgojp.api.model.sport.Sport;
import pe.com.unmsm.sgojp.api.service.QuerysService;

/**
 *
 * @author 
 */
public class QuerysServiceImpl implements QuerysService {

    private final SportDAO sportDao = FactoryDAO.getSportDAO();

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
                .sorted((e2,e1)-> e1.getRating().compareTo(e2.getRating()))
                .collect(Collectors.toList());
    }

}



