package com.gildedrose

class GildedRose(val items: Array<Item>) {

    companion object {
        const val ITEM_AGED_BRIE = "Aged Brie"
        const val ITEM_BACK_STAGE_PASS = "Backstage passes to a TAFKAL80ETC concert"
        const val ITEM_LEGENDARY = "Sulfuras, Hand of Ragnaros"
    }

    fun updateQuality() {
        for (item in items) {

            decrementSellIn(item)

            if (!isAgedBrie(item)
                && !isBackstagePass(item)
            ) {
                decrementItemQuality(item)
            } else {
                incrementItemQuality(item)
                if (isBackstagePass(item)) {
                    incrementBackstagePassQuality(item)
                }
            }

            if (isSellInLessThan(item, 0)) {
                if (!isAgedBrie(item)) {
                    if (!isBackstagePass(item)) {
                        decrementItemQuality(item)
                    } else {
                        dropQualityToZero(item)
                    }
                } else {
                    incrementItemQuality(item)
                }
            }
        }
    }

    private fun incrementBackstagePassQuality(item: Item) {
        if (isSellInLessThan(item, 11)) {
            incrementItemQuality(item)
        }
        if (isSellInLessThan(item, 6)) {
            incrementItemQuality(item)
        }
    }

    private fun isSellInLessThan(item: Item, days: Int) = item.sellIn < days

    private fun dropQualityToZero(item: Item) {
        item.quality = 0
    }

    private fun incrementItemQuality(item: Item) {
        if (item.quality < 50) {
            item.quality = item.quality + 1
        }
    }

    private fun decrementItemQuality(item: Item) {
        if (item.quality > 0) {
            if (!isLegendary(item)) {
                item.quality = item.quality - 1
            }
        }
    }

    private fun decrementSellIn(item: Item) {
        if (!isLegendary(item)) {
            item.sellIn = item.sellIn - 1
        }
    }

    private fun isLegendary(item: Item) = item.name.equals(ITEM_LEGENDARY)

    private fun isBackstagePass(item: Item) =
        item.name.equals(ITEM_BACK_STAGE_PASS)

    private fun isAgedBrie(item: Item) = item.name.equals(ITEM_AGED_BRIE)
}