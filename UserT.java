package sample;

import java.io.IOException;
import java.util.*;
public class UserT {

	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		User te = new User();
		
//		User u1 = new User("Abdul", "ak07594", "d7mi-uk@hotmail.com", 21);
//		u1.setId(1);
//		te.users.add(u1);
//		User u2 = new User("Potato", "po05427", "pot@gmail.com", 18);
//		u2.setId(2);
//		te.users.add(u2); 
//		User u3 = new User("CocaCola", "copep77", "coca@yahoo.com", 35);
//		u3.setId(3);
//		te.users.add(u3);
//		te.write();
		
		te.read();
		Scanner in = new Scanner(System.in);
		System.out.println("Existing User ? type 1 \nNew User ? type 2");
		int userInput = in.nextInt();
		
		
		if(userInput == 1){
			System.out.println("Enter your userName");
			String un = in.next();
			System.out.println("\n");
			System.out.println("Enter your password");
			String pw = in.next();
			Boolean login = false;
			for(User var : te.users){
				if(	(var.getUserName().equals(un)) && (var.getPassWord().equals(pw))	
							){
					login = true;
				}
			}
			
			if(login == true){
				System.out.println(" WELCOME BACK !! \n\n");
			}else{
				System.out.println(" You're not registered !! \n\n");
			}
		}
		if(userInput == 2){
			System.out.println("To register a new user please enter the following details ");
			
			System.out.println("Enter your userName");
			String un = in.next();
			System.out.println("Enter your password");
			String pw = in.next();
			System.out.println("Enter your email");
			String em = in.next();
			System.out.println("Enter your age");
			int ag = in.nextInt();
			te.addUser(un, pw, em, ag);
			te.write();
		}
		
		System.out.println("\n\n List of all users : !! \n\n");
		for(User us : te.users){
			System.out.println(us.getId()+" "+us.getUserName()+" "+us.getPassWord()+" "+us.getEmail()+" "+us.getAge());
		}
	
	}

}
