package phase1.coreFunctions.numberLogic.arrays.concepts.prefix


/*
📌 So in short:
👉 a Prefix sum = “Totals till now.”
It’s just storing the running total so you don’t redo work every time.
 */
fun main() {
    // Array consisting of money spend over last 5 days
    val array = intArrayOf(10, 30, 60, 120, 180) // Original array of money spend
    val prefixArray = prefixSum(array) // Passing an original array, the function will return its prefixSum array

    println("You can only choose from day 1 to 5th (index 0 to 4) only!")

    var l: Int
    var r: Int
    do {
        print("Choose left index (0 = day 1, 1 = day 2): ")
        l = readln().toInt()
        print("Choose right index (0 = day 1, 1 = day 2): ")
        r = readln().toInt()
    } while (l < 0 || l > 4 || r < 0 || r > 4 || l > r)
    /*
    Query to find total money spent from index 1 to 4:
    - This represents spending from day 2 to day 5
    - For a range query [l,r], we can use: prefixArray[r] - prefixArray[l-1]
    - If l=0, we can directly use prefixArray[r] since there's no need to subtract
     */

    println("From index $l to $r the total money spend is: ${if (l == 0) prefixArray[r] else prefixArray[r] - prefixArray[l - 1]}")
}

fun prefixSum(originalArray: IntArray): IntArray {
    /*
   PrefixSum at any given index is a total sum from index[0] to index[i] when you need to keep track of a sum from 
   any given point, like total amount of money spend in one month can be checked at index where month ended and 
   subtracting previous months total.
    */

    /* In prefix sum we have an array in which each index has a sum from previous indexes, so in case of 1st index
    there isn't any data before so index one is as it is so while making prefix sums, we explicitly write 1st index 
    like: prefix[0] = array[0] where an array is the original array and prefix is the array of same size as an 
    original array, but at every index it contains a sum of all previous sums
     */

    /* prefixSum array is of same size of an original array because we are not just giving one sum of all arrays,  
    but at every index it contains previous total plus current, so it will be of the same size
     */


    val size = originalArray.size

    val prefixSums =
        IntArray(size) // prefixSum array of the same size as an original array which shows spending of each day

    prefixSums[0] = originalArray[0] // first element remains same

    for (i in 1..size - 1) {
        prefixSums[i] =
            prefixSums[i - 1] + originalArray[i] // Add a previous sum and current value to get a running total
    }
    return prefixSums
}