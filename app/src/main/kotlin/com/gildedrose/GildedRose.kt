package com.gildedrose

import com.gildedrose.data.Item

class GildedRose(val items: Array<Item>) {
    fun updateQuality() {
        for (item in items) {
            item.updateQuality()
        }
    }
}