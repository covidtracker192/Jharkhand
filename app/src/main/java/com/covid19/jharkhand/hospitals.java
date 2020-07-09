package com.covid19.jharkhand;

import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class hospitals extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    LatLng latLng;
    private FusedLocationProviderClient fusedLocationClient;
    LocationRequest mLocationRequest;
    Location mLastLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitals);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);
        mLocationRequest = new LocationRequest();
        mLocationRequest.setInterval(180000);
        mLocationRequest.setFastestInterval(90000);
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationClient.requestLocationUpdates(mLocationRequest, mLocationCallback, Looper.myLooper());
        mMap.setMyLocationEnabled(true);

        // Test Center 1
        final LatLng center1 = new LatLng(23.561401, 84.556503);
        mMap.addMarker(new MarkerOptions().position(center1).title("District Hospital, Gumla, Jharkhand"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center1));

        //Test Center 2
        final LatLng center2 = new LatLng(24.172682, 84.475554);
        mMap.addMarker(new MarkerOptions().position(center2).title("Sadar Hospital,  Latehar, Jharkhand"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center2));

        //Test Center 3
        final LatLng center3 = new LatLng(24.125543, 84.697124);
        mMap.addMarker(new MarkerOptions().position(center3).title("Sadar Hospital, Lohardaga, Jharkhand"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center3));

        //Test Center 4
        final LatLng center4 = new LatLng(24.132131, 84.986887);
        mMap.addMarker(new MarkerOptions().position(center4).title("Itki Aarogyashala, Ranchi, Jharkhand"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center4));

        //Test Center 5
        final LatLng center5 = new LatLng(24.238831, 85.162304);
        mMap.addMarker(new MarkerOptions().position(center5).title("Sadar Hospital, Khunti, Jharkhand"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center5));

        //Test Center 6
        final LatLng center6 = new LatLng(25.267822, 84.838158);
        mMap.addMarker(new MarkerOptions().position(center6).title("Sadar Hospital, Chatra, Jharkhand"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center6));
        mMap.animateCamera(CameraUpdateFactory.zoomTo(6));

        //Test Center 7
        final LatLng center7 = new LatLng(23.981542, 85.359724);
        mMap.addMarker(new MarkerOptions().position(center7).title("Sadar Hospital, Ranchi, Jharkhand"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center7));

        //Test Center 8
        final LatLng center8 = new LatLng(24.314050, 85.326857);
        mMap.addMarker(new MarkerOptions().position(center8).title("Rajendra Institute of Medical Sciences, Ranchi, Jharkhand"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center8));

        //Test Center 9
        final LatLng center9 = new LatLng(24.212285, 85.388230);
        mMap.addMarker(new MarkerOptions().position(center9).title("Military Hospital Ranchi, Jharkhand"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center9));

        //Test Center 10
        final LatLng center10 = new LatLng(24.869766, 85.300349);
        mMap.addMarker(new MarkerOptions().position(center10).title("Sadar Hospital Hazaribag, Jharkhand"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center10));

        //Test Center 11
        final LatLng center11 = new LatLng(24.189438, 85.525884);
        mMap.addMarker(new MarkerOptions().position(center11).title("Sadar hospital ramgarh, Chhatarmaru, Jharkhand"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center11));

        //Test Center 12
        final LatLng center12 = new LatLng(24.569347, 86.084175);
        mMap.addMarker(new MarkerOptions().position(center12).title("Sadar Hospital Bokaro, Bokaro Steel City, Jharkhand"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(center7));

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {
                if(marker.getPosition().equals(center8)) {
                    Uri uriUrl = Uri.parse("https://www.rimsranchi.org/");
                    Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
                    startActivity(launchBrowser);
                }

            }
        });

    }

    LocationCallback mLocationCallback=new LocationCallback(){
        @Override
        public void onLocationResult(LocationResult locationResult) {
            for(Location location1 : locationResult.getLocations()) {
                if (getApplicationContext() != null) {
                    mLastLocation = location1;
                    latLng = new LatLng(location1.getLatitude(), location1.getLongitude());
                    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLng));
                    mMap.animateCamera(CameraUpdateFactory.zoomTo(7));
                }
            }

        }
    };
    public void onBackPressed(){
        Intent intent = new Intent(hospitals.this, home.class);
        startActivity(intent);
        finish();
    };
}
