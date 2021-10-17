public class Soldado {
	private String nombre;
	private int fila;
	private int columna;
	private int puntosVida;

	public Soldado(String n, int f, int c, int p) {
		setNombre(n);
		setFila(f);
		setColumna(c);
		setPuntos(p);
	}

	public void setNombre(String n) {
		nombre = n;
	}

	public void setFila(int f) {
		fila = f;
	}

	public void setColumna(int c) {
		columna = c;
	}

	public void setPuntos(int p) {
		puntosVida = p;
	}

	// Metodos accesores
	public String getNombre() {
		return nombre;
	}

	public int getFila() {
		return fila;
	}

	public int getColumna() {
		return columna;
	}

	public int getPuntos() {
		return puntosVida;
	}

	public void mostrarSoldado() {
		System.out.println("Nombre: " + nombre);
		System.out.println("Fila: " + fila);
		System.out.println("Columna: " + columna);
		System.out.println("Puntos de vida: " + puntosVida);
		System.out.print("\n");
	}
}