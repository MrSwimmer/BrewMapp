package com.brewmapp.brewmapp.features.main.search.main.presentation.recycler

import com.brewmapp.brewmapp.core.data.TypeSearch

class Search() {
    lateinit var title: String
    var select: Boolean = false
    lateinit var typeSearch: TypeSearch
    var image: Int? = null

    constructor(title: String, image: Int?) : this() {
        this.title = title
        this.image = image
    }

    constructor(title: String, image: Int?, type: TypeSearch) : this() {
        this.title = title
        this.image = image
        this.typeSearch = type
    }
}