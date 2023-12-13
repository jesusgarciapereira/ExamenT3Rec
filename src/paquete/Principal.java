package paquete;

import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		// Activamos el Scanner
		Scanner sc = new Scanner(System.in);

		// Variable con la dirección de movimiento que le pediremos al usuario
		String direccion;

		// Variable int para indicar si un movimiento es posible, se sale del tablero o
		// es una cadena errónea
		int movPosible;

		// Generamos la posición en la que se encuentra el tesoro
		Funciones.generaPosicionTesoro();

		// Creamos el objeto jugador
		Funciones jugador = new Funciones();

		// Presentamos el juego
		System.out.println("BIENVENIDO AL JUEGO DE LA BÚSQUEDA DEL TESORO");

		// Mientras no encontremos el tesoro, ejecutará las siguientes instrucciones
		while (!jugador.buscaTesoro()) {

			// Pintamos el tablero con la posición del jugador
			jugador.pintaTablero();

			// Bloque de instrucciones que se ejecutará, al menos, una vez
			do {
				// Preguntamos al usuario adónde quiere moverse
				System.out.println("¿Hacia dónde quiere moverse: ARRIBA, ABAJO, IZQUIERDA, DERECHA?");
				// Leemos el valor y se lo asignamos a la variable dirección
				direccion = sc.nextLine();

				// Asignamos a la variable int del movimiento posible el valor devuelto por la
				// función mueveJugador() con la cadena introducida por el usuario como
				// parámetro
				movPosible = jugador.mueveJugador(direccion);

				// Según cada caso del movimiento posible tendremos las siguientes instrucciones
				switch (movPosible) {

				// Si es -1
				case -1:
					// Mostramos el mensaje de que el movimiento se sale de los límites del tablero
					System.out.println("Este movimiento no está dentro de los límites del tablero");
					break;
				// Si es -1
				case -2:
					// Mostramos el mensaje de que no es correcta la cadena introducida
					System.out.println("Lo siento, pero no entiendo ese movimiento");
					break;
				}
			} while (movPosible != 0);// Si es 0 nos saldemos del bloque de instrucciones del do
		} // Repetimos las instrucciones desde el primer while si no encontramos el tesoro

		// Mensaje para cuando encontramos el tesoro
		System.out.println("¡ENHORABUENA! Ha encontrado el tesoro =D");

		// Cerramos el Scanner
		sc.close();
	}

}
