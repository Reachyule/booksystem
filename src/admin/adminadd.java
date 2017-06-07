package admin;
import java.util.List;  
import java.io.UnsupportedEncodingException;
import javax.swing.JOptionPane;  
import PO.Admin;  
import Dao.adminaddDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;  
public class adminadd extends ActionSupport {
	private String adminname;
    private String password1;  
    private String password2;
    private String mess=ERROR;  
    private List list;
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
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
		if(this.getAdminname()==null || this.getAdminname().length()==0){
            addFieldError("adminname", "账号不能为空!");  
        }else{  
        	adminaddDao dao=new adminaddDao();  
            List list=dao.findInfo("adminname", this.getAdminname()); 
            if(!list.isEmpty()){  
                addFieldError("adminname","学号已存在!");  
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
	public Admin admin(){  
       Admin info = new Admin();
        info.setAdminname(this.getAdminname());
        info.setAdminpassword(this.getPassword1());  
        return info;  
    }  
      
    public String execute() throws Exception{  
    	adminaddDao lr = new adminaddDao();  
        String ri = lr.saveInfo(admin());  
        if(ri.equals("success")){  
            mess ="success";  
        }  
        return mess;  
    }  
}
