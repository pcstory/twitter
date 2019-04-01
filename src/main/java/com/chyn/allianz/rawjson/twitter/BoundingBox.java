package com.chyn.allianz.rawjson.twitter;

import java.util.ArrayList;
import java.util.List;

public class BoundingBox {

	private List<List<List<Double>>> coordinates = new ArrayList<List<List<Double>>>();

	public List<List<List<Double>>> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<List<List<Double>>> coordinates) {
		this.coordinates = coordinates;
	}

	@Override
	public String toString() {
		return "BoundingBox [coordinates=" + coordinates + "]";
	}

	
}
