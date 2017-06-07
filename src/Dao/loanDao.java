package Dao;
import java.util.List;  
import javax.swing.JOptionPane;  
import PO.Loan;  
import org.hibernate.Query;  
import org.hibernate.Session;  
import org.hibernate.Transaction;  
  
import addHibernateFile.HibernateSessionFactory;  
public class loanDao {
	private Session session;  
    private Transaction transaction;  
    private Query query;  
    HibernateSessionFactory getSession;  
    public loanDao(){}
    public String saveInfo(Loan info) {  
        String mess = "error";  
        getSession = new HibernateSessionFactory();  
        session = getSession.getSession();  
        try {  
            transaction = session.beginTransaction();  
            session.save(info);  
            transaction.commit();  
            mess = "success";  
            return mess;  
        } catch (Exception e) {  
            message("LoanDao.error:" + e);  
            e.printStackTrace();  
            return null;  
        }  
    }  
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
            message("findInfo.error:"+e);  
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
