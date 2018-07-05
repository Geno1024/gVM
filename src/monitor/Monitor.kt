package com.geno1024.monitor

import java.awt.Color
import java.awt.Dimension
import java.awt.Graphics
import java.awt.image.BufferedImage
import javax.swing.JFrame
import javax.swing.JPanel

/**
 * The monitor, with a default 800 x 600 display.
 *
 * @author Geno1024
 * @date 2018-07-06 02:45
 */
class Monitor(width: Int = 800, height: Int = 600)
{
    /**
     * The width of display, in pixels.
     */
    var width: Int = width

    /**
     * The height of display, in pixels.
     */
    var height: Int = height

    /**
     * The image buffer.
     * Acts like a graphical memory.
     */
    var image: BufferedImage = BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB).apply {
        graphics.apply {
            color = Color.BLACK
            fillRect(0, 0, width, height)
        }
    }

    /**
     * The window of monitor.
     */
    private val screen = object : JFrame("Monitor")
    {
        override fun paint(g: Graphics?)
        {
            contentPane.graphics.drawImage(image, 0, 0, this)
        }
    }.apply {
        contentPane = JPanel().apply {
            preferredSize = Dimension(width, height)
        }
        isVisible = true
        isResizable = false
        pack()
    }

    /**
     * Draw a single pixel with the color provided.
     *
     * @param x the pixel's horizontal axis position.
     * @param y the pixel's vertical axis position.
     * @param color the provided color, or the previous color given.
     */
    fun drawPixel(x: Int, y: Int, color: Int = image.graphics.color.rgb) = image.setRGB(x, y, color)

    /**
     * Reset the size of the monitor.
     *
     * @param newWidth the new width of monitor, in pixels.
     * @param newHeight the new height of monitor, in pixels.
     */
    fun resetSize(newWidth: Int, newHeight: Int)
    {
        width = newWidth
        height = newHeight

        image = BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB).apply {
            createGraphics().apply {
                color = Color.BLACK
                fillRect(0, 0, width, height)
                drawImage(image, 0, 0, null)
                image.graphics.dispose()
            }
        }

        screen.contentPane.preferredSize = Dimension(width, height)
        screen.pack()
    }
}