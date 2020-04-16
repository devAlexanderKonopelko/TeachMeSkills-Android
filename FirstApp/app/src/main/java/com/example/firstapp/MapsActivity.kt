package com.example.firstapp

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import android.location.LocationListener
import android.location.LocationManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.material.dialog.MaterialAlertDialogBuilder

private const val LOCATION_PERMISSION_REQUEST_CODE = 1

class MapsActivity : AppCompatActivity(), OnMapReadyCallback,
    GoogleMap.OnMyLocationButtonClickListener,
    GoogleMap.OnMyLocationClickListener, LocationListener {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
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
        mMap.setOnMapLongClickListener { latLng ->
            showMarkerDialog(latLng)
        }

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))

        enableMyLocation()
        mMap.setOnMyLocationButtonClickListener(this)
        mMap.setOnMyLocationClickListener(this)

        val locationManager = getSystemService(Context.LOCATION_SERVICE) as LocationManager
        if (ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                this,
                Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ),
                LOCATION_PERMISSION_REQUEST_CODE
            )
            return
        }
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 1F, this)
    }

    override fun onMyLocationButtonClick(): Boolean {
        return false
    }

    override fun onMyLocationClick(p0: Location) {
        Toast.makeText(this, "Current location: $p0", Toast.LENGTH_SHORT).show()
    }

    override fun onLocationChanged(location: Location?) {
        mMap.animateCamera(CameraUpdateFactory.newLatLng(location?.latitude?.let { lat ->
            LatLng(
                lat,
                location.longitude
            )
        }))
    }

    override fun onStatusChanged(provider: String?, status: Int, extras: Bundle?) {
        //TODO("not implemented") To change body of created functions use File | Settings | File Templates.
    }

    override fun onProviderEnabled(provider: String?) {

    }

    override fun onProviderDisabled(provider: String?) {
        //TODO("not implemented") To change body of created functions use File | Settings | File Templates.
    }

    private fun enableMyLocation() {
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
            == PackageManager.PERMISSION_GRANTED
        ) {
            if (mMap != null) {
                mMap.isMyLocationEnabled = true
            }
        } else {
            // Permission to access the location is missing. Show rationale and request permission
            ActivityCompat.requestPermissions(
                this,
                arrayOf(
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ),
                LOCATION_PERMISSION_REQUEST_CODE
            )
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        if (requestCode != LOCATION_PERMISSION_REQUEST_CODE) {
            return
        }
        if (ActivityCompat
                .checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) ==
            PackageManager.PERMISSION_GRANTED
        ) { // Enable the my location layer if the permission has been granted.
            enableMyLocation()
        } else { // Permission was denied. Display an error message
// ...
        }

    }

    private fun showMarkerDialog(latLng: LatLng) {
        val editText = EditText(this)
        MaterialAlertDialogBuilder(this)
            .setTitle("Добавить метку")
            .setMessage("Введите название метки")
            .setView(editText)
            .setPositiveButton("OK") { dialog, which ->
                mMap.addMarker(MarkerOptions().position(latLng).title(editText.text.toString()))
            }.show()
    }

    fun ChangeType(view: View) {
        if (mMap.mapType == GoogleMap.MAP_TYPE_NORMAL) {
            mMap.mapType = GoogleMap.MAP_TYPE_SATELLITE
        } else if (mMap.mapType == GoogleMap.MAP_TYPE_SATELLITE) {
            mMap.mapType = GoogleMap.MAP_TYPE_TERRAIN
        } else if (mMap.mapType == GoogleMap.MAP_TYPE_TERRAIN) {
            mMap.mapType = GoogleMap.MAP_TYPE_HYBRID
        } else if (mMap.mapType == GoogleMap.MAP_TYPE_HYBRID) {
            mMap.mapType = GoogleMap.MAP_TYPE_NORMAL
        }
    }
}