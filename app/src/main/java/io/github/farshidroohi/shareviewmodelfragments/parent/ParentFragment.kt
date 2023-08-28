package io.github.farshidroohi.shareviewmodelfragments.parent

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import io.github.farshidroohi.shareviewmodelfragments.databinding.FragmentParentBinding

class ParentFragment : Fragment() {

    private val viewModel: ParentShareViewModel by viewModels()

    private var _binding: FragmentParentBinding? = null
    private val binding: FragmentParentBinding get() = _binding!!

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

        binding.btnIncrease.setOnClickListener { viewModel.increaseValue() }
        binding.btnReduce.setOnClickListener { viewModel.reduceValue() }
    }
}