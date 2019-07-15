package pe.com.unmsm.sgojp.api.dao.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mongodb.BasicDBObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import pe.com.unmsm.sgojp.api.dao.PlaceDAO;
import static pe.com.unmsm.sgojp.api.dao.Connection.getConnection;
import pe.com.unmsm.sgojp.api.model.Place;

/**
 *
 * @author Miguel
 */
public class PlaceDAOImpl implements PlaceDAO {

    private final String TABLE_NAME = "place";
    private final MongoDatabase DATABASE = getConnection();

    @Override
    public boolean register(Place e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Place e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Place get(String id) {
        Place user = null;
        MongoCollection<Place> collection = DATABASE.getCollection(TABLE_NAME, Place.class);

        MongoCursor<Place> cursor = collection.find(new BasicDBObject("_id", id)).iterator();
        try {
            while (cursor.hasNext()) {
                user = cursor.next();
            }
        } finally {
            cursor.close();
        }
        return user;
    }

    @Override
    public List<Place> getAll() {

        MongoCollection<Place> collection = DATABASE.getCollection(TABLE_NAME, Place.class);
        MongoCursor<Place> cursor = collection.find().iterator();
        List<Place> lista = new ArrayList<>();
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

    public static void main(String[] args) {
        PlaceDAOImpl a = new PlaceDAOImpl();
        System.out.println(a.get("BB02"));
    }
}
