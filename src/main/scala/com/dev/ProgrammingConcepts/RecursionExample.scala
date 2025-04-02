package com.dev.ProgrammingConcepts

object RecursionExample {
  def A(n: Int): Unit = {
    if (n > 0) {
      println(n)
      A(n - 1)
    }
  }

  def main(args: Array[String]): Unit = {
    val x = 3
    A(x)
  }
}

/*

### 🧠 **Code Context**

```scala
def A(n: Int): Unit = {
  if (n > 0) {
    println(n)
    A(n - 1)
  }
}
```

Calling `A(3)` triggers recursive calls: `A(3) → A(2) → A(1) → A(0)`. Let's see **what happens in memory**.

---

### 🗂️ Memory Layout in a Running Program:

1. **Code Segment** – where compiled code (like the definition of function `A`) resides.
2. **Stack Segment** – stores **function calls**, **local variables**, **parameters**, and **return addresses**.
3. **Heap Segment** – used for dynamically allocated memory (not used in this example).

---

### 📦 Stack in Recursion (Step-by-step):

Every time a function calls itself, a new **stack frame** is pushed onto the call stack.

#### Step 1: Call `A(3)`
- Stack Frame: `{ n = 3 }`
- Executes `println(3)`
- Calls `A(2)`

#### Step 2: Call `A(2)`
- Stack Frame: `{ n = 2 }`
- Executes `println(2)`
- Calls `A(1)`

#### Step 3: Call `A(1)`
- Stack Frame: `{ n = 1 }`
- Executes `println(1)`
- Calls `A(0)`

#### Step 4: Call `A(0)`
- Base case hit (`n > 0` is false), does **nothing**
- Function returns immediately

---

### 🔁 Unwinding the Stack

After hitting the base case, each function returns one by one:

- `A(0)` returns → `A(1)` finishes → removed from stack
- `A(2)` finishes → removed
- `A(3)` finishes → removed

---

### 🧠 Summary:

| Memory Part     | Role                                                                 |
|------------------|----------------------------------------------------------------------|
| Code             | Stores the compiled function definition of `A`                      |
| Stack            | Grows with each recursive call (each call is **independent**)        |
| Heap             | Not involved here (no `new` or allocation)                          |

---

### ⚠️ Important Note:
If recursion goes too deep (e.g., `A(100000)`), the **stack overflows**, resulting in a `StackOverflowError`.

 */