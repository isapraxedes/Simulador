
import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException {

		Boolean repeat = true;
		Arquivos cpu = new Arquivos();
		Thread t = new Thread(cpu);
		t.start();

		while (repeat == true) {
			System.out.print(">");
			Scanner command = new Scanner(System.in);
			String text = command.nextLine();

			if (!text.equals("exit")) {
				if (text.equals("procs")) {
						cpu.getProcs();
				} else if (text.equals("init")) {
					cpu.criarProcessos();
				} else if (text.equals("threads")) {
					cpu.exibeThread();
				//	System.out.println("threads typed");
				} else {
					System.out.println("“" + text + "” : Command not found ");
				}
			} else {
				repeat = false;
			}
		}

	        cpu.keepRunning = false;
	        t.interrupt();
	}
}