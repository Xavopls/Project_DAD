package pkg_1;

import java.util.List;

public class Stations {
	private List<Station> stations;

	public Stations() {}

	public Stations(List<Station> stations) {
		this.stations = stations;
	}

	public List<Station> getStations() {
		return stations;
	}

	public void setStations(List<Station> stations) {
		this.stations = stations;
	}
	
	public void addStation(Station station) {
		stations.add(station);
	}

	public void removeStation(Station station) {
		stations.remove(station);
	}
	
	public Station getStation(String id) {
		for (Station station : stations) {
			if (station.getId().equalsIgnoreCase(id)) {
				return station;
			}
		}
		return null;
	}
	 
	@Override
	public String toString() {
		return "Stations [stations=" + stations + ", getStations()=" + getStations() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	// STATISTICS FUNCTIONS

	// CALCULA EL PORCENTAJE DE CUANTAS ESTACIONES TIENEN BICICLETAS

	public int avgBikesAvailable_normalBike() {
		int total = 0;
		int num = 0;
		for (int i = 0; i < stations.size(); i++) {
			if (stations.get(i).getType().equals("BIKE")) {
				total++;
				if (!stations.get(i).getBikes().equals("0"))
					num += Integer.parseInt(stations.get(i).getBikes());
			}
		}
		return 100 * num / total;
	}

	public int avgBikesAvailable_electricBike() {
		int total = 0;
		int num = 0;
		for (int i = 0; i < stations.size(); i++) {
			if (stations.get(i).getType().equals("BIKE-ELECTRIC")) {
				total++;
				if (!stations.get(i).getBikes().equals("0"))
					num += Integer.parseInt(stations.get(i).getBikes());
			}
		}
		return 100 * num / total;
	}

	// CALCULA EL PORCENTAJE DE ESTACIONES QUE TIENEN HUECOS LIBRES

	public int avgFreeSlots_normalBike() {
		int total = 0;
		int num = 0;
		for (int i = 0; i < stations.size(); i++) {
			if (stations.get(i).getType().equals("BIKE")) {
				total++;
				if (!stations.get(i).getSlots().equals("0"))
					num += Integer.parseInt(stations.get(i).getSlots());
			}
		}
		return 100 * num / total;
	}

	public int avgFreeSlots_electricBike() {
		int total = 0;
		int num = 0;
		for (int i = 0; i < stations.size(); i++) {
			if (stations.get(i).getType().equals("BIKE-ELECTRIC")) {
				total++;
				if (!stations.get(i).getSlots().equals("0"))
					num += Integer.parseInt(stations.get(i).getSlots());
			}
		}
		return 100 * num / total;
	}

	// CALCULA EL PORCENTAJE DE ESTACIONES OPERATIVAS

	public int avg_status_normalBike() {
		int opn_num = 0;
		int total = 0;
		for (int i = 0; i < stations.size(); i++) {
			if (stations.get(i).getType().equals("BIKE")) {
				total++;

				if (stations.get(i).getStatus().equals("OPN")) {
					opn_num++;
				}
			}
		}
		

		return (100 * opn_num / total);
	}

	public int avg_status_electricBike() {
		int opn_num = 0;
		int total = 0;
		for (int i = 0; i < stations.size(); i++) {
			if (stations.get(i).getType().equals("BIKE-ELECTRIC")) {
				total++;

				if (stations.get(i).getStatus().equals("OPN")) {
					opn_num++;
				}
			}
		}
		return 100 * opn_num / total;
	}

}
