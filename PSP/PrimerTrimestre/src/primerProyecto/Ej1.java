package primerProyecto;

import java.util.ArrayList;
import java.util.Scanner;

public class Ej1 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> numeros = new ArrayList<>();
		
		System.out.print("¿Cuantos números quieres introducir? ");
		int x = sc.nextInt();
		
		System.out.print("Introduce " + x + " números: ");
		
		for (int i = 0; i < x; i++) {
			
			numeros.add(sc.nextInt());
			if (i < (x-1)) {
				System.out.print("Introduce el siguiente número: ");
			}
			
		}
		
		System.out.println("------------------------------------");
		
		System.out.println("Números introducidos en orden de introducción: ");
		for (Integer i : numeros) {
			System.out.print(i.toString() + " ");
		}
		
		sc.close();
		
	}

}
