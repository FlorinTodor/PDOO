# PDOO
PDDO UGR 2023-2024
En este repositorio se encuentra tanto la práctica como otros ficheros de la asignatura.

# 🏰 Irrgarten – Proyecto PDOO

## 📌 Descripción
Este repositorio contiene el desarrollo completo del videojuego **Irrgarten**, realizado como parte de la asignatura **Programación y Diseño Orientado a Objetos (PDOO)**.
El proyecto se implementa progresivamente en **Java** y **Ruby**, siguiendo una arquitectura orientada a objetos y aplicando principios de alta cohesión y bajo acoplamiento.

---

## 📆 Evolución del Proyecto

### 🔹 Práctica 1 – Fundamentos y clases iniciales
Se sientan las bases del modelo con la creación de enumerados y clases esenciales:
-   **Enumerados:**
    -   `Directions` (LEFT, RIGHT, UP, DOWN)
    -   `Orientation` (VERTICAL, HORIZONTAL)
    -   `GameCharacter` (PLAYER, MONSTER)
-   **Clases Base:**
    -   `Weapon`: con atributos `power`, `uses` y métodos `attack()`, `discard()`.
    -   `Shield`: con atributos `protection`, `uses` y métodos `protect()`, `discard()`.
    -   `Dice`: gestiona todas las decisiones aleatorias (probabilidades, generación de atributos, recompensas).
    -   `GameState`: encapsula el estado completo del juego (laberinto, jugadores, monstruos, turno, ganador, log).
-   **Pruebas:** Se utiliza un programa `TestP1` para validar el funcionamiento inicial de las clases y enumerados.

### 🔹 Práctica 2 – Ampliación del modelo y relaciones
Se implementa el diagrama de clases completo del dominio del problema:
-   **Nuevas Clases:**
    -   `Monster`
    -   `Player`
    -   `Labyrinth`
    -   `Game`
-   **Funcionalidades añadidas:**
    -   Constructores con inicialización completa de atributos.
    -   Métodos de lógica básica como `attack()`, `defend()`, `gotWounded()`, `setPos()`, `toString()`.
    -   Gestión inicial del stock de armas y escudos de los personajes.
    -   Representación interna del laberinto con arrays bidimensionales y caracteres (`'X'`, `'-'`, `'M'`, `'E'`, `'C'`).
    -   Configuración inicial del juego con colocación de monstruos y jugadores.

### 🔹 Prácticas posteriores – Lógica de juego y funcionalidades avanzadas
Se desarrolla la lógica completa del videojuego y las interacciones complejas:
-   Implementación del **movimiento** de jugadores y monstruos dentro del laberinto.
-   Gestión de **combates**, turnos y cálculo de resultados.
-   Reparto de **recompensas** (armas, escudos, salud) controlado por la clase `Dice`.
-   **Persistencia y consulta** del estado del juego a través del objeto `GameState`.
-   **Registro en un log** de eventos relevantes:
    -   Ganador de combates.
    -   Resurrecciones de personajes.
    -   Pérdida de turno por muerte.
    -   Movimientos sin éxito.
-   Métodos de interacción complejos como `manageHit()`, `receiveReward()`, `spreadPlayers()`.

---

## 🛠️ Tecnologías y Herramientas
-   **Lenguajes:** Java, Ruby.
-   **Entorno Java:** NetBeans (Java SE) y Jetbrains.
-   **Entorno Ruby:** RubyMine
-   **Control de versiones:** Git / GitHub.
-   **Buenas prácticas aplicadas:**
    -   Nomenclatura adaptada a cada lenguaje (`lowerCamelCase` en Java, `snake_case` en Ruby).
    -   Aplicación de principios **SOLID**.
    -   Uso de colecciones estándar (`ArrayList` en Java, `Array` en Ruby).
    -   Fuerte enfoque en la **modularidad y encapsulación**.

---

## 📈 Aprendizajes Clave
-   Diseño e implementación progresiva de un sistema Orientado a Objetos complejo desde cero.
-   Traducción y aplicación de **diagramas de clases** a código funcional.
-   Gestión de las **interacciones entre m
