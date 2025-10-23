package arrays.hashing.twopointers

fun main() {
    val players = intArrayOf(-1, 0, 1, 2, -1, -4)
    print(threeSumBruteForceTrial(players))
}

fun threeSumOnCube(nums: IntArray): List<List<Int>> {
    val triplets = mutableListOf<List<Int>>()
    val n = nums.size

    for (i in 0 until n) {
        for (j in i + 1 until n) {
            for (k in j + 1 until n) {
                if (nums[i] + nums[j] + nums[k] == 0) {
                    val sorted = listOf(nums[i], nums[j], nums[k]).sorted()
                    if(triplets.contains(sorted)) continue
                    triplets.add(sorted)
                }
            }
        }
    }
    return triplets
}

fun threeSumBruteForceTrial(nums: IntArray): List<List<Int>> {
    val triplets = mutableListOf<List<Int>>()
    val n = nums.size
    var right = 0

    while (right < n) {
        outerLoop@ for (j in right + 1 until n) {
            for (k in j + 1 until n) {
                if (nums[right] + nums[j] + nums[k] == 0) {
                    val sorted = listOf(nums[right], nums[j], nums[k]).sorted()
                    if (!triplets.contains(sorted)) {
                        triplets.add(sorted)
                        right = k + 1
                        break@outerLoop
                    }
                    right++
                    break@outerLoop
                }
            }
        }
    }
    return triplets
}

fun threeSumEfficient(nums: IntArray): List<List<Int>> {
    // This set will store our unique triplets.
    // Using a Set automatically handles all duplicates for us!
    val results = mutableSetOf<List<Int>>()

    // STEP 1: Sort the array. This is the pass key.
    nums.sort() // Now nums is [-4, -1, -1, 0, 1, 2]

    // STEP 2: Main loop to pick the first number (nums[i]).
    // We only need to go up to n-2 because we need at least two other numbers.
    for (i in 0 until nums.size - 2) {

        // SMART SKIP 1: Skip duplicate first numbers.
        // If i > 0 (we're not at the start) AND
        // nums[i] is the same as the one before it (nums[i-1]),
        // then we've already found all triplets for this number. So, skip.
        if (i > 0 && nums[i] == nums[i - 1]) {
            continue
        }

        // STEP 3: Set up the two pointers for the rest of the array.
        var left = i + 1
        var right = nums.size - 1

        // This is the "target" our two pointers need to find.
        val target = 0 - nums[i] // e.g., if nums[i] is -4, the target is 4.

        // STEP 4: The two-pointer "converging" loop.
        while (left < right) {
            val sum = nums[left] + nums[right]

            when {
                // Case 1: Found a match!
                sum == target -> {
                    // Add the valid triplet to our set.
                    results.add(listOf(nums[i], nums[left], nums[right]))

                    // SMART SKIP 2: Skip duplicates for the 'left' and 'right' pointers
                    // to avoid adding the same triplet multiple times.
                    while (left < right && nums[left] == nums[left + 1]) left++
                    while (left < right && nums[right] == nums[right - 1]) right--

                    // Move both pointers to the next unique elements.
                    left++
                    right--
                }

                // Case 2: The sum is too small. Need a bigger number.
                sum < target -> left++

                // Case 3: The sum is too big. Need a smaller number.
                sum > target -> right--
            }
        }
    }

    // Convert the Set (which has only unique triplets) to the List required by the function.
    return results.toList()
}