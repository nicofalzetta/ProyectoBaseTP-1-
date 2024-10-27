package juego;

import java.awt.Image;


import entorno.Entorno;

public class Pep {
	
		private Image imagen;
		private double x;
		private double y;
		private double angulo;
		private double escala;
		private double velocidad;
		private double direccion;
		private double velocidadSalto;
	
	
	public Pep(Image imagen,double x, double y, double angulo, double escala) {
		this.imagen = imagen;
		this.x = x;
		this.y = y;
		this.angulo = angulo;
		this.escala = escala;
		this.velocidad = velocidad;
		this.direccion = 0;
		this.velocidadSalto = velocidadSalto;
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
	
	public boolean estaPresionada(char key) {
		return true;
	}
	
	public boolean estaPresionada2(char key,char key2) {
		return true;
	}
	
	public boolean sePresiono(char key) {
		return true;
		
	}
	
	public boolean seLevanto(char key) {
		return true;
		
	}
	//Para el movimiento de Pep
		public void moverP(Barra[] barras,Entorno entorno) {
			//Verifica si esta sobre una barra, sino lo esta, cae
			if (!this.estaSobreBarra(barras)) {
				caer(barras);
			}else {
				//Movimiento del gnomo hacia la izquierda o derecha
				if (entorno.estaPresionada(entorno.TECLA_ARRIBA)) {
					this.y -= velocidadSalto + velocidad + 60;
				
				}
				if (entorno.estaPresionada(entorno.TECLA_IZQUIERDA)) {
					this.x -= velocidad + 1;
				}
				
				}
				if (entorno.estaPresionada(entorno.TECLA_DERECHA)) {
					this.x += velocidad + 1;
				}
				}
				
		   
			
		
		
		public void caer(Barra[] barras) {
			this.y += 2;
		}
	
	//dibuja la imagen de Pep
		public void dibujar(Entorno entorno) {
			entorno.dibujarImagen(this.imagen,this.x,this.y,this.angulo,this.escala);
		}
		
	
		
		//Metodo para verificar si pep esta sobre una barra
		public boolean estaSobreBarra(Barra[] barras) {
			for (Barra barra : barras) {
				if (barra != null && this.y + 20 >= barra.getY() - barra.getAlto() /2 &&
						this.y <= barra.getY() + barra.getAlto() / 2 &&
						this.x + 10 >= barra.getX() - barra.getAncho() / 2 &&
						this.x - 10 <= barra.getX() + barra.getAncho() / 2) {
					return true;
				}
			}
			return false;
		}
		
		
	}
		
		

