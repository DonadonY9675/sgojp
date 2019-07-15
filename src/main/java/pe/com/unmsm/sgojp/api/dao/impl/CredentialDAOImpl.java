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
import pe.com.unmsm.sgojp.api.dao.CredentialDAO;
import static pe.com.unmsm.sgojp.api.dao.Connection.getConnection;
import pe.com.unmsm.sgojp.api.model.Credential;

/**
 *
 * @author Miguel
 */
public class CredentialDAOImpl implements CredentialDAO {

    private final String TABLE_NAME = "credentials";
    private final MongoDatabase DATABASE = getConnection();

    @Override
    public boolean register(Credential e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Credential e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Credential get(String id) {
        Credential credential = null;
        MongoCollection<Credential> collection = DATABASE.getCollection(TABLE_NAME, Credential.class);

        MongoCursor<Credential> cursor = collection.find(new BasicDBObject("_id", id)).iterator();
        try {
            while (cursor.hasNext()) {
                credential = cursor.next();
            }
        } finally {
            cursor.close();
        }
        return credential;
    }

    @Override
    public List<Credential> getAll() {

        MongoCollection<Credential> collection = DATABASE.getCollection(TABLE_NAME, Credential.class);
        MongoCursor<Credential> cursor = collection.find().iterator();
        List<Credential> lista = new ArrayList<>();
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
        CredentialDAOImpl a = new CredentialDAOImpl();
        System.out.println(a.get("BB02"));
    }
}
