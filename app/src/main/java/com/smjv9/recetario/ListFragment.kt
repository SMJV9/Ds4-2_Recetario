package com.smjv9.recetario

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.floatingactionbutton.FloatingActionButton

class ListFragment : Fragment() {

    private var countries : MutableList<Rece> = mutableListOf()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?):
            View? {

        val view = inflater.inflate(R.layout.fragment_list, container, false)
        initData()

        val fab = view.findViewById<FloatingActionButton>(R.id.fabadd)

        val adapter = ReceAdapter(countries)


        val recyclerView =
            view.findViewById<RecyclerView>(
                R.id.countriesRecycler
            )


        //Variables para el elemento nuevo
        var _id : Int = 0
        var _name : String
        var _porciones : String
        var _hora  : String
        var _image : String
        

        fab.setOnClickListener {

            // Show Bottom Sheet Dialog and add a new item
            val bottomSheetFragment = BottomSheetDialog(view.context)
            val parentView : View = layoutInflater.inflate(R.layout.bsd_new_rece, null)
            bottomSheetFragment.setContentView(parentView)
            bottomSheetFragment.show()

            //elementos del formulario bsd
            val newId = parentView.findViewById<EditText>(R.id.bsd_id)
            val newname = parentView.findViewById<EditText>(R.id.bsd_comida)
            val newporciones = parentView.findViewById<EditText>(R.id.bsd_porciones)
            val newhora = parentView.findViewById<EditText>(R.id.bsd_hora)
            val newimage = parentView.findViewById<EditText>(R.id.bsd_imagen)

            val button = parentView.findViewById<Button>(R.id.bsd_submit)

            //boton guardar del bsd, asignación de valores y creación del nuevo elemento
            button.setOnClickListener{
                _id = newId.text.toString().toInt()
                _name = newname.text.toString()
                _porciones = newporciones.text.toString()
                _hora = newhora.text.toString()
                _image = newimage.text.toString()

                val newProductAdd = Rece(
                    _id,
                    _name,
                    _porciones,
                    _hora,
                    _image
                )

                countries.add(newProductAdd)
                recyclerView.adapter?.notifyDataSetChanged()
                bottomSheetFragment.dismiss()
            }
        }

        //Lista anchura completa
        val layoutManager = LinearLayoutManager(container?.context)
        //Cuadricula 2X2
        //val gridLayoutManager = GridLayoutManager(container?.context, 2)

        recyclerView?.layoutManager = layoutManager
        recyclerView?.adapter = adapter

        return view
    }

    private fun initData() {

        countries = mutableListOf(
            Rece(1, "Pozole", "6 porciones", "2 hora", "https://media.admagazine.com/photos/618a62f85b87a99cfb816295/4:3/w_4000,h_3000,c_limit/76176.jpg"),
            Rece(2,"Menudo","6 porciones","2 horas","https://animalgourmet.com/wp-content/uploads/2015/12/menudo-sinaloa.jpg"),
            Rece(3,"Chilaquilles","4 porciones", "45 minutos","https://productoschata.com/wp-content/uploads/elementor/thumbs/Chilaquiles-divorciados-con-chilorio_H1-q7vgzbzjuodcfdj0c7j1vsqtgnevwj9isrq3asj3hs.jpg"),
            Rece(4,"Pollo con mole","5 porciones","1:30 a 2 horas","https://assets.elgourmet.com/wp-content/uploads/2023/03/mole-_9IMJjkql3RCWT1eg6AHUD8PKyZLh7o.png"),
            Rece(5,"Enchiladas","6 porciones","1 hora","https://www.gourmet.cl/wp-content/uploads/2021/08/foto-istock-enchilada-tama%C3%B1o-web.jpg"),
            Rece(6,"Cocido","8 porciones","3 horas","https://content-cocina.lecturas.com/medio/2022/09/23/cocido-madrileno_00000000_231003161453_1200x1200.jpg"),
            Rece(7,"Albondigas","4 porciones","1 hora","https://imag.bonviveur.com/albondigas-con-tomate.jpg"),
            Rece(8,"Carne asada","1kg","1 hora","https://saboryestilo.com.mx/wp-content/uploads/2020/01/tips-para-hacer-la-mejor-carne-asada-1200x900.jpg"),
            Rece(9,"Tacos al pastor","1 kg","1 hora","https://www.comedera.com/wp-content/uploads/2017/08/tacos-al-pastor-receta.jpg"),
            Rece(10,"Chimichangas","6 porciones","35 minutos","https://imag.bonviveur.com/chimichanga.jpg"),
            Rece(11,"Ceviche","8 porciones","2 horas","https://cdn-3.expansion.mx/dims4/default/10e9479/2147483647/strip/true/crop/1080x1350+0+0/resize/1800x2250!/format/webp/quality/80/?url=https%3A%2F%2Fcdn-3.expansion.mx%2F76%2Fd8%2F238c51bb46f29eae0281286afd4e%2Fceviche-mexicano.jpg"),
            Rece(12,"Caldo de pollo","6 porciones","1 hora","https://t1.uc.ltmcdn.com/es/posts/3/9/3/como_hacer_sopa_de_pollo_con_fideos_50393_orig.jpg")
        )
    }
}