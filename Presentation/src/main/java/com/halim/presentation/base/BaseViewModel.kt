package com.halim.presentation.base

import androidx.lifecycle.ViewModel
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable

abstract class BaseViewModel : ViewModel() {
    private val disposables = CompositeDisposable()

    protected fun addDisposale(disposable: Disposable) = disposables.add(disposable)

    override fun onCleared() {
        disposables.dispose()
        super.onCleared()
    }

}