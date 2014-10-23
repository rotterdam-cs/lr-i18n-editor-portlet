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

package com.rcs.service.model;

import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link MessageSource}.
 * </p>
 *
 * @author flor
 * @see MessageSource
 * @generated
 */
public class MessageSourceWrapper implements MessageSource,
	ModelWrapper<MessageSource> {
	public MessageSourceWrapper(MessageSource messageSource) {
		_messageSource = messageSource;
	}

	@Override
	public Class<?> getModelClass() {
		return MessageSource.class;
	}

	@Override
	public String getModelClassName() {
		return MessageSource.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("key", getKey());
		attributes.put("locale", getLocale());
		attributes.put("value", getValue());
		attributes.put("bundle", getBundle());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String key = (String)attributes.get("key");

		if (key != null) {
			setKey(key);
		}

		String locale = (String)attributes.get("locale");

		if (locale != null) {
			setLocale(locale);
		}

		String value = (String)attributes.get("value");

		if (value != null) {
			setValue(value);
		}

		String bundle = (String)attributes.get("bundle");

		if (bundle != null) {
			setBundle(bundle);
		}
	}

	/**
	* Returns the primary key of this message source.
	*
	* @return the primary key of this message source
	*/
	@Override
	public com.rcs.service.service.persistence.MessageSourcePK getPrimaryKey() {
		return _messageSource.getPrimaryKey();
	}

	/**
	* Sets the primary key of this message source.
	*
	* @param primaryKey the primary key of this message source
	*/
	@Override
	public void setPrimaryKey(
		com.rcs.service.service.persistence.MessageSourcePK primaryKey) {
		_messageSource.setPrimaryKey(primaryKey);
	}

	/**
	* Returns the key of this message source.
	*
	* @return the key of this message source
	*/
	@Override
	public java.lang.String getKey() {
		return _messageSource.getKey();
	}

	/**
	* Sets the key of this message source.
	*
	* @param key the key of this message source
	*/
	@Override
	public void setKey(java.lang.String key) {
		_messageSource.setKey(key);
	}

	/**
	* Returns the locale of this message source.
	*
	* @return the locale of this message source
	*/
	@Override
	public java.lang.String getLocale() {
		return _messageSource.getLocale();
	}

	/**
	* Sets the locale of this message source.
	*
	* @param locale the locale of this message source
	*/
	@Override
	public void setLocale(java.lang.String locale) {
		_messageSource.setLocale(locale);
	}

	/**
	* Returns the value of this message source.
	*
	* @return the value of this message source
	*/
	@Override
	public java.lang.String getValue() {
		return _messageSource.getValue();
	}

	/**
	* Sets the value of this message source.
	*
	* @param value the value of this message source
	*/
	@Override
	public void setValue(java.lang.String value) {
		_messageSource.setValue(value);
	}

	/**
	* Returns the bundle of this message source.
	*
	* @return the bundle of this message source
	*/
	@Override
	public java.lang.String getBundle() {
		return _messageSource.getBundle();
	}

	/**
	* Sets the bundle of this message source.
	*
	* @param bundle the bundle of this message source
	*/
	@Override
	public void setBundle(java.lang.String bundle) {
		_messageSource.setBundle(bundle);
	}

	@Override
	public boolean isNew() {
		return _messageSource.isNew();
	}

	@Override
	public void setNew(boolean n) {
		_messageSource.setNew(n);
	}

	@Override
	public boolean isCachedModel() {
		return _messageSource.isCachedModel();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_messageSource.setCachedModel(cachedModel);
	}

	@Override
	public boolean isEscapedModel() {
		return _messageSource.isEscapedModel();
	}

	@Override
	public java.io.Serializable getPrimaryKeyObj() {
		return _messageSource.getPrimaryKeyObj();
	}

	@Override
	public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
		_messageSource.setPrimaryKeyObj(primaryKeyObj);
	}

	@Override
	public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
		return _messageSource.getExpandoBridge();
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.model.BaseModel<?> baseModel) {
		_messageSource.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
		_messageSource.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.service.ServiceContext serviceContext) {
		_messageSource.setExpandoBridgeAttributes(serviceContext);
	}

	@Override
	public java.lang.Object clone() {
		return new MessageSourceWrapper((MessageSource)_messageSource.clone());
	}

	@Override
	public int compareTo(com.rcs.service.model.MessageSource messageSource) {
		return _messageSource.compareTo(messageSource);
	}

	@Override
	public int hashCode() {
		return _messageSource.hashCode();
	}

	@Override
	public com.liferay.portal.model.CacheModel<com.rcs.service.model.MessageSource> toCacheModel() {
		return _messageSource.toCacheModel();
	}

	@Override
	public com.rcs.service.model.MessageSource toEscapedModel() {
		return new MessageSourceWrapper(_messageSource.toEscapedModel());
	}

	@Override
	public com.rcs.service.model.MessageSource toUnescapedModel() {
		return new MessageSourceWrapper(_messageSource.toUnescapedModel());
	}

	@Override
	public java.lang.String toString() {
		return _messageSource.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _messageSource.toXmlString();
	}

	@Override
	public void persist()
		throws com.liferay.portal.kernel.exception.SystemException {
		_messageSource.persist();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MessageSourceWrapper)) {
			return false;
		}

		MessageSourceWrapper messageSourceWrapper = (MessageSourceWrapper)obj;

		if (Validator.equals(_messageSource, messageSourceWrapper._messageSource)) {
			return true;
		}

		return false;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
	 */
	public MessageSource getWrappedMessageSource() {
		return _messageSource;
	}

	@Override
	public MessageSource getWrappedModel() {
		return _messageSource;
	}

	@Override
	public void resetOriginalValues() {
		_messageSource.resetOriginalValues();
	}

	private MessageSource _messageSource;
}