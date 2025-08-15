# Java SE TDD Labs ☕

Git-driven TDD workflow for Java projects.

## Usage

1. Describe requirements to AI
2. Use `@prompts/tdd/kent-beck-tdd.prompt`  
3. Say "go" - AI executes Red-Green cycles
4. Progress tracked in git commits

## Setup

Java 17+, Maven/Gradle, JUnit 5

```bash
./mvnw test     # Maven
./gradlew test  # Gradle
```

## Prompts

- `@prompts/tdd/kent-beck-tdd.prompt` - Kent Beck TDD methodology
- `@prompts/coding-style.prompt` - Java standards