#!/bin/bash
# pipeline_cd.sh
# Script para orquestar un pipeline de CI/CD local usando Docker Compose
# Autor: Mario Vicente

# Colores para la salida en consola
RED='\033[0;31m'
GREEN='\033[0;32m'
BLUE='\033[0;34m'
NC='\033[0m' # No Color

echo -e "${BLUE}========================================${NC}"
echo -e "${RED}   INICIANDO PIPELINE DE CI/CD LOCAL    ${NC}"
echo -e "${BLUE}========================================${NC}"

# Paso 1: Limpieza
echo -e "${GREEN}[Paso 1/3] Limpiando entorno anterior...${NC}"
sudo docker-compose down --remove-orphans

# Paso 2: Construcción y Despliegue
# Aquí Docker lee los Dockerfiles y compila el código (Build Stage)
echo -e "${GREEN}[Paso 2/3] Construyendo y Desplegando Contenedores...${NC}"
sudo docker-compose up -d --build

# Paso 3: Verificación (Healthcheck simple)
echo -e "${GREEN}[Paso 3/3] Verificando estado del despliegue...${NC}"
sleep 5 # Esperamos un poco a que arranque
sudo docker-compose ps

echo -e "${BLUE}========================================${NC}"
echo -e "${GREEN}   ¡DESPLIEGUE COMPLETADO CON ÉXITO!    ${NC}"
echo -e "${BLUE}========================================${NC}"