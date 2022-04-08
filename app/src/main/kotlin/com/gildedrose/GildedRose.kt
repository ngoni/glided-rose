package com.gildedrose

class GildedRose(val items: Array<Item>) {

    companion object {
        const val ITEM_NORMAL = "Normal"
        const val ITEM_AGED_BRIE = "Aged Brie"
        const val ITEM_BACK_STAGE_PASS = "Backstage passes to a TAFKAL80ETC concert"
        const val ITEM_LEGENDARY = "Sulfuras, Hand of Ragnaros"
    }

    fun updateQuality() {
        for (item in items) {

            if (!isItemType(item, ITEM_LEGENDARY)) {
                decrementSellIn(item)
            }

            if (!isItemType(item, ITEM_AGED_BRIE)
                && !isItemType(item, ITEM_BACK_STAGE_PASS)
            ) {
                if (!isItemType(item, ITEM_LEGENDARY)) {
                    decrementItemQuality(item)
                }
            } else {
                incrementItemQuality(item)
                if (isItemType(item, ITEM_BACK_STAGE_PASS)) {
                    if (isSellInLessThan(item, 11)) {
                        incrementItemQuality(item)
                    }

                    if (isSellInLessThan(item, 6)) {
                        incrementItemQuality(item)
                    }
                }
            }

            if (isSellInLessThan(item, 0)) {
                if (!isItemType(item, ITEM_AGED_BRIE)) {
                    if (!isItemType(item, ITEM_BACK_STAGE_PASS)) {
                        if (!isItemType(item, ITEM_LEGENDARY)) {
                            if (!isItemType(item, ITEM_LEGENDARY)) {
                                decrementItemQuality(item)
                            }
                        }
                    } else {
                        dropQualityToZero(item)
                    }
                } else {
                    incrementItemQuality(item)
                }
            }
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
            item.quality = item.quality - 1
        }
    }

    private fun decrementSellIn(item: Item) {
        item.sellIn = item.sellIn - 1
    }

    private fun isItemType(item: Item, name: String) = item.name == name
}