package com.gildedrose.data

class NormalItem(name: String, sellInt: Int, quality: Int) : Item(name, sellInt, quality) {

    override fun updateQuality() {
        modifyNormalItemQuality()
    }

    private fun modifyNormalItemQuality() {
        modifyItemQuality()
        decrementItemQuality()
    }

    private fun modifyItemQuality() {
        if (isSellInLessThan()) decrementItemQuality()
    }

    private fun isSellInLessThan() = this.sellIn < 1

    private fun decrementItemQuality() {
        if (this.quality > 0) {
            this.quality = this.quality - 1
        }
    }
}