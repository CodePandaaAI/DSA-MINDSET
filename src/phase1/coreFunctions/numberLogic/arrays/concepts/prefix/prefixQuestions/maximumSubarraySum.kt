package phase1.coreFunctions.numberLogic.arrays.concepts.prefix.prefixQuestions

fun main() {
    maximumSubarraySum(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4))
}

fun maximumSubarraySum(nums: IntArray) {
    var currentSum = nums[0]
    var max = nums[0]

    for (i in 1 until nums.size) {
        currentSum = maxOf(nums[i], currentSum + nums[i])
        max = maxOf(currentSum, max)
    }
    print(max)
}