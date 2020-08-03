package Arbol;

import steve.ac.cr.persona.Personas;

public class NodeTree {

	public Personas data; 
	public NodeTree leftChild; 
	public NodeTree rightChild; 

	public void displayNode() 
	{
		System.out.print('{');
		System.out.print(data);
		System.out.print("} ");
	}

}
