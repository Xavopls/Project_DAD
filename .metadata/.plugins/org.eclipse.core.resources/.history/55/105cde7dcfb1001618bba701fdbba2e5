package pkg_1;

import server.RestServer;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class TestMain {

	private static Stations stations;
	private static Users clients;

	public static Stations getStations() {
		return stations;
	}

	public static void setStations(Stations stations) {
		TestMain.stations = stations;
	}
	
	public static Users getClients() {
		return clients;
	}

	public static void setStations(Users clients) {
		TestMain.clients = clients;
	}
	
	public static void addTestUsers() {
		//Generate users (Client)
		User user01 = new User("111111111", "aaa");
		User user02 = new User("111111112", "aaa");
		User user03 = new User("111111113", "aaa");
		User user04 = new User("111111114", "aaa");
		User user05 = new User("111111115", "aaa");
		User user06 = new User("111111116", "aaa");
		User user07 = new User("111111117", "aaa");
		User user08 = new User("111111118", "aaa");
		User user09 = new User("111111119", "aaa");
		User user10 = new User("111111120", "aaa");
		
		//Add them to Users "list"
		clients.addClient(user01);
		clients.addClient(user02);
		clients.addClient(user03);
		clients.addClient(user04);
		clients.addClient(user05);
		clients.addClient(user06);
		clients.addClient(user07);
		clients.addClient(user08);
		clients.addClient(user09);
		clients.addClient(user10);
	}
	
	public static void testSubscription() {
		Client client = ClientBuilder.newClient();
		WebTarget targetSub011 = client.target("http://localhost:15000").path("client/subscribe/111111111/1");
		WebTarget targetSub012 = client.target("http://localhost:15000").path("client/subscribe/111111111/2");
		WebTarget targetSub013 = client.target("http://localhost:15000").path("client/subscribe/111111111/3");
		WebTarget targetSub021 = client.target("http://localhost:15000").path("client/subscribe/111111112/1");
		WebTarget targetSub022 = client.target("http://localhost:15000").path("client/subscribe/111111112/2");
		WebTarget targetSub023 = client.target("http://localhost:15000").path("client/subscribe/111111112/3");
		WebTarget targetSub031 = client.target("http://localhost:15000").path("client/subscribe/111111113/1");
		WebTarget targetSub032 = client.target("http://localhost:15000").path("client/subscribe/111111113/2");
		WebTarget targetSub033 = client.target("http://localhost:15000").path("client/subscribe/111111113/3");
		
	}
	
	

	public static void main(String[] args) throws SchedulerException {

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
		
		//Testing
		addTestUsers();
		testSubscription();

	}
}
