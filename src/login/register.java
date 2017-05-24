package login;
import java.util.List;  
import java.io.UnsupportedEncodingException;
import javax.swing.JOptionPane;  
import PO.Stu;  
import Dao.StudentDao;
import Dao.loginRegisterDao;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;  
public class register extends ActionSupport{
	private String stuid;  
    private String stuname;  
    private String stusex;
    private int stuage;
    private String stuclass;
    private String password1;  
    private String password2;
    private String mess=ERROR;  
    private List list;


	public String getStuid() {
		String param=stuid;
     	 try {
     		 param=new String(param.getBytes("ISO-8859-1"), "UTF-8");
  		} catch (UnsupportedEncodingException e) {
  			// TODO Auto-generated catch block
  			e.printStackTrace();
  		}
      return param;
		//return stuid;
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
		//return stuname;
	}
	public void setStuname(String stuname) {
		this.stuname = stuname;
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
		//return stusex;
	}
	public void setStusex(String stusex) {
		this.stusex = stusex;
	}
	public int getStuage() {
		return stuage;
	}
	public void setStuage(int stuage) {
		this.stuage = stuage;
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
		//return stuclass;
	}
	public void setStuclass(String stuclass) {
		this.stuclass = stuclass;
	}
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
	public void validate(){
		if(this.getStuid()==null || this.getStuid().length()==0){
            addFieldError("stuid", "学号不能为空!");  
        }else{  
        	loginRegisterDao dao=new loginRegisterDao();  
            List list=dao.findInfo("stuid", this.getStuid()); 
            if(!list.isEmpty()){  
                addFieldError("stuid","学号已存在!");  
            }  
         
        }  
        if(this.getStuname()==null || this.getStuname().length()==0){
            addFieldError("stuname", "用户名不能为空!");  
        }else{  
           loginRegisterDao info = new loginRegisterDao();  
            list = info.queryInfo("stuname",this.getStuname());  
            Stu ui = new Stu();  
            for(int i=0; i<list.size(); i++){  
                ui = (Stu)list.get(i);  
                if(ui.getStuname().equals(this.getStuname())){  
                    addFieldError("stuname", "用户名已存在！");  
                }  
            }  
        }  
        if(this.getPassword1()==null || this.getPassword1().length()==0){  
            addFieldError("password1", "登录密码不允许为空！");  
        }else if(this.getPassword2()==null || this.getPassword2().length()==0){  
            addFieldError("password2", "重复密码不允许为空！");  
        }else if(!this.getPassword1().equals(this.getPassword2())){  
            addFieldError("password2", "两次密码不一致！");  
        }  
    }
	private void alert(String string) {
		// TODO Auto-generated method stub
		
	}
	public Stu stu(){  
        Stu info = new Stu();
        info.setStuid(this.getStuid());
        info.setStuname(this.getStuname());
        info.setStuage(this.getStuage());
        info.setStusex(this.getStusex());
        info.setStuclass(this.getStuclass());
        info.setStupassword(this.getPassword1());  
        return info;  
    }  
      
    public String execute() throws Exception{  
    	loginRegisterDao lr = new loginRegisterDao();  
        String ri = lr.saveInfo(stu());  
        if(ri.equals("success")){  
            mess ="success";  
        }  
        return mess;  
    }  
}
