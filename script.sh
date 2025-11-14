#!/bin/bash

# 1. Limpiar y construir todos los módulos
echo "--- Construyendo todos los módulos... ---"
./mvnw clean package

# 2. Navegar a la carpeta 'target' de cada módulo y lanzar el .jar
# El '&' al final es crucial: lanza el proceso en segundo plano.

echo "--- Lanzando estatica (Puerto 8081)... ---"
java -jar estatica/target/estatica*.jar &

echo "--- Lanzando dinamica (Puerto 8082)... ---"
java -jar dinamica/target/dinamica*.jar &

# TODO: Proxy
echo "--- Lanzando normalizador (Puerto 8087)... ---"
java -jar normalizador/target/normalizador*.jar &

echo "--- Lanzando api-gateway (Puerto 8089)... ---"
java -jar api-gateway/target/api-gateway-*.jar &

echo "--- Lanzando gestor-personas (Puerto 8091)... ---"
java -jar gestor-personas/target/gestor-personas-*.jar &


echo "--- Lanzando estadistica (Puerto 8088)... ---"
java -jar estadistica/target/estadistica-*.jar &

echo "--- Lanzando agregador (Puerto 8080)... ---"
java -jar agregador/target/agregador-*.jar &

# 3. Mantener el script vivo
# (Esto es un truco para que el contenedor de Render no se apague)
echo "--- Todos los servicios lanzados. ---"
tail -f /dev/null