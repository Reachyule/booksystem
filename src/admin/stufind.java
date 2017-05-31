package admin;  
  
import Dao.stufindDao;  
import com.opensymphony.xwork2.ActionSupport;  
import java.util.List;  
import javax.servlet.http.HttpServletRequest;  
import javax.swing.JOptionPane;  
import org.apache.struts2.ServletActionContext;  
  
public class stufind extends ActionSupport{  
    private String stuid;  
    private HttpServletRequest request;  
    private String message="input";  
    public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public void validate(){  
        if(this.getStuid().equals("null")){  
            message("暂无学生信息！");  
            addFieldError("stuid","暂无学生信息！");  
        }  
    }  
    public String execute() throws Exception{  
        request=ServletActionContext.getRequest();  
        stufindDao dao=new stufindDao();  
        List list=dao.findInfo("stuid", this.getStuid());  
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