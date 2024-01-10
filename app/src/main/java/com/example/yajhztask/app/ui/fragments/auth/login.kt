package com.example.yajhztask.app.ui.fragments.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController

import com.example.yajhztask.R
import com.example.yajhztask.app.Consts
import com.example.yajhztask.app.state.ResponseState
import com.example.yajhztask.app.ui.helpers.Names
import com.example.yajhztask.app.viewmodel.AuthViewModel
import com.example.yajhztask.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

@AndroidEntryPoint
class login : Fragment() {
   lateinit var binding:FragmentLoginBinding
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toSignUP.setOnClickListener(object :OnClickListener{
            override fun onClick(p0: View?) {
                this@login.findNavController().navigate(R.id.action_login_to_signup)
            }

        })
        binding.log.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                viewModel.logIN(binding.emailLog.text.toString(),binding.password.text.toString(),Consts.DIVICE_TOKEN)
                lifecycleScope.launch {
                    viewModel.logIn.collect{
                        when(it){
                            is ResponseState.OnError -> {
                                Toast.makeText(requireContext(),it.message,Toast.LENGTH_LONG).show()
                            }
                            is ResponseState.OnLoading -> {

                            }
                            is ResponseState.OnSuccess -> {
                                if(it.response.success){

                                    Names.userName=it.response.data.name
                                    Names.userAddress=it.response.data.addresses.get(0).street+"/"+it.response.data.addresses.get(0).apartment
                                    this@login.findNavController().navigate(R.id.action_login_to_home)
                                }else{
                                    Toast.makeText(requireContext(),"Login Failed please register or check your password",Toast.LENGTH_LONG).show()
                                }
                            }
                        }
                    }
                }
            }

        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentLoginBinding.inflate(inflater,container,false)

        return binding.root
    }


}