package com.emifra9.cellphones.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.emifra9.cellphones.databinding.MainFragmentBinding
import dagger.hilt.android.AndroidEntryPoint



@AndroidEntryPoint
class MainFragment : Fragment(), MobileAdapter.OnMobileClicked {

    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainViewModel by viewModels()

    private val adapter = MobileAdapter()

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getMobiles()
        binding.recyclerview.layoutManager = GridLayoutManager(context,2)
        binding.recyclerview.adapter = adapter
        adapter.setOnClickMobile(this)
        viewModel.mobilesLiveData.observe(viewLifecycleOwner, {
            if (it.count() > 0) {
                binding.noData.visibility = GONE
                adapter.setMobilesList(it)
                binding.recyclerview.visibility = VISIBLE
            }
        })
        viewModel.isLoading.observe(viewLifecycleOwner, {
            if (it)
               binding.progressHorizontal.visibility = VISIBLE
            else
                binding.progressHorizontal.visibility = GONE
        })


    }

    override fun onMobileClick(position: Int) {
        val bundle = Bundle()
        bundle.putInt("id", position)
        val modalBottomSheet = ModalBottomSheet()
        modalBottomSheet.arguments = bundle;
        modalBottomSheet.show(childFragmentManager, ModalBottomSheet.TAG)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}