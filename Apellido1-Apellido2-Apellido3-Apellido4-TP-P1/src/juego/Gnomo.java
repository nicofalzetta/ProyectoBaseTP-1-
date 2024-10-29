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
    private double radio;
    private double direccion;
    private boolean estaVisible;
    private long tiempoDesaparicion; 
	private static final double[] VELOCIDADES = {0.3,0.7,0.2,0.5};
	private static final Random RANDOM = new Random();
	
	public Gnomo(Image imagen, double x, double y, double escala,double radio) {
		 this.imagen = imagen;
	     this.x = x;
	     this.y = y;
	     this.velocidad = VELOCIDADES[RANDOM.nextInt(VELOCIDADES.length)]; 
	     this.escala = escala;
	     this.tiempoDesaparicion = 0;
	     this.direccion = Math.random() > 0.5 ? 1 : -1;
	     this.estaVisible = true;
	     this.radio = radio;
	}

    public boolean desaparece(double limiteAltura) {
    	  return this.y > limiteAltura;
    }
    
    public void desaparecer() {
        this.tiempoDesaparicion = System.currentTimeMillis();
    }

    public boolean necesitaReaparicion() {
        return System.currentTimeMillis() - tiempoDesaparicion >= 2000; // 2 segundos para reaparecer
    }

    public void reaparcer(double x, double y) {
        this.x = x;
        this.y = y;
        this.tiempoDesaparicion = 0; // Reiniciar tiempo
    }

    public void dibujar(Entorno entorno) {
        entorno.dibujarImagen(this.imagen, this.x, this.y, 0, escala);
    }
    
    public boolean estaVisible() {
		 return this.estaVisible;
	 }
    
    // Método para verificar si el gnomo está sobre una barra
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
    
    // Verifica la colisión con una barra
    public boolean colisionaConBarra(Barra barra) {
        return (this.x > barra.getX() - barra.getAncho() / 2 &&
                this.x < barra.getX() + barra.getAncho() / 2 &&
                this.y + 20 >= barra.getY() - barra.getAlto() / 2 &&
                this.y <= barra.getY() + barra.getAlto() / 2);
    }
    
    // Método para hacer caer al gnomo
    public void caer(Barra[] barras) {
        this.y += 1.5;

        // Verifica si colisiona con alguna barra al caer
        for (Barra barra : barras) {
            if (this.colisionaConBarra(barra)) {
                direccion *= -1;
            }
        }
    }
    
 // Verifica la reaparición del gnomo
    public void verificarReaparicion() {
        if (!estaVisible) {
            this.estaVisible = true; 
            this.x = 400; 
            this.y = 50; 
        }
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
	 public void velocidadCeroGnomo() {
			velocidad = 0; 
		}

	
    // Getters
    
    public double getRadio() {
        return radio;
    }
    
    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public double getVelocidad() {
		return velocidad;
	}
}
