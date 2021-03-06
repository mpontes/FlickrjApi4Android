package com.googlecode.flickrjandroid.places;

import com.googlecode.flickrjandroid.SearchResultList;

/**
 * Simple Extension of SearchResultList.
 *
 * @author mago
 * @version $Id: PlacesList.java,v 1.1 2008/01/19 22:53:56 x-mago Exp $
 */
public class PlacesList extends SearchResultList<Place> {
    private static final long serialVersionUID = -6773614467896936754L;
    
    private double longitude;
    private double latitude;

    public PlacesList() {
    	super();
    }

	/**
	 * @return the longitude
	 */
	public double getLongitude() {
		return longitude;
	}

	/**
	 * @param longitude the longitude to set
	 */
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	/**
	 * @return the latitude
	 */
	public double getLatitude() {
		return latitude;
	}

	/**
	 * @param latitude the latitude to set
	 */
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
    
}
