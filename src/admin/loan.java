package admin;
import java.io.UnsupportedEncodingException;
import java.util.List;  
import java.util.Map;
import java.text.SimpleDateFormat;
import javax.servlet.http.HttpServletRequest;
import javax.swing.JOptionPane;
import java.util.Calendar;
import java.util.Date;
import org.apache.struts2.ServletActionContext;
import Dao.StudentDao; 
import Dao.loanDao;
import Dao.tsaddDao;
import Dao.tsfindDao;
import Dao.tsupdateDao;
import PO.Book;
import PO.Loan;  

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport; 
public class loan extends ActionSupport{
	String error="0";
	private HttpServletRequest request;
	private String loantime;
	private String tsname;
	private String stuid; 
	private String returntime;
    private String message="input";  
    private List list;
	public String getReturntime() {
		return returntime;
	}
	public void setReturntime(String returntime) {
		this.returntime = returntime;
	}
	public String getLoantime() {
		return loantime;
	}
	public void setLoantime(String loantime) {
		this.loantime = loantime;
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
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public void validate(){
	if(this.getStuid()==null || this.getStuid().length()==0){ 
        addFieldError("stuid", "学号不能为空!");  
    }else{  
        StudentDao info = new StudentDao();  
        list = info.queryInfo("stuid",this.getStuid());  
        if(list.size()==0){  
            addFieldError("stuid", "学号尚未注册!");  
        }
        }}
	private void alert(String string) {
		// TODO Auto-generated method stub
		
	}
	public Loan loan(){  
		 Date d = new Date();
	        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	        String time=sdf.format(d);
	      Loan info = new Loan();
	        info.setTsname(this.getTsname());
	        info.setStuid(this.getStuid()); 
	        info.setLoantime(time);
	        //info.setReturntime("2012");
	        return info;  
	    } 
	public Book book(){
		tsfindDao dao=new tsfindDao();  
		List list1=dao.findInfo("tsname", this.getTsname());
		Book info=(Book)list1.get(0);
		int number= Integer.parseInt(info.getTsnumber());
		if(number>=1){
		number=number-1;
		String N=String.valueOf(number);
		info.setTsnumber(N);
		//info.setTsname(info.getTsname());
		//info.setTsimg(info.getTsimg());
		//info.setTsCBS(info.getTsCBS());
		//info.setTsJJ(info.getTsJJ());
		return info;}
		else{
			 error="error";
			 return info;
		}
	}
	public String execute(){  
		loanDao lr = new loanDao();
        String ri = lr.saveInfo(loan()); 
        tsupdateDao dao=new tsupdateDao();  
        boolean update=dao.updateInfo(book()); 
        if(ri.equals("success")&&!error.equals("error")){  
            message ="success";  
        }  
            return message;  
    }  
}