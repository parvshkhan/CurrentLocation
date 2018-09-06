package graysone;

import android.annotation.SuppressLint;
import android.location.Location;
import android.os.Bundle;
import android.os.Looper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;

import graysone.com.amazonservice.R;

public class MainActivity2 extends AppCompatActivity implements
        GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener {


    MapView mapView;
    LocationRequest mLocationRequest;
    GoogleApiClient mGoogleApiClient;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);




        mapView = findViewById (R.id.mapView );

        mapView.onCreate ( savedInstanceState );
        mapView.onResume ();
        mapView.getMapAsync ( new OnMapReadyCallback ( ) {
            @Override
            public void onMapReady(GoogleMap googleMap) {




            }
        } );
    }








    private void buildGoogleClient()
    {

        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .addApi( LocationServices.API)
                .addConnectionCallbacks(this)
                .addOnConnectionFailedListener(this)
                .build();

    }

    @SuppressLint("MissingPermission")
    @Override
    public void onConnected(@Nullable Bundle bundle) {

        mLocationRequest = LocationRequest.create();
        mLocationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
        mLocationRequest.setInterval(1000); // Update location every second




        LocationCallback locationCallback = new LocationCallback (){

            @Override
            public void onLocationResult(LocationResult var1) {
                Log.i ( "result", "onLocationResult: " +var1);

            }
        };




        LocationServices.getFusedLocationProviderClient ( this ).requestLocationUpdates (mLocationRequest,locationCallback, Looper.myLooper ()  );


    }

    @Override
    public void onConnectionSuspended(int i) {

    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }





    @Override
    public void onResume() {
        buildGoogleClient();
        mGoogleApiClient.connect();
        super.onResume();


    }
}
