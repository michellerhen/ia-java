package org.example.core;

import org.example.agents.Agent;
import org.example.agents.ApiDesignAgent;
import org.example.agents.SqlGeneratorAgent;
import org.example.domain.AgentResponse;
import org.example.domain.ApiContract;
import org.example.domain.GeneratedCode;
import org.example.domain.SqlScript;
import org.example.domain.UserStory;

/**
 * Gerador de Código a partir de User Stories.
 * Orquestra agentes de IA para gerar API + SQL.
 */
public class CodeGenerator {
    private final Agent<ApiContract> apiAgent;
    private final Agent<SqlScript> sqlAgent;

    public CodeGenerator() {
        this.apiAgent = new ApiDesignAgent();
        this.sqlAgent = new SqlGeneratorAgent();
    }

    /**
     * Gera código (API Contract + SQL Script) para uma User Story.
     *
     * @param story A user story de entrada
     * @return GeneratedCode com API + SQL gerados
     * @throws IllegalStateException Se algum agente falhar
     */
    public GeneratedCode generate(UserStory story) {
        System.out.println("🚀 Gerando código para: " + story.title());

        // Executa ApiDesignAgent
        AgentResponse<ApiContract> apiResponse = apiAgent.execute(story);
        if (!apiResponse.success()) {
            throw new IllegalStateException("Falha ao gerar API: " + apiResponse.error());
        }
        System.out.println("✓ API Contract gerado");

        // Executa SqlGeneratorAgent
        AgentResponse<SqlScript> sqlResponse = sqlAgent.execute(story);
        if (!sqlResponse.success()) {
            throw new IllegalStateException("Falha ao gerar SQL: " + sqlResponse.error());
        }
        System.out.println("✓ SQL Script gerado");

        // Retorna resultado combinado
        GeneratedCode result = GeneratedCode.of(story, apiResponse.data(), sqlResponse.data());
        System.out.println("✅ Código gerado com sucesso!\n");
        return result;
    }
}

