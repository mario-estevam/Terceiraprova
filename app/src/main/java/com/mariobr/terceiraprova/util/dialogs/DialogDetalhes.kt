package com.mariobr.terceiraprova.util.dialogs
import android.annotation.SuppressLint
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle

import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

import com.mariobr.terceiraprova.R

class DialogDetalhes: DialogFragment() {

    @SuppressLint("InlinedApi")
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it, android.R.style.Theme_Material_Dialog_MinWidth)
            builder
                .setIcon(android.R.drawable.ic_dialog_info)
                .setTitle(getString(R.string.tela_detalhes))
                .setMessage("Esta é a tela de Detalhes, nesta tela são exibidos os detalhes do anime que você selecionou.")
                .setPositiveButton("Confirmar",
                    DialogInterface.OnClickListener { dialog, id ->

                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }

}