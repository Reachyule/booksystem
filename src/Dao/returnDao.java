package Dao;
import addHibernateFile.HibernateSessionFactory;  
import PO.Loan;  
import java.util.List;  
import javax.swing.JOptionPane;  
import org.hibernate.Query;  
import org.hibernate.Session;  
import org.hibernate.Transaction; 
public class returnDao {
	private Transaction transaction;  
    private Session session;  
    private Query query;  
    HibernateSessionFactory getSession;
    public returnDao(){}
    public List findInfo(String type,Object value){  
        session=HibernateSessionFactory.getSession();  
        try{  
            transaction=session.beginTransaction();  
            String queryString="from Loan as model where model."+type+"=?";  
            query=session.createQuery(queryString);  
            query.setParameter(0, value);  
            List list=query.list();  
            transaction.commit();  
            session.close();  
            return list;  
        }catch(Exception e){  
            message("tsfindDao.error:"+e);  
            e.printStackTrace();  
            return null;  
        }  
    }  
    public boolean updateInfo(Loan info){  
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
