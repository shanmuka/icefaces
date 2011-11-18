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

package org.icefaces.samples.showcase.example.compat.calendar;

import java.io.Serializable;
import java.util.Date;
import java.util.TimeZone;

import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.event.ActionEvent;
import javax.faces.event.ValueChangeEvent;

import org.icefaces.samples.showcase.view.navigation.NavigationController;
import org.icefaces.samples.showcase.metadata.annotation.ComponentExample;
import org.icefaces.samples.showcase.metadata.annotation.ExampleResource;
import org.icefaces.samples.showcase.metadata.annotation.ExampleResources;
import org.icefaces.samples.showcase.metadata.annotation.Menu;
import org.icefaces.samples.showcase.metadata.annotation.MenuLink;
import org.icefaces.samples.showcase.metadata.annotation.ResourceType;
import org.icefaces.samples.showcase.metadata.context.ComponentExampleImpl;

@ComponentExample(
        parent = CalendarBean.BEAN_NAME,
        title = "example.compat.calendar.timezone.title",
        description = "example.compat.calendar.timezone.description",
        example = "/resources/examples/compat/calendar/timezone.xhtml"
)
@ExampleResources(
        resources ={
            // xhtml
            @ExampleResource(type = ResourceType.xhtml,
                    title="timezone.xhtml",
                    resource = "/resources/examples/compat/"+
                               "calendar/timezone.xhtml"),
            // Java Source
            @ExampleResource(type = ResourceType.java,
                    title="CalendarTimezoneBean.java",
                    resource = "/WEB-INF/classes/org/icefaces/samples/"+
                               "showcase/example/compat/calendar/CalendarTimezoneBean.java")
        }
)
@ManagedBean(name= CalendarTimezoneBean.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class CalendarTimezoneBean extends ComponentExampleImpl<CalendarTimezoneBean> implements Serializable {
	
	public static final String BEAN_NAME = "calendarTimezone";
	
	private Date date = CalendarBean.getDefaultDate();
	private boolean hasChanged = false;
	private String pattern = CalendarBean.DEFAULT_PATTERN + " hh:mm z";
	private TimeZone timezoneObject;
	private String timezoneId;
	private String[] availableZones = TimeZone.getAvailableIDs();

	public CalendarTimezoneBean() {
		super(CalendarTimezoneBean.class);
	}
	
	public Date getDate() { return date; }
	public String getPattern() { return pattern; }
	public TimeZone getTimezoneObject() {
	    if (timezoneObject == null) {
	        if (timezoneId == null) {
	            timezoneObject = TimeZone.getDefault();
	        }
	        else {
	            timezoneObject = TimeZone.getTimeZone(timezoneId);
	        }
	    }
	    return timezoneObject;
	}
	public String getTimezoneId() {
	    if (timezoneId == null) {
	        timezoneId = getTimezoneObject().getID();
	    }
	    return timezoneId;
	}
	public String[] getAvailableZones() { return availableZones; }
	
	public void setDate(Date date) { this.date = date; }
	public void setTimezoneObject(TimeZone timezoneObject) { this.timezoneObject = timezoneObject; }
	public void setTimezoneId(String timezoneId) { this.timezoneId = timezoneId; }
	
	/**
	 * Method called when the timezone changed, which will cause the
	 *  date to be regenerated when the user applies their changes
	 */
	public void timezoneChanged(ValueChangeEvent event) {
	    hasChanged = true;
	}
	
	/**
	 * Method called when the user wants to apply the changes
	 * This may involve getting a new date object if the timezone changed
	 * Also we have to refresh the page to apply this new timezone
	 */
	public void applyChanges(ActionEvent event) {
	    if (hasChanged) {
	        date = CalendarBean.getDefaultDate(TimeZone.getTimeZone(timezoneId));
	    }
	    hasChanged = false;
	    
	    // Reset the object so it will be re-read based on the current timezone ID
	    timezoneObject = null;
	    
	    NavigationController.refreshPage();
	}
}
