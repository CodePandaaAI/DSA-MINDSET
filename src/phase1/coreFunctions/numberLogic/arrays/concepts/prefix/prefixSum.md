### Why We Need Prefix Sums

Imagine you have daily expenses written in an array:

`[100, 200, 300, 400, 500]`

Now, your friend asks, "How much did you spend from day 2 to day 4?" (That means the sum of `200 + 300 + 400 = 900`).

If this is a one-time question, you'll just add them manually. But what if you get 1000 such queries, like "sum from day 1 to day 3," "sum from day 2 to day 5," etc.? Doing addition repeatedly is slow.

**Prefix sum is like pre-calculating running totals once.** This makes any future range sum query a simple subtraction, saving a lot of time.

-----

### The Intuition

Using the same array: `[100, 200, 300, 400, 500]`

The **prefix sum** is a new array where each element is the sum of all previous elements up to that point.

* `prefix[0] = 100` (just the first element)
* `prefix[1] = 100 + 200 = 300`
* `prefix[2] = 100 + 200 + 300 = 600`
* `prefix[3] = 100 + 200 + 300 + 400 = 1000`
* `prefix[4] = 100 + 200 + 300 + 400 + 500 = 1500`

So, the prefix array becomes: `[100, 300, 600, 1000, 1500]`

Now, to get the sum from **index 1 to 3** (`200 + 300 + 400`), you just do:

👉 `prefix[3] - prefix[0] = 1000 - 100 = 900`

Instead of re-adding, you just subtract\! 🚀

-----

### Formal Definition

**Prefix Sum Array:** An array where each element at index `i` stores the sum of all elements from index `0` to `i` in the original array.

**Formula:**
`prefix[i] = prefix[i-1] + arr[i]`

-----

### Coding in Kotlin (Step-by-Step)

```kotlin
fun main() {
    val arr = intArrayOf(100, 200, 300, 400, 500)
    val n = arr.size

    // Step 1: create prefix array
    val prefix = IntArray(n)
    prefix[0] = arr[0]  // first is same

    // Step 2: build prefix sums
    for (i in 1 until n) {
        prefix[i] = prefix[i - 1] + arr[i]
    }

    // Example: query sum from index 1 to 3
    val l = 1
    val r = 3
    val sum = if (l == 0) prefix[r] else prefix[r] - prefix[l - 1]

    println("Sum from index $l to $r = $sum")
}
```

**Dry Run:**

* `prefix = [100, 300, 600, 1000, 1500]`
* Query (1 to 3): `prefix[3] - prefix[0] = 1000 - 100 = 900` ✅