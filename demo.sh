#!/bin/bash

# Colors for output
BLUE='\033[0;34m'
GREEN='\033[0;32m'
YELLOW='\033[1;33m'
RED='\033[0;31m'
BOLD='\033[1m'
NC='\033[0m' # No Color

clear

# Title
echo -e "${BLUE}${BOLD}"
echo "╔═══════════════════════════════════════════════════════════╗"
echo "║                                                           ║"
echo "║   🚀 Story-to-Code Generator (Java 21 + LangChain4j)    ║"
echo "║                                                           ║"
echo "║   Generating API Contracts + SQL from User Stories      ║"
echo "║                                                           ║"
echo "╚═══════════════════════════════════════════════════════════╝"
echo -e "${NC}"

echo ""
echo -e "${YELLOW}[1/3] Compiling project...${NC}"
echo ""

# Build
mvn clean compile -q 2>/dev/null

if [ $? -eq 0 ]; then
    echo -e "${GREEN}✓ Compilation completed successfully!${NC}"
else
    echo -e "${RED}✗ Compilation error${NC}"
    exit 1
fi

echo ""
echo -e "${YELLOW}[2/3] Running tests...${NC}"
echo ""

# Tests
mvn test -q 2>/dev/null

if [ $? -eq 0 ]; then
    echo -e "${GREEN}✓ All tests passed!${NC}"
else
    echo -e "${RED}✗ Test failure${NC}"
    exit 1
fi

echo ""
echo -e "${YELLOW}[3/3] Running demo...${NC}"
echo ""
echo -e "${BOLD}${GREEN}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"
echo ""

# Run the demo
mvn exec:java -Dexec.mainClass="org.example.Main" -q 2>/dev/null

echo ""
echo -e "${BOLD}${GREEN}━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━${NC}"
echo ""

echo -e "${BLUE}${BOLD}Demo completed! 🎉${NC}"
echo ""
echo -e "${BOLD}Java Features Demonstrated:${NC}"
echo -e "  ✓ ${GREEN}Sealed Interfaces${NC} - Complete control over implementations"
echo -e "  ✓ ${GREEN}Records${NC} - Type-safe immutable data"
echo -e "  ✓ ${GREEN}Text Blocks${NC} - Multi-line strings"
echo -e "  ✓ ${GREEN}Pattern Matching${NC} - Clean and readable code"
echo ""
echo -e "${BOLD}Architecture:${NC}"
echo -e "  • ${GREEN}UserStory${NC} → system input"
echo -e "  • ${GREEN}CodeGenerator${NC} → orchestrates agents"
echo -e "  • ${GREEN}ApiDesignAgent${NC} → generates OpenAPI specs"
echo -e "  • ${GREEN}SqlGeneratorAgent${NC} → generates SQL DDL"
echo ""
echo -e "${YELLOW}Code available at: ia-java/${NC}"
echo ""

