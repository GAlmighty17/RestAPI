package com.test.restapi.RestAPI.resources;


import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import com.test.restapi.RestAPI.services.MessagesServices;
import com.test.restapi.model.Message;

@Path("messages")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class MessageResource {
	
	private MessagesServices messageServices = new MessagesServices();
	
	@GET
	public List<Message> getAllMessage(){
		System.out.print("reached");
		return messageServices.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") Long messageId){
		return messageServices.getMessage(messageId);
	}
	
	@POST
	public Message addMessage(Message message){
		return messageServices.addMessage(message);
	}
	
	@PUT
	public Message updateMessage(Message message){
		return messageServices.updateMessage(message);
	}
	
	@DELETE
	@Path("/{messageId}")
	public Long deleteMessage(@PathParam("messageId") Long messageId){
		return messageServices.deleteMessage(messageId);
	}
}
