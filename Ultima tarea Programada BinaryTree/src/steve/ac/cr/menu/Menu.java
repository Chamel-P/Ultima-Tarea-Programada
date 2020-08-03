package steve.ac.cr.menu;

import Arbol.Tree;
import steve.ac.cr.help.Help;
import steve.ac.cr.persona.Personas;

public class Menu {

	Tree T = new Tree();
	Help H = new Help();

	public void Menu_BinaryTree() {
		
		switch (H.opcion_menu()) {
		case 1:
			T.IngresarPersona(
					new Personas(H.ObtenerNombre(), H.ObtenerApellido(), H.ObternerFecha(), H.ObtenerCedula()));
			Menu_BinaryTree();
			break;
		case 2:
			T.LeerArchivoCSV();
			Menu_BinaryTree();
			break;
		case 3:
			T.ImprimirArbol();
			Menu_BinaryTree();
			break;
		case 4:
		System.out.println("Hasta luego :)");
			break;
		default:
			System.out.println("Opcion invalida\n");
			Menu_BinaryTree();
			break;
		}
	}
}
