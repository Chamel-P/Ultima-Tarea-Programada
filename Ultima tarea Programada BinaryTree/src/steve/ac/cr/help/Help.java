package steve.ac.cr.help;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import Arbol.NodeTree;

public class Help {
	private Scanner input = new Scanner(System.in);

	public int opcion_menu() {
		System.out.println("1) insertar persona\n" + "2)Leer las personas desde un archivo de texto\n"
				+ "3)Imprimir árbol\n" + "4)Salir\n");

		System.out.print("Ingrese el numero de la opcion que desea: ");
		return input.nextInt();
	}

	public Date ObternerFecha() {
		System.out.println("Introduzca la fecha con formato dd/mm/yyyy");
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = null;
		try {
			fecha = df.parse(input.nextLine());
		} catch (ParseException e) {
			System.out.println("Tiene que ser en formato dd/mm/yyyy");
			ObternerFecha();
		}
		return fecha;
	}

	public String ObtenerNombre() {
		System.out.print("Ingrese Nombre: ");
		input.nextLine();
		return input.nextLine();
	}

	public String ObtenerApellido() {
		System.out.print("Ingrese Apellido:");
		return input.nextLine();
	}

	public String ObtenerCedula() {
		System.out.println("Ingrese Cedula");
		String ID = input.nextLine();
		if (ID.length() != 9) {
			System.out.println("Tienen que ser 9 digitos en la cedula\n");
			ObtenerCedula();
		}
		return ID;

	}

	public int Opcion_ImprimirArbol() {
		System.out.println("1)Imprimir PRE-ORDER\n" + "2)Imprimir IN-ORDER\n" + "3)Imprimir POST-ORDER ");
		return input.nextInt();
	}

	public void preOrder(NodeTree RaizIncial) {
		if (RaizIncial != null) {
			System.out.println(RaizIncial.data + " ");
			preOrder(RaizIncial.leftChild);
			preOrder(RaizIncial.rightChild);
		}
	}

	public void inOrder(NodeTree RaizIncial) {
		if (RaizIncial != null) {
			inOrder(RaizIncial.leftChild);
			System.out.println(RaizIncial.data + " ");
			inOrder(RaizIncial.rightChild);
		}
	}

	public void postOrder(NodeTree RaizIncial) {
		if (RaizIncial != null) {
			postOrder(RaizIncial.leftChild);
			postOrder(RaizIncial.rightChild);
			System.out.println(RaizIncial.data + " ");
		}
	}

	public Date IngresarDate(String datos) {
		SimpleDateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date fecha = null;
		try {
			fecha = df.parse(datos);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return fecha;
	}

	public void IngresarIzquierda(NodeTree padre, NodeTree nuevoNodo) {
		int orden = nuevoNodo.data.getFecha_Nacimiento().compareTo(padre.data.getFecha_Nacimiento());
		if(orden<0) {
			IngresarDerecha(padre, nuevoNodo);
			return;
		}
		
		if (padre.leftChild == null)
			padre.leftChild = nuevoNodo;
		else
			IngresarIzquierda(padre.leftChild, nuevoNodo);

	}

	public void IngresarDerecha(NodeTree padre, NodeTree nuevoNodo) {
		int orden = nuevoNodo.data.getFecha_Nacimiento().compareTo(padre.data.getFecha_Nacimiento());
		if(orden>0) {
			IngresarIzquierda(padre, nuevoNodo);
			return;
		}
		if (padre.rightChild == null)
			padre.rightChild = nuevoNodo;
		else
			IngresarDerecha(padre.rightChild, nuevoNodo);

	}
}
