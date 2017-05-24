package studentAction;  
  
import Dao.StudentDao;  
import com.opensymphony.xwork2.ActionSupport;  
import java.util.List;  
import javax.servlet.http.HttpServletRequest;  
import org.apache.struts2.ServletActionContext;  
  
public class LookMessageAction extends ActionSupport{  
    private HttpServletRequest request;  
    private String message="input";  
    public String execute() throws Exception{  
        request=ServletActionContext.getRequest();  
        StudentDao dao=new StudentDao();  
        List list=dao.findAllInfo();  
        request.getSession().setAttribute("count", list.size());  
        request.getSession().setAttribute("allInfo", list);  
        message="success";  
        return message;  
    }  
}  