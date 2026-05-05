package org.example.domain;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserStoryTest {

    @Test
    void testCreateValidUserStory() {
        UserStory story = UserStory.of(
            "product-api",
            "Product API",
            "Gerencia produtos"
        );

        assertNotNull(story);
        assertEquals("product-api", story.id());
        assertEquals("Product API", story.title());
        assertEquals("Gerencia produtos", story.description());
    }

    @Test
    void testRejectBlankId() {
        assertThrows(IllegalArgumentException.class, () ->
            UserStory.of("", "Title", "Desc")
        );
    }

    @Test
    void testRejectBlankTitle() {
        assertThrows(IllegalArgumentException.class, () ->
            UserStory.of("id", "", "Desc")
        );
    }

    @Test
    void testRejectBlankDescription() {
        assertThrows(IllegalArgumentException.class, () ->
            UserStory.of("id", "Title", "")
        );
    }
}

