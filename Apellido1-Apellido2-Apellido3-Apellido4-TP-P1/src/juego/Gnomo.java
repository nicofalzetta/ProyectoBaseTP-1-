package juego;

import java.awt.Image;
import java.util.Random;

import entorno.Entorno;



public class Gnomo {
	private Image imagen;
	private double x;
	private double y;
	private double velocidad;
	private double escala;
	private double desplazamiento;
	private double direccion;
	private double radio;
	
	//Array con las velocidades para cada gnomo
	private static final double[] VELOCIDADES = {0.3,0.7,0.2,0.5};
	private static final Random RANDOM = new Random();
	
	public Gnomo(Image imagen, double x, double y, double escala,double radio) {
		// 	Cargar la imagen
		this.imagen = imagen;
		this.x = x;
		this.y = y;
		this.velocidad = VELOCIDADES[RANDOM.nextInt(VELOCIDADES.length)]; 
		this.escala = escala;
		this.desplazamiento = 0;
		this.direccion = Math.random() > 0.5 ? 1 : -1;
		this.radio = radio;
	}

	
	//Verifica la colision con una barra
	public void mover(Barra[] barras) {
		//Verifica si esta sobre una barra, sino lo esta, cae
		if (!this.estaSobreBarra(barras)) {
			caer(barras);
		}else {
			//Movimiento del gnomo hacia la izquierda o derecha
			this.x += this.velocidad * direccion;
			// 	Verifica que el gnomo no salga del rango de las barras
			if(this.x < 0 ) {
				this.x = 0;
				direccion = 1;   
			}
			if (this.x > 800) {
				this.x = 800;
				direccion = -1; 
			}
			
	    }
		
	}
	
	//dibuja la imagen del gnomo
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(this.imagen, this.x, this.y,0,escala);
	}
	
	//Metodo para verificar si el gnomo esta sobre una barra
	public boolean estaSobreBarra(Barra[] barras) {
		for (Barra barra : barras) {
			if (barra != null && this.y + 20 >= barra.getY() - barra.getAlto() / 2 &&
					this.y <= barra.getY() + barra.getAlto() / 2 &&
					this.x + 10 >= barra.getX() - barra.getAncho() / 2 &&
					this.x - 10 <= barra.getX() + barra.getAncho() / 2) {
				return true;
			}
		}
		return false;
	}
	
	public void rebotar() {
		this.desplazamiento = -this.desplazamiento;
		this.y += this.desplazamiento;
	}
	
	//Verifica la colision con una barra
	public boolean colisionaConBarra(Barra barra) {
		return(this.x > barra.getX() - barra.getAncho() / 2 &&
				this.x < barra.getX() + barra.getAncho() / 2 &&
				this.y + 20 >= barra.getY() - barra.getAlto() / 2 &&
				this.y <= barra.getY() + barra.getAlto() / 2);
	}
	
	
	//Metodo para hacer caer al gnomo
	public void caer(Barra[] barras) {
		this.y += 2;
		
		//Verifica si colisiona con alguna barra al caer
		for (Barra barra : barras) {
			if (this.colisionaConBarra(barra)) {
				this.rebotar();
				direccion *= -1;
			}
		}
	}
	
	//Getters
	public double getX() {
		return x;
	}
	
	public double getY() {
		return y;
	}
	public double getRadio() {
		return radio;
	}
	
}
