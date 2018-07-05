package com.geno1024

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
        Monitor().apply {
            drawPixel(1, 1, Color.RED.rgb)
            resetSize(1024, 768)
            drawPixel(1022, 766, Color.GREEN.rgb)
            drawPixel(1, 766, Color.BLUE.rgb)
            drawPixel(1022, 1, Color.WHITE.rgb)
        }
    }
}