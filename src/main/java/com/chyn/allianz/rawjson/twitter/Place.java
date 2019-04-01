package com.chyn.allianz.rawjson.twitter;

public class Place {

	private String id;
	private String place_type;
	private String name;
	private String full_name;
	
	public String getFull_name() {
		return full_name;
	}

	public void setFull_name(String full_name) {
		this.full_name = full_name;
	}

	private String country;
	private BoundingBox bounding_box;
	
	@Override
	public String toString() {
		return "Place [id=" + id + ", place_type=" + place_type + ", name=" + name + ", full_name=" + full_name + ", country=" + country + ", bounding_box=" + bounding_box + "]";
	}

	public BoundingBox getBounding_box() {
		return bounding_box;
	}

	public void setBounding_box(BoundingBox bounding_box) {
		this.bounding_box = bounding_box;
	}
		
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPlace_type() {
		return place_type;
	}

	public void setPlace_type(String place_type) {
		this.place_type = place_type;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
