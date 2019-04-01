package com.chyn.allianz.twitter;

public class Status {

	private int code;
	private String descr;
	private String lastCollectedRawJson;

	public String getLastCollectedRawJson() {
		return lastCollectedRawJson;
	}

	public void setLastCollectedRawJson(String lastCollectedRawJson) {
		this.lastCollectedRawJson = lastCollectedRawJson;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getDescr() {
		return descr;
	}

	public void setDescr(String descr) {
		this.descr = descr;
	}

}
