package vcoach.example.com.vitalitycoach;


import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

/**
 * Created by ASHWINI2 on 14/08/2017.
 */

public class ActiveRewardsPage extends AppCompatActivity implements OnMapReadyCallback {

    static final LatLng RIVERSIDE_RUN = new LatLng(-26.748325, 27.828646);
    static final LatLng VIRGIN_ACTIVE = new LatLng(-26.740728, 27.844084);
    static final LatLng PARK_RUN = new LatLng(-26.757534, 27.844637);
    static final LatLng RACE_EVENT = new LatLng(-26.721597, 27.822249);

    MapView mapView;
    GoogleMap map;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.active_rewards_page);

        MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.googleMap);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {

        googleMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {

            @Override
            public View getInfoWindow(Marker arg0) {
                return null;
            }

            @Override
            public View getInfoContents(Marker marker) {

                LinearLayout info = new LinearLayout(getApplicationContext());
                info.setOrientation(LinearLayout.VERTICAL);

                TextView title = new TextView(getApplicationContext());
                title.setTextColor(Color.BLACK);
                title.setGravity(Gravity.CENTER);
                title.setTypeface(null, Typeface.BOLD);
                title.setText(marker.getTitle());

                TextView snippet = new TextView(getApplicationContext());
                snippet.setTextColor(Color.GRAY);
                snippet.setText(marker.getSnippet());

                info.addView(title);
                info.addView(snippet);

                return info;
            }
        });

        Marker m1 = googleMap.addMarker(new MarkerOptions()
                .position(RIVERSIDE_RUN)
                .title("RiverSide Sun")
                .snippet("Wenning St & Emfuleni Dr, Vanderbijlpark")
                .icon( BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_RED ) ) );


        Marker m2 = googleMap.addMarker(new MarkerOptions()
                .position(VIRGIN_ACTIVE)
                .title("Virgin Active (100 pts)")
                .snippet("Distance: 4km" + "\n" + "Location: Virgin Active Vanderbijl Park - Health Club")
                .icon( BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_AZURE ) ));

        Marker m3 = googleMap.addMarker(new MarkerOptions()
                .position(PARK_RUN)
                .title("Park Run (300 pts)")
                .snippet("Distance: 4.5km" + "\n" +"Location: Heron Banks Golf Course, 73 Minnaar St")
                .icon( BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_AZURE ) ));

        Marker m4 = googleMap.addMarker(new MarkerOptions()
                .position(RACE_EVENT)
                .title("Race Event (800 pts)")
                .snippet("Distance: 5.1km" + "\n" + "Location: Old Vaaltonians Sports Club, Abraham Kriel St")
                .icon( BitmapDescriptorFactory.defaultMarker( BitmapDescriptorFactory.HUE_AZURE ) ));

        CameraUpdate cu = CameraUpdateFactory.newLatLngZoom(m1.getPosition(), 12F);
        googleMap.moveCamera(cu);
    }
}






