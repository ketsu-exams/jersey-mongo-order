package com.thoughtworks.ketsu.infrastructure.records;

import com.google.inject.AbstractModule;
import com.mongodb.DB;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import org.jongo.Jongo;

import java.net.UnknownHostException;

public class MongoModels extends AbstractModule {
  @Override
  protected void configure() {
    String dbname = System.getenv().getOrDefault("MONGODB_DATABASE", "mongodb_store");
    String host = System.getenv().getOrDefault("MONGODB_HOST", "localhost");
    String user = System.getenv().getOrDefault("MONGODB_USER", "admin");
    String password = System.getenv().getOrDefault("MONGODB_PASS", "mypass");

    String connectURL = String.format(
      "mongodb://%s:%s@%s/%s",
      user,
      password,
      host,
      dbname
    );


    DB db = null;
    try {
      db = new MongoClient(new MongoClientURI(connectURL)).getDB("mongodb_store");
    } catch (UnknownHostException e) {
      e.printStackTrace();
    }

    Jongo jongo = new Jongo(db);

    bind(Jongo.class).toInstance(jongo);
  }
}
