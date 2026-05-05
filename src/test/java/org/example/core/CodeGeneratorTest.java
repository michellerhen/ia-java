package org.example.core;

import org.example.domain.GeneratedCode;
import org.example.domain.UserStory;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CodeGeneratorTest {

    @Test
    void testGenerateCodeSuccessfully() {
        CodeGenerator generator = new CodeGenerator();
        UserStory story = UserStory.of(
            "test-api",
            "Test API",
            "Test description"
        );

        GeneratedCode result = generator.generate(story);

        assertNotNull(result);
        assertNotNull(result.apiContract());
        assertNotNull(result.sqlScript());
        assertEquals(story, result.story());
        assertTrue(result.apiContract().openApiSpec().contains("openapi"));
        assertTrue(result.sqlScript().ddl().contains("CREATE TABLE"));
    }

    @Test
    void testGenerateThrowsOnNull() {
        CodeGenerator generator = new CodeGenerator();
        assertThrows(NullPointerException.class, () ->
            generator.generate(null)
        );
    }
}

