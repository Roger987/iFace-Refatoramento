import java.util.Scanner;

public class iFace{
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		
		int input = -1;
		
		
		System.out.println("---------- Welcome to iFace ----------\n\n");
		System.out.println("Choose an option:\n"
				+ "0 - Leave the page\n"
				+ "1 - Create new account\n"
				+ "2 - Login\n\n");
		
		java.util.ArrayList<Usuarios> users = new java.util.ArrayList<Usuarios>();
		
		while(input != 0) {
	
			try {
				
				input = scanner.nextInt();
				
				scanner.nextLine();
				
				switch(input) {
				
					case 1:
						Usuarios user = new Usuarios();
						
						user.CreateNewAccount();
						user.CreateProfile();
						users.add(user);					
						
						System.out.println("New account created!\n\n");
						
						break;
					
					case 2:
						
						int i, id = 0, flag0 = 0;
						String password = null;
						System.out.println("Login:");
						String login = scanner.nextLine();
						
						for(i = 0; i < users.size(); i++) {
							if(login.equals(users.get(i).login)) {
								id = i;
								System.out.println("Password:");
								password = scanner.nextLine();
								flag0++;
								break;
							}
						}
						
						if(flag0 == 0) {
							System.out.println("Sorry! Not found! Try again!\n");
							break;
						}
						
						else if(password.equals(users.get(id).getPassword())){
							System.out.println("\nHello " + users.get(id).name + "!\n");
							System.out.println("\nChoose an option:\n"
									+ "1 - Edit my profile\n"
									+ "2 - Add a new friend\n"
									+ "3 - Accept a new friend\n"
									+ "4 - Show my profile\n"
									+ "5 - Show another member profile\n"
									+ "6 - Show a community\n"
									+ "7 - Send a message\n"
									+ "8 - Read your messages\n"
									+ "9 - Create a community\n"
									+ "10 - Add a new person to your community\n"
									+ "11 - Delete your account\n"
									+ "12 - Logout\n\n");
							
							int inputcase2 = -1;
							
							while(inputcase2 != 12) {
								
								try {
									
									inputcase2 = scanner.nextInt();
									scanner.nextLine();
									
									switch(inputcase2) {
									
										case 1:
											
											users.get(id).EditProfile();
											
											break;
										
										case 2:
											
											int flag = 0;
											
											System.out.println("\nType your friend's user name:\n");
											
											String friendname = scanner.nextLine();
											
											for(i = 0; i < users.size(); i++) {
												
												if(friendname.equals(users.get(i).name)) {
													users.get(i).AddFriend(users.get(id).name);
													flag++;
													break;
												}
												
											}
											
											if(flag == 0) {
												System.out.println("Sorry! Not found!\n");
											}
											
											break;
										
										case 3:
											
											int j;
											System.out.println("People who want to be your friend"
													+ "\nPress 1 to accept and 2 to decline\n\n");
											
											for(i = 0; i < users.get(id).newfriends.size(); i++) {
												
												System.out.println("\n\n" + users.get(id).newfriends.get(i) + " wants to be your friend! Accept?\n\n");
												
												int accept = scanner.nextInt();
												
												if(accept == 1) {
													
													Messages message = new Messages();
													
													users.get(id).friends.add(users.get(id).newfriends.get(i));
													
													message.messagename = users.get(id).newfriends.get(i);
													
													users.get(id).mymessages.add(message);
													
													for(j = 0; j < users.size(); j++) {
														
														if(users.get(id).newfriends.get(i).equals(users.get(j).name)) {
															
															users.get(j).friends.add(users.get(id).name);
															
															Messages message2 = new Messages();
															
															message2.messagename = users.get(id).name;
															
															users.get(j).mymessages.add(message2);
															
															System.out.println("\nYou and " + users.get(id).newfriends.get(i) + " are friends now!");
														}
													}
													
													users.get(id).newfriends.remove(i);
												}
												
												else {
													
													users.get(id).newfriends.remove(i);
													System.out.println("Declined");
												}
											}
											
											break;
										
										case 4:
										
											users.get(id).ShowProfile();
											
											break;
											
										case 5:
											
											int flag2 = 0;
											
											System.out.println("\nType the name of the member that you're looking for:");
											
											String member = scanner.nextLine();
											
											for(i = 0; i < users.size(); i++) {
												if(member.equals(users.get(i).name)) {
													users.get(i).ShowProfile();
													flag2++;
												}
											}
											
											if(flag2 == 0) {
												System.out.println("\nSorry! Not found!\n");
											}
											
											break;
											
										case 6:
											
											int flag3 = 0;
											
											System.out.println("\nType the name of the community that you're looking for:");
											
											String com = scanner.nextLine();
											
											for(i = 0; i < users.size(); i++) {
												if(users.get(i).mycommunity != null && com.equals(users.get(i).mycommunity.communityname)) {
													users.get(i).mycommunity.ShowCommunity();
													flag3++;
												}
											}
											
											if(flag3 == 0) {
												System.out.println("\nSorry! Not found!\n");
											}
											
											break;
											
										case 7:
											
											users.get(id).SendMessage(users);
											break;
											
										case 8:
											users.get(id).PeekMessages();
											break;
											
										case 9:
											
											users.get(id).CreateCommunity();
											break;
											
										case 10:
											
											users.get(id).AddCommunity(users);
											break;
											
										case 11:
											
											for(i = 0; i < users.size(); i++) {
												for(j = 0; j < users.get(i).friends.size(); j++) {
													if(users.get(id).name.equals(users.get(i).friends.get(j))) {
														users.get(i).friends.remove(j);
													}
												}
											}
											
											for(i = 0; i < users.size(); i++) {
												for(j = 0; j < users.get(i).mymessages.size(); j++) {
													if(users.get(id).name.equals(users.get(i).mymessages.get(j).messagename)) {
														users.get(i).mymessages.remove(j);
													}
												}
											}
											
											for(i = 0; i < users.size(); i++) {
												for(j = 0; j < users.get(i).newfriends.size(); j++) {
													if(users.get(id).name.equals(users.get(i).newfriends.get(j))) {
														users.get(i).newfriends.remove(j);
													}
												}
											}
											
											
											for(i = 0; i < users.size(); i++) {
												if(users.get(i).mycommunity != null) {
													for(j = 0; j < users.get(i).mycommunity.communityusers.size(); j++) {
														if(users.get(id).name.equals(users.get(i).mycommunity.communityusers.get(j))) {
															users.get(i).mycommunity.communityusers.remove(j);
														}
													}
												}
											}
											
											users.remove(id);
											System.out.println("\nRemoved from iFace!\n");
											inputcase2 = 12;
											break;									
									}
									
									System.out.println("\nChoose an option:\n"
											+ "1 - Edit my profile\n"
											+ "2 - Add a new friend\n"
											+ "3 - Accept a new friend\n"
											+ "4 - Show my profile\n"
											+ "5 - Show another member profile\n"
											+ "6 - Show a community\n"
											+ "7 - Send a message\n"
											+ "8 - Read your messages\n"
											+ "9 - Create a community\n"
											+ "10 - Add a new person to your community\n"
											+ "11 - Delete your account\n"
											+ "12 - Logout\n\n");
									
								}
								
								catch(Exception e) {
									scanner.nextLine();
									System.out.println("\nError! Please try again!\n");
									System.out.println("\nChoose an option:\n"
											+ "1 - Edit my profile\n"
											+ "2 - Add a new friend\n"
											+ "3 - Accept a new friend\n"
											+ "4 - Show my profile\n"
											+ "5 - Show another member profile\n"
											+ "6 - Show a community\n"
											+ "7 - Send a message\n"
											+ "8 - Read your messages\n"
											+ "9 - Create a community\n"
											+ "10 - Add a new person to your community\n"
											+ "11 - Delete your account\n"
											+ "12 - Logout\n\n");
								}
								
							}
						}
						 else {
							 System.out.println("\nWrong password.\n\n"
							 		+ "Try again.\n\n");
						 }
						
						break; 
				}
				
			}
			
			catch(Exception e) {
				scanner.nextLine();
				System.out.println("\nError! Please try again!\n");

			}
			
			System.out.println("\n\nChoose an option:\n"
					+ "0 - Leave the page\n"
					+ "1 - Create new account\n"
					+ "2 - Login\n\n");
			

		}
		
		scanner.close();
	}
	
	
}