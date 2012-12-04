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

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import com.rcs.service.service.MessageSourceLocalServiceUtil;
import com.rcs.service.service.persistence.MessageSourcePK;

import java.io.Serializable;

import java.lang.reflect.Proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * @author flor
 */
public class MessageSourceClp extends BaseModelImpl<MessageSource>
	implements MessageSource {
	public MessageSourceClp() {
	}

	public Class<?> getModelClass() {
		return MessageSource.class;
	}

	public String getModelClassName() {
		return MessageSource.class.getName();
	}

	public MessageSourcePK getPrimaryKey() {
		return new MessageSourcePK(_key, _locale);
	}

	public void setPrimaryKey(MessageSourcePK primaryKey) {
		setKey(primaryKey.key);
		setLocale(primaryKey.locale);
	}

	public Serializable getPrimaryKeyObj() {
		return new MessageSourcePK(_key, _locale);
	}

	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((MessageSourcePK)primaryKeyObj);
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

	public String getKey() {
		return _key;
	}

	public void setKey(String key) {
		_key = key;
	}

	public String getLocale() {
		return _locale;
	}

	public void setLocale(String locale) {
		_locale = locale;
	}

	public String getValue() {
		return _value;
	}

	public void setValue(String value) {
		_value = value;
	}

	public String getBundle() {
		return _bundle;
	}

	public void setBundle(String bundle) {
		_bundle = bundle;
	}

	public BaseModel<?> getMessageSourceRemoteModel() {
		return _messageSourceRemoteModel;
	}

	public void setMessageSourceRemoteModel(
		BaseModel<?> messageSourceRemoteModel) {
		_messageSourceRemoteModel = messageSourceRemoteModel;
	}

	public void persist() throws SystemException {
		if (this.isNew()) {
			MessageSourceLocalServiceUtil.addMessageSource(this);
		}
		else {
			MessageSourceLocalServiceUtil.updateMessageSource(this);
		}
	}

	@Override
	public MessageSource toEscapedModel() {
		return (MessageSource)Proxy.newProxyInstance(MessageSource.class.getClassLoader(),
			new Class[] { MessageSource.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		MessageSourceClp clone = new MessageSourceClp();

		clone.setKey(getKey());
		clone.setLocale(getLocale());
		clone.setValue(getValue());
		clone.setBundle(getBundle());

		return clone;
	}

	public int compareTo(MessageSource messageSource) {
		int value = 0;

		value = getKey().compareTo(messageSource.getKey());

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}

		MessageSourceClp messageSource = null;

		try {
			messageSource = (MessageSourceClp)obj;
		}
		catch (ClassCastException cce) {
			return false;
		}

		MessageSourcePK primaryKey = messageSource.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{key=");
		sb.append(getKey());
		sb.append(", locale=");
		sb.append(getLocale());
		sb.append(", value=");
		sb.append(getValue());
		sb.append(", bundle=");
		sb.append(getBundle());
		sb.append("}");

		return sb.toString();
	}

	public String toXmlString() {
		StringBundler sb = new StringBundler(16);

		sb.append("<model><model-name>");
		sb.append("com.rcs.service.model.MessageSource");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>key</column-name><column-value><![CDATA[");
		sb.append(getKey());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>locale</column-name><column-value><![CDATA[");
		sb.append(getLocale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>value</column-name><column-value><![CDATA[");
		sb.append(getValue());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>bundle</column-name><column-value><![CDATA[");
		sb.append(getBundle());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private String _key;
	private String _locale;
	private String _value;
	private String _bundle;
	private BaseModel<?> _messageSourceRemoteModel;
}