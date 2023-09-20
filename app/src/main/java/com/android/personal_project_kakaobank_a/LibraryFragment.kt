package com.android.personal_project_kakaobank_a

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.GridLayoutManager
import com.android.personal_project_kakaobank_a.adapter.LibraryAdapter
import com.android.personal_project_kakaobank_a.data.KakaoData
import com.android.personal_project_kakaobank_a.databinding.LibraryFragmentBinding
import com.android.personal_project_kakaobank_a.databinding.SearchFragmentBinding
import com.bumptech.glide.Glide

class LibraryFragment : Fragment() {

    private var _binding: LibraryFragmentBinding? = null
    private val binding get() = _binding!!
    private val recyclerViewAdapter by lazy{
        LibraryAdapter(test2)
    }
    private val testSet = mutableSetOf<KakaoData>()
    companion object {
        fun newInstance() = LibraryFragment()
        val test2 = arrayListOf<KakaoData>()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = LibraryFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setFragmentResultListener("requestKey") { requestKey, bundle ->
            val itemList = bundle.getParcelableArrayList<KakaoData>("item")

            Log.d("LibraryFragment", "#choco5732 LibraryFragment :$itemList")
//            testSet.addAll(itemList!!)
            Log.d("LibraryFragment", "#choco5732 testSet :$testSet")

//            for( i in 0 until itemList.size) {
//                if ( itemList[i] in testSet ) {
//                recyclerViewAdapter.addItems(itemList)
//                }
//            }
            recyclerViewAdapter.addItems(itemList)


            itemList?.clear()
        }

        binding.recyclerView.adapter = recyclerViewAdapter
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)
    }

    override fun onDestroyView() {
        _binding = null
        super.onDestroyView()
    }
}