package phase1.coreFunctions.numberLogic.digitFrequency

fun main() {
    print(checkDigitAnagrams(1203, 3021))
}

fun checkDigitAnagrams(num1: Int, num2: Int): Boolean {
    var no1 = num1
    val map1 = mutableMapOf<Int, Int>()

    while (no1 > 0) {
        val digit = no1 % 10

        map1.put(digit, map1.getOrDefault(digit, 0) + 1)

        no1 = no1 / 10
    }

    var no2 = num2
    val map2 = mutableMapOf<Int, Int>()

    while (no2 > 0) {
        val digit = no2 % 10

        map2.put(digit, map2.getOrDefault(digit, 0) + 1)

        no2 = no2 / 10
    }

    return map1 == map2
}