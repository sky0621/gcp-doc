package com.example;

import com.google.cloud.datastore.Datastore;
import com.google.cloud.datastore.DatastoreOptions;
import com.google.cloud.datastore.Entity;
import com.google.cloud.datastore.Key;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );

        Datastore ds = DatastoreOptions.getDefaultInstance().getService();
        Key taskKey = ds.newKeyFactory().setKind("Task").newKey("nkey001");

        Entity task = Entity.newBuilder(taskKey).set("description", "Buy milk.").build();
        ds.put(task);

        Entity retrieved = ds.get(taskKey);
        System.out.printf("Retrieved %s: %s%n", taskKey.getName(), retrieved.getString("description"));
    }
}
