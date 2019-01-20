import java.util.Scanner;
import java.util.ArrayList;

public class Usuarios{
	public String login;
	public String name;
	private String password;
	public ArrayList<String> friends = new ArrayList<String>();
	public ArrayList<String> newfriends = new ArrayList<String>();
	public int age;
	public String city;
	public String nacionality;
	public Community mycommunity = null;
	public ArrayList<Messages> mymessages = new ArrayList<Messages>();
	public ArrayList<String> mycommunities = new ArrayList<String>();
	
	
	public void CreateNewAccount() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Login:");
		login = scanner.nextLine();
		
		System.out.println("User name:");
		name = scanner.nextLine();
		
		System.out.println("Password:");
		password = scanner.nextLine();
		
	}
	
	
	public String getPassword() {
		return this.password;
	}
	
	
	public void CreateProfile() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Age:");
		age = scanner.nextInt();
		scanner.nextLine();
		
		System.out.println("City:");
		city = scanner.nextLine();
		
		System.out.println("Nacionality:");
		nacionality = scanner.nextLine();
		
	}
	
	public void EditProfile() {
		
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Select the attribute you want to change:\n     1 - Age\n     2 - City\n     3 - Nacionality\n     4 - All\n     5 - quit\n");
		
		int editinput = scanner.nextInt();
		scanner.nextLine();
		
		switch(editinput) {
			
			case 1:
				System.out.println("Age:");
				age = scanner.nextInt();
				scanner.nextLine();
				System.out.println("Done!");
				break;
				
			case 2:
				System.out.println("City:");
				city = scanner.nextLine();
				System.out.println("Done!");
				break;
					
			case 3:
				System.out.println("Nacionality:");
				nacionality = scanner.nextLine();
				System.out.println("Done!");
				break;
				
			case 4:
				System.out.println("Age:");
				age = scanner.nextInt();
				scanner.nextLine();
					
				System.out.println("City:");
				city = scanner.nextLine();
					
				System.out.println("Nacionality:");
				nacionality = scanner.nextLine();
				System.out.println("Done!");
				break;
					
			case 5:
				break;
				
			default:
				System.out.println("\nInvalid Number!\n");
				break;
			
		}

		
	}
	
	
	public void AddFriend(String yourname) {
		String message = yourname;
		newfriends.add(message);
		System.out.println("Done!");
	}
	
	
	public void ShowProfile() {
		int i;
		System.out.println("\n" + name.toUpperCase());
		System.out.println("------------------------------");
		System.out.println(age + " years\n" + city + "     " + nacionality);
		System.out.println("Friends list:");
		for(i = 0; i < friends.size(); i++) {
			System.out.println("   " + friends.get(i));
		}
		if(mycommunity != null) {
			System.out.println("My Community: " + mycommunity.communityname + "\n  Description: " + mycommunity.description);

		}
		System.out.println("Communities:");
		for(i = 0; i < mycommunities.size(); i++) {
			System.out.println("   " + mycommunities.get(i));
		}
	}
	
	
	public void CreateCommunity() {
		Community community = new Community();
		community.CreateNewCommunity(this.name);
		mycommunity = community;
	}
	
	
	public void AddCommunity(ArrayList<Usuarios> u) {
		
		Scanner scanner = new Scanner(System.in);
		
		int i;
		
		if(mycommunity != null) {
			
			System.out.println("\nType the name of the user who you wants to add to your community:");
			
			String newname = scanner.nextLine();
			
			for(i = 0; i < u.size(); i++) {
				if(newname.equals(u.get(i).name)) {
					mycommunity.communityusers.add(newname);
					u.get(i).mycommunities.add(mycommunity.communityname);
					System.out.println("\n" + newname + " add to your community!");
				}
				
			}
		}
		
		else {
			System.out.println("\nOps! You haven't a community!\n");
		}
		
	}
	
	
	public void SendMessage(ArrayList<Usuarios> u) {
		
		Scanner scanner = new Scanner(System.in);
		
		int i, j;
		
		String mess = null;
		
		System.out.println("\nType the name of the user who you wants to send a message:");
		
		String newname = scanner.nextLine();
		
		for(i = 0; i < mymessages.size(); i++) {
			
			if(newname.equals(mymessages.get(i).messagename)) {
				
				System.out.println("\nYour message:");
				
				mess = scanner.nextLine();
				
				this.mymessages.get(i).messages.add(this.name + ": " + mess);
			
			}
			
		}
		
		for(i = 0; i < u.size(); i++) {
			if(newname.equals(u.get(i).name)) {
				
				for(j = 0; j < u.get(i).mymessages.size(); j++) {
					
					if(this.name.equals(u.get(i).mymessages.get(j).messagename)) {
						
						u.get(i).mymessages.get(j).messages.add(this.name + ": " + mess);
						
					}
				}
				
			}
		}
		
		System.out.println("\nDone!");

	}
	
	public void PeekMessages() {
		
		Scanner scanner = new Scanner(System.in);
		
		int i, flag = 0;
		
		System.out.println("\nType the name of the friend you wants to read the messages:");
		
		String search = scanner.nextLine();
		
		for(i = 0; i < mymessages.size(); i++) {
			if(search.equals(mymessages.get(i).messagename)) {
				mymessages.get(i).ShowMessages();
				flag++;
			}
		}
		
		if(flag == 0) {
			System.out.println("Sorry! Not found!");
		}
		
	}

	
}





