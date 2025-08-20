package phase1.coreFunctions.numberLogic.arrays.concepts.prefix.prefixQuestions

/*
1. Subarray Sum Queries

👉 Problem: You’re given an array of size N. You’ll be asked Q times:
“What is the sum of elements from index L to R?”

Naive way → Add elements one by one → O(N) per query.

Prefix sum way → Precompute once, then answer in O(1):

Array = [2, 4, 5, 7, 1]
Prefix = [2, 6, 11, 18, 19]
 */

fun main() {
    val originalArray = intArrayOf(2, 4, 5, 7, 1)
    val prefixArray = prefixArray(originalArray)

    println(query(prefixArray, 2, 4)) // 0-based [1,3] → 1-based [2,4] => 16
    println(query(prefixArray, 1, 5)) // whole array => 19

    // Multiple queries demo
    val queries = listOf(1 to 1, 1 to 3, 3 to 5, 2 to 2)
    for ((L, R) in queries) println("sum[$L,$R] = ${query(prefixArray, L, R)}")
}

fun prefixArray(originalArray: IntArray): IntArray {
    val size = originalArray.size
    val prefixSumArray = IntArray(size)

    prefixSumArray[0] = originalArray[0]

    for (i in 1..size - 1) {
        prefixSumArray[i] = prefixSumArray[i - 1] + originalArray[i]
    }
    return prefixSumArray
}

fun query(prefixArray: IntArray, l: Int, r: Int): Int {
    val l = if (l > 0) l - 1 else l
    val r = if (r > 0) r - 1 else r
    require(l in 0 until prefixArray.size && r in 0 until prefixArray.size) { "L,R out of bounds" }
    require(l <= r) { "l must be <= r" }
    return if (l == 0) prefixArray[r] else prefixArray[r] - prefixArray[l - 1]
}