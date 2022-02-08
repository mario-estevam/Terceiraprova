package com.mariobr.terceiraprova.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.mariobr.terceiraprova.R
import com.mariobr.terceiraprova.databinding.FragmentDetalhesBinding
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


}