package phase1.coreFunctions.numberLogic

fun main() {
    print(diffOddEvenSum(673))
}

fun diffOddEvenSum(number: Int): Int {
    var no = number
    var sumOdd = 0
    var sumEven = 0

    while (no > 0) {
        val digit = no % 10

        if (digit % 2 != 0) sumOdd += digit
        else sumEven += digit

        no = no / 10
    }
    return sumEven - sumOdd
}