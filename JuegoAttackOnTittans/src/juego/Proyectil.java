package juego;
import java.awt.Color;


import entorno.Entorno;



public class Proyectil {
	private double x;
	private double y;
	private double angulo;
	private Color color;
	private double alto;
	private double ancho;
	
	
	public Proyectil(double x, double y) {
		this.x = x;
		this.y = y;
		this.color = color.YELLOW;
		this.alto = 1;
		this.ancho = 1;
		
	}
	
	public void dibujar(Entorno entorno) {

		entorno.dibujarRectangulo(x, y, 5, 5, 0, color);
	}
///////////////////////////////Angulo del proyectil//////////////////////	
	public void definirAngulo(double angulo) {
		this.angulo = angulo;
		}
//////////////////////////////Movimiento del Proyectil//////////////////	
	public void avanzar (Entorno e) {
			this.x += Math.cos(this.angulo) * 2 ;
			this.y += Math.sin(this.angulo) * 2 ;
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