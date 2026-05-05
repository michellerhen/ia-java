package org.example.agents;

import org.example.domain.AgentResponse;
import org.example.domain.SqlScript;
import org.example.domain.UserStory;

/**
 * Agente que gera scripts SQL (DDL, índices, constraints).
 * TODO: Integrar com LangChain4j + ChatGPT em produção.
 */
public final class SqlGeneratorAgent implements Agent<SqlScript> {

    @Override
    public AgentResponse<SqlScript> execute(UserStory story) {
        try {
            String ddl = generateDDL(story);
            String indexes = generateIndexes(story);
            String constraints = generateConstraints(story);

            SqlScript script = SqlScript.of(ddl, indexes, constraints);
            return AgentResponse.success(script);
        } catch (Exception e) {
            return AgentResponse.failure("Erro ao gerar SQL: " + e.getMessage());
        }
    }

    @Override
    public String name() {
        return "SqlGeneratorAgent";
    }

    private String generateDDL(UserStory story) {
        return """
            CREATE TABLE IF NOT EXISTS %s (
                id UUID PRIMARY KEY,
                name VARCHAR(255) NOT NULL,
                created_at TIMESTAMP DEFAULT NOW(),
                updated_at TIMESTAMP DEFAULT NOW()
            );
            """.formatted(story.id().toLowerCase());
    }

    private String generateIndexes(UserStory story) {
        return """
            CREATE INDEX IF NOT EXISTS idx_%s_id ON %s(id);
            CREATE INDEX IF NOT EXISTS idx_%s_created ON %s(created_at);
            """.formatted(
            story.id().toLowerCase(),
            story.id().toLowerCase(),
            story.id().toLowerCase(),
            story.id().toLowerCase()
        );
    }

    private String generateConstraints(UserStory story) {
        return """
            ALTER TABLE %s ADD CONSTRAINT check_timestamps 
            CHECK (created_at <= updated_at);
            """.formatted(story.id().toLowerCase());
    }
}

