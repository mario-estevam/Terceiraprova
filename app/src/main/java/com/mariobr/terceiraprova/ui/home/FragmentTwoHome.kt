package com.mariobr.terceiraprova.ui.home

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.mariobr.terceiraprova.R
import com.mariobr.terceiraprova.TerceiraProvaApplication
import com.mariobr.terceiraprova.ui.home.adapter.AnimeAdapterLocal
import com.mariobr.terceiraprova.util.ReciclerViewClickListener

import com.mariobr.terceiraprova.databinding.FragmentTwoHomeBinding
import com.mariobr.terceiraprova.dialogs.DialogHome


class FragmentTwoHome : Fragment() {


    lateinit var binding:FragmentTwoHomeBinding
    lateinit var viewModel: HomeTwoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_two_home, container, false)
        val viewModelFactory = HomeTwoViewModel.Factory((requireActivity().application as TerceiraProvaApplication).localRepository)
        viewModel = ViewModelProvider(this, viewModelFactory).get(HomeTwoViewModel::class.java)

        val adapter = AnimeAdapterLocal()
        binding.recyclerView2.adapter = adapter


        viewModel.list.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })

        binding.recyclerView2.addOnItemTouchListener(ReciclerViewClickListener(binding.recyclerView2, object :
            ReciclerViewClickListener.OnItemClickListener {
            override fun onItemClick(view: View, position: Int) {
                Navigation.findNavController(view).navigate(FragmentTwoHomeDirections.actionFragmentTwoHomeToFragmentDetalhes(adapter.currentList[position].id.toInt()))
            }

            override fun onItemLongClick(view: View, position: Int) {
                Navigation.findNavController(view).navigate(FragmentTwoHomeDirections.actionFragmentTwoHomeToFragmentAltera(adapter.currentList[position].id.toInt()))
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


