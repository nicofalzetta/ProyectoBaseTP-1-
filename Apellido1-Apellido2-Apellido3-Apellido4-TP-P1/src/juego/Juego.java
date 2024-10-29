package juego;

import java.awt.Color;
import java.awt.Image;
import entorno.Entorno;
import java.util.List;
import java.util.ArrayList;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	
	// Variables y métodos propios de cada grupo
	private Imagen[] islas;
	private Barra[] barras;
	private Gnomo[] gnomos;
	private Texto[] textos;
    private bolaDeFuego[] BolasDeFuego;
    private int numeroBolas; // Contador de bolas de fuego activas
    private final int MAX_BOLAS = 10; // Número máximo de bolas de fuego
	
	private Imagen casa;
	private Imagen paisaje;
	private Pep pep;
	
	private int contadorGnomosPerdidos = 0;
	private int contadorGnomosSalvados = 0;
	private int contadorGnomosEliminados = 0;
	
	private ArrayList<Tortuga> tortugas;
	private ArrayList<bolaDeFuego> bolasDeFuego = new ArrayList<>();
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Al Rescate de los Gnomos", 800, 600);
		// Inicializar lo que haga falta para el juego
		Image ImagenIsla = Herramientas.cargarImagen("imagenes/isla.png");
		Image casa = Herramientas.cargarImagen("Imagenes/casa.png");
		Image paisaje = Herramientas.cargarImagen("Imagenes/paisaje.jpg");
		Image Gnomo = Herramientas.cargarImagen("imagenes/gnomo.png");
		Image Pep = Herramientas.cargarImagen("Imagenes/Pep.png");
		Image Tortuga = Herramientas.cargarImagen("imagenes/tortuga.png");
		
		
		
		//Paisaje de Fondo:
		
		this.paisaje = new Imagen(paisaje,350,350,0,0.22, 0);
		
		//texto en pantalla:
		
		this.textos = new Texto[14];
		
		//Contador de tiempo:
		
		this.textos[0] = new Texto("Tiempo:",100,20); 
		this.textos[1] = new Texto("0",157,20);       
		this.textos[2] = new Texto(":",165,20);       
		this.textos[3] = new Texto("0",170,20);       
		this.textos[4] = new Texto("0",180,20);       
        //Gnomos Perdididos:
		this.textos[5] = new Texto("Perdidos:",300,20); 
		this.textos[6] = new Texto("0",365,20);       
		//Gnomos Salvados:
		this.textos[7] = new Texto("Rescatados:",480,20); 
		this.textos[8] = new Texto("0",565,20);
		//Gnomos Eliminados:
		this.textos[9] = new Texto("Eliminados:",680,20); 
		this.textos[10] = new Texto("0",760,20);
		//Final del Juego:
		this.textos[11] = new Texto("FELICIDADES A GANADO",100,320);
		this.textos[12] = new Texto("GAME OVER",150,310);
		
		//Casa sobre las islas:
		
		this.casa = new Imagen(casa,400,30,0,0.015,0.0);
        
		//Barras debajo de las Islas.
		
		this.barras = new Barra[21];  //Array Barras

		//Primera Fila:
		this.barras[0] = new Barra(400,70,110,24, 0);
		//Segunda Fila:
		this.barras[1] = new Barra(300,120,100,26, 0);
		this.barras[2] = new Barra(500,120,100,26, 0);
		//Tercera Fila:
		this.barras[3]  = new Barra(250,210,90,20, 0);
		this.barras[4] = new Barra(400,210,90,20, 0);
		this.barras[5] = new Barra(550,210,90,20, 0);
		//Cuarta Fila:
		this.barras[6] = new Barra(170,330,90,21, 0);
		this.barras[7] = new Barra(320,330,90,21, 0);
		this.barras[8] = new Barra(510,330,90,21, 0);
		this.barras[9] = new Barra(670,330,90,21, 0);		
		//Quinta Fila:
		this.barras[10] = new Barra(100,430,90,21, 0);
		this.barras[11] = new Barra(250,430,90,21, 0);
		this.barras[12] = new Barra(400,430,90,21, 0);
		this.barras[13] = new Barra(550,430,90,21, 0);
		this.barras[14] = new Barra(700,430,90,21, 0);
		//Sexta Fila:
		this.barras[15] = new Barra(40,530,90,21, 0);
		this.barras[16] = new Barra(180,530,90,21, 0);
		this.barras[17] = new Barra(320,530,90,21, 0);
		this.barras[18] = new Barra(460,530,90,21, 0);
		this.barras[19] = new Barra(600,530,90,21, 0);
		this.barras[20] = new Barra(740,530,90,21, 0);

		//Islas:
		this.islas = new Imagen[21];    //Array Islas.
		//Primera Fila:
		this.islas[0] = new Imagen(ImagenIsla,400,70,0,0.18, 0.0);
		//Segunda Fila:
		this.islas[1] = new Imagen(ImagenIsla,300,120,0,0.16, 0.0);
		this.islas[2] = new Imagen(ImagenIsla,500,120,0,0.16, 0.0);
		//Tercera Fila:
		this.islas[3] = new Imagen(ImagenIsla,250,210,0,0.16, 0);
		this.islas[4] = new Imagen(ImagenIsla,400,210,0,0.16, 0);
		this.islas[5] = new Imagen(ImagenIsla,550,210,0,0.16, 0);
		//Cuarta Fila:
		this.islas[6] = new Imagen(ImagenIsla,170,330,0,0.14, 0);
		this.islas[7] = new Imagen(ImagenIsla,320,330,0,0.14, 0);
		this.islas[8] = new Imagen(ImagenIsla,510,330,0,0.14, 0);
		this.islas[9] = new Imagen(ImagenIsla,670,330,0,0.14, 0);
		//Quinta Fila:
		this.islas[10] = new Imagen(ImagenIsla,100,430,0,0.14, 0);
		this.islas[11] = new Imagen(ImagenIsla,250,430,0,0.14, 0);
		this.islas[12] = new Imagen(ImagenIsla,400,430,0,0.14, 0);
		this.islas[13] = new Imagen(ImagenIsla,550,430,0,0.14, 0);
		this.islas[14] = new Imagen(ImagenIsla,700,430,0,0.14, 0);
		//Sexta Fila:
		this.islas[15] = new Imagen(ImagenIsla,40,530,0,0.14, 0);
		this.islas[16] = new Imagen(ImagenIsla,180,530,0,0.14, 0);
		this.islas[17] = new Imagen(ImagenIsla,320,530,0,0.14, 0);
		this.islas[18] = new Imagen(ImagenIsla,460,530,0,0.14, 0);
		this.islas[19] = new Imagen(ImagenIsla,600,530,0,0.14, 0);
		this.islas[20] = new Imagen(ImagenIsla,740,530,0,0.14, 0);
		
		
		// Inicialización de gnomos
		this.gnomos = new Gnomo[4]; // Define el tamaño del array
		int numeroDeGnomos = (int) (Math.random() * 3) + 2; 
		this.gnomos = new Gnomo[numeroDeGnomos];
		        
		for (int i = 0; i < numeroDeGnomos; i++) {
		  double y = 50; 
		  double escala = 0.03;
		  double radio = 5;
		  gnomos[i] = new Gnomo(Gnomo, y, escala,radio); // Inicializar cada gnomo
	}
		
		//Inicializacion de la Tortuga
		this.tortugas = new ArrayList<>();
		int numeroDeTortugas = (int) (Math.random() * 3) + 3;
		for(int i = 0; i < numeroDeTortugas; i++) {
			Tortuga tortuga = new Tortuga(Tortuga,0,0.1,5);
			this.tortugas.add(tortuga);		
	    }
		//Inicio Pep
		this.pep = new Pep(Pep,50,500,0,0.12,5);
		
		//Inicio BolaDeFuego
		BolasDeFuego = new bolaDeFuego[MAX_BOLAS];
        numeroBolas = 0;
		

      // Inicia el juego!
		this.entorno.iniciar();
	   }
	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick()
	{
		//Imagen de Fondo:
	    this.paisaje.dibujar(this.entorno);
	    //Dibuja la Casa de los Gnomos:
	  	this.casa.dibujar(this.entorno);
	 	//Barras debajo de las islas:
		for(int i = 0; i < this.barras.length; i++) {
		    Barra b = this.barras[i];
			if(b != null) { // Reviso que la referencia al objeto no sea NULL
				b.dibujar(this.entorno);	
			}
		 }
		//Islas:
		for(int i = 0; i < this.islas.length; i++) {
		    Imagen p = this.islas[i];
			if(p != null)            // Reviso que la referencia al objeto no sea NULL
			{ 
				p.dibujar(this.entorno);
			}
		}	
			
		
		// Eliminar gnomos nulos si es necesario
	 	Image imagenGnomo = Herramientas.cargarImagen("imagenes/gnomo.png");
	    for (int i = 0; i < gnomos.length; i++) {
	        if (gnomos[i] == null) {   
	            double x = 400; 
	            double y = 50;
	            double escala = 0.04;
	            double radio = 1;
	            gnomos[i] = new Gnomo(imagenGnomo, y, escala,radio); 
	        }
	    }
		//Contadores en Pantalla:
		//Tiempo del juego:

		int Seg = (entorno.tiempo())/1000; // Toma el tiempo en milisegundos desde que inicial el juego y los convierte en segundos.
		int Min = 0; 
		textos[0].dibujarTexto(this.entorno); //this.textos[0] = new Texto("Tiempo:",100,20); // "Tiempo."
		textos[2].dibujarTexto(this.entorno); //this.textos[2] = new Texto(":",160,20);       // ":"
		textos[1].dibujarTexto(this.entorno);
		for (int i = 0; i < 10; i++) 
		{
		  if(Seg < 10)
		  {   this.textos[4] = new Texto("0",180,20);
			  textos[3].actualizarNumero(0);   // Actualiza el texto con el contador. this.textos[3] = new Texto("0",165,20);       // "0"
			  textos[3].dibujarTexto(entorno);      // Dibuja el contador.
		  }
		  if (Seg==10) {
		  this.textos[4] = new Texto("0",170,20);
		  }
		  if (Seg < 60) 
		  {
		    textos[4].actualizarNumero(Seg);   // Actualiza el texto con el contador.   
		    textos[4].dibujarTexto(entorno);   // Dibuja el contador.
		  }Min +=1;
		  if (Seg >= 60)     
		  {
			Seg -= 60;
			textos[1].actualizarNumero(Min);   // Actualiza el texto con el contador.   
			textos[1].dibujarTexto(entorno); // Dibuja el contador.
		  }
		}
		
		//Colision entre gnomos
		for (int i = 0; i < gnomos.length; i++) {
			Gnomo gnomo = gnomos[i];
			
			// Asegurarse de que el gnomo no sea null
			if (gnomo != null) {
				for (int j = i + 1; j < gnomos.length; j++) {
					Gnomo otroGnomo = gnomos[j];
					
					// Asegurarse de que el otro gnomo no sea null
					if (otroGnomo != null && gnomo.colisionConGnomo(otroGnomo)) {
						// Invertir la dirección de ambos gnomos
						gnomo.invertirDireccion();
						otroGnomo.invertirDireccion();
					}
				}
			 }
		  }
		//Gnomos Perdidos:
				for (int i = 0; i < gnomos.length; i++) {
				    Gnomo gnomo = gnomos[i];

				    // Verifica que el gnomo no sea null
				    if (gnomo != null) {
				        // Verifica si el gnomo ha desaparecido (ha caído)
				        if (gnomo.desaparece(550)) {
				            // Incrementa el contador de gnomos perdidos
				            contadorGnomosPerdidos++;
				            gnomos[i] = null; // Marca el gnomo como null al desaparecer
				        } else {
				            // Verifica la reaparición del gnomo
				            gnomo.verificarReaparicion(); 

				            // Solo dibuja el gnomo si es visible
				            if (gnomo.estaVisible()) {
				                gnomo.dibujar(this.entorno); // Dibuja el gnomo en pantalla
				                gnomo.mover(this.barras); // Mueve el gnomo
				            }
				        }
				    }
				}
				

				//Actualiza y dibuja el texto de gnomos perdidos
				textos[6].actualizarNumeroPerdidos(contadorGnomosPerdidos);
				textos[5].dibujarTexto(this.entorno);  
				textos[6].dibujarTexto(this.entorno); 

				    
			    //Gnomos salvados:     
			    textos[7].dibujarTexto(this.entorno); 
			    textos[8].dibujarTexto(entorno);       

			    for (int i = 0; i < gnomos.length; i++) {
			        Gnomo gnomo = gnomos[i];
			            
			        // Verifica que el gnomo no sea null y que haya colisión con `pep`
			         if (gnomo != null && pep.colisionPepGnomos(pep, gnomo)) {
			            contadorGnomosSalvados++; // Incrementa el contador solo si hubo colisión
			            gnomos[i] = null; // Marca el gnomo como null para evitar contarlo de nuevo
			         }
			     }

			     // Actualiza el texto del contador de gnomos salvados fuera del bucle
			     textos[8].actualizarNumerodeSalvados(contadorGnomosSalvados);
			 
			     // Gnomos Eliminados:     
			     textos[9].dibujarTexto(this.entorno);      // Dibuja el texto de "Gnomos Eliminados" en pantalla. 
			     textos[10].dibujarTexto(entorno);          // Dibuja el contador actualizado.
			     
			     // Movimiento y dibujo de las tortugas
			     for (Tortuga tortuga : tortugas) {
				 tortuga.dibujar(this.entorno);	 
				 tortuga.mover(this.barras);    
				 for (int i = 0; i < gnomos.length; i++) {    
					 Gnomo gnomo = gnomos[i];  
					 // Verifica que el gnomo no sea null antes de chequear la colisión			       
					 if (gnomo != null && tortuga.colisionTortugaGnomo(tortuga, gnomo)) { 
			           	 contadorGnomosEliminados++; // Incrementa el contador al eliminar un gnomo
			             gnomos[i] = null; // Elimina el gnomo estableciendo su posición como null
			         }
			         if (pep.colisionPepTortugas(pep, tortuga)){
			        	 for (Tortuga tortuga1 : tortugas) {
			        	 tortuga1.velocidadCeroTortuga();
			        	 }
			             gnomo.velocidadCeroGnomo();
			        	 pep.velocidadCeroPep();
			        	 textos[12].dibujarTextoPerder(this.entorno);
			        	 entorno.removeAll();        	 
			         }
			        	               
			         }        
			     }                                 
			     textos[10].actualizarNumero(contadorGnomosEliminados);  // Actualiza el texto del contador  

			//Movimiento, dibujo de Pep y final del juego.
	        Pep p = this.pep;
	        if (p != null)   // Reviso que la referencia al objeto no sea NULL
	        { 
	        	p.dibujar(this.entorno);
	            pep.moverP(this.barras, entorno);                
	            if (p.getY() > 600) 
	            {
	               this.pep = null;             
	               textos[12].dibujarTextoPerder(this.entorno);
		           entorno.removeAll();
	            }
	            if(contadorGnomosSalvados == 10) {
	            	textos[11].dibujarTextoGanar(this.entorno);
			        entorno.removeAll();
	            }
	            if(contadorGnomosPerdidos == 10  || contadorGnomosEliminados == 10 ) {
	            	textos[12].dibujarTextoGanar(this.entorno);
			        entorno.removeAll();
	            }
	            
	 
	        }
	        // Manejar disparos
	        Image bolaDeFuego1 = Herramientas.cargarImagen("Imagenes/bolaDeFuego.png");
	        // Crear y lanzar bolas de fuego según la dirección
	        if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA) && (entorno.sePresiono('c') || entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO))) {
	            bolaDeFuego nuevaBola = new bolaDeFuego(Herramientas.cargarImagen("Imagenes/bolaDeFuego.png"), pep.getX(), pep.getY(), 0.1, 0, 1, 5);
	            nuevaBola.iniciar(-10); // Mover a la izquierda
	            bolasDeFuego.add(nuevaBola);
	        } else if (entorno.estaPresionada(entorno.TECLA_DERECHA) && (entorno.sePresiono('c') || entorno.sePresionoBoton(entorno.BOTON_IZQUIERDO))) {
	            bolaDeFuego nuevaBola = new bolaDeFuego(Herramientas.cargarImagen("Imagenes/bolaDeFuego.png"), pep.getX(), pep.getY(), 0.1, 0, 1, 5);
	            nuevaBola.iniciar(10); // Mover a la derecha
	            bolasDeFuego.add(nuevaBola);
	        }

	        // Dibujar, mover, y manejar colisiones de bolas de fuego
	        for (int i = 0; i < bolasDeFuego.size(); i++) {
	            bolaDeFuego bola = bolasDeFuego.get(i);
	            bola.dibujar(entorno);
	            bola.mover();

	            // Verificar colisiones con cada tortuga
	            for (Tortuga tortuga : tortugas) {
	                if (bola.colisionBoladeFuegoTortuga(bola, tortuga)) {
	                    // Reubicar la tortuga de forma aleatoria
	                    tortuga.setX(50 + Math.random() * 600); // Ajusta el rango según el ancho del entorno
	                    tortuga.setY(50 + Math.random() * 400); // Ajusta el rango según la altura del entorno

	                    // Eliminar la bola de fuego tras la colisión
	                    bolasDeFuego.remove(i);
	                    i--; // Ajustar el índice tras la eliminación
	                    break; // Salir del bucle de tortugas
	                }
	            }

	            // Eliminar bolas que salieron de la pantalla
	            if (bola.getX() > 800 || bola.getX() < 0) { // Ajustar límites según el entorno
	                bolasDeFuego.remove(i);
	                i--; // Ajustar índice tras eliminación
	            }
	        }
	    }	
	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}

