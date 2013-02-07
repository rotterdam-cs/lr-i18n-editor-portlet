/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.rcs.service.service.impl;

import java.io.IOException;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.OrderFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.PropertyFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.LocaleThreadLocal;
import com.rcs.common.expert.MessageSourceExpert;
import com.rcs.common.utils.MessageSourceWrapper;
import com.rcs.common.utils.RcsConstants;
import com.rcs.service.model.MessageSource;
import com.rcs.service.service.MessageSourceLocalServiceUtil;
import com.rcs.service.service.base.MessageSourceLocalServiceBaseImpl;

/**
 * The implementation of the message source local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rcs.service.service.MessageSourceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author flor
 * @see com.rcs.service.service.base.MessageSourceLocalServiceBaseImpl
 * @see com.rcs.service.service.MessageSourceLocalServiceUtil
 */
public class MessageSourceLocalServiceImpl
	extends MessageSourceLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.rcs.service.service.MessageSourceLocalServiceUtil} to access the message source local service.
	 */
	
public static final String EMPTY_JSON = "[]";
	
	private static Log _logger = LogFactoryUtil.getLog(MessageSourceLocalServiceImpl.class);
	
	public List<String> getMessageBundles() throws SystemException {		
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(MessageSource.class);
		query.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("bundle"))); 
		List<String> results = (List<String>) MessageSourceLocalServiceUtil.dynamicQuery(query);		
		return results;
	}
	
	public long getMessageSourcesKeyCount() throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(MessageSource.class);		
		query.setProjection(ProjectionFactoryUtil.countDistinct("primaryKey.key"));				
		List result = MessageSourceLocalServiceUtil.dynamicQuery(query);
		Long count = (Long) result.get(0);
		return count.longValue();
	}
	
	public List<String> getMessageSourcesKey(int start, int end) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(MessageSource.class);
		query.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("primaryKey.key")));
		query.addOrder(OrderFactoryUtil.asc("primaryKey.key"));
		List<String> results = (List<String>) MessageSourceLocalServiceUtil.dynamicQuery(query, start, end);		
		return results;
	}
	
	public List<MessageSource> getMessageSources(int start, int end) throws SystemException {
		List <String> keys = this.getMessageSourcesKey(start, end);
		List<MessageSource> results = new ArrayList<MessageSource>();
		if(keys.size() != 0) {
			DynamicQuery mainQuery = DynamicQueryFactoryUtil.forClass(MessageSource.class);
			mainQuery.add(PropertyFactoryUtil.forName("primaryKey.key").in(keys.toArray()));
			mainQuery.addOrder(OrderFactoryUtil.asc("primaryKey.key"));
			results = (List<MessageSource>) MessageSourceLocalServiceUtil.dynamicQuery(mainQuery);
		} 		
		return results;
	}	
	
	public List<MessageSource> getMessageSources(String resourceKey, String resourceLocale, String resourceValue, String resourceBundle, int start, int end) throws SystemException {		
		List <String> keys = this.getMessageSourcesKey(resourceKey, resourceLocale, resourceValue, resourceBundle, start, end);
		if(keys.size() == 0) {
			return new ArrayList<MessageSource>();
		}
		DynamicQuery mainQuery = DynamicQueryFactoryUtil.forClass(MessageSource.class);
		mainQuery.add(PropertyFactoryUtil.forName("primaryKey.key").in(keys.toArray()));
		mainQuery.addOrder(OrderFactoryUtil.asc("primaryKey.key"));
		List<MessageSource> results = (List<MessageSource>) MessageSourceLocalServiceUtil.dynamicQuery(mainQuery);
		return results;
	}
	
	public List<String> getMessageSourcesKey(String resourceKey, String resourceLocale, String resourceValue, String resourceBundle, int start, int end) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(MessageSource.class);		
		if(StringUtils.isNotBlank(resourceKey)) {		
			query.add(RestrictionsFactoryUtil.ilike("primaryKey.key", "%" + resourceKey + "%"));			
		}		
		if(StringUtils.isNotBlank(resourceLocale)) {		
			query.add(PropertyFactoryUtil.forName("primaryKey.locale").eq(resourceLocale));
		}
		if(StringUtils.isNotBlank(resourceBundle) && !RcsConstants.ALL_BUNDLES.equals(resourceBundle)) {			
			query.add(PropertyFactoryUtil.forName("bundle").eq(resourceBundle));
		}
		if(StringUtils.isNotBlank(resourceValue)) {
			query.add(RestrictionsFactoryUtil.ilike("value", "%" + resourceValue + "%")); //forName("resourceValue").ilike("%" + resourceValue + "%"));			
		}		
		query.setProjection(ProjectionFactoryUtil.distinct(ProjectionFactoryUtil.property("primaryKey.key")));
		query.addOrder(OrderFactoryUtil.asc("primaryKey.key"));
		List<String> results = (List<String>) MessageSourceLocalServiceUtil.dynamicQuery(query, start, end);		
		return results;
	}
	
	public long getMessageSourcesKeyCount(String resourceKey, String resourceLocale, String resourceValue, String resourceBundle) throws SystemException {
		DynamicQuery query = DynamicQueryFactoryUtil.forClass(MessageSource.class);
		if(StringUtils.isNotBlank(resourceKey)) {					
			query.add(RestrictionsFactoryUtil.ilike("primaryKey.key", "%" + resourceKey + "%"));
		}		
		if(StringUtils.isNotBlank(resourceLocale)) {		
			query.add(PropertyFactoryUtil.forName("primaryKey.locale").eq(resourceLocale));
		}
		if(StringUtils.isNotBlank(resourceValue)) {
			query.add(RestrictionsFactoryUtil.ilike("value", "%" + resourceValue + "%")); //forName("resourceValue").ilike("%" + resourceValue + "%"));			
		}
		if(StringUtils.isNotBlank(resourceBundle) && !RcsConstants.ALL_BUNDLES.equals(resourceBundle)) {		
			query.add(PropertyFactoryUtil.forName("bundle").eq(resourceBundle));
		}	
		query.setProjection(ProjectionFactoryUtil.countDistinct("primaryKey.key"));									
		List result = MessageSourceLocalServiceUtil.dynamicQuery(query);
		Long count = (Long) result.get(0);			
		return count.longValue();
	}
	
	private List<MessageSourceWrapper> wrapMessageSources(List<MessageSource> messageSourceList) {

        List<MessageSourceWrapper> messageSourceWrapperList = new LinkedList<MessageSourceWrapper>();

        MessageSourceWrapper messageSourceWrapper = null;
        String preKey = null;
        for (MessageSource messageSource : messageSourceList) {
            if (!StringUtils.equals(preKey, messageSource.getKey())) {
                messageSourceWrapper = new MessageSourceWrapper();
                messageSourceWrapper.setKey(messageSource.getKey());
                messageSourceWrapper.setBundle(messageSource.getBundle());
                messageSourceWrapper.setSource(new HashMap());
                messageSourceWrapperList.add(messageSourceWrapper);
            }
            messageSourceWrapper.getSource().put(messageSource.getLocale(), messageSource.getValue());
            preKey = messageSource.getKey();
        }
        return messageSourceWrapperList;
    }
	
	public String getMessageSourceWrappers(int start, int end) {
        try {        	        	
            List<MessageSource> messageSourceList = this.getMessageSources(start, end);            
            List<MessageSourceWrapper> messageSourceWrapperList = wrapMessageSources(messageSourceList);

            return getMSWrappersJSON(messageSourceWrapperList);
        } catch (Exception e) {
            _logger.warn("Cannot get resource cause: " + e.getMessage(), e);
        }
        
        return EMPTY_JSON;
    }					 
    
    private String getMSWrappersJSON(List<MessageSourceWrapper> messageSourceWrapperList) {
        ObjectMapper om = new ObjectMapper();
        StringWriter sw = new StringWriter();
        try {
            om.writeValue(sw, messageSourceWrapperList);
        } catch (IOException ignored) {
        }
        return sw.toString();
    }
    
    private Locale getDefaultLocale() {
        //get default locale as default locale of request
        Locale locale = LocaleThreadLocal.getThemeDisplayLocale();

        //get default locale as default locale of portal
        if (locale == null) {
            locale = LocaleThreadLocal.getDefaultLocale();
        }

        //get default locale as default locale of server
        if (locale == null) {
            locale = Locale.getDefault();
        }

        return locale;

    }
    
    public String getMSWJson(int start, int end) {
    	long count = 0;
    	try {
    		count = this.getMessageSourcesKeyCount();
    	} catch(Exception ex) {
    		count = 0;
    	}
        return new StringBuilder()
                .append("{\"totalRecords\":\"")
                .append(count)
                .append("\",")
                .append("\"start\":\"")
                .append(start)
                .append("\",")
                .append("\"records\":")
                .append(getMessageSourceWrappers(start, end))
                .append("}")
                .toString();
    }
        
    public String getMSWJson(String key, String locale, String value, String bundle, int start, int end) {
    	long count = 0;
    	try {
    		count = this.getMessageSourcesKeyCount(key, locale, value, bundle);
    	} catch(Exception ex) {
    		count = 0;
    	}
        return new StringBuilder()
                .append("{\"totalRecords\":\"")
                .append(count)
                .append("\",")
                .append("\"start\":\"")
                .append(start)
                .append("\",")
                .append("\"records\":")
                .append(this.getMessageSourceWrappers(key, locale, value, bundle, start, end))
                .append("}")
                .toString();
    }
    
    public String getMessageSourceWrappers(String key, String locale, String value, String bundle, int start, int end) {

        try{
            List<MessageSource> messageSourceList = this.getMessageSources(key, locale, value, bundle, start, end);

            List<MessageSourceWrapper> messageSourceWrapperList = wrapMessageSources(messageSourceList);

            return getMSWrappersJSON(messageSourceWrapperList);
        } catch (Exception e) {
            _logger.warn("Cannot get resource cause: " + e.getMessage(), e);
        }
        return EMPTY_JSON;
    }
	    
    public List<MessageSource> getMessageSourcesByKey(String key) throws PortalException, SystemException {	    
	    List<MessageSource> entities = messageSourcePersistence.findByKey(key);
		return entities;
	}
    
    public void clearCache() throws SystemException {
    	messageSourcePersistence.clearCache();
    }
    
    public List<MessageSource> findAll() throws SystemException {
    	return messageSourcePersistence.findAll();
    }
    
    public List<MessageSource> findByBundle(String bundle) throws SystemException {
    	return messageSourcePersistence.findByBundle(bundle);
    }
}