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

package org.icefaces.samples.showcase.example.compat.series;

import java.io.Serializable;

import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import org.icefaces.samples.showcase.metadata.annotation.ComponentExample;
import org.icefaces.samples.showcase.metadata.annotation.ExampleResource;
import org.icefaces.samples.showcase.metadata.annotation.ExampleResources;
import org.icefaces.samples.showcase.metadata.annotation.Menu;
import org.icefaces.samples.showcase.metadata.annotation.MenuLink;
import org.icefaces.samples.showcase.metadata.annotation.ResourceType;
import org.icefaces.samples.showcase.metadata.context.ComponentExampleImpl;

@ComponentExample(
        title = "example.compat.series.title",
        description = "example.compat.series.description",
        example = "/resources/examples/compat/series/series.xhtml"
)
@ExampleResources(
        resources ={
            // xhtml
            @ExampleResource(type = ResourceType.xhtml,
                    title="series.xhtml",
                    resource = "/resources/examples/compat/"+
                               "series/series.xhtml"),
            // Java Source
            @ExampleResource(type = ResourceType.java,
                    title="SeriesBean.java",
                    resource = "/WEB-INF/classes/org/icefaces/samples/"+
                               "showcase/example/compat/series/SeriesBean.java")
        }
)
@Menu(
	title = "menu.compat.series.subMenu.title",
	menuLinks = {
            @MenuLink(title = "menu.compat.series.subMenu.main",
                    isDefault = true,
                    exampleBeanName = SeriesBean.BEAN_NAME),
            @MenuLink(title = "menu.compat.series.subMenu.dynamic",
                    exampleBeanName = SeriesDynamic.BEAN_NAME),
            @MenuLink(title = "menu.compat.series.subMenu.rows",
                    exampleBeanName = SeriesRows.BEAN_NAME),
            @MenuLink(title = "menu.compat.series.subMenu.first",
                    exampleBeanName = SeriesFirst.BEAN_NAME),
            @MenuLink(title = "menu.compat.series.subMenu.content",
                    exampleBeanName = SeriesContent.BEAN_NAME),
            @MenuLink(title = "menu.compat.series.subMenu.style",
                    exampleBeanName = SeriesStyle.BEAN_NAME)
})
@ManagedBean(name= SeriesBean.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class SeriesBean extends ComponentExampleImpl<SeriesBean> implements Serializable {
	
	public static final String BEAN_NAME = "series";
	
	public SeriesBean() {
		super(SeriesBean.class);
	}
}
