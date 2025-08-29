package phase1.coreFunctions.numberLogic.arrays.concepts.traversal

fun main() {
    val arr = intArrayOf(3, 2, 3, 6, 3, 3, 7, 8, 3, 2, 3,3,3,3,5, 3, 4, 3, 1, 1, 2, 7, 9, 0, 3, 3, 3, 3, 77, 88, 91, 2, 3, 3)
    var left = 0
    var right = arr.size - 1
    while (left <= right) {
        if (arr[left] == 3 && arr[right] != 3) {
            arr[left] = arr[right]
            arr[right] = 3
            left++
            right--
            continue
        }
        else if(arr[right] == 3){
            right--
            continue
        }
        left++

    }
    println(arr.contentToString())
    print(removeElementKeepOrder(intArrayOf(3, 2, 3, 6, 3, 3, 7, 8, 3, 2, 3,3,3,3,5, 3, 4, 3, 1, 1, 2, 7, 9, 0, 3, 3, 3, 3, 77, 88, 91, 2, 3, 3), 3))
}

// Remove all x while preserving order. Returns the new length.
fun removeElementKeepOrder(a: IntArray, x: Int): Int {
    var w = 0
    for (i in a.indices) {
        if (a[i] != x) {
            a[w] = a[i]   // overwrite in-place
            w++
        }
    }
    // optional: fill tail for visualization
    print(a.copyOf(w).contentToString())
    return w
}

//fun main() {
//    val arr = intArrayOf(3, 2, 3, 6, 3, 3, 7, 8, 3, 2, 5, 3, 4, 3, 1, 1, 2, 7, 9, 0, 3, 3, 3, 3, 77, 88, 91, 2, 3, 4)
//    var left = 0
//    var right = arr.size - 1
//
//    while (left <= right) {
//        if (arr[left] == 3) {
//            arr[left] = arr[right]
//            right--  // shrink from right
//        } else {
//            left++  // only advance when good element stays
//        }
//    }
//
//    println("New length = ${right + 1}")
//    println("Modified array = ${arr.copyOf(right + 1).contentToString()}")
//}
