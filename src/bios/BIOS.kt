package com.geno1024.bios

import com.geno1024.bios.font.Default
import com.geno1024.bios.font.DotMatrix
import com.geno1024.bios.font.extract
import com.geno1024.monitor.Monitor
import java.awt.Color

/**
 * A Basic Input Output System.
 *
 * @author Geno1024
 * @date 2018-07-07 02:41
 */
class BIOS
{
    /**
     * The connected monitor.
     */
    lateinit var monitor: Monitor

    /**
     * Draw a character to the monitor.
     *
     * @param x horizontal position of this character
     * @param y vertical position of this character
     * @param character the character being draw
     * @param color the color used to draw
     */
    fun drawCharacter(x: Int, y: Int, character: DotMatrix, color: Int = Color.GRAY.rgb)
    {
        character.extract().mapIndexed { yIndex, ints ->
            ints.mapIndexed { xIndex, int ->
                if (int == 1) monitor.drawPixel(x * 8 + xIndex, y * 16 + yIndex, color)
            }
        }
    }

    /**
     * Draw a single pixel with the color provided.
     *
     * @param x the pixel's horizontal axis position.
     * @param y the pixel's vertical axis position.
     * @param color the provided color, or the previous color given.
     */
    fun drawPixel(x: Int, y: Int, color: Int = Color.GRAY.rgb) = monitor.image.setRGB(x, y, color)

    /**
     * Draw a string with the color provided.
     *
     * @param x the pixel's horizontal axis position.
     * @param y the pixel's vertical axis position.
     * @param string the string being draw
     * @param color the color used to draw
     *
     * @exception java.lang.ArrayIndexOutOfBoundsException if window overflow.
     */
    fun drawString(x: Int, y: Int, string: String, color: Int = Color.GRAY.rgb)
    {
        string.forEachIndexed { index, c ->
            drawCharacter(x + index, y, Default.charmap[c.toInt()])
        }
    }
}
