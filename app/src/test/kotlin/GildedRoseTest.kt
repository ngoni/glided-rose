package com.gildedrose

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
        val app = checkItem("Any", 0, 10)
        assertEquals(8, app.items[0].quality)
    }

    @Test
    fun BeforeSellByDateDegradeSingle() {
        val app = checkItem("Any", 1, 10)
        assertEquals(9, app.items[0].quality)
    }

    @Test
    fun QualityOfItemNotNegative() {
        val app = checkItem("Any", 0, 0)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun BrieImprovesWithAge() {
        val app = checkItem("Aged Brie", 0, 0)
        assertEquals(2, app.items[0].quality)
    }

    @Test
    fun QualityOfItemLimit50() {
        val app = checkItem("Aged Brie", 0, 50)
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun LegendarySulfuras() {
        val app = checkItem("Sulfuras, Hand of Ragnaros", 0, 80)
        assertEquals(80, app.items[0].quality)
    }

    @Test
    fun BackstageValueLosesAllQualityOnDate() {
        val app = checkItem("Backstage passes to a TAFKAL80ETC concert", 0, 10)
        assertEquals(0, app.items[0].quality)
    }

    @Test
    fun BackstageValueLongBefore() {
        val app = checkItem("Backstage passes to a TAFKAL80ETC concert", 100, 100)
        assertEquals(100, app.items[0].quality)
    }

    @Test
    fun BackstageValue10DaysBefore() {
        val app = checkItem("Backstage passes to a TAFKAL80ETC concert", 8, 47)
        assertEquals(49, app.items[0].quality)
    }

    @Test
    fun BackstageValueTwoDaysBefore() {
        val app = checkItem("Backstage passes to a TAFKAL80ETC concert", 2, 40)
        assertEquals(43, app.items[0].quality)
    }

    @Test
    fun Backstage1() {
        val app = checkItem("Backstage passes to a TAFKAL80ETC concert", 10, 49)
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun Backstage2() {
        val app = checkItem("Backstage passes to a TAFKAL80ETC concert", 5, 51)
        assertEquals(51, app.items[0].quality)
    }

    @Test
    fun Backstage3() {
        val app = checkItem("Backstage passes to a TAFKAL80ETC concert", 13, 51)
        assertEquals(51, app.items[0].quality)
    }

    @Test
    fun Backstage4() {
        val app = checkItem("Backstage passes to a TAFKAL80ETC concert", 15, 45)
        assertEquals(46, app.items[0].quality)
    }

    @Test
    fun Backstage5() {
        val app = checkItem("Backstage passes to a TAFKAL80ETC concert", 5, 45)
        assertEquals(48, app.items[0].quality)
    }

    @Test
    fun Backstage6() {
        val app = checkItem("Backstage passes to a TAFKAL80ETC concert", 5, 49)
        assertEquals(50, app.items[0].quality)
    }

    @Test
    fun Backstage7() {
        val app = checkItem("Backstage passes to a TAFKAL80ETC concert", 7, 52)
        assertEquals(52, app.items[0].quality)
    }

    @Test
    fun LegendarySulfuras2() {
        val app = checkItem("Sulfuras, Hand of Ragnaros", -1, 80)
        assertEquals(80, app.items[0].quality)
    }

    private fun checkItem(item: String?, sellin: Int?, quality: Int?): GildedRose {
        val items = arrayOf(
            Item(
                item!!, sellin!!, quality!!
            )
        )
        val app = GildedRose(items)
        app.updateQuality()
        return app
    }
}