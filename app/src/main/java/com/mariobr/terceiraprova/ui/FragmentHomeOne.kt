package com.mariobr.terceiraprova.ui



import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.mariobr.terceiraprova.R
import com.mariobr.terceiraprova.adapters.NovoAnimeAdapter
import com.mariobr.terceiraprova.adapters.NovoRecyclerViewClickListener
import com.mariobr.terceiraprova.databinding.FragmentHomeOneBinding
import com.mariobr.terceiraprova.model.Anime
import com.mariobr.terceiraprova.model.AnimeLocal
import com.mariobr.terceiraprova.viewModel.AnimeViewModel
import org.koin.android.viewmodel.ext.android.viewModel


class FragmentHomeOne : Fragment() {

    private val viewModel: AnimeViewModel by viewModel()
    lateinit var binding: FragmentHomeOneBinding

    var anime = AnimeLocal()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home_one, container, false)
        val adapter  = NovoAnimeAdapter()
        binding.recyclerView.adapter = adapter

        Thread{
            while(true){
                Thread.sleep(2000)
                this.requireActivity().runOnUiThread{
                    try {
                        if ( view != null) {
                            viewModel.listarTodos()!!.observe(viewLifecycleOwner, {
                                viewModel.recebe(it as Array<Anime>)
                                adapter.animes = viewModel.lista
                                adapter.notifyDataSetChanged()
                            })
                        }
                    }catch (e:ArrayIndexOutOfBoundsException ) {
                        Toast.makeText(context, e.toString(), Toast.LENGTH_SHORT).show()
                    }

                }
            }
        }.start()


        binding.recyclerView.addOnItemTouchListener(NovoRecyclerViewClickListener(requireContext(),binding.recyclerView, object : NovoRecyclerViewClickListener.onItemClickListener{
            override fun onItemClick(v: View, position: Int) {

            }
            override fun onItemLongClick(v: View, position: Int) {

            }
        }))

       return binding.root
    }


}



