package dao;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.hibernate.LockOptions;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Example;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.transaction.annotation.Transactional;

import entity.Food;

/**
 * A data access object (DAO) providing persistence and search support for Food
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see entity.Food
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class FoodDAO {
	private static final Logger log = LoggerFactory.getLogger(FoodDAO.class);
	// property constants
	public static final String FNAME = "fname";
	public static final String FPRICE = "fprice";
	public static final String FDES = "fdes";
	public static final String STOCK = "stock";
	public static final String IMG = "img";
	public static final String CATEID = "fcid";

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

	public int save(Food transientInstance) {
		log.debug("saving Food instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public int delete(Food persistentInstance) {
		log.debug("deleting Food instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Food findById(java.lang.Integer id) {
		log.debug("getting Food instance with id: " + id);
		try {
			Food instance = (Food) getCurrentSession().get("entity.Food", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Food instance) {
		log.debug("finding Food instance by example");
		try {
			List results = getCurrentSession().createCriteria("entity.Food")
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
		log.debug("finding Food instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Food as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public List findByPropert(String propertyName, Object value) {
		log.debug("finding Food instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Food as model left join fetch model.foodcate fc where fc."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFname(Object fname) {
		return findByProperty(FNAME, fname);
	}

	public List findByFprice(Object fprice) {
		return findByProperty(FPRICE, fprice);
	}
	public List findFoodByCateId(Object cateId){
		return findByPropert(CATEID,cateId);
	}

	public List findByFdes(Object fdes) {
		return findByProperty(FDES, fdes);
	}

	public List findByStock(Object stock) {
		return findByProperty(STOCK, stock);
	}

	public List findByImg(Object img) {
		return findByProperty(IMG, img);
	}

	public List findAll() {
		log.debug("finding all Food instances");
		try {
			String queryString = "from Food as model left join fetch model.foodcate fc";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public int merge(Food detachedInstance) {
		log.debug("merging Food instance");
		try {
			Food result = (Food) getCurrentSession().merge(detachedInstance);
			log.debug("merge successful");
			return 1;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Food instance) {
		log.debug("attaching dirty Food instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Food instance) {
		log.debug("attaching clean Food instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FoodDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FoodDAO) ctx.getBean("FoodDAO");
	}
	/*public List findFoodByCateId(Integer CateId) {
		List list=null;
		String hql="select f.fid from Food f left join f.foodcate fc where fc.fcid="+CateId;
		//Session session=getCurrentSession();;
		//Query query =session.createQuery(hql);
		//query.setInteger("fcid", CateId);
		Query queryObject = getCurrentSession().createQuery(hql);
		return queryObject.list();
		
	}*/


}