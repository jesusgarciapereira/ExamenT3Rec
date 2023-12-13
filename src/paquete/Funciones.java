package paquete;

import java.util.Random;

public class Funciones {

	// Constante que indica el tamaño del tablero
	static final int TAM_TABLERO = 5;

	// Atributo que indica la coordenada X en donde está el tesoro
	static int xTesoro;
	// Atributo que indica la coordenada Y en donde está el tesoro
	static int yTesoro;
	// Atributo que indica la coordenada X en donde está el jugador
	// Inicializada en 1
	int xJugador = 1;
	// Atributo que indica la coordenada Y en donde está el jugador
	// Inicializada en 1
	int yJugador = 1;

	// ENTRADA: Nada
	// SALIDA: Nada
	// FUNCIONALIDAD: Genera numeros aleatorios y los asigna a las posiciones X e Y
	// del tesoro
	public static void generaPosicionTesoro() {
		// Creamos un objeto de tipo Random
		Random r = new Random();
		// Generamos dos números aleatorios entre 1 y el valor de la constante del
		// tamaño del tablero y los asignamos a los atributos de la posición del tesoro
		xTesoro = r.nextInt(1, TAM_TABLERO + 1);
		yTesoro = r.nextInt(1, TAM_TABLERO + 1);
	}

	// ENTRADA: Nada
	// SALIDA: Nada
	// FUNCIONALIDAD: Pinta el tablero con la posición del jugador
	public void pintaTablero() {

		// La "fila 0" muestra los números del 1 hasta el valor de la constante del
		// tamaño del tablero
		// precedidos por un tabulador
		for (int i = 1; i <= TAM_TABLERO; i++) {
			System.out.print("\t" + i);
		}
		// Salto de línea
		System.out.println();

		// Las siguientes filas (tantas como el tamaño del tablero) muestran siempre el
		// valor de su fila correspondiente
		for (int i = 1; i <= TAM_TABLERO; i++) {
			System.out.print(i);
			// Si el número de la fila coincide con la posición X del jugador
			if (i == xJugador) {
				// En dicha fila se imprimirán también tantos tabuladores igual al valor de la
				// posición Y del jugador
				for (int j = 1; j <= yJugador; j++) {
					System.out.print("\t");
				}
				// Y finalmente se imprimirá el símbolo que representa al jugador
				System.out.print("J");
			}
			// Salto de línea
			System.out.println();
		}

	}

	// ENTRADA: String
	// SALIDA: int
	// FUNCIONALIDAD: Toma el parámetro de entrada y en función de su valor modifica
	// o no los atributos de las coordenadas X e Y del jugador y devuelve un valor
	// entero según la situación del jugador en el tablero
	public int mueveJugador(String movimiento) {
		// Creamos la variable del valor que tendrá el movimiento, será 0 si el
		// movimiento es posible
		int valorMovimiento = 0;

		// Según cada caso del atributo (en mayúsculas o en minúsculas) tendremos las
		// siguientes instrucciones
		switch (movimiento.toLowerCase()) {
		// Si el parámetro es "arriba"
		case "arriba":
			// Si al restarle 1 a la cordenada X del jugador es menor que 1
			if (xJugador - 1 < 1)
				// La variable pasará a ser -1 porque el movimiento no es posible
				valorMovimiento = -1;
			// En caso contrario decrementa en 1 la cordenada X del jugador
			else
				xJugador--;
			break;
		// Si el parámetro es "abajo"
		case "abajo":
			// Si al sumarle 1 a la cordenada X del jugador es mayor que la constante del
			// tamaño del tablero
			if (xJugador + 1 > TAM_TABLERO)
				// La variable pasará a ser -1 porque el movimiento no es posible
				valorMovimiento = -1;
			// En caso contrario incrementa en 1 la cordenada X del jugador
			else
				xJugador++;
			break;
		// Si el parámetro es "derecha"
		case "derecha":
			// Si al sumarle 1 a la cordenada Y del jugador es mayor que la constante del
			// tamaño del tablero
			if (yJugador + 1 > TAM_TABLERO)
				// La variable pasará a ser -1 porque el movimiento no es posible
				valorMovimiento = -1;
			else
				// En caso contrario incrementa en 1 la cordenada Y del jugador
				yJugador++;
			break;
		// Si el parámetro es "izquierda"
		case "izquierda":
			// Si al restarle 1 a la cordenada Y del jugador es menor que 1
			if (yJugador - 1 < 1)
				// La variable pasará a ser -1 porque el movimiento no es posible
				valorMovimiento = -1;
			else
				// En caso contrario decrementa en 1 la cordenada Y del jugador
				yJugador--;
			break;
		// Si el parámetro es qualquier otro String
		default:
			// La variable pasará a ser -2 porque la cadena introducida no es válida
			valorMovimiento = -2;
			break;
		}

		// Devolverá 0 si el movimiento es posible, -1 si el movimiento no es posible o
		// -2 si la cadena introducida no es válida
		return valorMovimiento;
	}

	// ENTRADA: Nada
	// SALIDA: boolean
	// FUNCIONALIDAD: Te indica si el jugador está en la misma posición que el
	// tesoro
	public boolean buscaTesoro() {

		// Creamos la variable que indicará si hemos encontrado el tesoro, inicializada
		// como false
		boolean tesoroEncontrado = false;

		// Pero cambiará a true si las cordenadas X e Y del jugador y del tesoro son las
		// mismas
		if (xTesoro == xJugador && yTesoro == yJugador)
			tesoroEncontrado = true;

		// Devolverá true o false según si hemos encontrado el tesoro o no
		return tesoroEncontrado;
	}
}
