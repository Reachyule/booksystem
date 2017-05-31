package admin;
import Dao.adminqueryDao;  
import com.opensymphony.xwork2.ActionSupport;  
import java.util.List;  
import javax.servlet.http.HttpServletRequest;  
import org.apache.struts2.ServletActionContext;  
public class adminquery extends ActionSupport{
	private HttpServletRequest request;  
    private String message="input";  
    public String execute() throws Exception{  
        request=ServletActionContext.getRequest();  
        adminqueryDao dao=new adminqueryDao();  
        List list=dao.findAllInfo();  
        request.getSession().setAttribute("count", list.size());  
        request.getSession().setAttribute("allInfo", list);  
        message="success";  
        return message;  
    }  
}
