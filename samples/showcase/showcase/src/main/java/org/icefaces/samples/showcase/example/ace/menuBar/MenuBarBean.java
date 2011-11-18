/*
 * Version: MPL 1.1
 *
 * The contents of this file are subject to the Mozilla Public License
 * Version 1.1 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://www.mozilla.org/MPL/
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations under
 * the License.
 *
 * The Original Code is ICEfaces 1.5 open source software code, released
 * November 5, 2006. The Initial Developer of the Original Code is ICEsoft
 * Technologies Canada, Corp. Portions created by ICEsoft are Copyright (C)
 * 2004-2011 ICEsoft Technologies Canada, Corp. All Rights Reserved.
 *
 * Contributor(s): _____________________.
 */

package org.icefaces.samples.showcase.example.ace.menuBar;

import org.icefaces.samples.showcase.metadata.annotation.*;
import org.icefaces.samples.showcase.metadata.context.ComponentExampleImpl;

import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.event.FacesEvent;
import javax.faces.event.ValueChangeEvent;
import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@ComponentExample(
        title = "example.ace.menuBar.title",
        description = "example.ace.menuBar.description",
        example = "/resources/examples/ace/menuBar/menuBar.xhtml"
)
@ExampleResources(
        resources ={
            // xhtml
            @ExampleResource(type = ResourceType.xhtml,
                    title="menuBar.xhtml",
                    resource = "/resources/examples/ace/menuBar/menuBar.xhtml"),
            // Java Source
            @ExampleResource(type = ResourceType.java,
                    title="MenuBarBean.java",
                    resource = "/WEB-INF/classes/org/icefaces/samples/showcase"+
                    "/example/ace/menuBar/MenuBarBean.java")
        }
)
@Menu(
	title = "menu.ace.menuBar.subMenu.title",
	menuLinks = {
	        @MenuLink(title = "menu.ace.menuBar.subMenu.main",
	                isDefault = true,
                    exampleBeanName = MenuBarBean.BEAN_NAME),
            @MenuLink(title = "menu.ace.menuBar.subMenu.effect",
                exampleBeanName = MenuBarEffect.BEAN_NAME),
            @MenuLink(title = "menu.ace.menuBar.subMenu.click",
                exampleBeanName = MenuBarClick.BEAN_NAME)
    }
)
@ManagedBean(name= MenuBarBean.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class MenuBarBean extends ComponentExampleImpl<MenuBarBean> implements
    Serializable {

    public static final String BEAN_NAME = "menuBarBean";

    public MenuBarBean() {
        super(MenuBarBean.class);
    }
}