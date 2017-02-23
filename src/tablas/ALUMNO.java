package tablas;

public class ALUMNO {
    private int numero;
    private String nombre;
    private String apellido;
    private int edad;
    
	public ALUMNO() {
		super();
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}
            
    public void mostrarInfo(){
    	
    	System.out.print("\n\tNUMERO "+numero);
    	System.out.print("\tNOMBRE "+nombre);
    	System.out.print("\tAPELLIDO "+apellido);
    	System.out.print("\tEDAD "+edad);
    }
}
