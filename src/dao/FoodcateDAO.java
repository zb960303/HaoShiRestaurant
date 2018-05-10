package dao;

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
import org.springframework.transaction.annotation.Transactional;

import entity.Food;
import entity.Foodcate;

/**
 * A data access object (DAO) providing persistence and search support for
 * Foodcate entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see entity.Foodcate
 * @author MyEclipse Persistence Tools
 */
@Transactional
public class FoodcateDAO {
	private static final Logger log = LoggerFactory
			.getLogger(FoodcateDAO.class);
	// property constants
	public static final String FCNAME = "fcname";

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

	public void save(Foodcate transientInstance) {
		log.debug("saving Foodcate instance");
		try {
			getCurrentSession().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Foodcate persistentInstance) {
		log.debug("deleting Foodcate instance");
		try {
			getCurrentSession().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Foodcate findById(java.lang.Integer id) {
		log.debug("getting Foodcate instance with id: " + id);
		try {
			Foodcate instance = (Foodcate) getCurrentSession().get(
					"entity.Foodcate", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Foodcate instance) {
		log.debug("finding Foodcate instance by example");
		try {
			List results = getCurrentSession()
					.createCriteria("entity.Foodcate")
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
		log.debug("finding Foodcate instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Foodcate as model where model."
					+ propertyName + "= ?";
			Query queryObject = getCurrentSession().createQuery(queryString);
			queryObject.setParameter(0, value);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByFcname(Object fcname) {
		return findByProperty(FCNAME, fcname);
	}

	public List findAll() {
		log.debug("finding all Foodcate instances");
		try {
			String queryString = "from Foodcate";
			Query queryObject = getCurrentSession().createQuery(queryString);
			return queryObject.list();
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Foodcate merge(Foodcate detachedInstance) {
		log.debug("merging Foodcate instance");
		try {
			Foodcate result = (Foodcate) getCurrentSession().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Foodcate instance) {
		log.debug("attaching dirty Foodcate instance");
		try {
			getCurrentSession().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Foodcate instance) {
		log.debug("attaching clean Foodcate instance");
		try {
			getCurrentSession().buildLockRequest(LockOptions.NONE).lock(
					instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static FoodcateDAO getFromApplicationContext(ApplicationContext ctx) {
		return (FoodcateDAO) ctx.getBean("FoodcateDAO");
	}
	
	
	
	
}