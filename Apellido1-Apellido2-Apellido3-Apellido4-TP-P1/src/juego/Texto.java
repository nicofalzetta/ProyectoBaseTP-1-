package juego;

import java.awt.Color;

import entorno.Entorno;

public class Texto {
	private String texto;
	private double x;
	private double y;
	

	
	public Texto(String texto,double x, double y){
		this.texto = texto;
		this.x = x;
		this.y = y;
	}
	public void dibujarTexto(Entorno entorno) {
		
		entorno.cambiarFont("Times new roman",16, Color.BLACK,entorno.NEGRITA);
		entorno.escribirTexto(texto,x,y); // Aquí se dibuja el texto en las coordenadas especificadas

	}
	public void dibujarTextoPerder(Entorno entorno) {
		
		entorno.cambiarFont("Bauhaus 93",80, Color.BLACK,entorno.NEGRITA);
		entorno.escribirTexto(texto,x,y); // Aquí se dibuja el texto en las coordenadas especificadas

	}
public void dibujarTextoGanar(Entorno entorno) {
		
		entorno.cambiarFont("Berlin Sans FB Demi",40, Color.BLACK,entorno.NEGRITA);
		entorno.escribirTexto(texto,x,y); // Aquí se dibuja el texto en las coordenadas especificadas

	}
	public void actualizarNumero(int numero) {
        this.texto = String.valueOf(numero); // Actualiza el texto con el nuevo número
    }
	public void actualizarNumeroPerdidos(int numero) {
        this.texto = String.valueOf(numero); // Actualiza el texto con el nuevo número
    }
	public void actualizarNumerodeSalvados(int numero) {
        this.texto = String.valueOf(numero); // Actualiza el texto con el nuevo número
    }
	public String getTexto() {
		return texto;
	}
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}
	
	
}
