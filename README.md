El patrón Command es un patrón de comportamiento que convierte una solicitud en un objeto independiente que contiene toda la información sobre la solicitud. Esto permite parametrizar objetos con operaciones, encolar operaciones, y soportar operaciones deshacer.

📋 ¿Qué es el Patrón Command?
Problema que resuelve:

Desacoplar el objeto que invoca una operación del objeto que sabe cómo realizarla

Necesitas encolar operaciones, soportar operaciones deshacer o registrar logs de operaciones

Quieres parametrizar objetos con operaciones

Solución:

Crear objetos comando que encapsulan una solicitud

El invocador trabaja con comandos en lugar de con receptores directamente

Los comandos pueden ser almacenados, encolados, y ejecutados en diferentes momentos

