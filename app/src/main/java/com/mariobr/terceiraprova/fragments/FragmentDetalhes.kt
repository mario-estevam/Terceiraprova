package com.mariobr.terceiraprova.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.mariobr.terceiraprova.R
import com.mariobr.terceiraprova.databinding.FragmentDetalhesBinding
import com.mariobr.terceiraprova.dialogs.DialogDetalhes
import com.mariobr.terceiraprova.viewModel.DetalhesViewModel


class FragmentDetalhes : Fragment() {

    lateinit var bindingD:FragmentDetalhesBinding
    lateinit var viewModelD: DetalhesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args:FragmentDetalhesArgs by navArgs()
        bindingD= DataBindingUtil.inflate(inflater, R.layout.fragment_detalhes, container, false)
        val viewModelFactory = DetalhesViewModel.DetalhesFragmentViewModelFactory(requireActivity().application, args.id)
        viewModelD = ViewModelProvider(this, viewModelFactory).get(DetalhesViewModel::class.java)

        bindingD.viewModelD = viewModelD
        bindingD.lifecycleOwner = this

        setHasOptionsMenu(true)
        return bindingD.root

    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.ajuda -> {
                val dialog = DialogDetalhes()
                dialog.show(requireActivity().supportFragmentManager,"Dialog3")
            }
        }
        return super.onOptionsItemSelected(item)
    }


}