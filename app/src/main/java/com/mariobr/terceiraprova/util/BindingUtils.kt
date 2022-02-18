package com.mariobr.terceiraprova.util

import android.widget.EditText
import android.widget.TextView
import androidx.databinding.BindingAdapter


@BindingAdapter("epsAsText")
fun TextView.setEpsAsText(eps:Int?){
    eps?.let {
        it.toString()
    }
}

@BindingAdapter("classAsText")
fun TextView.setClasAsText(classificacao:Int?){
    classificacao?.let {
        it.toString()
    }
}

@BindingAdapter("anoAsText")
fun TextView.setAnoAsText(ano:Int?){
    ano?.let {
        it.toString()
    }
}


