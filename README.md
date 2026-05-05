# Story to Code - API & SQL Generator with AI

> A Java 21 project demonstrating the use of AI agents to generate code (OpenAPI contracts + SQL scripts) from user stories.

## ✨ Features

- **AI Agents** (Sealed interfaces) for generating API + SQL
- **Java 21 Records** for immutability and type-safety
- **Pattern Matching** for response processing
- **Simple & Functional** (~650 lines, production-ready)

## 🏗️ Architecture

```
UserStory → CodeGenerator → [ApiDesignAgent, SqlGeneratorAgent] → GeneratedCode
                                                                    ├─ ApiContract
                                                                    └─ SqlScript
```

### Main Classes

**Domain Models** (Immutable Records):
- `UserStory` - Business requirement
- `ApiContract` - Generated OpenAPI contract
- `SqlScript` - Generated SQL script
- `GeneratedCode` - Complete result (API + SQL)
- `AgentResponse<T>` - Agent response (Result type)

**Agents** (Sealed interface):
- `Agent<T>` - Sealed interface (only ApiDesignAgent and SqlGeneratorAgent)
- `ApiDesignAgent` - Generates OpenAPI specs
- `SqlGeneratorAgent` - Generates SQL scripts

**Orchestration**:
- `CodeGenerator` - Orchestrates the agents

## 🚀 Quick Start

### Requirements
- Java 21+
- Maven 3.8+

### Build
```bash
mvn clean compile
```

### Run
```bash
mvn exec:java -Dexec.mainClass="org.example.Main"
```

### Example Output
```
╔════════════════════════════════════════════════╗
║  Story-to-Code Generator (Java 21 + AI)      ║
╚════════════════════════════════════════════════╝

📝 User Story: Product Catalog API
   Product management system with CRUD and search

🚀 Generating code for: Product Catalog API
✓ API Contract generated
✓ SQL Script generated
✅ Code generated successfully!

═══════════════════════════════════════════════
📋 OPENAPI SPEC
═══════════════════════════════════════════════
openapi: 3.0.3
info:
  title: Product Catalog API
  description: Product management system with CRUD and search
  version: 1.0.0
...

═══════════════════════════════════════════════
🗄️  SQL SCRIPT
═══════════════════════════════════════════════
CREATE TABLE IF NOT EXISTS product_catalog_api (
    id UUID PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    ...
```

## 🧪 Tests

```bash
mvn test
```

Tests cover:
- ✅ UserStory validation
- ✅ Complete code generation
- ✅ Error handling

## 🎥 Recording Video for LinkedIn

### Quick Demo (30 seconds)

```bash
# Option 1: Simple and direct demo
mvn clean compile -q && mvn exec:java -Dexec.mainClass="org.example.Main" -q

# Option 2: Using the script
bash video-demo.sh
```

### Demo with Multiple Examples (60 seconds)

```bash
# Shows 3 different User Stories being processed
mvn exec:java -Dexec.mainClass="org.example.MainMultipleExamples" -q
```

### Customizable Demo

```bash
# Edit src/main/java/org/example/MainCustomExamples.java
# Uncomment one of the examples (E-commerce, Blog, Scheduling, Payment)
# Then run:
mvn exec:java -Dexec.mainClass="org.example.MainCustomExamples" -q
```

### 📹 Recording Instructions

**On Mac:**
1. Open QuickTime Player (⌘ + Space → "QuickTime")
2. **File → New Screen Recording**
3. Increase terminal font to 18pt
4. Run one of the commands above
5. Let it run naturally (45-90 seconds)

**Recommendations:**
- ✅ Resolution: 1080p or 1440p
- ✅ Terminal font: 18pt (readable)
- ✅ No distractions (close other tabs)
- ✅ Dark theme in terminal

### 📝 Script (60 seconds)

```
[0-10s]  "Hi! I created a Java 21 project that generates API + SQL from requirements"
[10-50s] Run: mvn clean compile -q && mvn exec:java -Dexec.mainClass="org.example.Main" -q
[50-60s] "Everything was generated in seconds! Java 21 with Records and Sealed Interfaces."
```

### 🎯 LinkedIn Post Text

```
🚀 I built a project that showcases the power of modern Java 21!

Story-to-Code Generator: A system that takes a requirement description
and automatically generates:
✓ Complete OpenAPI Contract
✓ SQL DDL with indexes and constraints

All using:
• Sealed Interfaces
• Records (immutability)
• Pattern Matching
• Text Blocks

Java remains the most secure and performant language for complex backends! 💪

#Java #Java21 #Architecture #Backend #SoftwareEngineering
```

## 📦 Project Structure

```
src/main/java/org/example/
├── Main.java                           # Main demo
├── MainMultipleExamples.java           # 3 different examples
├── MainCustomExamples.java             # Customizable examples
├── agents/
│   ├── Agent.java                      # Sealed interface
│   ├── ApiDesignAgent.java
│   └── SqlGeneratorAgent.java
├── core/
│   └── CodeGenerator.java              # Orchestrator
└── domain/
    ├── UserStory.java
    ├── ApiContract.java
    ├── SqlScript.java
    ├── GeneratedCode.java
    └── AgentResponse.java

Scripts:
├── video-demo.sh                       # Quick demo (45s)
├── video-demo-multi.sh                 # Multiple demo (90s)
└── demo.sh                             # Complete demo with tests
```

## 💡 Java 21 Features

This project demonstrates:

1. **Sealed Interfaces** - `Agent<T> permits ApiDesignAgent, SqlGeneratorAgent`
2. **Records** - Immutability and automatic validation with compact constructors
3. **Pattern Matching** - Type checking and conditions in switch
4. **Text Blocks** - Multi-line string templates

## 🔧 Next Steps (TODO)

To use real AI:

```java
// TODO: Integrate with LangChain4j + OpenAI
// @AiService
// public interface CodeGenerationService {
//     @SystemMessage("...")
//     ApiContract generateApiContract(UserStory story);
// }
```

See `LANGCHAIN4J_INTEGRATION.md` for integration steps.

## 📊 Metrics

- **Lines of Code**: ~650 (functional)
- **Classes**: 12 (business logic) + 3 (demo) + 2 (tests) = 17 files
- **Tests**: 6 ✅ (2 test classes)
- **Demo Options**: 3
- **Dependencies**: LangChain4j, SLF4J, JUnit 5

## 📄 License

MIT - Free to use in personal portfolio.

---

**Built with ❤️ using Java 21**

