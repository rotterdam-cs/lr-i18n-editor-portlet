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

package com.rcs.service.model;

import com.liferay.portal.model.ModelWrapper;

/**
 * <p>
 * This class is a wrapper for {@link MessageSource}.
 * </p>
 *
 * @author    flor
 * @see       MessageSource
 * @generated
 */
public class MessageSourceWrapper implements MessageSource,
	ModelWrapper<MessageSource> {
	public MessageSourceWrapper(MessageSource messageSource) {
		_messageSource = messageSource;
	}

	public Class<?> getModelClass() {
		return MessageSource.class;
	}

	public String getModelClassName() {
		return MessageSource.class.getName();
	}

	/**
	* Returns the primary key of this message source.
	*
	* @return the primary key of this message source
	*/
	public com.rcs.service.service.persistence.MessageSourcePK getPrimaryKey() {
		return _messageSource.getPrimaryKey();
	}

	/**
	* Sets the primary key of this message source.
	*
	* @param primaryKey the primary key of this message source
	*/
	public void setPrimaryKey(
		com.rcs.service.service.persistence.MessageSourcePK primaryKey) {
		_messageSource.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the key of this message source.
	*
	* @return the key of this message source
	*/
	public java.lang.String getKey() {
		return _messageSource.getKey();
	}

	/**
	* Sets the key of this message source.
	*
	* @param key the key of this message source
	*/
	public void setKey(java.lang.String key) {
		_messageSource.setKey(key);
	}

	/**
	* Returns the locale of this message source.
	*
	* @return the locale of this message source
	*/
	public java.lang.String getLocale() {
		return _messageSource.getLocale();
	}

	/**
	* Sets the locale of this message source.
	*
	* @param locale the locale of this message source
	*/
	public void setLocale(java.lang.String locale) {
		_messageSource.setLocale(locale);
	}

	/**
	* Returns the value of this message source.
	*
	* @return the value of this message source
	*/
	public java.lang.String getValue() {
		return _messageSource.getValue();
	}

	/**
	* Sets the value of this message source.
	*
	* @param value the value of this message source
	*/
	public void setValue(java.lang.String value) {
		_messageSource.setValue(value);
	}

	/**
	* Returns the bundle of this message source.
	*
	* @return the bundle of this message source
	*/
	public java.lang.String getBundle() {
		return _messageSource.getBundle();
	}

	/**
	* Sets the bundle of this message source.
	*
	* @param bundle the bundle of this message source
	*/
	public void setBundle(java.lang.String bundle) {
		_messageSource.setBundle(bundle);
	}

	public boolean isNew() {
		return _messageSource.isNew();
	}

	public void setNew(boolean n) {
		_messageSource.setNew(n);
	}

	public boolean isCachedModel() {
		return _messageSource.isCachedModel();
	}

	public void setCachedModel(boolean cachedModel) {
		_messageSource.setCachedModel(cachedModel);
	}

	public boolean isEscapedModel() {
		return _messageSource.isEscapedModel();
	}

	public java.io.Serializable getPrimaryKeyObj() {
		return _messageSource.getPrimaryKeyObj();
	}

	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_messageSource.setPrimaryKeyObj(primaryKeyObj);
	}

	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _messageSource.getExpandoBridge();
	}

	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_messageSource.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MessageSourceWrapper((MessageSource)_messageSource.clone());
	}

	public int compareTo(com.rcs.service.model.MessageSource messageSource) {
		return _messageSource.compareTo(messageSource);
	}

	@Override
	public int hashCode() {
		return _messageSource.hashCode();
	}

	public com.liferay.portal.model.CacheModel<com.rcs.service.model.MessageSource> toCacheModel() {
		return _messageSource.toCacheModel();
	}

	public com.rcs.service.model.MessageSource toEscapedModel() {
		return new MessageSourceWrapper(_messageSource.toEscapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _messageSource.toString();
	}

	public java.lang.String toXmlString() {
		return _messageSource.toXmlString();
	}

	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_messageSource.persist();
	}

	/**
	 * @deprecated Renamed to {@link #getWrappedModel}
	 */
	public MessageSource getWrappedMessageSource() {
		return _messageSource;
	}

	public MessageSource getWrappedModel() {
		return _messageSource;
	}

	public void resetOriginalValues() {
		_messageSource.resetOriginalValues();
	}

	private MessageSource _messageSource;
}