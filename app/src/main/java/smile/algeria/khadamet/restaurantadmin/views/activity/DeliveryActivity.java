package smile.algeria.khadamet.restaurantadmin.views.activity;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MapStyleOptions;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;

import smile.algeria.khadamet.restaurantadmin.R;
import smile.algeria.khadamet.restaurantadmin.model.InfoWindowData;
import smile.algeria.khadamet.restaurantadmin.utils.CustomInfoWindowGoogleMap;

public class DeliveryActivity extends AppCompatActivity implements OnMapReadyCallback {

    private static final String TAG = "Tag";
    private GoogleMap mMap;
    ArrayList<LatLng> markersArray = new ArrayList<LatLng>();
    BottomSheetBehavior sheetBehavior;
    private ImageView motorImage;
    private ImageView carImage;
    RelativeLayout layoutBottomSheet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delivery);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(getString(R.string.delivery));
        initMap();
        addLocation();
        layoutBottomSheet =findViewById(R.id.bottom_sheet);
        sheetBehavior = BottomSheetBehavior.from(layoutBottomSheet);
        motorImage = findViewById(R.id.motor);
        carImage = findViewById(R.id.car);
        sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
        sheetBehavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                switch (newState) {
                    case BottomSheetBehavior.STATE_HIDDEN:
                        break;
                    case BottomSheetBehavior.STATE_EXPANDED: {
//                        btnBottomSheet.setText("Close Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_COLLAPSED: {
//                        btnBottomSheet.setText("Expand Sheet");
                    }
                    break;
                    case BottomSheetBehavior.STATE_DRAGGING:
                        break;
                    case BottomSheetBehavior.STATE_SETTLING:
                        break;
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        // Toast.makeText(this, "Map is Ready", Toast.LENGTH_SHORT).show();
        Log.e(TAG, "onMapReady: map is ready");
        mMap = googleMap;
        mMap.setMapStyle(MapStyleOptions.loadRawResourceStyle(this, R.raw.map_style));

        //  init(new LatLng(location.getLatitude(), location.getLongitude()));

//        ArrayList<MarkerData> markersArray = new ArrayList<MarkerData>();


        for(int i = 0 ; i < markersArray.size() ; i++) {
            createMarker(markersArray.get(i), "Title "+i, "Im a driver");
        }

        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(36.7538478,5.0534492), 15.0f));


    }

    private void addLocation() {
        markersArray.add(new LatLng(36.7523842,5.0248746));
        markersArray.add(new LatLng(36.751782,5.0518535));
        markersArray.add(new LatLng(36.7514809,5.0567349));
        markersArray.add(new LatLng(36.7523422,5.0513427));
        markersArray.add(new LatLng(36.7521187,5.0504992));
        markersArray.add(new LatLng(36.752007,5.0572866));
        markersArray.add(new LatLng(36.7503565,5.050881));
        markersArray.add(new LatLng(36.7500298,5.0529605));
    }

    protected Marker createMarker(LatLng location, final String title, String snippet) {

        Marker marker = mMap.addMarker(new MarkerOptions()
                .position(location)
                .anchor(0.5f, 0.5f)
                .title(title)
                .snippet(snippet));


        InfoWindowData info = new InfoWindowData();
        info.setImage("http://dl.hiapphere.com/data/icon/201705/HiAppHere_com_com.leomaz.flix.png");
        info.setHotel(title);
        info.setFood("Food : all types of restaurants available");
        info.setTransport("Reach the site by bus, car and train.");

        mMap.setOnInfoWindowCloseListener(new GoogleMap.OnInfoWindowCloseListener() {
            @Override
            public void onInfoWindowClose(Marker marker) {
                sheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
            }
        });

        CustomInfoWindowGoogleMap customInfoWindow = new CustomInfoWindowGoogleMap(this);
        mMap.setInfoWindowAdapter(customInfoWindow);

        mMap.setOnInfoWindowClickListener(new GoogleMap.OnInfoWindowClickListener() {
            @Override
            public void onInfoWindowClick(Marker marker) {

                    sheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
            }
        });
        marker.setTag(info);
        return marker;
    }

    private void initMap() {
        Log.e(TAG, "Init map");

        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map);

        if (mapFragment != null) {
            mapFragment.getMapAsync(this);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home){
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    public void motorDriver(View view) {
        carImage.setBackgroundResource(R.drawable.edit_text_background);
        motorImage.setBackgroundResource(R.drawable.ic_edit_text_background_shape);
        mMap.clear();
        markersArray.clear();
        addLocationM();
        initMap();
    }

    public void carDriver(View view) {
        carImage.setBackgroundResource(R.drawable.ic_edit_text_background_shape);
        motorImage.setBackgroundResource(R.drawable.edit_text_background);
        mMap.clear();
        markersArray.clear();
        addLocationC();
        initMap();
    }

    private void addLocationM() {
        markersArray.add(new LatLng(36.7523842,5.0248746));
        markersArray.add(new LatLng(36.751782,5.0518535));
        markersArray.add(new LatLng(36.7514809,5.0567349));

    }

    private void addLocationC() {
        markersArray.add(new LatLng(36.7523422,5.0513427));
        markersArray.add(new LatLng(36.7521187,5.0504992));
        markersArray.add(new LatLng(36.752007,5.0572866));
        markersArray.add(new LatLng(36.7503565,5.050881));
        markersArray.add(new LatLng(36.7500298,5.0529605));
    }



}