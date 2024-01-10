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
import com.example.yajhztask.databinding.FragmentSignupBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

@AndroidEntryPoint
class signup : Fragment() {
    lateinit var binding: FragmentSignupBinding
    private val viewModel: AuthViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.toSignUP.setOnClickListener(object :OnClickListener{
            override fun onClick(p0: View?) {
                this@signup.findNavController().navigate(R.id.action_signup_to_login)
            }

        })
        binding.reg.setOnClickListener(object :View.OnClickListener{
            override fun onClick(v: View?) {
                viewModel.register(binding.name.text.toString(),binding.emailReg.text.toString()
                ,binding.passwordReg.text.toString(),binding.passwordReg.text.toString(),Consts.DIVICE_TOKEN)
                lifecycleScope.launch {
                    viewModel.register.collect{
                        when(it){
                            is ResponseState.OnError -> {
                                Toast.makeText(requireContext(),it.message, Toast.LENGTH_LONG).show()
                            }
                            is ResponseState.OnLoading -> {

                            }
                            is ResponseState.OnSuccess -> {
                                if(it.response.success){
                                    Names.userName=it.response.data.name
                                    Names.userAddress="Temp/Temp"
                                    this@signup.findNavController().navigate(R.id.action_signup_to_home)
                                }else{
                                    Toast.makeText(requireContext(),"Registration failed due to ${it.response.message}",
                                        Toast.LENGTH_LONG).show()
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
        binding=FragmentSignupBinding.inflate(inflater,container,false)

        return binding.root
    }


}