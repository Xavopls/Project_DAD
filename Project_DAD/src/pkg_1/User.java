package pkg_1;

import java.util.List;

public class User {

	private String phone;
	private String password;
	private List<String> subs;

	public User(String phone, String password, List<String> subs) {
		super();
		this.phone = phone;
		this.password = password;
		this.subs = subs;
	}

	public User() {}

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

	public List<String> getSubs() {
		return subs;
	}

	public void setSubs(List<String> subs) {
		this.subs = subs;
	}
	public void addSubs(String id){
		subs.add(id);
	}
	
}
/*
 * public void subscribeStation(String id) { if (!subs.contains(id))
 * subs.add(id); else System.out.
 * println("Unable to add, you're already subscribed to that station!"); }
 * 
 * public void unsubscribeStation(String id) { int ini = subs.size();
 * subs.remove(id); if (ini == subs.size()) { System.out.
 * println("Unable to unsubscribe, you are not subscribed to this station!"); }
 * }
 */
