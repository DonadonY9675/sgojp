/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.model.service;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;

/**
 *
 * @author Miguel
 */
@Data
@NoArgsConstructor
public class Opinion {
    private String id;
    private String user_id;
    private String comment;
    private String date;
    private String likes;
    private String dislikes;
}
