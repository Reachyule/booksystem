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
            addFieldError("userName", "�û�������Ϊ��!");  
        }else{  
            LoginRegisterInfo info = new LoginRegisterInfo();  
            list = info.queryInfo("userName",this.getUserName());  
            if(list.size()==0){  
                addFieldError("userName", "���û���δע�ᣡ");  
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
                            addFieldError("password", "��¼���벻��ȷ!");  
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