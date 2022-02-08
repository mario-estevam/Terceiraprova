package com.mariobr.terceiraprova.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.mariobr.terceiraprova.R
import com.mariobr.terceiraprova.databinding.FragmentAlteraBinding
import com.mariobr.terceiraprova.viewModel.AlteraViewModel


class FragmentAltera : Fragment() {

    lateinit var bindingAltera:FragmentAlteraBinding
    lateinit var viewModelAltera: AlteraViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args:FragmentAlteraArgs by navArgs()

        bindingAltera= DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false)
        val viewModelFactory = AlteraViewModel.AlteraFragmentViewModelFactory(requireActivity().application,
            args.id
        )
        viewModelAltera = ViewModelProvider(this,viewModelFactory).get(AlteraViewModel::class.java)

        bindingAltera.alteraViewModel = viewModelAltera
        bindingAltera.lifecycleOwner = this

        bindingAltera.alterar.setOnClickListener {
            viewModelAltera .saveAnime()
            Navigation.findNavController(it).navigate(R.id.fragmentHomeOne)
            Toast.makeText(context, "Dados alterados com sucesso!", Toast.LENGTH_SHORT).show()
        }

        setHasOptionsMenu(true)
        return bindingAltera.root
    }

}