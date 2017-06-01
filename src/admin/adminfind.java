package admin;  
  
import Dao.adminfindDao;  
import com.opensymphony.xwork2.ActionSupport;  
import java.util.List;  
import javax.servlet.http.HttpServletRequest;  
import javax.swing.JOptionPane;  
import org.apache.struts2.ServletActionContext;  
  
public class adminfind extends ActionSupport{ 
	private String adminname;
    private HttpServletRequest request;  
    private String message="input"; 
    
	public String getAdminname() {
		return adminname;
	}
	public void setAdminname(String adminname) {
		this.adminname = adminname;
	}
	public void validate(){  
        if(this.getAdminname().equals("null")){  
            message("暂无学生信息！");  
            addFieldError("adminname","暂无学生信息！");  
        }  
    }  
    public String execute() throws Exception{  
        request=ServletActionContext.getRequest();  
        adminfindDao dao=new adminfindDao();  
        List list=dao.findInfo("adminname", this.getAdminname());  
        request.getSession().setAttribute("oneInfo", list);  
        message="success";  
        return message;  
    }  
    public void message(String mess){  
        int type=JOptionPane.YES_NO_OPTION;  
        String title="提示信息";  
        JOptionPane.showMessageDialog(null, mess, title, type);  
    }  
}  