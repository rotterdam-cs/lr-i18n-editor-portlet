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

package com.rcs.service.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import com.rcs.service.model.MessageSource;

import java.io.Serializable;

/**
 * The cache model class for representing MessageSource in entity cache.
 *
 * @author flor
 * @see MessageSource
 * @generated
 */
public class MessageSourceCacheModel implements CacheModel<MessageSource>,
	Serializable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(9);

		sb.append("{key=");
		sb.append(key);
		sb.append(", locale=");
		sb.append(locale);
		sb.append(", value=");
		sb.append(value);
		sb.append(", bundle=");
		sb.append(bundle);
		sb.append("}");

		return sb.toString();
	}

	public MessageSource toEntityModel() {
		MessageSourceImpl messageSourceImpl = new MessageSourceImpl();

		if (key == null) {
			messageSourceImpl.setKey(StringPool.BLANK);
		}
		else {
			messageSourceImpl.setKey(key);
		}

		if (locale == null) {
			messageSourceImpl.setLocale(StringPool.BLANK);
		}
		else {
			messageSourceImpl.setLocale(locale);
		}

		if (value == null) {
			messageSourceImpl.setValue(StringPool.BLANK);
		}
		else {
			messageSourceImpl.setValue(value);
		}

		if (bundle == null) {
			messageSourceImpl.setBundle(StringPool.BLANK);
		}
		else {
			messageSourceImpl.setBundle(bundle);
		}

		messageSourceImpl.resetOriginalValues();

		return messageSourceImpl;
	}

	public String key;
	public String locale;
	public String value;
	public String bundle;
}