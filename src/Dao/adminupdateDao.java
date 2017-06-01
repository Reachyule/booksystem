package Dao;
import addHibernateFile.HibernateSessionFactory;  
import PO.Admin;  
import java.util.List;  
import javax.swing.JOptionPane;  
import org.hibernate.Query;  
import org.hibernate.Session;  
import org.hibernate.Transaction;  
public class adminupdateDao {
	private Transaction transaction;  
    private Session session;  
    private Query query;  
    HibernateSessionFactory getSession;
   public adminupdateDao(){};
	public boolean updateInfo(Admin info){  
        try{  
            session=HibernateSessionFactory.getSession();  
            transaction=session.beginTransaction();  
            session.update(info);  
            transaction.commit();  
            session.close();  
            return true;  
        }catch(Exception e){  
            message("updateInfo.error:"+e);   
            return false;  
        }  
    }
	public void message(String mess){  
        int type=JOptionPane.YES_NO_OPTION;  
        String title="提示信息";  
        JOptionPane.showMessageDialog(null, mess, title, type);  
    }  
}