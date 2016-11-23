package pkg_1;

import java.util.List;

public class Users {
	private List<User> clients;

	@Override
	public String toString() {
		return "Clients [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	public List<User> getClients() {
		return clients;
	}

	public void setClients(List<User> clients) {
		this.clients = clients;
	}

	public void addClient(User client) {
		if (clients.contains(client))
			clients.add(client);
		else
			System.out.println("The client already exists!");
	}

	public void removeClient(User client) {
		if (clients.contains(client))
			clients.remove(client);
		else
			System.out.println("Unable to delete, user does not exist!");
	}
	
	public User getClient(String phone) {
		for (User client : clients) {
			if (client.getPhone().equalsIgnoreCase(phone)) {
				return client;
			}
		}
		return null;
	}

}
