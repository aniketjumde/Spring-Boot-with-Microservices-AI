# Spring MVC Interview Notes: Validation, BindingResult & Data Binding

## Table of Contents

1. [How does validation work in Spring MVC?](#1-how-does-validation-work-in-spring-mvc)
2. [What is the purpose of `@Valid`?](#2-what-is-the-purpose-of-valid)
3. [What is the difference between `@Valid` and `@Validated`?](#3-what-is-the-difference-between-valid-and-validated)
4. [What is `BindingResult`?](#4-what-is-bindingresult)
5. [Why must `BindingResult` be placed immediately after the validated parameter?](#5-why-must-bindingresult-be-placed-immediately-after-the-validated-parameter)
6. [What is the difference between Data Binding and Type Conversion?](#6-what-is-the-difference-between-data-binding-and-type-conversion)

---

## 1. How does validation work in Spring MVC?

### 1.1 Definition

**Validation** in Spring MVC is the process of checking whether incoming user data satisfies predefined rules **before** the application processes or saves it.

For example, in a student registration form, you may want to ensure that:

- The student's name is not empty.
- The email address has a valid format.
- The age is within an acceptable range.
- The password satisfies your application's security requirements.

Spring MVC integrates with **Jakarta Bean Validation** (or the older **Javax Validation** API in older applications) to validate Java objects using annotations such as `@NotBlank`, `@Email`, `@Size`, and `@Min`.

### 1.2 How validation works

```
Client submits form (name, email, age)
        │
        ▼
Spring MVC data binding
(request values populate a Java object)
        │
        ▼
Validation with @Valid
(Bean Validation checks the constraints)
        │
        ├── Valid   ──► Continue processing
        │
        └── Invalid ──► Return errors or an appropriate response
```

**Steps:**

1. The client submits data.
2. Spring binds the incoming values to a Java object.
3. `@Valid` triggers validation of the object's declared constraints.
4. Spring records any constraint violations in a `BindingResult` or `Errors` object.
5. The controller checks the errors and either continues processing or returns an appropriate error response.

> **Note:** Validation does not automatically save or reject every request by itself. Your controller or exception-handling configuration determines what happens when errors are found.

### 1.3 Practical example: Student registration form

Let's implement validation using Spring Boot, Spring MVC, and Bean Validation.

#### Step 1: Add the validation dependency

For Spring Boot 3.x, add this to `pom.xml`:

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

> Spring Boot 3 uses `jakarta.validation` imports. Older Spring Boot 2 applications generally use `javax.validation`.

#### Step 2: Create a `Student` class with validation rules

```java
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class Student {

    @NotBlank(message = "Name is required")
    @Size(min = 3, max = 50,
          message = "Name must contain 3 to 50 characters")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email address")
    private String email;

    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    // Getters and setters
}
```

**What do these annotations mean?**

| Annotation   | Purpose                                                                  |
|--------------|--------------------------------------------------------------------------|
| `@NotBlank`  | Rejects `null`, empty, or whitespace-only strings                        |
| `@Size`      | Checks the size of a string, collection, or supported value              |
| `@Email`     | Checks whether a string conforms to the validator's email-format rules   |
| `@Min(18)`   | Requires the numeric value to be at least 18                             |

> **Note:** `@Min` alone does **not** reject `null` for a reference-type number. Use `@NotNull` as well when a value is required. Here, `age` is a primitive `int`, so it cannot be `null`.

#### Step 3: Use `@Valid` in the controller

```java
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class StudentController {

    @PostMapping("/register")
    public String registerStudent(
            @Valid @ModelAttribute("student") Student student,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "register";
        }

        // Call service to process valid data
        model.addAttribute("message", "Registration successful");

        return "success";
    }
}
```

> **Important interview point:** When using `BindingResult` to handle validation errors in the same controller method, place it **immediately after** the corresponding validated parameter.

#### Step 4: Display validation errors in Thymeleaf

Inside `register.html`:

```html
<form th:action="@{/register}"
      th:object="${student}"
      method="post">

    <input type="text" th:field="*{name}">
    <span th:errors="*{name}"></span>

    <input type="email" th:field="*{email}">
    <span th:errors="*{email}"></span>

    <input type="number" th:field="*{age}">
    <span th:errors="*{age}"></span>

    <button type="submit">Register</button>
</form>
```

If the user submits an invalid email or a name that is too short, Spring MVC makes the validation errors available to the view, and Thymeleaf displays the corresponding messages.

### 1.4 Interview-ready answer

> Spring MVC supports Bean Validation to verify incoming data against constraints defined on Java objects. When a request object is annotated with `@Valid`, Spring triggers validation after data binding. Errors can be inspected through `BindingResult` or handled through exception-handling mechanisms. Valid data can then proceed to the service layer, while invalid data can be returned with appropriate error messages.

**Remember this sequence:**

```
Request → Data Binding → @Valid → Constraint Checking → Handle Errors or Continue
```

---

## 2. What is the purpose of `@Valid`?

### 2.1 Definition

`@Valid` is an annotation that tells Spring MVC and the Bean Validation integration to **validate an object against its declared validation constraints**.

It does **not** define the validation rules itself. The rules are usually defined using annotations such as `@NotBlank`, `@Email`, and `@Min`.

### 2.2 Example

```java
@PostMapping("/register")
public String register(
        @Valid @ModelAttribute Student student,
        BindingResult result) {

    if (result.hasErrors()) {
        return "register";
    }

    return "success";
}
```

Here:

- `@ModelAttribute` binds request parameters to the `Student` object.
- `@Valid` triggers validation of the object's constraints.
- `BindingResult` holds binding and validation errors.
- `result.hasErrors()` checks whether any errors occurred.

> Without `@Valid` or another validation trigger, merely declaring constraint annotations on the Java class does **not** guarantee that Spring MVC will validate the object during request handling.

### 2.3 How is `@Valid` used in REST APIs?

For a REST API, `@Valid` is often combined with `@RequestBody`.

```java
@RestController
@RequestMapping("/api/students")
public class StudentApiController {

    @PostMapping
    public String createStudent(
            @Valid @RequestBody Student student) {

        return "Student data is valid";
    }
}
```

When the request body is converted into a `Student` object, Spring MVC validates it. If a constraint fails and no local `BindingResult` handles the errors, Spring MVC normally raises a validation exception that can be translated into an **HTTP 400 Bad Request** response.

In production APIs, you can use `@RestControllerAdvice` to return a consistent JSON error structure.

### 2.4 Interview-ready answer

> `@Valid` triggers validation of an object using its declared Bean Validation constraints. It is commonly used with `@ModelAttribute` for HTML forms and `@RequestBody` for REST API requests. Validation results can be handled using `BindingResult` or an exception handler.

---

## 3. What is the difference between `@Valid` and `@Validated`?

Both `@Valid` and `@Validated` are used to trigger validation of Java objects in Spring applications. The main difference:

- `@Valid` is a **standard Jakarta Bean Validation** annotation.
- `@Validated` is a **Spring-specific** annotation that additionally supports **validation groups**.

### 3.1 What is `@Valid`?

`@Valid` comes from the Jakarta Bean Validation API.

```java
import jakarta.validation.Valid;
```

It tells the validation provider to validate an object against the constraints defined on its fields.

```java
public class Student {

    @NotBlank(message = "Name cannot be empty")
    private String name;

    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    // Getters and setters
}
```

```java
@PostMapping("/register")
public String register(
        @Valid @ModelAttribute("student") Student student,
        BindingResult result) {

    if (result.hasErrors()) {
        return "register";
    }

    return "success";
}
```

**How it works:**

1. Spring binds incoming form data to the `Student` object.
2. `@Valid` triggers validation.
3. The validation provider checks `name` and `age`.
4. Validation errors are recorded in `BindingResult`.
5. The controller returns the form again if errors exist; otherwise, it proceeds.

### 3.2 What is `@Validated`?

`@Validated` is provided by Spring.

```java
import org.springframework.validation.annotation.Validated;
```

It supports ordinary validation and also lets you specify **validation groups**. Groups allow different validation rules to apply in different situations, such as registration versus updating a student.

#### Example: Validation groups

**Define two marker interfaces:**

```java
public interface CreateGroup {}
public interface UpdateGroup {}
```

**Define the validation rules:**

```java
public class Student {

    @NotBlank(groups = CreateGroup.class)
    private String name;

    @NotNull(groups = UpdateGroup.class)
    private Long id;

    // Getters and setters
}
```

**Select the group to validate:**

```java
@PostMapping("/students")
public String createStudent(
        @Validated(CreateGroup.class)
        @ModelAttribute Student student,
        BindingResult result) {

    if (result.hasErrors()) {
        return "register";
    }

    return "success";
}
```

Here, Spring validates only the constraints assigned to `CreateGroup` (along with any applicable default-group constraints). Use `UpdateGroup.class` for a different operation.

### 3.3 Key differences

| Feature                              | `@Valid`                                                   | `@Validated`                                                  |
|--------------------------------------|------------------------------------------------------------|---------------------------------------------------------------|
| **Package**                          | `jakarta.validation.Valid`                                 | `org.springframework.validation.annotation.Validated`         |
| **Standard**                         | Jakarta Bean Validation                                    | Spring Framework                                              |
| **Basic validation**                 | Yes                                                        | Yes                                                           |
| **Validation groups**                | Does not specify groups itself                             | Yes, supports group selection                                 |
| **Typical use**                      | Validating request objects and nested objects              | Group-based validation and Spring method validation           |
| **Nested object validation**         | Yes, when placed on the nested field or property           | Yes, when used appropriately with constraints                 |
| **Usable on controller parameters**  | Yes                                                        | Yes                                                           |
| **Spring-specific**                  | No                                                         | Yes                                                           |

> **Important:** `@Valid` can participate in validation groups when group selection is configured elsewhere, but it does **not** have a `groups` attribute of its own. `@Validated` can explicitly select groups.

### 3.4 Can `@Validated` replace `@Valid`?

For ordinary validation, yes.

```java
@PostMapping("/register")
public String register(
        @Validated @ModelAttribute Student student,
        BindingResult result) {

    if (result.hasErrors()) {
        return "register";
    }

    return "success";
}
```

This triggers the same default-group validation as `@Valid`. However, if you need to select a group, use:

```java
@Validated(CreateGroup.class)
```

### 3.5 What about Spring Boot REST APIs?

Both can be used to validate request bodies:

```java
@PostMapping("/api/students")
public ResponseEntity<String> create(
        @Valid @RequestBody Student student) {

    return ResponseEntity.ok("Student created");
}
```

When validation fails and the errors are not handled locally, Spring MVC normally responds with **HTTP 400 Bad Request**.

For **nested objects**, use `@Valid` on the nested field too:

```java
public class Student {

    @Valid
    private Address address;
}
```

`@Validated` is also relevant for **Spring method validation** (validating method parameters and return values). The exact behavior depends on the Spring version and how method validation is configured.

```java
@Validated
@RestController
public class StudentApiController {
    // Handler methods
}
```

### 3.6 Request flow

```
Incoming request (form data or JSON)
        │
        ▼
Java object created (data binding)
        │
        ├── @Valid      → standard validation
        └── @Validated  → validation and group selection
        │
        ▼
Validation result → handle errors or continue processing
```

### 3.7 Common interview questions

**Q1. Which one should you use in a typical Spring Boot controller?**
Use `@Valid` for straightforward request validation. Use `@Validated` when you need to select validation groups or use Spring's method-validation capabilities.

**Q2. Is `@Validated` a replacement for `@Valid`?**
It can perform ordinary validation, but the two annotations are not identical because `@Validated` supports explicit validation-group selection.

**Q3. Do either of these annotations define the validation rules?**
No. Constraints such as `@NotBlank`, `@Email`, and `@Min` define the rules. `@Valid` and `@Validated` only *trigger* validation in the relevant context.

**Q4. What dependency is required in Spring Boot 3?**

```xml
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-starter-validation</artifactId>
</dependency>
```

Spring Boot 3 uses `jakarta.validation.*`; older Spring Boot 2 applications generally use `javax.validation.*`.

### 3.8 Interview-ready answer

> `@Valid` is a standard Jakarta Bean Validation annotation used to trigger validation of an object based on its constraint annotations. `@Validated` is Spring's equivalent that also supports validation groups and is useful for Spring method validation. I use `@Valid` for normal DTO validation and `@Validated` when different operations, such as create and update, require different validation rules.

**Remember:** `@Valid` = standard validation; `@Validated` = Spring validation with group support.

---

## 4. What is `BindingResult`?

`BindingResult` is an interface in Spring MVC that **stores the results of data binding and validation**, including errors that occur when request data is converted into Java object properties or when validation constraints fail.

It allows us to check errors and handle them instead of proceeding with invalid data.

**Package:**

```java
import org.springframework.validation.BindingResult;
```

### 4.1 Why do we need `BindingResult`?

Suppose you are building a student registration application with these requirements:

- Student name must not be empty.
- Email must be valid.
- Age must be at least 18.

If a user submits an empty name, an invalid email, or an age of 15, Spring can record the validation errors in `BindingResult`. Your controller can then return the registration page with the errors instead of processing invalid data.

### 4.2 Example from basic to practical

#### Step 1: Create the `Student` class

```java
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Student {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter a valid email")
    private String email;

    @Min(value = 18, message = "Age must be at least 18")
    private int age;

    // Getters and setters
}
```

#### Step 2: Use `BindingResult` in the controller

```java
@Controller
public class StudentController {

    @PostMapping("/register")
    public String registerStudent(
            @Valid @ModelAttribute("student") Student student,
            BindingResult result,
            Model model) {

        if (result.hasErrors()) {
            return "register";
        }

        model.addAttribute("message", "Student registered successfully");

        return "success";
    }
}
```

#### Step 3: Understand the execution

```
1. User submits the form (name, email, age)
        │
        ▼
2. Spring binds request data (creates and populates Student)
        │
        ▼
3. @Valid triggers validation (checks constraints on Student)
        │
        ├── Errors found → result.hasErrors() is true → return the form
        │
        └── No errors    → continue registration → return success
```

### 4.3 Important methods of `BindingResult`

| Method                  | Purpose                                         |
|-------------------------|-------------------------------------------------|
| `hasErrors()`           | Checks whether any errors exist                 |
| `getErrorCount()`       | Returns the total number of errors              |
| `getAllErrors()`        | Returns all errors                              |
| `getFieldErrors()`      | Returns errors associated with fields           |
| `getFieldError("name")` | Returns the first error for a specific field    |
| `getFieldValue("name")` | Retrieves the value associated with a field     |
| `rejectValue()`         | Adds an error for a particular field            |
| `reject()`              | Adds a general object-level error               |

```java
if (result.hasErrors()) {
    System.out.println(result.getErrorCount());

    result.getFieldErrors().forEach(error ->
        System.out.println(
            error.getField() + ": " + error.getDefaultMessage()
        )
    );
}
```

### 4.4 What happens if we do not use `BindingResult`?

For a typical Spring MVC form, if validation fails and there is no immediately associated `BindingResult` to handle the errors locally, Spring MVC can raise a validation exception rather than allowing the controller to inspect the errors.

For REST controllers using `@Valid @RequestBody`, an unhandled validation failure normally results in **HTTP 400 Bad Request**.

### 4.5 `BindingResult` vs. `Errors`

| `BindingResult`                                       | `Errors`                                                  |
|-------------------------------------------------------|-----------------------------------------------------------|
| Extends the `Errors` interface                        | Defines the basic interface for recording/accessing errors |
| Provides additional binding-related capabilities      | Focuses on error recording and retrieval                  |
| Commonly used in Spring MVC controllers               | Used more generally in Spring validation APIs             |

### 4.6 Interview-ready answer

> `BindingResult` is a Spring interface used to store data-binding and validation errors. It is commonly placed immediately after an `@Valid` or `@Validated` controller parameter. We use methods such as `hasErrors()` and `getFieldErrors()` to check and handle errors before processing the submitted data.

---

## 5. Why must `BindingResult` be placed immediately after the validated parameter?

In Spring MVC, `BindingResult` must be placed **immediately after** the corresponding `@Valid` or `@Validated` parameter so Spring can associate validation and data-binding errors with that specific parameter.

### 5.1 Correct example

```java
@PostMapping("/register")
public String registerStudent(
        @Valid @ModelAttribute("student") Student student,
        BindingResult result,
        Model model) {

    if (result.hasErrors()) {
        return "register";
    }

    return "success";
}
```

Here, `BindingResult` immediately follows `student`, so Spring MVC can make the validation errors available to the controller.

### 5.2 Incorrect example

```java
@PostMapping("/register")
public String registerStudent(
        @Valid @ModelAttribute("student") Student student,
        Model model,
        BindingResult result) {   // ❌ Model sits between them

    if (result.hasErrors()) {
        return "register";
    }

    return "success";
}
```

In this example, `Model` comes between the validated parameter and `BindingResult`. Spring MVC cannot associate the `BindingResult` with the validated parameter in the required way. A validation failure may therefore result in an **exception** instead of being handled through `result.hasErrors()`.

### 5.3 How does it work internally?

```
Request received
   │
   ▼
Spring binds request data to Student
   │
   ▼
@Valid triggers validation (constraint violations detected)
   │
   ▼
BindingResult immediately follows → Spring exposes the errors to the controller
   │
   ▼
Controller handles the result
(return the form if errors exist; otherwise continue)
```

### 5.4 Interview-ready answer

> `BindingResult` must immediately follow the validated parameter because Spring MVC uses this parameter arrangement to associate validation and binding errors with the corresponding model attribute. If it is placed elsewhere, Spring may throw an exception instead of allowing the controller to handle those errors locally.

---

## 6. What is the difference between Data Binding and Type Conversion?

In Spring MVC:

- **Data binding** means mapping incoming request data to the properties of a Java object.
- **Type conversion** means converting a value from one data type to another.

They work together when Spring processes form submissions, query parameters, and path variables.

### 6.1 What is Data Binding?

Data binding is the process of taking data from an HTTP request and assigning it to the corresponding properties of a Java object.

#### Example

A user submits this registration form:

```html
<form action="/register" method="post">
    <input name="name" value="Aniket">
    <input name="age" value="22">
    <button type="submit">Register</button>
</form>
```

Java class:

```java
public class Student {

    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Getters
}
```

Controller:

```java
@PostMapping("/register")
public String register(
        @ModelAttribute("student") Student student) {

    System.out.println(student.getName());
    System.out.println(student.getAge());

    return "success";
}
```

Spring creates and populates the `Student` object using the incoming request values.

```
HTTP Request:   name=Aniket, age=22
      │
      ▼
Data Binding:   matches request fields to Java properties
      │
      ▼
Student Object: name = "Aniket", age = 22
```

Data binding can involve property matching, type conversion, and error handling.

### 6.2 What is Type Conversion?

Type conversion is the process of converting a value from one data type to another.

HTTP request parameters generally arrive as **text**. However, your Java application may need an `int`, `long`, `double`, `LocalDate`, or another type.

#### Example

Incoming request:

```
age=22
```

The request value `"22"` is text, but the Java property is an `int`:

```java
private int age;
```

Spring converts the string `"22"` into the integer `22` so it can assign the value to the property.

| Incoming value | Target Java type | Converted value                              |
|----------------|------------------|----------------------------------------------|
| `"22"`         | `int`            | `22`                                         |
| `"99.5"`       | `double`         | `99.5`                                       |
| `"true"`       | `boolean`        | `true`                                       |
| `"2026-10-17"` | `LocalDate`      | A `LocalDate` representing October 17, 2026  |

> The last conversion requires a supported date format and converter or formatter configuration.

#### What happens if conversion fails?

Suppose the user submits:

```
age=abc
```

Spring cannot convert `"abc"` into an integer. It records a **binding/conversion error**, which you can inspect using `BindingResult` in a suitable controller method.

```java
@PostMapping("/register")
public String register(
        @Valid @ModelAttribute("student") Student student,
        BindingResult result) {

    if (result.hasErrors()) {
        return "register";
    }

    return "success";
}
```

Here, `BindingResult` can contain **both** type-conversion errors and validation errors.

### 6.3 Key differences

| Feature                 | Data Binding                                  | Type Conversion                                |
|-------------------------|-----------------------------------------------|------------------------------------------------|
| **Meaning**             | Maps request data to Java object properties   | Changes a value from one type to another       |
| **Main purpose**        | Populates an object                           | Produces a value of the required type          |
| **Scope**               | Broader process                               | One operation that can occur during binding    |
| **Example**             | Populating `Student` from form fields         | Converting `"22"` to `int`                     |
| **Spring MVC example**  | `@ModelAttribute`                             | `ConversionService`, converters, formatters    |
| **Error example**       | A property cannot be bound or populated       | `"abc"` cannot become an integer               |

### 6.4 How do they work together?

Consider this controller:

```java
@GetMapping("/students")
public String getStudents(
        @RequestParam int age,
        Model model) {

    model.addAttribute("age", age);
    return "students";
}
```

For the URL:

```
/students?age=22
```

Spring converts the request parameter `"22"` to an `int` and supplies it to the controller. Since the parameter is a scalar rather than a Java object, this is **parameter conversion**, not binding an entire object.

For a more complete object-binding example:

```java
@PostMapping("/students")
public String save(
        @ModelAttribute Student student) {
    return "success";
}
```

Spring maps the submitted fields to `Student` properties and converts individual values to their required types.

> Type conversion can occur independently, while object data binding often uses type conversion as one step.

### 6.5 Advanced interview point: Converter vs. Formatter

Spring provides two useful extension mechanisms:

- **`Converter<S, T>`**: Converts a source type to a target type, such as `String` to `Integer` or `String` to a custom `Department` object.
- **`Formatter<T>`**: Handles formatting and parsing, particularly for user-facing text such as dates and numbers, with support for locale-sensitive behavior.

For example, a custom converter could convert a department ID supplied as text into a `Department` object. A formatter could parse a date string according to a configured date pattern.

### 6.6 Interview-ready answer

> Data binding in Spring MVC maps incoming request data to Java object properties, while type conversion converts individual values between Java types. For example, when a registration form submits `name=Aniket` and `age=22`, Spring binds the fields to a `Student` object and converts the age value from a string to an integer. Type conversion is often one part of the broader data-binding process.

---

## Quick Revision Cheat Sheet

| Concept               | One-line summary                                                                  |
|-----------------------|-----------------------------------------------------------------------------------|
| **Validation**        | Checks incoming data against rules before processing                              |
| **Constraint annotations** | `@NotBlank`, `@Email`, `@Size`, `@Min` define the rules                      |
| **`@Valid`**          | Standard Jakarta annotation that triggers validation                              |
| **`@Validated`**      | Spring annotation; triggers validation and supports groups                        |
| **`BindingResult`**   | Holds binding and validation errors; must follow the validated parameter          |
| **Data binding**      | Maps request data to Java object properties                                       |
| **Type conversion**   | Converts a value from one type to another (e.g., `"22"` → `22`)                   |
| **REST validation**   | `@Valid @RequestBody` → unhandled failures normally return HTTP 400               |

**Flow to remember:**

```
Request → Data Binding (+ Type Conversion) → @Valid → Constraint Checking → Handle Errors or Continue
```
