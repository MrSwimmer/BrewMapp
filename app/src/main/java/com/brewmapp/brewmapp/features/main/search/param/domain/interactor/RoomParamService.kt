package com.brewmapp.brewmapp.features.main.search.param.domain.interactor

import com.bignerdranch.android.osm.data.room.Param
import com.bignerdranch.android.osm.data.room.NoteDao
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import rx.Observable

class RoomParamService(var db: NoteDao) {

    fun getAllParams(type: String, callback: ParamCallback) {
        db.getAllByType(type)
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