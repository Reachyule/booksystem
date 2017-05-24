package PO;  

import java.io.UnsupportedEncodingException;

public class Stuinfo  implements java.io.Serializable {  
     private String id;  
     private String name;  
     private String sex;  
     private int age;  
     private float weight;  
     public String getId() { 
        return this.id;  
    }  
    public void setId(String id) {  
        this.id = id;  
    }  
    public String getName() { 
    	return this.name;
    }  
    public void setName(String name) { 
        this.name = name;  
    }  
    public String getSex() { 
     	 /*String param=this.sex;
       	 try {
       		 param=new String(param.getBytes("ISO-8859-1"), "UTF-8");
    		} catch (UnsupportedEncodingException e) {
    			// TODO Auto-generated catch block
    			e.printStackTrace();
    		}
        return param;*/
        return this.sex;  
    }  
      
    public void setSex(String sex) {  
        this.sex = sex;  
    }  
    public int getAge() {  
        return this.age;  
    }  
    public void setAge(int age) {  
        this.age = age;  
    }  
    public float getWeight() {  
        return this.weight;  
    }  
      
    public void setWeight(float weight) {  
        this.weight = weight;  
    }  
}  