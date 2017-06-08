package admin;
import java.io.UnsupportedEncodingException;

import Dao.tsdelDao;  
import com.opensymphony.xwork2.ActionSupport;  
import javax.swing.JOptionPane;  
public class tsdel extends ActionSupport{
	private String tsname;  
    private String message;
	public String getTsname() {
		String param=tsname;
   	 try {
   		 param=new String(param.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    return param;
     //return tsname;  
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
        tsdelDao dao=new tsdelDao();  
        boolean del=dao.deleteInfo(this.getTsname());  
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
