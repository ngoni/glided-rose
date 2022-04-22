package com.gildedrose.data

open class Item(
    val name: String,
    var sellIn: Int,
    var quality: Int
) : ItemBehaviour {
    override fun updateQuality() {
    }

    @Override
    override fun toString(): String {
        return "$name, $sellIn, $quality"
    }
}