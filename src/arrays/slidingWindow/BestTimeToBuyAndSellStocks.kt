package arrays.slidingWindow

import kotlin.math.max

fun main() {
    val prices = intArrayOf(7, 1, 5, 3, 6, 4)
    print(maxProfitTwo(prices))
}

fun maxProfit(prices: IntArray): Int {
    var maxProfit = 0

    for (i in 0 until prices.size) {
        for (j in i + 1 until prices.size) {
            if (prices[j] > prices[i])
                maxProfit = max(prices[j] - prices[i], maxProfit)
        }
    }

    return maxProfit
}

fun maxProfitTwo(prices: IntArray): Int {
    var maxP = 0
    var minPrice = Int.MAX_VALUE

    for (right in 0 until prices.size) {
        if (prices[right] < minPrice) {
            minPrice = prices[right]
        }

        maxP = max(prices[right] - minPrice, maxP)

    }
    return maxP
}