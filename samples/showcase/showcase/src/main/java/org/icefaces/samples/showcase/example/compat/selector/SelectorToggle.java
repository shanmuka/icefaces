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

package org.icefaces.samples.showcase.example.compat.selector;

import java.io.Serializable;

import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;

import org.icefaces.samples.showcase.metadata.annotation.ComponentExample;
import org.icefaces.samples.showcase.metadata.annotation.ExampleResource;
import org.icefaces.samples.showcase.metadata.annotation.ExampleResources;
import org.icefaces.samples.showcase.metadata.annotation.ResourceType;
import org.icefaces.samples.showcase.metadata.context.ComponentExampleImpl;

@ComponentExample(
        parent = SelectorBean.BEAN_NAME,
        title = "example.compat.selector.toggle.title",
        description = "example.compat.selector.toggle.description",
        example = "/resources/examples/compat/selector/selectorToggle.xhtml"
)
@ExampleResources(
        resources ={
            // xhtml
            @ExampleResource(type = ResourceType.xhtml,
                    title="selectorToggle.xhtml",
                    resource = "/resources/examples/compat/"+
                               "selector/selectorToggle.xhtml"),
            // Java Source
            @ExampleResource(type = ResourceType.java,
                    title="SelectorToggle.java",
                    resource = "/WEB-INF/classes/org/icefaces/samples/"+
                               "showcase/example/compat/selector/SelectorToggle.java")
        }
)
@ManagedBean(name= SelectorToggle.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class SelectorToggle extends ComponentExampleImpl<SelectorToggle> implements Serializable {
	
    public static final String BEAN_NAME = "selectorToggle";

    private boolean enable = false;

    public SelectorToggle() {
            super(SelectorToggle.class);
    }

    public boolean getEnable() { return enable; }

    public void setEnable(boolean enable) { this.enable = enable; }
}
