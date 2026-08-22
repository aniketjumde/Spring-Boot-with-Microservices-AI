# Enum in Java — Complete Notes

---

## 1. What is Enum?

`enum` (short for **enumeration**) is a special **data type** in Java used to define a **fixed set of named constants**.

- Introduced in **Java 5**.
- Declared using the `enum` keyword.
- Internally, every enum in Java **implicitly extends** `java.lang.Enum` class.
- Each constant of an enum is actually a **public, static, final instance** of that enum type.

### Basic Example

```java
enum Signal {
    RED, YELLOW, GREEN
}
```

Here, `RED`, `YELLOW`, and `GREEN` are **fixed constants** — no other value is allowed for a `Signal` variable.

```java
Signal s = Signal.RED;   // valid
Signal s2 = Signal.BLUE; // compile-time error — BLUE doesn't exist
```

---

## 2. How Enums Are Stored (Internally)

When you write:

```java
enum Day {
    MONDAY, TUESDAY, WEDNESDAY
}
```

The Java compiler transforms this into something conceptually like:

```java
final class Day extends Enum<Day> {
    public static final Day MONDAY   = new Day("MONDAY", 0);
    public static final Day TUESDAY  = new Day("TUESDAY", 1);
    public static final Day WEDNESDAY = new Day("WEDNESDAY", 2);

    private static final Day[] VALUES = { MONDAY, TUESDAY, WEDNESDAY };

    private Day(String name, int ordinal) {
        super(name, ordinal);
    }
}
```

### Key storage facts

- Each constant is created **only once** (at class-loading time) → enums are essentially **Singletons per constant**.
- Every constant automatically gets:
  - a **name** (`String`, e.g., `"MONDAY"`) → accessible via `name()`
  - an **ordinal** (`int`, position starting from 0) → accessible via `ordinal()`
- All constants are stored internally in a **fixed-size array** (`values()` returns a copy of this array).

### Visual representation

```
enum Day
   │
   ▼
┌─────────────┬─────────────┬──────────────┐
│  MONDAY     │  TUESDAY    │  WEDNESDAY   │
│  ordinal=0  │  ordinal=1  │  ordinal=2   │
│  name="MONDAY" │ name="TUESDAY" │ name="WEDNESDAY" │
└─────────────┴─────────────┴──────────────┘
        (stored as static final singleton objects)
```

### Common inherited methods (from `java.lang.Enum`)

| Method            | Description                                          |
|--------------------|--------------------------------------------------------|
| `name()`           | Returns the exact constant name as declared.           |
| `ordinal()`        | Returns the position (0-based index) of the constant.  |
| `values()`         | Returns an array of all constants (static, compiler-generated). |
| `valueOf(String)`  | Returns the constant matching the given name (throws `IllegalArgumentException` if not found). |
| `compareTo(E o)`   | Compares based on ordinal value.                        |
| `toString()`       | Returns the constant's name (can be overridden).        |

---

## 3. Why Do We Need Enum (Constants)?

### Problem before enums (using `int` or `String` constants)

```java
public static final int RED = 0;
public static final int YELLOW = 1;
public static final int GREEN = 2;

void setSignal(int signal) {
    if (signal == RED) { ... }
}

setSignal(5);        // compiles fine — but 5 is invalid! No type safety.
setSignal(YELLOW);
setSignal(100);       // logically wrong, but compiler allows it
```

**Issues with plain `int`/`String` constants:**
- **No type safety** — any integer/string can be passed, even invalid ones.
- **No compile-time checking** — errors show up only at runtime (or not at all).
- Poor **readability** — `signal == 1` doesn't tell you what `1` means.
- Difficult to **group related behavior** with the constant.
- No built-in way to iterate over "all possible values."

### How Enum solves this

```java
enum Signal { RED, YELLOW, GREEN }

void setSignal(Signal signal) {
    if (signal == Signal.RED) { ... }
}

setSignal(Signal.RED);   // valid
setSignal(5);              // compile-time error — type mismatch!
```

### Benefits of using Enum

1. **Type safety** — only predefined constants of that type are allowed; invalid values are caught at compile time.
2. **Readability** — `Signal.RED` is far clearer than `0` or `"RED"`.
3. **Namespace control** — constants are scoped inside the enum type, avoiding naming collisions.
4. **Can hold data & behavior** — enums can have fields, constructors, and methods (unlike plain constants).
5. **Built-in utility methods** — `values()`, `valueOf()`, `ordinal()`, `name()`, works with `switch` statements.
6. **Safe iteration** — easily loop over all constants using `values()`.
7. **Can be used in `EnumSet` / `EnumMap`** for optimized, fixed-domain collections.
8. **Singleton behavior** — each constant is a single, shared instance — safe for comparison using `==`.

---

## 4. Custom Enum (Enum with Fields, Constructors, and Methods)

Enums in Java are not just plain constants — they can behave like **full-fledged classes**.

### Example: Enum with fields and constructor

```java
enum Planet {
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6);

    private final double mass;   // in kilograms
    private final double radius; // in meters

    // Enum constructor — always private (or package-private) implicitly
    Planet(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    double surfaceGravity() {
        final double G = 6.67300E-11;
        return G * mass / (radius * radius);
    }
}
```

```java
for (Planet p : Planet.values()) {
    System.out.println(p + " gravity = " + p.surfaceGravity());
}
```

### Example: Enum with abstract method (constant-specific behavior)

```java
enum Operation {
    ADD {
        public int apply(int a, int b) { return a + b; }
    },
    SUBTRACT {
        public int apply(int a, int b) { return a - b; }
    },
    MULTIPLY {
        public int apply(int a, int b) { return a * b; }
    };

    public abstract int apply(int a, int b);
}
```

```java
System.out.println(Operation.ADD.apply(5, 3));       // 8
System.out.println(Operation.MULTIPLY.apply(5, 3));  // 15
```

### Example: Enum implementing an interface

```java
interface Describable {
    String describe();
}

enum Level implements Describable {
    LOW, MEDIUM, HIGH;

    public String describe() {
        return "Level: " + name();
    }
}
```

### Rules for custom enums

- Enum constructors are **always implicitly `private`** (cannot be public/protected).
- Enum constants **must be declared first**, before any fields/methods.
- Enums **cannot extend another class** (they already extend `Enum`), but **can implement interfaces**.
- Enum **cannot be instantiated using `new`** from outside.
- Enums **can be declared inside a class** but not extended further (implicitly `final`).

---

## 5. Real Use Case: HTTP Status Codes (`HttpStatus` Enum)

A very common real-world example is representing **HTTP response status codes** using an enum — similar to how Spring Framework's `HttpStatus` enum works.

```java
enum HttpStatus {
    OK(200, "OK"),
    CREATED(201, "Created"),
    BAD_REQUEST(400, "Bad Request"),
    UNAUTHORIZED(401, "Unauthorized"),
    NOT_FOUND(404, "Not Found"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");

    private final int code;
    private final String message;

    HttpStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    // Custom lookup method: find enum constant by status code
    public static HttpStatus fromCode(int code) {
        for (HttpStatus status : values()) {
            if (status.code == code) {
                return status;
            }
        }
        throw new IllegalArgumentException("Unknown HTTP status code: " + code);
    }
}
```

### Usage

```java
HttpStatus status = HttpStatus.NOT_FOUND;
System.out.println(status.getCode());     // 404
System.out.println(status.getMessage());  // Not Found

HttpStatus fromApi = HttpStatus.fromCode(500);
System.out.println(fromApi);              // INTERNAL_SERVER_ERROR
```

### Why enum is ideal here

- HTTP status codes form a **fixed, well-known set** — a textbook case for enums.
- Prevents invalid/typo'd status codes (`"Succes"` instead of `"Success"`, or wrong numeric code) since only predefined constants are usable.
- Each constant can carry **its own data** (code + message) instead of needing separate lookup maps.
- Works cleanly with `switch` statements for handling responses:

```java
switch (status) {
    case OK -> System.out.println("Request succeeded");
    case NOT_FOUND -> System.out.println("Resource missing");
    case INTERNAL_SERVER_ERROR -> System.out.println("Server error");
    default -> System.out.println("Other status");
}
```

- Pairs naturally with `EnumMap`/`EnumSet` — e.g., mapping `HttpStatus` → handler logic, or grouping status codes into `EnumSet` categories (`2xx`, `4xx`, `5xx`).

*(Note: This is a simplified illustrative version. Spring Framework's actual `org.springframework.http.HttpStatus` enum works on this same principle, with many more constants and helper methods like `is2xxSuccessful()`, `is4xxClientError()`, etc.)*

---

## 6. Internal Working — "Enum is a Class"

The most important concept: **`enum` is just syntactic sugar for a class.**

### Every enum, under the hood:

```
enum Day { MONDAY, TUESDAY, WEDNESDAY }
```

compiles to (conceptually):

```java
public final class Day extends java.lang.Enum<Day> {
    public static final Day MONDAY;
    public static final Day TUESDAY;
    public static final Day WEDNESDAY;

    private static final Day[] $VALUES;

    static {
        MONDAY   = new Day("MONDAY", 0);
        TUESDAY  = new Day("TUESDAY", 1);
        WEDNESDAY = new Day("WEDNESDAY", 2);
        $VALUES = new Day[] { MONDAY, TUESDAY, WEDNESDAY };
    }

    private Day(String name, int ordinal) {
        super(name, ordinal);
    }

    public static Day[] values() {
        return $VALUES.clone();
    }

    public static Day valueOf(String name) {
        // looks up constant by name, throws IllegalArgumentException if not found
    }
}
```

### Key internal facts

| Concept                          | Explanation                                                                 |
|------------------------------------|---------------------------------------------------------------------------|
| Base class                         | Every enum implicitly `extends java.lang.Enum<E>`.                        |
| `final` by default                 | Enum classes are implicitly `final` — **cannot be subclassed** (except for constant-specific class bodies, which the compiler handles as anonymous subclasses). |
| Constants = static final fields    | Each constant (`MONDAY`, etc.) is a `public static final` instance created **once**, in a `static` initializer block. |
| Singleton nature                   | Since constants are created only once at class load time, `==` comparison works safely and reliably for enum constants. |
| Constructor visibility              | Enum constructors are implicitly `private` — you cannot call `new Day(...)` from outside. |
| `values()` and `valueOf()`         | Auto-generated **static** methods added by the compiler — not inherited from `Enum` class directly (they're specific to each enum type). |
| `ordinal()` and `name()`           | Inherited directly from `java.lang.Enum` — provide position and declared name. |
| Serialization                      | Enums have special serialization handling — only the `name()` is serialized, and `valueOf()` is used to restore the constant, ensuring singleton property is preserved even after deserialization. |
| Enum in `switch`                   | Uses `ordinal()` internally to build an efficient jump table.              |

### Visual Summary

```
        java.lang.Enum<E>          (abstract base class)
               ▲
               │ extends
               │
          enum Day                  (compiler-generated final class)
               │
   ┌───────────┼─────────────┐
   ▼           ▼              ▼
 MONDAY      TUESDAY       WEDNESDAY
(static final instances, created once in static block)
```

---

## 7. Quick Summary

- **Enum** = a special class type representing a **fixed set of constants**, each being a singleton instance.
- **Storage**: constants are `public static final` objects, created once in a compiler-generated `static` block, each carrying a `name` and `ordinal`.
- **Why needed**: solves problems of type-safety, readability, and invalid values that plain `int`/`String` constants suffer from.
- **Custom enums**: can have fields, constructors, methods, abstract methods (constant-specific bodies), and can implement interfaces.
- **Real use case**: `HttpStatus`-style enums model fixed domains like HTTP codes cleanly, safely, and efficiently.
- **Internally**: every `enum` is compiled into a `final class extending java.lang.Enum<E>`, with constants as static final singleton instances — this is why `EnumMap`/`EnumSet` can exploit `ordinal()` for fast, array-based storage.
