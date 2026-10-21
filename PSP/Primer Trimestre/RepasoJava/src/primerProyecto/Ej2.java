package primerProyecto;

public class Ej2 {

	public static void main(String[] args) {

		int tA[] = { 1, 3, 5, 7, 9, 11, 13, 15, 17, 19 };
		int tB[] = { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20 };
		int tC[] = new int[tA.length + tB.length];
		
		for (int i = 0; i < tC.length; i++) {
			
				tC[i] = (i % 2 == 0) ? tA[i / 2] : tB[i / 2];
				System.out.print("Posición " + (i + 1) + ": " + tC[i] + "\n");
				
		}
			 
			
	}

}
