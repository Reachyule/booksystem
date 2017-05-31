package admin;  
  
import Dao.studelDao;  
import com.opensymphony.xwork2.ActionSupport;  
import javax.swing.JOptionPane;  
  
public class studel extends ActionSupport{  
    private String stuid;  
    private String message;  

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
        studelDao dao=new studelDao();  
        boolean del=dao.deleteInfo(this.getStuid());  
        if(del){  
            message="success";  
        }  
        return message;  
    }  
    public void message(String mess){  
        int type=JOptionPane.YES_NO_OPTION;  
        String title="提示信息";  
        JOptionPane.showMessageDialog(null, mess, title, type);  
    }  
}  