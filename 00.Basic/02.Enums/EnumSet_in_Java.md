# EnumSet in Java

## Introduction

`EnumSet` is a special `Set` implementation designed specifically for storing enum constants.

An `EnumSet` is required instead of a standard enum when you need to store, manage, or manipulate a **group or collection** of multiple enum constants (like a set of flags or selected states), rather than working with a single enum value at a time.

---

## The Core Problem with Regular Enums

When you define a standard enum, you can only assign **one** state to a variable at a time:

```java
enum Day { MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY }

// You can only pick ONE day
Day favoriteDay = Day.FRIDAY;
```

If you need to represent a group of days (like `WEEKEND`), a single enum variable cannot hold both `SATURDAY` and `SUNDAY`. You need a **collection**.

---

## Why Standard Collections (HashSet) Are Inefficient

A `HashSet` has to maintain things like:

```
HashSet
 ├── buckets
 ├── entries/nodes
 ├── references
 └── hash-related information
```

While this works, it is highly inefficient for enums because a `HashSet`:

- Allocates memory for internal entry objects and buckets.
- Computes complex hashcodes for every element.

`EnumSet` can essentially store the membership information as a **bit vector**.

---

## Internal Working

### 1. What Is a Bit-Vector?

A bit is either:

```
0 or 1
```

A bit-vector is simply a collection of these bits.

For example:

```
00000000
```

has 8 bits.

Suppose we have:

```java
enum Day {
    MONDAY,     // 0
    TUESDAY,    // 1
    WEDNESDAY,  // 2
    THURSDAY,   // 3
    FRIDAY,     // 4
    SATURDAY,   // 5
    SUNDAY      // 6
}
```

Each enum constant has an ordinal position:

| Constant  | Ordinal |
|-----------|:-------:|
| MONDAY    | 0       |
| TUESDAY   | 1       |
| WEDNESDAY | 2       |
| THURSDAY  | 3       |
| FRIDAY    | 4       |
| SATURDAY  | 5       |
| SUNDAY    | 6       |

### 2. How Does EnumSet Use This?

Suppose we create:

```java
EnumSet<Day> weekend =
    EnumSet.of(Day.SATURDAY, Day.SUNDAY);
```

We can represent this as:

```
Day:       M  T  W  T  F  S  S
Ordinal:   0  1  2  3  4  5  6
Selected:  0  0  0  0  0  1  1
```

- **`1`** means: this enum value is present in the set.
- **`0`** means: this enum value is not present.

So internally, conceptually, we have:

```
00000110
```

> The exact bit orientation in the actual implementation is important if you're reading the source, but conceptually the mapping is:
>
> **enum ordinal → bit position**

> **Note (Very Important):** `EnumSet` does **NOT** store the enum objects in the bit-vector.
> - Bit = `1` → enum is in the set.
> - Bit = `0` → enum is not in the set.

---

## Important Methods

| Method                    | Purpose                            |
|---------------------------|-------------------------------------|
| `EnumSet.allOf()`         | All enum constants                 |
| `EnumSet.noneOf()`        | Empty set                          |
| `EnumSet.of()`             | Selected constants                 |
| `EnumSet.complementOf()`  | Constants not in the given set     |
| `add()`                   | Add constant                       |
| `remove()`                 | Remove constant                    |
| `contains()`               | Check constant                     |
| `size()`                   | Number of elements                 |
| `isEmpty()`                 | Check empty                        |
| `clear()`                   | Remove all                         |
