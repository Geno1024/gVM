package com.geno1024.bios.font

import java.awt.Color
import java.awt.Font
import java.awt.image.BufferedImage
import java.io.PrintStream

/**
 * Font generator of a default font, from FixedSys.
 *
 * @author geno1024
 * @date 2018-07-07 17:48
 * @see <a href="http://www.fixedsysexcelsior.com">Fixedsys Excelsior</a>
 */
object FontGenerator
{
    @JvmStatic
    fun main(args: Array<String>)
    {
        val array = IntArray(8 * 16 * 4) { _ -> 0 }

        System.setOut(PrintStream("./src/bios/font/Default.kt"))

        println("package com.geno1024.bios.font")
        println()
        println("object Default: Font")
        println("{")
        println("\toverride val name: String = \"Default\"")
        println("\toverride val description: String = \"Default Font\"")
        println("")
        ('\u0000'..'\u007f').map {
            with(BufferedImage(8, 16, BufferedImage.TYPE_INT_ARGB)) bi@ {
                with(graphics) {
                    color = Color.BLACK
                    fillRect(0, 0, this@bi.width, this@bi.height)
                    color = Color.RED
                    font = Font("Fixedsys Excelsior 3.01", Font.PLAIN, 16)
                    drawString("$it", 0, 13)
                    raster.getPixels(0, 0, 8, 16, array)
                    dispose()
                    Pair(it, array.asList().chunked(4).map { it -> it[0] shr 7 }.chunked(8).joinToString(separator = ", ", prefix = "arrayOf(", postfix = ")") { "${it.foldRight(0) { i: Int, acc: Int -> (acc shl 1) + i } }" })
                }
            }
        }.forEach { println("\tval x${it.first.toInt().toString(16)}: Array<Int> = ${it.second}") }
        println("")
        println("\tval charmap: Array<DotMatrix> = arrayOf(${(0..127).joinToString { "x${it.toString(16)}" }})")

        println("}")
    }
}