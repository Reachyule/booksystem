package Dao;
import addHibernateFile.HibernateSessionFactory;  
import PO.Book;  
import java.util.List;  
import javax.swing.JOptionPane;  
import org.hibernate.Query;  
import org.hibernate.Session;  
import org.hibernate.Transaction;  
public class tsdelDao {
	private Transaction transaction;  
    private Session session;  
    private Query query;  
    HibernateSessionFactory getSession;
    public tsdelDao(){}
    public boolean deleteInfo(String id){  
        try{  
            session=HibernateSessionFactory.getSession();  
            transaction=session.beginTransaction();  
            Book info=new Book();  
            info=(Book)session.get(Book.class, id);  
            session.delete(info);  
            transaction.commit();  
            session.close();  
            return true;  
        }catch(Exception e){  
            message("tsdelDao.error:"+e);  
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
