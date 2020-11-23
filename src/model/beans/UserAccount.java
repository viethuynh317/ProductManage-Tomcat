package model.beans;
 
public class UserAccount {
 
   public static final String GENDER_MALE ="Nam";
   public static final String GENDER_FEMALE = "Nữ";
    
   private String userName;
   private String gender;
   private String password;
   private int age;
   private String name;
   private String email;
 


public UserAccount() {
        
   }
    
	public UserAccount(String userName, String password, String name, String gender, int age, String email) {
		this.userName = userName;
		this.password = password;
		this.gender = gender;
		this.name = name;
		this.age  = age;
		this.email = email;	
	}

   public String getUserName() {
       return userName;
   }
 
   public void setUserName(String userName) {
       this.userName = userName;
   }
 
   public String getGender() {
       return gender;
   }
 
   public void setGender(String gender) {
       this.gender = gender;
   }
 
   public String getPassword() {
       return password;
   }
 
   public void setPassword(String password) {
       this.password = password;
   }
 
   public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
   
}