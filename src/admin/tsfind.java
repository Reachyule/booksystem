package admin;
import Dao.tsfindDao;  
import com.opensymphony.xwork2.ActionSupport;  
import java.util.List;  
import javax.servlet.http.HttpServletRequest;  
import javax.swing.JOptionPane;  
import org.apache.struts2.ServletActionContext;  
public class tsfind extends ActionSupport{
	private String tsname;
    private HttpServletRequest request;  
    private String message="input"; 
    

	public String getTsname() {
		return tsname;
	}
	public void setTsname(String tsname) {
		this.tsname = tsname;
	}
	public void validate(){  
        if(this.getTsname().equals("null")){  
            message("暂无图书信息！");  
            addFieldError("tsname","暂无图书信息！");  
        }  
    }  
    public String execute() throws Exception{  
        request=ServletActionContext.getRequest();  
        tsfindDao dao=new tsfindDao();  
        List list=dao.findInfo("tsname", this.getTsname());  
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
