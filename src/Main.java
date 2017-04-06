
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Boolean repeat = true;

		while (repeat == true) {
			System.out.print(">");
			Scanner command = new Scanner(System.in);
			String text = command.nextLine();
			Arquivos processo =  new Arquivos();

			if (!text.equals("exit")) {
				if (text.equals("procs")) {
					System.out.println(text);
				} else if (text.equals("init")) {
					System.out.println(text);
					processo.init();
				} else if (text.equals("threads")) {
					System.out.println(text);
				} else {
					System.out.println("“" + text + "” : Command not found ");
				}
			} else {
				repeat = false;
			}
		}
	}
}