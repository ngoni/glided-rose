package com.gildedrose

class GildedRose(val items: Array<Item>) {

    fun updateQuality() {
        for (i in items.indices) {

            decrementSellIn(i)

            if (!isAgedBrie(i)
                && !isBackstagePass(i)
            ) {
                if (items[i].quality > 0) {
                    if (!isLegendary(i)) {
                        items[i].quality = items[i].quality - 1
                    }
                }
            } else {
                if (items[i].quality < 50) {
                    items[i].quality = items[i].quality + 1
                    if (isBackstagePass(i)) {
                        if (items[i].sellIn < 11) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }
                        if (items[i].sellIn < 6) {
                            if (items[i].quality < 50) {
                                items[i].quality = items[i].quality + 1
                            }
                        }
                    }
                }
            }

            if (items[i].sellIn < 0) {
                if (!isAgedBrie(i)) {
                    if (!isBackstagePass(i)) {
                        if (items[i].quality > 0) {
                            if (!isLegendary(i)) {
                                items[i].quality = items[i].quality - 1
                            }
                        }
                    } else {
                        items[i].quality = items[i].quality - items[i].quality
                    }
                } else {
                    if (items[i].quality < 50) {
                        items[i].quality = items[i].quality + 1
                    }
                }
            }
        }
    }

    private fun decrementSellIn(i: Int) {
        if (!isLegendary(i)) {
            items[i].sellIn = items[i].sellIn - 1
        }
    }

    private fun isLegendary(i: Int) = items[i].name.equals("Sulfuras, Hand of Ragnaros")

    private fun isBackstagePass(i: Int) =
        items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")

    private fun isAgedBrie(i: Int) = items[i].name.equals("Aged Brie")
}