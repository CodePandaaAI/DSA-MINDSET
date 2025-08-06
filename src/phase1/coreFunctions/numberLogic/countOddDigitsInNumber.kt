package phase1.coreFunctions.numberLogic

fun main() {
    print(countOddDigits(92))
}

fun countOddDigits(number: Int): Int {
    var no = number
    var count = 0

    while (no > 0) {
        val digit = no % 10
        if (digit % 2 != 0) count++
        no = no / 10
    }
    return count
}