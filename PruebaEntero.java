package pruebas;

public class PruebaEntero {

	public static void main(String[] args) {
		Entero numero = new Entero("240");
		System.out.println(numero.getValor());
		
		numero.setValor("-240");
		System.out.println(numero.getValor());
		
		numero.setValor(350);
		System.out.println(numero);
		numero.setValor(-350);
		System.out.println(numero);
		
		Entero numero2 = new Entero("-350");
		System.out.println("¿Son iguales?: " + numero2.equals(numero));
	}

}
