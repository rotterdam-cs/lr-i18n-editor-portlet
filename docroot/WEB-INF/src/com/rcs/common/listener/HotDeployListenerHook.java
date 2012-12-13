package com.rcs.common.listener;


import com.liferay.portal.kernel.deploy.hot.HotDeployEvent;
import com.liferay.portal.kernel.deploy.hot.HotDeployException;
import com.liferay.portal.kernel.deploy.hot.HotDeployListener;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.security.auth.CompanyThreadLocal;
import com.liferay.portal.util.PortalUtil;
import com.rcs.common.utils.Importer;

import org.apache.log4j.Logger;
import javax.servlet.ServletContext;

public class HotDeployListenerHook implements HotDeployListener {

    private static final Logger _logger = Logger.getLogger(HotDeployListenerHook.class);

    public static final String DEFAULT_RESOURCE_NAME = "Language.properties";

    public static final String DEFAULT_RESOURCE_PREFIX = "Language_";
    public static final String DEFAULT_RESOURCE_SUFFIX = ".properties";

    public static final String LIFERAY_HOOK_PATH = "/WEB-INF/liferay-hook.xml";   
   
    @Override
    public void invokeDeploy(HotDeployEvent hotDeployEvent) throws HotDeployException {

    	ServletContext servletContext = hotDeployEvent.getServletContext();
        
        String bundleName = hotDeployEvent.getPluginPackage().getName();
                
        long currentCompanyID = CompanyThreadLocal.getCompanyId();
        CompanyThreadLocal.setCompanyId(PortalUtil.getDefaultCompanyId());                    
    	try {
			Importer.importPortletLanguages(servletContext, bundleName);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	CompanyThreadLocal.setCompanyId(currentCompanyID);
    }

    @Override
    public void invokeUndeploy(HotDeployEvent event) throws HotDeployException {

    }
}
