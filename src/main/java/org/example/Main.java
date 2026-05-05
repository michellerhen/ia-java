package org.example;

import org.example.core.CodeGenerator;
import org.example.domain.GeneratedCode;
import org.example.domain.UserStory;

/**
 * Demo: Gera API + SQL a partir de uma User Story.
 */
public class Main {

    public static void main(String[] args) {
        System.out.println("╔════════════════════════════════════════════════╗");
        System.out.println("║  Story-to-Code Generator (Java 21 + AI)      ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        // Criar uma user story
        UserStory story = UserStory.of(
            "product-api",
            "Product Catalog API",
            "Sistema de gerenciamento de produtos com CRUD e busca"
        );

        System.out.println("📝 User Story: " + story.title());
        System.out.println("   " + story.description() + "\n");

        // Gerar código
        try {
            CodeGenerator generator = new CodeGenerator();
            GeneratedCode result = generator.generate(story);

            // Exibir API
            System.out.println("═══════════════════════════════════════════════");
            System.out.println("📋 OPENAPI SPEC");
            System.out.println("═══════════════════════════════════════════════");
            System.out.println(result.apiContract().openApiSpec());

            // Exibir SQL
            System.out.println("\n═══════════════════════════════════════════════");
            System.out.println("🗄️  SQL SCRIPT");
            System.out.println("═══════════════════════════════════════════════");
            System.out.println(result.sqlScript().getFullScript());

        } catch (Exception e) {
            System.err.println("❌ Erro: " + e.getMessage());
            e.printStackTrace();
            System.exit(1);
        }
    }
}

