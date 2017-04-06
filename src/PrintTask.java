
public class PrintTask implements Runnable {
	
	private int ticks = 0;
	private final String taskName;
	private String status;
	
	public PrintTask( String name ){
		taskName = name;
	}
	
	public void run(){
		try{
				Thread.sleep(3000);			
		} catch ( InterruptedException exception){
			System.out.println("Blá blá blá");
		}
	}
}
