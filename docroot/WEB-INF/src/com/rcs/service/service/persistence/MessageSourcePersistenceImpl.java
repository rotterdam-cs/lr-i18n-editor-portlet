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

import com.liferay.portal.NoSuchModelException;
import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.BatchSessionUtil;
import com.liferay.portal.service.persistence.ResourcePersistence;
import com.liferay.portal.service.persistence.UserPersistence;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.rcs.service.NoSuchMessageSourceException;
import com.rcs.service.model.MessageSource;
import com.rcs.service.model.impl.MessageSourceImpl;
import com.rcs.service.model.impl.MessageSourceModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the message source service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author flor
 * @see MessageSourcePersistence
 * @see MessageSourceUtil
 * @generated
 */
public class MessageSourcePersistenceImpl extends BasePersistenceImpl<MessageSource>
	implements MessageSourcePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MessageSourceUtil} to access the message source persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MessageSourceImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_KEY = new FinderPath(MessageSourceModelImpl.ENTITY_CACHE_ENABLED,
			MessageSourceModelImpl.FINDER_CACHE_ENABLED,
			MessageSourceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByKey",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KEY = new FinderPath(MessageSourceModelImpl.ENTITY_CACHE_ENABLED,
			MessageSourceModelImpl.FINDER_CACHE_ENABLED,
			MessageSourceImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByKey", new String[] { String.class.getName() },
			MessageSourceModelImpl.KEY_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_KEY = new FinderPath(MessageSourceModelImpl.ENTITY_CACHE_ENABLED,
			MessageSourceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKey",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_BUNDLE = new FinderPath(MessageSourceModelImpl.ENTITY_CACHE_ENABLED,
			MessageSourceModelImpl.FINDER_CACHE_ENABLED,
			MessageSourceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByBundle",
			new String[] {
				String.class.getName(),
				
			"java.lang.Integer", "java.lang.Integer",
				"com.liferay.portal.kernel.util.OrderByComparator"
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUNDLE =
		new FinderPath(MessageSourceModelImpl.ENTITY_CACHE_ENABLED,
			MessageSourceModelImpl.FINDER_CACHE_ENABLED,
			MessageSourceImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByBundle", new String[] { String.class.getName() },
			MessageSourceModelImpl.BUNDLE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_BUNDLE = new FinderPath(MessageSourceModelImpl.ENTITY_CACHE_ENABLED,
			MessageSourceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByBundle",
			new String[] { String.class.getName() });
	public static final FinderPath FINDER_PATH_FETCH_BY_KEYANDLOCALE = new FinderPath(MessageSourceModelImpl.ENTITY_CACHE_ENABLED,
			MessageSourceModelImpl.FINDER_CACHE_ENABLED,
			MessageSourceImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByKeyAndLocale",
			new String[] { String.class.getName(), String.class.getName() },
			MessageSourceModelImpl.KEY_COLUMN_BITMASK |
			MessageSourceModelImpl.LOCALE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_KEYANDLOCALE = new FinderPath(MessageSourceModelImpl.ENTITY_CACHE_ENABLED,
			MessageSourceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByKeyAndLocale",
			new String[] { String.class.getName(), String.class.getName() });
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MessageSourceModelImpl.ENTITY_CACHE_ENABLED,
			MessageSourceModelImpl.FINDER_CACHE_ENABLED,
			MessageSourceImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MessageSourceModelImpl.ENTITY_CACHE_ENABLED,
			MessageSourceModelImpl.FINDER_CACHE_ENABLED,
			MessageSourceImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MessageSourceModelImpl.ENTITY_CACHE_ENABLED,
			MessageSourceModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	/**
	 * Caches the message source in the entity cache if it is enabled.
	 *
	 * @param messageSource the message source
	 */
	public void cacheResult(MessageSource messageSource) {
		EntityCacheUtil.putResult(MessageSourceModelImpl.ENTITY_CACHE_ENABLED,
			MessageSourceImpl.class, messageSource.getPrimaryKey(),
			messageSource);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEYANDLOCALE,
			new Object[] { messageSource.getKey(), messageSource.getLocale() },
			messageSource);

		messageSource.resetOriginalValues();
	}

	/**
	 * Caches the message sources in the entity cache if it is enabled.
	 *
	 * @param messageSources the message sources
	 */
	public void cacheResult(List<MessageSource> messageSources) {
		for (MessageSource messageSource : messageSources) {
			if (EntityCacheUtil.getResult(
						MessageSourceModelImpl.ENTITY_CACHE_ENABLED,
						MessageSourceImpl.class, messageSource.getPrimaryKey()) == null) {
				cacheResult(messageSource);
			}
			else {
				messageSource.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all message sources.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(MessageSourceImpl.class.getName());
		}

		EntityCacheUtil.clearCache(MessageSourceImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the message source.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MessageSource messageSource) {
		EntityCacheUtil.removeResult(MessageSourceModelImpl.ENTITY_CACHE_ENABLED,
			MessageSourceImpl.class, messageSource.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(messageSource);
	}

	@Override
	public void clearCache(List<MessageSource> messageSources) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MessageSource messageSource : messageSources) {
			EntityCacheUtil.removeResult(MessageSourceModelImpl.ENTITY_CACHE_ENABLED,
				MessageSourceImpl.class, messageSource.getPrimaryKey());

			clearUniqueFindersCache(messageSource);
		}
	}

	protected void clearUniqueFindersCache(MessageSource messageSource) {
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEYANDLOCALE,
			new Object[] { messageSource.getKey(), messageSource.getLocale() });
	}

	/**
	 * Creates a new message source with the primary key. Does not add the message source to the database.
	 *
	 * @param messageSourcePK the primary key for the new message source
	 * @return the new message source
	 */
	public MessageSource create(MessageSourcePK messageSourcePK) {
		MessageSource messageSource = new MessageSourceImpl();

		messageSource.setNew(true);
		messageSource.setPrimaryKey(messageSourcePK);

		return messageSource;
	}

	/**
	 * Removes the message source with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param messageSourcePK the primary key of the message source
	 * @return the message source that was removed
	 * @throws com.rcs.service.NoSuchMessageSourceException if a message source with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MessageSource remove(MessageSourcePK messageSourcePK)
		throws NoSuchMessageSourceException, SystemException {
		return remove((Serializable)messageSourcePK);
	}

	/**
	 * Removes the message source with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the message source
	 * @return the message source that was removed
	 * @throws com.rcs.service.NoSuchMessageSourceException if a message source with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MessageSource remove(Serializable primaryKey)
		throws NoSuchMessageSourceException, SystemException {
		Session session = null;

		try {
			session = openSession();

			MessageSource messageSource = (MessageSource)session.get(MessageSourceImpl.class,
					primaryKey);

			if (messageSource == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMessageSourceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(messageSource);
		}
		catch (NoSuchMessageSourceException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected MessageSource removeImpl(MessageSource messageSource)
		throws SystemException {
		messageSource = toUnwrappedModel(messageSource);

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.delete(session, messageSource);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		clearCache(messageSource);

		return messageSource;
	}

	@Override
	public MessageSource updateImpl(
		com.rcs.service.model.MessageSource messageSource, boolean merge)
		throws SystemException {
		messageSource = toUnwrappedModel(messageSource);

		boolean isNew = messageSource.isNew();

		MessageSourceModelImpl messageSourceModelImpl = (MessageSourceModelImpl)messageSource;

		Session session = null;

		try {
			session = openSession();

			BatchSessionUtil.update(session, messageSource, merge);

			messageSource.setNew(false);
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MessageSourceModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((messageSourceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KEY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						messageSourceModelImpl.getOriginalKey()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KEY,
					args);

				args = new Object[] { messageSourceModelImpl.getKey() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KEY,
					args);
			}

			if ((messageSourceModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUNDLE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						messageSourceModelImpl.getOriginalBundle()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BUNDLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUNDLE,
					args);

				args = new Object[] { messageSourceModelImpl.getBundle() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_BUNDLE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUNDLE,
					args);
			}
		}

		EntityCacheUtil.putResult(MessageSourceModelImpl.ENTITY_CACHE_ENABLED,
			MessageSourceImpl.class, messageSource.getPrimaryKey(),
			messageSource);

		if (isNew) {
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEYANDLOCALE,
				new Object[] { messageSource.getKey(), messageSource.getLocale() },
				messageSource);
		}
		else {
			if ((messageSourceModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_KEYANDLOCALE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						messageSourceModelImpl.getOriginalKey(),
						
						messageSourceModelImpl.getOriginalLocale()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_KEYANDLOCALE,
					args);

				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEYANDLOCALE,
					args);

				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEYANDLOCALE,
					new Object[] {
						messageSource.getKey(),
						
					messageSource.getLocale()
					}, messageSource);
			}
		}

		return messageSource;
	}

	protected MessageSource toUnwrappedModel(MessageSource messageSource) {
		if (messageSource instanceof MessageSourceImpl) {
			return messageSource;
		}

		MessageSourceImpl messageSourceImpl = new MessageSourceImpl();

		messageSourceImpl.setNew(messageSource.isNew());
		messageSourceImpl.setPrimaryKey(messageSource.getPrimaryKey());

		messageSourceImpl.setKey(messageSource.getKey());
		messageSourceImpl.setLocale(messageSource.getLocale());
		messageSourceImpl.setValue(messageSource.getValue());
		messageSourceImpl.setBundle(messageSource.getBundle());

		return messageSourceImpl;
	}

	/**
	 * Returns the message source with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the message source
	 * @return the message source
	 * @throws com.liferay.portal.NoSuchModelException if a message source with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MessageSource findByPrimaryKey(Serializable primaryKey)
		throws NoSuchModelException, SystemException {
		return findByPrimaryKey((MessageSourcePK)primaryKey);
	}

	/**
	 * Returns the message source with the primary key or throws a {@link com.rcs.service.NoSuchMessageSourceException} if it could not be found.
	 *
	 * @param messageSourcePK the primary key of the message source
	 * @return the message source
	 * @throws com.rcs.service.NoSuchMessageSourceException if a message source with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MessageSource findByPrimaryKey(MessageSourcePK messageSourcePK)
		throws NoSuchMessageSourceException, SystemException {
		MessageSource messageSource = fetchByPrimaryKey(messageSourcePK);

		if (messageSource == null) {
			if (_log.isWarnEnabled()) {
				//_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + messageSourcePK);
			}

			throw new NoSuchMessageSourceException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				messageSourcePK);
		}

		return messageSource;
	}

	/**
	 * Returns the message source with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the message source
	 * @return the message source, or <code>null</code> if a message source with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public MessageSource fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		return fetchByPrimaryKey((MessageSourcePK)primaryKey);
	}

	/**
	 * Returns the message source with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param messageSourcePK the primary key of the message source
	 * @return the message source, or <code>null</code> if a message source with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MessageSource fetchByPrimaryKey(MessageSourcePK messageSourcePK)
		throws SystemException {
		MessageSource messageSource = (MessageSource)EntityCacheUtil.getResult(MessageSourceModelImpl.ENTITY_CACHE_ENABLED,
				MessageSourceImpl.class, messageSourcePK);

		if (messageSource == _nullMessageSource) {
			return null;
		}

		if (messageSource == null) {
			Session session = null;

			boolean hasException = false;

			try {
				session = openSession();

				messageSource = (MessageSource)session.get(MessageSourceImpl.class,
						messageSourcePK);
			}
			catch (Exception e) {
				hasException = true;

				throw processException(e);
			}
			finally {
				if (messageSource != null) {
					cacheResult(messageSource);
				}
				else if (!hasException) {
					EntityCacheUtil.putResult(MessageSourceModelImpl.ENTITY_CACHE_ENABLED,
						MessageSourceImpl.class, messageSourcePK,
						_nullMessageSource);
				}

				closeSession(session);
			}
		}

		return messageSource;
	}

	/**
	 * Returns all the message sources where key = &#63;.
	 *
	 * @param key the key
	 * @return the matching message sources
	 * @throws SystemException if a system exception occurred
	 */
	public List<MessageSource> findByKey(String key) throws SystemException {
		return findByKey(key, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<MessageSource> findByKey(String key, int start, int end)
		throws SystemException {
		return findByKey(key, start, end, null);
	}

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
	public List<MessageSource> findByKey(String key, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_KEY;
			finderArgs = new Object[] { key };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_KEY;
			finderArgs = new Object[] { key, start, end, orderByComparator };
		}

		List<MessageSource> list = (List<MessageSource>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MessageSource messageSource : list) {
				if (!Validator.equals(key, messageSource.getKey())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_MESSAGESOURCE_WHERE);

			if (key == null) {
				query.append(_FINDER_COLUMN_KEY_KEY_1);
			}
			else {
				if (key.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_KEY_KEY_3);
				}
				else {
					query.append(_FINDER_COLUMN_KEY_KEY_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(MessageSourceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (key != null) {
					qPos.add(key);
				}

				list = (List<MessageSource>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public MessageSource findByKey_First(String key,
		OrderByComparator orderByComparator)
		throws NoSuchMessageSourceException, SystemException {
		MessageSource messageSource = fetchByKey_First(key, orderByComparator);

		if (messageSource != null) {
			return messageSource;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("key=");
		msg.append(key);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMessageSourceException(msg.toString());
	}

	/**
	 * Returns the first message source in the ordered set where key = &#63;.
	 *
	 * @param key the key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message source, or <code>null</code> if a matching message source could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MessageSource fetchByKey_First(String key,
		OrderByComparator orderByComparator) throws SystemException {
		List<MessageSource> list = findByKey(key, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public MessageSource findByKey_Last(String key,
		OrderByComparator orderByComparator)
		throws NoSuchMessageSourceException, SystemException {
		MessageSource messageSource = fetchByKey_Last(key, orderByComparator);

		if (messageSource != null) {
			return messageSource;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("key=");
		msg.append(key);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMessageSourceException(msg.toString());
	}

	/**
	 * Returns the last message source in the ordered set where key = &#63;.
	 *
	 * @param key the key
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message source, or <code>null</code> if a matching message source could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MessageSource fetchByKey_Last(String key,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByKey(key);

		List<MessageSource> list = findByKey(key, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public MessageSource[] findByKey_PrevAndNext(
		MessageSourcePK messageSourcePK, String key,
		OrderByComparator orderByComparator)
		throws NoSuchMessageSourceException, SystemException {
		MessageSource messageSource = findByPrimaryKey(messageSourcePK);

		Session session = null;

		try {
			session = openSession();

			MessageSource[] array = new MessageSourceImpl[3];

			array[0] = getByKey_PrevAndNext(session, messageSource, key,
					orderByComparator, true);

			array[1] = messageSource;

			array[2] = getByKey_PrevAndNext(session, messageSource, key,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MessageSource getByKey_PrevAndNext(Session session,
		MessageSource messageSource, String key,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MESSAGESOURCE_WHERE);

		if (key == null) {
			query.append(_FINDER_COLUMN_KEY_KEY_1);
		}
		else {
			if (key.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_KEY_KEY_3);
			}
			else {
				query.append(_FINDER_COLUMN_KEY_KEY_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(MessageSourceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (key != null) {
			qPos.add(key);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(messageSource);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MessageSource> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Returns all the message sources where bundle = &#63;.
	 *
	 * @param bundle the bundle
	 * @return the matching message sources
	 * @throws SystemException if a system exception occurred
	 */
	public List<MessageSource> findByBundle(String bundle)
		throws SystemException {
		return findByBundle(bundle, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<MessageSource> findByBundle(String bundle, int start, int end)
		throws SystemException {
		return findByBundle(bundle, start, end, null);
	}

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
	public List<MessageSource> findByBundle(String bundle, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_BUNDLE;
			finderArgs = new Object[] { bundle };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_BUNDLE;
			finderArgs = new Object[] { bundle, start, end, orderByComparator };
		}

		List<MessageSource> list = (List<MessageSource>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (MessageSource messageSource : list) {
				if (!Validator.equals(bundle, messageSource.getBundle())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_MESSAGESOURCE_WHERE);

			if (bundle == null) {
				query.append(_FINDER_COLUMN_BUNDLE_BUNDLE_1);
			}
			else {
				if (bundle.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_BUNDLE_BUNDLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_BUNDLE_BUNDLE_2);
				}
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}

			else {
				query.append(MessageSourceModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bundle != null) {
					qPos.add(bundle);
				}

				list = (List<MessageSource>)QueryUtil.list(q, getDialect(),
						start, end);
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
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
	public MessageSource findByBundle_First(String bundle,
		OrderByComparator orderByComparator)
		throws NoSuchMessageSourceException, SystemException {
		MessageSource messageSource = fetchByBundle_First(bundle,
				orderByComparator);

		if (messageSource != null) {
			return messageSource;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bundle=");
		msg.append(bundle);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMessageSourceException(msg.toString());
	}

	/**
	 * Returns the first message source in the ordered set where bundle = &#63;.
	 *
	 * @param bundle the bundle
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching message source, or <code>null</code> if a matching message source could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MessageSource fetchByBundle_First(String bundle,
		OrderByComparator orderByComparator) throws SystemException {
		List<MessageSource> list = findByBundle(bundle, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public MessageSource findByBundle_Last(String bundle,
		OrderByComparator orderByComparator)
		throws NoSuchMessageSourceException, SystemException {
		MessageSource messageSource = fetchByBundle_Last(bundle,
				orderByComparator);

		if (messageSource != null) {
			return messageSource;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("bundle=");
		msg.append(bundle);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMessageSourceException(msg.toString());
	}

	/**
	 * Returns the last message source in the ordered set where bundle = &#63;.
	 *
	 * @param bundle the bundle
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching message source, or <code>null</code> if a matching message source could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MessageSource fetchByBundle_Last(String bundle,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByBundle(bundle);

		List<MessageSource> list = findByBundle(bundle, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	public MessageSource[] findByBundle_PrevAndNext(
		MessageSourcePK messageSourcePK, String bundle,
		OrderByComparator orderByComparator)
		throws NoSuchMessageSourceException, SystemException {
		MessageSource messageSource = findByPrimaryKey(messageSourcePK);

		Session session = null;

		try {
			session = openSession();

			MessageSource[] array = new MessageSourceImpl[3];

			array[0] = getByBundle_PrevAndNext(session, messageSource, bundle,
					orderByComparator, true);

			array[1] = messageSource;

			array[2] = getByBundle_PrevAndNext(session, messageSource, bundle,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MessageSource getByBundle_PrevAndNext(Session session,
		MessageSource messageSource, String bundle,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MESSAGESOURCE_WHERE);

		if (bundle == null) {
			query.append(_FINDER_COLUMN_BUNDLE_BUNDLE_1);
		}
		else {
			if (bundle.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_BUNDLE_BUNDLE_3);
			}
			else {
				query.append(_FINDER_COLUMN_BUNDLE_BUNDLE_2);
			}
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}

		else {
			query.append(MessageSourceModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bundle != null) {
			qPos.add(bundle);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(messageSource);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MessageSource> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
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
	public MessageSource findByKeyAndLocale(String key, String locale)
		throws NoSuchMessageSourceException, SystemException {
		MessageSource messageSource = fetchByKeyAndLocale(key, locale);

		if (messageSource == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("key=");
			msg.append(key);

			msg.append(", locale=");
			msg.append(locale);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchMessageSourceException(msg.toString());
		}

		return messageSource;
	}

	/**
	 * Returns the message source where key = &#63; and locale = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param key the key
	 * @param locale the locale
	 * @return the matching message source, or <code>null</code> if a matching message source could not be found
	 * @throws SystemException if a system exception occurred
	 */
	public MessageSource fetchByKeyAndLocale(String key, String locale)
		throws SystemException {
		return fetchByKeyAndLocale(key, locale, true);
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
	public MessageSource fetchByKeyAndLocale(String key, String locale,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { key, locale };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_KEYANDLOCALE,
					finderArgs, this);
		}

		if (result instanceof MessageSource) {
			MessageSource messageSource = (MessageSource)result;

			if (!Validator.equals(key, messageSource.getKey()) ||
					!Validator.equals(locale, messageSource.getLocale())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_MESSAGESOURCE_WHERE);

			if (key == null) {
				query.append(_FINDER_COLUMN_KEYANDLOCALE_KEY_1);
			}
			else {
				if (key.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_KEYANDLOCALE_KEY_3);
				}
				else {
					query.append(_FINDER_COLUMN_KEYANDLOCALE_KEY_2);
				}
			}

			if (locale == null) {
				query.append(_FINDER_COLUMN_KEYANDLOCALE_LOCALE_1);
			}
			else {
				if (locale.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_KEYANDLOCALE_LOCALE_3);
				}
				else {
					query.append(_FINDER_COLUMN_KEYANDLOCALE_LOCALE_2);
				}
			}

			query.append(MessageSourceModelImpl.ORDER_BY_JPQL);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (key != null) {
					qPos.add(key);
				}

				if (locale != null) {
					qPos.add(locale);
				}

				List<MessageSource> list = q.list();

				result = list;

				MessageSource messageSource = null;

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEYANDLOCALE,
						finderArgs, list);
				}
				else {
					messageSource = list.get(0);

					cacheResult(messageSource);

					if ((messageSource.getKey() == null) ||
							!messageSource.getKey().equals(key) ||
							(messageSource.getLocale() == null) ||
							!messageSource.getLocale().equals(locale)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_KEYANDLOCALE,
							finderArgs, messageSource);
					}
				}

				return messageSource;
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (result == null) {
					FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_KEYANDLOCALE,
						finderArgs);
				}

				closeSession(session);
			}
		}
		else {
			if (result instanceof List<?>) {
				return null;
			}
			else {
				return (MessageSource)result;
			}
		}
	}

	/**
	 * Returns all the message sources.
	 *
	 * @return the message sources
	 * @throws SystemException if a system exception occurred
	 */
	public List<MessageSource> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	public List<MessageSource> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	public List<MessageSource> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		FinderPath finderPath = null;
		Object[] finderArgs = new Object[] { start, end, orderByComparator };

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<MessageSource> list = (List<MessageSource>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_MESSAGESOURCE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MESSAGESOURCE.concat(MessageSourceModelImpl.ORDER_BY_JPQL);
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (orderByComparator == null) {
					list = (List<MessageSource>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);
				}
				else {
					list = (List<MessageSource>)QueryUtil.list(q, getDialect(),
							start, end);
				}
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (list == null) {
					FinderCacheUtil.removeResult(finderPath, finderArgs);
				}
				else {
					cacheResult(list);

					FinderCacheUtil.putResult(finderPath, finderArgs, list);
				}

				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the message sources where key = &#63; from the database.
	 *
	 * @param key the key
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByKey(String key) throws SystemException {
		for (MessageSource messageSource : findByKey(key)) {
			remove(messageSource);
		}
	}

	/**
	 * Removes all the message sources where bundle = &#63; from the database.
	 *
	 * @param bundle the bundle
	 * @throws SystemException if a system exception occurred
	 */
	public void removeByBundle(String bundle) throws SystemException {
		for (MessageSource messageSource : findByBundle(bundle)) {
			remove(messageSource);
		}
	}

	/**
	 * Removes the message source where key = &#63; and locale = &#63; from the database.
	 *
	 * @param key the key
	 * @param locale the locale
	 * @return the message source that was removed
	 * @throws SystemException if a system exception occurred
	 */
	public MessageSource removeByKeyAndLocale(String key, String locale)
		throws NoSuchMessageSourceException, SystemException {
		MessageSource messageSource = findByKeyAndLocale(key, locale);

		return remove(messageSource);
	}

	/**
	 * Removes all the message sources from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	public void removeAll() throws SystemException {
		for (MessageSource messageSource : findAll()) {
			remove(messageSource);
		}
	}

	/**
	 * Returns the number of message sources where key = &#63;.
	 *
	 * @param key the key
	 * @return the number of matching message sources
	 * @throws SystemException if a system exception occurred
	 */
	public int countByKey(String key) throws SystemException {
		Object[] finderArgs = new Object[] { key };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_KEY,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MESSAGESOURCE_WHERE);

			if (key == null) {
				query.append(_FINDER_COLUMN_KEY_KEY_1);
			}
			else {
				if (key.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_KEY_KEY_3);
				}
				else {
					query.append(_FINDER_COLUMN_KEY_KEY_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (key != null) {
					qPos.add(key);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEY, finderArgs,
					count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of message sources where bundle = &#63;.
	 *
	 * @param bundle the bundle
	 * @return the number of matching message sources
	 * @throws SystemException if a system exception occurred
	 */
	public int countByBundle(String bundle) throws SystemException {
		Object[] finderArgs = new Object[] { bundle };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_BUNDLE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MESSAGESOURCE_WHERE);

			if (bundle == null) {
				query.append(_FINDER_COLUMN_BUNDLE_BUNDLE_1);
			}
			else {
				if (bundle.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_BUNDLE_BUNDLE_3);
				}
				else {
					query.append(_FINDER_COLUMN_BUNDLE_BUNDLE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bundle != null) {
					qPos.add(bundle);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_BUNDLE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of message sources where key = &#63; and locale = &#63;.
	 *
	 * @param key the key
	 * @param locale the locale
	 * @return the number of matching message sources
	 * @throws SystemException if a system exception occurred
	 */
	public int countByKeyAndLocale(String key, String locale)
		throws SystemException {
		Object[] finderArgs = new Object[] { key, locale };

		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_BY_KEYANDLOCALE,
				finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MESSAGESOURCE_WHERE);

			if (key == null) {
				query.append(_FINDER_COLUMN_KEYANDLOCALE_KEY_1);
			}
			else {
				if (key.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_KEYANDLOCALE_KEY_3);
				}
				else {
					query.append(_FINDER_COLUMN_KEYANDLOCALE_KEY_2);
				}
			}

			if (locale == null) {
				query.append(_FINDER_COLUMN_KEYANDLOCALE_LOCALE_1);
			}
			else {
				if (locale.equals(StringPool.BLANK)) {
					query.append(_FINDER_COLUMN_KEYANDLOCALE_LOCALE_3);
				}
				else {
					query.append(_FINDER_COLUMN_KEYANDLOCALE_LOCALE_2);
				}
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (key != null) {
					qPos.add(key);
				}

				if (locale != null) {
					qPos.add(locale);
				}

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_KEYANDLOCALE,
					finderArgs, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Returns the number of message sources.
	 *
	 * @return the number of message sources
	 * @throws SystemException if a system exception occurred
	 */
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MESSAGESOURCE);

				count = (Long)q.uniqueResult();
			}
			catch (Exception e) {
				throw processException(e);
			}
			finally {
				if (count == null) {
					count = Long.valueOf(0);
				}

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);

				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the message source persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.rcs.service.model.MessageSource")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<MessageSource>> listenersList = new ArrayList<ModelListener<MessageSource>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<MessageSource>)InstanceFactory.newInstance(
							listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(MessageSourceImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@BeanReference(type = MessageSourcePersistence.class)
	protected MessageSourcePersistence messageSourcePersistence;
	@BeanReference(type = ResourcePersistence.class)
	protected ResourcePersistence resourcePersistence;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private static final String _SQL_SELECT_MESSAGESOURCE = "SELECT messageSource FROM MessageSource messageSource";
	private static final String _SQL_SELECT_MESSAGESOURCE_WHERE = "SELECT messageSource FROM MessageSource messageSource WHERE ";
	private static final String _SQL_COUNT_MESSAGESOURCE = "SELECT COUNT(messageSource) FROM MessageSource messageSource";
	private static final String _SQL_COUNT_MESSAGESOURCE_WHERE = "SELECT COUNT(messageSource) FROM MessageSource messageSource WHERE ";
	private static final String _FINDER_COLUMN_KEY_KEY_1 = "messageSource.id.key IS NULL";
	private static final String _FINDER_COLUMN_KEY_KEY_2 = "messageSource.id.key = ?";
	private static final String _FINDER_COLUMN_KEY_KEY_3 = "(messageSource.id.key IS NULL OR messageSource.id.key = ?)";
	private static final String _FINDER_COLUMN_BUNDLE_BUNDLE_1 = "messageSource.bundle IS NULL";
	private static final String _FINDER_COLUMN_BUNDLE_BUNDLE_2 = "messageSource.bundle = ?";
	private static final String _FINDER_COLUMN_BUNDLE_BUNDLE_3 = "(messageSource.bundle IS NULL OR messageSource.bundle = ?)";
	private static final String _FINDER_COLUMN_KEYANDLOCALE_KEY_1 = "messageSource.id.key IS NULL AND ";
	private static final String _FINDER_COLUMN_KEYANDLOCALE_KEY_2 = "messageSource.id.key = ? AND ";
	private static final String _FINDER_COLUMN_KEYANDLOCALE_KEY_3 = "(messageSource.id.key IS NULL OR messageSource.id.key = ?) AND ";
	private static final String _FINDER_COLUMN_KEYANDLOCALE_LOCALE_1 = "messageSource.id.locale IS NULL";
	private static final String _FINDER_COLUMN_KEYANDLOCALE_LOCALE_2 = "messageSource.id.locale = ?";
	private static final String _FINDER_COLUMN_KEYANDLOCALE_LOCALE_3 = "(messageSource.id.locale IS NULL OR messageSource.id.locale = ?)";
	private static final String _ORDER_BY_ENTITY_ALIAS = "messageSource.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MessageSource exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MessageSource exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(MessageSourcePersistenceImpl.class);
	private static MessageSource _nullMessageSource = new MessageSourceImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<MessageSource> toCacheModel() {
				return _nullMessageSourceCacheModel;
			}
		};

	private static CacheModel<MessageSource> _nullMessageSourceCacheModel = new CacheModel<MessageSource>() {
			public MessageSource toEntityModel() {
				return _nullMessageSource;
			}
		};
}