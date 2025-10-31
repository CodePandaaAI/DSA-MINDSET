package arrays.binarysearch

fun main() {
    val nums = intArrayOf(3,4,5,1,2)
    print(findMinimumInRotatedSortedArray(nums))
}

fun findMinimumInRotatedSortedArray(nums: IntArray): Int {
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