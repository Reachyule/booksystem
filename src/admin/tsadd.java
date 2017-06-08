package admin;
import java.io.File;  
import java.io.FileInputStream;  
import java.io.FileOutputStream;  
import org.apache.struts2.ServletActionContext;  
import com.opensymphony.xwork2.ActionSupport;
import java.util.List;  
import java.io.UnsupportedEncodingException;
import javax.swing.JOptionPane;  
import PO.Book;  
import Dao.tsaddDao;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;  
public class tsadd extends ActionSupport{
	private String tsname;
	private File upload;
	private String uploadFileName;
	private String savePath;
	private String tsCBS;
	private String tsimg;
	private String tsnumber;
	private String tsJJ;
	private String mess=ERROR;  
    private List list;
    
	public String getTsimg() {
		return tsimg;
	}
	public void setTsimg(String tsimg) {
		this.tsimg = tsimg;
	}
	public String getTsCBS() {

     return tsCBS;  
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
	public String getTsJJ() {
     return tsJJ;  
	}
	public void setTsJJ(String tsJJ) {
		this.tsJJ = tsJJ;
	}
	public String getTsname() {
     return tsname;  
	}
	public void setTsname(String tsname) {
		this.tsname = tsname;
	}
	public File getUpload() {
		return upload;
	}
	public void setUpload(File upload) {
		this.upload = upload;
	}
	public String getUploadFileName() {
		return uploadFileName;
	}
	public void setUploadFileName(String uploadFileName) {
		this.uploadFileName = uploadFileName;
	}

	public void setSavePath(String savePath) {
		this.savePath = savePath;
	}
	public String getSavePath() throws Exception{
		return ServletActionContext.getServletContext().getRealPath(savePath);
	}
	public void validate(){
		if(this.getTsname()==null || this.getTsname().length()==0){
            addFieldError("tsname", "图书名不能为空!");  
        }else{  
        	tsaddDao dao=new tsaddDao();  
            List list=dao.findInfo("tsname", this.getTsname()); 
            if(!list.isEmpty()){  
                addFieldError("tsname","该图书已存在!");  
            }  
         
        }  
        if(this.getTsCBS()==null || this.getTsCBS().length()==0){  
            addFieldError("tsCBS", "出版社不允许为空！");  }
        if(this.getTsnumber()==null || this.getTsnumber().length()==0){  
            addFieldError("tsnumber", "库存不允许为空！");  }
        if(this.getTsJJ()==null || this.getTsJJ().length()==0){  
            addFieldError("tsJJ", "简介不允许为空！");  }
    }
	private void alert(String string) {
		// TODO Auto-generated method stub
		
	}
	public Book book(){  
	      Book info = new Book();
	        info.setTsname(this.getTsname());
	        info.setTsCBS(this.getTsCBS());
	        info.setTsnumber(this.getTsnumber());
	        info.setTsJJ(this.getTsJJ());
	        info.setTsimg(this.getUploadFileName());
	        return info;  
	    }  
	public String execute()throws Exception{
		tsaddDao lr = new tsaddDao();  
        String ri = lr.saveInfo(book());  
		FileOutputStream fos = new FileOutputStream(getSavePath()
				+"\\"+getUploadFileName());
		FileInputStream fis = new FileInputStream(getUpload());
		byte[] buffer = new byte [1024];
		int len=0;
		while ((len=fis.read(buffer))>0){
			fos.write(buffer,0,len);
		}
		fos.close();
		 if(ri.equals("success")){  
	            mess ="success";  
	        }  
	        return mess; 
	}
}
