package com.chyn.allianz.rawjson.google;

import java.util.List;

public class Rows {
	
	private List<Elements> elements;

	public List<Elements> getElements() {
		return elements;
	}

	public void setElements(List<Elements> elements) {
		this.elements = elements;
	}

	@Override
	public String toString() {
		return "Rows [elements=" + elements + "]";
	}
	

}
