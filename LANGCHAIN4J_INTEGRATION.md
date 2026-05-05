# How to Integrate with LangChain4j + OpenAI (TODO)

This project has been prepared for real AI integration. Here are the steps:

## 1. Add Configuration to pom.xml

```xml
<dependency>
    <groupId>dev.langchain4j</groupId>
    <artifactId>langchain4j-spring-boot-starter</artifactId>
    <version>0.33.0</version>
</dependency>
```

## 2. Get OpenAI API Key

```bash
export OPENAI_API_KEY="sk-..."
```

## 3. Create an AI Service

```java
package org.example.ai;

import dev.langchain4j.service.AiService;
import dev.langchain4j.service.SystemMessage;
import dev.langchain4j.service.UserMessage;

@AiService
public interface CodeGenerationService {

    @SystemMessage("You are an experienced API architect. Generate a complete OpenAPI specification.")
    String generateOpenApiSpec(
        @UserMessage String userStory
    );

    @SystemMessage("You are an experienced DBA. Generate a complete SQL schema.")
    String generateSqlSchema(
        @UserMessage String userStory
    );
}
```

## 4. Integrate into Agents

### ApiDesignAgent.java
```java
@Override
public AgentResponse<ApiContract> execute(UserStory story) {
    try {
        String spec = codeGenService.generateOpenApiSpec(
            "User Story: " + story.title() + "\n" + story.description()
        );
        
        ApiContract contract = ApiContract.of(story.title(), spec);
        return AgentResponse.success(contract);
    } catch (Exception e) {
        return AgentResponse.failure(e.getMessage());
    }
}
```

### SqlGeneratorAgent.java
```java
@Override
public AgentResponse<SqlScript> execute(UserStory story) {
    try {
        String sql = codeGenService.generateSqlSchema(
            "User Story: " + story.title() + "\n" + story.description()
        );
        
        // Parse SQL into DDL, indexes, constraints
        SqlScript script = parseSql(sql);
        return AgentResponse.success(script);
    } catch (Exception e) {
        return AgentResponse.failure(e.getMessage());
    }
}
```

## 5. Environment Variables

Create a `.env` file:

```
OPENAI_API_KEY=sk-...
OPENAI_MODEL=gpt-4
```

## 6. Example with LangChain4j Direct

```java
import dev.langchain4j.model.chat.ChatLanguageModel;
import dev.langchain4j.model.openai.OpenAiChatModel;
import dev.langchain4j.data.message.UserMessage;

public class ApiDesignAgent implements Agent<ApiContract> {
    private final ChatLanguageModel model;

    public ApiDesignAgent() {
        this.model = OpenAiChatModel.builder()
            .apiKey(System.getenv("OPENAI_API_KEY"))
            .modelName("gpt-4")
            .build();
    }

    @Override
    public AgentResponse<ApiContract> execute(UserStory story) {
        try {
            String prompt = """
                Generate a complete OpenAPI 3.0.3 specification for:
                Title: %s
                Description: %s
                
                Include:
                - Multiple endpoints (GET, POST, PUT, DELETE)
                - Request/response schemas
                - Error handling
                """.formatted(story.title(), story.description());

            String response = model.generate(new UserMessage(prompt));
            ApiContract contract = ApiContract.of(story.title(), response);
            return AgentResponse.success(contract);
        } catch (Exception e) {
            return AgentResponse.failure(e.getMessage());
        }
    }
}
```

## 7. Testing with Mock

Use Mockito to test without calling OpenAI:

```java
@Test
void testAgentWithMock() {
    ChatLanguageModel mockModel = Mockito.mock(ChatLanguageModel.class);
    Mockito.when(mockModel.generate(any())).thenReturn("openapi: 3.0.3 ...");
    
    ApiDesignAgent agent = new ApiDesignAgent(mockModel);
    AgentResponse<ApiContract> response = agent.execute(story);
    
    assertTrue(response.success());
}
```

## 8. Performance and Caching

To cache AI responses (avoid costs):

```java
@CacheConfig(cacheNames = "apiContracts")
public class ApiDesignAgent implements Agent<ApiContract> {

    @Cacheable(key = "#story.id()")
    @Override
    public AgentResponse<ApiContract> execute(UserStory story) {
        // ... call to LLM
    }
}
```

## Next Steps

1. Setup OpenAI credentials
2. Test with a simple example
3. Add rate limiting (OpenAI has limits)
4. Implement robust retry logic
5. Add structured logging

---

**The project is already ready for this! Just follow these steps.**

