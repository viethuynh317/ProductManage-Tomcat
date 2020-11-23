package model.beans;
 
public class Product {
 
   private String code;
   private String name;
   private float price;
   private int count;
   private String state;


public Product() {
	
}
 
   public Product(String code, String name, float price, int count, String state) {
       this.code = code;
       this.name = name;
       this.price = price;
       this.count = count;
       this.state = state;
   }
 
   public String getCode() {
       return code;
   }
 
   public void setCode(String code) {
       this.code = code;
   }
 
   public String getName() {
       return name;
   }
 
   public void setName(String name) {
       this.name = name;
   }
 
   public float getPrice() {
       return price;
   }
 
   public void setPrice(float price) {
       this.price = price;
   }
   public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}