package arrays.binarysearch

fun main() {
    val nums = intArrayOf(5, 7, 7, 8, 8, 8, 10)
    println(searchRange(nums, target = 8).contentToString())
    println(searchRangeBinarySearch(nums, target = 8).contentToString())
}

fun searchRange(nums: IntArray, target: Int): IntArray {
    val indexes = IntArray(2) { -1 }
    for (i in 0 until nums.size) {
        if (indexes[0] == -1 && nums[i] == target) {
            indexes[0] = i
        }
        if (nums[i] == target) indexes[1] = i
    }

    return indexes
}

fun searchRangeBinarySearch(nums: IntArray, target: Int): IntArray {
    val indexes = IntArray(2) { -1 }

    indexes[0] = firstPos(nums, target)
    indexes[1] = lastPos(nums, target)

    return indexes
}

fun firstPos(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    var firstPos = -1

    while (left <= right) {
        val mid = left + (right - left) / 2

        if (nums[mid] == target) {
            firstPos = mid
            right = mid - 1
        } else if (nums[mid] > target) right = mid - 1
        else left = mid + 1
    }

    return firstPos
}

fun lastPos(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1
    var lastPos = -1

    while (left <= right) {
        val mid = left + (right - left) / 2

        if (nums[mid] == target) {
            lastPos = mid
            left = mid + 1
        } else if (nums[mid] > target) right = mid - 1
        else left = mid + 1
    }

    return lastPos
}