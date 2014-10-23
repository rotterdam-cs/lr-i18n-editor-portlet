package com.rcs.common.utils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.MethodKey;
import com.liferay.portal.kernel.util.PortalClassInvoker;
import com.liferay.portal.kernel.util.PortalClassLoaderUtil;
import com.liferay.support.tomcat.loader.PortalClassLoader;

import java.util.Collections;
import java.util.Locale;
import java.util.Map;

public final class PortalLanguageResourcesUtil {
    
    private static Log _logger = LogFactoryUtil.getLog(PortalLanguageResourcesUtil.class);
    
    private static final String LANGUAGE_RESOURCES_CLASS_NAME =
            "com.liferay.portal.language.LanguageResources";
    private static final String LANGUAGE_MAPS_FIELD_NAME =
            "_languageMaps";
    
    public static void putLanguageMap(Locale locale) throws Exception{
    	Class clazz=PortalReflectionUtil.getPortalClass(LANGUAGE_RESOURCES_CLASS_NAME);
    	MethodKey methodKey=new MethodKey(clazz, "putLanguageMap", Locale.class, Map.class);
        PortalClassInvoker.invoke(false, methodKey,
                locale, Collections.emptyMap());
    }

    public static Map<String, String> getLanguageMap(Locale locale){
        return getLanguageMaps().get(locale);
    }

    @SuppressWarnings("unchecked")
    public static Map<Locale, Map<String, String>> getLanguageMaps(){
        return (Map<Locale, Map<String, String>>) PortalReflectionUtil
                .getPortalFieldValue(LANGUAGE_RESOURCES_CLASS_NAME, LANGUAGE_MAPS_FIELD_NAME);
    }
}
