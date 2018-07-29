package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.data.Mode
import com.brewmapp.brewmapp.core.data.TypeSearch
import com.brewmapp.brewmapp.features.main.search.main.presentation.recycler.Search
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter

class SearchPresenter : MvpBasePresenter<SearchContract.View>(), SearchContract.Presenter {
    override fun setRecyclerData(mode: String) {
        when(mode) {
            Mode.BEER.name -> setBeerRecyclerData()
            Mode.BREWERY.name -> setBreweryRecyclerData()
        }
    }


    fun setRestaurantsRecyclerData() {
        var searches = arrayListOf<Search>()
        //searches.add(Search("Поиск по названию заведения", "Любое", R.drawable.ic_search_name, TypeSearch.RESTO_TITLE))
        //searches.add(Search("Поиск по названию пива", "Любое", R.drawable.ic_search_name, TypeSearch.BEER_TITLE))
        searches.add(Search("Тип заведения", "Любой", R.drawable.ic_search_type, TypeSearch.RESTO_TYPE))
        searches.add(Search("Тип пива", "Любой", R.drawable.ic_search_type, TypeSearch.RESTO_TYPE))
        searches.add(Search("Кухня", "Любая", R.drawable.ic_search_type, TypeSearch.KITCHEN))
        searches.add(Search("Средний счет", "Любая", R.drawable.ic_search_type, TypeSearch.KITCHEN))
        searches.add(Search("Кухня", "Любая", R.drawable.ic_search_type, TypeSearch.KITCHEN))
        searches.add(Search("Кухня", "Любая", R.drawable.ic_search_type, TypeSearch.KITCHEN))
        searches.add(Search("Кухня", "Любая", R.drawable.ic_search_type, TypeSearch.KITCHEN))
    }

    fun setBreweryRecyclerData() {
        var searches = arrayListOf<Search>()
        //searches.add(Search("Поиск по названию пивоварни", "Любое", R.drawable.ic_search_name, TypeSearch.BREWERY_TITLE))
        searches.add(Search("Страна", "Не имеет значения", R.drawable.ic_search_country, TypeSearch.COUNTRY))
        searches.add(Search("Бренд пива", "Любой", R.drawable.ic_search_brand, TypeSearch.BRAND))
        searches.add(Search("Тип пива", "Любой", R.drawable.ic_search_type, TypeSearch.TYPE))
        view.initAdapter(searches)
    }

    fun setBeerRecyclerData() {
        var searches = arrayListOf<Search>()
        //searches.add(Search("Поиск по названию", "Любое", R.drawable.ic_search_name, TypeSearch.BEER_TITLE))
        searches.add(Search("Страна - производитель", "Не имеет значения", R.drawable.ic_search_country, TypeSearch.COUNTRY))
        searches.add(Search("Тип пива", "Любой", R.drawable.ic_search_type, TypeSearch.TYPE))
        searches.add(Search("Бренд пива", "Любой", R.drawable.ic_search_brand, TypeSearch.BRAND))
        searches.add(Search("Крепость пива", "Любая", R.drawable.ic_search_strength, TypeSearch.STRENGTH))
        //searches.add(Search("Фильтрация пива", "Любая", R.drawable.ic_search_filter_beer, TypeSearch.FILTER.typeSearch))//
        //searches.add(Search("Тип брожения", "Любой", R.drawable.ic_search_type_ferm, TypeSearch.FERM.typeSearch))//
        searches.add(Search("IBU", "Любой", R.drawable.ic_search_ibu, TypeSearch.IBU))
        searches.add(Search("Вид емкости", "Любой", R.drawable.ic_search_capacity, TypeSearch.PACKING))
        searches.add(Search("Цвет", "Любой", R.drawable.ic_search_color, TypeSearch.COLOR))
        searches.add(Search("Аромат", "Любой", R.drawable.ic_search_scent, TypeSearch.FRAGRANCE))
        searches.add(Search("Вкус", "Любой", R.drawable.ic_search_taste, TypeSearch.TASTE))
        searches.add(Search("Послевкусие", "Любое", R.drawable.ic_search_aftertaste, TypeSearch.AFTERTASTE))
        searches.add(Search("Пивоварня", "Любая", R.drawable.ic_search_brewery, TypeSearch.BREWERY))
        searches.add(Search("Цена", "Любая", R.drawable.ic_search_price, TypeSearch.PRICERANGE))
        searches.add(Search("Где искать", "Любой город", R.drawable.ic_search_city, TypeSearch.CITY))//
        view.initAdapter(searches)
    }


}