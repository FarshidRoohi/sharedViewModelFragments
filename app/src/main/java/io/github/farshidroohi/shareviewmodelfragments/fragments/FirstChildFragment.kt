package io.github.farshidroohi.shareviewmodelfragments.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import io.github.farshidroohi.shareviewmodelfragments.databinding.FragmentFirstChildBinding
import io.github.farshidroohi.shareviewmodelfragments.parent.ParentShareViewModel
import kotlinx.coroutines.launch

class FirstChildFragment : Fragment() {

    private val viewModel: ParentShareViewModel by viewModels({ requireParentFragment() })

    private var _binding: FragmentFirstChildBinding? = null
    private val binding: FragmentFirstChildBinding get() = _binding!!

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
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentFirstChildBinding.inflate(inflater, container, false)
        return _binding!!.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.txtTitle.text = this.javaClass.simpleName

        binding.layoutCounter.btnIncrease.setOnClickListener {
            viewModel.increaseValue()
        }
        binding.layoutCounter.btnReduce.setOnClickListener {
            viewModel.reduceValue()
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = FirstChildFragment()
    }
}