package com.gildedrose;

import com.gildedrose.data.*

object GildedRoseApplication {

    @JvmStatic
    fun main(args: Array<String>) {
        println("Starting Gilded Rose")
        val items: Array<Item> = arrayOf(
            NormalItem("+5 Dexterity Vest", 10, 20),  //
            AgedBrieItem("Aged Brie", 2, 0),  //
            NormalItem("Elixir of the Mongoose", 5, 7),  //
            LegendaryItem("Sulfuras, Hand of Ragnaros", 0, 80),  //
            LegendaryItem("Sulfuras, Hand of Ragnaros", -1, 80),
            BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 15, 20),
            BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 10, 49),
            BackstagePassItem("Backstage passes to a TAFKAL80ETC concert", 5, 49),
            // this conjured item does not work properly yet
            ConjuredItem("Conjured Mana Cake", 3, 6)
        )
        val app = GildedRose(items)

        var days = 2
        if (args.isNotEmpty()) {
            days = Integer.parseInt(args[0]) + 1
        }

        for (i in 0 until days) {
            println("-------- day $i --------")
            println("name, sellIn, quality")
            for (item in items) {
                println(item)
            }
            println()
            app.updateQuality()
        }
    }
}