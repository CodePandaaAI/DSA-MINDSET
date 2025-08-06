package phase1.coreFunctions.numberLogic.testingConcepts

fun main() {
    val n = 100_000
    val sb = StringBuilder()
    val start2 = System.currentTimeMillis()
    for (i in 1..n) {
        sb.append("a")
    }
    val end2 = System.currentTimeMillis()
    println("StringBuilder took ${end2 - start2} ms")
}