package admin;

import com.opensymphony.xwork2.ActionSupport;
import java.io.UnsupportedEncodingException;
import java.util.List;


import Dao.tsupdate;  
import PO.Stu;   
import javax.swing.JOptionPane;  
public class stuupdate extends ActionSupport{
	private String stuid;
	private String stuname;
	private int stuage;
	private String stusex;
	private String stuclass;
	private String stupassword;
	private String password1;
	private String password2;
	private String message="input";   
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getStuid() {
		String param=stuid;
     	 try {
     		 param=new String(param.getBytes("ISO-8859-1"), "UTF-8");
  		} catch (UnsupportedEncodingException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
      return param;
       //return name;  
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getStuname() {
		String param=stuname;
     	 try {
     		 param=new String(param.getBytes("ISO-8859-1"), "UTF-8");
  		} catch (UnsupportedEncodingException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
      return param;
       //return name;  
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
	}
	
	public int getStuage() {
		return stuage;
	}
	public void setStuage(int stuage) {
		this.stuage = stuage;
	}
	public String getStusex() {
		String param=stusex;
     	 try {
     		 param=new String(param.getBytes("ISO-8859-1"), "UTF-8");
  		} catch (UnsupportedEncodingException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
      return param;
       //return name;  
	}
	public void setStusex(String stusex) {
		this.stusex = stusex;
	}
	public String getStuclass() {
		String param=stuclass;
     	 try {
     		 param=new String(param.getBytes("ISO-8859-1"), "UTF-8");
  		} catch (UnsupportedEncodingException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
      return param;
       //return name;  
	}
	public void setStuclass(String stuclass) {
		this.stuclass = stuclass;
	}
	public String getStupassword() {
		String param=stupassword;
     	 try {
     		 param=new String(param.getBytes("ISO-8859-1"), "UTF-8");
  		} catch (UnsupportedEncodingException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
      return param;
       //return name;  
	}
	public void setStupassword(String stupassword) {
		this.stupassword = stupassword;
	}
	public void validate(){  
		if(this.getStuid()==null || this.getStuid().length()==0){
            addFieldError("stuid", "学号不能为空!");  
        }
        if(this.getStuname()==null || this.getStuname().length()==0){
            addFieldError("stuname", "用户名不能为空!");  
        }  
        if(this.getPassword1()==null || this.getPassword1().length()==0){  
            addFieldError("password1", "登录密码不允许为空！");  
        }else if(this.getPassword2()==null || this.getPassword2().length()==0){  
            addFieldError("password2", "重复密码不允许为空！");  
        }else if(!this.getPassword1().equals(this.getPassword2())){  
            addFieldError("password2", "两次密码不一致！");  
        }  
    }
	public String execute() throws Exception{  
        tsupdate dao=new tsupdate();  
        boolean update=dao.updateInfo(info());  
        if(update){  
            message="success";  
        }  
        return message;  
    }  
	public Stu info(){  
        Stu info = new Stu();
        info.setStuid(this.getStuid());
        info.setStuname(this.getStuname());
        info.setStuage(this.getStuage());
        info.setStusex(this.getStusex());
        info.setStuclass(this.getStuclass());
        info.setStupassword(this.getPassword1());  
        return info;  
    }  
      
	public void message(String mess){  
        int type=JOptionPane.YES_NO_OPTION;  
        String title="提示信息";  
        JOptionPane.showMessageDialog(null, mess, title, type);  
    }  
}
