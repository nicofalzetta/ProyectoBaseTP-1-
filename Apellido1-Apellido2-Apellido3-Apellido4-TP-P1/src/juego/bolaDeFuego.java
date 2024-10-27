package juego;

import java.awt.Image;


import entorno.Entorno;

public class bolaDeFuego {
		
		private Image imagen;
		private double x;
		private double y;
		private double escala;
		private double velocidad;
		private double angulo;
		
		public bolaDeFuego(Image imagen,double x, double y, double escala, double angulo, double velocidad) {
			this.imagen = imagen;
			this.x = x;
			this.y = y;
			this.escala = escala;
			this.velocidad = velocidad;
			this.angulo = angulo;
			}
		
		public double getAngulo() {
			return angulo;
		}
		public double getX() {
			return x;
		}

		public double getY() {
			return y;
		}

		public double getEscala() {
			return escala;
		}
		
		public double getVelocidad() {
			return velocidad;
		}
		
		
		public boolean sePresiono(char key) {
			return true;
			
		}
		
		public boolean seLevanto(char key) {
			return true;}
		
		
		//Metodo para verificar si la bola de fuego esta sobre una barra
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
				
				public void dibujar(Entorno entorno) {
					entorno.dibujarImagen(this.imagen,this.x,this.y,this.angulo,this.escala);
				}
			
			public boolean lanzarB(Entorno entorno) {
				if (entorno.seLevanto(entorno.TECLA_IZQUIERDA)&& entorno.sePresiono('c')) {
					this.x -= velocidad + 10;
					return true;
					
					}
				if (entorno.seLevanto(entorno.TECLA_DERECHA)&& entorno.sePresiono('c')) {
					this.x += velocidad + 10;
					return true;}
			 return false;
			}
				}
	
