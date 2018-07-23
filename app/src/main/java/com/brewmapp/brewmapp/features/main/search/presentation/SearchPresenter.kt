package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.core.data.TypeSearch
import com.brewmapp.brewmapp.features.main.search.presentation.recycler.Search
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter

class SearchPresenter : MvpBasePresenter<SearchContract.View>(), SearchContract.Presenter {
    override fun setRecyclerData() {
        var searches = arrayListOf<Search>()
        searches.add(Search("Поиск по названию", "Любое", R.drawable.ic_search_name, TypeSearch.NAME.type))
        searches.add(Search("Страна - производитель", "Не имеет значения", R.drawable.ic_search_country, TypeSearch.COUNTRY.type))
        searches.add(Search("Тип пива", "Любой", R.drawable.ic_search_type, TypeSearch.TYPE.type))
        searches.add(Search("Бренд пива", "Любой", R.drawable.ic_search_brand, TypeSearch.BRAND.type))
        searches.add(Search("Крепость пива", "Любая", R.drawable.ic_search_strength, TypeSearch.STRENGTH.type))
        //searches.add(Search("Фильтрация пива", "Любая", R.drawable.ic_search_filter_beer, TypeSearch.FILTER.type))//
        //searches.add(Search("Тип брожения", "Любой", R.drawable.ic_search_type_ferm, TypeSearch.FERM.type))//
        searches.add(Search("IBU", "Любой", R.drawable.ic_search_ibu, TypeSearch.IBU.type))
        searches.add(Search("Вид емкости", "Любой", R.drawable.ic_search_capacity, TypeSearch.PACKING.type))
        searches.add(Search("Цвет", "Любой", R.drawable.ic_search_color, TypeSearch.COLOR.type))
        searches.add(Search("Аромат", "Любой", R.drawable.ic_search_scent, TypeSearch.FRAGRANCE.type))
        searches.add(Search("Вкус", "Любой", R.drawable.ic_search_taste, TypeSearch.TASTE.type))
        searches.add(Search("Послевкусие", "Любое", R.drawable.ic_search_aftertaste, TypeSearch.AFTERTASTE.type))
        searches.add(Search("Пивоварня", "Любая", R.drawable.ic_search_brewery, TypeSearch.BREWERY.type))
        searches.add(Search("Цена", "Любая", R.drawable.ic_search_price, TypeSearch.PRICERANGE.type))
        searches.add(Search("Где искать", "Любой город", R.drawable.ic_search_city, TypeSearch.CITY.type))//
        view.initAdapter(searches)
    }

}