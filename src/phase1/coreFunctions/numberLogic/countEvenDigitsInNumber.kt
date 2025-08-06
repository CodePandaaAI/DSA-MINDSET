package phase1.coreFunctions.numberLogic

fun main() {
    print(countEvenDigits(8))
}

fun countEvenDigits(number: Int): Int {
    var no = number
    var count = 0

    while (no > 0) {
        if ((no % 10) % 2 == 0) count++
        no = no / 10
    }
    return count
}