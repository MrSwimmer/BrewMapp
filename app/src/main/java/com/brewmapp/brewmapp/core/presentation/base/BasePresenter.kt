package com.brewmapp.brewmapp.core.presentation.base

import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter
import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable


open class BasePresenter<V : BaseContract.View> : MvpBasePresenter<V>() {

}