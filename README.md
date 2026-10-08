# Caso práctico 1 – Programación multihilo

Programa en Java con 3 hebras. Cada una escribe por pantalla
un carácter varias veces; el carácter y el número de repeticiones
se pasan como parámetros en el constructor.

## Estructura
- `Main.java`: crea las tres hebras ('A', 'B' y 'C') y las lanza con `start()`.
- `Hebra.java`: extiende `Thread` y en su método `run()` imprime
  el carácter tantas veces como se indique.

## ¿Se mezclan las letras?
Sí, se mezclan. Al ejecutar el programa varias veces, las letras salen
intercaladas (por ejemplo `AAAABBBCCCAABBB...`) y además el resultado
cambia en cada ejecución.

Esto pasa porque las tres hebras se ejecutan a la vez. Una vez que las
lanzo con `start()`, ya no controlo yo cuál se ejecuta en cada momento,
sino el planificador del sistema operativo y de la JVM. El planificador
va repartiendo el tiempo de CPU entre las hebras, así que una escribe
unas cuantas letras, se para, entra otra, y así todo el rato.

Como no he usado ningún tipo de sincronización, no hay nada que
garantice un orden, y por eso cada ejecución sale distinta. Aunque
lance las hebras en orden (A, B y C), eso no significa que vayan a
empezar ni a terminar en ese orden.

También me he dado cuenta de que con pocas repeticiones casi no se
nota la mezcla, porque a cada hebra le da tiempo a terminar antes de
que el planificador cambie a otra. Con más repeticiones se ve mucho
más claro.