package com.chyn.allianz.rawjson.google;

public class Distance {

	private String text;
	private long value;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public long getValue() {
		return value;
	}

	public void setValue(long value) {
		this.value = value;
	}

	@Override
	public String toString() {
		return "Distance [text=" + text + ", value=" + value + "]";
	}

}
