
public class PrintTask implements Runnable {
	
	private int ticks = 0;
	private final String taskName;
	private String status; 
	private int ID;
	
	public PrintTask( String name ){
		taskName = name;
	}
	
	public void run(){
		try{
				Thread.sleep(10000);			
		} catch ( InterruptedException exception){
			System.out.println("Blá blá blá");
		}
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}
}
