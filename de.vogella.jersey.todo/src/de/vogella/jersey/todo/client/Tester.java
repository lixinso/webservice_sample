package de.vogella.jersey.todo.client;

import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.representation.Form;

import de.vogella.jersey.todo.model.Todo;

public class Tester {
	public static void main(String[] args){
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create();
		WebResource service = client.resource(getBaseURI());
		Todo todo = new Todo("3","Blabla");
		ClientResponse response = service.path("rest").path("todos").path(todo.getId()).accept(MediaType.APPLICATION_XML).put(ClientResponse.class,todo);
		System.out.println(response.getStatus());
		System.out.println(service.path("rest").path("todos").accept(MediaType.TEXT_XML).get(String.class));
		System.out.println(service.path("rest").path("todos").accept(MediaType.APPLICATION_XML).get(String.class));
		System.out.println(service.path("rest").path("todos/1").accept(MediaType.APPLICATION_XML).get(String.class));
		service.path("rest").path("todos/3").delete();
		System.out.println(service.path("rest").path("todos").accept(MediaType.APPLICATION_XML).get(String.class));
		
		Form form = new Form();
		form.add("id","4");
		form.add("summary", "Demostration of the client lib for forms");
		response = service.path("rest").path("todos").type(MediaType.APPLICATION_FORM_URLENCODED).post(ClientResponse.class,form);
		System.out.println("Form response" + response.getEntity(String.class));
	}
	
	private static URI getBaseURI(){
		return UriBuilder.fromUri("http://localhost:8080/de.vogella.jersey.todo").build();
	}

}
