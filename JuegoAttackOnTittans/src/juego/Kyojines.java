package juego;

import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;

public class Kyojines {
	
	private double x;
	private double y;
	private double angulo;
	private double velocidad;
	private double escala;
	private Image img1;
	private double alto;
	private double ancho;


	public Kyojines(int x, int y) {
		
		this.x = x;
		this.y = y;
		this.velocidad = 0.25;
		this.angulo = 0;
		this.escala = 0.25;
		this.img1 = Herramientas.cargarImagen("kyojines1.png");
		this.alto = 55;
		this.ancho = 55;
		
	}
/////////////////////////////Se dibuja el titan en el entorno////////////
	public void dibujar(Entorno e) {
			e.dibujarImagen(img1, this.x, this.y, 0, this.escala);
	}
	


///////////////////////////////////Movimiento del Titan/////////////////
	public void mover(double x, double y,Entorno e ,int tick) {
		if(tick%700==0) {
			double delx = x - this.x;
			double dely = y - this.y;					//Determina el angulo del titan
			this.angulo = Math.atan2(dely, delx);
		}
		
		if (this.angulo > Math.PI * 2) {
			this.angulo = this.angulo - Math.PI * 2;
		}												//Hace que el angulo este entre 0 y 2pi 
		if (this.angulo < 0) {
			this.angulo = this.angulo + Math.PI * 2;
		}
		
		
		this.x += Math.cos(this.angulo) * velocidad;
		this.y += Math.sin(this.angulo) * velocidad;
		
		
		if (this.x > e.ancho() - 20) {
			this.x = e.ancho() - 20;
		}
		if (this.x < 20) {
			this.x = 20; 	// Esto hace que el titan choque con las paredes
							
		}
		if (this.y > e.alto() - 20) { 
			this.y = e.alto() - 20;
		}
		if (this.y < 20) {
			this.y = 20;
		}
	}
	

	
	public void moverInvoluntariamente() {


		if (this.angulo > Math.PI && this.angulo < 2 * Math.PI) {
			this.x -= Math.cos(this.angulo - 0.4) * 10;
			this.y -= Math.sin(this.angulo - 0.4) * 10;
		} else {													//Hace que el titan rebote contra los obstaculos
			this.x -= Math.cos(this.angulo + 0.4) * 10;
			this.y -= Math.sin(this.angulo + 0.4) * 10;
		}
	}
	
	


	public void moverInvoluntariamenteEsp(int signo){
		

		this.x =this.x+(signo)* (Math.cos(this.angulo + Math.PI) * (Math.random()*(20-2)+2)+Math.random());
		this.y =this.y+(signo)*( Math.sin(this.angulo + Math.PI) * (Math.random()*(20-2)+2)-Math.random());
	}
																												//Hace que el titan rebote contra los titanes
	public void moverInvoluntariamenteXEsp(int signo) {
		this.x =this.x+(signo)* (Math.cos(this.angulo + Math.PI) * (Math.random()*(20-2)+2)+Math.random());	
	}
	
	public void moverInvoluntariamenteYEsp(int signo) {
		this.y =this.y+(signo)*( Math.sin(this.angulo + Math.PI) * (Math.random()*(20-2)+2)-Math.random());
	}
	
	public void seguirRitmo() {
		this.x += Math.cos(this.angulo) * velocidad;
		this.y += Math.sin(this.angulo) * velocidad;														
	}
	
	

///////////////////////////////////////Getters///////////////////////////////
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getAlto() {
		return alto;
	}

	public double getAncho() {
		return ancho;
	}
	
	}
	
	
	
		