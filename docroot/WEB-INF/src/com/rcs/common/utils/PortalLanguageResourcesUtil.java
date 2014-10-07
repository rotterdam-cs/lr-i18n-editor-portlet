package com.rcs.common.utils;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.PortalClassInvoker;

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
        PortalClassInvoker.invoke(false, LANGUAGE_RESOURCES_CLASS_NAME,
                "putLanguageMap",
                new String[]{Locale.class.getName(), Map.class.getName()},
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
