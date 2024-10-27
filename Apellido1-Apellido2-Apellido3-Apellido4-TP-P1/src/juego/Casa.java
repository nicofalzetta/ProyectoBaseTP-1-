package juego;

import java.awt.Image;

import entorno.Entorno;

public class Casa {
	
		private Image imagen;
		private double x;
		private double y;
		private double angulo;
		private double escala;
		private double velocidad;
	
	
	public Casa(Image imagen, double x, double y, double angulo, double escala,double velocidad) {
		this.imagen = imagen;
		this.x = x;
		this.y = y;
		this.angulo = angulo;
		this.escala = escala;
		this.velocidad = velocidad;
		
	}
	public void iniciar(int velocidad) {
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
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(this.imagen,this.x, this.y, this.angulo, this.escala);
	}
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getAngulo() {
		return angulo;
	}

	public double getEscala() {
		return escala;
	}
	public double getVelocidad() {
		return velocidad;
	}

}