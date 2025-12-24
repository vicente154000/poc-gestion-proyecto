# Etapa 1: Construcción con Node.js
FROM node:18 AS build
WORKDIR /app
# Copiamos primero los archivos de dependencias para aprovechar la caché de Docker
COPY package*.json ./
RUN npm install
COPY . .
# Compila la aplicación Angular para producción
RUN npm run build -- --configuration production

# Etapa 2: Servidor Web con Nginx
FROM nginx:alpine
COPY --from=build /app/dist/*/ /usr/share/nginx/html

# Configuración necesaria para que Angular maneje las rutas (evita errores 404 al recargar)
RUN echo 'server { \
    listen 80; \
    location / { \
        root /usr/share/nginx/html; \
        index index.html index.htm; \
        try_files $uri $uri/ /index.html; \
    } \
}' > /etc/nginx/conf.d/default.conf

EXPOSE 80