package com.gildedrose

class GildedRose(val items: Array<Item>) {

    companion object {
        const val ITEM_AGED_BRIE = "Aged Brie"
        const val ITEM_BACK_STAGE_PASS = "Backstage passes to a TAFKAL80ETC concert"
        const val ITEM_LEGENDARY = "Sulfuras, Hand of Ragnaros"
    }

    fun updateQuality() {
        for (i in items.indices) {

            decrementSellIn(i)

            if (!isAgedBrie(i)
                && !isBackstagePass(i)
            ) {
                decrementItemQuality(i)
            } else {
                incrementItemQuality(i)
                if (isBackstagePass(i)) {
                    incrementBackstagePassQuality(i)
                }
            }

            if (isSellInLessThan(i, 0)) {
                if (!isAgedBrie(i)) {
                    if (!isBackstagePass(i)) {
                        decrementItemQuality(i)
                    } else {
                        dropQualityToZero(i)
                    }
                } else {
                    incrementItemQuality(i)
                }
            }
        }
    }

    private fun incrementBackstagePassQuality(i: Int) {
        if (isSellInLessThan(i, 11)) {
            incrementItemQuality(i)
        }
        if (isSellInLessThan(i, 6)) {
            incrementItemQuality(i)
        }
    }

    private fun isSellInLessThan(i: Int, days: Int) = items[i].sellIn < days

    private fun dropQualityToZero(i: Int) {
        items[i].quality = 0
    }

    private fun incrementItemQuality(i: Int) {
        if (items[i].quality < 50) {
            items[i].quality = items[i].quality + 1
        }
    }

    private fun decrementItemQuality(i: Int) {
        if (items[i].quality > 0) {
            if (!isLegendary(i)) {
                items[i].quality = items[i].quality - 1
            }
        }
    }

    private fun decrementSellIn(i: Int) {
        if (!isLegendary(i)) {
            items[i].sellIn = items[i].sellIn - 1
        }
    }

    private fun isLegendary(i: Int) = items[i].name.equals(ITEM_LEGENDARY)

    private fun isBackstagePass(i: Int) =
        items[i].name.equals(ITEM_BACK_STAGE_PASS)

    private fun isAgedBrie(i: Int) = items[i].name.equals(ITEM_AGED_BRIE)
}