package juego;




import java.awt.Color;
import java.awt.Image;
import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego
{
	// El objeto Entorno que controla el tiempo y otros
	private Entorno entorno;
	
	// Variables y métodos propios de cada grupo
	private Isla[] islas;
	private Barra barra;
	private Casa casa;
	private Paisaje paisaje;
	// ...
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Al Rescate de los Gnomos", 800, 600);
		// Inicializar lo que haga falta para el juego
		Image ImagenIsla = Herramientas.cargarImagen("imagenes/isla.png");
		Image casa = Herramientas.cargarImagen("Imagenes/casa.png");
		Image paisaje = Herramientas.cargarImagen("Imagenes/paisaje.jpg");
		
		//Paisaje de Fondo:
		this.paisaje = new Paisaje(paisaje,350,350,0,0.22);
		
		//Casa sobre las islas:
		this.casa = new Casa(casa,400,74,0,0.02);
		
		//Islas:
		this.islas = new Isla[20];
		//Primera Fila:
		this.islas[0] = new Isla(ImagenIsla,100,530,0,0.19, 0);
		this.islas[1] = new Isla(ImagenIsla,250,530,0,0.19, 0);
		this.islas[2] = new Isla(ImagenIsla,400,530,0,0.19, 0);
		this.islas[3] = new Isla(ImagenIsla,550,530,0,0.19, 0);
		this.islas[4] = new Isla(ImagenIsla,700,530,0,0.19, 0);
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
		this.islas[12] = new Isla(ImagenIsla,300,200,0,0.23, 0);
		this.islas[13] = new Isla(ImagenIsla,500,200,0,0.23, 0);
		//Quinta Fila:
		this.islas[14] = new Isla(ImagenIsla,400,100,0,0.21, 0);
		
		this.barra = new Barra(350,500,200,50,2);

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
		
		
		
	/**	Movimiento de la barra
		*boolean sePresionoLaTeclaDerecha = this.entorno.estaPresionada(this.entorno.TECLA_DERECHA);
		*boolean noSePasaLaBarraAlaDerecha = (this.barra.getX() + this.barra.getAncho()/2) < this.entorno.ancho();
		*if(sePresionoLaTeclaDerecha && noSePasaLaBarraAlaDerecha) {
		*	this.barra.moverDerecha();
		*}
		*
		* Revisamos si la barra se movio hacia la izquierda
		*boolean sePresionoLaTeclaIzquierda = this.entorno.estaPresionada(this.entorno.TECLA_IZQUIERDA);
		*boolean noSePasaLaBarraAlaIzquierda = (this.barra.getX() - this.barra.getAncho()/2) > 0;
		*if(sePresionoLaTeclaIzquierda && noSePasaLaBarraAlaIzquierda) {
		*	this.barra.moverIzquierda();
		*}
		*/	
		
		//Imagen de Fondo:
		this.paisaje.dibujar(this.entorno);
		
		//Dibuja la Casa de los Gnomos:
		this.casa.dibujar(this.entorno);
		
		
		//Movimiento de la Isla:
		/*
		for(int i = 0; i < this.islas.length-3; i++) {
		    Isla p = this.islas[i];
			if(p != null) { // Reviso que la referencia al objeto no sea NULL
				p.dibujar(this.entorno);
			}
		}*/	
		
		for(int i = 0; i < this.islas.length; i++) {
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
		
		//Revisamos que tecla esta presionada
		// Si se presiona la 'p' hacemos el movimiento inicial
		if(this.entorno.sePresiono('p')) {
			for(Isla p: this.islas) {
				p.iniciar(4);	
			}
		}
				
	
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
		
	  

	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
