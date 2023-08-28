package io.github.farshidroohi.shareviewmodelfragments.parent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import io.github.farshidroohi.shareviewmodelfragments.databinding.FragmentParentBinding
import io.github.farshidroohi.shareviewmodelfragments.parent.viewpager.ViewPagerAdapter
import kotlinx.coroutines.launch

class ParentFragment : Fragment() {

    private val viewModel: ParentShareViewModel by viewModels()

    private var _binding: FragmentParentBinding? = null
    private val binding: FragmentParentBinding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        lifecycleScope.launch {
            lifecycle.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiStateSharedFlow.collect { state ->
                    binding.layoutCounter.txtCounter.text = state.number.toString()
                }
            }
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentParentBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.layoutCounter.btnIncrease.setOnClickListener { viewModel.increaseValue() }
        binding.layoutCounter.btnReduce.setOnClickListener { viewModel.reduceValue() }

        initViewPager()
    }

    private fun initViewPager() {
        val adapter = ViewPagerAdapter(childFragmentManager, lifecycle)
        binding.viewpager.adapter = adapter

    }
}