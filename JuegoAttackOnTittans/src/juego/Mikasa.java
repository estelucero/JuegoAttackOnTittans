package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Mikasa {

	private double x;
	private double y;
	private double velocidad;
	private Image img1;
	private Image img2;
	private double escala;
	private double angulo;
	private double colisionSuero;
	private double velocidadAngulo;
	private int ancho;
	private int alto;
	private boolean modoTitan;
	private int tiempoTitan;
	private double escala2;
	
	public Mikasa(double x, double y) {

		this.x = x;
		this.y = y;
		this.velocidad = 1;
		this.escala = 0.4;
		this.escala2 = 0.2;
		this.angulo = 0;
		this.colisionSuero = 37;
		this.velocidadAngulo = 0.1;
		this.ancho = 20;
		this.alto = 30;
		this.modoTitan = false;
		this.tiempoTitan = 0;
		this.img1 = Herramientas.cargarImagen("mikasa_stay.png");
		this.img2 = Herramientas.cargarImagen("mikasa_titan.png");
	}

/////////////////////////////////////////////Codigo que dibuja a Mikasa//////////////////////////////////////
	public void dibujar(Entorno e) {
		if(this.modoTitan == true) {
			e.dibujarImagen(img2, this.x, this.y, this.angulo, this.escala);
		}else {
			e.dibujarImagen(img1, this.x, this.y, this.angulo, this.escala2);
	}
	}
////////////////////////////////////////////////Codigo para que Mikasa camine///////////////////////////////////
	public void caminar(Entorno e) {

		this.x += Math.cos(this.angulo) * velocidad;
		this.y += Math.sin(this.angulo) * velocidad;

		if (this.x > e.ancho() - 20) {
			this.x = e.ancho() - 20;		//Codigo para que Mikasa choque contra los bordes
		}
		if (this.x < 20) {
			this.x = 20; 
		}
		if (this.y > e.alto() - 20) { 
			this.y = e.alto() - 20;
		}
		if (this.y < 20) {
			this.y = 20;
		}

	}

///////////////////////////////////////////Este es el codigo para girar//////////////////////////////////////////
	public void girar(double modificador) {
		this.angulo = this.angulo + modificador;
		if (this.angulo > Math.PI * 2) {
			this.angulo = this.angulo - Math.PI * 2;
		}												//Codigo para que el angulo este entre 0 y 2pi
		if (this.angulo < 0) {
			this.angulo = this.angulo + Math.PI * 2;
		}
	}
	
	public void moverInvoluntariamente() {

		this.x -= Math.cos(this.angulo) * 10;		//Codigo para que Mikasa rebote con los obstaculos
		this.y -= Math.sin(this.angulo) * 10;
	}
	
	



///////////////////////////////////////Mikasa en modo titan///////////////////////////////
	
	public void mikasaTiempoInmortal(int tiempo) {
		this.tiempoTitan = tiempo + 500;
	}

	public void mikasaInmortal() {
		this.modoTitan = true;
	}

	public void mikasaMortal() {
		this.modoTitan = false;
	}
	
	public boolean isModoTitan() {
		return modoTitan;
	}
	

	
///////////////////////////////////////Getters///////////////////////////////
	
	public double getAngulo() {
		return angulo;
	}

	public double getColisionSuero() {
		return colisionSuero;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getVelocidadAngulo() {
		return velocidadAngulo;
	}


	public double getTamanio() {
		return escala;
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public int getTiempoTitan() {
		return tiempoTitan;
	}


}
