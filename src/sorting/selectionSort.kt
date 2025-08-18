package sorting

fun main() {
    print(selectionSort(intArrayOf(7, 2, 1, 5, 6, 4, 3)).contentToString())
}

fun selectionSort(arr: IntArray): IntArray {
    if (arr.size <= 1) return arr
    for (i in 0 until arr.size - 1) {
        var minIndex = i
        for (j in i + 1 until arr.size) {
            if (arr[j] < arr[minIndex]) {
                minIndex = j
            }
        }
        val temp = arr[minIndex]
        arr[minIndex] = arr[i]
        arr[i] = temp
    }
    return arr
}