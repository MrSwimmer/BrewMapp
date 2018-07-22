package com.brewmapp.brewmapp.features.main.profile

import com.brewmapp.brewmapp.R
import com.brewmapp.brewmapp.features.main.search.presentation.recycler.Search
import com.hannesdorfmann.mosby3.mvp.MvpBasePresenter

class SearchPresenter : MvpBasePresenter<SearchContract.View>(), SearchContract.Presenter {
    override fun setRecyclerData() {
        var searches = arrayListOf<Search>()
        searches.add(Search("Поиск по названию", "Любое", R.drawable.ic_search_name))
        searches.add(Search("Страна - производитель", "Не имеет значения", R.drawable.ic_search_country))
        searches.add(Search("Тип пива", "Любой", R.drawable.ic_search_type))
        searches.add(Search("Бренд пива", "Любой", R.drawable.ic_search_brand))
        searches.add(Search("Крепость пива", "Любая", R.drawable.ic_search_strength))
        searches.add(Search("Фильтрация пива", "Любая", R.drawable.ic_search_filter_beer))
        searches.add(Search("Тип брожения", "Любой", R.drawable.ic_search_type_ferm))
        searches.add(Search("IBU", "Любой", R.drawable.ic_search_ibu))
        searches.add(Search("Вид емкости", "Любой", R.drawable.ic_search_capacity))
        searches.add(Search("Цвет", "Любой", R.drawable.ic_search_color))
        searches.add(Search("Аромат", "Любой", R.drawable.ic_search_scent))
        searches.add(Search("Вкус", "Любой", R.drawable.ic_search_taste))
        searches.add(Search("Послевкусие", "Любое", R.drawable.ic_search_aftertaste))
        searches.add(Search("Пивоварня", "Любая", R.drawable.ic_search_brewery))
        searches.add(Search("Цена", "Любая", R.drawable.ic_search_price))
        searches.add(Search("Где искать", "Любой город", R.drawable.ic_search_city))
        view.initAdapter(searches)
    }

}