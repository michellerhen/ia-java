package org.example.agents;

import org.example.domain.AgentResponse;
import org.example.domain.ApiContract;
import org.example.domain.UserStory;

/**
 * Agente que gera contratos de API (OpenAPI spec).
 * TODO: Integrar com LangChain4j + ChatGPT em produção.
 */
public final class ApiDesignAgent implements Agent<ApiContract> {

    @Override
    public AgentResponse<ApiContract> execute(UserStory story) {
        try {
            String openApiSpec = generateOpenApiSpec(story);
            ApiContract contract = ApiContract.of(
                "API: " + story.title(),
                openApiSpec
            );
            return AgentResponse.success(contract);
        } catch (Exception e) {
            return AgentResponse.failure("Erro ao gerar contrato: " + e.getMessage());
        }
    }

    @Override
    public String name() {
        return "ApiDesignAgent";
    }

    private String generateOpenApiSpec(UserStory story) {
        return """
            openapi: 3.0.3
            info:
              title: %s
              description: %s
              version: 1.0.0
            servers:
              - url: https://api.example.com/v1
            paths:
              /%s:
                get:
                  summary: Listar %s
                  responses:
                    '200':
                      description: Sucesso
                post:
                  summary: Criar %s
                  responses:
                    '201':
                      description: Criado
                    '400':
                      description: Erro
            """.formatted(
            story.title(),
            story.description(),
            story.id().toLowerCase(),
            story.title(),
            story.title()
        );
    }
}

