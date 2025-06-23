#!/bin/bash

echo "1 - Compilar"
echo "2 - Executar"
echo "3 - Sair"
read res

if [ "$res" == "1" ]; then
    echo "Compilando..."
    javac -d bin $(find src -name "*.java")
    echo "Compilado com sucesso!"

elif [ "$res" == "2" ]; then
    reset
    echo "Executando..."
    java -cp bin application.App

else
    echo "Saindo..."
    exit
fi
