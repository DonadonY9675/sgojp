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
import pe.com.unmsm.sgojp.api.dao.QuestionDAO;
import static pe.com.unmsm.sgojp.api.dao.Connection.getConnection;
import pe.com.unmsm.sgojp.api.model.service.Question;

/**
 *
 * @author Miguel
 */
public class QuestionDAOImpl implements QuestionDAO {

    private final String TABLE_NAME = "questions";
    private final MongoDatabase DATABASE = getConnection();

    @Override
    public boolean register(Question e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Question e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Question get(String id) {
        Question user = null;
        MongoCollection<Question> collection = DATABASE.getCollection(TABLE_NAME, Question.class);

        MongoCursor<Question> cursor = collection.find(new BasicDBObject("code", id)).iterator();
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
    public List<Question> getAll() {

        MongoCollection<Question> collection = DATABASE.getCollection(TABLE_NAME, Question.class);
        MongoCursor<Question> cursor = collection.find().iterator();
        List<Question> lista = new ArrayList<>();
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
        QuestionDAOImpl a = new QuestionDAOImpl();
        System.out.println(a.getAll());
    }
}
