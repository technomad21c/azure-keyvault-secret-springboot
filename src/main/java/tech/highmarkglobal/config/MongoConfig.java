package tech.highmarkglobal.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;

import com.mongodb.Mongo;
import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
	
//This class may not be needed in spring boot

//@Configuration
//@EnableMongoAuditing
public class MongoConfig extends AbstractMongoConfiguration {

	@Value("${server.dbName}")
	private String dbName;

	@Value("${spring.data.mongodb.uri}")
	private String mongoUri;

	@Override
	protected String getDatabaseName() {
		return dbName;
	}

	public Mongo mongo() throws Exception {
		String[] addresses = mongoUri.split(",");
		List<ServerAddress> servers = new ArrayList<>();
		for (String address : addresses) {
			String[] split = address.trim().split(":");
			servers.add(new ServerAddress(split[0].trim(), Integer.parseInt(split[1].trim())));
		}
		return new MongoClient(servers);
	}

	@Override
	public MongoClient mongoClient() {
		// TODO Auto-generated method stub
		return null;
	}

}