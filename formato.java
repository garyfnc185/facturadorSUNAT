import java.util.*;
import java.io.*;
public class formato {
	public static void main (String [] Args) {
		double valor;
		String Moneda = "PEN";
		String Tipo = "Boleta";
		int Serie = 001;
		int Correlativo = 000000003;
		String tipoAfectacion = "10";
		String afectacionISC = "01";
		String codigoUnidad = "NIU";
		String codigoProducto = "A-04";
		Double SumatoriaCargos = 0.00;
		Double TotalValorVentas = 0.00;
		Double TotalDescuentos = 0.00;
		Double otrosTributos = 0.00;
		Double sumaISC = 0.00;
		String tipoISC = "01";
		Double totalExonerada = 0.00;
		Scanner sc = new Scanner(System.in);
		System.out.print("Ingrese fecha de emision: ");
		String fecha = sc.nextLine();
		System.out.print("Ingrese su DNI: ");
		String DNI = sc.nextLine();
		System.out.print("Ingrese su nombre: ");
		String nombre = sc.nextLine();
		System.out.print("Ingrese su primer apellido: ");
		String apellido = sc.nextLine();
		System.out.print("Ingrese su segundo apellido: ");
		String apellido2 = sc.nextLine();
		System.out.print("Ingrese tipo de operacion: ");
		String operacion = sc.nextLine();//debe ser 01
		System.out.print("Ingrese cantidad de producto: ");
		String cant = sc.nextLine();
		System.out.print("Ingrese su descripcion del producto: ");
		String descripcion = sc.nextLine();
		System.out.print("Ingrese valor: ");
		valor = sc.nextDouble();
		Double cantidad = Double.parseDouble(cant);
		Double subtotal = (double)Math.round((valor/1.18) * 100d) / 100d;
		Double igv = (double)Math.round((subtotal * 0.18) * 100d) / 100d;
		Double importeTotal = (double)Math.round((valor - igv) * 100d) / 100d;
		Double descuentoGlobal = (double)Math.round((importeTotal*0.05) * 100d) / 100d;
		Double TotalVentasGrabadas = (double)Math.round((importeTotal - descuentoGlobal) * 100d) / 100d;

		// generacion cab

		FileWriter fichero = null;
		PrintWriter pw = null;
		try
		{
			fichero = new FileWriter("D:\\SUNAT\\sunat_archivos\\sfs\\DATA\\20601898447-01-FF13-00000017.cab");
			pw = new PrintWriter(fichero);
			pw.println(operacion+"|"+ fecha+"||"+"1"+"|"+DNI+"|"+nombre+" "+apellido+" "+apellido2+"|"+Moneda+"|"+SumatoriaCargos+"|"+TotalValorVentas+"|"+descuentoGlobal+"|"+TotalVentasGrabadas+"|"+TotalDescuentos+"|"+otrosTributos+"|"+igv+"|"+sumaISC+"|"+totalExonerada+"|"+importeTotal+"|");


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (null != fichero)
					fichero.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}


		// generacion det

		FileWriter fichero2 = null;
		PrintWriter pw2 = null;
		try
		{
			fichero2 = new FileWriter("D:\\SUNAT\\sunat_archivos\\sfs\\DATA\\20601898447-01-FF13-00000020.det");
			pw2 = new PrintWriter(fichero2);
			pw2.println(codigoUnidad+"|"+ cantidad+"|"+codigoProducto+"||"+descripcion+"|"+valor+"|"+importeTotal+"|"+otrosTributos+"|"+igv+"|"+sumaISC+"|"+tipoISC+"|"+totalExonerada+"|"+importeTotal+"|");


		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {

				if (null != fichero2)
					fichero2.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
	}
}
