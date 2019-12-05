package com.test.restapi.database;

import java.util.HashMap;
import java.util.Map;

import com.test.restapi.model.Message;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
//	private static Map<Long, Message> profile = new HashMap<>();
	
	public static Map<Long, Message> getMessages() {
		return messages;
	}
	
	
}
