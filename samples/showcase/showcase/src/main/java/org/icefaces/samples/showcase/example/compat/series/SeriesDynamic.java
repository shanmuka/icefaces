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

import org.icefaces.samples.showcase.util.FacesUtils;
import org.icefaces.samples.showcase.metadata.annotation.ComponentExample;
import org.icefaces.samples.showcase.metadata.annotation.ExampleResource;
import org.icefaces.samples.showcase.metadata.annotation.ExampleResources;
import org.icefaces.samples.showcase.metadata.annotation.Menu;
import org.icefaces.samples.showcase.metadata.annotation.MenuLink;
import org.icefaces.samples.showcase.metadata.annotation.ResourceType;
import org.icefaces.samples.showcase.metadata.context.ComponentExampleImpl;

@ComponentExample(
        parent = SeriesBean.BEAN_NAME,
        title = "example.compat.series.dynamic.title",
        description = "example.compat.series.dynamic.description",
        example = "/resources/examples/compat/series/seriesDynamic.xhtml"
)
@ExampleResources(
        resources ={
            // xhtml
            @ExampleResource(type = ResourceType.xhtml,
                    title="seriesDynamic.xhtml",
                    resource = "/resources/examples/compat/"+
                               "series/seriesDynamic.xhtml"),
            // Java Source
            @ExampleResource(type = ResourceType.java,
                    title="SeriesDynamic.java",
                    resource = "/WEB-INF/classes/org/icefaces/samples/"+
                               "showcase/example/compat/series/SeriesDynamic.java")
        }
)
@ManagedBean(name= SeriesDynamic.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class SeriesDynamic extends ComponentExampleImpl<SeriesDynamic> implements Serializable {
	
	public static final String BEAN_NAME = "seriesDynamic";
	
	private Employee toAdd = new Employee();
	private String toRemove;
	
	public SeriesDynamic() {
		super(SeriesDynamic.class);
	}
	
	public Employee getToAdd() { return toAdd; }
	public String getToRemove() { return toRemove; }
	
	public void setToAdd(Employee toAdd) { this.toAdd = toAdd; }
	public void setToRemove(String toRemove) { this.toRemove = toRemove; }
	
	public void addItem(ActionEvent event) {
	    SeriesData.addEmployee(toAdd);
	    
	    // Reset the employee after adding
	    toAdd = new Employee();
	}
	
	public String removeItem() {
	    // Check if we have a valid item index to remove
	    if (!FacesUtils.isBlank(toRemove)) {
	        // Attempt to remove the item
	        SeriesData.removeEmployee(Integer.parseInt(toRemove));
	        
	        // If we have no items left then restore the original list
	        if (SeriesData.empty()) {
	            SeriesData.defaultEmployees();
	        }
	    }
	    
	    return null;
	}
	
	public void restoreDefault(ActionEvent event) {
	    SeriesData.defaultEmployees();
	}
}
