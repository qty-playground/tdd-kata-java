# Java SE TDD Labs ☕

A comprehensive collection of **Java SE Test-Driven Development** prompts and practice exercises. This project provides structured guidance for learning and applying TDD principles in Java projects.

## Prerequisites

- Java 8+ (Java 11+ recommended)
- Maven 3.6+ or Gradle 6.0+
- Your favorite Java IDE (IntelliJ IDEA, Eclipse, or VS Code)

## Quick Start

### 1. Create a Java Project

Choose one of the following methods to create your Java project:

#### Option A: Maven Project
```bash
mvn archetype:generate -DgroupId=com.example \
  -DartifactId=tdd-practice \
  -DarchetypeArtifactId=maven-archetype-quickstart \
  -DinteractiveMode=false

cd tdd-practice
```

#### Option B: Gradle Project
```bash
mkdir tdd-practice && cd tdd-practice
gradle init --type java-application
```

### 2. Add JUnit 5 Dependency

#### For Maven (add to `pom.xml`):
```xml
<dependencies>
    <dependency>
        <groupId>org.junit.jupiter</groupId>
        <artifactId>junit-jupiter</artifactId>
        <version>5.9.2</version>
        <scope>test</scope>
    </dependency>
</dependencies>
```

#### For Gradle (add to `build.gradle`):
```gradle
dependencies {
    testImplementation 'org.junit.jupiter:junit-jupiter:5.9.2'
}

test {
    useJUnitPlatform()
}
```

### 3. Verify Setup

#### Maven:
```bash
./mvnw test        # If wrapper exists
# or
mvn test           # Fallback
```

#### Gradle:
```bash
./gradlew test     # If wrapper exists  
# or
gradle test        # Fallback
```

## How to Use This Repository

### 📋 TDD Development Prompts

This repository contains specialized prompts to guide your Java TDD development:

#### Core TDD Flow
- **`@prompts/tdd/tdd-session.prompt`** - Main TDD session controller
- **`@prompts/tdd/red-phase.prompt`** - Write failing JUnit tests
- **`@prompts/tdd/green-phase.prompt`** - Minimal Java implementation
- **`@prompts/tdd/refactor-phase.prompt`** - Code quality improvements

#### Supporting Guides
- **`@prompts/coding-style.prompt`** - Java SE coding standards
- **`@prompts/overview.prompt`** - Complete workflow guide

### 🎯 Practice Exercises

- **`@labs/foobarbar-tdd.prompt`** - Classic TDD kata with Java focus

### Recommended Workflow

1. **Start a TDD session**: Use `@prompts/tdd/tdd-session.prompt`
2. **Follow the Red-Green-Refactor cycle**:
   - 🔴 **Red**: Use `@prompts/tdd/red-phase.prompt` 
   - 🟢 **Green**: Use `@prompts/tdd/green-phase.prompt`
   - 🔧 **Refactor**: Use `@prompts/tdd/refactor-phase.prompt`
3. **Maintain code quality**: Reference `@prompts/coding-style.prompt`

## Key Features

✅ **Java SE Focused**: All examples and guidance are Java-specific  
✅ **JUnit 5 Integration**: Modern testing framework support  
✅ **Maven & Gradle Support**: Works with both build systems  
✅ **IDE Friendly**: Compatible with IntelliJ IDEA, Eclipse, VS Code  
✅ **Structured Learning**: Progressive TDD skill development  
✅ **Real-world Practices**: Professional Java development patterns  

## Common Commands

### Maven
```bash
./mvnw test                                    # Run all tests
./mvnw test -Dtest=ClassNameTest              # Run specific test class
./mvnw test -Dtest=ClassNameTest#methodName   # Run specific test method
./mvnw clean compile                          # Clean and compile
```

### Gradle  
```bash
./gradlew test                                # Run all tests
./gradlew test --tests ClassNameTest         # Run specific test class  
./gradlew test --tests ClassNameTest.methodName # Run specific test method
./gradlew clean build                        # Clean and build
```

## Getting Help

- Read `@prompts/overview.prompt` for detailed workflow guidance
- Each phase prompt contains specific rules and examples
- Practice with `@labs/foobarbar-tdd.prompt` to build muscle memory

## License

MIT License