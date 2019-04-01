package com.chyn.allianz.rawjson.twitter;

public class QuoteStatus {

	private User user;
	private long id;

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "QuoteStatus [user=" + user + ", id=" + id + "]";
	}

}
