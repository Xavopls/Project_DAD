package server;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import pkg_1.Station;
import pkg_1.TestMain;
import pkg_1.User;

@Path("/services")
public class Services {

	// POST METHODS
	@POST
	@Path("/client/add")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public Response create(User client) {
		TestMain.setClient(client);
		return Response.status(200).entity(client).build();
	}

	@POST
	@Path("/client/subscribe/{phone}/{id}")
	@Produces(MediaType.TEXT_HTML)
	public Response subscribe(@PathParam("phone") String phone, @PathParam("id") String id) {
		
		User client;
		// Checks the client
		try {
			client = TestMain.getClient(phone);
		} catch (Exception e) {
			throw new WebApplicationException(404);
		}
		// Checks the station
		try {
			Station station = TestMain.getStation(id);
		} catch (Exception e) {
			throw new WebApplicationException(404);
		}
		
		String confirmation = "The user "+phone+" has been successfully subscribed to station "+id+".";
		client.addSubs(id);
		return Response.status(200).entity(confirmation).build();
	}

	// GET METHODS

	@GET
	@Path("/station/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Station getStation(@PathParam("id") String id) {
		try {
			return TestMain.getStation(id);
		} catch (Exception e) {
			throw new WebApplicationException(404);
		}
	}

	@GET
	@Path("/client/get/{phone}")
	@Produces(MediaType.APPLICATION_JSON)
	public User getClient(@PathParam("phone") String phone) {
		try {
			return TestMain.getClient(phone);
		} catch (Exception e) {
			throw new WebApplicationException(404);
		}
	}
	/*
	 * @GET
	 * 
	 * @Path("client/subscribe/showSubscribed")
	 * 
	 * @Produces(MediaType.APPLICATION_JSON) public Stations
	 * getSubscribed(@PathParam("phone") String phone) { User client =
	 * clients.getClient("phone"); if (client == null) throw new
	 * WebApplicationException(404); Stations subStations = new
	 * Stations(client.getSubs()); return subStations; }
	 */
}
