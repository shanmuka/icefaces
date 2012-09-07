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

package org.icefaces.samples.showcase.example.ace.file;

import java.io.Serializable;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.CustomScoped;
import javax.faces.bean.ManagedBean;

import org.icefaces.ace.component.fileentry.FileEntryCallback;
import org.icefaces.ace.component.fileentry.FileEntryResults;
import org.icefaces.ace.component.fileentry.FileEntryStatuses;
import org.icefaces.samples.showcase.metadata.annotation.ComponentExample;
import org.icefaces.samples.showcase.metadata.annotation.ExampleResource;
import org.icefaces.samples.showcase.metadata.annotation.ExampleResources;
import org.icefaces.samples.showcase.metadata.annotation.ResourceType;
import org.icefaces.samples.showcase.metadata.context.ComponentExampleImpl;

@ComponentExample(parent = FileEntryBean.BEAN_NAME, title = "example.ace.fileentry.callback.title", description = "example.ace.fileentry.callback.description", example = "/resources/examples/ace/fileentry/fileEntryCallback.xhtml")
@ExampleResources(resources = {
// xhtml
		@ExampleResource(type = ResourceType.xhtml, title = "fileEntryCallback.xhtml", resource = "/resources/examples/ace/"
				+ "fileentry/fileEntryCallback.xhtml"),
		// Java Source
		@ExampleResource(type = ResourceType.java, title = "FileEntryCallbackBean.java", resource = "/WEB-INF/classes/org/icefaces/samples/"
				+ "showcase/example/ace/file/FileEntryCallbackBean.java") })
@ManagedBean(name = FileEntryCallbackBean.BEAN_NAME)
@CustomScoped(value = "#{window}")
public class FileEntryCallbackBean extends
		ComponentExampleImpl<FileEntryCallbackBean> implements
		FileEntryCallback, Serializable {
	public static final String BEAN_NAME = "fileEntryCallback";
	private static Logger logger = Logger.getLogger(FileEntryCallbackBean.class
			.getName());

	public FileEntryCallbackBean() {
		super(FileEntryCallbackBean.class);
	}

	@PostConstruct
	public void initMetaData() {
		super.initMetaData();
	}

	// Executed before the upload starts
	public void begin(FileEntryResults.FileInfo fileInfo) {

	}

	public void write(int i) {

	}

	public void write(byte[] bytes, int offset, int length) {
	}

	// Executed at the end of a file upload
	public void end(FileEntryResults.FileInfo fileEntryInfo) {
		// We can fail the file here for invalid file type
		if (!fileEntryInfo.getContentType().equals("application/pdf"))
			fileEntryInfo.updateStatus(FileEntryStatuses.INVALID, false);
	}

}