/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.model.sport;

import java.util.ArrayList;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Miguel
 */
@Data
@NoArgsConstructor
public class Sport {

    private String id;
    private String name;
    private String place;
    private String description;
    private String history;
    private String url_image_1;
    private String url_image_2;
//    private String url_image_3;
    private List<Event> events;

}
