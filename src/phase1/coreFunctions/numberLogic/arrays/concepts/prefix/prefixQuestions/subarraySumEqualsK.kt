package phase1.coreFunctions.numberLogic.arrays.concepts.prefix.prefixQuestions

fun main() {
    val arr = intArrayOf(1, 2, 3, 5, 7, 22, 54, 90, 90, 222)
    print(subarraySumEqualK(arr, 22))
}


fun subarraySumEqualK(array: IntArray, k: Int): Int {
    var count = 0
    var prefixSum = 0

    val map = hashMapOf<Int, Int>()
    map[0] = 0

    for (i in 0 until array.size) {
        prefixSum += array[i]
        if(map.contains(prefixSum - k)) {
            count += map[prefixSum - k]!!
        }

        map[prefixSum] = map.getOrDefault(prefixSum, 0) + 1
    }
    return count
}

//fun subarraySumEqualK(array: IntArray, k: Int): Int {
//    val arr = array
//    val hashMap = hashMapOf<Int, Int>()
//
//    for (i in 0 until arr.size) {
//        var sum = 0
//        for (j in i until arr.size) {
//            sum += arr[j]
//            if (sum == k) hashMap[k] = hashMap.getOrDefault(k, 0) + 1
//        }
//    }
//    return hashMap.getOrDefault(k, 0)
//}