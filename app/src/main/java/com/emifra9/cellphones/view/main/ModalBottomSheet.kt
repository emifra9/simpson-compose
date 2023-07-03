package com.emifra9.cellphones.view.main

import android.os.Build
import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.emifra9.cellphones.viewmodel.MainViewModel
import com.emifra9.cellphones.databinding.BottomSheetDialogBinding
import com.emifra9.cellphones.view.main.adapters.ImageAdapter
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class ModalBottomSheet : BottomSheetDialogFragment() {


    private val viewModel: MainViewModel by viewModels()
    private var _binding: BottomSheetDialogBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = BottomSheetDialogBinding.inflate(inflater, container, false)
        return binding.root
    }

    companion object {
        const val TAG = "ModalBottomSheet"
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val id = this.arguments!!.getInt("id")

        viewModel.getMobile(id)

        viewModel.mobileLiveData.observe(viewLifecycleOwner) {
            binding.nameMobile.text = it.name
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                binding.legal.text = Html.fromHtml(it.legal, Html.FROM_HTML_MODE_COMPACT)
            }
            binding.rvImage.layoutManager =
                LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)
            binding.rvImage.adapter = ImageAdapter(requireContext(), it.images)

        }
        binding.idBtnDismiss.setOnClickListener { dialog!!.dismiss() }


    }
}