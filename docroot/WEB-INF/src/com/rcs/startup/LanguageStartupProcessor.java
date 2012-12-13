package com.rcs.startup;

import com.rcs.service.model.MessageSource;
import com.rcs.service.service.MessageSourceLocalServiceUtil;
import com.rcs.common.utils.Importer;
import com.rcs.common.utils.PortalLanguageResourcesUtil;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.model.Portlet;
import com.liferay.portal.service.PortletLocalServiceUtil;
import com.liferay.util.portlet.PortletProps;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.*;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

/**
 * Class that imports languages on startup
 * 
 * @author flor
 */
public class LanguageStartupProcessor extends SimpleAction {

	protected static final Logger _logger = Logger.getLogger(LanguageStartupProcessor.class);

    @Override
    public void run(String[] ids) throws ActionException {
                    	
        try {   
        	if(StringUtils.equals("true", PortletProps.get("import.on.startup"))) {        		        
	        	_logger.info("Start language importing");
	        	
	        	Importer.importLanguages();
	        	
	        	MessageSourceLocalServiceUtil.findAll();
	        	
	        	_logger.info("Stop language importing");
        	}
		} catch (SystemException e) {
			_logger.error("Language importing exception", e);
		} catch (Exception e) {
			_logger.error("Language importing exception", e);			
		}                        
    }
}
