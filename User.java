			package sample;
			
			import java.io.*;
			import java.util.*;
			public class User implements Serializable {
			
				int iD = 0;
				String userName;
				String passWord;
				String eMail;
				int age;
				List<User> users = new ArrayList<User>();
				String sourceAsString = "";
				//Map map = new HashMap();
				
				
				
				public User (String u, String p, String e, int ag){
					userName = u;
					passWord = p;
					eMail = e;
					age = ag;
				}
				public User(){
					
				}
				
				//Setters
				public void setId(int i){
					iD = i;
				}
				public void setUserName(String n){
					userName = n;
				}
				
				public void setPassWord(String p){
					passWord = p;
				}
				
				public void setEmail(String e){
					eMail = e;
				}
				public void setAge(int ag){
					age = ag;
				}
				
				
				//Getters
				public int getId(){
					return iD;
				}
				public String getUserName(){
					return userName;
				}
				
				public String getPassWord(){
					return passWord;
				}
				
				public String getEmail(){
					return eMail;
				}
				
				public int getAge(){
					return age;
				}
				
				
				
				
				
				//Adds a new opject to the List users using the current data members
				public void addUser(String un, String pw, String em, int ag){
					setUserName(un);
					setPassWord(pw);
					setEmail(em);
					setAge(ag);
					users.add(new User(userName, passWord, eMail, age));
					users.get(users.size()-1).setId(users.size());
				}
				
				
				
				
	
			
				
				
				
				// Using Serializable
				
				public void read(){
					
					try{
						ObjectInputStream ois = new ObjectInputStream(new FileInputStream("resources/source"));
						 users = (List) ois.readObject();
						//System.out.println(toRead.size());
						ois.close();
					}catch(FileNotFoundException e){
						e.getMessage();
					}catch(IOException e){
						e.getMessage();
					}catch(ClassNotFoundException e){
						e.getMessage();
					}
					
				}
				
				public void write(){
					
					try{
						ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("resources/source"));
						oos.writeObject(users);
						oos.close();
					}catch(FileNotFoundException e){
						e.getMessage();
					}catch(IOException e){
						e.getMessage();
					}
				}
				
				
	
	
	
	
				
	
	
	
	
	
	
	
}	
