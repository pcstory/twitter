package com.chyn.allianz.rawjson.twitter;

public class RetweetedStatus {

	private long id;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	private long retweet_count;

	private User user;

	public long getRetweet_count() {
		return retweet_count;
	}

	public void setRetweet_count(long retweet_count) {
		this.retweet_count = retweet_count;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "RetweetedStatus [id=" + id + ", retweet_count=" + retweet_count + ", user=" + user + "]";
	}

}
