package com.mongodb;

import java.net.UnknownHostException;

import com.mongodb.util.JSON;

/**
 * @description
 * @author liang.ma
 * @date 2013-11-27 下午4:46:44
 * @since 0.0.0.0
 */

public class SimpleTest2 {
	public static void main(String[] args) throws UnknownHostException,
			MongoException {
		MongoClient mg = new MongoClient();
		// 查询所有的Database
		for (String name : mg.getDatabaseNames()) {
			System.out.println("dbName: " + name);
		}

		DB db = mg.getDB("test");
		// 查询所有的聚集集合
		for (String name : db.getCollectionNames()) {
			System.out.println("collectionName: " + name);
		}
		DBCollection users = db.getCollection("users");
		// 查询所有的数据
		DBCursor cur = users.find();
		while (cur.hasNext()) {
			System.out.println(cur.next());
		}
		System.out.println(cur.count());
		System.out.println(cur.getCursorId());
		System.out.println(JSON.serialize(cur));
	}
}
