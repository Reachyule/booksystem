package admin;
import Dao.stuqueryDao;  
import com.opensymphony.xwork2.ActionSupport;  
import java.util.List;  
import javax.servlet.http.HttpServletRequest;  
import org.apache.struts2.ServletActionContext;  
public class stuquery extends ActionSupport{
	private HttpServletRequest request;  
    private String message="input";  
    public String execute() throws Exception{  
        request=ServletActionContext.getRequest();  
        stuqueryDao dao=new stuqueryDao();  
        List list=dao.findAllInfo();  
        request.getSession().setAttribute("count", list.size());  
        request.getSession().setAttribute("allInfo", list);  
        message="success";  
        return message;  
    }  
}
