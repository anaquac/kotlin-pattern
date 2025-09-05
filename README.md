Qué es el Patrón Observer?
Problema que resuelve:

Necesitas notificar a múltiples objetos sobre cambios en otro objeto

Quieres mantener un acoplamiento bajo entre el sujeto y los observadores

Deseas que los objetos se actualicen automáticamente ante cambios

Solución:

Un Sujeto mantiene una lista de Observadores

Los Observadores se registran en el Sujeto

Cuando el Sujeto cambia, notifica a todos los Observadores registrados