package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Muralla {
	public double x;
	public double y;
	private double ancho;
	private double alto;
	private double escala;
	private double angulo;
	public Image obstaculo1;

	public Muralla(double x, double y) {
		this.x = x;
		this.y = y;
		this.ancho = 180;
		this.alto = 55;
		this.escala = 0.7;
		this.angulo = 0;
		this.obstaculo1 = Herramientas.cargarImagen("Obstaculo3.png");
	}
////////////////////////Muralla se dibuja en el entorno //////////////////	
	public void dibujar(Entorno e) {
		e.dibujarImagen(obstaculo1, x, y, angulo, escala);
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