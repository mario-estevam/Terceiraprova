package com.mariobr.terceiraprova.ui.cadastro

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.mariobr.terceiraprova.R
import com.mariobr.terceiraprova.TerceiraProvaApplication
import com.mariobr.terceiraprova.databinding.FragmentCadastroBinding
import com.mariobr.terceiraprova.util.dialogs.CustomDialogFragment


class FragmentCadastro : Fragment() {

    lateinit var binding:FragmentCadastroBinding
    lateinit var viewModel: CadastroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cadastro, container, false)
        val viewModelFactory = CadastroViewModel.Factory((requireActivity().application as TerceiraProvaApplication).localRepository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(CadastroViewModel::class.java)
        binding.viewModel = viewModel

        binding.lifecycleOwner = this

        setHasOptionsMenu(true)
        // a navegação nao pode ser feita no viewModel, mas podemos aqui observar o evento que ocorre pra realizar a navegação
        viewModel.eventCadastroAnime.observe(viewLifecycleOwner, { hasChanged ->
            if (hasChanged){ // se o evento está ocorrendo ele vai navegar pra home
                Navigation.findNavController(requireView()).navigate(FragmentCadastroDirections.actionFragmentCadastroToFragmentTwoHome())
                viewModel.onCadastroAnimeComplete()
            }
        })

        return binding.root
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