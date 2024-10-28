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

# `Casa`

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

		
  
  
