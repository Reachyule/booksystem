package Dao;
import addHibernateFile.HibernateSessionFactory;  
import PO.Admin;  
import java.util.List;  
import javax.swing.JOptionPane;  
import org.hibernate.Query;  
import org.hibernate.Session;  
import org.hibernate.Transaction;  
public class adminfindDao {
	private Transaction transaction;  
    private Session session;  
    private Query query;  
    HibernateSessionFactory getSession;
    public adminfindDao(){}
    public List findInfo(String type,Object value){  
        session=HibernateSessionFactory.getSession();  
        try{  
            transaction=session.beginTransaction();  
            String queryString="from Admin as model where model."+type+"=?";  
            query=session.createQuery(queryString);  
            query.setParameter(0, value);  
            List list=query.list();  
            transaction.commit();  
            session.close();  
            return list;  
        }catch(Exception e){  
            message("findInfo.error:"+e);  
            e.printStackTrace();  
            return null;  
        }  
    }  
    public void message(String mess){  
        int type=JOptionPane.YES_NO_OPTION;  
        String title="提示信息";  
        JOptionPane.showMessageDialog(null, mess, title, type);  
    }  
}