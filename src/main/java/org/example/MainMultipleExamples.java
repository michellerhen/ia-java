package org.example;

import org.example.core.CodeGenerator;
import org.example.domain.GeneratedCode;
import org.example.domain.UserStory;

/**
 * Demo alternativa: Múltiplas histórias para mostrar flexibilidade
 */
public class MainMultipleExamples {

    public static void main(String[] args) {
        // Exemplos diferentes de User Stories
        UserStory[] stories = {
            new UserStory("story-1", "Product Catalog API",
                "Sistema de gerenciamento de produtos com CRUD e busca"),

            new UserStory("story-2", "User Authentication Service",
                "Serviço de autenticação com JWT, refresh tokens e roles"),

            new UserStory("story-3", "Order Management System",
                "Sistema para gerenciar pedidos, pagamentos e envios")
        };

        CodeGenerator generator = new CodeGenerator();

        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║  Story-to-Code Generator (Multi Example)       ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        for (UserStory story : stories) {
            System.out.println("━".repeat(50));
            System.out.println("📝 Processing: " + story.title());
            System.out.println("━".repeat(50));

            try {
                GeneratedCode code = generator.generate(story);

                System.out.println("✓ API Contract gerado");
                System.out.println("✓ SQL Script gerado");
                System.out.println("✅ Story processada com sucesso!\n");

                System.out.println("📋 API Title: " + code.apiContract().title());
                System.out.println("🗄️  Table: " + code.sqlScript().ddl().split("\\n")[0]);
                System.out.println();
            } catch (IllegalStateException e) {
                System.out.println("❌ Erro: " + e.getMessage() + "\n");
            }
        }

        System.out.println("═".repeat(50));
        System.out.println("✅ Processamento concluído!");
        System.out.println("═".repeat(50) + "\n");
    }
}

