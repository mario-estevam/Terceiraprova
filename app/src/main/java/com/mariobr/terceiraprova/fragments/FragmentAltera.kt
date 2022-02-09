package com.mariobr.terceiraprova.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.mariobr.terceiraprova.R
import com.mariobr.terceiraprova.databinding.FragmentAlteraBinding
import com.mariobr.terceiraprova.dialogs.DialogAlterar
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

        viewModelAltera.eventAlteraPessoa.observe(viewLifecycleOwner,{ hasChanged ->
            if(hasChanged)  {
                Navigation
                    .findNavController(requireView())
                    .navigate(R.id.fragmentHomeOne)
            }
            viewModelAltera.onAlteraAnimeComplete()
        })

        setHasOptionsMenu(true)
        return bindingAltera.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.ajuda -> {
                val dialog = DialogAlterar()
                dialog.show(requireActivity().supportFragmentManager,"Dialog3")
            }
        }
        return super.onOptionsItemSelected(item)
    }

}