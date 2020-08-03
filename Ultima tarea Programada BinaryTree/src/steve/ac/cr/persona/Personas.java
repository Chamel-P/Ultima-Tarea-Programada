package steve.ac.cr.persona;

import java.util.Date;

public class Personas {
private String Nombre;
private String Apellido;
private Date Fecha_Nacimiento;
private String Cedula;

public Personas(String nombre, String apellido, Date fecha_Nacimiento, String cedula) {
	Nombre = nombre;
	Apellido = apellido;
	Fecha_Nacimiento = fecha_Nacimiento;
	Cedula = cedula;
}
public String getNombre() {
	return Nombre;
}
public String getApellido() {
	return Apellido;
}
public Date getFecha_Nacimiento() {
	return Fecha_Nacimiento;
}
public String getCedula() {
	return Cedula;
}
@Override
public String toString() {
	return "[" + Nombre + "," + Cedula +"]";
}


}
