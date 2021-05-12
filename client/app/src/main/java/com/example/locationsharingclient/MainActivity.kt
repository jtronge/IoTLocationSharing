package com.example.locationsharingclient

import android.Manifest
import android.content.pm.PackageManager
import android.location.Location
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.core.app.ActivityCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.JsonArrayRequest
import com.android.volley.toolbox.Volley
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.google.android.gms.location.LocationServices.*
import com.google.gson.Gson
import org.json.JSONArray
import kotlin.reflect.typeOf

class MainActivity : AppCompatActivity() {

    // private lateinit var fusedLocationClient: FusedLocationProviderClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var services = ArrayList<Service>()
        val servicesView: RecyclerView = findViewById(R.id.services_view)
        val adapter = ServiceAdapter(services)
        servicesView.adapter = adapter;
        servicesView.layoutManager = LinearLayoutManager(this)

        val queue = Volley.newRequestQueue(this)
        var request = JsonArrayRequest(
            Request.Method.GET, getString(R.string.server_url) + "/services", null,
            Response.Listener { response: JSONArray ->
                val gson = Gson()
                for (i in 0 until response.length()) {
                    val service = gson.fromJson(response[i].toString(), Service::class.java)
                    services.add(service)
                    //services.add(Service(response[i].toString(), 0.0, 0.8))
                    //Service.
                }
                adapter.notifyDataSetChanged()
            },
            Response.ErrorListener { error ->
                // TODO
            })
        queue.add(request)
    }
}