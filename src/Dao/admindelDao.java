package Dao;

import addHibernateFile.HibernateSessionFactory;  
import PO.Admin;  
import java.util.List;  
import javax.swing.JOptionPane;  
import org.hibernate.Query;  
import org.hibernate.Session;  
import org.hibernate.Transaction;  
public class admindelDao {
	private Transaction transaction;  
    private Session session;  
    private Query query;  
    HibernateSessionFactory getSession;
    public admindelDao(){}
    public boolean deleteInfo(String id){  
        try{  
            session=HibernateSessionFactory.getSession();  
            transaction=session.beginTransaction();  
            Admin info=new Admin();  
            info=(Admin)session.get(Admin.class, id);  
            session.delete(info);  
            transaction.commit();  
            session.close();  
            return true;  
        }catch(Exception e){  
            message("deleteInfo.error:"+e);  
            e.printStackTrace();  
            return false;  
        }  
    }  
    public void message(String mess){  
        int type=JOptionPane.YES_NO_OPTION;  
        String title="提示信息";  
        JOptionPane.showMessageDialog(null, mess, title, type);  
    }  
}
