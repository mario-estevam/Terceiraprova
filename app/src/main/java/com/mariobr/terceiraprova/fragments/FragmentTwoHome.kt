package com.mariobr.terceiraprova.fragments

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.mariobr.terceiraprova.R
import com.mariobr.terceiraprova.adapters.AnimeAdapterLocal
import com.mariobr.terceiraprova.adapters.NovoReciclerViewClickListener

import com.mariobr.terceiraprova.databinding.FragmentTwoHomeBinding
import com.mariobr.terceiraprova.dialogs.DialogHome
import com.mariobr.terceiraprova.viewModel.HomeTwoViewModel



class FragmentTwoHome : Fragment() {


    lateinit var binding:FragmentTwoHomeBinding
    lateinit var viewModelHome: HomeTwoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_two_home, container, false)
        viewModelHome = ViewModelProvider(this).get(HomeTwoViewModel::class.java)

        val adapter  = AnimeAdapterLocal()

            binding.recyclerView2.adapter = adapter

            viewModelHome.listaAnimes!!.observe(viewLifecycleOwner, { list ->
                adapter.submitList(list)
            })

        binding.recyclerView2.addOnItemTouchListener(NovoReciclerViewClickListener(binding.recyclerView2, object : NovoReciclerViewClickListener.OnItemClickListener{
            override fun onItemClick(v: View, position: Int) {
                Navigation.findNavController(binding.recyclerView2).navigate(FragmentTwoHomeDirections.actionFragmentTwoHomeToFragmentDetalhes(
                    adapter.currentList[position].id.toInt()
                ))
            }
            override fun onItemLongClick(v: View, position: Int) {
                Navigation.findNavController(binding.recyclerView2).navigate(FragmentTwoHomeDirections.actionFragmentTwoHomeToFragmentAltera(
                    adapter.currentList[position].id.toInt()
                ))
            }
        }))
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
                val dialog = DialogHome()
                dialog.show(requireActivity().supportFragmentManager,"Dialog3")
            }
        }
        return super.onOptionsItemSelected(item)
    }




}