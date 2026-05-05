package org.example.domain;

/**
 * Record para um script SQL.
 * Gerado pelo SqlGeneratorAgent.
 */
public record SqlScript(
    String ddl,
    String indexes,
    String constraints
) {
    public SqlScript {
        if (ddl == null || ddl.isBlank()) throw new IllegalArgumentException("ddl não pode ser vazio");
        if (indexes == null) throw new IllegalArgumentException("indexes não pode ser nulo");
        if (constraints == null) throw new IllegalArgumentException("constraints não pode ser nulo");
    }

    public static SqlScript of(String ddl, String indexes, String constraints) {
        return new SqlScript(ddl, indexes, constraints);
    }

    /**
     * Combina todo o SQL em um script ordenado.
     */
    public String getFullScript() {
        return String.join("\n\n", ddl, indexes, constraints);
    }
}

