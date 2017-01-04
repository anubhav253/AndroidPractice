package com.example.devil.maps;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        // Add a marker in Sydney and move the camera
        mMap.getUiSettings().setCompassEnabled(true);

        LatLng sydney = new LatLng(0, 0);
        MarkerOptions marker = new MarkerOptions().position(sydney).title("0 , 0");
        marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));
        mMap.addMarker(marker);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));


        LatLng mumbai = new LatLng(19.0760f, 72.8777f);
        MarkerOptions marker2 = new MarkerOptions().position(mumbai).title("Mumbai");
        marker2.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE));
        mMap.addMarker(marker2);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(mumbai));


        LatLng rajasthan = new LatLng(27.0238f, 74.2179f);
        MarkerOptions marker3 = new MarkerOptions().position(rajasthan).title("Rajasthan");
        marker3.icon(BitmapDescriptorFactory.fromResource(R.mipmap.restaurant));
        mMap.addMarker(marker3);
        mMap.moveCamera(CameraUpdateFactory.newLatLng(rajasthan));


        LatLng delhi = new LatLng(28.7041f, 77.1025f);
        mMap.addMarker(new MarkerOptions().position(delhi).title("Delhi"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(delhi));
        CameraPosition cameraPosition2 = new CameraPosition.Builder().target(
                delhi).zoom(9f).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition2));

        //For zoom on India
        LatLng india = new LatLng(12.9716f, 77.5946f);
        mMap.addMarker(new MarkerOptions().position(india).title("India"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(india));
        CameraPosition cameraPosition = new CameraPosition.Builder().target(
                india).zoom(10f).build();
        googleMap.animateCamera(CameraUpdateFactory.newCameraPosition(cameraPosition));



    }
}
