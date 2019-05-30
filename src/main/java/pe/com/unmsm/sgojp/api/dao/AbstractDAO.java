package pe.com.unmsm.sgojp.api.dao;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;

/**
 *
 * @author Miguel
 */
public interface AbstractDAO<K, V> {
    
    boolean register(V e);

    boolean update(V e);

    V get(K id);

    List<V> getAll();

    boolean remove(K id);

}
