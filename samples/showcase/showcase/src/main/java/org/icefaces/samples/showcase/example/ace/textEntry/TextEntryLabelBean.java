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

package org.icefaces.samples.showcase.example.ace.textEntry;

import org.icefaces.samples.showcase.metadata.annotation.*;
import org.icefaces.samples.showcase.metadata.context.ComponentExampleImpl;

import javax.annotation.PostConstruct;
import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;
import java.io.Serializable;

@ComponentExample(
        parent = TextEntryBean.BEAN_NAME,
        title = "example.ace.textEntry.label.title",
        description = "example.ace.textEntry.label.description",
        example = "/resources/examples/ace/textEntry/textEntryLabel.xhtml"
)
@ExampleResources(
        resources ={
            // xhtml
            @ExampleResource(type = ResourceType.xhtml,
                    title="textEntryLabel.xhtml",
                    resource = "/resources/examples/ace/textEntry/textEntryLabel.xhtml"),
            // Java Source
            @ExampleResource(type = ResourceType.java,
                    title="TextEntryLabelBean.java",
                    resource = "/WEB-INF/classes/org/icefaces/samples/showcase"+
                    "/example/ace/textEntry/TextEntryLabelBean.java")
        }
)
@ManagedBean(name= TextEntryLabelBean.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class TextEntryLabelBean extends ComponentExampleImpl<TextEntryLabelBean> implements Serializable
{
    public static final String BEAN_NAME = "textEntryLabelBean";
    
    private String firstLabelText = "First Name";
    private String lastLabelText = "Last Name";
    private String labelPosition = "inField";
    
    public TextEntryLabelBean() {
        super(TextEntryLabelBean.class);
    }
    
    public String getFirstLabelText() {
        return firstLabelText;
    }
    
    public String getLastLabelText() {
        return lastLabelText;
    }
    
    public String getLabelPosition() {
        return labelPosition;
    }
    
    public void setFirstLabelText(String firstLabelText) {
        this.firstLabelText = firstLabelText;
    }
    
    public void setLastLabelText(String lastLabelText) {
        this.lastLabelText = lastLabelText;
    }
    
    public void setLabelPosition(String labelPosition) {
        this.labelPosition = labelPosition;
    }

    @PostConstruct
    public void initMetaData() {
        super.initMetaData();
    }
}
