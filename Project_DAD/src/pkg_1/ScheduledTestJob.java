package pkg_1;

import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ScheduledTestJob implements Job {
	Client client = ClientBuilder.newClient();

	public void execute(JobExecutionContext context) throws JobExecutionException {
		WebTarget targetAdd = client.target("http://wservice.viabicing.cat/v2/stations");
		Stations stations = targetAdd.request(MediaType.APPLICATION_JSON_TYPE).get(new GenericType<Stations>() {
		});

		List<Station> list = stations.getStations();
		 System.out.println("Porcentaje de estaciones operativas");
		 System.out.println(stations.avg_status_normalBike());
		/*for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i).getType());
		}
*/
	}
}
