public static int buscar(int[] vector, int num) {
	int inicio = 0;
	int fin = vector.length - 1;

	while (inicio <= fin) {
		int medio = (inicio + fin) / 2;
		if (vector[medio] < num)
			inicio = medio + 1; 		// Examinar mitad derecha
		else if (vector[medio] > num)
			fin = medio - 1; 		// Examinar mitad izquierda
		else 					// Encontrado
			return medio;
	}
	return -1; // No está
}