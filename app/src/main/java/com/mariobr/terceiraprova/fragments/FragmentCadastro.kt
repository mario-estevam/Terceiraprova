package com.mariobr.terceiraprova.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.mariobr.terceiraprova.R
import com.mariobr.terceiraprova.databinding.FragmentCadastroBinding
import com.mariobr.terceiraprova.dialogs.CustomDialogFragment
import com.mariobr.terceiraprova.viewModel.CadastroViewModel


class FragmentCadastro : Fragment() {

    lateinit var bindingCadastro:FragmentCadastroBinding
    lateinit var viewModel: CadastroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        bindingCadastro= DataBindingUtil.inflate(inflater, R.layout.fragment_cadastro, container, false)
        viewModel = ViewModelProvider(this).get(CadastroViewModel::class.java)

        bindingCadastro.viewModel = viewModel
        bindingCadastro.cadastrar.setOnClickListener {
            viewModel.cadastraAnime()
            Navigation.findNavController(it).navigate(R.id.fragmentHomeOne)
            Toast.makeText(context, "Cadastrado com sucesso!", Toast.LENGTH_SHORT).show()
        }

        setHasOptionsMenu(true)
        return bindingCadastro.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.ajuda -> {
                val dialog = CustomDialogFragment()
                dialog.show(requireActivity().supportFragmentManager,"Dialog3")
            }
        }
        return super.onOptionsItemSelected(item)
    }


}