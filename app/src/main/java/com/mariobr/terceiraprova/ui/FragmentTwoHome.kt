package com.mariobr.terceiraprova.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.mariobr.terceiraprova.R
import com.mariobr.terceiraprova.adapters.AnimeAdapterLocal
import com.mariobr.terceiraprova.adapters.NovoRecyclerViewClickListener
import com.mariobr.terceiraprova.databinding.FragmentTwoHomeBinding
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

        viewModelHome.listaAnimes!!.observe(viewLifecycleOwner, {
            adapter.animes = it.toTypedArray()
            adapter.notifyDataSetChanged()
        })

        binding.recyclerView2.addOnItemTouchListener(NovoRecyclerViewClickListener(requireContext(),binding.recyclerView2, object : NovoRecyclerViewClickListener.onItemClickListener{
            override fun onItemClick(v: View, position: Int) {
                Navigation.findNavController(v).navigate(FragmentTwoHomeDirections.actionFragmentTwoHomeToFragmentDetalhes(
                    adapter.animes[position].id.toInt()
                ))
            }
            override fun onItemLongClick(v: View, position: Int) {
                Navigation.findNavController(v).navigate(FragmentTwoHomeDirections.actionFragmentTwoHomeToFragmentAltera(
                    adapter.animes[position].id.toInt()
                ))
            }
        }))
        setHasOptionsMenu(true)
        return binding.root
    }

}