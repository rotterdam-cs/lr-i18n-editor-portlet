package com.rcs.startup;

import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
//import com.rcs.i18n.common.cache.CacheService;
import com.rcs.common.config.ApplicationPropsBean;
import com.rcs.service.model.MessageSource;

import com.rcs.common.service.LocaleService;
//import com.rcs.i18n.common.service.ObjectFactory;
import com.rcs.service.service.MessageSourceLocalServiceUtil;
import com.rcs.service.service.persistence.MessageSourcePK;
import com.rcs.service.service.persistence.MessageSourceUtil;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.NoSuchMessageException;

import java.util.Locale;
import java.util.Map;

public abstract class BaseStartupProcessor extends SimpleAction {

    protected static final Logger _logger = Logger.getLogger(BaseStartupProcessor.class);

    /*@Autowired
    protected static ApplicationPropsBean props;*/

    //protected static CacheService cacheService = ObjectFactory.getBean("ehCacheService");
    
    /*@Autowired
    protected static MessageSourcePersistence messageSourcePersistence;*/

    @Autowired
    protected static LocaleService localeService;


    protected void checkAndSaveLanguageMap(Map<String, String> languageMap, Locale locale, String bundleName) {

        //go through language map
        for (Map.Entry<String, String> message : languageMap.entrySet()) {
        	try {
            //check if message isn't exist in the DB
        		
	        	MessageSourcePK messageSourcePK = new MessageSourcePK(message.getKey(), locale.toString());
	        	MessageSource messageSource = MessageSourceLocalServiceUtil.fetchMessageSource(messageSourcePK);
	        	//MessageSource messageSource = messageSourcePersistence.findByPrimaryKey(messageSourcePK);
	        	//MessageSource messageSource = MessageSourceUtil.findByResourceKeyAndLocale(message.getKey(), locale.toString()); 
	        			//MessageSourceUtil.fetchByPrimaryKey(messageSourcePK);
	            //MessageSource messageSource = messageSourcePersistence.getMessage(message.getKey(), locale.toString());
	        	
	            if (messageSource == null) {
	                //otherwise put message into DB
	                //messageSource = new MessageSource();
	            	//long msId = CounterLocalServiceUtil.increment(MessageSource.class.getName());	            	
	            	messageSource = MessageSourceUtil.create(messageSourcePK);
	                //MessageSourceUtil.create(messageSourcePK);
	            	//messageSource.setResourceKey(message.getKey());
	            	//messageSource.setResourceLocale(locale.toString());
	                messageSource.setValue(message.getValue());                
	                messageSource.setBundle(bundleName);
	                MessageSourceLocalServiceUtil.updateMessageSource(messageSource);
	                //messageSourcePersistence.insert(messageSource);
	            }
        	} catch (SystemException ex) {
        		ex.printStackTrace();
        	} catch (NoSuchMessageException ex) {
        		ex.printStackTrace();
        	} catch (Exception ex) {
        		ex.printStackTrace();
        	}

            //put into cache
            /*if (props.isCacheEnabled()) {
                cacheService.putResult(MessageSource.class.getSimpleName(), null,
                        new Object[]{message.getKey(), locale}, messageSource);
            }*/
        }

    }

    protected void _importBundle(String bundleName) throws Exception {

        //Locale[] availableLocales = localeService.getAvailableLocales();
    	Locale[] availableLocales = LanguageUtil.getAvailableLocales();

        _logger.info("Number of available locales is " + availableLocales.length);

        for (int i = 1; i <= availableLocales.length; i++) {

            Locale locale = availableLocales[i - 1];

            _logger.info("Start importing locale " + locale.toString() + ", for bundle " + "\"" + bundleName + "\"" + ", #" + i);

            Map<String, String> languageMap = getLanguageMap(locale);

            checkAndSaveLanguageMap(languageMap, locale, bundleName);

            //small formatting
            int leftNum = availableLocales.length - i;
            String leftStr = leftNum == 0 ? "nothing" : String.valueOf(leftNum);

            _logger.info("Stop importing locale " + locale.toString() + ", " + leftStr + " left");
        }

    }

    protected abstract Map<String, String>  getLanguageMap(Locale locale);

}
