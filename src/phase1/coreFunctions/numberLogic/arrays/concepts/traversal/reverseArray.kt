package phase1.coreFunctions.numberLogic.arrays.concepts.traversal

fun main() {
    val arr = intArrayOf(1, 2, 3, 4, 5)

    var left = 0
    var right = arr.size-1

    while (left<right){
        val temp = arr[right]
        arr[right] = arr[left]
        arr[left] = temp
        left++
        right--
    }
    print(arr.contentToString())
}