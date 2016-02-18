import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;

public class OlteanAurelianATM {
	static Scanner sc = new Scanner(System.in);
	static User userLogat;
	
	//Am creat 3 obiecte de tip user și am și inițializat atributele.
	static User user1 = new User("Gigel", "123", 1000);
	static User user2 = new User("George", "456", 2000);
	static User user3 = new User("Ionel", "789", 3000);
	
	public static void main(String[] args) {
		
		Login();
		User();
		
	}
	
	public static void User() {
		
		//Am creat meniul
		System.out.println();
		System.out.println("---Meniu---");
		System.out.println("1. Vizualizare sold");
		System.out.println("2. Depunere numerar");
		System.out.println("3. Retragere numerar");
		System.out.println("4. Schimbare parola");
		System.out.println("5. Log out");
		System.out.println("6. Exit ATM");
		
        String select;
        System.out.println();
        System.out.println("Alegeti o optiune:");
        select = sc.next();
        
        switch(select){
        case "1":
        	userLogat.VizualizareSold();
        break;
        case "2":
        	userLogat.Depunere();
        break;
        case "3":
        	userLogat.Retragere();
        break;
        case "4":
        	userLogat.changePassword();
        break;
        case "5":
        	main(null);
        break;
        case "6":
        	System.out.println("Thank you for using this ATM! Goodbye");
        	System.exit(0);
        break;
        default:
        	System.err.println("Va rugam sa introduceti una din optiunile afisate!");
        	User();
        break;
        }
		
	}
	
	public static void Login() {
		List<User>UserList = new ArrayList <User>();
		UserList.add(user1);
		UserList.add(user2);
		UserList.add(user3);
		
		System.out.println("              ---Start ATM---              ");
		System.out.println();
		//Aici este codul pentru logarea utilizatorilor
		//Introducerea numelui si a parolei
		//Daca se greseste parola de 3 ori contul va fi blocat
		boolean ok = false;
		while(true) {
			try {
			    Thread.sleep(10);                 //1000 milliseconds is one second.
			} catch(InterruptedException ex) {
			    Thread.currentThread().interrupt();
			}
			System.out.println("");
			System.out.println("User name: ");
			String userName = sc.next();
			int counter = 0;
			for (User contLista : UserList) {
				if (userName.equalsIgnoreCase(contLista.getName())) {
					userLogat = contLista;
					counter++;
					for (int i = 0; i < 3; i++) {
					System.out.println("Password: ");
					String password = sc.next();
						if (password.equals(contLista.getPassword())) {
							ok = true;
							break;
						} else {
							System.err.println("Incorrect password");
						try {
						    Thread.sleep(5);                 //1000 milliseconds is one second.
						} catch(InterruptedException ex) {
						    Thread.currentThread().interrupt();
						}
						System.out.println("Mai aveti " + (2-i) + " incercari");	
						}
					}
					if ( !ok ) {
						System.err.println("Card blocat");
						continue;
					} else {
						System.out.println("Bine ai venit la ATM!");
						return;
					}
				}	
			}
			if (counter==0) {
				System.err.println("Incorrect name");
			}
			
		}
		
	}
	
	
			
}
	
	

	


