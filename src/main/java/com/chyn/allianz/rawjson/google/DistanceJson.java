package com.chyn.allianz.rawjson.google;

import java.util.List;

public class DistanceJson {
	
	private List<String> destination_addresses;
	private List<String> origin_addresses;
	private List<Rows> rows;
	
	
	public List<String> getDestination_addresses() {
		return destination_addresses;
	}


	public void setDestination_addresses(List<String> destination_addresses) {
		this.destination_addresses = destination_addresses;
	}


	public List<String> getOrigin_addresses() {
		return origin_addresses;
	}


	public void setOrigin_addresses(List<String> origin_addresses) {
		this.origin_addresses = origin_addresses;
	}


	public List<Rows> getRows() {
		return rows;
	}


	public void setRows(List<Rows> rows) {
		this.rows = rows;
	}


	@Override
	public String toString() {
		return "DistanceJson [destination_addresses=" + destination_addresses + ", origin_addresses=" + origin_addresses + ", rows=" + rows + "]";
	}
	

	
	

//	{
//		   "destination_addresses" : [ "San Francisco, CA, USA" ],
//		   "origin_addresses" : [ "Seattle, WA, USA" ],
//		   "rows" : [
//		      {
//		         "elements" : [
//		            {
//		               "distance" : {
//		                  "text" : "1,300 km",
//		                  "value" : 1299785
//		               },
//		               "duration" : {
//		                  "text" : "12 hours 40 mins",
//		                  "value" : 45600
//		               },
//		               "status" : "OK"
//		            }
//		         ]
//		      }
//		   ],
//		   "status" : "OK"
//		}
//	
}
