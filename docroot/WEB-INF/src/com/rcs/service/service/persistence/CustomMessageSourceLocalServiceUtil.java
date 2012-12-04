package com.rcs.service.service.persistence;

import java.util.List;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.rcs.service.NoSuchMessageSourceException;
import com.rcs.service.model.MessageSource;
import com.rcs.service.service.MessageSourceLocalServiceUtil;


public class CustomMessageSourceLocalServiceUtil extends
		MessageSourceLocalServiceUtil {
	
	private static Log log = LogFactoryUtil.getLog(CustomMessageSourceLocalServiceUtil.class);
	
	private static CustomMessageSourcePersistenceImpl customPersistence;
	
	public static List<MessageSource> getMessageSources(int start,int end) throws SystemException {
		log.error("CustomMessageSourceLocalServiceUtil: 1: first");
		CustomMessageSourcePersistenceImpl persistence = (CustomMessageSourcePersistenceImpl) getCustomPersistence();
		log.error("CustomMessageSourceLocalServiceUtil: persistence: " + persistence);
		return persistence.getMessageSources(persistence, start, end);
	}

	private static CustomMessageSourcePersistenceImpl getCustomPersistence() {
		if (customPersistence == null) {
            customPersistence = new CustomMessageSourcePersistenceImpl();
        }
		return customPersistence;
	}

	private static void setCustomPersistence(CustomMessageSourcePersistenceImpl customPersistence) {
		CustomMessageSourceLocalServiceUtil.customPersistence = customPersistence;
	}
}
