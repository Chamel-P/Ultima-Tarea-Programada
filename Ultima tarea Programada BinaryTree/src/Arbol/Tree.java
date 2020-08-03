package Arbol;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import steve.ac.cr.help.Help;
import steve.ac.cr.persona.Personas;

public class Tree {
	private NodeTree Raiz;
	Help H = new Help();
	Scanner input = new Scanner(System.in);
	private boolean dato = false;

	public Tree() {
		Raiz = null;
	}

	public void IngresarPersona(Personas persona) {
		NodeTree nuevoNodo = new NodeTree();
		nuevoNodo.data = persona;
		if (Raiz == null)
			Raiz = nuevoNodo;
		else {
			int orden = persona.getFecha_Nacimiento().compareTo(Raiz.data.getFecha_Nacimiento());
			if (orden > 0)
				H.IngresarIzquierda(Raiz, nuevoNodo);
			else if (orden == 0)
				if (Integer.parseInt(persona.getCedula()) < Integer.parseInt(Raiz.data.getCedula()))
					H.IngresarDerecha(Raiz, nuevoNodo);
				else
					H.IngresarIzquierda(Raiz, nuevoNodo);
			else
				H.IngresarDerecha(Raiz, nuevoNodo);
		}
	}

	public void LeerArchivoCSV() {
		if (dato == false) {
			try {
				Scanner lector = new Scanner(new File("src/PersonasALeer.csv"));
				while (lector.hasNextLine()) {
					String[] datos = lector.nextLine().split(",");
					IngresarPersona(new Personas(datos[0], datos[1], H.IngresarDate(datos[2]), datos[3]));
				}
				lector.close();
				dato = true;
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
			
		} else
			System.out.println("Solo se puede cargar una sola vez");
	}

	public void ImprimirArbol() {
		switch (H.Opcion_ImprimirArbol()) {
		case 1:
			System.out.print("\nImprimir PRE-ORDER: ");
			H.preOrder(Raiz);
			break;
		case 2:
			System.out.print("\nImprimir IN-ORDER:  ");
			H.inOrder(Raiz);
			break;
		case 3:
			System.out.print("\nImprimir POST-ORDER: ");
			H.postOrder(Raiz);
			break;
		default:
			System.out.println("Opcion invalida");
			ImprimirArbol();
			break;
		}
		System.out.println();
	}


}