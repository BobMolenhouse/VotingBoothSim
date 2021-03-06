import java.util.ArrayList;
/**
 * @author   Roger Ferguson
 */
public class Booth implements ClockListener {	
	private int timeOfNextEvent = 0;
	private Voter person;   // this is the person at the booth. 
	private BoothQueue boothQueue;
	private SimStatus info;
	
	public Booth(BoothQueue boothQueue, SimStatus info){
		this.boothQueue = boothQueue;
		this.info = info;
	}
	
//	public void add (Voter person)
//	{
//		this.person = person;
//	}
	
	public void event (int tick){
		if (tick >= timeOfNextEvent) {
//			if (person != null) { 			// Notice the delay that takes place here
//				person.getDestination().add(person);    // take this person to the next station. 
//			person = null;				// I have send the person on. 
//			}
			
//			if (person != null) {
				if(!boothQueue.getQ().isEmpty()){
					if(person != null){
				info.setTotalTime(tick - (person.getTickTime()));
					}
				person = boothQueue.getVoter();		// do not send this person as of yet, make them wait. 
				timeOfNextEvent = tick + (int) (person.getBoothTime() + 1);
				info.incThroughPut();	
				}
//			}	
		}
	}

}