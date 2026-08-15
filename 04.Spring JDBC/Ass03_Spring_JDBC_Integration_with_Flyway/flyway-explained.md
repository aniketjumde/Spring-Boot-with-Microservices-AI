# Flyway: Database Migration Tool

## What is Flyway?

Flyway is an open-source **database migration tool** that helps teams version, track, and apply changes to a database schema in a controlled, repeatable, and automated way — similar to how Git version-controls source code.

It answers a common problem: as an application evolves, its database schema needs to change too (new tables, columns, indexes, etc.). Without a system, these changes are applied manually and inconsistently across environments (dev, staging, production), leading to drift and bugs. Flyway solves this by treating schema changes as ordered, versioned scripts that are applied automatically and tracked in a history table.

## Core Concepts

### 1. Migrations
A migration is a single unit of database change, usually a SQL script (or a Java class for more complex logic). Each migration has:
- A **version number** (e.g., `V1`, `V2`, `V1.1`)
- A **description**
- The actual change (SQL statements)

Example filename convention:
```
V1__Create_users_table.sql
V2__Add_email_column.sql
V3__Create_orders_table.sql
```

### 2. Types of Migrations
| Type | Prefix | Purpose |
|------|--------|---------|
| Versioned | `V` | Applied once, in order, and tracked (e.g., `V1__init.sql`) |
| Undo | `U` | Reverts a versioned migration (Flyway Teams/Pro feature) |
| Repeatable | `R` | Re-applied every time their checksum changes (e.g., for views, stored procedures) |

### 3. Schema History Table
Flyway creates a table (default name: `flyway_schema_history`) in the target database. This table records:
- Which migrations have been applied
- Their checksums (to detect accidental edits)
- Execution time and success/failure status

This is how Flyway knows which migrations are new and need to be run.

### 4. Checksum Validation
Flyway calculates a checksum for each migration script. If an already-applied script is modified afterward, Flyway detects the mismatch and throws a validation error — preventing silent, untracked changes to history.

## How Flyway Works (Typical Flow)

1. You write a new SQL migration script and place it in the configured migrations folder.
2. You run `flyway migrate`.
3. Flyway checks the schema history table to see which migrations have already run.
4. It applies any new migrations, in version order, inside a transaction (where supported).
5. It records the result in the schema history table.

## Key Commands

| Command | Description |
|---------|-------------|
| `flyway migrate` | Applies all pending migrations |
| `flyway info` | Shows the status of all migrations (applied, pending, etc.) |
| `flyway validate` | Verifies applied migrations match their scripts (checksum check) |
| `flyway clean` | Drops all objects in the configured schemas (dangerous — dev use only) |
| `flyway baseline` | Marks an existing database as a starting point at a given version |
| `flyway repair` | Fixes the schema history table after failed/edited migrations |
| `flyway undo` | Reverts the most recent migration (Teams/Pro edition) |

## Where Flyway Fits

- **CLI**: Standalone command-line tool
- **Build tool plugins**: Maven and Gradle plugins to run migrations as part of a build
- **Java API**: Embed Flyway directly in application startup code
- **Framework integration**: Native support in Spring Boot — migrations run automatically on application startup
- **Docker**: Official Flyway Docker image for CI/CD pipelines

## Supported Databases

Flyway supports a wide range of relational databases, including:
PostgreSQL, MySQL, MariaDB, Oracle, SQL Server, SQLite, DB2, CockroachDB, Snowflake, Redshift, and more (some require the paid Teams/Enterprise edition).

## Flyway vs. Alternatives

| Tool | Approach |
|------|----------|
| **Flyway** | Plain SQL scripts, version-based, simple and explicit |
| **Liquibase** | XML/YAML/JSON/SQL changelogs, more abstract, supports rollback natively in Community edition |
| **Alembic** (Python/SQLAlchemy) | Python-based migration scripting, common in Python ecosystems |
| **Django Migrations** | Built into Django ORM, auto-generates migrations from model changes |

Flyway's philosophy is deliberately simple: **plain SQL, applied in order, tracked in a table.** This makes it easy to reason about, debug, and adopt without learning a new abstraction layer.

## Example: Spring Boot + Flyway

```yaml
# application.yml
spring:
  flyway:
    enabled: true
    locations: classpath:db/migration
  datasource:
    url: jdbc:postgresql://localhost:5432/mydb
    username: postgres
    password: postgres
```

Place migration scripts in `src/main/resources/db/migration/`:
```
V1__Create_users_table.sql
V2__Add_index_to_users_email.sql
```

On application startup, Spring Boot automatically triggers Flyway to apply any pending migrations before the app is ready to serve traffic.

## Editions

- **Community** (free, open-source): Core migration features (migrate, info, validate, baseline, repair, clean)
- **Teams / Enterprise** (paid): Undo migrations, dry runs, migration callbacks for more databases, Oracle/SQL Server advanced support, and enterprise support

## Best Practices

- Never edit a migration script after it has been applied to any shared environment — create a new migration instead.
- Use descriptive filenames so the migration history is self-documenting.
- Keep migrations small and focused on one logical change.
- Run `flyway info` before deploying to confirm what will be applied.
- Avoid using `flyway clean` in production (it can drop all schema objects).
