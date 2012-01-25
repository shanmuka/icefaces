/*
 * Copyright 2004-2012 ICEsoft Technologies Canada Corp.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an "AS
 * IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */

package org.icefaces.samples.showcase.example.compat.menuPopup;

import java.io.Serializable;

import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.model.SelectItem;

import org.icefaces.samples.showcase.metadata.annotation.ComponentExample;
import org.icefaces.samples.showcase.metadata.annotation.ExampleResource;
import org.icefaces.samples.showcase.metadata.annotation.ExampleResources;
import org.icefaces.samples.showcase.metadata.annotation.ResourceType;
import org.icefaces.samples.showcase.metadata.context.ComponentExampleImpl;

@ComponentExample(
        parent = MenuPopupBean.BEAN_NAME,
        title = "example.compat.menuPopup.hide.title",
        description = "example.compat.menuPopup.hide.description",
        example = "/resources/examples/compat/menuPopup/menuPopupHide.xhtml"
)
@ExampleResources(
        resources ={
            // xhtml
            @ExampleResource(type = ResourceType.xhtml,
                    title="menuPopupHide.xhtml",
                    resource = "/resources/examples/compat/"+
                               "menuPopup/menuPopupHide.xhtml"),
            // Java Source
            @ExampleResource(type = ResourceType.java,
                    title="MenuPopupHide.java",
                    resource = "/WEB-INF/classes/org/icefaces/samples/"+
                               "showcase/example/compat/menuPopup/MenuPopupHide.java")
        }
)
@ManagedBean(name= MenuPopupHide.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class MenuPopupHide extends ComponentExampleImpl<MenuPopupHide> implements Serializable {
	
	public static final String BEAN_NAME = "menuPopupHide";
	
	private SelectItem[] availableHides = new SelectItem[] {
	    new SelectItem("mousedown", "Mouse Down"),
	    new SelectItem("mouseout", "Mouse Out"),
	};
	private String hide = availableHides[0].getValue().toString();
	
	public MenuPopupHide() {
		super(MenuPopupHide.class);
	}
	
	public SelectItem[] getAvailableHides() { return availableHides; }
	public String getHide() { return hide; }
	
	public void setHide(String hide) { this.hide = hide; }
}
