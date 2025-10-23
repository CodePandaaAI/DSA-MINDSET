package arrays.hashing.twopointers

fun main() {
    val players = intArrayOf(-1, 0, 1, 2, -1, -4)
    print(threeSumBruteForce(players))
}

fun threeSum(nums: IntArray): List<List<Int>> {
    val triplets = mutableListOf<List<Int>>()
    val n = nums.size

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            for (k in j + 1 until n) {
                if (nums[i] + nums[j] + nums[k] == 0) triplets.add(listOf(nums[i], nums[j], nums[k]))
            }
        }
    }
    return triplets
}

fun threeSumBruteForce(nums: IntArray): List<List<Int>> {
    val result = mutableListOf<List<Int>>()
    val n = nums.size
    val dup = mutableListOf<Int>()
    var right = 0


    while (right < n) {

        for (j in right + 1 until n) { // Start from i+1 to not reuse the same element

            right++
            for (k in j + 1 until n) { // Start from j+1
                if (nums[right] + nums[j] + nums[k] == 0 && !dup.contains(j) && !dup.contains(k)) {

                    val triplet = listOf(nums[right], nums[j], nums[k])

                    result.add(triplet)
                    dup.add(j)
                    dup.add(k)
                    right = k + 1
                }
            }
        }
    }
    return result
}