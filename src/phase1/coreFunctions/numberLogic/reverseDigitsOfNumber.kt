package phase1.coreFunctions.numberLogic

fun main() {
    println(reverseDigitsOfNumber(1200))
}

// What if input is 1200? leading 0's?
fun reverseDigitsOfNumber(number: Int): Int {
    var num = number
    var reversed = 0
    while(num > 0){
        val digit = num % 10
        if(digit == 0) {
            num = num / 10
            continue
        }
        reversed = reversed * 10 + digit
        num = num / 10
    }
    return reversed
}

// String Builder Solution
//fun reverseDigitsOfNumber(number: Int): Int {
//    var num = number
//    val str = StringBuilder()
//
//    while(num > 0){
//        val digit = num % 10
//        str.append(digit)
//        num = num / 10
//    }
//    return str.toString().toInt()
//}

// What if input is 1200? leading 0's?

// Pure Math Solution more efficient
//fun reverseDigitsOfNumber(number: Int): Int {
//    var num = number
//    var reversed = 0
//    while(num > 0){
//        val digit = num % 10
//        reversed = reversed * 10 + digit
//        num = num / 10
//    }
//    return reversed
//}

