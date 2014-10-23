/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
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

package com.rcs.service.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.rcs.service.model.MessageSource;

import java.util.List;

/**
 * The persistence utility for the message source service. This utility wraps {@link MessageSourcePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author flor
 * @see MessageSourcePersistence
 * @see MessageSourcePersistenceImpl
 * @generated
 */
public class MessageSourceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(MessageSource messageSource) {
		getPersistence().clearCache(messageSource);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MessageSource> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MessageSource> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MessageSource> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static MessageSource update(MessageSource messageSource)
		throws SystemException {
		return getPersistence().update(messageSource);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static MessageSource update(MessageSource messageSource,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(messageSource, serviceContext);
	}

	/**
	* Returns all the message sources where key = &#63;.
	*
	* @param key the key
	* @return the matching message sources
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.service.model.MessageSource> findByKey(
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByKey(key);
	}

	/**
	* Returns a range of all the message sources where key = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.service.model.impl.MessageSourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param key the key
	* @param start the lower bound of the range of message sources
	* @param end the upper bound of the range of message sources (not inclusive)
	* @return the range of matching message sources
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.service.model.MessageSource> findByKey(
		java.lang.String key, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByKey(key, start, end);
	}

	/**
	* Returns an ordered range of all the message sources where key = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.service.model.impl.MessageSourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param key the key
	* @param start the lower bound of the range of message sources
	* @param end the upper bound of the range of message sources (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching message sources
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.service.model.MessageSource> findByKey(
		java.lang.String key, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByKey(key, start, end, orderByComparator);
	}

	/**
	* Returns the first message source in the ordered set where key = &#63;.
	*
	* @param key the key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching message source
	* @throws com.rcs.service.NoSuchMessageSourceException if a matching message source could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.MessageSource findByKey_First(
		java.lang.String key,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchMessageSourceException {
		return getPersistence().findByKey_First(key, orderByComparator);
	}

	/**
	* Returns the first message source in the ordered set where key = &#63;.
	*
	* @param key the key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching message source, or <code>null</code> if a matching message source could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.MessageSource fetchByKey_First(
		java.lang.String key,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByKey_First(key, orderByComparator);
	}

	/**
	* Returns the last message source in the ordered set where key = &#63;.
	*
	* @param key the key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching message source
	* @throws com.rcs.service.NoSuchMessageSourceException if a matching message source could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.MessageSource findByKey_Last(
		java.lang.String key,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchMessageSourceException {
		return getPersistence().findByKey_Last(key, orderByComparator);
	}

	/**
	* Returns the last message source in the ordered set where key = &#63;.
	*
	* @param key the key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching message source, or <code>null</code> if a matching message source could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.MessageSource fetchByKey_Last(
		java.lang.String key,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByKey_Last(key, orderByComparator);
	}

	/**
	* Returns the message sources before and after the current message source in the ordered set where key = &#63;.
	*
	* @param messageSourcePK the primary key of the current message source
	* @param key the key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next message source
	* @throws com.rcs.service.NoSuchMessageSourceException if a message source with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.MessageSource[] findByKey_PrevAndNext(
		com.rcs.service.service.persistence.MessageSourcePK messageSourcePK,
		java.lang.String key,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchMessageSourceException {
		return getPersistence()
				   .findByKey_PrevAndNext(messageSourcePK, key,
			orderByComparator);
	}

	/**
	* Removes all the message sources where key = &#63; from the database.
	*
	* @param key the key
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByKey(java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByKey(key);
	}

	/**
	* Returns the number of message sources where key = &#63;.
	*
	* @param key the key
	* @return the number of matching message sources
	* @throws SystemException if a system exception occurred
	*/
	public static int countByKey(java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByKey(key);
	}

	/**
	* Returns all the message sources where bundle = &#63;.
	*
	* @param bundle the bundle
	* @return the matching message sources
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.service.model.MessageSource> findByBundle(
		java.lang.String bundle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBundle(bundle);
	}

	/**
	* Returns a range of all the message sources where bundle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.service.model.impl.MessageSourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bundle the bundle
	* @param start the lower bound of the range of message sources
	* @param end the upper bound of the range of message sources (not inclusive)
	* @return the range of matching message sources
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.service.model.MessageSource> findByBundle(
		java.lang.String bundle, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByBundle(bundle, start, end);
	}

	/**
	* Returns an ordered range of all the message sources where bundle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.service.model.impl.MessageSourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param bundle the bundle
	* @param start the lower bound of the range of message sources
	* @param end the upper bound of the range of message sources (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching message sources
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.service.model.MessageSource> findByBundle(
		java.lang.String bundle, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByBundle(bundle, start, end, orderByComparator);
	}

	/**
	* Returns the first message source in the ordered set where bundle = &#63;.
	*
	* @param bundle the bundle
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching message source
	* @throws com.rcs.service.NoSuchMessageSourceException if a matching message source could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.MessageSource findByBundle_First(
		java.lang.String bundle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchMessageSourceException {
		return getPersistence().findByBundle_First(bundle, orderByComparator);
	}

	/**
	* Returns the first message source in the ordered set where bundle = &#63;.
	*
	* @param bundle the bundle
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching message source, or <code>null</code> if a matching message source could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.MessageSource fetchByBundle_First(
		java.lang.String bundle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBundle_First(bundle, orderByComparator);
	}

	/**
	* Returns the last message source in the ordered set where bundle = &#63;.
	*
	* @param bundle the bundle
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching message source
	* @throws com.rcs.service.NoSuchMessageSourceException if a matching message source could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.MessageSource findByBundle_Last(
		java.lang.String bundle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchMessageSourceException {
		return getPersistence().findByBundle_Last(bundle, orderByComparator);
	}

	/**
	* Returns the last message source in the ordered set where bundle = &#63;.
	*
	* @param bundle the bundle
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching message source, or <code>null</code> if a matching message source could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.MessageSource fetchByBundle_Last(
		java.lang.String bundle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByBundle_Last(bundle, orderByComparator);
	}

	/**
	* Returns the message sources before and after the current message source in the ordered set where bundle = &#63;.
	*
	* @param messageSourcePK the primary key of the current message source
	* @param bundle the bundle
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next message source
	* @throws com.rcs.service.NoSuchMessageSourceException if a message source with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.MessageSource[] findByBundle_PrevAndNext(
		com.rcs.service.service.persistence.MessageSourcePK messageSourcePK,
		java.lang.String bundle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchMessageSourceException {
		return getPersistence()
				   .findByBundle_PrevAndNext(messageSourcePK, bundle,
			orderByComparator);
	}

	/**
	* Removes all the message sources where bundle = &#63; from the database.
	*
	* @param bundle the bundle
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByBundle(java.lang.String bundle)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByBundle(bundle);
	}

	/**
	* Returns the number of message sources where bundle = &#63;.
	*
	* @param bundle the bundle
	* @return the number of matching message sources
	* @throws SystemException if a system exception occurred
	*/
	public static int countByBundle(java.lang.String bundle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByBundle(bundle);
	}

	/**
	* Returns the message source where key = &#63; and locale = &#63; or throws a {@link com.rcs.service.NoSuchMessageSourceException} if it could not be found.
	*
	* @param key the key
	* @param locale the locale
	* @return the matching message source
	* @throws com.rcs.service.NoSuchMessageSourceException if a matching message source could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.MessageSource findByKeyAndLocale(
		java.lang.String key, java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchMessageSourceException {
		return getPersistence().findByKeyAndLocale(key, locale);
	}

	/**
	* Returns the message source where key = &#63; and locale = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param key the key
	* @param locale the locale
	* @return the matching message source, or <code>null</code> if a matching message source could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.MessageSource fetchByKeyAndLocale(
		java.lang.String key, java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByKeyAndLocale(key, locale);
	}

	/**
	* Returns the message source where key = &#63; and locale = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param key the key
	* @param locale the locale
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching message source, or <code>null</code> if a matching message source could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.MessageSource fetchByKeyAndLocale(
		java.lang.String key, java.lang.String locale, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByKeyAndLocale(key, locale, retrieveFromCache);
	}

	/**
	* Removes the message source where key = &#63; and locale = &#63; from the database.
	*
	* @param key the key
	* @param locale the locale
	* @return the message source that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.MessageSource removeByKeyAndLocale(
		java.lang.String key, java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchMessageSourceException {
		return getPersistence().removeByKeyAndLocale(key, locale);
	}

	/**
	* Returns the number of message sources where key = &#63; and locale = &#63;.
	*
	* @param key the key
	* @param locale the locale
	* @return the number of matching message sources
	* @throws SystemException if a system exception occurred
	*/
	public static int countByKeyAndLocale(java.lang.String key,
		java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByKeyAndLocale(key, locale);
	}

	/**
	* Caches the message source in the entity cache if it is enabled.
	*
	* @param messageSource the message source
	*/
	public static void cacheResult(
		com.rcs.service.model.MessageSource messageSource) {
		getPersistence().cacheResult(messageSource);
	}

	/**
	* Caches the message sources in the entity cache if it is enabled.
	*
	* @param messageSources the message sources
	*/
	public static void cacheResult(
		java.util.List<com.rcs.service.model.MessageSource> messageSources) {
		getPersistence().cacheResult(messageSources);
	}

	/**
	* Creates a new message source with the primary key. Does not add the message source to the database.
	*
	* @param messageSourcePK the primary key for the new message source
	* @return the new message source
	*/
	public static com.rcs.service.model.MessageSource create(
		com.rcs.service.service.persistence.MessageSourcePK messageSourcePK) {
		return getPersistence().create(messageSourcePK);
	}

	/**
	* Removes the message source with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageSourcePK the primary key of the message source
	* @return the message source that was removed
	* @throws com.rcs.service.NoSuchMessageSourceException if a message source with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.MessageSource remove(
		com.rcs.service.service.persistence.MessageSourcePK messageSourcePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchMessageSourceException {
		return getPersistence().remove(messageSourcePK);
	}

	public static com.rcs.service.model.MessageSource updateImpl(
		com.rcs.service.model.MessageSource messageSource)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(messageSource);
	}

	/**
	* Returns the message source with the primary key or throws a {@link com.rcs.service.NoSuchMessageSourceException} if it could not be found.
	*
	* @param messageSourcePK the primary key of the message source
	* @return the message source
	* @throws com.rcs.service.NoSuchMessageSourceException if a message source with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.MessageSource findByPrimaryKey(
		com.rcs.service.service.persistence.MessageSourcePK messageSourcePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchMessageSourceException {
		return getPersistence().findByPrimaryKey(messageSourcePK);
	}

	/**
	* Returns the message source with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param messageSourcePK the primary key of the message source
	* @return the message source, or <code>null</code> if a message source with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.rcs.service.model.MessageSource fetchByPrimaryKey(
		com.rcs.service.service.persistence.MessageSourcePK messageSourcePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(messageSourcePK);
	}

	/**
	* Returns all the message sources.
	*
	* @return the message sources
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.service.model.MessageSource> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the message sources.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.service.model.impl.MessageSourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of message sources
	* @param end the upper bound of the range of message sources (not inclusive)
	* @return the range of message sources
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.service.model.MessageSource> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the message sources.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.service.model.impl.MessageSourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of message sources
	* @param end the upper bound of the range of message sources (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of message sources
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.rcs.service.model.MessageSource> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the message sources from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of message sources.
	*
	* @return the number of message sources
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static MessageSourcePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (MessageSourcePersistence)PortletBeanLocatorUtil.locate(com.rcs.service.service.ClpSerializer.getServletContextName(),
					MessageSourcePersistence.class.getName());

			ReferenceRegistry.registerReference(MessageSourceUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(MessageSourcePersistence persistence) {
	}

	private static MessageSourcePersistence _persistence;
}