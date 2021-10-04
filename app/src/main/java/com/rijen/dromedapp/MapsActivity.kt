package com.rijen.dromedapp

import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.app.ActivityCompat
import com.google.android.gms.common.ConnectionResult
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.location.FusedLocationProviderClient

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback, GoogleApiClient.ConnectionCallbacks,GoogleApiClient.OnConnectionFailedListener{

    private lateinit var mMap: GoogleMap
    var permissions = arrayOf(
        android.Manifest.permission.ACCESS_FINE_LOCATION,
        android.Manifest.permission.ACCESS_COARSE_LOCATION
    )
    private lateinit var myLocation: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        if(!checkPermissions())
        {
            requestPermissions()
        }
        initialize()
    }

    private fun requestPermissions()
    {
        ActivityCompat.requestPermissions(this@MapsActivity,permissions,1)
    }
    private fun initialize()
    {
        myLocation = FusedLocationProviderClient(this@MapsActivity)
        getCurrentLocation()
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    private fun getCurrentLocation()
    {
        if (ActivityCompat.checkSelfPermission(
                this,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) == PackageManager.PERMISSION_GRANTED
        ) {
            myLocation.lastLocation.addOnSuccessListener {
                if(it!=null)
                {
                    addLocationMarker(it.latitude,it.longitude)
                    if(it.hasAccuracy())
                    {
                        Toast.makeText(this@MapsActivity, "Accuracy", Toast.LENGTH_SHORT).show()
                    }
                    else
                    {
                        Toast.makeText(this@MapsActivity, "No Accuracy", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
        else
        {
            println("dasdsad")
        }
    }
    private fun addLocationMarker(lat:Double,lon:Double)
    {
        val clientLocation = LatLng(lat, lon)
        mMap.addMarker(MarkerOptions().position(clientLocation).title("Mero Med"))
        mMap.animateCamera(
            CameraUpdateFactory.newLatLngZoom(LatLng(27.708317, 85.320581), 17F), 3000, null
        )
        mMap.uiSettings.isZoomControlsEnabled = true
    }

    private fun checkPermissions():Boolean
    {
        var flag = true
        for(i in permissions)
        {
            if(ActivityCompat.checkSelfPermission(this@MapsActivity,i) != PackageManager.PERMISSION_GRANTED)
            {
                flag = false
            }
        }
        return flag
    }



    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val egKtm = LatLng(27.708317, 85.320581)
        mMap.addMarker(MarkerOptions().position(egKtm).title("Mero Med.")
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_AZURE))
        )

    }

    override fun onConnected(p0: Bundle?) {
        TODO("Not yet implemented")
    }

    override fun onConnectionSuspended(p0: Int) {
        TODO("Not yet implemented")
    }

    override fun onConnectionFailed(p0: ConnectionResult) {
        TODO("Not yet implemented")
    }
}