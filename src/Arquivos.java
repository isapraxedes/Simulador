import java.lang.Thread;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Arquivos {
	int contThread = 00;
	String process = "program1";
	String caminho = "C:/Users/Isabelly/workspace/Simulador/src/" + process + ".txt";

	public void init() throws IOException {
		call(caminho);
	}

	public void call(String program) throws IOException {

		FileReader arq = new FileReader(program);
		BufferedReader lerArq = new BufferedReader(arq);
		read(lerArq);
		arq.close();

	}

	public void read(BufferedReader arquivo) throws IOException {
		createNewThread(process);
		String linha = arquivo.readLine();
		while (linha != null) {
			String[] tokens = linha.split(" ");
			// for( String token : tokens)
			// System.out.println( token );

			if (tokens[0].equals("create_thread(")) {
				createNewThread(process);	
			} else if (tokens[0].equals("call(")) {
				process = tokens[1];
				call(caminho);
			} else {
			System.out.printf("%s\n", linha);
			}
			linha = arquivo.readLine();
		}

	}

	public Thread createNewThread(String PID) {

		Thread thread = new Thread (new PrintTask(PID));
		 thread.start();
		 contThread++;
		 thread.setName(Integer.toString(contThread));
		 System.out.println(thread.getName() + "  " + PID);
		 return thread;
	}

}
