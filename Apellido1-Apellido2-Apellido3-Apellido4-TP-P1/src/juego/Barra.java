package juego;


import java.awt.Color;
import entorno.Entorno;

public class Barra {
	
	private int x;
	private int y;
	private int ancho;
	private int alto;
	private int velocidad;
	
	public Barra(int x, int y, int ancho, int alto, int velocidad){
		this.x = x;
		this.y = y;
		this.ancho = ancho;
		this.alto = alto;
		this.velocidad = velocidad;
	}
	public void mover() {
		this.x= this.x + this.velocidad;
	}
	public void rebotarderecha() {
		this.velocidad = this.velocidad * (-1);
	}
	public void rebotarizquierda() {
		this.velocidad = this.velocidad * (-1);
	}
	public void iniciar(int velocidad) {
		this.velocidad = velocidad;
	}

		
	public void dibujar(Entorno entorno) {
		entorno.dibujarRectangulo(this.x, this.y, this.ancho, this.alto, 0, Color.YELLOW);
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public int getVelocidad() {
		return velocidad;
	}

}
