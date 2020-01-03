package com.example.mymaptry

import android.content.Context
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.maps.*
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MainActivity : AppCompatActivity() {

    lateinit var mapFragment: SupportMapFragment
    lateinit var googleMap: GoogleMap


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        mapFragment = supportFragmentManager.findFragmentById(R.id.map) as SupportMapFragment

        mapFragment.getMapAsync(OnMapReadyCallback {
            googleMap = it
            googleMap.isMyLocationEnabled = true //current location


            //map marker eklemek
            var location1 = LatLng(40.343144, 26.685169)
            googleMap.addMarker(MarkerOptions().position(location1).title("rastgele"))

            // zooming
            googleMap.animateCamera((CameraUpdateFactory.newLatLngZoom(location1, 1f)))
        })


    }

}
