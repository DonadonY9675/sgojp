/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.model.service;

import java.util.Date;
import java.util.Map;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Miguel
 */
@Data
@NoArgsConstructor
public class Opinion {
    private String id;
    private String user_id;
    private String place;
    private String comment;
    private Date date;
    private Map<String,Boolean> likes;
}
