### The Connection: Arrays and Prefix Sums

So far, we've thought of prefix sums as "running totals." When applied to arrays, this concept becomes extremely powerful because many problems involve asking about ranges of numbers.

---

### The Power of Prefix Sums in Arrays

Consider an array of daily sales for a shop:

`sales = [5, 7, 3, 9, 6]`

If your boss asks, "What were the total sales from day 2 to day 4?" (indices 1 to 3), you'd sum `sales[1] + sales[2] + sales[3] = 7 + 3 + 9 = 19`. Doing this directly takes **O(n)** time for each query. This is slow if you get 1000 similar requests. 🚨

---

### Building the Prefix Sum Array

We can build a helper array where each index stores the total sales up to that point. The formula is:

* `prefix[0] = sales[0]`
* `prefix[i] = prefix[i-1] + sales[i]`

For our sales example:

* `sales = [5, 7, 3, 9, 6]`
* `prefix = [5, 12, 15, 24, 30]`

Now, finding the total sales for any range is simple:

* **Total sales from index 0 to `i`:** `prefix[i]`
* **Total sales from index `l` to `r`:** `prefix[r] - prefix[l-1]`

---

### Example Queries

* **Sales from day 2 to 4 (index 1 to 3):**
  `prefix[3] - prefix[0] = 24 - 5 = 19` ✅
* **Sales from day 1 to 5 (index 0 to 4):**
  `prefix[4] = 30` ✅

Now, each query takes just **O(1)** time. While building the prefix array takes **O(n)** time initially, answering 1000 queries becomes **O(n + q)** instead of **O(n * q)**, which is much more efficient.

---

### Real-World Analogy

Think of an **electricity meter**.  If you want to know how much electricity was used between day 10 and day 20, you don't need to check each day's usage. You just subtract the meter reading from day 9 from the reading of day 20.

---

### Summary

✅ Prefix sums are one of the most fundamental tricks in **Data Structures and Algorithms (DSA)**. They are used widely in competitive programming and other applications for range queries, subarray problems, and more.