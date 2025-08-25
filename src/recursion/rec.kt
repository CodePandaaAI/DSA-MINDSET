package recursion

//fun main() {
//    countDown(5)
//}
//
//fun countDown(n: Int) {
//    println("n = $n")
//    if(n > 0) {
//        countDown(n - 1)
//    }
//}

fun deepRecursion(n: Int) {
    if (n == 0) return
    deepRecursion(n - 1)
}

fun main() {
    println(fact(5))
}

fun fact(n: Int): Int {
    var fact = 1

//    for(i in n downTo 1){
//        fact = fact * i
//    }
    return fact
}

fun factRec(n: Int): Int {
    if (n <= 1) return 1
    return n * factRec(n - 1)
}
