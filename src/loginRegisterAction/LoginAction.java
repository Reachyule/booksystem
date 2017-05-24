package loginRegisterAction;  
  
import java.util.List;  

import javax.swing.JOptionPane;

import loginRegisterDao.*;  
import PO.UserInfoPO;  

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;  
  
public class LoginAction extends ActionSupport {  
    private String userName;  
    private String password;  
    private String message="error";  
    private List list;  
    public String getUserName() {  
        return userName;  
    }  
    public void setUserName(String userName) {  
        this.userName = userName;  
    }  
    public String getPassword() {  
        return password;  
    }  
    public void setPassword(String password) {  
        this.password = password;  
    }  
  
      
    public void validate(){  
        if(this.getUserName()==null || this.getUserName().length()==0){ 
            addFieldError("userName", "用户名不能为空!");  
        }else{  
            LoginRegisterInfo info = new LoginRegisterInfo();  
            list = info.queryInfo("userName",this.getUserName());  
            if(list.size()==0){  
                addFieldError("userName", "该用户尚未注册！");  
            }else{  
                UserInfoPO ui = new UserInfoPO();  
                int count = 0;  
                for(int i=0; i<list.size(); i++){  
                    count++;  
                    ui = (UserInfoPO)list.get(i);  
                    if(this.getUserName().equals(ui.getUserName())){  
                        if(ui.getPassword().equals(this.getPassword())){  
                            message = SUCCESS;  
                        }else{  
                            addFieldError("password", "登录密码不正确!");  
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