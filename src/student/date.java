package student;
import Dao.dateDao;  
import com.opensymphony.xwork2.ActionSupport;  
import java.util.List;  
import javax.servlet.http.HttpServletRequest;  
import javax.swing.JOptionPane;  
import org.apache.struts2.ServletActionContext;  
public class date extends ActionSupport{
	private String stuid;  
    private HttpServletRequest request;  
    private String message="input";
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String execute() throws Exception{ 
        request=ServletActionContext.getRequest();  
        dateDao dao=new dateDao();  
        List list=dao.findInfo("stuid", request.getSession().getAttribute("NUMBER"));  
        request.getSession().setAttribute("dateallInfo", list);  
        message="success";  
        return message;  
    }  
    public void message(String mess){  
        int type=JOptionPane.YES_NO_OPTION;  
        String title="提示信息";  
        JOptionPane.showMessageDialog(null, mess, title, type);  
    }  
}
