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

package com.rcs.service.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MessageSourceLocalService}.
 *
 * @author flor
 * @see MessageSourceLocalService
 * @generated
 */
public class MessageSourceLocalServiceWrapper
	implements MessageSourceLocalService,
		ServiceWrapper<MessageSourceLocalService> {
	public MessageSourceLocalServiceWrapper(
		MessageSourceLocalService messageSourceLocalService) {
		_messageSourceLocalService = messageSourceLocalService;
	}

	/**
	* Adds the message source to the database. Also notifies the appropriate model listeners.
	*
	* @param messageSource the message source
	* @return the message source that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.service.model.MessageSource addMessageSource(
		com.rcs.service.model.MessageSource messageSource)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.addMessageSource(messageSource);
	}

	/**
	* Creates a new message source with the primary key. Does not add the message source to the database.
	*
	* @param messageSourcePK the primary key for the new message source
	* @return the new message source
	*/
	@Override
	public com.rcs.service.model.MessageSource createMessageSource(
		com.rcs.service.service.persistence.MessageSourcePK messageSourcePK) {
		return _messageSourceLocalService.createMessageSource(messageSourcePK);
	}

	/**
	* Deletes the message source with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param messageSourcePK the primary key of the message source
	* @return the message source that was removed
	* @throws PortalException if a message source with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.service.model.MessageSource deleteMessageSource(
		com.rcs.service.service.persistence.MessageSourcePK messageSourcePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.deleteMessageSource(messageSourcePK);
	}

	/**
	* Deletes the message source from the database. Also notifies the appropriate model listeners.
	*
	* @param messageSource the message source
	* @return the message source that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.service.model.MessageSource deleteMessageSource(
		com.rcs.service.model.MessageSource messageSource)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.deleteMessageSource(messageSource);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _messageSourceLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.service.model.impl.MessageSourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.rcs.service.model.impl.MessageSourceModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.dynamicQuery(dynamicQuery, start,
			end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.rcs.service.model.MessageSource fetchMessageSource(
		com.rcs.service.service.persistence.MessageSourcePK messageSourcePK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.fetchMessageSource(messageSourcePK);
	}

	/**
	* Returns the message source with the primary key.
	*
	* @param messageSourcePK the primary key of the message source
	* @return the message source
	* @throws PortalException if a message source with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.service.model.MessageSource getMessageSource(
		com.rcs.service.service.persistence.MessageSourcePK messageSourcePK)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.getMessageSource(messageSourcePK);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.getPersistedModel(primaryKeyObj);
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
	@Override
	public java.util.List<com.rcs.service.model.MessageSource> getMessageSources(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.getMessageSources(start, end);
	}

	/**
	* Returns the number of message sources.
	*
	* @return the number of message sources
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getMessageSourcesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.getMessageSourcesCount();
	}

	/**
	* Updates the message source in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param messageSource the message source
	* @return the message source that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.rcs.service.model.MessageSource updateMessageSource(
		com.rcs.service.model.MessageSource messageSource)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.updateMessageSource(messageSource);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _messageSourceLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_messageSourceLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _messageSourceLocalService.invokeMethod(name, parameterTypes,
			arguments);
	}

	@Override
	public java.util.List<java.lang.String> getMessageBundles()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.getMessageBundles();
	}

	@Override
	public long getMessageSourcesKeyCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.getMessageSourcesKeyCount();
	}

	@Override
	public java.util.List<java.lang.String> getMessageSourcesKey(int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.getMessageSourcesKey(start, end);
	}

	@Override
	public java.util.List<com.rcs.service.model.MessageSource> getMessageSources(
		java.lang.String resourceKey, java.lang.String resourceLocale,
		java.lang.String resourceValue, java.lang.String resourceBundle,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.getMessageSources(resourceKey,
			resourceLocale, resourceValue, resourceBundle, start, end);
	}

	@Override
	public java.util.List<java.lang.String> getMessageSourcesKey(
		java.lang.String resourceKey, java.lang.String resourceLocale,
		java.lang.String resourceValue, java.lang.String resourceBundle,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.getMessageSourcesKey(resourceKey,
			resourceLocale, resourceValue, resourceBundle, start, end);
	}

	@Override
	public long getMessageSourcesKeyCount(java.lang.String resourceKey,
		java.lang.String resourceLocale, java.lang.String resourceValue,
		java.lang.String resourceBundle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.getMessageSourcesKeyCount(resourceKey,
			resourceLocale, resourceValue, resourceBundle);
	}

	@Override
	public java.lang.String getMessageSourceWrappers(int start, int end) {
		return _messageSourceLocalService.getMessageSourceWrappers(start, end);
	}

	@Override
	public java.lang.String getMSWJson(int start, int end) {
		return _messageSourceLocalService.getMSWJson(start, end);
	}

	@Override
	public java.lang.String getMSWJson(java.lang.String key,
		java.lang.String locale, java.lang.String value,
		java.lang.String bundle, int start, int end) {
		return _messageSourceLocalService.getMSWJson(key, locale, value,
			bundle, start, end);
	}

	@Override
	public java.lang.String getMessageSourceWrappers(java.lang.String key,
		java.lang.String locale, java.lang.String value,
		java.lang.String bundle, int start, int end) {
		return _messageSourceLocalService.getMessageSourceWrappers(key, locale,
			value, bundle, start, end);
	}

	@Override
	public java.util.List<com.rcs.service.model.MessageSource> getMessageSourcesByKey(
		java.lang.String key)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.getMessageSourcesByKey(key);
	}

	@Override
	public void clearCache()
		throws com.liferay.portal.kernel.exception.SystemException {
		_messageSourceLocalService.clearCache();
	}

	@Override
	public java.util.List<com.rcs.service.model.MessageSource> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.findAll();
	}

	@Override
	public java.util.List<com.rcs.service.model.MessageSource> findByBundle(
		java.lang.String bundle)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _messageSourceLocalService.findByBundle(bundle);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public MessageSourceLocalService getWrappedMessageSourceLocalService() {
		return _messageSourceLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedMessageSourceLocalService(
		MessageSourceLocalService messageSourceLocalService) {
		_messageSourceLocalService = messageSourceLocalService;
	}

	@Override
	public MessageSourceLocalService getWrappedService() {
		return _messageSourceLocalService;
	}

	@Override
	public void setWrappedService(
		MessageSourceLocalService messageSourceLocalService) {
		_messageSourceLocalService = messageSourceLocalService;
	}

	private MessageSourceLocalService _messageSourceLocalService;
}