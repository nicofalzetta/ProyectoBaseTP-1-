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
		private double radio;
		
		public bolaDeFuego(Image imagen,double x, double y, double escala, double angulo, double velocidad,double radio) {
			this.imagen = imagen;
			this.x = x;
			this.y = y;
			this.escala = escala;
			this.velocidad = velocidad;
			this.angulo = angulo;
			this.radio = radio;
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
		public double getRadio() {
			return radio;
		}
		public void mover() {
			this.x =this.x +  this.velocidad;
		}
		
		public boolean sePresiono(char key) {
			return true;
			
		}
		
		public boolean seLevanto(char key) {
			return true;}
		
		public void iniciar(int velocidad) {
			this.velocidad = velocidad;
		}
				
		public void dibujar(Entorno entorno) {
					entorno.dibujarImagen(this.imagen,this.x,this.y,this.angulo,this.escala);
		}
			 
	    public boolean lanzarB(Entorno entorno) {
				
	    	if (entorno.seLevanto(entorno.TECLA_IZQUIERDA)&& entorno.sePresiono('c')) {
					
	    		iniciar(10);
					
	    		return true;
					
			}
				
	    	if (entorno.seLevanto(entorno.TECLA_DERECHA)&& entorno.sePresiono('c')) {
					
	    		iniciar(-10);
					
	    		return true;}
			 
	    	return false;
			}
		public boolean colisionBoladeFuegoTortuga(bolaDeFuego f, Tortuga t) {
			
						    
			if (f == null) {// Verifica que g no sea null
			        return false; // No hay colisión si el gnomo es null
			    }
			   // Calcula la distancia entre los centros
			   double deltaX = f.getX() - t.getX();
			   double deltaY = f.getY() - t.getY();
			   double distancia = Math.sqrt(deltaX * deltaX + deltaY * deltaY);
			   
			   double sumaRadios = f.getRadio() + t.getRadio();     // Suma de los radios

			    // Si la distancia es menor que la suma de los radios, hay colisión
			    return distancia < sumaRadios;
		   }
	}