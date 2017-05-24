package login;
import java.io.UnsupportedEncodingException;
import java.util.List;  
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;

import org.apache.struts2.ServletActionContext;

import Dao.StudentDao;  
import PO.Stu;  

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport; 
public class login extends ActionSupport {
	 private HttpServletRequest request;
	private String stuid;  
    private String stupassword;  
    private String message="error";  
    private List list;
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getStupassword() {
		return stupassword;
	}
	public void setStupassword(String stupassword) {
		this.stupassword = stupassword;
	} 
	public void validate(){
		
		if(this.getStuid()==null || this.getStuid().length()==0){ 
            addFieldError("stuid", "学号不能为空!");  
        }else{  
            StudentDao info = new StudentDao();  
            list = info.queryInfo("stuid",this.getStuid());  
            if(list.size()==0){  
                addFieldError("stuid", "学号尚未注册!");  
            }else{  
                Stu ui = new Stu();  
                int count = 0;  
                for(int i=0; i<list.size(); i++){  
                    count++;  
                    ui = (Stu)list.get(i);  
                    if(this.getStuid().equals(ui.getStuid())){  
                        if(ui.getStupassword().equals(this.getStupassword())){  
                            message = SUCCESS;
                            request=ServletActionContext.getRequest(); 
                            request.getSession().setAttribute("NUMBER", this.getStuid());
                        }else{  
                            addFieldError("stupassword", "登录密码不正确!");  
                        }  
                    }  
                }  
            }  
        }  
	}
	private void alert(String string) {
		// TODO Auto-generated method stub
		
	}
	public String execute(){  
            return message;  
    }  
}
