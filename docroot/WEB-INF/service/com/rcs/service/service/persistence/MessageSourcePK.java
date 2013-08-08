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

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Serializable;

/**
 * @author flor
 */
public class MessageSourcePK implements Comparable<MessageSourcePK>,
	Serializable {
	public String key;
	public String locale;

	public MessageSourcePK() {
	}

	public MessageSourcePK(String key, String locale) {
		this.key = key;
		this.locale = locale;
	}

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public int compareTo(MessageSourcePK pk) {
		if (pk == null) {
			return -1;
		}

		int value = 0;

		value = key.compareTo(pk.key);

		if (value != 0) {
			return value;
		}

		value = locale.compareTo(pk.locale);

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MessageSourcePK)) {
			return false;
		}

		MessageSourcePK pk = (MessageSourcePK)obj;

		if ((key.equals(pk.key)) && (locale.equals(pk.locale))) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (String.valueOf(key) + String.valueOf(locale)).hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(10);

		sb.append(StringPool.OPEN_CURLY_BRACE);

		sb.append("key");
		sb.append(StringPool.EQUAL);
		sb.append(key);

		sb.append(StringPool.COMMA);
		sb.append(StringPool.SPACE);
		sb.append("locale");
		sb.append(StringPool.EQUAL);
		sb.append(locale);

		sb.append(StringPool.CLOSE_CURLY_BRACE);

		return sb.toString();
	}
}