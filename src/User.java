import java.util.Scanner;

public class User {
	Scanner sc = new Scanner(System.in);
	
		// ATRIBUTELE CLASEI
	private String name;
	private String password;
	private double sold;					
	
        // CONSTRUCTOR
	public User(String name, String password, double sold) {
		this.name = name;
		this.password = password;
		this.sold = sold;	
	}
 
        // ACCESSORS / GETTERS
	public String getName() {
		return name;
	}
 
        // MUTATORS / SETTERS
	public void setName(String name) {
		this.name = name;
	}
 
	public String getPassword() {
		return password;
	}
 
	public void setPassword(String password) {
		this.password = password;
	}
 
	public double getSold() {
		return sold;
	}
 
	public void setSold(double sold) {
		this.sold = sold;
	}
	//Aici am creat metoda pentru vizualizarea soldului
	public void VizualizareSold() {
	    System.out.println("Sold cont: "+ this.sold);
	    OlteanAurelianATM.User();
	}
	//Aici am creat metoda pentru depunerea numerarului
	//In cazul in care se introduc caractere sau o suma cu '-' se va afisa un mesaj de atentionare
	public void Depunere() {
		System.out.println("Suma depusa: ");
		double sumaDepusa = 0;	
		try	{
			do {
				sumaDepusa = sc.nextDouble();	
				if(sumaDepusa > 0){
					this.sold = this.sold + sumaDepusa;
					System.out.println("Sold: "+this.sold);
					OlteanAurelianATM.User();
				}
			} while (sumaDepusa > 0);
				System.err.println("Suma trebuie sa fie mai mare decat 0!");
				OlteanAurelianATM.User();
		}catch(Exception e){
			System.err.println("Sorry! Va rugam sa introduceti cifre");
		sc.hasNextDouble();
		}
		sc.nextLine();
		this.sold = this.sold + sumaDepusa;
		System.out.println("Sold: "+this.sold);
		OlteanAurelianATM.User();
		
	}
	//Aici am creat metoda pentru retragere numerar 
	//In cazul in care se vor introduce caractere, o suma cu minus sau o suma mai mare decat soldul
	//se va afisa un mesaj de atentionare
	public void Retragere() {
		System.out.println("Suma retrasa: ");
		double sumaRetrasa = 0;	
		try	{
			do {
				sumaRetrasa = sc.nextDouble();	
				if(sumaRetrasa > 0 && sumaRetrasa <= sold){
					this.sold = this.sold - sumaRetrasa;
					System.out.println("Sold: "+this.sold);
					OlteanAurelianATM.User();
				}
			} while (!(sumaRetrasa > 0) && !(sumaRetrasa <= sold));
			if (sumaRetrasa<=0 || sumaRetrasa>sold){
				System.err.println("Suma trebuie sa fie mai mare decat 0 si mai mica sau egala cu soldul!");
				OlteanAurelianATM.User();
			return;
			}	
		}catch(Exception e){
			System.err.println("Sorry! Va rugam sa introduceti cifre");
		sc.hasNextDouble();
		}
		sc.nextLine();
		this.sold = this.sold - sumaRetrasa;
		System.out.println("Sold: "+this.sold);
		OlteanAurelianATM.User();
		
	}
	//Aici am facut metoda pentru schimbarea parolei
	public void changePassword() {
		
		System.out.println("Password: ");
		String oldPassword = sc.next();
		if (oldPassword.equals(this.password)){
			System.out.println("New password: ");
			String newPassword1 = sc.next();
			System.out.println("Confirm new password: ");
			String newPassword2 = sc.next();
			if (newPassword1.equals(newPassword2) && newPassword1.length() == 4){
				this.password = newPassword2;
				System.out.println("Parola a fost schimbata cu succes!");
				System.out.println();
				OlteanAurelianATM.User();
			}else{
				System.out.println("Noua parola nu a fost introdusa corect! \n"
						+ "Parola trebuie sa contina 4 cifre!");
				OlteanAurelianATM.User();
			}
		}else{
			System.out.println("Parola actuala a fost introdusa gresit!");
			OlteanAurelianATM.User();
		}
	}
	
}
