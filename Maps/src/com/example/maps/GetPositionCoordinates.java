package com.example.maps;

import android.app.Activity;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;

public class GetPositionCoordinates extends Activity implements LocationListener{
	private LocationManager mlocManager;

	public GetPositionCoordinates(LocationManager locManager) {
		// TODO Auto-generated constructor stub
		mlocManager = locManager;
	}

	public Location Coordinates(){
		Log.d("Locmanager","Locmanager");
		mlocManager.requestLocationUpdates( LocationManager.NETWORK_PROVIDER, 0, 0,  this);
		Log.d("Location","Location");
		Location loc = mlocManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
		Log.d("Cordinates",loc.toString());
		return loc;
	}

	@Override
	public void onLocationChanged(Location location) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStatusChanged(String provider, int status, Bundle extras) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderEnabled(String provider) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onProviderDisabled(String provider) {
		// TODO Auto-generated method stub
		
	}
}
