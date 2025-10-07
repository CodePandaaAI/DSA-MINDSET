package arrays.hashing

fun main() {
    val testArray = intArrayOf(2, 7, 11, 15)
    val target = 13

    val result = twoSum(testArray, target)
    print(result.contentToString())
}
// O(n^2)
//fun twoSum(array: IntArray, target: Int): IntArray {
//    for (i in array.indices - 1) {
//        for (j in i + 1 until array.size) {
//            if (array[i] + array[j] == target) return intArrayOf(i, j)
//        }
//    }
//    return intArrayOf()
//}

// 0(n)
fun twoSum(nums: IntArray, target: Int): IntArray {
    if (nums.size < 2) return intArrayOf()

    val seen = mutableMapOf<Int, Int>()

    for (i in nums.indices) {
        if (seen.containsKey(target - nums[i])) {
            val seenIndex = seen.getValue(target - nums[i])
            return intArrayOf(seenIndex, i)
        }
        seen.put(nums[i], i)
    }
    return intArrayOf()
}