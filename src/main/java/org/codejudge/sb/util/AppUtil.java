package org.codejudge.sb.util;

public class AppUtil {

	public static Double findDistance(Double srcLatitude, Double srcLongitude, Double destLatitude, Double destLongitude) {
		double lat1 = Math.toRadians(srcLatitude.doubleValue());
		double long1 = Math.toRadians(srcLongitude.doubleValue());
		double lat2 = Math.toRadians(destLatitude.doubleValue());
		double long2 = Math.toRadians(destLongitude.doubleValue());
		
		double dlon = long1-long2;
		double dlat = lat1-lat2;
		
		double a = Math.pow(Math.sin(dlat / 2), 2) + Math.cos(lat1) * Math.cos(lat2) * Math.pow(Math.sin(dlon / 2),2);
		double c = 2 * Math.asin(Math.sqrt(a)); 
		return Double.valueOf(c*6371);
	}
}
