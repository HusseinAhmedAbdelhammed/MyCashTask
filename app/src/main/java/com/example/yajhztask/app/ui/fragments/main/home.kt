package com.example.yajhztask.app.ui.fragments.main

import android.Manifest
import android.app.AlertDialog
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.yajhztask.R
import com.example.yajhztask.app.state.ResponseState
import com.example.yajhztask.app.ui.helpers.HasPermission
import com.example.yajhztask.app.ui.helpers.Names
import com.example.yajhztask.app.ui.recyclertools.cat.CatAdapter
import com.example.yajhztask.app.ui.recyclertools.popular.PopularAdapter
import com.example.yajhztask.app.ui.recyclertools.trending.TrendingAdapter
import com.example.yajhztask.app.viewmodel.AuthViewModel
import com.example.yajhztask.app.viewmodel.HomeViewModel
import com.example.yajhztask.databinding.FragmentHomeBinding
import com.example.yajhztask.databinding.FragmentLoginBinding
import com.example.yajhztask.databinding.FragmentSignupBinding
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel
import pub.devrel.easypermissions.AppSettingsDialog
import pub.devrel.easypermissions.EasyPermissions

@AndroidEntryPoint
class home : Fragment(){
    lateinit var binding: FragmentHomeBinding
    lateinit var fusedLocation:FusedLocationProviderClient
    lateinit var catAdapter: CatAdapter
    lateinit var popularAdapter: PopularAdapter
    lateinit var trendingAdapter: TrendingAdapter
    private val viewModel: HomeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fusedLocation = LocationServices.getFusedLocationProviderClient(requireActivity())

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.userName.text = Names.userName
        binding.address.text = "NON"

        viewModel.getHomeCategory()
        lifecycleScope.launch {
            viewModel.homeCat.collect{
                when(it){
                    is ResponseState.OnError -> {

                    }
                    is ResponseState.OnLoading -> {

                    }
                    is ResponseState.OnSuccess -> {
                        catAdapter= CatAdapter(requireContext())
                        catAdapter.submitList(it.response.data.data)
                        binding.catRecycler.apply {
                            adapter = catAdapter
                            layoutManager= LinearLayoutManager(context).apply {
                                orientation= RecyclerView.HORIZONTAL
                            }
                            viewModel.getPopularSeller(30.1,40.1,1)
                            viewModel.popularSellers.collect{
                                when(it){
                                    is ResponseState.OnError -> {

                                    }
                                    is ResponseState.OnLoading -> {

                                    }
                                    is ResponseState.OnSuccess -> {
                                        popularAdapter = PopularAdapter(requireContext())
                                        popularAdapter.submitList(it.response.data)
                                        binding.popularRecycler.apply {
                                            adapter=popularAdapter
                                            layoutManager= LinearLayoutManager(context).apply {
                                                orientation= RecyclerView.HORIZONTAL
                                            }
                                        }
                                        viewModel.getTrendSellers(30.1,40.1,1)
                                        viewModel.trendingSellers.collect{
                                            when(it){
                                                is ResponseState.OnError -> {

                                                }
                                                is ResponseState.OnLoading -> {

                                                }
                                                is ResponseState.OnSuccess -> {
                                                    trendingAdapter = TrendingAdapter(requireContext())
                                                    trendingAdapter.submitList(it.response.data)
                                                    binding.trendingRecycler.apply{
                                                        adapter=trendingAdapter
                                                        layoutManager= LinearLayoutManager(context).apply {
                                                            orientation= RecyclerView.HORIZONTAL
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }




    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding= FragmentHomeBinding.inflate(inflater,container,false)

        return binding.root
    }






}