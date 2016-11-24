package pkg_1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.WebApplicationException;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

import server.RestServer;

public class TestMain {

	private static Stations stations;
	private static List<User> clients;
	
	public static void main(String[] args) throws SchedulerException, IOException {

		RestServer server = new RestServer();
		server.initServer();
		
		Stations stations = new Stations();
		clients = new ArrayList<User>();
		
		scheduleJob();
		
	}

	public static Stations getStations() {
		return stations;
	}
	
	public static void setStations(Stations stations) {
		TestMain.stations = stations;
	}

	public static Station getStation(String id) {
		try {
			return stations.getStation(id);
		} catch (Exception e) {
			throw new WebApplicationException(404);
		}
	}
	
	public static void setStation(Station station) {
		TestMain.stations.addStation(station);
	}

	public static List<User> getClients() {
		return clients;
	}
	
	public static void setClients(List<User> clients) {
		TestMain.clients = clients;
	}
	
	public static User getClient(String phone) {
		for (User user : clients) {
			if (user.getPhone().equalsIgnoreCase(phone)) {
				return user;
			}
		}
		throw new WebApplicationException(404);
	}

	public static void setClient(User client) {
		TestMain.clients.add(client);
	}

	public static void scheduleJob() throws SchedulerException {
		
		// Specify the job' s details..
		JobDetail job = JobBuilder.newJob(ScheduledTestJob.class).withIdentity("testJob").build();

		// Specify the running period of the job
		Trigger trigger = TriggerBuilder.newTrigger()
				.withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(30).repeatForever()).build();

		// Schedule the job
		SchedulerFactory sf = new StdSchedulerFactory();
		Scheduler sched = sf.getScheduler();
		sched.start();
		sched.scheduleJob(job, trigger);
	}
	
}
