¿Qué es el Patrón Strategy?
Problema que resuelve:

Tienes múltiples algoritmos para una misma tarea

Quieres poder cambiar el algoritmo en tiempo de ejecución

Necesitas evitar condicionales complejos (if/else o switch)

Quieres seguir el principio Open/Closed

Solución:

Definir una interfaz común para todos los algoritmos

Implementar cada algoritmo en una clase separada

Permitir que el cliente elija el algoritmo a usar