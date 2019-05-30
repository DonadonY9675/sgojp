/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.unmsm.sgojp.api.dao;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoClientURI;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import java.util.ArrayList;
import java.util.List;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import pe.com.unmsm.sgojp.api.model.User;

/**
 *
 * @author Alisson
 */
public class Connection {

    //constantes de conexion
    private static final String USER = "admin";
    private static final String PASSWORD = "admin";
    private static final String HOST = "mongodb01-fgunf.mongodb.net";
    private static final String BD_NAME = "BD_SGOJP";

    private static MongoDatabase database = null;
    private static MongoClient mongoClient;
    private static MongoClientURI uri;

    public static MongoDatabase getConnection() {
        if (database == null) {
            initialize();
        }
        return database;
    }

    private static void initialize() {
        try {
            uri = new MongoClientURI(
                    "mongodb+srv://" + USER + ":" + PASSWORD + "@" + HOST + "/test?retryWrites=true");

            mongoClient = new MongoClient(uri);

            CodecRegistry pojoCodecRegistry = fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder().automatic(true).build()));

            database = mongoClient.getDatabase(BD_NAME).withCodecRegistry(pojoCodecRegistry);
        } catch (Exception e) {
            throw new RuntimeException("Error: " + e);
        }
    }

    private static void close() {
        uri = null;
        database = null;
        mongoClient.close();
        mongoClient = null;
    }

    public static void main(String[] args) {
        database = getConnection();
        
        MongoCollection<User> collection = database.getCollection("user", User.class);
        MongoCursor<User> cursor = collection.find().iterator();
        List<User> lista = new ArrayList<>();
        try {
            while (cursor.hasNext()) {
                lista.add(cursor.next());
            }
        } finally {
            cursor.close();
        }
        System.out.println(lista);
//        System.out.println("TOTAL= " + database.listCollectionNames().first());
        System.out.println("TERMINADO");
    }
}
