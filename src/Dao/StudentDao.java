package Dao;  
  
import addHibernateFile.HibernateSessionFactory;  
import PO.Stuinfo;  
import java.util.List;  
import javax.swing.JOptionPane;  
import org.hibernate.Query;  
import org.hibernate.Session;  
import org.hibernate.Transaction;  
  
public class StudentDao {  
    private Transaction transaction;  
    private Session session;  
    private Query query;  
    HibernateSessionFactory getSession;
    public StudentDao(){  
    }  
    public boolean  saveInfo(Stuinfo info){  
        try{  
            session=HibernateSessionFactory.getSession();  
            transaction=session.beginTransaction();  
            session.save(info);  
            transaction.commit();  
            session.close();  
            return true;  
        }catch(Exception e){  
            message("saveInfo.error:"+e);  
            e.printStackTrace();  
            return false;  
        }  
    }  
    public List findInfo(String type,Object value){  
        session=HibernateSessionFactory.getSession();  
        try{  
            transaction=session.beginTransaction();  
            String queryString="from Stuinfo as model where model."+type+"=?";  
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
    
    public List findAllInfo(){  
        session=HibernateSessionFactory.getSession();  
        try{  
            transaction=session.beginTransaction();  
            String queryString="from Stuinfo";  
            query=session.createQuery(queryString);  
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
    public boolean deleteInfo(String id){  
        try{  
            session=HibernateSessionFactory.getSession();  
            transaction=session.beginTransaction();  
            Stuinfo info=new Stuinfo();  
            info=(Stuinfo)session.get(Stuinfo.class, id);  
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
    public boolean updateInfo(Stuinfo info){  
        try{  
            session=HibernateSessionFactory.getSession();  
            transaction=session.beginTransaction();  
            session.update(info);  
            transaction.commit();  
            session.close();  
            return true;  
        }catch(Exception e){  
            message("updateInfo.error:"+e);  
            e.printStackTrace();  
            return false;  
        }  
    }
    public List queryInfo(String type, Object value) {  
        getSession = new HibernateSessionFactory();  
        session = getSession.getSession();  
        transaction = session.beginTransaction();   
        try {  
            String hqlsql = "from Stu as u where u.stuid=?";  
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
    public void message(String mess){  
        int type=JOptionPane.YES_NO_OPTION;  
        String title="提示信息";  
        JOptionPane.showMessageDialog(null, mess, title, type);  
    }  
}  