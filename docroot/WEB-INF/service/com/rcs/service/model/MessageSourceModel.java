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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import com.rcs.service.service.persistence.MessageSourcePK;

import java.io.Serializable;

/**
 * The base model interface for the MessageSource service. Represents a row in the &quot;editor_MessageSource&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.rcs.service.model.impl.MessageSourceModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.rcs.service.model.impl.MessageSourceImpl}.
 * </p>
 *
 * @author flor
 * @see MessageSource
 * @see com.rcs.service.model.impl.MessageSourceImpl
 * @see com.rcs.service.model.impl.MessageSourceModelImpl
 * @generated
 */
public interface MessageSourceModel extends BaseModel<MessageSource> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a message source model instance should use the {@link MessageSource} interface instead.
	 */

	/**
	 * Returns the primary key of this message source.
	 *
	 * @return the primary key of this message source
	 */
	public MessageSourcePK getPrimaryKey();

	/**
	 * Sets the primary key of this message source.
	 *
	 * @param primaryKey the primary key of this message source
	 */
	public void setPrimaryKey(MessageSourcePK primaryKey);

	/**
	 * Returns the key of this message source.
	 *
	 * @return the key of this message source
	 */
	@AutoEscape
	public String getKey();

	/**
	 * Sets the key of this message source.
	 *
	 * @param key the key of this message source
	 */
	public void setKey(String key);

	/**
	 * Returns the locale of this message source.
	 *
	 * @return the locale of this message source
	 */
	@AutoEscape
	public String getLocale();

	/**
	 * Sets the locale of this message source.
	 *
	 * @param locale the locale of this message source
	 */
	public void setLocale(String locale);

	/**
	 * Returns the value of this message source.
	 *
	 * @return the value of this message source
	 */
	@AutoEscape
	public String getValue();

	/**
	 * Sets the value of this message source.
	 *
	 * @param value the value of this message source
	 */
	public void setValue(String value);

	/**
	 * Returns the bundle of this message source.
	 *
	 * @return the bundle of this message source
	 */
	@AutoEscape
	public String getBundle();

	/**
	 * Sets the bundle of this message source.
	 *
	 * @param bundle the bundle of this message source
	 */
	public void setBundle(String bundle);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(MessageSource messageSource);

	@Override
	public int hashCode();

	@Override
	public CacheModel<MessageSource> toCacheModel();

	@Override
	public MessageSource toEscapedModel();

	@Override
	public MessageSource toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}