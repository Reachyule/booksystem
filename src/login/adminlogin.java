package login;
import java.io.UnsupportedEncodingException;
import java.util.List;  

import javax.swing.JOptionPane;

import Dao.AdminDao;  
import PO.Admin;  
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport; 
public class adminlogin extends ActionSupport{
	private String adminname;  
    private String adminpassword;  
    private String message="error";  
    private List list;
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
        }else{  
            AdminDao info = new AdminDao();  
            list = info.queryInfo("adminname",this.getAdminname());  
            if(list.size()==0){  
                addFieldError("adminname", "账号不存在!");  
            }else{  
                Admin ui = new Admin();  
                int count = 0;  
                for(int i=0; i<list.size(); i++){  
                    count++;  
                    ui = (Admin)list.get(i);  
                    if(this.getAdminname().equals(ui.getAdminname())){  
                        if(ui.getAdminpassword().equals(this.getAdminpassword())){  
                            message = SUCCESS;  
                        }else{  
                            addFieldError("adminpassword", "登录密码不正确!");  
                        }  
                    }  
                }  
            }  
        }  
	}
	private void alert(String string) {
		// TODO Auto-generated method stub
		
	}
	public String execute(){  
            return message;  
    }  
}
