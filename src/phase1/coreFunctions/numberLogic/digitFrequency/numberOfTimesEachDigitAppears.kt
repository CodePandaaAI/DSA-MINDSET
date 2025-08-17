package phase1.coreFunctions.numberLogic.digitFrequency

fun main() {
    println(digitFrequency(235678900))
}

fun digitFrequency(number: Int): Map<Int, Int> {
    var num = number
    val map = mutableMapOf<Int, Int>() // emptymap [] -> 0 -> 0 , 0 = 0

    while(num> 0) {
        val digit = num % 10
        map.put(digit, map.getOrDefault(digit, 0) + 1) // PUT(KEY, VALUE)
//      map[digit] = map.getOrDefault(digit, 0) + 1
        num /= 10
    }
    return map.toMap()
}

//fun digitFrequency(number: Int): String {
//    // Extract digit
//    var zero = 0
//    var one = 0
//    var two = 0
//    var three = 0
//    var four = 0
//    var five = 0
//    var six = 0
//    var seven = 0
//    var eight = 0
//    var nine = 0
//
//    var num = number
//
//    while(num> 0) {
//        val digit = num % 10
//
//        when (digit) {
//            0 -> zero++
//            1 -> one++
//            2 -> two++
//            3 -> three++
//            4 -> four++
//            5 -> five++
//            6 -> six++
//            7 -> seven++
//            8 -> eight++
//            9 -> nine++
//        }
//        num /= 10
//    }
//
//    val result = StringBuilder()
//    if (zero > 0) result.append("0:$zero ")
//    if (one > 0) result.append("1:$one ")
//    if (two > 0) result.append("2:$two ")
//    if (three > 0) result.append("3:$three ")
//    if (four > 0) result.append("4:$four ")
//    if (five > 0) result.append("5:$five ")
//    if (six > 0) result.append("6:$six ")
//    if (seven > 0) result.append("7:$seven ")
//    if (eight > 0) result.append("8:$eight ")
//    if (nine > 0) result.append("9:$nine")
//
//    return result.toString()
//}