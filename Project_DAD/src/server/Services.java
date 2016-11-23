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
import pkg_1.Clients;
import pkg_1.Client;

@Path("/services")
public class Services {

	static Stations stations;
	static Clients clients;
	
	public Services(Stations _stations, Clients _clients) {
		stations = _stations;
		clients = _clients;
	}
	
	/* POST METHODS */
	@POST
	@Path("/client/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(Client client) {
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
	public Client getClient(@PathParam("phone") String phone) {
		Client client = clients.getClient("phone");
		if(client!=null) {
			return client;
		}
		throw new WebApplicationException(404);
	}
	
}
