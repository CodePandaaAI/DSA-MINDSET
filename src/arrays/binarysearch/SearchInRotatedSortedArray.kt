package arrays.binarysearch

fun main() {
    val nums = intArrayOf(5, 1, 3)
    val target = 5
    print(searchInArray(nums, target))
}

fun searchInArray(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2

        if (target == nums[mid]) return mid

        if (nums[left] <= nums[mid]) {
            if (target >= nums[left] && target < nums[mid]) right = mid - 1
            else left = mid + 1
        } else {
            if (target > nums[mid] && target <= nums[right]) left = mid + 1
            else right = mid - 1
        }
    }
    return -1
}

// Tried But failed
fun searchInRotatedArray(nums: IntArray, target: Int): Int {
    var left = 0
    var right = nums.size - 1

    if (target <= nums[right]) {
        left = findMin(nums)
    }
    if (target == nums[right]) return right

    while (left < right) {
        val mid = left + (right - left) / 2
        println("mid: $mid")
        if (target == nums[mid]) return mid
        if (nums[mid] >= target) right = mid
        if (nums[mid] <= target) right = mid
    }
    return -1
}

fun findMin(nums: IntArray): Int {
    var left = 0
    var right = nums.size - 1

    while (left < right) {
        val mid = left + (right - left) / 2

        if (nums[mid] > nums[right]) {
            left = mid + 1
        } else if (nums[mid] <= nums[right]) {
            right = mid
        }
    }
    return left
}