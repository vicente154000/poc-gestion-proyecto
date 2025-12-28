#!/bin/bash
# pipeline_cd.sh
# Script para orquestar un pipeline de CI/CD local
# Autor: Mario Vicente

set -a
source .env
set +a

# Colores
RED='\033[0;31m'
GREEN='\033[0;32m'
BLUE='\033[0;34m'
NC='\033[0m'

echo -e "${BLUE}========================================${NC}"
echo -e "${RED}   INICIANDO PIPELINE DE CI/CD LOCAL    ${NC}"
echo -e "${BLUE}========================================${NC}"

# Paso 1: Limpieza
# Usamos -E con sudo para que conserve las variables que acabamos de cargar
echo -e "${RED}[Paso 1/3] Limpiando entorno anterior...${NC}"
sudo -E docker-compose down --remove-orphans

# Paso 2: Construcción y Despliegue
echo -e "${RED}[Paso 2/3] Construyendo y Desplegando Contenedores...${NC}"
sudo -E docker-compose up -d --build

# Paso 3: Verificación
echo -e "${RED}[Paso 3/3] Verificando estado del despliegue...${NC}"
echo "Esperando 10 segundos a que arranque Spring Boot..."
sleep 10
sudo docker-compose ps

echo -e "${BLUE}========================================${NC}"
echo -e "${RED}   ¡DESPLIEGUE COMPLETADO!              ${NC}"
echo -e "${BLUE}========================================${NC}"