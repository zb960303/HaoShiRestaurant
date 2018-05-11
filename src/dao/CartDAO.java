package dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.transaction.annotation.Transactional;

import entity.Cart;

/**
 * A data access object (DAO) providing persistence and search support for Cart
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see entity.Cart
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class CartDAO {
	private static final Logger log = LoggerFactory.getLogger(CartDAO.class);
	// property constants
	public static final String FNUM = "fnum";
	public static final String FPRICE = "fprice";
	public static final String FID = "fid";
	public static final String TID = "tid";

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	private Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	protected void initDao() {
		// do nothing
	}

	public int save(Cart transientInstance) {
		log.debug("saving Cart instance");
		try {
			getCurrentSession().save(transientInstance);
			return 1;
			//log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
			
		}
	}

	public void delete(Cart persistentInstance) {
		log.debug("deleting Cart instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Cart findById(java.lang.Integer id) {
		log.debug("getting Cart instance with id: " + id);
		try {
			Cart instance = (Cart) getCurrentSession().get("entity.Cart", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Cart instance) {
		log.debug("finding Cart instance by example");
		try {
			List results = getCurrentSession().createCriteria("entity.Cart")
					.add(Example.create(instance)).list();
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Cart instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Cart as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFnum(Object fnum) {
		return findByProperty(FNUM, fnum);
	}

	public List findByFprice(Object fprice) {
		return findByProperty(FPRICE, fprice);
	}
	
	public List findByFID(Object fid,Object tid) {
		String queryString = "from Cart as model where model.food.fid"
				 + "= ? and model.table.tid "+" = ?";
		Query queryObject = getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, fid);
		queryObject.setParameter(1, tid);
		return queryObject.list();
	}
	
	public List findByTID(Object tid) {
		List<Object[]> objects = null;
		List<Cart> list = new ArrayList<Cart>();
		String queryString = " from Cart c ,Food f,Table t where c.food.fid =f.fid and c.table.tid=t.tid and c.table.tid "+" = ?";
		Query queryObject = getCurrentSession().createQuery(queryString);
		queryObject.setParameter(0, tid);
		objects = queryObject.list();
        for (int i = 0; i < objects.size(); i++) {
            Object[] obs = objects.get(i);
            Cart cart = (Cart) obs[0];
            list.add(cart);
        }
		return list;
	}
	public Double SumPrice(int TID){
		String hql="select sum(c.fprice) from Cart c where c.table.tid ="+ TID ;
		Double sum=(Double) getCurrentSession().createQuery(hql).uniqueResult();
		return sum;
	}
	
	public List findAll() {
		log.debug("finding all Cart instances");
		try {
			String queryString = "from Cart";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public int merge(Cart detachedInstance) {
		log.debug("merging Cart instance");
		try {
			Cart result = (Cart) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Cart instance) {
		log.debug("attaching dirty Cart instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Cart instance) {
		log.debug("attaching clean Cart instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CartDAO getFromApplicationContext(ApplicationContext ctx) {
		return (CartDAO) ctx.getBean("CartDAO");
	}
	
	public Cart findCartByFId_TID(int FID,int TID){
		String hql="from Cart c where c.food.fid = "+ FID + " and c.table.tid ="+ TID ;
		System.out.println(hql);
		Cart cart=(Cart) getCurrentSession().createQuery(hql).uniqueResult();
		return cart;
	}
}