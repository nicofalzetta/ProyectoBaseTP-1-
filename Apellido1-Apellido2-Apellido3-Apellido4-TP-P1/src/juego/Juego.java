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
	private Isla isla;
	private Barra barra;
	// ...
	
	Juego()
	{
		// Inicializa el objeto entorno
		this.entorno = new Entorno(this, "Al Rescate de los Gnomos", 800, 600);
		// Inicializar lo que haga falta para el juego
		Image ImagenIsla = Herramientas.cargarImagen("imagenes/isla.png");
		
		this.isla = new Isla(ImagenIsla,350,470,0,0.32, 0);
		
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
		this.barra.dibujar(this.entorno);
		
		this.isla.dibujar(this.entorno);
		
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
		
		//Movimiento de la Isla:
			Isla p = this.isla;
			if(p != null) { // Reviso que la referencia al objeto no sea NULL
				p.dibujar(this.entorno);
				p.mover();
				
				if(p.getX() - p.getEscala() < 0) {
					p.rebotarderecha();
				}
				if(p.getX() - p.getEscala()  > 800) {
					p.rebotarizquierda();
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
		//Revisamos que tecla esta presionada
		// Si se presiona la 'p' hacemos el movimiento inicial
		if(this.entorno.sePresiono('p')) {
			//b.iniciar(4);
			p.iniciar(4);
		}
	  
	  }

	}

	@SuppressWarnings("unused")
	public static void main(String[] args)
	{
		Juego juego = new Juego();
	}
}
