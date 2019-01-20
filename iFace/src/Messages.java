import java.util.ArrayList;

public class Messages{
	
	public String messagename;
	public ArrayList<String> messages = new ArrayList<String>();

	public void ShowMessages() {
		int i;
		if(messages.size() > 0) {
			System.out.println("\nYour messages with " + messagename);
			for(i = 0; i < messages.size(); i++) {
				System.out.println(messages.get(i));
			}
		}
		else {
			System.out.println("Sorry! You haven't any message from " + this.messagename);
		}
	}
	
}