package phase1.coreFunctions.numberLogic.factorsAndMultiples

import kotlin.math.sqrt

fun main() {
    println(factors(84))
}

fun factors(num: Int): List<Int> {
    val list = mutableListOf<Int>()

    if (num <= 0) return list

    val sqrtNum = sqrt(num.toDouble()).toInt()

    for (n in 1..sqrtNum) {
        if (num % n == 0) {
            list.add(n)
            if (n != num / n) list.add(num / n)
        }
    }
    return list
}