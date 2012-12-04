package com.rcs.service.service.persistence;

import java.util.ArrayList;
import java.util.List;

import com.liferay.portal.kernel.bean.PortalBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.SessionFactory;
import com.rcs.service.model.MessageSource;
import com.rcs.service.model.impl.MessageSourceImpl;
import com.rcs.service.model.impl.MessageSourceModelImpl;
import com.rcs.service.service.MessageSourceLocalServiceUtil;

public class CustomMessageSourcePersistenceImpl extends
		MessageSourcePersistenceImpl {

	//private SessionFactory sessionFactory;
	
	public CustomMessageSourcePersistenceImpl() {
		/*this.sessionFactory = (SessionFactory) PortalBeanLocatorUtil
                .getBeanLocator().locate("liferaySessionFactory");*/
	}
	
	public List<MessageSource> getMessageSources(CustomMessageSourcePersistenceImpl persistence, int start, int end) {
		System.out.println("CustomMessageSourcePersistenceImpl: first");
		//String sql = "SELECT DISTINCT resourceEditor_MessageSource.resourcekey, resourceEditor_MessageSource.resourcelocale, resourceEditor_MessageSource.resourcevalue, resourceEditor_MessageSource.resourcebundle from resourceEditor_MessageSource";
		String sql = "SELECT DISTINCT {resourceEditor_MessageSource.*} from resourceEditor_MessageSource";
		//SQLQuery q = persistence.openSession().createSQLQuery(sql);		
		Session session = null;
		SQLQuery q = null;
		List<MessageSource> result = null;
		try {
			//System.out.println("CustomMessageSourcePersistenceImpl: persistence.sessionFactory: " + persistence.sessionFactory);
			setSessionFactory((SessionFactory)PortalBeanLocatorUtil.getBeanLocator().locate(MessageSourceImpl.SESSION_FACTORY));
			//((SessionFactory)PortalBeanLocatorUtil.getBeanLocator().locate(MessageSourceImpl.SESSION_FACTORY)).
			System.out.println("CustomMessageSourcePersistenceImpl: second "  + PortalBeanLocatorUtil.getBeanLocator().locate(MessageSourceImpl.SESSION_FACTORY).toString());
			session = openSession();			
			System.out.println("CustomMessageSourcePersistenceImpl: session: " + session);
			q = session.createSQLQuery(sql);
			System.out.println("q1: " + q);
	        //q.setCacheable(true);
	        q.addEntity(MessageSourceImpl.TABLE_NAME, MessageSource.class);
	        System.out.println("q2: " + q.toString());	        
	        
	        result = ( List<MessageSource> ) QueryUtil.list(q, getDialect(), start, end);
	        System.out.println("CustomMessageSourcePersistenceImpl: result: " + result);
	        if (result.size() <= 0) {
	            return new ArrayList<MessageSource>();
	        }
		} catch(Exception e) {
			System.out.println("CustomMessageSourcePersistenceImpl: exception: " + e);
		}				        
        return result;
    }	
}
