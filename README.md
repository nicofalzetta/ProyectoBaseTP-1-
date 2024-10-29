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

La clase `Gnomo` representa un personaje en el juego, diseñado para moverse, colisionar con barras, interactuar con otros gnomos, y desaparecer o reaparecer según ciertas condiciones. A continuación se detallan todos los métodos y atributos de esta clase, sus funcionalidades y su lógica de implementación.



## Atributos

- **`imagen`**: La imagen que representa visualmente al gnomo en pantalla.
- **`x`**: La coordenada X del gnomo en el entorno de juego.
- **`y`**: La coordenada Y del gnomo en el entorno de juego.
- **`velocidad`**: Define la velocidad de movimiento del gnomo.
- **`escala`**: Factor de escala que ajusta el tamaño de la imagen.
- **`radio`**: Radio de colisión que permite detectar interacciones con otros objetos.
- **`direccion`**: Determina la dirección de movimiento, donde 1 es hacia la derecha y -1 es hacia la izquierda.
- **`estaVisible`**: Indica si el gnomo está visible en el entorno de juego.
- **`tiempoDesaparicion`**: Almacena el tiempo de la última desaparición.
- **`tiempoUltimaColision`**: Almacena el tiempo de la última colisión con otro gnomo.
- **`POSICIONESX`**: Array de posiciones iniciales en X para generar variedad en la posición de aparición de los gnomos.
- **`VELOCIDADES`**: Array de velocidades iniciales que se asignan aleatoriamente a los gnomos.
- **`TIEMPO_COOLDOWN`**: Tiempo de espera en milisegundos entre colisiones.
- **`RANDOM`**: Generador de números aleatorios para establecer posiciones y velocidades aleatorias.

---

## Constructor

### `Gnomo(Image imagen, double y, double escala, double radio)`

Inicializa un gnomo con los valores dados, asignándole una posición en X y una velocidad de forma aleatoria. También configura su visibilidad como `true` y establece una dirección inicial aleatoria.

---

## Métodos

### `desaparece(double limiteAltura)`

Determina si el gnomo cayó más allá de un límite de altura (`limiteAltura`). Si `y` es mayor que `limiteAltura`, el gnomo debe desaparecer.  
**Retorno**: `boolean` - `true` si el gnomo cayó y debe desaparecer.

### `desaparecer()`

Marca el tiempo actual como el momento de desaparición del gnomo.

### `necesitaReaparicion()`

Evalúa si el gnomo estuvo desaparecido por más de 2 segundos y, por lo tanto, necesita reaparecer.  
**Retorno**: `boolean` - `true` si el gnomo debe reaparecer.

### `reaparecer(double y)`

Restaura la posición `y` del gnomo para que reaparezca en el entorno y restablece el temporizador de desaparición.

### `estaVisible()`

Devuelve el estado de visibilidad del gnomo.  
**Retorno**: `boolean` - `true` si el gnomo está visible.

### `estaSobreBarra(Barra[] barras)`

Verifica si el gnomo está encima de alguna de las barras, a partir en su posición `y` y `x` en relación con las dimensiones de las barras.  
**Retorno**: `boolean` - `true` si el gnomo está sobre una barra.

### `colisionaConBarra(Barra barra)`

Determina si el gnomo colisiona con una barra específica cuando se compara sus posiciones.  
**Retorno**: `boolean` - `true` si hay colisión con la barra.

### `caer(Barra[] barras)`

Simula el efecto de caída del gnomo, se aumenta su coordenada `y` . Si colisiona con una barra mientras cae, invierte su dirección horizontal.

### `verificarReaparicion()`

Si el gnomo no está visible, lo reaparece en una posición inicial específica `(x=400, y=50)`.

### `mover(Barra[] barras)`

Mueve el gnomo en la dirección indicada, pero si no está sobre una barra, simula una caída. Verifica que el gnomo no salga del área de juego, invirtiendo la dirección al llegar a los límites.

### `colisionConGnomo(Gnomo otroGnomo)`

Verifica si ocurre una colisión con otro gnomo basándose en sus posiciones y radios de colisión. También incluye un "cooldown" para evitar múltiples colisiones en un corto período de tiempo.  
**Retorno**: `boolean` - `true` si colisiona con otro gnomo y se cumple el tiempo de cooldown.

### `invertirDireccion()`

Invierte la dirección horizontal del gnomo, útil para responder a colisiones.

---

## Implementación de la clase en `Juego`

### Inicialización de los Gnomos
En el constructor de `Juego`, inicializamos una lista de gnomos que se instancian de manera aleatoria para crear entre 2 y 4 gnomos en cada inicio del juego.
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# `Texto`

La clase `Texto` representa el texto en pantalla en el juego, el cual nos muestra en tiempo real el tiempo real de juego, un contador con los gnomos salvados por pep, un contador con los gnomos perdidos al caer de la ultima isla y un contador de gnomos eliminados por las tortugas.

## Atributos
- **`Texto`**: El texto que se muestra en pantalla.
- **`x`, `y`**: Coordenadas de posición del texto en el entorno.
## Constructor

### `public Texto(String texto,double x, double y)`

Inicializa el texto en pantalla en la posición (`x` y `y`).

## Métodos de visivilidad y actualizacion del texto.

- ### `public void dibujarTexto(Entorno entorno)`
  Nos muestra en pantalla el texto solicitado en la clase juego, pudiendo definir desde este metodo la fuente, el tamaño y el color de la letra.

- ### `public void actualizarNumerodeTiempo(int numero)`
  Actualiza constantemente el texto en pantalla que controla el tiempo con el nuevo valor numerico pasado como un parametro en la clase juego .

- ### `public void actualizarNumeroPerdidos(int numero) `
  Actualiza constantemente el texto en pantalla que controla el valor de los gnomos perdidos, con el nuevo valor numerico pasado como un parametro en la clase juego.

- ### `public void actualizarNumerodeEliminados(int numero)`
 Actualiza constantemente el texto en pantalla que controla el valor de los gnomos eliminados por las tortugas, con el nuevo valor numerico pasado como un parametro en la clase juego.

- ### `public void actualizarNumerodeSalvados(int numero)`
 Actualiza constantemente el texto en pantalla que controla el valor de los gnomos salvados por pep, con el nuevo valor numerico pasado como un parametro en la clase juego.

## Implementación de la clase en `Juego`

### Inicialización de Texto
En el constructor de `Juego`, inicializamos un arreglo con la cantidad de textos para mostrar en pantalla. 
Texto en pantalla: this.textos = new Texto[11]; y luego a cada arreglo le pasamos los variables de instancia
con los valores pedidos por el constructor del objeto. this.textos[numero de array] = new Texto("texto",x,y);
-----------------------------------------------------------------------------------------------------------------------------------------
# `Isla`

La clase `Isla` representa las islas que estan flotando en el juego, donde interactuan las tortugas, pep y los gnomos del entorno del juego.

## Atributos
- **`imagen`**: La imagen que representa visualmente a la isla.
- **`x`, `y`**: Coordenadas de posición de la isla en el entorno.
- **`Angulo`**: Angulo con el que ve en pantalla la imagen. 
- **`escala`**: Escala de tamaño de la isla en relación con su imagen original.
## Constructor

### `public Isla(Image imagen, double x, double y, double angulo, double escala, double velocidad)`

Inicializa el imagen en pantalla en la posición (`x` y `y`), con un angulo y una escala. el valor de estas variables son pasadas como parametros en la clase juego por medio de un Array.

## Métodos de visivilidad y actualizacion del texto.

- ### `public void dibujar(Entorno entorno)`
  Nos muestra en pantalla la imagen de lista, los parametros desde la clase juego.


## Implementación de la clase en `Juego`

### Inicialización de Texto
En el constructor de `Juego`, inicializamos un arreglo con la cantidad de islas para mostrar en pantalla. Previamente se guarda en una variable de tipo image la imagen a mostrar y por medio de un array se crean la cantidad de islas necesarias. 
Imagen en pantalla: this.isla = new Isla[cant de arreglos]; y luego a cada arreglo le pasamos las variables de instancia
con los valores pedidos por el constructor del objeto. this.isla[numero de array] = new Isla(imagen,x,y,escala,angulo);
-----------------------------------------------------------------------------------------------------------------------------------------
# `Barra`

La clase `Texto` representa el texto en pantalla en el juego, el cual nos muestra en tiempo real el tiempo real de juego, un contador con los gnomos salvados por pep, un contador con los gnomos perdidos al caer de la ultima isla y un contador de gnomos eliminados por las tortugas.

## Atributos
- **`Texto`**: El texto que se muestra en pantalla.
- **`x`, `y`**: Coordenadas de posición del texto en el entorno.
## Constructor

### `public Texto(String texto,double x, double y)`

Inicializa el texto en pantalla en la posición (`x` y `y`).

## Métodos de visivilidad y actualizacion del texto.

- ### `public void dibujarTexto(Entorno entorno)`
  Nos muestra en pantalla el texto solicitado en la clase juego, pudiendo definir desde este metodo la fuente, el tamaño y el color de la letra.

- ### `public void actualizarNumerodeTiempo(int numero)`
  Actualiza constantemente el texto en pantalla que controla el tiempo con el nuevo valor numerico pasado como un parametro en la clase juego .

- ### `public void actualizarNumeroPerdidos(int numero) `
  Actualiza constantemente el texto en pantalla que controla el valor de los gnomos perdidos, con el nuevo valor numerico pasado como un parametro en la clase juego.

- ### `public void actualizarNumerodeEliminados(int numero)`
 Actualiza constantemente el texto en pantalla que controla el valor de los gnomos eliminados por las tortugas, con el nuevo valor numerico pasado como un parametro en la clase juego.

- ### `public void actualizarNumerodeSalvados(int numero)`
 Actualiza constantemente el texto en pantalla que controla el valor de los gnomos salvados por pep, con el nuevo valor numerico pasado como un parametro en la clase juego.

## Implementación de la clase en `Juego`

### Inicialización de Texto
En el constructor de `Juego`, inicializamos un arreglo con la cantidad de textos para mostrar en pantalla. 
Texto en pantalla: this.textos = new Texto[11]; y luego a cada arreglo le pasamos los variables de instancia
con los valores pedidos por el constructor del objeto. this.textos[numero de array] = new Texto("texto",x,y);
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# `Casa`

La clase `Casa` representa el objeto casa que aparece en la pantalla del juego, de ella salen los gnomos que van cayendo hacia las islas quie estan por debajo.

## Atributos
- **`Texto`**: El texto que se muestra en pantalla.
- **`x`, `y`**: Coordenadas de posición del texto en el entorno.
- **`velocidad`**: Define la velocidad de movimiento del gnomo.
- **`escala`**: Factor de escala que ajusta el tamaño de la imagen.
- **`angulo`**: Factor de angulo que ajusta el angulo de la imagen.

## Constructor

public Casa(Image imagen, double x, double y, double angulo, double escala,double velocidad)

 Construye el objeto casa con los valores de instancia que recibe desde la clase juego cuando se lo inicializa desde ella. 

## Métodos de visivilidad y actualizacion del texto.

- ### `public void dibujar(Entorno entorno) `
  Nos muestra en pantalla la casa inicializada en la clase juego.

## Implementación de la clase en `Juego`

### Inicialización de Texto
En el constructor de `Juego`, inicializamos el objeto casa y le damos los parametros necesarios que cumplan con el constructor previamente creado. 		
  
  
