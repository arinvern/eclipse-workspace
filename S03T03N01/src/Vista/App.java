package Vista;

import java.util.ArrayList;
import java.util.Scanner;

import Persistencia.Persistencia;
import entidades.Floristeria;
import entidades.Producto;
import entidades.Arbol;
import entidades.Flor;
import entidades.Decoracion;
import entidades.Ticket;

public class App {
	

	public static void main(String[] args) {

		Persistencia persistencia = new Persistencia();
		Floristeria floristeria = null;

		int opcio = pedirInt("Si vols crear floristeria escriu 1, si vols carregar floristeria escriu 2.");
		if (opcio == 1) {
			floristeria = new Floristeria("Floristeria Jacinto");
		} else if (opcio == 2) {
			floristeria = persistencia.cargarFloristeria();
		} else {
			System.out.println("error, escriu 1 o 2");
		}
		;

		boolean salir = false;
		while (!salir) {
			System.out.println("Selecciona una opció:");
			System.out.println("1. Afegir Arbre");
			System.out.println("2. Afegir Flor");
			System.out.println("3. Afegir Decoració");
			System.out.println("4. Stock");
			System.out.println("5. Retirar arbre");
			System.out.println("6. Retirar flor");
			System.out.println("7. Retirar decoració");
			System.out.println("8. Imprimir stock amb quantitats");
			System.out.println("9. Imprimir valor total de la floristeria");
			System.out.println("10. Crear tickets de compra");
			System.out.println("11. Mostrar llista de compres antigues");
			System.out.println("12. Visualitzar el total de diners guanyats");
			System.out.println("0. Salir");
			int opcion = pedirInt("Escull una opció del menú:");
			switch (opcion) {
			case 0:
				System.out.println("Sortint del menú");
				salir = true;
				break;
			case 1:
				afegirArbre(floristeria);
				Persistencia.guardarFloristeria(floristeria);
				break;
			case 2:
				afegirFlor(floristeria);
				Persistencia.guardarFloristeria(floristeria);
				break;
			case 3:
				afegirDecoracio(floristeria);
				Persistencia.guardarFloristeria(floristeria);
				break;
			case 4:
				floristeria.imprimirStock();
				continuarTecla();
				break;
			case 5:
				String nom = pedirString("Introdueix el nom de l'arbre a eliminar");
				int quantitat = pedirInt("Introdueix la quantitat a eliminar");
				retirarArbre(floristeria, nom, quantitat);
				break;
			case 6:
				nom = pedirString("Introdueix el nom de la flor a eliminar");
				quantitat = pedirInt("Introdueix la quantitat a eliminar");
				retirarFlor(floristeria, nom, quantitat);
				break;
			case 7:
				nom = pedirString("Introdueix el nom de la decoracio a eliminar");
				quantitat = pedirInt("Introdueix la quantitat a eliminar");
				retirarDecoracio(floristeria, nom, quantitat);
				break;
			case 8:
				floristeria.imprimirCantidadStock();
				continuarTecla();
				break;
			case 9:
				floristeria.imprimirValorTotalStock();
				continuarTecla();
				break;
			case 10:
				ArrayList<Producto> productesSeleccionats = seleccionarProductes(floristeria);
				crearTicket(productesSeleccionats, floristeria);
				Persistencia.guardarFloristeria(floristeria);
				break;
			case 11:
				mostrarTicketsAntiguos(floristeria);
				continuarTecla();
				break;
			case 12:
				System.out.println(calcularTotalVentas(floristeria));
				continuarTecla();
				break;
			default:
				System.out.println("Opció no vàlida");
				break;
			}
		}

	}

	private static void continuarTecla() {
		Scanner a = new Scanner(System.in);
		System.out.println("pulsa qualsevol tecla per continuar");
		a.nextLine();
	}

	private static Floristeria crearFloristeria() {

		Floristeria floristeria = new Floristeria("Floristeria");
		return floristeria;
	}

	public static void afegirArbre(Floristeria floristeria) {
		String nom = pedirString("Nom de l'arbre: ");
		double preu = pedirDouble("Preu de l'arbre: ");
		int quantitat = pedirInt("Quantitat: ");
		double altura = pedirDouble("Alçada de l'arbre: ");
		Arbol arbol = new Arbol(nom, preu, quantitat, altura);
		floristeria.addArbol(arbol);
		System.out.println("S'ha afegit l'arbre " + nom + " correctament.");
	}

	public static void afegirFlor(Floristeria floristeria) {
		String nom = pedirString("Nom de la flor: ");
		double preu = pedirDouble("Preu de la flor: ");
		int quantitat = pedirInt("Quantitat: ");
		String color = pedirString("Color de la flor: ");
		Flor flor = new Flor(nom, preu, quantitat, color);
		floristeria.addFlor(flor);
		System.out.println("S'ha afegit la flor " + nom + " correctament.");
	}

	public static void afegirDecoracio(Floristeria floristeria) {
		String nom = pedirString("Nom de la decoració: ");
		double preu = pedirDouble("Preu de la decoració: ");
		int quantitat = pedirInt("Quantitat: ");
		String material = pedirString("Material (fusta/plastic): ");

		if (material.equals("fusta") || material.equals("plastic")) {
			Decoracion decoracion = new Decoracion(nom, preu, quantitat, material);
			floristeria.addDecoracion(decoracion);
			System.out.println("S'ha afegit la decoració " + nom + " correctament.");
		} else {
			System.out.println("El material ha de ser 'fusta' o 'plastic'. No s'ha pogut afegir la decoració.");
		}
	}

	public static ArrayList<Producto> seleccionarProductes(Floristeria floristeria) {
		ArrayList<Producto> productosSeleccionados = new ArrayList<>();
		ArrayList<Producto> productosEnStock = new ArrayList<>();
		productosEnStock.addAll(floristeria.getStockArboles());
		productosEnStock.addAll(floristeria.getStockFlores());
		productosEnStock.addAll(floristeria.getStockDecoraciones());

		Scanner scanner = new Scanner(System.in);
		boolean seguirSeleccionando = true;
		while (seguirSeleccionando) {

			System.out.println("Productes en stock:");
			for (int i = 0; i < productosEnStock.size(); i++) {
				System.out.println(i + 1 + ". " + productosEnStock.get(i));
			}

			System.out.println("Seleccioni un producte o escriu 'sortir' per terminar la selecció:");
			String seleccion = scanner.nextLine();
			System.out.println("Producte afegit, afegeix un altre o escriu 'sortir' per terminar la selecció:");

			if (seleccion.equals("sortir")) {
				seguirSeleccionando = false;
				System.out.println("Ticket creat.");
			} else {

				int seleccionNum = -1;
				try {
					seleccionNum = Integer.parseInt(seleccion);
				} catch (NumberFormatException e) {

				}

				if (seleccionNum > 0 && seleccionNum <= productosEnStock.size()) {
					productosSeleccionados.add(productosEnStock.get(seleccionNum - 1));

					if (productosEnStock.get(seleccionNum - 1) instanceof Arbol) {
						floristeria.restarArbol((Arbol) productosEnStock.get(seleccionNum - 1), 1);
					}
					if (productosEnStock.get(seleccionNum - 1) instanceof Flor) {
						floristeria.restarFlor((Flor) productosEnStock.get(seleccionNum - 1), 1);
					}
					if (productosEnStock.get(seleccionNum - 1) instanceof Decoracion) {
						floristeria.restarDecoracion((Decoracion) productosEnStock.get(seleccionNum - 1), 1);
					}

				} else {
					System.out.println("Selecció no vàlida.");
				}
			}
		}
		return productosSeleccionados;
	}

	public static Ticket crearTicket(ArrayList<Producto> productosSeleccionados, Floristeria floristeria) {
		if (productosSeleccionados.isEmpty()) {
			System.out.println("No es pot crear un ticket sense productes.");

		}
		int idTicket = floristeria.getTickets().size() + 1;
		Ticket ticket = new Ticket(idTicket, productosSeleccionados);
		floristeria.getTickets().add(ticket);
		System.out.println("S'ha creat un nou ticket de compra:\n");
		return ticket;
	}

	public static void mostrarTicketsAntiguos(Floristeria floristeria) {

		if (floristeria.getTickets() != null) {
			for (Ticket ticket : floristeria.getTickets()) {
				System.out.println(ticket.toString());
			}
		} else {
			System.out.println("No hi ha tickets antics");
		}
	}

	public static double calcularTotalVentas(Floristeria floristeria) {
		double totalVentas = 0.0;
		for (Ticket t : floristeria.getTickets()) {
			totalVentas += t.getTotal();
		}
		return totalVentas;
	}

	public static void retirarArbre(Floristeria floristeria, String nombreArbol, int cantidad) {
		for (Arbol arbol : floristeria.getStockArboles()) {
			if (arbol.getNombre().equals(nombreArbol)) {
				if (arbol.getCantidad() >= cantidad) {
					arbol.restarCantidad(cantidad);
					System.out.println(cantidad + " " + nombreArbol + "(s) retirats del stock.");
				} else {
					System.out.println("No hi ha suficient " + nombreArbol + " en stock.");
				}
				return;
			}
		}
		System.out.println("No s'ha trobat cap " + nombreArbol + " en el stock.");
	}
	
	public static void retirarFlor(Floristeria floristeria, String nombreFlor, int cantidad) {
		for (Flor flor : floristeria.getStockFlores()) {
			if (flor.getNombre().equals(nombreFlor)) {
				if (flor.getCantidad() >= cantidad) {
					flor.restarCantidad(cantidad);
					System.out.println(cantidad + " " + nombreFlor + "(s) retirats del stock.");
				} else {
					System.out.println("No hi ha suficient " + nombreFlor + " en stock.");
				}
				return;
			}
		}
		System.out.println("No s'ha trobat cap " + nombreFlor + " en el stock.");
	}
	
	public static void retirarDecoracio(Floristeria floristeria, String nombreDecoracion, int cantidad) {
		for (Decoracion decoracion : floristeria.getStockDecoraciones()) {
			if (decoracion.getNombre().equals(nombreDecoracion)) {
				if (decoracion.getCantidad() >= cantidad) {
					decoracion.restarCantidad(cantidad);
					System.out.println(cantidad + " " + nombreDecoracion + "(s) retirats del stock.");
				} else {
					System.out.println("No hi ha suficient " + nombreDecoracion + " en stock.");
				}
				return;
			}
		}
		System.out.println("No s'ha trobat cap " + nombreDecoracion + " en el stock.");
	}
	

	public static String pedirString(String mensaje) {
		Scanner sc = new Scanner(System.in);
		System.out.print(mensaje);
		return sc.nextLine();
	}

	public static int pedirInt(String mensaje) {
		Scanner sc = new Scanner(System.in);
		System.out.print(mensaje);
		return sc.nextInt();
	}

	public static double pedirDouble(String mensaje) {
		Scanner sc = new Scanner(System.in);
		System.out.print(mensaje);
		return sc.nextDouble();
	}
}
