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
	private Isla[] islas;
	private Barra[] barras;
	private Casa casa;
	private Paisaje paisaje;
	private Pep pep;
	private List<Gnomo> gnomos;
	private Texto[] textos;
	// ...
	
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
		
		//texto en pantalla:
		this.textos = new Texto[11];
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
		this.textos[7] = new Texto("Salvados:",500,20); 
		this.textos[8] = new Texto("0",565,20);
		//Gnomos Eliminados:
		this.textos[9] = new Texto("Salvados:",700,20); 
		this.textos[10] = new Texto("0",765,20);
		
		
		
		//Paisaje de Fondo:
		this.paisaje = new Paisaje(paisaje,350,350,0,0.22);
		
		//Casa sobre las islas:
		this.casa = new Casa(casa,400,60,0,0.02,0.0);
		
		this.barras = new Barra[15];
		//Primera Fila:
		this.barras[0] = new Barra(100,530,121,21, 0);
		this.barras[1] = new Barra(250,530,121,21, 0);
		this.barras[2] = new Barra(400,530,121,21, 0);
		this.barras[3] = new Barra(550,530,121,21, 0);
		this.barras[4] = new Barra(700,530,121,21, 0);
		//Segunda Fila:
		this.barras[5] = new Barra(150,430,143,24, 0);
		this.barras[6] = new Barra(320,430,143,24, 0);
		this.barras[7] = new Barra(490,430,143,24, 0);
		this.barras[8] = new Barra(660,430,143,24, 0);
		//Tercera Fila:
		this.barras[9]  = new Barra(200,330,150,26, 0);
		this.barras[10] = new Barra(400,330,150,26, 0);
		this.barras[11] = new Barra(600,330,150,26, 0);
		//Cuarta Fila:
		this.barras[12] = new Barra(300,200,150,26, 0);
		this.barras[13] = new Barra(500,200,150,26, 0);
		//Quinta Fila:
		this.barras[14] = new Barra(400,100,150,26, 0);
		
		
		//Islas:
		this.islas = new Isla[20];
		//Primera Fila:
		this.islas[0] = new Isla(ImagenIsla,100,530,0,0.18, 0);
		this.islas[1] = new Isla(ImagenIsla,250,530,0,0.18, 0);
		this.islas[2] = new Isla(ImagenIsla,400,530,0,0.18, 0);
		this.islas[3] = new Isla(ImagenIsla,550,530,0,0.18, 0);
		this.islas[4] = new Isla(ImagenIsla,700,530,0,0.18, 0);
		//Segunda Fila:
		this.islas[5] = new Isla(ImagenIsla,150,430,0,0.21, 0);
		this.islas[6] = new Isla(ImagenIsla,320,430,0,0.21, 0);
		this.islas[7] = new Isla(ImagenIsla,490,430,0,0.21, 0);
		this.islas[8] = new Isla(ImagenIsla,660,430,0,0.21, 0);
		//Tercera Fila:
		this.islas[9]  = new Isla(ImagenIsla,200,330,0,0.22, 0);
		this.islas[10] = new Isla(ImagenIsla,400,330,0,0.22, 0);
		this.islas[11] = new Isla(ImagenIsla,600,330,0,0.22, 0);
		//Cuarta Fila:
		this.islas[12] = new Isla(ImagenIsla,300,200,0,0.23, 0.0);
		this.islas[13] = new Isla(ImagenIsla,500,200,0,0.23, 0.0);
		//Quinta Fila:
		this.islas[14] = new Isla(ImagenIsla,400,100,0,0.22, 0.0);
		
		
		//Inicializacion de Gnomo
		this.gnomos = new ArrayList<>();
		int numeroDeGnomos = (int) (Math.random() * 3) + 2;
		for(int i = 0; i < numeroDeGnomos; i++) {
			Gnomo gnomo = new Gnomo(Gnomo,400,50,0.04);
			this.gnomos.add(gnomo);
		}
		//Inicio Pep
		this.pep = new Pep(Pep,100,500,0,0.1);

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
		
		
		// Procesamiento de un instante de tiempo
		//this.barra.dibujar(this.entorno);
		

		//Imagen de Fondo:
	    this.paisaje.dibujar(this.entorno);
	 
	 	//Movimiento de la barra:
		
		//barras Inferirores
		for(int i = 0; i < this.barras.length-3; i++) {
		    Barra b = this.barras[i];
			if(b != null) { // Reviso que la referencia al objeto no sea NULL
				b.dibujar(this.entorno);
			}
		}	
		//barras Superiores:
		
		for(int i = 12; i < this.barras.length; i++) {
		    Barra b = this.barras[i];
			if(b != null) { // Reviso que la referencia al objeto no sea NULL
				b.dibujar(this.entorno);
				b.mover();
				
				if(b.getX() - b.getAncho() < 100) {
					b.rebotarderecha();
				}
				if(b.getX() - b.getAncho()  > 700) {
					b.rebotarizquierda();
				}
				
			}
		
		}
		//Dibuja la Casa de los Gnomos:
		this.casa.dibujar(this.entorno);	
				
		
		
		//Dibujo y Movimiento de la Isla:
		
		//Islas Inferirores
		for(int i = 0; i < this.islas.length-3; i++) {
		    Isla p = this.islas[i];
			if(p != null) { // Reviso que la referencia al objeto no sea NULL
				p.dibujar(this.entorno);
			}
		}	
		//Islas Superiores:
		
		for(int i = 12; i < this.islas.length; i++) {
		    Isla p = this.islas[i];
			if(p != null) { // Reviso que la referencia al objeto no sea NULL
				p.dibujar(this.entorno);
				p.mover();
				
				if(p.getX() - p.getEscala() < 100) {
					p.rebotarderecha();
				}
				if(p.getX() - p.getEscala()  > 700) {
					p.rebotarizquierda();
				}
				
			}
		}
		
		//Movimiento y dibujo de los gnomos
		for (Gnomo gnomo : gnomos) {
			gnomo.dibujar(this.entorno);
			gnomo.mover(this.barras);
		}
		
		//Movimiento y dibujo de Pep
		pep.dibujar(this.entorno);
		pep.moverP(this.barras,entorno);
		
			
		
		
		//Movimiento de las casa
		Casa c = this.casa;
		if(c != null) { // Reviso que la referencia al objeto no sea NULL
			c.dibujar(this.entorno);
			c.mover();
				
			if(c.getX() - c.getEscala() < 100) {
					c.rebotarderecha();
			}
			if(c.getX() - c.getEscala()  > 700) {
					c.rebotarizquierda();
			}
				
		  }	
		//Contadores en Pantalla:
		
		//Tiempo del juego:

		int Seg = (entorno.tiempo())/1000; // Toma el tiempo en milisegundos desde que inicial el juego y los convierte en segundos.
		int Min = 0; 
		textos[0].dibujarTexto(this.entorno); //this.textos[0] = new Texto("Tiempo:",100,20); // "Tiempo."
		textos[2].dibujarTexto(this.entorno); //this.textos[2] = new Texto(":",160,20);       // ":"
		textos[1].dibujarTexto(this.entorno);
		for (int i = 0; i < 10; i++) {
		
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
        //Gnomos Perdidos:
			int Perdidos = 0;
	     	
			textos[5].dibujarTexto(this.entorno);  // Dibuja el Texto en Pantalla/
		    textos[6].actualizarNumero(Perdidos);  // Actualiza el texto con el contador.   
	        textos[6].dibujarTexto(entorno);       // Dibuja el contador.
	      //Gnomos Perdidos:
			int Salvados = 0;
	     	
			textos[7].dibujarTexto(this.entorno);  // Dibuja el Texto en Pantalla/
		    textos[8].actualizarNumero(Salvados);  // Actualiza el texto con el contador.   
	        textos[8].dibujarTexto(entorno);       // Dibuja el contador.
	      //Gnomos Eliminados:
	        int Eliminados = 0;
	        textos[9].dibujarTexto(this.entorno);  // Dibuja el Texto en Pantalla/
		    textos[10].actualizarNumero(Eliminados);  // Actualiza el texto con el contador.   
	        textos[10].dibujarTexto(entorno);       // Dibuja el contador.
	}
	
	    
	            
	    
 	
		
		
		
		
		
		/*
		//Revisamos que tecla esta presionada
		// Si se presiona la 'p' hacemos el movimiento inicial
		if(this.entorno.sePresiono('p')) {
			this.casa.iniciar(4);
			for(Isla p: this.islas) {
				p.iniciar(4);
			}
		
			
		}
		*/		
	
/*
		//Movimiento de la barra:
		Barra b = this.barra;
		if(b != null) { // Reviso que la referencia al objeto no sea NULL
			b.dibujar(this.entorno);
			b.mover();
		}	
		if(b.getX() - b.getAncho() < 0) {
				b.rebotarderecha();
		}
		if(b.getX() - b.getAncho()  > 800) {
			b.rebotarizquierda();
		}		
	*/	
		
	  


	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
