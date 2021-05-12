package com.example.locationsharingclient

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ServiceAdapter(private val services: List<Service>) : RecyclerView.Adapter<ServiceAdapter.ServiceViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.service_item, parent, false)

        return ServiceViewHolder(view)
    }

    override fun getItemCount() : Int = services.size

    override fun onBindViewHolder(holder: ServiceViewHolder, position: Int) {
        val service = services[position]
        holder.name.text = service.name
        holder.latitude.text = service.latitude.toString()
        holder.longitude.text = service.longitude.toString()
    }

    class ServiceViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        // TODO: Synthetic properties
        val name: TextView = view.findViewById(R.id.service_name)
        val latitude: TextView = view.findViewById(R.id.latitude)
        val longitude: TextView = view.findViewById(R.id.longitude)
    }
}