package com.gildedrose.data

class ConjuredItem(name: String, sellInt: Int, quality: Int) : Item(name, sellInt, quality) {

    override fun updateQuality() {
        modifyNormalItemQuality()
        modifyNormalItemQuality()
    }

    private fun modifyNormalItemQuality() {
        modifyItemQuality()
        decrementItemQuality()
    }

    private fun modifyItemQuality() {
        if (isSellInLessThan()) decrementItemQuality()
    }


    private fun decrementItemQuality() {
        if (this.quality > 0) {
            this.quality = this.quality - 1
        }
    }

    private fun isSellInLessThan() = this.sellIn < 0
}