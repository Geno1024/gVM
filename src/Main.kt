package com.geno1024

import com.geno1024.bios.BIOS
import com.geno1024.bios.font.Default
import com.geno1024.monitor.Monitor
import java.awt.Color

/**
 * Entry point of the gVM.
 *
 * @author Geno1024
 * @date 2018-07-06 02:44
 */
object Main
{
    @JvmStatic
    fun main(args: Array<String>)
    {
        BIOS().apply {
            monitor = Monitor().apply {
                drawPixel(1, 1, Color.RED.rgb)
                resetSize(1024, 768)
                drawPixel(1022, 766, Color.GREEN.rgb)
                drawPixel(1, 766, Color.BLUE.rgb)
                drawPixel(1022, 1, Color.WHITE.rgb)
            }
            drawCharacter(0, 0, Default.x67)
            drawCharacter(1, 0, Default.x56)
            drawCharacter(2, 0, Default.x4d)

            drawCharacter(0, 2, Default.x42)
            drawCharacter(1, 2, Default.x79)
            drawCharacter(3, 2, Default.x47)
            drawCharacter(4, 2, Default.x65)
            drawCharacter(5, 2, Default.x6e)
            drawCharacter(6, 2, Default.x6f)
            drawCharacter(7, 2, Default.x31)
            drawCharacter(8, 2, Default.x30)
            drawCharacter(9, 2, Default.x32)
            drawCharacter(10, 2, Default.x34)
        }
    }
}