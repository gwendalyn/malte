package com.mongodb;

import java.net.UnknownHostException;

/**
 * @description 
 * @author liang.ma
 * @date 2013-11-27 上午10:47:55
 * @since 0.0.0.0
 */

public class SimpleTest {

	public static void main(String[] args){
		
		// 这样就创建了一个MongoDB的数据库连接对象，它默认连接到当前机器的localhost地址，端口是27017。
		MongoClient mongo = null;
		try {
			mongo = new MongoClient();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// 这样就获得了一个test的数据库，如果mongoDB中没有创建这个数据库也是可以正常运行的。
		// 当添加的时候，没有这个库，mongoDB会自动创建当前数据库。
		DB db = mongo.getDB("test");
		DBCollection collName = db.getCollection("collName");
		DBCursor cursor = collName.find();
		while(cursor.hasNext()){
			System.out.println(cursor.next());
		}
	}
}



