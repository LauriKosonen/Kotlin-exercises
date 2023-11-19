package com.example.e10favouritecities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.example.e10favouritecities.databinding.ActivityMapsBinding
import com.google.android.gms.maps.model.LatLngBounds

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
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
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        // Add a marker in Sydney and move the camera
        val jyvaskyla = LatLng(62.14, 25.43)
        mMap.addMarker(MarkerOptions().position(jyvaskyla).title("Marker in Jyväskylä"))

        val tampere = LatLng(61.3, 23.5)
        mMap.addMarker(MarkerOptions().position(tampere).title("Marker in Tampere"))

        val valkeakoski = LatLng(61.15, 24.01)
        mMap.addMarker(MarkerOptions().position(valkeakoski).title("Marker in Valkeakoski"))

        val helsinki = LatLng(60.1, 24.56)
        mMap.addMarker(MarkerOptions().position(helsinki).title("Marker in Helsinki"))

        val turku = LatLng(60.27, 22.16)
        mMap.addMarker(MarkerOptions().position(turku).title("Marker in Turku"))


        // zoom
        val boundsBuilder = LatLngBounds.builder()
            .include(jyvaskyla)
            .include(tampere)
            .include(valkeakoski)
            .include(helsinki)
            .include(turku)

        val bounds = boundsBuilder.build()

        val padding = 500
        val cameraUpdate = CameraUpdateFactory.newLatLngBounds(bounds, padding)
        mMap.moveCamera(cameraUpdate)

    }
}