package juego;

import java.awt.Image;

import entorno.Entorno;

public class Paisaje {
	
		private Image imagen;
		private double x;
		private double y;
		private double angulo;
		private double escala;
	
	
	public Paisaje(Image imagen, double x, double y, double angulo, double escala) {
		this.imagen = imagen;
		this.x = x;
		this.y = y;
		this.angulo = angulo;
		this.escala = escala;
		
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

}