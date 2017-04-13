import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Arquivos implements Runnable {

	private int tick = 300;
	private int tickThread = 0;
	private int timeRun = 0;
	public Boolean keepRunning = true;
	public List<Process> list = new ArrayList<Process>();

	File file1 = new File("C:\\Users\\Isabelly\\workspace\\Simulador\\src\\program1.txt");
	File file2 = new File("C:\\Users\\Isabelly\\workspace\\Simulador\\src\\program2.txt");

	void readFile(File file) {
		Scanner sc;
		try {
			sc = new Scanner(file);
			processFile(sc);
			sc.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void processFile(Scanner sc) {
		Process p = new Process(list.size(), "pc" + list.size(), ProcessState.RUNNING, 0, timeRun + 3, 0);

		while (sc.hasNextLine()) {
			String line = sc.nextLine();
			createProcess(line);
			processFile(sc);
		}
	}

	void createProcess(String line) {
		String operation = processOperation(line);
	}

	String processOperation(String line) {
		String instruction = "";
		if (line.contains("generic_instruction")) {
			generic();
			tickThread++;
		}
		if (line.contains("create_thread")){
			instruction = line.replaceAll("[^0-9]", "");
			createThread(Integer.parseInt(instruction));
			tickThread++;
		}
		if (line.contains("call")) {
			readFile(file2);
			tickThread++;
		}
		if (line.contains("blocking_system_call")) {
			init.setState(ProcessState.BLOCKED);
			tickThread++;
		}
		else {
			
		}
		
		return instruction;
	}

	void generic() {
	}

	Thread thread;
	private Thread createThread(int line) {
		// Cria uma nova thread para o processo
		// Inicia o program counter na linha recebida
		Thread t = new Thread();
		t.start();
		tickThread = 0;
		
	return thread;	
	}
	
	void exibeThread(){
		System.out.println( tickThread + "\t\t ");
	}

	Process init;
	Process pc1;
	Process pc2;

	// Para testes
	public void criarProcessos() {
		Process init = new Process(1, "init", ProcessState.RUNNING, 0, timeRun, 0);
		Process pc2 = new Process(2, "pc2", ProcessState.RUNNING, 0, timeRun + 3, init.getId());
		init.addProcessoFilho(pc2);
		list.add(init);
		list.add(pc2);
		System.out.println("Processos iniciados");
	}

	@Override
	public void run() {
		while (keepRunning) {
			this.timeRun++;

			try {
				Thread.sleep(tick);
			} catch (Exception e) {

			}
		}
		System.out.println("System terminated after " + timeRun + " ticks.");
	}

	public void getProcs() {
		System.out.println(" Estado \t Processo Pai \t Processos Filho \t ID \t Ticks em execução");

		for (Process o : list) {
			System.out.println(o.getState() + "\t\t\t" + o.getProcessoPai() + "\t\t" + o.getProcessosFilho() + "\t\t "
					+ o.getId() + "\t\t" + (timeRun - o.getTime()));
		}
	}

}
