package org.example;

import org.example.core.CodeGenerator;
import org.example.domain.GeneratedCode;
import org.example.domain.UserStory;

/**
 * Exemplos customizados de User Stories para gravar vídeos
 * Use esses exemplos para criar diferentes cenários
 */
public class MainCustomExamples {

    public static void main(String[] args) {
        // Escolha um exemplo descomentando:

        // 1. E-commerce simples
        // demonstrateStory(new UserStory(
        //     "ecommerce-api",
        //     "E-commerce Product API",
        //     "API para gerenciar produtos, estoque e categorias com busca full-text"
        // ));

        // 2. Sistema de blog
        // demonstrateStory(new UserStory(
        //     "blog-api",
        //     "Blog Platform API",
        //     "Sistema de blogging com posts, comentários, tags e autenticação"
        // ));

        // 3. Sistema de agendamento
        // demonstrateStory(new UserStory(
        //     "scheduling-api",
        //     "Appointment Scheduling Service",
        //     "Serviço de agendamento com calendário, notificações e reminders"
        // ));

        // 4. Sistema de pagamento
        demonstrateStory(new UserStory(
            "payment-api",
            "Payment Gateway Integration",
            "Sistema de processamento de pagamentos com webhook e status tracking"
        ));
    }

    private static void demonstrateStory(UserStory story) {
        CodeGenerator generator = new CodeGenerator();

        System.out.println("\n╔════════════════════════════════════════════════╗");
        System.out.println("║  Story-to-Code Generator (Custom Example)      ║");
        System.out.println("╚════════════════════════════════════════════════╝\n");

        System.out.println("📝 User Story: " + story.title());
        System.out.println("   " + story.description() + "\n");

        try {
            GeneratedCode code = generator.generate(story);

            System.out.println("═══════════════════════════════════════════════");
            System.out.println("📋 OPENAPI SPEC");
            System.out.println("═══════════════════════════════════════════════");
            System.out.println(code.apiContract().openApiSpec() + "\n");

            System.out.println("═══════════════════════════════════════════════");
            System.out.println("🗄️  SQL SCRIPT");
            System.out.println("═══════════════════════════════════════════════");
            System.out.println(code.sqlScript().ddl());
            System.out.println(code.sqlScript().indexes());
            System.out.println(code.sqlScript().constraints());

        } catch (IllegalStateException e) {
            System.out.println("❌ Erro: " + e.getMessage());
        }
    }
}

/*
 * 💡 COMO USAR ESTE ARQUIVO PARA GRAVAR:
 *
 * 1. Escolha um dos exemplos comentados acima
 * 2. Descomente a linha (remova as //)
 * 3. Recompile:
 *    mvn clean compile
 *
 * 4. Execute:
 *    mvn exec:java -Dexec.mainClass="org.example.MainCustomExamples"
 *
 * 5. Grave o resultado
 *
 * DICA: Mude o exemplo a cada gravação para ter vários vídeos!
 */

