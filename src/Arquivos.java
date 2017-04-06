import java.lang.Thread;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;

public class Arquivos {
	
	Thread thread1 = new Thread ( new PrintTask( "Programa 1" ));
	Thread thread2 = new Thread ( new PrintTask( "Programa 1" ));
	
	public void init() throws IOException{
		call("C:/Users/Isabelly/workspace/Simulador/src/program1.txt");
	}
	
	public void call(String program) throws IOException {
		thread1.start();
		FileReader arq = new FileReader(program);
		BufferedReader lerArq = new BufferedReader(arq);
		read(lerArq);
		arq.close();

	}

	public void read(BufferedReader arquivo) throws IOException {
		String linha = arquivo.readLine();
		while (linha != null) {
			String[] tokens = linha.split( " " );
			
//				for( String token : tokens)
//				System.out.println( token );
				
			if(tokens[0].equals("create_thread(")){
				
				
			}
			System.out.printf("%s\n", linha);

			linha = arquivo.readLine();
		}

	}
}
