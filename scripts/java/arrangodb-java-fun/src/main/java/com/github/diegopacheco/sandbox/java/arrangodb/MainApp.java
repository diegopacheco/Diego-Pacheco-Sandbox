package com.github.diegopacheco.sandbox.java.arrangodb;

import com.arangodb.ArangoConfigure;
import com.arangodb.ArangoDriver;
import com.arangodb.ArangoHost;
import com.arangodb.entity.CollectionEntity;
import com.arangodb.entity.DocumentEntity;

public class MainApp {
	public static void main(String[] args) throws Throwable {
		
		  ArangoConfigure configure = new ArangoConfigure();
		  configure.setArangoHost(new ArangoHost("127.0.0.1", 8529));
		  configure.init();
		  ArangoDriver arangoDriver = new ArangoDriver(configure);
		  
		  arangoDriver.createDatabase("db1");
		  arangoDriver.setDefaultDatabase("db1");
		  
		  CollectionEntity myArangoCollection = arangoDriver.createCollection("myCollection");
		  System.out.println(myArangoCollection);
		  
		  MyObject myObject = new MyObject("Homer", 38);
		  DocumentEntity<MyObject> myDocument = arangoDriver.createDocument("myCollection", myObject);
		  System.out.println(myDocument);
	}
}
