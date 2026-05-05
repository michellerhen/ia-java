#!/bin/bash

# Quick demo for LinkedIn video
# Shows application execution in a clean and clear manner

cd /Users/michelle.henriques/Documents/Texas/ProjetosGit/ia-java

clear

echo ""
echo "╔═════════════════════════════════════════════════════════════════╗"
echo "║                                                                 ║"
echo "║        📖 Story-to-Code Generator (Java 21 + AI)              ║"
echo "║                                                                 ║"
echo "║   Takes a User Story and generates:                           ║"
echo "║   • OpenAPI Contract (API Specification)                      ║"
echo "║   • SQL Script (DDL + Indexes + Constraints)                  ║"
echo "║                                                                 ║"
echo "╚═════════════════════════════════════════════════════════════════╝"
echo ""

echo "→ Compiling..."
mvn clean compile -q

echo "→ Running..."
echo ""

mvn exec:java -Dexec.mainClass="org.example.Main" -q 2>&1 | grep -v "^\[INFO\]"

echo ""
echo "═══════════════════════════════════════════════════════════════════"
echo ""
echo "✅ Production ready!"
echo ""
echo "📊 What was generated:"
echo "   ✓ API OpenAPI 3.0.3 fully specified"
echo "   ✓ SQL DDL with tables, indexes and constraints"
echo "   ✓ All from a simple requirement description"
echo ""
echo "🎯 Java 21 Features:"
echo "   • Sealed Interfaces (Agent<T>)"
echo "   • Records with validation"
echo "   • Text Blocks"
echo "   • Pattern Matching"
echo ""

