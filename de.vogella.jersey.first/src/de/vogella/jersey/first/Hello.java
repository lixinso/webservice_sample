package de.vogella.jersey.first;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/hello")
public class Hello {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String sayPlainTextHello(){
		return "Hello Jersey TEXT";
	}
	
	@GET
	@Produces(MediaType.TEXT_XML)
	public String sayXMLhello(){
		return "<?xml version=\"1.0\"?>" + "<hello>Hello Jersey XML" + "</hello>";
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	public String sayHtmlHello(){
		return "<html>" + "<title>" + "Hello Jersey HTML" + "</title>" + "<body><h1>" 
		+ "Hello Jersey" + "</h1></body>" + "</html>";
	}
}
