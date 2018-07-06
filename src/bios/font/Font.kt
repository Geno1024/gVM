package com.geno1024.bios.font

typealias DotMatrix = Array<Int>
fun DotMatrix.extract(): Array<Array<Int>> = map { outer -> (0..7).map { inner -> outer and (1 shl inner) shr inner }.toTypedArray()  }.toTypedArray()

/**
 * Interface of font.
 *
 * @author geno1024
 * @date 2018-07-06 17:47
 */
interface Font
{
    val name: String
    val description: String
}