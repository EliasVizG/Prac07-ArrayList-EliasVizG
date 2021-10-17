
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class VideoJuego3 {
	static Random rd = new Random();
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		ArrayList<ArrayList<Soldado>> ejercito1 = new ArrayList<ArrayList<Soldado>>();
		for (int i = 0; i < 10; i++) {
			ejercito1.add(new ArrayList<Soldado>());
			for (int j = 0; j < 10; j++)
				ejercito1.get(i).add(null);
		}
		int n = rd.nextInt(10) + 1;
		for (int i = 0; i < n; i++) {
			String nombre = "Soldado1x" + (i + 1);
			int fila = rd.nextInt(10), columna = rd.nextInt(10), puntosVida = rd.nextInt(10) + 1;
			try {
				ejercito1.get(fila).get(columna);
			} catch (Exception e) {
				ejercito1.get(fila).set(columna, new Soldado(nombre, fila, columna, puntosVida));
				continue;
			}
			i--;
		}
		ArrayList<ArrayList<Soldado>> ejercito2 = new ArrayList<ArrayList<Soldado>>();
		for (int i = 0; i < 10; i++) {
			ejercito2.add(new ArrayList<Soldado>());
			for (int j = 0; j < 10; j++) {
				ejercito2.get(i).add(null);
			}
		}
		n = rd.nextInt(10) + 1;
		for (int i = 0; i < n; i++) {
			String nombre = "Soldado" + (i + 1);
			int fila = rd.nextInt(10), columna = rd.nextInt(10), puntosVida = rd.nextInt(10) + 1;
			if (ejercito2.get(fila).get(columna) == null)
				ejercito2.get(fila).set(columna, new Soldado(nombre, fila, columna, puntosVida));
			else
				i--;
			continue;
		}
		mostrarTablero(ejercito1);
		mostrarSoldadoMayorVida(ejercito1);
		mostrarPromedioPuntosVida(ejercito1);
		mostrarVidaTotal(ejercito1);
		mostrarEjercito(OrdenamientoNombreBurbuja(ejercito1));
		System.out.println("MOSTRANDO ORDENAMIENTO BURBUJAS");
		mostrarEjercito(OrdenamientoPuntosBurbuja(ejercito1));
		System.out.println("MOSTRANDO ORDENAMIENTO SELECCION");
		mostrarEjercito(OrdenamientoPuntosSeleccion(ejercito1));
	}

	public static ArrayList<ArrayList<Soldado>> mezclarEjercitos(ArrayList<ArrayList<Soldado>> ejercito1,
			ArrayList<ArrayList<Soldado>> ejercito2) {
		ArrayList<ArrayList<Soldado>> ejercitos = new ArrayList<ArrayList<Soldado>>();
		for (int i = 0; i < 10; i++)
			ejercitos.add(new ArrayList<Soldado>());
		for (int i = 0; i < ejercito1.size(); i++) {
			for (int j = 0; j < ejercito1.get(i).size(); j++) {
				ejercitos.get(i).set(j, ejercito1.get(i).get(j));
			}
		}
		for (int i = 0; i < ejercito2.size(); i++) {
			for (int j = 0; j < ejercito2.get(i).size(); j++) {
				ejercitos.get(i).set(j, ejercito2.get(i).get(j));
			}
		}
		return ejercitos;
	}

	public static void mostrarTablero(ArrayList<ArrayList<Soldado>> ejercito) {
		for (int i = 0; i < ejercito.size(); i++) {
			for (int j = 0; j < ejercito.get(i).size(); j++) {
				if (ejercito.get(i).get(j) != null)
					System.out.print("[   " + ejercito.get(i).get(j).getNombre() + "\t]");
				else
					System.out.print("[\t\t]");
			}
			System.out.println();
		}
		System.out.println();
	}

	public static void mostrarSoldadoMayorVida(ArrayList<ArrayList<Soldado>> ejercito) {
		System.out.println(">>Soldado con mayor vida:<<");
		int max = 0;
		for (int i = 0; i < ejercito.size(); i++) {
			for (int j = 0; j < ejercito.get(i).size(); j++) {
				if (ejercito.get(i).get(j).getPuntos() > max)
					max = ejercito.get(i).get(j).getPuntos();
			}
		}
		for (int i = 0; i < ejercito.size(); i++) {
			for (int j = 0; j < ejercito.get(i).size(); j++) {
				if (ejercito.get(i).get(j).getPuntos() == max)
					ejercito.get(i).get(j).mostrarSoldado();
			}
		}
		System.out.println();
	}

	public static void mostrarPromedioPuntosVida(ArrayList<ArrayList<Soldado>> ejercito) {
		int suma = 0;
		int conteo = 0;
		for (int i = 0; i < ejercito.size(); i++) {
			for (int j = 0; j < ejercito.get(i).size(); j++) {
				suma += ejercito.get(i).get(j).getPuntos();
				conteo++;
			}
		}
		double promedioTotal = 1.0 * suma / conteo;
		System.out.println(">>Promedio de puntos de vida: " + promedioTotal);
		System.out.println();
	}

	public static void mostrarVidaTotal(ArrayList<ArrayList<Soldado>> ejercito) {
		int suma = 0;
		for (int i = 0; i < ejercito.size(); i++) {
			for (int j = 0; j < ejercito.get(i).size(); j++) {
				suma += ejercito.get(i).get(j).getPuntos();
			}
		}
		System.out.println(">>Vida total del Ejercito: " + suma);
		System.out.println();
	}

	public static void mostrarEjercito(ArrayList<Soldado> ejercito) {
		System.out.println(">>Mostrando Soldados... ");
		for (int i = 0; i < ejercito.size(); i++) {
			ejercito.get(i).mostrarSoldado();
		}
		System.out.println();
	}

	public static ArrayList<Soldado> OrdenamientoNombreBurbuja(ArrayList<ArrayList<Soldado>> ejercito) {
		ArrayList<Soldado> copia0 = new ArrayList<Soldado>();
		int n = 0;
		for (int i = 0; i < ejercito.size(); i++) {
			for (int j = 0; j < ejercito.get(i).size(); j++) {
				copia0.add(ejercito.get(i).get(j));
				n++;
			}
		}
		int tamaño = copia0.size();
		int fin = tamaño - 1; //
		boolean sorted = false;
		for (int i = 0; i < tamaño - 1 && !sorted; i++) {
			sorted = true; // if you never execute a swap, the list is already sorted
			for (int j = 0; j < fin; j++) {
				Soldado s1 = copia0.get(j);
				Soldado s2 = copia0.get(j + 1);
				if (s1.getNombre().compareTo(s2.getNombre()) < 0) {
					sorted = false;
					copia0.remove(j);
					copia0.add(j + 1, s1);
				}
			}
			fin--;
		}
		return copia0;
	}

	public static ArrayList<Soldado> OrdenamientoPuntosBurbuja(ArrayList<ArrayList<Soldado>> ejercito) {
		ArrayList<Soldado> copia1 = new ArrayList<Soldado>();
		int n = 0;
		for (int i = 0; i < ejercito.size(); i++) {
			for (int j = 0; j < ejercito.get(i).size(); j++) {
				copia1.add(ejercito.get(i).get(j));
				n++;
			}
		}
		int tamaño = copia1.size();
		int fin = tamaño - 1; //
		boolean sorted = false;
		for (int i = 0; i < tamaño - 1 && !sorted; i++) {
			sorted = true; // if you never execute a swap, the list is already sorted
			for (int j = 0; j < fin; j++) {
				Soldado s1 = copia1.get(j);
				Soldado s2 = copia1.get(j + 1);
				if (s1.getPuntos() > s2.getPuntos()) {
					sorted = false;
					copia1.remove(j);
					copia1.add(j + 1, s1);
				}
			}
			fin--;
		}
		return copia1;
	}

	public static ArrayList<Soldado> OrdenamientoPuntosSeleccion(ArrayList<ArrayList<Soldado>> ejercito) {
		ArrayList<Soldado> copia1 = new ArrayList<Soldado>();
		int n = 0;
		for (int i = 0; i < ejercito.size(); i++) {
			for (int j = 0; j < ejercito.get(i).size(); j++) {
				copia1.add(ejercito.get(i).get(j));
				n++;
			}
		}
		for (int i = 0; i < n - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < n; j++)
				if (copia1.get(j).getPuntos() < copia1.get(minIndex).getPuntos())
					minIndex = j;
			Soldado temp = copia1.get(minIndex);
			copia1.set(minIndex, copia1.get(i));
			copia1.set(i, temp);
		}
		return copia1;
	}
}