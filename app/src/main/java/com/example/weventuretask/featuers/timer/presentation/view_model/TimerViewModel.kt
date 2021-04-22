package com.example.weventuretask.featuers.timer.presentation.view_model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weventuretask.featuers.timer.domin.getTimeUseCase
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.core.Scheduler
import io.reactivex.rxjava3.disposables.CompositeDisposable
import io.reactivex.rxjava3.schedulers.Schedulers

class TimerViewModel(
    private val getTimer: (Long) -> Observable<String> = ::getTimeUseCase
) : ViewModel() {

    val timer by lazy { MutableLiveData<String>() }

    private val compositeDisposable = CompositeDisposable()

    fun startTimer(
        timeInSecond: Long,
        scheduler: Scheduler = Schedulers.io(),
        subscribeOnSchedulers: Scheduler = AndroidSchedulers.mainThread()
    ) {
        stopTimer()
        getTimer(timeInSecond)
            .observeOn(scheduler)
            .subscribeOn(subscribeOnSchedulers)
            .subscribe(timer::postValue)
            .apply { compositeDisposable.add(this) }
    }

    fun stopTimer(){
        compositeDisposable.clear()
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}