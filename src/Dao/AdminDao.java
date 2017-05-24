package Dao;  
  
import addHibernateFile.HibernateSessionFactory;  
import PO.Admin;  
import java.util.List;  
import javax.swing.JOptionPane;  
import org.hibernate.Query;  
import org.hibernate.Session;  
import org.hibernate.Transaction;  
  
public class AdminDao {  
    private Transaction transaction;  
    private Session session;  
    private Query query;  
    HibernateSessionFactory getSession;
    public AdminDao(){  
    }  
    public List queryInfo(String type, Object value) {  
        getSession = new HibernateSessionFactory();  
        session = getSession.getSession();  
        transaction = session.beginTransaction();   
        try {  
            String hqlsql = "from Admin as u where u.adminname=?";  
            query = session.createQuery(hqlsql);  
            query.setParameter(0, value);  
            List list = query.list();  
            transaction.commit();  
            return list;  
        } catch (Exception e) {  
            message("loginRegisterDao类中有异常,异常为:" + e);  
            e.printStackTrace();  
            return null;  
        }  
    }  
  
    public void message(String mess) {  
        int type = JOptionPane.YES_NO_OPTION;  
        String title = "提示信息";  
        JOptionPane.showMessageDialog(null, mess, title, type);  
    }  
}  