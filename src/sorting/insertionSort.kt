package sorting

fun insertionSort(arr: IntArray): List<Int> {
    val sortedArray = mutableListOf<Int>()
    sortedArray.add(arr[0])

    for (i in 1..arr.size - 1) {
        for (j in 0..sortedArray.size - 1) {
            var minIndex = j
            if (arr[i] < sortedArray[j]) {
                minIndex = j
            } else {
                sortedArray[0]
            }
        }
    }

    return sortedArray
}

fun insertionSortD(arr: IntArray): IntArray {
    // The outer loop starts at the second element (index 1)
    // because the first element is considered the 'sorted' part.
    for (i in 1 until arr.size) {
        val key = arr[i]
        var j = i - 1

        // The inner loop shifts elements in the sorted subarray
        // that are greater than the 'key'.
        while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j]
            j--
        }

        // Insert the 'key' into its correct position.
        arr[j + 1] = key
    }
    return arr
}

fun main() {
//    val numbers = intArrayOf(5, 2, 4, 6, 1, 3)
//    println("Original array: ${numbers.contentToString()}")
//    insertionSortD(numbers)
//    println("Sorted array: ${numbers.contentToString()}")
    print(sum(100000))
}

fun sum(n: Int): Int {
    if (n == 1) return 1
    return n + sum(n - 1)
}