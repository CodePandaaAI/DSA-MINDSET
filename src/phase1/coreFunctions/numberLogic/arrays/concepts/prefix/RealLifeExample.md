### Real-World Examples of Prefix Sums

---

#### 1. Bank Transactions (Running Balance)

Imagine you have a bank account with these daily transactions:

* **Day 1:** +100
* **Day 2:** -20
* **Day 3:** +50
* **Day 4:** -10

To find your balance at the end of each day, you don't re-add everything from the beginning. You just keep a running total:

* **Day 1:** 100
* **Day 2:** `100 - 20 = 80`
* **Day 3:** `80 + 50 = 130`
* **Day 4:** `130 - 10 = 120`

👉 This running balance is exactly what a **prefix sum** is. It saves you from recalculating everything from scratch.

---

#### 2. Supermarket Bill

Suppose you're buying items one by one:

* **Milk:** ₹50
* **Bread:** ₹40
* **Butter:** ₹80
* **Juice:** ₹60

You want to know your total spending after each item. Instead of adding from the beginning each time, you keep a cumulative total:

* **After Milk:** ₹50
* **After Bread:** `50 + 40 = ₹90`
* **After Butter:** `90 + 80 = ₹170`
* **After Juice:** `170 + 60 = ₹230`

Again, this is a **prefix sum** at work.

---

#### 3. Marathon Distance

Imagine a marathon with checkpoints every 1 km. At each checkpoint, a board shows the total distance you've covered from the start:

* **Checkpoint 1:** 1 km
* **Checkpoint 2:** 2 km
* **Checkpoint 3:** 3 km
* ...and so on.

This is a real-life example of a **prefix sum**: it tells you the cumulative distance covered up to that point.

---

#### 4. Electricity Bill Units

Each day your electricity meter shows the units consumed:

* **Day 1:** 5 units
* **Day 2:** 8 units
* **Day 3:** 12 units
* **Day 4:** 3 units

Instead of adding the daily units, the meter directly shows the total units consumed to date:

* **Day 1:** 5
* **Day 2:** `5 + 8 = 13`
* **Day 3:** `13 + 12 = 25`
* **Day 4:** `25 + 3 = 28`

This is another example of a **prefix sum**.

---

### In Short

📌 A **prefix sum** is simply the **"total till now."** It's a way of storing a running total so you don't have to re-do work every time you need a sum.