package phase1.coreFunctions.numberLogic.digitFrequency

fun main() {
    println(isDigitSubset(121, 211))
    println(isDigitSubset(121, 21))
}

fun isDigitSubset(num1: Int, num2: Int): Boolean {
    val map1 = mutableMapOf<Int, Int>()
    var n1 = num1
    while (n1 > 0) {
        val digit = n1 % 10
        map1[digit] = map1.getOrDefault(digit, 0) + 1
        n1 /= 10
    }

    val map2 = mutableMapOf<Int, Int>()
    var n2 = num2
    while (n2 > 0) {
        val digit = n2 % 10
        map2[digit] = map2.getOrDefault(digit, 0) + 1
        n2 /= 10
    }

    for ((digit, count) in map1) {
        if (map2.getOrDefault(digit, 0) < count) {
            return false
        }
    }

    return true
}