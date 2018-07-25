package com.brewmapp.brewmapp.features.main.search.main.presentation.recycler

import com.brewmapp.brewmapp.core.data.TypeSearch

class Search() {
    lateinit var title: String
    lateinit var select: String
    lateinit var typeSearch: TypeSearch
    var image: Int? = null

    constructor(title: String, select: String, image: Int?) : this() {
        this.title = title
        this.select = select
        this.image = image
    }

    constructor(title: String, select: String, image: Int?, type: TypeSearch) : this() {
        this.title = title
        this.select = select
        this.image = image
        this.typeSearch = type
    }
}