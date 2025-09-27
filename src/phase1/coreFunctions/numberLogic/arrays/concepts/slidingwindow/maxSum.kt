package phase1.coreFunctions.numberLogic.arrays.concepts.slidingwindow

fun main() {
    val arr = intArrayOf(1, 5, 6, 7, 8, 9, 4, 5, 6, 7, 7, 7, 7)

    print(maxSum(arr, 3))

}

fun maxSum(arr: IntArray, k: Int): Int {
    var windowSum = 0

    for (i in 0..k - 1) windowSum += arr[i]

    var maxWindowSum = windowSum

    for (w in k until arr.size){
        windowSum += arr[w] - arr[w-k]

        maxWindowSum = maxOf(windowSum, maxWindowSum)
    }

    return maxWindowSum
}