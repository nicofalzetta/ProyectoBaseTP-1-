//Este es solo un comentario para poder subir hacer otro push al repositorio

package juego;
import java.util.Random;
import java.awt.Image;
import entorno.Entorno;

public class Tortuga{
	private Image imagen;
	private double x;
	private double y;
	private double radio;
	private double velocidad;
	private double escala;
	private double direccion;
	
	//Array con las velocidades para cada tortuga
	private static final double[] VELOCIDADES = {1};
	private static final Random RANDOM = new Random();
	//Array con las posiciones para cada tortuga
	private static final int[] POSICIONESX = {100,120,140,170,200,500,535,570,650,700,750};
	private static final int[] POSICIONESY = {250,300,350,400};
	public Tortuga(Image imagen, double y, double escala,double radio) {
		// 	Cargar la imagen
		this.imagen = imagen;
		this.x = POSICIONESX[RANDOM.nextInt(POSICIONESX.length)];
		this.y = POSICIONESY[RANDOM.nextInt(POSICIONESY.length)];
		this.velocidad = VELOCIDADES[RANDOM.nextInt(VELOCIDADES.length)]; 
		this.escala = escala;
		this.direccion = Math.random() > 0.5 ? 1 : -1;
		
	}
    
	public void mover(Barra[] barras) {
	    // Verifica si está sobre una barra; si no, llama al método caer
	    boolean sobreBarra = false;
	    Barra barraActual = null;

	    for (Barra barra : barras) {
	        if (this.estaSobreBarra(new Barra[]{barra})) {
	            sobreBarra = true;
	            barraActual = barra;
	            break; // Encuentra la primera barra en la que está la tortuga y sale del bucle
	        }
	    }

	    if (!sobreBarra) {
	        caer(barras);
	    } else {
	        // Movimiento horizontal dentro de los límites de la barra
	        this.x += this.velocidad * direccion;

	        if (this.x < barraActual.getX() - barraActual.getAncho() / 2) {
	            this.x = barraActual.getX() - barraActual.getAncho() / 2;  // Límite izquierdo
	            direccion = 1;  // Cambia dirección hacia la derecha
	        }
	        if (this.x > barraActual.getX() + barraActual.getAncho() / 2) {
	            this.x = barraActual.getX() + barraActual.getAncho() / 2;  // Límite derecho
	            direccion = -1;  // Cambia dirección hacia la izquierda
	        }
	    }
	}


	
	//dibuja la imagen de la tortuga
	public void dibujar(Entorno entorno) {
		entorno.dibujarImagen(this.imagen, this.x, this.y,0,escala);
	}
	
	//Metodo para verificar si la tortuga esta sobre una barra
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
	
	//Verifica la colision con una barra
	public boolean colisionaConBarra(Barra barra) {
		return(this.x > barra.getX() - barra.getAncho() / 2 &&
				this.x < barra.getX() + barra.getAncho() / 2 &&
				this.y + 20 >= barra.getY() - barra.getAlto() / 2 &&
				this.y <= barra.getY() + barra.getAlto() / 2);
	}
	
	
	//Metodo para hacer caer a la tortuga
	public void caer(Barra[] barras) {
		this.y += 2;
		
		//Verifica si colisiona con alguna barra al caer
		for (Barra barra : barras) {
			if (this.colisionaConBarra(barra)) {
				direccion *= -1;
			}
		}
	}
	//Setter
	public void setX(double x) {
		this.x =x;
	}
	
	public void setY(double y) {
		this.y = y;
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
	public double getVelocidad() {
		return velocidad;
	}
	public void velocidadCeroTortuga() {
		velocidad = 0; 
	}
	
	public boolean colisionTortugaGnomo(Tortuga t, Gnomo g) {
		// Verifica que g no sea null
	    if (g == null) {
	        return false; // No hay colisión si el gnomo es null
	    }
	    // Calcula la distancia entre los centros
	    double deltaX = t.getX() - g.getX();
	    double deltaY = t.getY() - g.getY();
	    double distancia = Math.sqrt(deltaX * deltaX + deltaY * deltaY);

	    // Suma de los radios
	    double sumaRadios = t.getRadio() + g.getRadio();

	    // Si la distancia es menor que la suma de los radios, hay colisión
	    return distancia < sumaRadios;
	}
}