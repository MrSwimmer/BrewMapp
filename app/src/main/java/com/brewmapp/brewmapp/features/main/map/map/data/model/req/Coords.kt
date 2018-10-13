package com.brewmapp.brewmapp.features.main.map.map.data.model.req

class Coords() {
    var coordStart = ""
    var coordEnd = ""
    var restoCity = ""
    var restoTypes = ""
    var restoMetroes = ""
    var restoKitchens = ""
    var restoFeatures = ""
    var menuBeer = ""
    var restoPrices = ""
    constructor(coordStart: String, coordEnd: String) : this() {
        this.coordStart = coordStart
        this.coordEnd = coordEnd
    }

}