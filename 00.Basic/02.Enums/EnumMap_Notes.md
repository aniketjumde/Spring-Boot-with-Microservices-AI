# EnumMap in Java — Complete Notes

---

## 1. What is EnumMap?

`EnumMap` is a **specialized `Map` implementation** in Java, designed specifically to be used with **enum keys**. It is part of the `java.util` package.

- It implements the `Map<K, V>` interface.
- All keys in an `EnumMap` **must belong to a single enum type**, which is specified explicitly (or inferred) when the map is created.
- Internally, `EnumMap` represents the map as an **array**, indexed by the enum constant's **ordinal** (its position in the enum declaration).

### Related concepts (how they differ)

| Type       | Purpose                                             |
|------------|------------------------------------------------------|
| `enum`     | Defines a fixed set of constants.                     |
| `EnumSet`  | Stores a **set** of enum values.                      |
| `EnumMap`  | Stores a **mapping** from an enum value to some value.|

### Example

```java
enum Signal {
    RED, YELLOW, GREEN
}

EnumMap<Signal, Integer> duration = new EnumMap<>(Signal.class);
duration.put(Signal.RED, 60);
duration.put(Signal.YELLOW, 5);
duration.put(Signal.GREEN, 45);
```

```java
enum Day {
    MONDAY, TUESDAY, WEDNESDAY
}

EnumMap<Day, String> map = new EnumMap<>(Day.class);
map.put(Day.MONDAY, "Study");
map.put(Day.TUESDAY, "Gym");
map.put(Day.WEDNESDAY, "Work");
```

Ordinal values for `Day`:

| Constant   | Ordinal |
|------------|---------|
| MONDAY     | 0       |
| TUESDAY    | 1       |
| WEDNESDAY  | 2       |

---

## 2. Why We Need EnumMap — Use Cases

### Why EnumMap is needed

- When keys are known to be from a **fixed, finite enum type**, using a general-purpose map (like `HashMap`) is inefficient — it does extra work (hashing, collision handling, node creation) that isn't necessary.
- `EnumMap` takes advantage of the fact that enum constants have a **known, fixed ordinal position**, so it can use **direct array indexing** instead of hashing.

### Use Cases

- Mapping **days of the week** to tasks/schedules (as shown above).
- Mapping **traffic signal states** to durations (`RED`, `YELLOW`, `GREEN` → seconds).
- Mapping **HTTP status categories** to handlers.
- Mapping **application states** (e.g., `STARTED`, `RUNNING`, `STOPPED`) to configuration or behavior.
- Any scenario where you need a **lookup table keyed by a fixed set of constants** — configuration maps, state machines, permission levels, order statuses, etc.

---

## 3. Have HashMap — Why Do Developers Need EnumMap?

Developers already have `HashMap`, so why introduce `EnumMap`? Because `EnumMap` offers **specific advantages when the keys are enums**:

| Feature                  | HashMap                                  | EnumMap                                      |
|---------------------------|-------------------------------------------|-----------------------------------------------|
| Key type                  | Any object                                | Only enum constants of a single enum type     |
| Internal structure         | Hash table (array of linked nodes/trees) | Simple array indexed by ordinal               |
| Hashing required           | Yes                                       | No (direct ordinal-based indexing)            |
| Memory overhead            | Higher (stores key, value, hash, next ref per node) | Lower (array slot holds just the value)   |
| Iteration order             | Unordered (unpredictable)                | **Natural order of enum constants** (declaration order) |
| Performance                | O(1) average, but with hashing overhead   | Faster — pure array access, no hashing/collision handling |
| Null keys                  | One null key allowed                      | **Null keys not allowed** (throws `NullPointerException`) |

### Key reasons developers prefer EnumMap over HashMap for enum keys:

1. **Performance** — No hashing, no collision resolution; just array indexing using `ordinal()`.
2. **Memory efficiency** — No need to store the key or a hash code with every entry; only compact array slots.
3. **Predictable iteration order** — Entries are iterated in the **natural order of the enum constants** (their declared order), not an arbitrary hash order.
4. **Type safety** — Only accepts keys of the specified enum type, preventing accidental use of unrelated keys.
5. **Compact and fast for a known-size domain** — Since the enum type defines a fixed number of constants, the underlying array size is fixed and small.

---

## 4. Internal Working of EnumMap

### Core idea

```
enum key → ordinal() → array index → value
```

`EnumMap` avoids creating a `Node` object for every entry (as `HashMap` does). Instead, it uses:
- The enum class (`Day.class`) to know **all possible keys** in advance.
- Each constant's `ordinal()` value as a **direct index** into an internal `Object[]` array.

### Comparison of internal structures

**HashMap** — each entry is a `Node`:

```
Node
┌─────────────────┐
│ hash             │
│ key              │ → MONDAY
│ value            │ → "Study"
│ next             │
└─────────────────┘
```

**EnumMap** — no per-entry node; just a value array aligned with ordinals:

```
EnumMap
Key information:
Day.class
   +
MONDAY.ordinal()    = 0
TUESDAY.ordinal()   = 1
WEDNESDAY.ordinal() = 2

Value array (vals):
┌─────────┬───────┬────────┐
│ "Study" │ "Gym" │ "Work" │
└─────────┴───────┴────────┘
    0         1        2
```

### Visual: overall structure

```
             EnumMap
                │
                ▼
          Object[] vals
                │
        ┌───────┼────────┐
        ▼       ▼        ▼
      [0]      [1]      [2]
       │        │        │
    "Study"   "Gym"    "Work"
       ▲        ▲        ▲
    MONDAY   TUESDAY  WEDNESDAY
```

### How `get()` works internally

```java
map.get(Day.TUESDAY);
```

Conceptually:

```
TUESDAY
   │
   ▼
ordinal = 1
   │
   ▼
vals[1]
   │
   ▼
"Gym"
```

### Why does the array NOT need to store the key?

- Since `EnumMap` knows the enum class up front, it also knows **all possible keys and their order**.
- The array index **itself represents the key** (via ordinal position) — so there's no need to store the enum constant alongside the value like `HashMap` does with its `Node`.
- This is the **key optimization**: keys are implicit (positional), only values are explicitly stored.

### Summary of internal mechanics

- Backed by `Object[] vals`, sized to the number of constants in the enum (`values().length`).
- A separate boolean/tracking mechanism (or `null` checks) determines whether a slot is "present" or "absent" (since a slot can be `null`/empty if no mapping was put for that key).
- No hashing, no collision handling, no rehashing/resizing needed — array size is fixed once the enum type is known.

---

## 5. Methods of EnumMap

`EnumMap` implements all standard `Map` methods, plus behaves consistently with enum-based ordering. Commonly used methods:

| Method                                   | Description                                                                 |
|--------------------------------------------|-------------------------------------------------------------------------------|
| `put(K key, V value)`                     | Associates the specified value with the specified enum key.                  |
| `get(Object key)`                         | Returns the value mapped to the given key, or `null` if none.                |
| `remove(Object key)`                      | Removes the mapping for the specified key.                                   |
| `containsKey(Object key)`                 | Returns `true` if the map contains a mapping for the key.                    |
| `containsValue(Object value)`             | Returns `true` if the map contains one or more keys mapped to the value.     |
| `size()`                                   | Returns the number of key-value mappings.                                    |
| `isEmpty()`                                | Returns `true` if the map contains no mappings.                              |
| `clear()`                                  | Removes all mappings from the map.                                           |
| `keySet()`                                 | Returns a `Set` view of the keys, in **natural enum order**.                 |
| `values()`                                 | Returns a `Collection` view of the values, ordered by key's natural order.   |
| `entrySet()`                               | Returns a `Set` view of the mappings, ordered by key's natural order.        |
| `putAll(Map<? extends K, ? extends V> m)`  | Copies all mappings from the specified map into this map.                    |
| `putIfAbsent(K key, V value)`              | Adds mapping only if key is not already present.                             |
| `getOrDefault(Object key, V default)`      | Returns value for key, or a default value if key not found.                  |
| `replace(K key, V value)`                  | Replaces the value for a key only if it is already mapped.                   |
| `computeIfAbsent(K key, Function f)`       | Computes and inserts a value if the key is absent.                           |
| `computeIfPresent(K key, BiFunction f)`    | Updates the value if the key is present.                                     |
| `merge(K key, V value, BiFunction f)`      | Merges a value into the map using a remapping function.                      |
| `clone()`                                  | Returns a shallow copy of the `EnumMap`.                                     |
| `equals(Object o)`                         | Compares this map with another map for equality.                             |
| `forEach(BiConsumer action)`               | Performs the given action for each entry.                                    |

### Example usage of a few methods

```java
EnumMap<Day, String> map = new EnumMap<>(Day.class);
map.put(Day.MONDAY, "Study");
map.put(Day.TUESDAY, "Gym");
map.put(Day.WEDNESDAY, "Work");

System.out.println(map.get(Day.TUESDAY));        // Gym
System.out.println(map.containsKey(Day.MONDAY));  // true
System.out.println(map.size());                   // 3

for (Map.Entry<Day, String> entry : map.entrySet()) {
    System.out.println(entry.getKey() + " -> " + entry.getValue());
}
// Output is always in enum declaration order:
// MONDAY -> Study
// TUESDAY -> Gym
// WEDNESDAY -> Work
```

---

## 6. Quick Summary

- **EnumMap** = a `Map` optimized for enum keys, backed internally by an array indexed by `ordinal()`.
- **No hashing** → faster than `HashMap` for enum keys.
- **No null keys allowed**.
- **Iteration order** = natural order of enum constants (declaration order), not insertion order.
- Ideal for **state machines, configuration maps, fixed-category lookups** (days, signals, statuses, etc.).
- Saves memory by **not storing the key in every entry** — the key is implicit via array position.
