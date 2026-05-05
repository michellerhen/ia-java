package org.example.domain;

/**
 * Record genérico para respostas de Agentes com padrão Result<T, E>.
 */
public record AgentResponse<T>(
    boolean success,
    T data,
    String error
) {
    public AgentResponse {
        if (success && data == null) throw new IllegalArgumentException("Se success=true, data não pode ser nulo");
        if (!success && (error == null || error.isBlank())) throw new IllegalArgumentException("Se success=false, error não pode ser vazio");
    }

    public static <T> AgentResponse<T> success(T data) {
        return new AgentResponse<>(true, data, null);
    }

    public static <T> AgentResponse<T> failure(String error) {
        return new AgentResponse<>(false, null, error);
    }
}

