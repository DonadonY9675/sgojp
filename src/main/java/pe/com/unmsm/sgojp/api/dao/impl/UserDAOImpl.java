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
import pe.com.unmsm.sgojp.api.dao.UserDAO;
import static pe.com.unmsm.sgojp.api.dao.Connection.getConnection;
import pe.com.unmsm.sgojp.api.model.User;

/**
 *
 * @author Miguel
 */
public class UserDAOImpl implements UserDAO {

    private final String TABLE_NAME = "users";
    private final MongoDatabase DATABASE = getConnection();

    @Override
    public boolean register(User e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(User e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public User get(String id) {
        User user = null;
        MongoCollection<User> collection = DATABASE.getCollection(TABLE_NAME, User.class);

        MongoCursor<User> cursor = collection.find(new BasicDBObject("_id", id)).iterator();
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
    public List<User> getAll() {

        MongoCollection<User> collection = DATABASE.getCollection(TABLE_NAME, User.class);
        MongoCursor<User> cursor = collection.find().iterator();
        List<User> lista = new ArrayList<>();
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
        UserDAOImpl a = new UserDAOImpl();
        System.out.println(a.get("BB02"));
    }
}
