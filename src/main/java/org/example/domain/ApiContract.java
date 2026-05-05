package org.example.domain;

/**
 * Record para um contrato de API (OpenAPI spec).
 * Gerado pelo ApiDesignAgent.
 */
public record ApiContract(
    String title,
    String openApiSpec
) {
    public ApiContract {
        if (title == null || title.isBlank()) throw new IllegalArgumentException("title não pode ser vazio");
        if (openApiSpec == null || openApiSpec.isBlank()) throw new IllegalArgumentException("openApiSpec não pode ser vazio");
    }

    public static ApiContract of(String title, String openApiSpec) {
        return new ApiContract(title, openApiSpec);
    }
}

