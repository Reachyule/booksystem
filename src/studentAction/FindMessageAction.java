package studentAction;  
  
import Dao.StudentDao;  
import com.opensymphony.xwork2.ActionSupport;  
import java.util.List;  
import javax.servlet.http.HttpServletRequest;  
import javax.swing.JOptionPane;  
import org.apache.struts2.ServletActionContext;  
  
public class FindMessageAction extends ActionSupport{  
    private String id;  
    private HttpServletRequest request;  
    private String message="input";  
    public String getId() {  
        return id;  
    }  
    public void setId(String id) {  
        this.id = id;  
    }  
    public void validate(){  
        if(this.getId().equals("null")){  
            message("暂无学生信息！");  
            addFieldError("id","暂无学生信息！");  
        }  
    }  
    public String execute() throws Exception{  
        request=ServletActionContext.getRequest();  
        StudentDao dao=new StudentDao();  
        List list=dao.findInfo("id", this.getId());  
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