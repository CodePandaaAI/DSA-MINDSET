package arrays.hashing

fun main() {
    val array = intArrayOf(3, 4, 7, 2, -3, 1, 4)
    val target = 7
    subarraySumEqualK(array, target)
    print(subarraySumEqualK(array, target))
}
// Sliding window fails here because it is mostly applicable for only positive inputs like if size increases shrink else expands, but with negative numbers, it fails, so prefix plus hashmap is better
//fun subarraySumEqualK(nums: IntArray, k: Int): Int {
//    var left = 0
//    var sum = nums[left]
//    var count = if (sum == k) 1 else 0
//    for (i in 1 until nums.size) {
//        sum += nums[i]
//        if (sum == k) {
//            count++
//            continue
//        }
//        while (sum > k) {
//            sum = sum - nums[left]
//            left++
//        }
//        if (sum == k) count++
//    }
//    return count
//}

fun subarraySumEqualK(nums: IntArray, k: Int): Int {
    val prefixSumCount = mutableMapOf(0 to 1) // sum 0 occurs once (empty subarray)
    var currentSum = 0
    var count = 0

    for (num in nums) {
        currentSum += num
        // If currentSum - k existed before, we found a valid subarray
        count += prefixSumCount.getOrDefault(currentSum - k, 0)
        prefixSumCount[currentSum] = prefixSumCount.getOrDefault(currentSum, 0) + 1
    }

    return count
}