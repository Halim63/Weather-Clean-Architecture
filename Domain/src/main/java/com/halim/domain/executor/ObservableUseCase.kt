package com.halim.domain.executor

import com.halim.domain.models.DomainModel
import com.halim.domain.usecases.GetWeatherUsecase
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.disposables.Disposable
import io.reactivex.rxjava3.observers.DisposableObserver
import io.reactivex.rxjava3.schedulers.Schedulers

abstract class ObservableUseCase<T : DomainModel, in Params> constructor(
    private val postExecutionThread: PostExecutionThread) {
private val disposables=CompositeDisposable()
    abstract fun buildUseCaseObservable(params: GetWeatherUsecase.Params?=null):Observable<T>

    open fun execute(observer: DisposableObserver<T>,params: GetWeatherUsecase.Params?=null) {
        val observable=this.buildUseCaseObservable(params)
            .subscribeOn(Schedulers.io())
            .observeOn(postExecutionThread.scheduler)
    }

    fun dispose(){
        disposables.dispose()
    }

fun addDisposable(disposable: Disposable){
    disposables.add(disposable)

}


}