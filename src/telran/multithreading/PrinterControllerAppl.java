package telran.multithreading;

public class PrinterControllerAppl {

	public static void main(String[] args) {
		Printer printer1 = new Printer('#', 100);
		Printer printer2 = new Printer('*', 100);
		printer1.start();
//		printer2.start();
//		Printer printer3 = new Printer('*', 100);
//		printer3.start();
//		Printer printer4 = new Printer('*', 100);
//		printer4.start();
//		Printer printer5 = new Printer('*', 100);
//		printer5.start();
	}

}
