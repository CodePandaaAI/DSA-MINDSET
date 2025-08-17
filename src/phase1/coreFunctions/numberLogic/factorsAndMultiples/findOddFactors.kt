package phase1.coreFunctions.numberLogic.factorsAndMultiples

import kotlin.math.sqrt

fun main() {
    println(findOddFactorsInEff(84))
    println(findOddFactorsEff(84))
}

fun findOddFactorsInEff(number: Int): List<Int> {
    val list = mutableListOf<Int>()
    for (i in 1..number) { // first loop i = 1, second = 2
        if (number % i == 0 && i % 2 != 0) list.add(i)
    }

    return list
}

fun findOddFactorsEff(number: Int): List<Int> {
    val list = mutableListOf<Int>()
    val sqrtNum = sqrt(number.toDouble()).toInt()

    for (i in 1..sqrtNum) { // first loop i = 1, second = 2
        if (number % i == 0) {
            if (i % 2 != 0) {
                list.add(i)
            }
            if (number / i != i && number / i % 2 != 0) {
                list.add(number / i)
            }
        }
    }

    return list
}
