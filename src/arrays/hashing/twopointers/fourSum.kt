package arrays.hashing.twopointers

fun main() {
    print(fourSum(intArrayOf(1000000000,1000000000,1000000000,1000000000), -294967296))
}

fun fourSum(nums: IntArray, target: Int): List<List<Int>> {
    nums.sort()
    val results = mutableListOf<List<Int>>()
    val n = nums.size

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            for (k in j + 1 until n) {
                for (q in k + 1 until n) {
                    if (nums[i].toLong() + nums[j] + nums[k] + nums[q] == target.toLong() && !results.contains(listOf(nums[i], nums[j], nums[k], nums[q]))) {
                        results.add(listOf(nums[i], nums[j], nums[k], nums[q]))
                        break
                    }
                    continue
                }
            }
        }
    }
    return results
}