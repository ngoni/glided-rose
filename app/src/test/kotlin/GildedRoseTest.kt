package com.gildedrose

import com.gildedrose.data.*
import org.junit.Assert.assertEquals
import org.junit.Test

/**
 * Source: https://gist.github.com/maaretp/e7dafe02b662ab809fbca2f76f8d4110
 *
 * The below test cases where obtained from the above link.
 * I've refactored these from Java to Kotlin
 *
 * The below tests achieve a high code coverage - see Readme file for stats.
 **/

class GildedRoseTest {

    @Test
    fun AfterSellByDateDegradeDouble() {
        val item = NormalItem("Any", 0, 10)
        val app = checkItem(item)
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun BeforeSellByDateDegradeSingle() {
        val item = NormalItem("Any", 1, 10)
        val app = checkItem(item)
        assertEquals(9, app.items[0].quality)
    }

    @Test
    fun QualityOfItemNotNegative() {
        val item = NormalItem("Any", 0, 0)
        val app = checkItem(item)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun BrieImprovesWithAge() {
        val item = AgedBrieItem("Aged Brie", 0, 0)
        val app = checkItem(item)
        assertEquals(2, app.items[0].quality)
    }

    @Test
    fun QualityOfItemLimit50() {
        val item = AgedBrieItem("Aged Brie", 0, 50)
        val app = checkItem(item)
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun LegendarySulfuras() {
        val item = LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80)
        val app = checkItem(item)
        assertEquals(80, app.items[0].quality)
    }

    @Test
    fun BackstageValueLosesAllQualityOnDate() {
        val item = BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 0, 10)
        val app = checkItem(item)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun BackstageValueLongBefore() {
        val item = BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 100, 100)
        val app = checkItem(item)
        assertEquals(100, app.items[0].quality)
    }

    @Test
    fun BackstageValue10DaysBefore() {
        val item = BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 8, 47)
        val app = checkItem(item)
        assertEquals(49, app.items[0].quality)
    }

    @Test
    fun BackstageValueTwoDaysBefore() {
        val item = BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 2, 40)
        val app = checkItem(item)
        assertEquals(43, app.items[0].quality)
    }

    @Test
    fun Backstage1() {
        val item = BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 10, 49)
        val app = checkItem(item)
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun Backstage2() {
        val item = BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 5, 51)
        val app = checkItem(item)
        assertEquals(51, app.items[0].quality)
    }

    @Test
    fun Backstage3() {
        val item = BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 13, 51)
        val app = checkItem(item)
        assertEquals(51, app.items[0].quality)
    }

    @Test
    fun Backstage4() {
        val item = BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 15, 45)
        val app = checkItem(item)
        assertEquals(46, app.items[0].quality)
    }

    @Test
    fun Backstage5() {
        val item = BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 5, 45)
        val app = checkItem(item)
        assertEquals(48, app.items[0].quality)
    }

    @Test
    fun Backstage6() {
        val item = BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 5, 49)
        val app = checkItem(item)
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun Backstage7() {
        val item = BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 7, 52)
        val app = checkItem(item)
        assertEquals(52, app.items[0].quality)
    }

    @Test
    fun LegendarySulfuras2() {
        val item = LegendaryItem("Sulfuras, Hand of Ragnaros", -1, 80)
        val app = checkItem(item)
        assertEquals(80, app.items[0].quality)
    }

    @Test
    fun Conjured() {
        val item = ConjuredItem("Conjured Mana Cake", 6, 50)
        val app = checkItem(item)
        assertEquals(48, app.items[0].quality)
    }

    private fun checkItem(item: Item): GildedRose {
        val items = arrayOf(item)
        val app = GildedRose(items)
        app.updateQuality()
        return app
    }
}