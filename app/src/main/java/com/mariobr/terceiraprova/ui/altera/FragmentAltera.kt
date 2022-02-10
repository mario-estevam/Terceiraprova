package com.mariobr.terceiraprova.ui.altera

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.mariobr.terceiraprova.R
import com.mariobr.terceiraprova.TerceiraProvaApplication
import com.mariobr.terceiraprova.databinding.FragmentAlteraBinding
import com.mariobr.terceiraprova.dialogs.DialogAlterar


class FragmentAltera : Fragment() {

    lateinit var binding:FragmentAlteraBinding
    lateinit var viewModel: AlteraViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val args: FragmentAlteraArgs by navArgs()
        val viewModelFactory = AlteraViewModel.Factory(
            args.id.toLong(),
            (requireActivity().application as TerceiraProvaApplication).localRepository
        )
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_altera, container, false)
        viewModel = ViewModelProvider(this, viewModelFactory).get(AlteraViewModel::class.java)

        binding.alteraViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.eventAlteraAnime.observe(viewLifecycleOwner, { hasChanged ->
            if (hasChanged) {
                Navigation.findNavController(requireView())
                    .navigate(R.id.fragmentTwoHome)
                viewModel.onAlteraPessoaComplete()
            }
        })

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
                val dialog = DialogAlterar()
                dialog.show(requireActivity().supportFragmentManager,"Dialog3")
            }
        }
        return super.onOptionsItemSelected(item)
    }

}