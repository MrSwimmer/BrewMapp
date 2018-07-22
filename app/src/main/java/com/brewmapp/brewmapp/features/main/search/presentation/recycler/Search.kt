package com.brewmapp.brewmapp.features.main.search.presentation.recycler

class Search() {
    lateinit var title: String
    lateinit var select: String
    lateinit var type: String
    var image: Int? = null

    constructor(title: String, select: String, image: Int?) : this() {
        this.title = title
        this.select = select
        this.image = image
    }

    constructor(title: String, select: String, image: Int?, type: String) : this() {
        this.title = title
        this.select = select
        this.image = image
        this.type = type
    }
}