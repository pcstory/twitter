package com.chyn.allianz.rawjson.twitter;

public class RawRetweetJson {

	private long id;
	private User user;
	private RetweetedStatus retweeted_status;
	private QuoteStatus quoted_status; 
	private boolean is_quote_status;
	private String created_at;
	private String text;
	
	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getCreated_at() {
		return created_at;
	}

	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}

	public boolean isIs_quote_status() {
		return is_quote_status;
	}

	public void setIs_quote_status(boolean is_quote_status) {
		this.is_quote_status = is_quote_status;
	}

	private Place place;
	
	public Place getPlace() {
		return place;
	}

	public void setPlace(Place place) {
		this.place = place;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public QuoteStatus getQuoted_status() {
		return quoted_status;
	}

	public void setQuoted_status(QuoteStatus quoted_status) {
		this.quoted_status = quoted_status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public RetweetedStatus getRetweeted_status() {
		return retweeted_status;
	}

	public void setRetweeted_status(RetweetedStatus retweeted_status) {
		this.retweeted_status = retweeted_status;
	}

	@Override
	public String toString() {
		return "RawRetweetJson [id=" + id + ", user=" + user + ", retweeted_status=" + retweeted_status + ", quoted_status=" + quoted_status + ", is_quote_status="
				+ is_quote_status + ", created_at=" + created_at + ", text=" + text + ", place=" + place + "]";
	}

}
