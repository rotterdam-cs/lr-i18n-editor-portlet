/**
 * Copyright (c) 2000-2012 Liferay, Inc. All rights reserved.
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

package com.rcs.service.model.impl;

import org.codehaus.jackson.annotate.JsonIgnore;

import com.liferay.portal.model.BaseModel;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.expando.model.ExpandoBridge;

/**
 * The extended model implementation for the MessageSource service. Represents a row in the &quot;resourceEditor_MessageSource&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * Helper methods and all application logic should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.rcs.service.model.MessageSource} interface.
 * </p>
 *
 * @author flor
 */
public class MessageSourceImpl extends MessageSourceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. All methods that expect a message source model instance should use the {@link com.rcs.service.model.MessageSource} interface instead.
	 */
	public MessageSourceImpl() {
	}

	@JsonIgnore
	@Override
	public ExpandoBridge getExpandoBridge() {
		// TODO Auto-generated method stub
		return super.getExpandoBridge();
	}

	@JsonIgnore
	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel) {
		// TODO Auto-generated method stub
		super.setExpandoBridgeAttributes(baseModel);
	}

	@JsonIgnore
	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		// TODO Auto-generated method stub
		super.setExpandoBridgeAttributes(expandoBridge);
	}
	
	@JsonIgnore
	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		// TODO Auto-generated method stub
		super.setExpandoBridgeAttributes(serviceContext);
	}
}