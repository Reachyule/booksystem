package admin;

import Dao.admindelDao;  
import com.opensymphony.xwork2.ActionSupport;  
import javax.swing.JOptionPane;  
  
public class admindel extends ActionSupport{  
    private String adminname;  
    private String message;  

	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public void validate(){  
        if(this.getAdminname().equals("null")){  
            message("暂无管理员信息！");  
            addFieldError("adminname","暂无管理员信息！");  
        }  
    }  
    public String execute() throws Exception{  
        admindelDao dao=new admindelDao();  
        boolean del=dao.deleteInfo(this.getAdminname());  
        if(del){  
            message="success";  
        }  
        return message;  
    }  
    public void message(String mess){  
        int type=JOptionPane.YES_NO_OPTION;  
        String title="提示信息";  
        JOptionPane.showMessageDialog(null, mess, title, type);  
    }  
}  