package pkg_1;

import java.util.List;

public class Clients {
	private List<Client> clients;

	@Override
	public String toString() {
		return "Clients [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public List<Client> getClients() {
		return clients;
	}

	public void setClients(List<Client> clients) {
		this.clients = clients;
	}

	public void addClient(Client client) {
		if (clients.contains(client))
			clients.add(client);
		else
			System.out.println("The client already exists!");
	}

	public void removeClient(Client client) {
		if (clients.contains(client))
			clients.remove(client);
		else
			System.out.println("Unable to delete, user does not exist!");
	}
	
	public Client getClient(String phone) {
		for (Client client : clients) {
			if (client.getPhone().equalsIgnoreCase(phone)) {
				return client;
			}
		}
		return null;
	}

}
