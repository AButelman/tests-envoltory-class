package pruebas;

public class Entero {
	private int valor;
	boolean negativo = false;
	
	public Entero(int v){
		valor = v;
		if (valor < 0) { negativo = true; }
	}
	
	public Entero(String cadena){
		valor = pasarCadenaAInt(cadena);
	}
	
	public void setValor(int valor){
		this.valor = valor;
		if (valor < 0) { 
			negativo = true; 
		} else {
			negativo = false;
		}
	}
	
	public void setValor(String cadena){
		valor = pasarCadenaAInt(cadena);
	}
	
	public int getValor() {return valor;}
	
	private int pasarCadenaAInt(String cadena){
		int total = 0;
		int digito;
		
		if (cadena.length() > 11) {
			System.err.println("Su número supera el valor máximo permitido.");
			System.exit(1);
		} else if (cadena.length() == 0) {
			System.err.println("Por favor ingrese un número válido.");
			System.exit(1);
		}
		
		
		if (cadena.charAt(0) == '-') {
			negativo = true;
			
			char[] cad = new char[cadena.length() - 1];
			
			for (int i = 0; i < (cadena.length() - 1); i++) {
				cad[i] = cadena.charAt(i+1);
			}
			
			cadena = new String(cad);
		}
		
		for (int i = 0; i < cadena.length(); i++){
			digito = resolverDigito(cadena.charAt(cadena.length() - i - 1));
			total += digito * ((int) Math.pow(10, i));
		}
		
		if (negativo) { total = -total; }
		return total;
	}
	
	private int resolverDigito(char caracter){
		int digito = 0;
		
		switch(caracter){
			case ('0'):
				digito = 0;
				break;
			case ('1'):
				digito = 1;
				break;
			case ('2'):
				digito = 2;
				break;
			case ('3'):
				digito = 3;
				break;
			case ('4'):
				digito = 4;
				break;
			case ('5'):
				digito = 5;
				break;
			case ('6'):
				digito = 6;
				break;
			case ('7'):
				digito = 7;
				break;
			case ('8'):
				digito = 8;
				break;
			case ('9'):
				digito = 9;
				break;
			default:
				System.err.println("Ingrese sólo números enteros");
				System.exit(1);
		}
		
		return digito;
	}
	
	public String toString() {
		int temp;
		if (negativo) { 
			temp = -valor; 
		} else {
			temp = valor;
		}
		
		int resto;
		char caracter;
		char[] caracteresAlReves = new char[11];
		
		
		//System.out.println(temp);
		
		int cantDeCaracteres = 0;
		
		if (temp == 0) { 
			return "0";
		} else {
			int temporal = temp;
		
			while (temporal > 0){
				temporal = temporal / 10;
				cantDeCaracteres++;
			}
			
		}
		
		for (int i = 0; i < cantDeCaracteres; i++) {
			if (temp > 9) {
				resto = temp % 10;
				caracter = resolverCaracter(resto);
				caracteresAlReves[i] = caracter;
				temp = temp / 10;
			} else {
				caracter = resolverCaracter(temp);
				caracteresAlReves[i] = caracter;
			}
		}
		
		char[] caracteres = new char[cantDeCaracteres];
		
		int numero;
		for (int i = 0; i < cantDeCaracteres; i++){
			numero = cantDeCaracteres - i - 1;
			caracteres[numero] = caracteresAlReves[i]; 
		}
		
		String c = null;
		String carac = null;
		
		if (negativo) {
			carac = new String(caracteres);
			c = "-" + carac;
		} else {
			c = new String(caracteres);
		}
		
		return c;
	}
	
	
	private char resolverCaracter(int digito){
		char caracter = 0;
		
		switch (digito){
			case (0):
				caracter='0';
				break;
			case (1):
				caracter='1';
				break;
			case (2):
				caracter='2';
				break;
			case (3):
				caracter='3';
				break;
			case (4):
				caracter='4';
				break;
			case (5):
				caracter='5';
				break;
			case (6):
				caracter='6';
				break;
			case (7):
				caracter='7';
				break;
			case (8):
				caracter='8';
				break;
			case (9):
				caracter='9';
				break;		
		}
		
		return caracter;
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Entero) {
			if (valor == ((Entero) obj).getValor()) { return true; }
		}
		return false;
	}
}
