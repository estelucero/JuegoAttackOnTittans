package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Casas {
	private double x;
	private double y;
	private double ancho;
	private double alto;
	private Image img;
	private double escala;
	
	public Casas(double x, double y) {
		this.x = x;
		this.y = y;
		this.ancho = 75;
		this.alto = 55;
		this.img = Herramientas.cargarImagen("obstaculo4.png");
		this.escala=0.7;
	}
///////////////////////////////Se dibuja la casa en el entorno////////////////	
	public void dibujar(Entorno e) {
		e.dibujarImagen(this.img, this.x, this.y, 0,this.escala);
	}

///////////////////////////////////////Getters///////////////////////////////
	
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getAncho() {
		return ancho;
	}

	public double getAlto() {
		return alto;
	}
	
}
