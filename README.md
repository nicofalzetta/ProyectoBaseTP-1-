# Proyecto final Programacion 1

## Descripción
Este es un juego de plataforma en Java en el que nuestro protagonista el caballero Pep tiene que rescartar a gnomos de las tortugas que los quieren capturar.

## Requisitos
- **Java**: versión 8 o superior
- **Entorno Gráfico**: Biblioteca `Entorno` para la gestión de gráficos 2D
- **IDE recomendado**: Eclipse o IntelliJ IDEA

## Instalación y Ejecución
1. Clonar el repositorio en la máquina local que desee.
   ```bash
   git clone https://github.com/nicofalzetta/ProyectoBaseTP-1-.git

# Clases

# `Gnomo`

La clase `Gnomo` representa un personaje en el juego que tiene capacidades de movimiento, visibilidad controlada y detección de colisiones. 

## Atributos

- **`imagen`**: La imagen que representa visualmente al gnomo.
- **`x`, `y`**: Coordenadas de posición del gnomo en el entorno.
- **`velocidad`**: La velocidad a la que el gnomo se mueve en el eje x.
- **`escala`**: Escala de tamaño del gnomo en relación con su imagen original.
- **`desplazamiento`**: Controla el desplazamiento en el movimiento del gnomo.
- **`direccion`**: Indica la dirección del movimiento: 1 para derecha y -1 para izquierda.
- **`tiempoDesaparicion`**: Registra el momento en que el gnomo desaparece.
- **`estaVisible`**: Indica si el gnomo está visible en el entorno.
- **`VELOCIDADES`**: Array que contiene velocidades posibles para cada gnomo.
- **`RANDOM`**: Genera números aleatorios para asignar una velocidad aleatoria a cada gnomo.

## Constructor

### `public Gnomo(Image imagen, double x, double y, double escala)`

Inicializa un gnomo con su imagen, posición (`x` y `y`), escala y una velocidad aleatoria tomada del array `VELOCIDADES`. La dirección inicial se establece aleatoriamente como izquierda o derecha.

## Métodos de Movimiento y Colisión

- ### `boolean estaSobreBarra(Barra[] barras)`
  
  Comprueba si el gnomo está sobre alguna de las barras en el array `barras`. Retorna `true` si está sobre una barra, `false` en caso contrario.

- ### `boolean colisionaConBarra(Barra barra)`
  
  Verifica si el gnomo está en contacto con una barra específica, lo que se usa para invertir la dirección si colisiona. Retorna `true` en caso de colisión.

- ### `void caer(Barra[] barras)`

  Realiza el movimiento de caída del gnomo incrementando su posición `y`. Si colisiona con una barra mientras cae, invierte la dirección en `x`.

- ### `void mover(Barra[] barras)`

  Controla el movimiento general del gnomo. Si no está sobre una barra, el gnomo cae; si está sobre una barra, se mueve horizontalmente en la dirección establecida, y se asegura de no salir de los límites de la pantalla.

## Métodos de Desaparición y Reaparición

- ### `boolean desaparece(double limiteAltura)`

  Comprueba si la posición `y` del gnomo supera un límite especificado (`limiteAltura`), indicando que debe desaparecer. Retorna `true` si ha excedido el límite.

- ### `void desaparecer()`

  Oculta el gnomo estableciendo `estaVisible` en `false` y registra el tiempo de desaparición en `tiempoDesaparicion`.

- ### `void verificarReaparicion()`

  Verifica si han pasado 2 segundos desde la desaparición del gnomo. Si es así, lo vuelve visible y lo reposiciona en las coordenadas iniciales (`x = 400`, `y = 50`).

- ### `boolean estaVisible()`
  
  Retorna `true` si el gnomo es visible, `false` si no lo es.

## Implementación de la clase en `Juego`

### Inicialización de los Gnomos
En el constructor de `Juego`, inicializamos una lista de gnomos que se instancian de manera aleatoria para crear entre 2 y 4 gnomos en cada inicio del juego.
