package com.test.restapi.RestAPI.services;

import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.io.Serializable;
import java.util.ArrayList;

import com.test.restapi.database.DatabaseClass;
import com.test.restapi.model.Message;

public class MessagesServices {
	
	private Map<Long, Message> messages = DatabaseClass.getMessages();
	
	private SessionFactory sessionFactory = null;
	private Session session = null;
	
	public MessagesServices(){
		sessionFactory = new Configuration().configure().buildSessionFactory();
//		session = sessionFactory.openSession();
//		session.beginTransaction();
		System.out.print("done");
	}
	
	public List<Message> getAllMessages(){
		session = sessionFactory.openSession();
		session.getTransaction();
		Query query = session.createQuery("from Message");
		ArrayList<Message> messages = (ArrayList<Message>) query.list();
		session.close();
		return messages;
	}

	public Message getMessage(Long id){
		session = sessionFactory.openSession();
		session.getTransaction();
		Message message = session.get(Message.class, id);
		session.close();
		return message;
//		return messages.get(id);
	}
	
	public Message addMessage(Message message){
//		messages.put(message.getId(), message);
		session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(message);
		session.getTransaction().commit();
		session.close();
//		return messages.get(message.getId());
		return message;
	}
	
	public Message updateMessage(Message message){
		if(message.getId()<=0)
			return null;
		messages.put(message.getId(), message);
		return message;
	}
	
	public Long deleteMessage(Long id){
		
		Serializable delId = new Long(id);
		
		session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		
		Object persistentInstance = session.load(Message.class, delId);
		
		session.delete(persistentInstance);
		tx.commit();
		session.close();
		
		return id;
	}
}
