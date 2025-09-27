package phase1.coreFunctions.numberLogic.arrays.concepts.traversal

fun main() {
    val arr = intArrayOf(1, 2, 1, 3, 3, 4, 2, 4, 5, 8, 8, 3, 3, 3, 4)
    removeDuplicates(arr)
    print(arr.contentToString())
}

//fun removeDuplicates(arr: IntArray) {
//    val set = HashSet<Int>()
//    var left = 0
//    var right = 0
//
//    while (right < arr.size) {
//        if (!set.contains(arr[left])) {
//            set.add(arr[left])
//            left++
//            right++
//            continue
//        }
//        if (!set.contains(arr[right])) {
//            val temp = arr[right]
//            arr[right] = arr[left]
//            arr[left] = temp
//            set.add(arr[left])
//            left++
//            right++
//            continue
//        }
//        right++
//    }
//}

fun removeDuplicates(arr: IntArray): Int {
    if (arr.isEmpty()) return 0
    var left = 0
    for (right in 1 until arr.size) {
        if (arr[right] != arr[left]) {
            left++
            arr[left] = arr[right]
        }
    }
    return left + 1 // new length of unique portion
}


//fun removeDuplicates(arr: IntArray) {
//    val set = HashSet<Int>()
//    var left = 0
//    var right = arr.size - 1
//
//    while (left <= right) {
//        if (set.contains(arr[left])) {
//
//            val temp = arr[left]
//            arr[left] = arr[right]
//            arr[right] = temp
//            left++
//            right--
//
//        } else {
//            set.add(arr[left])
//            left++
//            right--
//        }
//    }
//}