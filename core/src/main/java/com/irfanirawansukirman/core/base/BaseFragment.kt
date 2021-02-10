package com.irfanirawansukirman.core.base

import android.app.Application
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.irfanirawansukirman.core.util.viewmodel.ViewModelFactory
import javax.inject.Inject

/**
 * Created by Irfan Irawan Sukirman on 2/9/21 at Bandung City
 * Copyright (c) 2021 PT. Haruka Evolusi Digital Utama. All rights reserved.
 */
abstract class BaseFragment<VB : ViewBinding, VM : BaseVM>(
    private val viewBinder: (LayoutInflater) -> ViewBinding
) : Fragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelFactory

    val viewBinding by lazy { viewBinder.invoke(LayoutInflater.from(requireContext())) as VB }
    val viewModel: VM by lazy {
        ViewModelProvider(viewModelStore, viewModelFactory).get(getViewModel())
    }
    val activity by lazy { (requireActivity() as BaseActivity) }
    val contextFragment by lazy { requireContext() }

    private var isViewCreated = false
    private var isComponentCreated = false

    abstract fun onLoadVM(viewModel: VM)
    abstract fun getViewModel(): Class<VM>
    abstract fun initInjector()
    abstract fun initComponent()
    abstract fun initViewListener()
    abstract fun onViewReady(savedInstanceState: Bundle?, view: View)
    abstract fun onClear()

    override fun onCreate(savedInstanceState: Bundle?) {
        initInjector()
        super.onCreate(savedInstanceState)
        if (!isComponentCreated) {
            initComponent()
            isComponentCreated = true
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return viewBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if (!isViewCreated) {
            onViewReady(savedInstanceState, view)
            initViewListener()
            onLoadVM(viewModel)
            isViewCreated = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        onClear()
    }

    fun getApplication(): Application = (requireContext() as BaseActivity).application
}