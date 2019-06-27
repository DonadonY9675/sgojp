package pe.com.unmsm.sgojp.api.dao.impl;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.bson.conversions.Bson;
import org.codehaus.jackson.map.ObjectMapper;
import pe.com.unmsm.sgojp.api.dao.OpinionDAO;
import static pe.com.unmsm.sgojp.api.dao.Connection.getConnection;
import pe.com.unmsm.sgojp.api.model.service.Opinion;

/**
 *
 * @author Miguel
 */
public class OpinionDAOImpl implements OpinionDAO {

    private final String COLLECTION_NAME = "opinions";
    private final MongoDatabase DATABASE = getConnection();

    @Override
    public List<Opinion> filterUserId(String userId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean register(Opinion e) {
        MongoCollection<Opinion> collection = DATABASE.getCollection(COLLECTION_NAME, Opinion.class);
        ObjectMapper oMapper = new ObjectMapper();
        BasicDBObject doc = new BasicDBObject(oMapper.convertValue(e, Map.class));
        collection.insertOne(e);
        return true;
    }

    @Override
    public boolean update(Opinion e) {
        MongoCollection<Opinion> collection = DATABASE.getCollection(COLLECTION_NAME, Opinion.class);
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.append("$set", e);
        BasicDBObject filter = new BasicDBObject("_id", e.getId());
        return collection.updateMany(filter, newDocument).isModifiedCountAvailable();

    }

    @Override
    public Opinion get(String id) {
        System.out.println("llego al dao");
        Opinion user = null;
        MongoCollection<Opinion> collection = DATABASE.getCollection(COLLECTION_NAME, Opinion.class);
        MongoCursor<Opinion> cursor = collection.find(new BasicDBObject("_id", id)).iterator();
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
    public List<Opinion> getAll() {

        MongoCollection<Opinion> collection = DATABASE.getCollection(COLLECTION_NAME, Opinion.class);
        MongoCursor<Opinion> cursor = collection.find().iterator();
        List<Opinion> lista = new ArrayList<>();
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
        MongoCollection<Opinion> collection = DATABASE.getCollection(COLLECTION_NAME, Opinion.class);
        return collection.deleteOne(new BasicDBObject().append("_id", id)).getDeletedCount()!=0;
    }

    public static void main(String[] args) {
        OpinionDAOImpl od = new OpinionDAOImpl();
        Opinion op = new Opinion();
        op.setId("6");
        op.setUser_id("BB01");
        op.setComment("Malo");
        op.setPlace("lima");
        op.setDate(new Date(119, 1, 1));
        Map<String, Boolean> map = new HashMap<>();
        map.put("B666", true);
        op.setLikes(map);
        od.remove("6");
    }

}
