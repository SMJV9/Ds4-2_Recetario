package com.smjv9.recetario

import android.app.Activity
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso


class ReceAdapter(private var Rece: List<Rece>):
    RecyclerView.Adapter<ReceAdapter.ReceViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReceViewHolder {

        val inflador = LayoutInflater.from(parent.context)

        val view = inflador.inflate(R.layout.item_rece, parent, false)
        return ReceViewHolder(view)
    }

    override fun onBindViewHolder(holder: ReceViewHolder, position: Int) {
        val rece = Rece[position]
        holder.render(rece)

        //aquí se aplica la lógica. ej: onClickListener
    }

    override fun getItemCount(): Int {
        return Rece.size
    }

    class ReceViewHolder(view: View): RecyclerView.ViewHolder(view) {

        val name: TextView = view.findViewById(R.id.country_name)
        val capital: TextView = view.findViewById(R.id.country_capital)
        val continent: TextView = view.findViewById(R.id.country_continent)
        val image: ImageView = view.findViewById(R.id.country_image)

        fun render(country: Rece) {
            name.text = country.name + ", "
            capital.text = country.porciones
            continent.text = country.horas
            Picasso.get().load(country.image).into(image)
        }
    }
}