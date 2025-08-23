package sorting

fun main() {
    print(bubbleSort1(intArrayOf(7, 2, 1, 5, 6, 4, 3)).contentToString())
}

fun bubbleSort1(arr: IntArray): IntArray {
    if (arr.size <= 1) return arr
    for (i in 0 until arr.size-1) {
        var isSorted = true
        for (j in 0 until arr.size - i - 1) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
                isSorted = false
            }
        }
        if (isSorted) return arr
    }
    return arr
}