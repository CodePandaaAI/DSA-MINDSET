package arrays.hashing.twopointers

import kotlin.math.max
import kotlin.math.min

fun main() {
    val heights = intArrayOf(7, 1, 2, 3, 9)
    print(containerWithMostWater(heights))
}

fun containerWithMostWater(height: IntArray): Int {
    if (height.size < 2) return height[0]

    var left = 0
    var maxArea = 0
    var right = height.size - 1

    while (left < right) {
        val minHeight = min(height[left], height[right])
        val width = right - left

        val currentArea = width * minHeight

        maxArea = max(maxArea, currentArea)

        if (height[left] < height[right]) {
            left++
        } else {
            right--
        }
    }

    return maxArea
}