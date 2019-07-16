/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.model.querys;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author Miguel
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BetterQualifiedComment {
    private String sport;
    private String event;
    private String comment;
    private Long likes;
    private Long dislikes;
}
