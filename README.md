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

# `Tortuga`

La clase `Tortuga` representa un personaje en el juego que tiene capacidades de movimiento, visibilidad controlada y detección de colisiones. 

## Atributos

- **`imagen`**: La imagen que representa visualmente la tortuga.
- **`x`, `y`**: Coordenadas de posición de la tortuga en el entorno.
- **`velocidad`**: La velocidad a la que la tortuga se mueve en el eje x.
- **`escala`**: Escala de tamaño de la tortuga en relación con su imagen original.
- **`direccion`**: Indica la dirección del movimiento: 1 para derecha y -1 para izquierda.
- **`VELOCIDADES`**: Array que contiene velocidades posibles para cada tortuga.
- **`RANDOM`**: Genera números aleatorios para asignar una velocidad aleatoria y una posicion incial, en x, a cada tortuga.

## Constructor

### `public Tortuga(Image imagen, double x, double y, double escala, double radio)`

Inicializa una tortuga con su imagen, posición (`y`), escala y una velocidad y una posición ‘x’ aleatoria tomada de sus arrays correspondientes. La dirección inicial se establece aleatoriamente como izquierda o derecha.

## Métodos de Movimiento y Colisión

- ### `boolean estaSobreBarra(Barra[] barras)`
  
  Comprueba si la tortuga está sobre alguna de las barras en el array `barras`. Retorna `true` si está sobre una barra, `false` en caso contrario.

- ### `boolean colisionaConBarra(Barra barra)`
  
  Verifica si la tortuga está en contacto con una barra específica, lo que se usa para invertir la dirección si colisiona. Retorna `true` en caso de colisión.

- ### `void caer(Barra[] barras)`

  Realiza el movimiento de caída de la tortuga incrementando su posición `y`. Si colisiona con una barra mientras cae, invierte la dirección en `x`.

- ### `void mover(Barra[] barras)`

  Controla el movimiento general de la tortuga. Si no está sobre una barra, la tortuga cae; si está sobre una barra, se mueve horizontalmente en la dirección establecida, y se asegura de no salir de los límites de la barra. Para ello se utiliza un booleano que llamado ‘sobreBarra’ inicializado en ‘false’, de esta manera la tortuga cae hasta colacionar con una barra. Posteriormente se condiciona el movimiento solo dentro de la barra colacionada

## Implementación de la clase en `Juego`

### Inicialización de las Tortugas
En el constructor de `Juego`, inicializamos una lista de gnomos que se instancian de manera aleatoria para crear tortugas en cada inicio del juego.
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

### Inicialización de Barra
 En el constructor de `Juego`, inicializamos un arreglo con la cantidad de textos para mostrar en pantalla. 
Texto en pantalla: this.textos = new Texto[11]; y luego a cada arreglo le pasamos los variables de instancia
con los valores pedidos por el constructor del objeto. this.textos[numero de array] = new Texto("texto",x,y);
 Luego en el metodo tick creamos la logica para que se muestren en pantalla las barras debajo de las islas que
 serian la parte fisica donde se sostendrian todos los objetos que interactuan en el juego
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# `Imagen`

La clase `Imagen` representa el objeto imagen que aparece en la pantalla del juego. El mismo esta instanciado para ser usado tanto en casa como en paisaje.

## Atributos
- **`Texto`**: El texto que se muestra en pantalla.
- **`x`, `y`**: Coordenadas de posición del texto en el entorno.
- **`velocidad`**: Define la velocidad de movimiento del gnomo.
- **`escala`**: Factor de escala que ajusta el tamaño de la imagen.
- **`angulo`**: Factor de angulo que ajusta el angulo de la imagen.

## Constructor

public Imagen(Image imagen, double x, double y, double angulo, double escala,double velocidad)

 Construye el objeto Imagen con los valores de instancia que recibe desde la clase juego cuando se lo inicializa desde ella. 

## Métodos de visivilidad y actualizacion del texto.

- ### `public void dibujar(Entorno entorno) `
  Nos muestra en pantalla la casa inicializada en la clase juego.

## Implementación de la clase en `Juego`

### Inicialización de Texto
En el constructor de `Juego`, inicializamos el objeto imagen creando las variables casa, paisaje y ademas un array de la imagen isla. En cada caso les damos los parametros necesarios para que cumplan con el constructor previamente creado y luego en el metodo tick los mostramos por pantalla.		
--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
# `Pep`

La clase `Pep` representa el objeto Pep, que es el caballero encargado de rescatar a los gnomos. Aparece en la pantalla del juego, es el encargado de rescatar los gnomos antes que caigan al vacio, o sean eliminados por tortugas, tiene la habilidad de tirar bolas de fuego que permiten eliminar a las tortugas.

## Atributos
- **`imagen`**: La imagen que representa visualmente a Pep.
- **`x`, `y`**: Coordenadas de posición de inicio de Pep en el entorno.
- **`Angulo`**: Angulo con el que ve en pantalla la imagen. 
- **`escala`**: Escala de tamaño de Pep en relación con su imagen original.
- **`velocidad`**: Velocidad a la que se mueve Pep en el entorno.
- **`direccion`**: Direccion en la que seran disparadas las bolas de fuego.
- **`radio`**: Radio del objeto para permitir la colision con los otros.

## Constructor

public Pep(Image imagen,double x, double y, double angulo, double escala, double radio)

 Construye el objeto Pep con los valores de instancia que recibe desde la clase juego cuando se lo inicializa desde ella. 

## Métodos

### `estaPresionada(char key)`

Determina si se esta presionando la tecla de movimiento.
**Retorno**: `boolean` - `true` nos devuelve si se esta presionando la tecla y Pep se debe mover.

### `sePresiono(char key)`

Determina si se presiono la tecla de disparo.
**Retorno**: `boolean` - `true` nos devuelve si se presiono la tecla y Pep debe lanzar la bola de fuego.

### `moverP Barra[] barras, Entorno entorno`

Nos indica la tecla que se esta presionando y para donde debe moverse Pep, al mismo tiempo le da la velocidad al movimiento.

### `colisionaConBarra (Barra barra)`

**Retorno**: `boolean` - `true` nos devuelve si Pep esta colisionando con alguna barra.

### `caer (Barra[] barras)`

Simula el efecto de caída de Pep, se aumenta su coordenada `y` . Si colisiona con una barra mientras cae, invierte su dirección horizontal.

### `public void dibujar(Entorno entorno) `

Nos muestra en pantalla a Pep inicializado en la clase juego.

### `rebotar ()`

Devuelve la velocidad y cambia la direccion para generar el rebote.


### `estaSobreBarra(Barra[] barras)`

Verifica si el gnomo está encima de alguna de las barras, a partir en su posición `y` y `x` en relación con las dimensiones de las barras.  
**Retorno**: `boolean` - `true` si el gnomo está sobre una barra.

### `colisionaConBarra(Barra barra)`

Determina si Pep colisiona con una barra específica cuando se compara sus posiciones.  
**Retorno**: `boolean` - `true` si hay colisión con la barra.
**Retorno**: `boolean` - `false` si no colisiona con ninguna barra.

### `colisionPepGnomos(Pep p Gnomo gnomo)`

Verifica si ocurre una colision con un gnomo, calculando la posicion y la distancia entre Pep y el Gnomo con sus radios, si la distancia es menor entonces ocurre la colision.

### `colisionPepTortugas(Pep p Tortuga T)`

Verifica si ocurre una colision con una tortuga, calculando la posicion y la distancia entre Pep y la tortuga con sus radios, si la distancia es menor entonces ocurre la colision.


### `velocidadCeroPep()`

setea la velocidad de Pep en 0.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Implementación de la clase en `Juego`

### Inicialización de Pep
En el constructor de `Juego`, inicializamos el objeto Pep y le damos los parametros necesarios que cumplan con el constructor previamente creado. 	

---

# `bolaDeFuego`

La clase `bolaDeFuego` representa el objeto de la bola de fuego, este es el proyectil que arroja el caballero `Pep` y se encarga de eliminar a las tortugas.

## Atributos
- **`imagen`**: La imagen que representa visualmente a la bola de fuego.
- **`x`, `y`**: Coordenadas de posición de inicio de bola de fuego en el entorno.
- **`escala`**: Escala de tamaño de la bola de fuego en relación con su imagen original.
- **`velocidad`**: Velocidad a la que se mueve la bola de fuego en el entorno.
-  **`Angulo`**: Angulo con el que se la ve en pantalla a la imagen. 
- **`radio`**: Radio del objeto para permitir la colision con los otros.

## Constructor

public bolaDeFuego(Image imagen,double x, double y, double escala, double angulo, double velocidad, double radio)

 Construye el objeto bolaDeFuego con los valores de instancia que recibe desde la clase juego cuando se lo inicializa desde ella. 

## Métodos
### `mover()`

Nos devuelve para el lado que se va a mover la bola de fuego y le agrega la velocidad.

### `sePresiono (char key)`

Indica si fue presionada la tecla y nos retorna true.

### `seLevanto (char key)`

Indica si fue soltada la tecla y nos retorna true.

### `iniciar (int velocidad)`

Sirve para iniciar el movimiento de la bola de fuego, le da velocidad.

### `public void dibujar(Entorno entorno) `

Nos muestra en pantalla a la bola de fuego inicializada en la clase juego.

### Boolean `lanzarB(Entorno entorno) `

Nos devuelve `true` segun la tecla que se haya levantado y si luego se apreto la tecla de disparo, dispara la bola de fuego para el lado que corresponde.

### `colisionBoladeFuegoTortuga(bolaDeFuego f Tortuga T)`

Verifica si ocurre una colision con una tortuga, calculando la posicion y la distancia entre la bola de fuego y la tortuga con sus radios, si la distancia es menor entonces ocurre la colision.

## Implementación de la clase en `Juego`

### Inicialización de bolaDeFuego
En el constructor de `Juego`, inicializamos el objeto bolaDeFuego y generamos la aparicion si se dan las condiciones solicitadas en los metodos instanciados en la clase.

---  
