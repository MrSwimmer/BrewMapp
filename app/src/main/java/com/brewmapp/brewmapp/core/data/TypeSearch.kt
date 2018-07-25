package com.brewmapp.brewmapp.core.data


enum class TypeSearch(val type: String, val field: String) {
    COUNTRY("country", "country_id"),
    TYPE("typeSearch", "type_id"),
    BRAND("brand", "brand_id"),
    COLOR("color", "colors_search"),
    FRAGRANCE("fragrance", "fragrances_search"), //aromat
    TASTE("taste", "tastes_search"),
    AFTERTASTE("aftertaste", "aftertastes_search"),
    PACKING("packing", "packing_id"),
    STRENGTH("strength", "strength_id"), //crepost
    PRICERANGE("pricerange", "pricerange_id"),
    //DENSITY("density", "_id"), //plotnost
    IBU("ibu", "Beer[ibu_id]"),
    BREWERY("brewery", "brewery_id"),
    TITLE("title", "title_id"),
    FILTER("filter", "filtered"),
    CITY("city", "city_id")
}