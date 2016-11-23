package server;

//import java.util.ArrayList;
//import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pkg_1.Stations;
import pkg_1.Station;
import pkg_1.Users;
import pkg_1.User;

@Path("/services")
public class Services {

	static Stations stations;
	static Users clients;
	
	
	/* POST METHODS */
	@POST
	@Path("/client/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(User client) {
		clients.addClient(client);
		return Response.status(200).entity(client).build();
	}
	
	@POST
	@Path("/station/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Station station) {
		stations.addStation(station);
		return Response.status(200).entity(station).build();
	}
	
	@POST
	@Path("/client/subscribe/{phone}/{id}")
	public void subscribe(@PathParam("phone") String phone, @PathParam("id") String id) {
		//Identifies the client and the station
		User client = clients.getClient("phone");
		if(client==null)
			throw new WebApplicationException(404);
		Station station = stations.getStation("id");
		if(station==null)
			throw new WebApplicationException(404);
		
		client.subscribeStation(station);
	}
	
	/* GET METHODS */
	@GET
	@Path("/station/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Station getStation(@PathParam("id") String id) {
		Station station = stations.getStation("id");
		if(station!=null) {
			return station;
		}
		throw new WebApplicationException(404);
	}
	
	@GET
	@Path("/client/get/{phone}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getClient(@PathParam("phone") String phone) {
		User client = clients.getClient("phone");
		if(client==null)
			throw new WebApplicationException(404);
		return client;
	}
	
	@GET
	@Path("client/subscribe/showSubscribed")
	@Produces(MediaType.APPLICATION_JSON)
	public Stations getSubscribed(@PathParam("phone") String phone) {
		User client = clients.getClient("phone");
		if(client==null)
			throw new WebApplicationException(404);
		Stations subStations = new Stations(client.getSubs());
		return subStations;
	}
	
}
