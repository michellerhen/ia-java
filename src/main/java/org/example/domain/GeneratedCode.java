package org.example.domain;

/**
 * Result da geração de código (API + SQL).
 */
public record GeneratedCode(
    UserStory story,
    ApiContract apiContract,
    SqlScript sqlScript
) {
    public GeneratedCode {
        if (story == null) throw new IllegalArgumentException("story não pode ser nulo");
        if (apiContract == null) throw new IllegalArgumentException("apiContract não pode ser nulo");
        if (sqlScript == null) throw new IllegalArgumentException("sqlScript não pode ser nulo");
    }

    public static GeneratedCode of(UserStory story, ApiContract api, SqlScript sql) {
        return new GeneratedCode(story, api, sql);
    }
}

