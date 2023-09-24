package com.android.personal_project_kakaobank_a

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.personal_project_kakaobank_a.data.KakaoModel

class MainSharedViewModel : ViewModel() {

    private val _libraryEvent: MutableLiveData<MainSharedEventForLibrary> = MutableLiveData()
    val libraryEvent: LiveData<MainSharedEventForLibrary> get() = _libraryEvent

    private val _searchEvent: MutableLiveData<MainSharedEventForSearch> = MutableLiveData()
    val searchEvent: LiveData<MainSharedEventForSearch> get() = _searchEvent
    fun updateLibraryItems(items: List<KakaoModel>?) {
        items?.filter {
            it.isAdd
        }?.also {
            _libraryEvent.value = MainSharedEventForLibrary.UpdateLibraryItems(it)
        }
    }

    fun updateSearchItem(item: KakaoModel) {
        _searchEvent.value = MainSharedEventForSearch.UpdateSearchItem(item)
    }
}

sealed interface MainSharedEventForLibrary {
    data class UpdateLibraryItems(
        val items: List<KakaoModel>
    ) : MainSharedEventForLibrary
}

sealed interface MainSharedEventForSearch {
    data class UpdateSearchItem(
        val item: KakaoModel
    ) : MainSharedEventForSearch
}