package admin;
import com.opensymphony.xwork2.ActionSupport;
import java.io.UnsupportedEncodingException;
import java.util.List;
import Dao.tsupdateDao;  
import PO.Book;   
import javax.swing.JOptionPane;  
public class tsupdate extends ActionSupport{
	private String tsname;
	private String tsJJ;
	private String tsCBS;
	private String tsnumber;
	private String message="input";
	private String tsimg;
	public String getTsimg() {
		return tsimg;
	}
	public void setTsimg(String tsimg) {
		this.tsimg = tsimg;
	}
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
	public String getTsJJ() {
		String param=tsJJ;
   	 try {
   		 param=new String(param.getBytes("ISO-8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    return param;
     //return tsJJ;  
	}
	public void setTsJJ(String tsJJ) {
		this.tsJJ = tsJJ;
	}
	public String getTsCBS() {
		String param=tsCBS;
	   	 try {
	   		 param=new String(param.getBytes("ISO-8859-1"), "UTF-8");
			} catch (UnsupportedEncodingException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    return param;
	     //return tsCBS; 
	}
	public void setTsCBS(String tsCBS) {
		this.tsCBS = tsCBS;
	}
	public String getTsnumber() {
		return tsnumber;
	}
	public void setTsnumber(String tsnumber) {
		this.tsnumber = tsnumber;
	}
	public void validate(){ 
		if(this.getTsname()==null || this.getTsname().length()==0){
            addFieldError("tsname", "图书名不能为空!");  
        }
		if(this.getTsCBS()==null || this.getTsCBS().length()==0){  
            addFieldError("tsCBS", "出版社不允许为空！");  }
        if(this.getTsnumber()==null || this.getTsnumber().length()==0){  
            addFieldError("tsnumber", "库存不允许为空！");  }
        if(this.getTsJJ()==null || this.getTsJJ().length()==0){  
            addFieldError("tsJJ", "简介不允许为空！");  }
	}
	public String execute() throws Exception{  
        tsupdateDao dao=new tsupdateDao();  
        boolean update=dao.updateInfo(info());  
        if(update){  
            message="success";  
        }  
        return message;  
    }  
	public Book info(){  
        Book info = new Book();
        info.setTsname(this.getTsname());
        info.setTsCBS(this.getTsCBS());
        info.setTsnumber(this.getTsnumber());
        info.setTsJJ(this.getTsJJ());
        info.setTsimg(this.getTsimg());
        return info;  
    }  
      
	public void message(String mess){  
        int type=JOptionPane.YES_NO_OPTION;  
        String title="提示信息";  
        JOptionPane.showMessageDialog(null, mess, title, type);  
    }  
}
