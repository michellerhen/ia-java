#!/bin/bash
# Script para build e test do projeto

echo "╔════════════════════════════════════════════════╗"
echo "║     Story to Code - Build & Test Script       ║"
echo "╚════════════════════════════════════════════════╝"
echo ""

cd "$(dirname "$0")" || exit

echo "📦 Compilando..."
mvn clean compile -q
if [ $? -ne 0 ]; then
    echo "❌ Erro na compilação"
    exit 1
fi
echo "✓ Compilação bem-sucedida"

echo ""
echo "🧪 Executando testes..."
mvn test -q
if [ $? -ne 0 ]; then
    echo "❌ Erro nos testes"
    exit 1
fi
echo "✓ Testes passaram"

echo ""
echo "🚀 Executando aplicação..."
mvn exec:java -q

echo ""
echo "✅ Tudo pronto para produção!"

