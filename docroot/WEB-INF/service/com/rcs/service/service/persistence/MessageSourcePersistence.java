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

package com.rcs.service.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.rcs.service.model.MessageSource;

/**
 * The persistence interface for the message source service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author flor
 * @see MessageSourcePersistenceImpl
 * @see MessageSourceUtil
 * @generated
 */
public interface MessageSourcePersistence extends BasePersistence<MessageSource> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MessageSourceUtil} to access the message source persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Caches the message source in the entity cache if it is enabled.
	*
	* @param messageSource the message source
	*/
	public void cacheResult(com.rcs.service.model.MessageSource messageSource);

	/**
	* Caches the message sources in the entity cache if it is enabled.
	*
	* @param messageSources the message sources
	*/
	public void cacheResult(
		java.util.List<com.rcs.service.model.MessageSource> messageSources);

	/**
	* Creates a new message source with the primary key. Does not add the message source to the database.
	*
	* @param messageSourcePK the primary key for the new message source
	* @return the new message source
	*/
	public com.rcs.service.model.MessageSource create(
		com.rcs.service.service.persistence.MessageSourcePK messageSourcePK);

	/**
	* Removes the message source with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageSourcePK the primary key of the message source
	* @return the message source that was removed
	* @throws com.rcs.service.NoSuchMessageSourceException if a message source with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.MessageSource remove(
		com.rcs.service.service.persistence.MessageSourcePK messageSourcePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchMessageSourceException;

	public com.rcs.service.model.MessageSource updateImpl(
		com.rcs.service.model.MessageSource messageSource, boolean merge)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the message source with the primary key or throws a {@link com.rcs.service.NoSuchMessageSourceException} if it could not be found.
	*
	* @param messageSourcePK the primary key of the message source
	* @return the message source
	* @throws com.rcs.service.NoSuchMessageSourceException if a message source with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.MessageSource findByPrimaryKey(
		com.rcs.service.service.persistence.MessageSourcePK messageSourcePK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchMessageSourceException;

	/**
	* Returns the message source with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param messageSourcePK the primary key of the message source
	* @return the message source, or <code>null</code> if a message source with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.MessageSource fetchByPrimaryKey(
		com.rcs.service.service.persistence.MessageSourcePK messageSourcePK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the message sources where key = &#63;.
	*
	* @param key the key
	* @return the matching message sources
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.service.model.MessageSource> findByKey(
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the message sources where key = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param key the key
	* @param start the lower bound of the range of message sources
	* @param end the upper bound of the range of message sources (not inclusive)
	* @return the range of matching message sources
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.service.model.MessageSource> findByKey(
		java.lang.String key, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the message sources where key = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param key the key
	* @param start the lower bound of the range of message sources
	* @param end the upper bound of the range of message sources (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching message sources
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.service.model.MessageSource> findByKey(
		java.lang.String key, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first message source in the ordered set where key = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param key the key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching message source
	* @throws com.rcs.service.NoSuchMessageSourceException if a matching message source could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.MessageSource findByKey_First(
		java.lang.String key,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchMessageSourceException;

	/**
	* Returns the last message source in the ordered set where key = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param key the key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching message source
	* @throws com.rcs.service.NoSuchMessageSourceException if a matching message source could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.MessageSource findByKey_Last(
		java.lang.String key,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchMessageSourceException;

	/**
	* Returns the message sources before and after the current message source in the ordered set where key = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param messageSourcePK the primary key of the current message source
	* @param key the key
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next message source
	* @throws com.rcs.service.NoSuchMessageSourceException if a message source with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.MessageSource[] findByKey_PrevAndNext(
		com.rcs.service.service.persistence.MessageSourcePK messageSourcePK,
		java.lang.String key,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchMessageSourceException;

	/**
	* Returns all the message sources where bundle = &#63;.
	*
	* @param bundle the bundle
	* @return the matching message sources
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.service.model.MessageSource> findByBundle(
		java.lang.String bundle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the message sources where bundle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param bundle the bundle
	* @param start the lower bound of the range of message sources
	* @param end the upper bound of the range of message sources (not inclusive)
	* @return the range of matching message sources
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.service.model.MessageSource> findByBundle(
		java.lang.String bundle, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the message sources where bundle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param bundle the bundle
	* @param start the lower bound of the range of message sources
	* @param end the upper bound of the range of message sources (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching message sources
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.service.model.MessageSource> findByBundle(
		java.lang.String bundle, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first message source in the ordered set where bundle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param bundle the bundle
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching message source
	* @throws com.rcs.service.NoSuchMessageSourceException if a matching message source could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.MessageSource findByBundle_First(
		java.lang.String bundle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchMessageSourceException;

	/**
	* Returns the last message source in the ordered set where bundle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param bundle the bundle
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching message source
	* @throws com.rcs.service.NoSuchMessageSourceException if a matching message source could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.MessageSource findByBundle_Last(
		java.lang.String bundle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchMessageSourceException;

	/**
	* Returns the message sources before and after the current message source in the ordered set where bundle = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param messageSourcePK the primary key of the current message source
	* @param bundle the bundle
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next message source
	* @throws com.rcs.service.NoSuchMessageSourceException if a message source with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.MessageSource[] findByBundle_PrevAndNext(
		com.rcs.service.service.persistence.MessageSourcePK messageSourcePK,
		java.lang.String bundle,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchMessageSourceException;

	/**
	* Returns the message source where key = &#63; and locale = &#63; or throws a {@link com.rcs.service.NoSuchMessageSourceException} if it could not be found.
	*
	* @param key the key
	* @param locale the locale
	* @return the matching message source
	* @throws com.rcs.service.NoSuchMessageSourceException if a matching message source could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.MessageSource findByKeyAndLocale(
		java.lang.String key, java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchMessageSourceException;

	/**
	* Returns the message source where key = &#63; and locale = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param key the key
	* @param locale the locale
	* @return the matching message source, or <code>null</code> if a matching message source could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.MessageSource fetchByKeyAndLocale(
		java.lang.String key, java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the message source where key = &#63; and locale = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param key the key
	* @param locale the locale
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching message source, or <code>null</code> if a matching message source could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.rcs.service.model.MessageSource fetchByKeyAndLocale(
		java.lang.String key, java.lang.String locale, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the message sources.
	*
	* @return the message sources
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.service.model.MessageSource> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the message sources.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of message sources
	* @param end the upper bound of the range of message sources (not inclusive)
	* @return the range of message sources
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.service.model.MessageSource> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the message sources.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set.
	* </p>
	*
	* @param start the lower bound of the range of message sources
	* @param end the upper bound of the range of message sources (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of message sources
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.rcs.service.model.MessageSource> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the message sources where key = &#63; from the database.
	*
	* @param key the key
	* @throws SystemException if a system exception occurred
	*/
	public void removeByKey(java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the message sources where bundle = &#63; from the database.
	*
	* @param bundle the bundle
	* @throws SystemException if a system exception occurred
	*/
	public void removeByBundle(java.lang.String bundle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the message source where key = &#63; and locale = &#63; from the database.
	*
	* @param key the key
	* @param locale the locale
	* @throws SystemException if a system exception occurred
	*/
	public void removeByKeyAndLocale(java.lang.String key,
		java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.rcs.service.NoSuchMessageSourceException;

	/**
	* Removes all the message sources from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of message sources where key = &#63;.
	*
	* @param key the key
	* @return the number of matching message sources
	* @throws SystemException if a system exception occurred
	*/
	public int countByKey(java.lang.String key)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of message sources where bundle = &#63;.
	*
	* @param bundle the bundle
	* @return the number of matching message sources
	* @throws SystemException if a system exception occurred
	*/
	public int countByBundle(java.lang.String bundle)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of message sources where key = &#63; and locale = &#63;.
	*
	* @param key the key
	* @param locale the locale
	* @return the number of matching message sources
	* @throws SystemException if a system exception occurred
	*/
	public int countByKeyAndLocale(java.lang.String key, java.lang.String locale)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of message sources.
	*
	* @return the number of message sources
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}