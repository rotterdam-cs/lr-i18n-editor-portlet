package com.rcs.common.expert;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.stereotype.Component;

import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.rcs.common.utils.CustomMessage;
import com.rcs.service.model.MessageSource;
import com.rcs.service.model.impl.MessageSourceImpl;
import com.rcs.service.service.MessageSourceLocalServiceUtil;

@Component
public class MessageSourceExpert {
	
	private static final Log _logger = LogFactoryUtil.getLog(MessageSourceExpert.class);
	
	public static final String EMPTY_JSON = "[]";
	
	public List<CustomMessage> delete(String data) {
        if (StringUtils.isNotBlank(data)) {
        	try {        		        		
				List<MessageSource> messageSources = MessageSourceLocalServiceUtil.getMessageSourcesByKey(data);
				for(MessageSource messageSource : messageSources) {
					MessageSourceLocalServiceUtil.deleteMessageSource(messageSource);
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        return Collections.emptyList();
    }
	
	public String getCMJson(List<CustomMessage> customMessages) {
        try {
            return new ObjectMapper().writeValueAsString(customMessages);
        } catch (IOException ignored) {}
        return EMPTY_JSON;        
    }
	
	private List<CustomMessage> getCustomMessageList(CustomMessage ... customMessages) {
        return new LinkedList<CustomMessage>(Arrays.asList(customMessages));
    }
	
	private List<MessageSource> deserializeMessageSources(String data) throws IOException {
        ObjectMapper om = new ObjectMapper();
        return om.readValue(data, new TypeReference<List<MessageSourceImpl>>() {});
    }
	
	public List<CustomMessage> saveMessageSources(String data, Boolean save) {				
        try {
            List<MessageSource> messageSourceList = deserializeMessageSources(data);

            for (MessageSource messageSource : messageSourceList) {
            
                if (save) {
                	MessageSourceLocalServiceUtil.addMessageSource(messageSource);                	                   
                } else {
                	MessageSourceLocalServiceUtil.updateMessageSource(messageSource);
                }
                MessageSourceLocalServiceUtil.clearCache();
            }
        } catch (SystemException e) {
        	_logger.warn("Cannot save data cause: " + e.getMessage(), e);
            return getCustomMessageList(new CustomMessage("resources not saved", true));        
        } catch (IOException e) {
            _logger.warn("Cannot save data cause: " + e.getMessage(), e);
            return getCustomMessageList(new CustomMessage("resources not saved", true));
        }
        return getCustomMessageList(new CustomMessage("resources saved", false));
    }
}
