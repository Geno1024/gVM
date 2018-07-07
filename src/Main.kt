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
                resetSize(1024, 768)
            }
            drawPixel(1, 1, Color.RED.rgb)
            drawPixel(1022, 766, Color.GREEN.rgb)
            drawPixel(1, 766, Color.BLUE.rgb)
            drawPixel(1022, 1, Color.WHITE.rgb)

            drawString(0, 0, "gVM")

            drawString(0, 2, "By Geno1024")

            drawString(0, 3, "$> _")
            drawString(0, 4, "00000000001111111111222222222233333333334444444444555555555566666666667777777777888888888899999999990000000000111111111112222222")
            drawString(0, 5, "01234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567890123456789012345678901234567")
        }
    }
}