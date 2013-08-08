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

package com.rcs.service.service.base;

import com.rcs.service.service.MessageSourceLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 */
public class MessageSourceLocalServiceClpInvoker {
	public MessageSourceLocalServiceClpInvoker() {
		_methodName0 = "addMessageSource";

		_methodParameterTypes0 = new String[] {
				"com.rcs.service.model.MessageSource"
			};

		_methodName1 = "createMessageSource";

		_methodParameterTypes1 = new String[] {
				"com.rcs.service.service.persistence.MessageSourcePK"
			};

		_methodName2 = "deleteMessageSource";

		_methodParameterTypes2 = new String[] {
				"com.rcs.service.service.persistence.MessageSourcePK"
			};

		_methodName3 = "deleteMessageSource";

		_methodParameterTypes3 = new String[] {
				"com.rcs.service.model.MessageSource"
			};

		_methodName4 = "dynamicQuery";

		_methodParameterTypes4 = new String[] {  };

		_methodName5 = "dynamicQuery";

		_methodParameterTypes5 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName6 = "dynamicQuery";

		_methodParameterTypes6 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
			};

		_methodName7 = "dynamicQuery";

		_methodParameterTypes7 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
				"com.liferay.portal.kernel.util.OrderByComparator"
			};

		_methodName8 = "dynamicQueryCount";

		_methodParameterTypes8 = new String[] {
				"com.liferay.portal.kernel.dao.orm.DynamicQuery"
			};

		_methodName9 = "fetchMessageSource";

		_methodParameterTypes9 = new String[] {
				"com.rcs.service.service.persistence.MessageSourcePK"
			};

		_methodName10 = "getMessageSource";

		_methodParameterTypes10 = new String[] {
				"com.rcs.service.service.persistence.MessageSourcePK"
			};

		_methodName11 = "getPersistedModel";

		_methodParameterTypes11 = new String[] { "java.io.Serializable" };

		_methodName12 = "getMessageSources";

		_methodParameterTypes12 = new String[] { "int", "int" };

		_methodName13 = "getMessageSourcesCount";

		_methodParameterTypes13 = new String[] {  };

		_methodName14 = "updateMessageSource";

		_methodParameterTypes14 = new String[] {
				"com.rcs.service.model.MessageSource"
			};

		_methodName15 = "updateMessageSource";

		_methodParameterTypes15 = new String[] {
				"com.rcs.service.model.MessageSource", "boolean"
			};

		_methodName36 = "getBeanIdentifier";

		_methodParameterTypes36 = new String[] {  };

		_methodName37 = "setBeanIdentifier";

		_methodParameterTypes37 = new String[] { "java.lang.String" };

		_methodName42 = "getMessageBundles";

		_methodParameterTypes42 = new String[] {  };

		_methodName43 = "getMessageSourcesKeyCount";

		_methodParameterTypes43 = new String[] {  };

		_methodName44 = "getMessageSourcesKey";

		_methodParameterTypes44 = new String[] { "int", "int" };

		_methodName45 = "getMessageSources";

		_methodParameterTypes45 = new String[] { "int", "int" };

		_methodName46 = "getMessageSources";

		_methodParameterTypes46 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int"
			};

		_methodName47 = "getMessageSourcesKey";

		_methodParameterTypes47 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int"
			};

		_methodName48 = "getMessageSourcesKeyCount";

		_methodParameterTypes48 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String"
			};

		_methodName50 = "getMessageSourceWrappers";

		_methodParameterTypes50 = new String[] { "int", "int" };

		_methodName53 = "getMSWJson";

		_methodParameterTypes53 = new String[] { "int", "int" };

		_methodName54 = "getMSWJson";

		_methodParameterTypes54 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int"
			};

		_methodName55 = "getMessageSourceWrappers";

		_methodParameterTypes55 = new String[] {
				"java.lang.String", "java.lang.String", "java.lang.String",
				"java.lang.String", "int", "int"
			};

		_methodName56 = "getMessageSourcesByKey";

		_methodParameterTypes56 = new String[] { "java.lang.String" };

		_methodName57 = "clearCache";

		_methodParameterTypes57 = new String[] {  };

		_methodName58 = "findAll";

		_methodParameterTypes58 = new String[] {  };

		_methodName59 = "findByBundle";

		_methodParameterTypes59 = new String[] { "java.lang.String" };
	}

	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		if (_methodName0.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
			return MessageSourceLocalServiceUtil.addMessageSource((com.rcs.service.model.MessageSource)arguments[0]);
		}

		if (_methodName1.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
			return MessageSourceLocalServiceUtil.createMessageSource((com.rcs.service.service.persistence.MessageSourcePK)arguments[0]);
		}

		if (_methodName2.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
			return MessageSourceLocalServiceUtil.deleteMessageSource((com.rcs.service.service.persistence.MessageSourcePK)arguments[0]);
		}

		if (_methodName3.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
			return MessageSourceLocalServiceUtil.deleteMessageSource((com.rcs.service.model.MessageSource)arguments[0]);
		}

		if (_methodName4.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
			return MessageSourceLocalServiceUtil.dynamicQuery();
		}

		if (_methodName5.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
			return MessageSourceLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName6.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
			return MessageSourceLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue());
		}

		if (_methodName7.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
			return MessageSourceLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0],
				((Integer)arguments[1]).intValue(),
				((Integer)arguments[2]).intValue(),
				(com.liferay.portal.kernel.util.OrderByComparator)arguments[3]);
		}

		if (_methodName8.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
			return MessageSourceLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery)arguments[0]);
		}

		if (_methodName9.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
			return MessageSourceLocalServiceUtil.fetchMessageSource((com.rcs.service.service.persistence.MessageSourcePK)arguments[0]);
		}

		if (_methodName10.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
			return MessageSourceLocalServiceUtil.getMessageSource((com.rcs.service.service.persistence.MessageSourcePK)arguments[0]);
		}

		if (_methodName11.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
			return MessageSourceLocalServiceUtil.getPersistedModel((java.io.Serializable)arguments[0]);
		}

		if (_methodName12.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
			return MessageSourceLocalServiceUtil.getMessageSources(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName13.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
			return MessageSourceLocalServiceUtil.getMessageSourcesCount();
		}

		if (_methodName14.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
			return MessageSourceLocalServiceUtil.updateMessageSource((com.rcs.service.model.MessageSource)arguments[0]);
		}

		if (_methodName15.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
			return MessageSourceLocalServiceUtil.updateMessageSource((com.rcs.service.model.MessageSource)arguments[0],
				((Boolean)arguments[1]).booleanValue());
		}

		if (_methodName36.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes36, parameterTypes)) {
			return MessageSourceLocalServiceUtil.getBeanIdentifier();
		}

		if (_methodName37.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes37, parameterTypes)) {
			MessageSourceLocalServiceUtil.setBeanIdentifier((java.lang.String)arguments[0]);

			return null;
		}

		if (_methodName42.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes42, parameterTypes)) {
			return MessageSourceLocalServiceUtil.getMessageBundles();
		}

		if (_methodName43.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes43, parameterTypes)) {
			return MessageSourceLocalServiceUtil.getMessageSourcesKeyCount();
		}

		if (_methodName44.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes44, parameterTypes)) {
			return MessageSourceLocalServiceUtil.getMessageSourcesKey(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName45.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes45, parameterTypes)) {
			return MessageSourceLocalServiceUtil.getMessageSources(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName46.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes46, parameterTypes)) {
			return MessageSourceLocalServiceUtil.getMessageSources((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName47.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes47, parameterTypes)) {
			return MessageSourceLocalServiceUtil.getMessageSourcesKey((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName48.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes48, parameterTypes)) {
			return MessageSourceLocalServiceUtil.getMessageSourcesKeyCount((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3]);
		}

		if (_methodName50.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes50, parameterTypes)) {
			return MessageSourceLocalServiceUtil.getMessageSourceWrappers(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName53.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes53, parameterTypes)) {
			return MessageSourceLocalServiceUtil.getMSWJson(((Integer)arguments[0]).intValue(),
				((Integer)arguments[1]).intValue());
		}

		if (_methodName54.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes54, parameterTypes)) {
			return MessageSourceLocalServiceUtil.getMSWJson((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName55.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes55, parameterTypes)) {
			return MessageSourceLocalServiceUtil.getMessageSourceWrappers((java.lang.String)arguments[0],
				(java.lang.String)arguments[1], (java.lang.String)arguments[2],
				(java.lang.String)arguments[3],
				((Integer)arguments[4]).intValue(),
				((Integer)arguments[5]).intValue());
		}

		if (_methodName56.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes56, parameterTypes)) {
			return MessageSourceLocalServiceUtil.getMessageSourcesByKey((java.lang.String)arguments[0]);
		}

		if (_methodName57.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes57, parameterTypes)) {
			MessageSourceLocalServiceUtil.clearCache();

			return null;
		}

		if (_methodName58.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes58, parameterTypes)) {
			return MessageSourceLocalServiceUtil.findAll();
		}

		if (_methodName59.equals(name) &&
				Arrays.deepEquals(_methodParameterTypes59, parameterTypes)) {
			return MessageSourceLocalServiceUtil.findByBundle((java.lang.String)arguments[0]);
		}

		throw new UnsupportedOperationException();
	}

	private String _methodName0;
	private String[] _methodParameterTypes0;
	private String _methodName1;
	private String[] _methodParameterTypes1;
	private String _methodName2;
	private String[] _methodParameterTypes2;
	private String _methodName3;
	private String[] _methodParameterTypes3;
	private String _methodName4;
	private String[] _methodParameterTypes4;
	private String _methodName5;
	private String[] _methodParameterTypes5;
	private String _methodName6;
	private String[] _methodParameterTypes6;
	private String _methodName7;
	private String[] _methodParameterTypes7;
	private String _methodName8;
	private String[] _methodParameterTypes8;
	private String _methodName9;
	private String[] _methodParameterTypes9;
	private String _methodName10;
	private String[] _methodParameterTypes10;
	private String _methodName11;
	private String[] _methodParameterTypes11;
	private String _methodName12;
	private String[] _methodParameterTypes12;
	private String _methodName13;
	private String[] _methodParameterTypes13;
	private String _methodName14;
	private String[] _methodParameterTypes14;
	private String _methodName15;
	private String[] _methodParameterTypes15;
	private String _methodName36;
	private String[] _methodParameterTypes36;
	private String _methodName37;
	private String[] _methodParameterTypes37;
	private String _methodName42;
	private String[] _methodParameterTypes42;
	private String _methodName43;
	private String[] _methodParameterTypes43;
	private String _methodName44;
	private String[] _methodParameterTypes44;
	private String _methodName45;
	private String[] _methodParameterTypes45;
	private String _methodName46;
	private String[] _methodParameterTypes46;
	private String _methodName47;
	private String[] _methodParameterTypes47;
	private String _methodName48;
	private String[] _methodParameterTypes48;
	private String _methodName50;
	private String[] _methodParameterTypes50;
	private String _methodName53;
	private String[] _methodParameterTypes53;
	private String _methodName54;
	private String[] _methodParameterTypes54;
	private String _methodName55;
	private String[] _methodParameterTypes55;
	private String _methodName56;
	private String[] _methodParameterTypes56;
	private String _methodName57;
	private String[] _methodParameterTypes57;
	private String _methodName58;
	private String[] _methodParameterTypes58;
	private String _methodName59;
	private String[] _methodParameterTypes59;
}