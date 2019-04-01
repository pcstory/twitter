package com.chyn.allianz.rawjson.twitter;

public class User {

	private long id;
	private long followers_count;
	private long friends_count;
	private String location;
	private String name;
	private String screen_name;
	
	public String getScreen_name() {
		return screen_name;
	}

	public void setScreen_name(String screen_name) {
		this.screen_name = screen_name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getFollowers_count() {
		return followers_count;
	}

	public void setFollowers_count(long followers_count) {
		this.followers_count = followers_count;
	}

	public long getFriends_count() {
		return friends_count;
	}

	public void setFriends_count(long friends_count) {
		this.friends_count = friends_count;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", followers_count=" + followers_count + ", friends_count=" + friends_count + ", location=" + location + ", name=" + name + ", screen_name="
				+ screen_name + "]";
	}

	

}
