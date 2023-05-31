package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Suero {
	private double x;
	private double y;
	private double escala;
	private Image imgSuero;

	private double angulo;
	private int tiempoMax;
	private double ancho;
	private double alto;
	
	//Aca es el constructor del suero
	
	public Suero(int ancho, int alto, int tiempo) {

		this.x = (int) (Math.random() * (alto - 150 + 1)) + 100;

		this.y = (int) (Math.random() * (alto - 150 + 1)) + 100;

		this.imgSuero = Herramientas.cargarImagen("suero.png");
		this.escala = 0.2;
		this.angulo = 0;
		this.tiempoMax = tiempo + 200; // 100 ticks son 1 s //Este es el tiempo max del suero
		this.alto = 30;
		this.ancho = 30;
	}
//////////////////////////Se dibuja el suero en el entorno/////////////////////	
	public void dibujar(Entorno e) {
		e.dibujarImagen(imgSuero,this.x,this.y,this.angulo,escala);
	}
	
	
///////////////////////////////////////Getters///////////////////////////////
	
	public int getTiempoMax() {
		return tiempoMax;
	}

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
