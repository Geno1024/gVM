package com.geno1024.bios

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
}