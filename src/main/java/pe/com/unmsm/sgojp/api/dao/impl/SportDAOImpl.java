/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.dao.impl;

import com.mongodb.BasicDBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import static pe.com.unmsm.sgojp.api.dao.Connection.getConnection;
import pe.com.unmsm.sgojp.api.dao.SportDAO;
import pe.com.unmsm.sgojp.api.model.sport.Sport;
import pe.com.unmsm.sgojp.api.model.User;

/**
 *
 * @author Miguel
 */
public class SportDAOImpl implements SportDAO {

    private final String TABLE_NAME = "sports";
    private final MongoDatabase DATABASE = getConnection();

    @Override
    public boolean register(Sport e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Sport e) {
        MongoCollection<Sport> collection = DATABASE.getCollection(TABLE_NAME, Sport.class);
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.append("$set", e);
        BasicDBObject filter = new BasicDBObject("_id", e.getId());
        return collection.updateMany(filter, newDocument).getModifiedCount()>0;
    }

    @Override
    public Sport get(String id) {
        Sport sport = null;
        MongoCollection<Sport> collection = DATABASE.getCollection(TABLE_NAME, Sport.class);

        MongoCursor<Sport> cursor = collection.find(new BasicDBObject("_id", id)).iterator();
        try {
            while (cursor.hasNext()) {
                sport = cursor.next();
            }
        } finally {
            cursor.close();
        }
        return sport;
    }

    @Override
    public List<Sport> getAll() {
        MongoCollection<Sport> collection = DATABASE.getCollection(TABLE_NAME, Sport.class);
        MongoCursor<Sport> cursor = collection.find().iterator();
        List<Sport> lista = new ArrayList<>();
        try {
            while (cursor.hasNext()) {
                lista.add(cursor.next());
            }
        } finally {
            cursor.close();
        }
        return lista;
    }

    @Override
    public boolean remove(String id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
