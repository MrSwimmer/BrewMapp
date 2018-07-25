package com.brewmapp.brewmapp.core.data


enum class TypeSearch(val type: String, val field: String) {
    COUNTRY("country", "Beer[country_id]"),
    TYPE("typeSearch", "Beer[type_id]"),
    BRAND("brand", "Beer[brand_id]"),
    COLOR("color", "Beer[colors_search]"),
    FRAGRANCE("fragrance", "Beer[fragrances_search]"), //aromat
    TASTE("taste", "Beer[tastes_search]"),
    AFTERTASTE("aftertaste", "Beer[aftertastes_search]"),
    PACKING("packing", "Beer[packing_id]"),
    STRENGTH("strength", "Beer[strength_id]"), //crepost
    PRICERANGE("pricerange", "Beer[pricerange_id]"),
    //DENSITY("density", "Beer[_id]"), //plotnost
    IBU("ibu", "Beer[ibu_id]"),
    BREWERY("brewery", "Beer[brewery_id]"),
    TITLE("title", "Beer[title_id]"),
    FILTER("filter", "Beer[filtered]"),
    CITY("city", "Beer[city_id]")
}