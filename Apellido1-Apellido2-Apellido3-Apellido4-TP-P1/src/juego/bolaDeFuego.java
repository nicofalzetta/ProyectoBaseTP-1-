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
		private double direccion;
		
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
					if (barra != null && this.y + 200 >= barra.getY() - barra.getAlto() / 2 &&
							this.y <= barra.getY() + barra.getAlto() / 2 &&
							this.x + 100 >= barra.getX() - barra.getAncho() / 2 &&
							this.x - 100 <= barra.getX() + barra.getAncho() / 2) {
						return true;
					}
				}
				return false;
				}
			//Verifica la colision con una barra
			public void mover(Barra[] barras) {
				//Verifica si esta sobre una barra, sino lo esta, cae
				if (!this.estaSobreBarra(barras)) {
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
	
