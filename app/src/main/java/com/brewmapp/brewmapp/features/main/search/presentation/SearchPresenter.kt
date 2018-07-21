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
        searches.add(Search("Бренд пива", "Любой", R.drawable.ic_search_))
        searches.add(Search("", "Любое", R.drawable.ic_search_))
        searches.add(Search("", "Любое", R.drawable.ic_search_))
        searches.add(Search("", "Любое", R.drawable.ic_search_))
        searches.add(Search("", "Любое", R.drawable.ic_search_))
        searches.add(Search("", "Любое", R.drawable.ic_search_))
        searches.add(Search("", "Любое", R.drawable.ic_search_))
        view.initAdapter()
    }

}