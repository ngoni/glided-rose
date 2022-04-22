package com.gildedrose.data

class AgedBrieItem(name: String, sellInt: Int, quality: Int) : Item(name, sellInt, quality) {

    override fun updateQuality() {
        incrementItemQuality()
        incrementItemQuality()
    }

    private fun incrementItemQuality() {
        if (this.quality < 50) {
            this.quality = this.quality + 1
        }
    }

}