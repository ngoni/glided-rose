package com.gildedrose.data

class BackstagePassItem(name: String, sellInt: Int, quality: Int) : Item(name, sellInt, quality) {

    override fun updateQuality() {
        modifyBackstagePassQuality()
    }

    private fun modifyBackstagePassQuality() {
        incrementItemQuality()
        if (isSellInLessThan(11)) incrementItemQuality()
        if (isSellInLessThan(6)) incrementItemQuality()
        if (isSellInLessThan(0)) dropQualityToZero()
    }

    private fun incrementItemQuality() {
        if (this.quality < 50) {
            this.quality = this.quality + 1
        }
    }

    private fun isSellInLessThan(days: Int) = this.sellIn < days

    private fun dropQualityToZero() {
        this.quality = 0
    }

}