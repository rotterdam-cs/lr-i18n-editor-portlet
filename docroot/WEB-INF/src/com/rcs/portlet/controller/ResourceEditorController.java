package com.rcs.portlet.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.portlet.MimeResponse;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.portlet.ModelAndView;
import org.springframework.web.portlet.bind.annotation.RenderMapping;
import org.springframework.web.portlet.bind.annotation.ResourceMapping;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.rcs.common.expert.MessageSourceExpert;
import com.rcs.common.utils.CustomMessage;
import com.rcs.common.utils.RcsConstants;
import com.rcs.service.service.MessageSourceLocalServiceUtil;

@Controller(value="ResourceEditorController")
@Scope("session")
@RequestMapping("VIEW")
public class ResourceEditorController {
	private static Log log = LogFactoryUtil.getLog(ResourceEditorController.class);	
	
	protected static final String DEFAULT_SUCCESS_RESULT = "{\"success\":true}";

    protected static final String DEFAULT_ERROR_RESULT = "{\"success\":false}";   
    
    private MessageSourceExpert messageSourceExpert = new MessageSourceExpert();
    
    protected void writeResponse(MimeResponse mimeResponse, String response){
        try{
            mimeResponse.setContentType("text/html");
            mimeResponse.getWriter().write(response);
        } catch (Exception e){
        	log.warn("Error while response, cause - " + e.getMessage(), e);
        }
    }
    
	@RenderMapping
	public ModelAndView resolveView(PortletRequest request, PortletResponse response) throws PortalException, SystemException, Exception {						
		HashMap<String, Object> model = new HashMap<String, Object>();
		Locale[] availableLocales = LanguageUtil.getAvailableLocales();
		List<String> bundles = MessageSourceLocalServiceUtil.getMessageBundles();
		model.put("locales", availableLocales);
		model.put("bundles", bundles);		
		return new ModelAndView("/WEB-INF/views/portal/i18n/view/view.jsp", model);
	}
	
	
	@ResourceMapping("resourceContent")
    public void resourceContent(@RequestParam("startIndex") Integer startIndex,
                                @RequestParam("pageSize") Integer pageSize,
                                @RequestParam(value = "resourcekey", required = false) String resourceKey,
                                @RequestParam(value = "resourcemessage", required = false) String resourceMessage,
                                @RequestParam(value = "resourcelocale", required = false) String resourceLocale,
                                @RequestParam(value = "resourcebundle", required = false) String resourceBundle,
                                ResourceRequest request, ResourceResponse response) {


        boolean findAll = StringUtils.isBlank(resourceKey) && StringUtils.isBlank(resourceMessage) &&
                (resourceBundle == null || RcsConstants.ALL_BUNDLES.equals(resourceBundle));               
        
        if (findAll)
            writeResponse(response, MessageSourceLocalServiceUtil.getMSWJson(startIndex, startIndex + pageSize));
        else
            writeResponse(response, MessageSourceLocalServiceUtil.getMSWJson(resourceKey, resourceLocale, resourceMessage, resourceBundle, startIndex, startIndex + pageSize));
    }
	
	@ResourceMapping("uploadResources")
    public void uploadResources(@RequestParam("data") String data, ResourceResponse response) {		
        List<CustomMessage> customMessages = messageSourceExpert.saveMessageSources(data, false);
        writeResponse(response, messageSourceExpert.getCMJson(customMessages));
    }
	
	@ResourceMapping("delete")
    public void delete(@RequestParam("data") String data) {
		messageSourceExpert.delete(data);
    }
	
	@RequestMapping(params = "render=edit")
    public ModelAndView edit(){
        ModelAndView mov = new ModelAndView("portal/i18n/view/edit");
        mov.addObject("locales", LanguageUtil.getAvailableLocales());
        return mov;
    }
	
	@ResourceMapping("save")
    public void save(@RequestParam("data") String data){
		messageSourceExpert.saveMessageSources(data, true);
    }
}
