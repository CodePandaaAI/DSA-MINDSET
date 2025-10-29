package arrays.arraymanuplation

fun main() {
    val nums = intArrayOf(1, 2, 3, 4)
    println("Brute Force: ${prodArray(nums).contentToString()}")
//    println("Efficient: ${prodArrayEfficient(nums).contentToString()}")
    println("Efficient: ${prodArrayEfficientN(nums).contentToString()}")

    println("Prod: ${prodArrayPrefixSuffix(nums).contentToString()}")
}

fun prodArray(nums: IntArray): IntArray {
    val n = nums.size
    val arr = IntArray(n) { 1 }
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (j == i)
                continue
            arr[i] *= nums[j]
        }
    }
    return arr
}

fun prodArrayEfficient(nums: IntArray): IntArray {
    if (nums.size == 1) return nums

    val n = nums.size
    var prefixSum = 1
    val arr = IntArray(4) { 1 }
    for (i in 1 until n) {
        prefixSum = prefixSum * nums[i]
    }

    for (i in 0 until n) {
        arr[i] = prefixSum / nums[i]
    }

    return arr
}

fun prodArrayEfficientN(nums: IntArray): IntArray {
    if (nums.size == 1) return nums

    val n = nums.size
    val prefixSum = IntArray(n + 1)
    prefixSum[0] = 1
    val arr = IntArray(n) { 1 }
    for (i in 1 ..n) {
        prefixSum[i] = prefixSum[i - 1] * nums[i - 1]
    }

    println("Prefix: ${prefixSum.contentToString()}")

    return intArrayOf()
}

fun prodArrayPrefixSuffix(nums: IntArray): IntArray {
    val n = nums.size
    // 1 2 3 4
    // 1 1 2 6
    //
    val answer = IntArray(n) { 1 } // Create our final answer array, fill with 1s

    // --- PASS 1: Calculate Left Products ---
    // Store the product of all elements to the LEFT of i in answer[i]
    var prefixProduct = 1
    for (i in 0 until n) {
        answer[i] = prefixProduct  // Set answer[i] to the product of everything to its left
        prefixProduct *= nums[i]   // Update prefixProduct for the *next* iteration
    }
    println("Answer before right: ${answer.contentToString()}")
    // After this loop, answer = [1, 1, 2, 6]

    // --- PASS 2: Calculate Right Products & Combine ---
    // Now, go backwards and multiply in the product of all elements to the RIGHT of i
    var suffixProduct = 1
    for (i in n - 1 downTo 0) {
        answer[i] *= suffixProduct // answer[i] = (product of left) * (product of right)
        suffixProduct *= nums[i]   // Update suffixProduct for the *next* iteration
    }
    // Let's trace this pass:
    // i = 3: answer[3] = 6 * 1 = 6.  suffixProduct becomes 4
    // i = 2: answer[2] = 2 * 4 = 8.  suffixProduct becomes 12
    // i = 1: answer[1] = 1 * 12 = 12. suffixProduct becomes 24
    // i = 0: answer[0] = 1 * 24 = 24. suffixProduct becomes 24

    // Final answer = [24, 12, 8, 6]
    return answer
}