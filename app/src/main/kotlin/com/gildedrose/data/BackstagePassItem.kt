package com.gildedrose.data

import kotlin.math.min

class BackstagePassItem(name: String, sellInt: Int, quality: Int) : Item(name, sellInt, quality) {

    override fun updateQuality() {
        modifyBackstagePassQuality()
    }

    private fun modifyBackstagePassQuality() {
        when (this.sellIn) {
            in 6..10 -> {
                incrementItemQuality(2)
            }
            in 1..5 -> {
                incrementItemQuality(3)
            }
            0 -> {
                dropQualityToZero()
            }
            else -> incrementItemQuality(1)
        }
    }

    private fun incrementItemQuality(increase: Int) {
        if (this.quality < 50) {
            this.quality = min(50, this.quality + increase)
        }
    }

    private fun dropQualityToZero() {
        this.quality = 0
    }

}