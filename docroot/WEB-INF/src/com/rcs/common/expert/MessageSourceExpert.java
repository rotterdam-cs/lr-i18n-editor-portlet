package com.rcs.common.expert;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Component;

import sun.util.logging.resources.logging;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.rcs.common.utils.CustomMessage;
import com.rcs.service.model.MessageSource;
import com.rcs.service.model.impl.MessageSourceImpl;
import com.rcs.service.model.impl.MessageSourceModelImpl;
import com.rcs.service.service.MessageSourceLocalServiceUtil;
import com.rcs.service.service.impl.MessageSourceLocalServiceImpl;
import com.rcs.service.service.persistence.MessageSourceUtil;

@Component
public class MessageSourceExpert {
	
	private static Log _logger = LogFactoryUtil.getLog(MessageSourceExpert.class);
	
	public static final String EMPTY_JSON = "[]";
	
	public List<CustomMessage> delete(String data) {
        if (StringUtils.isNotBlank(data)) {
        	//@@probar
            //persistence.deleteThroughHQL(data);
        	try {        		
        		//MessageSourceLocalServiceUtil.getMessageSourcesByKey(data);
				List<MessageSource> messageSources = MessageSourceLocalServiceUtil.getMessageSourcesByKey(data);
				for(MessageSource messageSource : messageSources) {
					MessageSourceLocalServiceUtil.deleteMessageSource(messageSource);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	//this.de
        }
        return Collections.emptyList();
    }
	
	public String getCMJson(List<CustomMessage> customMessages) {
        try {
            return new ObjectMapper().writeValueAsString(customMessages);
        } catch (IOException e) {
            //_logger.error("Cannot serialize CustomMessage list, cause: " + e.getMessage(), e);
        }
        return EMPTY_JSON;
        //return "";
    }
	
	private List<CustomMessage> getCustomMessageList(CustomMessage ... customMessages) {
        return new LinkedList<CustomMessage>(Arrays.asList(customMessages));
    }
	
	private List<MessageSource> deserializeMessageSources(String data) throws IOException {
        ObjectMapper om = new ObjectMapper();
        return om.readValue(data, new TypeReference<List<MessageSourceImpl>>() {});
    }
	
	public List<CustomMessage> saveMessageSources(String data, Boolean save) {		
		_logger.debug("error: " + save);
        try {
            List<MessageSource> messageSourceList = deserializeMessageSources(data);

            for (MessageSource messageSource : messageSourceList) {

            	_logger.debug("messageSource: " + messageSource);
                if (save) {
                	MessageSourceLocalServiceUtil.addMessageSource(messageSource);                	
                    //persistence.insert(messageSource);
                } else {
                	MessageSourceLocalServiceUtil.updateMessageSource(messageSource);
                    //persistence.updateThroughHQL(messageSource);
                }
                MessageSourceLocalServiceUtil.clearCache();
                //@@todo: clear cache
                //put into cache
                /*if (props.isCacheEnabled()) {
                    cacheService.putResult(MessageSource.class.getSimpleName(), null,
                            new Object[]{messageSource.getKey(), messageSource.getLocale()}, messageSource);
                }*/
            }
        } catch (SystemException e) {
        	_logger.error("Cannot save data cause: " + e.getMessage(), e);
            return getCustomMessageList(new CustomMessage("resources not saved", true));        
        } catch (IOException e) {
            _logger.error("Cannot save data cause: " + e.getMessage(), e);
            return getCustomMessageList(new CustomMessage("resources not saved", true));
        }
        return getCustomMessageList(new CustomMessage("resources saved", false));
    }
}
