package admin;
import Dao.logDao;  
import com.opensymphony.xwork2.ActionSupport;  
import java.util.List;  
import javax.servlet.http.HttpServletRequest;  
import org.apache.struts2.ServletActionContext;  
public class log extends ActionSupport{
	private HttpServletRequest request;  
    private String message="input";  
    public String execute() throws Exception{  
        request=ServletActionContext.getRequest();  
        logDao dao=new logDao();  
        List list=dao.findAllInfo();  
        request.getSession().setAttribute("logcount", list.size());  
        request.getSession().setAttribute("logallInfo", list);  
        message="success";  
        return message;  
    }  
}
