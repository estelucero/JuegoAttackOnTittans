package juego;


import java.awt.Color;
import java.awt.Image;

import entorno.Entorno;
import entorno.Herramientas;
import entorno.InterfaceJuego;

public class Juego extends InterfaceJuego {
	

/////////////////////////////////Funcion para saber el cuadrante dependiendo un objeto:Sirve para las colisiones porque sabemos para donde llevarlo//////////////////////
	public static int cuadrante(Kyojines titan1, Kyojines titan2) {

		if (titan1.getX() >= titan2.getX()) {
			if (titan1.getY() <= titan2.getY()) {
				return 1;
			} else {
				return 4;
			}
		} else {
			if (titan1.getY() <= titan2.getY()) {
				return 2;
			} else {
				return 3;
			}
		}
	}
	


	////////////////////////////Esta es una funcion determina la distantica entre dos objetos //////////////////////////////
	public static boolean colision(Mikasa mikasa, Suero suero, double distancia) {
		return (mikasa.getX() + mikasa.getAncho() - (suero.getX() + suero.getAncho()))
				* (mikasa.getX() + mikasa.getAncho() - (suero.getX() + suero.getAncho()))
				+ (mikasa.getY() + mikasa.getAlto() - (suero.getY() + suero.getAlto()))
				* (mikasa.getY() + mikasa.getAlto() - (suero.getY() + suero.getAlto())) < distancia * distancia;
	}

	
	//////////////////////////////Esta es la colision Muralla;Mikasa////////////////////////////////
	public static boolean colision(Mikasa mikasa, Muralla muralla) {

		return mikasa.getX() > muralla.getX() - muralla.getAncho()  
			   && mikasa.getX() < muralla.getX() + muralla.getAncho() 
		       && mikasa.getY() + mikasa.getAlto() / 2 > muralla.getY() - muralla.getAlto()+23  
		       && mikasa.getY() + mikasa.getAlto() / 2 < muralla.getY() + muralla.getAlto()+10 ;
				
	}
////////////////////////////////////////Colision Suero Muralla///////////////////////////////////////////////////
	
	public static boolean colision(Suero suero, Muralla muralla) {

		return suero.getX() > muralla.getX() - muralla.getAncho()  
			   && suero.getX() < muralla.getX() + muralla.getAncho() 
		       && suero.getY() + suero.getAlto() / 2 > muralla.getY() - muralla.getAlto()+23  
		       && suero.getY() + suero.getAlto() / 2 < muralla.getY() + muralla.getAlto()+10 ;
				
	}
	
	
///////////////////////////////////Colision Mikasa Casa///////////////////////////////////////////
	public static boolean colision(Mikasa mikasa, Casas casa) {

		return mikasa.getX() > casa.getX() - casa.getAncho()-10  
			   && mikasa.getX() < casa.getX()-10 + casa.getAncho() 
		       && mikasa.getY() + mikasa.getAlto() / 2 > casa.getY() - casa.getAlto()   
		       && mikasa.getY() + mikasa.getAlto() / 2 < casa.getY() + casa.getAlto() ;
				
	}

//////////////////////////////////Colision Mikasa normal Titan//////////////////////////////////
	
	public static boolean colision(Kyojines titan1, Mikasa mikasa, double distancia) {
		if (mikasa != null) {
			if (!mikasa.isModoTitan()) {

				return (titan1.getX() - (mikasa.getX())) * (titan1.getX() - (mikasa.getX()))
						+ (titan1.getY() - (mikasa.getY())) * (titan1.getY() - (mikasa.getY())) < distancia * distancia;

			} else {

				return (titan1.getX() - (mikasa.getX())) * (titan1.getX() - (mikasa.getX()))
						+ (titan1.getY() - (mikasa.getY()))
								* (titan1.getY() - (mikasa.getY())) < (distancia * distancia) + 50;
			}
		}
		return false;
	}

/////////////////////////////////Colision Suero - Casa////////////////////////////////////////////
	
	public static boolean colision(Suero suero, Casas casa) {

		return suero.getX() > casa.getX() - casa.getAncho() - 10 && suero.getX() < casa.getX() - 10 + casa.getAncho()
				&& suero.getY() + suero.getAlto() / 2 > casa.getY() - casa.getAlto()
				&& suero.getY() + suero.getAlto() / 2 < casa.getY() + casa.getAlto();

	}
	
/////////////////////////////Colision Titan Titan////////////////////////////////////////////////
	
	public static boolean colision(Kyojines titan1, Kyojines titan2, double distancia) {

		return (titan1.getX() - (titan2.getX())) * (titan1.getX() - (titan2.getX()))
				+ (titan1.getY() - (titan2.getY())) * (titan1.getY() - (titan2.getY())) < distancia * distancia;

	}
	
////////////////////////////////Colision Titan Casas/////////////////////////////////////////////
	
	public static boolean colision(Kyojines titan, Casas casa) {

		return titan.getX() > casa.getX() - casa.getAncho() - 10 && titan.getX() < casa.getX() - 10 + casa.getAncho()
				&& titan.getY() + titan.getAlto() / 2 > casa.getY() - casa.getAlto()
				&& titan.getY() + titan.getAlto() / 2 < casa.getY() + casa.getAlto();

	}
	
/////////////////////////////Colision Titan Muralla//////////////////////////////////////////////
	
	public static boolean colision(Kyojines titan, Muralla muralla) {

		return titan.getX() > muralla.getX() - muralla.getAncho() && titan.getX() < muralla.getX() + muralla.getAncho()
				&& titan.getY() + titan.getAlto() / 2 > muralla.getY() - muralla.getAlto() + 23
				&& titan.getY() + titan.getAlto() / 2 < muralla.getY() + muralla.getAlto() + 10;

	}
	
/////////////////////////Colision Titan Proyectil ///////////////////////////////////////////////
	
	public static boolean colision(Proyectil proyectil, Kyojines titan2, double distancia) {

		return (proyectil.getX() - (titan2.getX())) * (proyectil.getX() - (titan2.getX()))
				+ (proyectil.getY() - (titan2.getY())) * (proyectil.getY() - (titan2.getY())) < distancia * distancia;

	}
	
/////////////////////////////Colision Proyectil Casas //////////////////////////////////////////////////
	
	public static boolean colision(Proyectil proyectil, Casas casa) {

		return proyectil.getX() > casa.getX() - casa.getAncho() - 10
				&& proyectil.getX() < casa.getX() - 10 + casa.getAncho()
				&& proyectil.getY() + proyectil.getAlto() / 2 > casa.getY() - casa.getAlto()
				&& proyectil.getY() + proyectil.getAlto() / 2 < casa.getY() + casa.getAlto();

	}
	
//////////////////////////Esta es la colision Muralla - Proyectil/////////////////////////////
	
	public static boolean colision(Proyectil proyectil, Muralla muralla) {

		return proyectil.getX() > muralla.getX() - muralla.getAncho()
				&& proyectil.getX() < muralla.getX() + muralla.getAncho()
				&& proyectil.getY() + proyectil.getAlto() / 2 > muralla.getY() - muralla.getAlto() + 23
				&& proyectil.getY() + proyectil.getAlto() / 2 < muralla.getY() + muralla.getAlto() + 10;
	}
	
///////////////////////////////////////Creacion de Variables/////////////////////////////////////
	
	// El objeto Entorno que controla el tiempo y otros//
	private Entorno entorno;	
	
	//Creacion de clase: Mikasa//
	private Mikasa mikasa;
	
	//Creacion de Titanes en forma de array//
	private Kyojines [] kyojines;
	
	//Creacion de imagen de Fondo//
	private Image fondo;
	
	//Creacion de Muralla, primer obstaculo//
	private Muralla muralla;
	
	//Creacion de Casas//
	private Casas[] casas;
	
	//Creacion de clase suero//
	private Suero suero;  
	private int tiempoSuero; //En este variable se ponen los numeros aletorios, que cuando toca el 7 y no existan sueros se va a activar el suero//
//	private int contSueros;
	
	//Variables de tiempo y ticks
	//Estas dos variables sirven para el random del tiempo de suero son las dos cotas de numero aletorios//
	private int min;  
	private int max;
	
	private int reaparicion; //Tiempo en el que reaparecen los titanes
	
	private int tick; //Esto son los ticks del juego 
	
	//Creacion de Proyectil//
	private Proyectil proyectil;
	private int estadoAtaque;//0 null, 1 en juego
	//Puntaje del Usuario
	private int puntaje;
	//Valores para saber si se esta jugando
	private boolean jugando;
	private boolean gano;
	
	//Creacion de imagen de fin//
	private Image perdiste;
	private Image ganaste;
	
	
	
	public Juego() {
		
		
		this.entorno = new Entorno(this, "Prueba del Entorno", 800, 600); // Inicializa el objeto entorno
		fondo = Herramientas.cargarImagen("fondo.png");
		
		//Creacion de objetos//
		muralla = new Muralla(entorno.ancho() /5+23, entorno.alto()/3);
		mikasa = new Mikasa(entorno.ancho() / 2, entorno.alto() / 2);
		kyojines = new Kyojines[4];
		casas = new Casas[3];
		
		//Variables de control para perder o ganar //
		jugando = true;
		gano = false;
		perdiste = Herramientas.cargarImagen("perdiste.png");
		ganaste = Herramientas.cargarImagen("ganaste.png");
		
		
		//Objetos:Casas// Ubicacion predeterminada
		
		for (int i = 0; i < casas.length; i++) {
			
			if (i == 0) {
				casas[i] = new Casas(600.0, 430.0);
			}
			
			if (i == 1) {
				casas[i] = new Casas(200.0, 400.0);
			}
			
			if (i == 2) {
				casas[i] = new Casas(600.0, 150.0);
			}
		}
		
		
		// Objeto: Kyojines // Se asegura de que el Kyojin no aparezca dentro de un obstaculo
		for(int i = 0; i < kyojines.length; i++) {	
			kyojines[i] = new Kyojines((int)(Math.random()*(entorno.ancho() - 149))+ 100, (int)(Math.random()*(entorno.alto() - 149)) +100);  //(eje X random, eje Y random) Math.random()*(n-m)+m
			if (i > 0) {
				for (int o = 0; o < kyojines.length; o++) {
					if (kyojines[o] != null && o != i) {
						while (colision(kyojines[i], muralla) || colision(kyojines[i], casas[0]) || colision(kyojines[i], casas[1]) //Aca se verifica que el titan no aparezca en las murallas
							  ||colision(kyojines[i], casas[2]) ||colision(kyojines[i],kyojines[o], 120)) {

							kyojines[i] = null;
							kyojines[i] = new Kyojines((int)(Math.random()*(entorno.ancho()-149))+100, (int)(Math.random()*(entorno.alto()-149))+100);
						}
					}
				}
			}
		}
		
		// Objeto: Proyectil //
		estadoAtaque = 0; 
		
		
		// Objeto: Suero //
		tiempoSuero=0;
		this.min=0;
		this.max=50; 
		this.suero=null;

		
		
		//Puntaje de Mikasa//
		
		this.puntaje = 0;
		
		
		//TICKS DEL JUEGO//
		this.tick=0;
		//Variable que sirve para la reaparicion de los titanes 
		this.reaparicion = 0;
		
		// Inicia el juego!
		this.entorno.iniciar();
	}

	/**
	 * Durante el juego, el método tick() será ejecutado en cada instante y 
	 * por lo tanto es el método más importante de esta clase. Aquí se debe 
	 * actualizar el estado interno del juego para simular el paso del tiempo 
	 * (ver el enunciado del TP para mayor detalle).
	 */
	public void tick() {
//////////////Se verifica si el juego termino o no////////////////////////////////
		if (jugando == true) {
///////////////Se resta un tick del tiempo de reaparicion de los titanes//////////////////
			if (this.reaparicion !=0) {
				this.reaparicion = this.reaparicion -1;

			}
			
///////////////////////////////////////////Generador de titanes////////////////////////////////////////
			
			for (int i = 0; i < kyojines.length; i++) {
				if (kyojines[i] == null && reaparicion == 0) {
					kyojines[i] = new Kyojines((int)(Math.random()*(entorno.ancho()-149))+100, (int)(Math.random()*(entorno.alto()-149))+100);  
					
					for (int o = 0; o < kyojines.length; o++) {
						if(kyojines[o] != null && o != i) {
							while (colision(kyojines[i],muralla) || colision(kyojines[i], casas[0]) || colision(kyojines[i], casas[1]) 
								  || colision(kyojines[i], casas[2]) || colision(kyojines[i], kyojines[o], 120)) {
							
								kyojines[i]=null;
								kyojines[i] = new Kyojines((int)(Math.random()*(entorno.ancho()-149))+100, (int)(Math.random()*(entorno.alto()-149))+100);
							}
						}	
					}
				}
			}

	
		
/////////////////////////////////Se dibuja: Imagen de Fondo//////////////////////////////////////////////
		entorno.dibujarImagen(fondo, entorno.ancho() / 2, entorno.alto() / 2, 0);
		
		entorno.cambiarFont("impact", 34, Color.black);
		entorno.escribirTexto("Kyojines muertos: " + puntaje, entorno.ancho() / 2 - 380, entorno.alto() - 25);
		
/////////////////////////////////Se dibuja: Muralla//////////////////////////////////////////////
		muralla.dibujar(entorno);
		
/////////////////////////////////Funciones casas////////////////////////////////////////////////////////
		for (int i = 0; i < casas.length; i++) {
			casas[i].dibujar(entorno);
		}		
		
/////////////////////////////////Se dibuja: Mikasa//////////////////////////////////////////////
		if (mikasa != null) {
		mikasa.dibujar(entorno);
		}	


///////////////////////////////////////Movimiento de Mikasa si no colisiona con nada///////////////////

		if (mikasa != null) {
			if (entorno.estaPresionada('a')) {
				mikasa.girar(mikasa.getVelocidadAngulo());
			}
			
			if (entorno.estaPresionada('d')) {
				mikasa.girar(-mikasa.getVelocidadAngulo());
			}
			
			if (entorno.estaPresionada('w')) {
				mikasa.caminar(this.entorno);
			}
//////////////////////////////////Movimiento del Proyectil////////////////////////////////////////			
			if (entorno.estaPresionada(entorno.TECLA_ESPACIO) && estadoAtaque == 0) {
				proyectil = new Proyectil(mikasa.getX(), mikasa.getY());
				proyectil.definirAngulo(mikasa.getAngulo());
				Herramientas.cargarSonido("proyectil_sound.wav").start();
			}
			
			if (proyectil != null) {
				proyectil.dibujar(entorno);
				estadoAtaque = 1;
			}
			
			if (proyectil != null) {
				proyectil.avanzar(entorno);
				}
				
			if (proyectil != null) {
				if (proyectil.getX() < 0 || proyectil.getX() > entorno.ancho() || proyectil.getY() < 0 || proyectil.getY() > entorno.alto()) {
						proyectil = null;
						estadoAtaque = 0;
				}
			}
		}
		
//////////////////////////////////////////////Movimiento de Mikasa si colisiona con la muralla/////////////////////////////////////////
		
		if (mikasa !=null) {
		if (colision(mikasa,muralla)) {
			
			if (entorno.estaPresionada('a')) {
				mikasa.girar(mikasa.getVelocidadAngulo());
			}
			
			if (entorno.estaPresionada('d')) {
				mikasa.girar(-mikasa.getVelocidadAngulo());
			}
			
			if(entorno.estaPresionada('w')) {
				mikasa.moverInvoluntariamente();

				
			}
			
		}
		}
//////////////////////////////////////Movimiento de Mikasa si colisiona con una casa/////////////////////////////////////
		
		if (mikasa !=null) {
		for (int i = 0; i < casas.length; i++) {
			if (colision(mikasa, casas[i])) {
				
				if (entorno.estaPresionada('a')) {
					mikasa.girar(mikasa.getVelocidadAngulo());
				}
				
				if (entorno.estaPresionada('d')) {
					mikasa.girar(-mikasa.getVelocidadAngulo());
				}
				
				if(entorno.estaPresionada('w')) {
					mikasa.moverInvoluntariamente();

					
				}
		     }
		}
		}
		
		
////////////////////////////Colsion titan muralla/////////////////////////////		
		for (int i = 0; i < kyojines.length; i++) {
			
			if(kyojines[i] != null) {
				
				if(colision(kyojines[i], muralla)) {
					kyojines[i].moverInvoluntariamente();

				}
/////////////////////////////Colision titan casa//////////////////////////////////////					
				for (int o = 0; o < casas.length; o++) {
					if (colision(kyojines[i], casas[o])) {				
						kyojines[i].moverInvoluntariamente();

					}
				}
					
				kyojines[i].dibujar(entorno);
				if (mikasa !=null) {
				kyojines[i].mover(mikasa.getX(), mikasa.getY(),entorno,tick);
				}

			}
			
		}
/////////////////////////////////// Colsiones entre titanes/////////////////////////////////////////////		
		for (int l = 0; l < kyojines.length ; l++) { 						
			for (int k = 0; k < kyojines.length ; k++) {
				
				if(kyojines[l] != null && kyojines[k] != null) {
					if (colision(kyojines[l], kyojines[k], 50) && l != k ) {
						if(cuadrante(kyojines[k], kyojines[l]) == 1) {
							kyojines[k].moverInvoluntariamenteEsp(-1);
							kyojines[l].seguirRitmo();	
						}
						if(cuadrante(kyojines[k], kyojines[l]) == 2) {
							kyojines[k].moverInvoluntariamenteXEsp(-1);
							kyojines[k].moverInvoluntariamenteYEsp(1);
							kyojines[l].seguirRitmo();	
						}
						if(cuadrante(kyojines[k], kyojines[l]) == 3) {
							kyojines[k].moverInvoluntariamenteEsp(1);
							kyojines[l].seguirRitmo();
						}
						if(cuadrante(kyojines[k], kyojines[l]) == 4) {
							kyojines[k].moverInvoluntariamenteYEsp(-1);
							kyojines[k].moverInvoluntariamenteXEsp(1);
							kyojines[l].seguirRitmo();	
						}
					}
				}
			}
		}
		
		
		
/////////////////////////////////////Funcion Suero/////////////////////////////////////////////
		
		//En este momento se van a guardar en este variable numeros aletorias dentro del min y max 
		this.tiempoSuero=(int)(Math.random()*(max-this.min+1))+this.min;
		
		//Aca verifico que el suero no existe (o sea es null) y que el numero aletorio sea 7 
		if (this.tiempoSuero == 7 && suero == null) {
			suero= new Suero(entorno.ancho(), entorno.alto(), tick);   //Aca se crea el suero en caso de que el suero no existas y el valor aletoro es 7
			
			// En el while me fijo que el suero no se cree arriba de obstaculos
			while (colision(suero,muralla) || colision(suero,casas[0]) || colision(suero,casas[1]) || colision(suero,casas[2])) {
				suero=null;
				suero= new Suero(entorno.ancho(),entorno.alto(),tick);
			}
		}
			
		
////////////////////////////////////////Colision Mikasa con Suero y mikasa modo titan////////////////////////////////////
		
		if (mikasa != null && suero != null && colision(mikasa,suero,45)) {

				suero = null;
				mikasa.mikasaTiempoInmortal(tick);
			}
///////////////////////////Verifica si Mikasa es titan o no////////////////////////////////		
		if (mikasa != null) {
			if(mikasa.getTiempoTitan() > tick) {
				mikasa.mikasaInmortal();

			} else {
				mikasa.mikasaMortal();	 
			}
		}
		
		
/////////////////////Aca lo que hago es verificar que el suero existe y que el tiempo del suero ya termino////////////////////////////////
		if (suero != null && suero.getTiempoMax() < tick) {
				suero=null;	//Elimino el suero actual	
				}
				
///////////////////////Aca se dibuja el suero////////////////////////////////////////////////////
		if (suero!=null) {
					suero.dibujar(entorno);
				}
		
				


				
		
////////////////////////////////////Colision Proyectil con Titan/////////////////////////////////////
		
		for (int i = 0; i < kyojines.length; i++) {
			if(proyectil != null && kyojines[i] != null) {
				if (colision(proyectil, kyojines[i], 30)) {

					proyectil = null;
					kyojines[i] = null;
					estadoAtaque = 0;
					puntaje += 1;
					if ( this.reaparicion == 0) {
						this.reaparicion = 1000;
					}
				}
			}
			
		}
////////////////////////////////Colision Bala Casas//////////////////////////////////////////////////
		
		for (int i = 0; i < casas.length; i++) {
			if(proyectil != null ) {
				if (colision(proyectil, casas[i])) {
					proyectil=null;
					estadoAtaque = 0;
				}
			}
			
		}
////////////////////////////////Colision Bala Muralla//////////////////////////////////////////////////
		
			if (proyectil != null) {
				if (colision(proyectil, muralla)) {
					
					proyectil = null;
					estadoAtaque = 0;
				}
			}


////////////////////////////////////Colision Mikasa y titan/////////////////////////////////////
			for (int i = 0; i < kyojines.length; i++) {
				if(mikasa != null && kyojines[i] != null && colision(kyojines[i], mikasa, 30)) {
					if (mikasa.isModoTitan()) {
						kyojines[i] = null;
						puntaje += 1;
						if ( this.reaparicion == 0) {
							this.reaparicion = 1000;
						}
						mikasa.mikasaTiempoInmortal(-500);
					} else {
						mikasa = null;
						jugando = false;
					}
				}
			}
			
			tick ++;
///////////////////////////////Termina el juego Si gana//////////////////////////////////			
			for (int i = 0; i < kyojines.length; i++) {
				if (kyojines[i] == null) {
					if (i+1 == kyojines.length ) {
						jugando = false;
						gano = true;
					}
			}else {
				return;
				}
			}
			
			
			
			}
			
/////////////////////////////////////////Pantallas de ganaste o perdiste/////////////////////////////////
			if (jugando ==false && gano == true) {
				entorno.dibujarImagen(ganaste, entorno.ancho() / 2, entorno.alto() / 2, 0, 1);
			}
			if (jugando ==false && gano == false) {
				entorno.dibujarImagen(perdiste, entorno.ancho() / 2, entorno.alto() / 2, 0, 1);
			}
		
}
		
		

	
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Juego juego = new Juego();
	}

}