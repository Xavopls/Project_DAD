package pkg_1;

import java.util.List;

public class User {

	private String phone;
	private String password;
	private List<Station> subs;
	
	public User(String _phone, String _pass) {
		phone = _phone;
		password = _pass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Client [phone=" + phone + ", password=" + password + ", subs=" + subs + ", getPhone()=" + getPhone()
				+ ", getPassword()=" + getPassword() + ", getSubs()=" + getSubs() + ", getClass()=" + getClass()
				+ ", hashCode()=" + hashCode() + ", toString()=" + super.toString() + "]";
	}

	public List<Station> getSubs() {
		return subs;
	}

	public void setSubs(List<Station> subs) {
		this.subs = subs;
	}

	public void subscribeStation(Station station) {
		if (!subs.contains(station))
			subs.add(station);
		else
			System.out.println("Unable to add, you're already subscribed to that station!");
	}

	public void unsubscribeStation(Station station) {
		int ini = subs.size();
		subs.remove(station);
		if (ini == subs.size()) {
			System.out.println("Unable to unsubscribe, you are not subscribed to this station!");
		}
	}
}
