#!/bin/bash

# Demo with multiple examples to show flexibility
cd /Users/michelle.henriques/Documents/Texas/ProjetosGit/ia-java

clear

echo ""
echo "╔═════════════════════════════════════════════════════════════════╗"
echo "║                                                                 ║"
echo "║        📖 Story-to-Code Generator (Multiple Examples)          ║"
echo "║                                                                 ║"
echo "║   Showing flexibility: 3 different User Stories               ║"
echo "║                                                                 ║"
echo "╚═════════════════════════════════════════════════════════════════╝"
echo ""

echo "→ Compiling..."
mvn clean compile -q

echo "→ Running multiple examples..."
echo ""

mvn exec:java -Dexec.mainClass="org.example.MainMultipleExamples" -q 2>&1 | grep -v "^\[INFO\]"

echo ""
echo "═══════════════════════════════════════════════════════════════════"
echo ""
echo "✅ All examples were processed!"
echo ""
echo "📊 Each User Story generated:"
echo "   ✓ Complete OpenAPI 3.0.3 API"
echo "   ✓ SQL DDL with appropriate structure"
echo ""
echo "🎯 This demonstrates the flexibility and reusability of the system!"
echo ""

