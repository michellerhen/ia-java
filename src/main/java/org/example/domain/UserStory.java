package org.example.domain;

/**
 * Record imutável para uma User Story.
 * Representa um requisito que será transformado em código.
 */
public record UserStory(
    String id,
    String title,
    String description
) {
    public UserStory {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id não pode ser vazio");
        if (title == null || title.isBlank()) throw new IllegalArgumentException("title não pode ser vazio");
        if (description == null || description.isBlank()) throw new IllegalArgumentException("description não pode ser vazio");
    }

    public static UserStory of(String id, String title, String description) {
        return new UserStory(id, title, description);
    }
}

