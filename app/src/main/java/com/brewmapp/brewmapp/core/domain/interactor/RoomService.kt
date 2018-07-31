package com.brewmapp.brewmapp.core.domain.interactor

import android.annotation.SuppressLint
import com.bignerdranch.android.osm.data.room.Param
import com.bignerdranch.android.osm.data.room.NoteDao
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import rx.Observable

class RoomService(var db: NoteDao) {

    @SuppressLint("CheckResult")
    fun getAll(id: String, type: String, callback: ParamCallback) {
        db.getAll(id, type)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ callback.onSuccess(it) }, { callback.onError(it) })
    }

    fun addParams(params: List<Param>, callback: EditNoteCallback) {
        Observable.create(Observable.OnSubscribe<String> { subscriber ->
            db.addParams(params)
            subscriber.onCompleted()
        })
                .subscribeOn(rx.schedulers.Schedulers.io())
                .observeOn(rx.android.schedulers.AndroidSchedulers.mainThread())
                .subscribe({ callback.onSuccess() }, { callback.onError(it) })
    }

    interface ParamCallback {
        fun onSuccess(params: List<Param>)
        fun onError(e: Throwable)
    }

    interface EditNoteCallback {
        fun onSuccess()
        fun onError(e: Throwable)
    }
}