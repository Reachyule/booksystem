package admin;
import Dao.tsqueryDao;  
import com.opensymphony.xwork2.ActionSupport;  
import java.util.List;  
import javax.servlet.http.HttpServletRequest;  
import org.apache.struts2.ServletActionContext;  
public class tsquery extends ActionSupport{
	private HttpServletRequest request;  
    private String message="input";  
    public String execute() throws Exception{  
        request=ServletActionContext.getRequest();  
        tsqueryDao dao=new tsqueryDao();  
        List list=dao.findAllInfo();  
        request.getSession().setAttribute("count", list.size());  
        request.getSession().setAttribute("allInfo", list);  
        message="success";  
        return message;  
    }  
}
