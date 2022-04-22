package com.gildedrose.data

class LegendaryItem(name: String, sellInt: Int, quality: Int) : Item(name, sellInt, quality) {

    override fun updateQuality() {
        // do nothing
    }

}