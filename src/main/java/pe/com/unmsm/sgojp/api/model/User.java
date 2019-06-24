/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.model;

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
public class User {

    private String id;
//    private String place;
    private String date;
    private String section;
    private List sport_ids;
}
