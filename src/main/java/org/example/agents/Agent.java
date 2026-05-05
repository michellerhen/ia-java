package org.example.agents;

import org.example.domain.AgentResponse;
import org.example.domain.UserStory;

/**
 * Sealed interface para agentes de IA.
 * Apenas ApiDesignAgent e SqlGeneratorAgent podem implementar.
 */
public sealed interface Agent<T> permits ApiDesignAgent, SqlGeneratorAgent {
    /**
     * Executa o agente com uma User Story.
     */
    AgentResponse<T> execute(UserStory story);

    /**
     * Retorna o nome do agente.
     */
    String name();
}

