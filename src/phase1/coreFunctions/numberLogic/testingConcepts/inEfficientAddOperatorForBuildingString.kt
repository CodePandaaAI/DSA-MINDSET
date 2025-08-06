package phase1.coreFunctions.numberLogic.testingConcepts

fun main() {
    var str = ""  // Start empty
    val startTime = System.currentTimeMillis()  // Start clock
    for (i in 1..100000) {  // Add 10,000 times
        str = str + "a"  // Add one "a" each time
    }
    val endTime = System.currentTimeMillis()  // Stop clock
    println("Time taken: ${endTime - startTime} milliseconds")  // How long?

}