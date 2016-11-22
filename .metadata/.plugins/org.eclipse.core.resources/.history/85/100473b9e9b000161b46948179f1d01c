package pkg_1;

import java.util.List;

public class Stations {
	private List<Station> stations;

	public Stations() {
	}

	public Stations(List<Station> stations) {
		this.stations = stations;

	}

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}

	@Override
	public String toString() {
		return "Stations [stations=" + stations + ", getStations()=" + getStations() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	// STATISTICS FUNCTIONS

	public int avg_normalBike() {
		int total = 0;
		int num = 0;
		for (int i = 0; i < stations.size(); i++) {
			if (stations.get(i).getType() == "BIKE") {
				total++;
				num += Integer.parseInt(stations.get(i).getBikes());
			}
		}
		return num / total;
	}

	public int avg_electricBike() {
		int total = 0;
		int num = 0;
		for (int i = 0; i < stations.size(); i++) {
			if (stations.get(i).getType() == "BIKE-ELECTRIC") {
				total++;
				num += Integer.parseInt(stations.get(i).getBikes());
			}
		}
		return num / total;
	}

	public void avg_status_normalBike() {
		int opn_num = 0;
		for (int i = 0; i < stations.size(); i++) {
			if (stations.get(i).getType() == "BIKE" && stations.get(i).getStatus() == "OPN") {
				opn_num++;
			}

		}
	}

	public void avg_status_electricBike() {
		int opn_num = 0;
		for (int i = 0; i < stations.size(); i++) {
			if (stations.get(i).getType() == "BIKE-ELECTRIC" && stations.get(i).getStatus() == "OPN") {
				opn_num++;
			}

		}
	}

}
