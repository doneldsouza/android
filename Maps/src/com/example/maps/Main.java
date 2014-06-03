package com.example.maps;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;



public class Main extends Activity{
	MapView mymap;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);

		LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);
        //Get location coordinates
		GetPositionCoordinates PC=new GetPositionCoordinates(mlocManager);
        Location loc = PC.Coordinates();
        
        
        GoogleMap mMap;
        mMap = ((MapFragment) getFragmentManager()
        		.findFragmentById(R.id.map))
        		.getMap();
        //Add Marker and Zoom
        Marker MO= mMap.addMarker(new MarkerOptions()
                .position(new LatLng(loc.getLatitude(), loc.getLongitude()))
                .title("Your Location"));
        //Toast.makeText( getApplicationContext(), Text, Toast.LENGTH_SHORT).show();
        LatLng bounds = new LatLng(loc.getLatitude(),loc.getLongitude());
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(bounds, 15));//2.0-21.0
        //Make marker title visible
        MO.showInfoWindow();
    }

}