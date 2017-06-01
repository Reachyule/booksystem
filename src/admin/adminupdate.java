package admin;

import com.opensymphony.xwork2.ActionSupport;
import java.io.UnsupportedEncodingException;
import java.util.List;
import Dao.adminupdateDao;  
import PO.Admin;   
import javax.swing.JOptionPane;  
public class adminupdate extends ActionSupport{
	private String id;
	private String adminname;
	private String adminpassword;
	private String password1;
	private String password2;
	private String message="input";
	

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
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
	
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public String getAdminpassword() {
		return adminpassword;
	}
	public void setAdminpassword(String adminpassword) {
		this.adminpassword = adminpassword;
	}
	public void validate(){  
		if(this.getAdminname()==null || this.getAdminname().length()==0){
            addFieldError("adminname", "账号不能为空!");  
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
        adminupdateDao dao=new adminupdateDao();  
        boolean update=dao.updateInfo(info());  
        if(update){  
            message="success";  
        }  
        return message;  
    }  
	public Admin info(){  
        Admin info = new Admin();
        info.setAdminname(this.getAdminname());
        info.setAdminpassword(this.getPassword1());
        return info;  
    }  
      
	public void message(String mess){  
        int type=JOptionPane.YES_NO_OPTION;  
        String title="提示信息";  
        JOptionPane.showMessageDialog(null, mess, title, type);  
    }  
}
