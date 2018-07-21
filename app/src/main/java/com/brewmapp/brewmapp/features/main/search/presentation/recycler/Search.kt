package com.brewmapp.brewmapp.features.main.search.presentation.recycler

class Search() {
    lateinit var title: String
    lateinit var select: String
    var image: Int? = null

    constructor(title: String, select: String, image: Int?) : this() {
        this.title = title
        this.select = select
        this.image = image
    }
}