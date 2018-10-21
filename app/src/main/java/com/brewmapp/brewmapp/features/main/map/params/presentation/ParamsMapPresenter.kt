package com.brewmapp.brewmapp.features.main.map.params.presentation

import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.core.data.TypeSearch
import com.brewmapp.brewmapp.core.presentation.base.BasePresenter
import com.brewmapp.brewmapp.features.main.search.main.presentation.recycler.Search

class ParamsMapPresenter: BasePresenter<ParamsMapContract.View>(), ParamsMapContract.Presenter {
    override fun setRecyclerData(mode: Mode) {
        when(mode) {
            Mode.BEER -> setBeerRecyclerData()
            Mode.RESTO -> setRestoRecyclerData()
        }
    }

    private fun setRestoRecyclerData() {
        val searches = arrayListOf<Search>()
        //searches.add(Search("Поиск по названию заведения", "Любое", R.drawable.ic_search_name, TypeSearch.RESTO_TITLE))
        //searches.add(Search("Поиск по названию пива", "Любое", R.drawable.ic_search_name, TypeSearch.BEER_TITLE))
        searches.add(Search("Тип заведения", R.drawable.ic_resto_type, TypeSearch.MAP_RESTO_TYPE))
        searches.add(Search("Кухня", R.drawable.ic_kitchen, TypeSearch.MAP_RESTO_KITCHEN))
        searches.add(Search("Город", R.drawable.ic_search_city, TypeSearch.MAP_RESTO_CITY))
        searches.add(Search("Тип пива", R.drawable.ic_search_type, TypeSearch.MAP_RESTO_BEER_TYPE))
        view.initAdapter(searches)
    }

    private fun setBeerRecyclerData() {
        val searches = arrayListOf<Search>()
        //searches.add(Search("Поиск по названию", "Любое", R.drawable.ic_search_name, TypeSearch.BEER_TITLE))
        searches.add(Search("Страна - производитель", R.drawable.ic_search_country, TypeSearch.COUNTRY))
        searches.add(Search("Тип пива", R.drawable.ic_search_type, TypeSearch.TYPE))
        searches.add(Search("Бренд пива", R.drawable.ic_search_brand, TypeSearch.BRAND))
        searches.add(Search("Крепость пива", R.drawable.ic_search_strength, TypeSearch.STRENGTH))
        searches.add(Search("IBU", R.drawable.ic_search_ibu, TypeSearch.IBU))
        searches.add(Search("Вид емкости", R.drawable.ic_search_capacity, TypeSearch.PACKING))
        searches.add(Search("Цвет", R.drawable.ic_search_color, TypeSearch.COLOR))
        searches.add(Search("Аромат", R.drawable.ic_search_scent, TypeSearch.FRAGRANCE))
        searches.add(Search("Вкус", R.drawable.ic_search_taste, TypeSearch.TASTE))
        searches.add(Search("Послевкусие", R.drawable.ic_search_aftertaste, TypeSearch.AFTERTASTE))
        //searches.add(Search("Пивоварня", R.drawable.ic_search_brewery, TypeSearch.BREWERY))
        searches.add(Search("Цена", R.drawable.ic_search_price, TypeSearch.PRICERANGE))
        view.initAdapter(searches)
    }
}