package primerProyecto;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Ej3 {

	private static void ordenar(int[] array, int guardados, int val) {

		int pos = guardados;

		while (pos > 0 && array[pos - 1] > val) {

			array[pos] = array[pos - 1];
			pos--;

		}

		array[pos] = val;

	}

	private static int leerInt(BufferedReader bR, String msg) throws IOException {

		while (true) {

			System.out.printf(msg);
			String l = bR.readLine();

			if (l == null) {

				throw new IOException("Fin de entrada de texto inesperado");

			}

			try {

				return Integer.parseInt(l);

			} catch (NumberFormatException e) {

				System.err.println("Error: Introduce un valor válido.");

			}

		}

	}

	private static String msgC(int i) {

		return String.format("Número %d: ", i);

	}

	private static final int N = 5;

	public static void main(String[] args) {

		try (BufferedReader bR = new BufferedReader(new InputStreamReader(System.in))) {

			int[] array = new int[N * 2];
			int guardados = 0;

			System.out.printf("Introduce %d números enteros, los ordeno aunque no los metas ordenados\n", N);
			for (int i = 0; i < N; i++) {

				int val = leerInt(bR, msgC(i + 1));

				ordenar(array, guardados, val);
				guardados++;

			}

			System.out.printf("Introduce otros %d números enteros y yo te los ordeno de manera ascendente: \n", N);
			for (int i = 0; i < array.length / 2; i++) {

				int val = leerInt(bR, msgC(i + N + 1));

				ordenar(array, guardados, val);
				guardados++;

			}

			System.out.printf("Array ordenado: ");
			for (int i = 0; i < guardados; i++) {

				System.out.printf("%d ", array[i]);

			}

		} catch (IOException e) {
		}

	}

}
