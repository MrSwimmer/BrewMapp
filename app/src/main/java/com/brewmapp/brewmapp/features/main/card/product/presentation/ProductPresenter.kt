package com.brewmapp.brewmapp.features.main.profile

import android.util.Log
import com.brewmapp.brewmapp.App
import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter
import com.brewmapp.brewmapp.features.main.card.product.data.model.product.BeerAveragePrice
import com.brewmapp.brewmapp.features.main.card.product.data.model.product.Model
import com.brewmapp.brewmapp.features.main.card.product.data.model.product.RestoMenu
import com.brewmapp.brewmapp.features.main.card.product.domain.ApiProductService
import com.brewmapp.brewmapp.features.main.card.product.presentation.param_recycler.Param
import com.brewmapp.brewmapp.features.main.card.product.presentation.resto_recycler.Resto
import com.brewmapp.brewmapp.features.main.search.param.domain.interactor.ParamRepository
import javax.inject.Inject

class ProductPresenter : BasePresenter<ProductContract.View>(), ProductContract.Presenter {

    var repository: ParamRepository

    init {
        App.component.inject(this)
        repository = ParamRepository()
    }

    @Inject
    lateinit var apiService: ApiProductService

    var paramsList = mutableListOf<Param>()
    var restoList = mutableListOf<Resto>()
    var reviewList = mutableListOf<com.brewmapp.brewmapp.features.main.card.product.data.model.review.Model>()

    var restoAmount = 0

    override fun getProduct(id: String) {
        apiService.getProduct(id, object : ApiProductService.ProductCallback {
            override fun onSuccess(model: Model) {
                view.setProduct(model)

                paramsList.clear()
                paramsList.add(Param("Средняя цена:", "${getAveragePrice(model.relations.beerAveragePrice)} руб.", R.drawable.ic_search_price))
                paramsList.add(Param("Страна производитель:", model.relations.country.name.get1(), R.drawable.ic_search_country))
                paramsList.add(Param("Бренд:", model.relations.beerBrand.name.get1(), R.drawable.ic_search_brand))
                view.setParams(paramsList)

                restoList.clear()
                restoAmount = model.relations.restoMenu.size
                Log.i("code", "restoamount $restoAmount")
                for (i in 0 until model.relations.restoMenu.size) {
                    Log.i("code", "av1")
                    val mark: String = if (model.avgBall == null)
                        "-"
                    else
                        model.avgBall
                    val title: String = if (model.title.get1() == null)
                        ""
                    else
                        model.title.get1()
                    getResto(model.relations.restoMenu[i], title, model.getThumb, mark)
                }

                getReview(model.id)
            }

            override fun onError(it: Throwable) {
                Log.i("code", it.message)
                //view.showErrorMessage(it.message!!)
            }
        })
    }

    fun getAveragePrice(beerAveragePrice: MutableList<BeerAveragePrice>): String {
        var sum = 0
        beerAveragePrice.forEach {
            sum += it.price.toFloat().toInt()
        }
        return if (sum == 0)
            "Нет в продаже"
        else
            "${sum / beerAveragePrice.size}"
    }

    fun getResto(restoMenu: RestoMenu, title: String, thumb: String, avgBall: String) {
        apiService.getResto(restoMenu.id, object : ApiProductService.RestoCallback {
            override fun onSuccess(model: com.brewmapp.brewmapp.features.main.card.product.data.model.resto.Model) {
                val resto = model.resto[0]
                val location = resto.location
                val restofin = Resto(resto.name.get1(), title, "", avgBall, location.cityId.get1(), location.metro.name.get1(), resto.getThumb, thumb)
                restoList.add(restofin)
                Log.i("code", "resto size " + restoList.size)
                Log.i("code", "resto amount " + restoAmount)
                if (restoList.size == restoAmount) {
                    Log.i("code", "true set resto " + restoList.size.toString())
                    view.setResto(restoList)
                }
            }

            override fun onError(it: Throwable) {
                Log.i("code", "error get resto ${it.message}")
                restoAmount -= 1
                if (restoList.size == restoAmount) {
                    Log.i("code", "true set resto " + restoList.size.toString())
                    view.setResto(restoList)
                }
            }

        })
    }

    fun getReview(id: String) {
        apiService.getReview(id, object : ApiProductService.ReviewCallback {
            override fun onSuccess(models: MutableList<com.brewmapp.brewmapp.features.main.card.product.data.model.review.Model>) {
                reviewList = models
                view.setReview(models)
            }

            override fun onError(it: Throwable) {
                Log.i("code", "error review ${it.message}")
            }

        })
    }
}