package com.mariobr.terceiraprova.dialogs

import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle

import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.DialogFragment

import com.mariobr.terceiraprova.R

class CustomDialogFragment:DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        return activity?.let {
            // Use the Builder class for convenient dialog construction
            val builder = AlertDialog.Builder(it, android.R.style.Theme_Material_Dialog_MinWidth)
            builder
                .setIcon(android.R.drawable.ic_dialog_info)
                .setTitle(getString(R.string.testar))
                .setMessage("Esta é a tela de cadastro, você deve preencher os respectivos campos para que possa cadastrar um anime no sistema.")
                .setPositiveButton("Confirmar",
                    DialogInterface.OnClickListener { dialog, id ->
                        Toast.makeText(it.baseContext, "Agora preencha os dados!", Toast.LENGTH_SHORT).show()
                    })
            // Create the AlertDialog object and return it
            builder.create()
        } ?: throw IllegalStateException("Activity cannot be null")
    }


}