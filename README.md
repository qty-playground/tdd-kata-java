# Java SE TDD Labs ☕

A comprehensive collection of **Java SE Test-Driven Development** prompts and practice exercises. This project provides structured guidance for learning and applying TDD principles in Java projects.

## Prerequisites

- Java 17+ (Java 21 LTS recommended)
- Maven 3.8+ or Gradle 8.0+
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

### 📋 Unified TDD System

This repository uses a unified state machine approach to guide your Java TDD development:

- **`@unified_tdd_system.md`** - Complete TDD workflow state machine that handles the entire Red-Green-Refactor cycle

### State Machine Workflow

The unified system operates as a state machine with the following flow:

1. **Start**: Type "go" to begin the TDD cycle
2. **Automated Flow**: The system automatically progresses through:
   - 📋 **Reading Plan**: Extracts next task from `plan.md`
   - 🔴 **Red Phase**: Creates failing test
   - 🟢 **Green Phase**: Implements minimal passing code
   - ✅ **Verification**: Runs full test suite
   - 🔧 **Structural Tidying**: Applies "Tidy First" refactoring
   - 🚀 **Behavioral Refactoring**: Improves code quality
   - 💾 **Committing**: Creates standardized commit message

### Getting Started

1. **Create a `plan.md` file** with your development tasks:
   ```markdown
   - [ ] Implement basic calculator addition
   - [ ] Add subtraction functionality
   - [ ] Handle edge cases for division by zero
   ```

2. **Use the unified system**: Reference `@unified_tdd_system.md` and type "go" to start each cycle

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

- Read `@unified_tdd_system.md` for complete TDD workflow guidance
- The state machine provides clear instructions for each development phase
- Follow Kent Beck's TDD principles and "Tidy First" refactoring approach

## License

MIT License