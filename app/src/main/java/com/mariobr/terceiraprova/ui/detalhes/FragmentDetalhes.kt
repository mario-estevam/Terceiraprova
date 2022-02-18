package com.mariobr.terceiraprova.ui.detalhes

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.mariobr.terceiraprova.R
import com.mariobr.terceiraprova.TerceiraProvaApplication
import com.mariobr.terceiraprova.databinding.FragmentDetalhesBinding
import com.mariobr.terceiraprova.util.dialogs.DialogDetalhes


class FragmentDetalhes : Fragment() {

    lateinit var binding:FragmentDetalhesBinding
    lateinit var viewModel: DetalhesViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args: FragmentDetalhesArgs by navArgs()

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detalhes, container, false)
        val viewModelFactory = DetalhesViewModel.Factory(
            args.id.toLong(),
            (requireActivity().application as TerceiraProvaApplication).localRepository
        )
        viewModel = ViewModelProvider(this, viewModelFactory ).get(DetalhesViewModel::class.java)

        binding.viewModelD = viewModel

        binding.lifecycleOwner = this

        setHasOptionsMenu(true)
        return binding.root

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