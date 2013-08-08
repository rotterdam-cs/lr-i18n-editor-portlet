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

import com.rcs.service.service.persistence.MessageSourcePK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author    flor
 * @generated
 */
public class MessageSourceSoap implements Serializable {
	public static MessageSourceSoap toSoapModel(MessageSource model) {
		MessageSourceSoap soapModel = new MessageSourceSoap();

		soapModel.setKey(model.getKey());
		soapModel.setLocale(model.getLocale());
		soapModel.setValue(model.getValue());
		soapModel.setBundle(model.getBundle());

		return soapModel;
	}

	public static MessageSourceSoap[] toSoapModels(MessageSource[] models) {
		MessageSourceSoap[] soapModels = new MessageSourceSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MessageSourceSoap[][] toSoapModels(MessageSource[][] models) {
		MessageSourceSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MessageSourceSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MessageSourceSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MessageSourceSoap[] toSoapModels(List<MessageSource> models) {
		List<MessageSourceSoap> soapModels = new ArrayList<MessageSourceSoap>(models.size());

		for (MessageSource model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MessageSourceSoap[soapModels.size()]);
	}

	public MessageSourceSoap() {
	}

	public MessageSourcePK getPrimaryKey() {
		return new MessageSourcePK(_key, _locale);
	}

	public void setPrimaryKey(MessageSourcePK pk) {
		setKey(pk.key);
		setLocale(pk.locale);
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

	private String _key;
	private String _locale;
	private String _value;
	private String _bundle;
}