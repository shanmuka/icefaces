package org.icefaces.impl.application;

import org.icefaces.util.EnvUtils;

import javax.faces.application.Resource;
import javax.faces.application.ResourceHandler;
import javax.faces.application.ResourceHandlerWrapper;
import javax.faces.application.ResourceWrapper;
import javax.faces.context.FacesContext;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VersioningResourceHandler extends ResourceHandlerWrapper {

    private static Logger log = Logger.getLogger(VersioningResourceHandler.class.getName());

    private ResourceHandler wrapped;

    public VersioningResourceHandler(ResourceHandler wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public ResourceHandler getWrapped() {
        return wrapped;
    }

    @Override
    public Resource createResource(String resourceName, String libraryName, String contentType) {

        Resource rez = wrapped.createResource(resourceName, libraryName, contentType);

        //The context parameter org.icefaces.uniqueResourceURLs is used to determine whether
        //we add our versioning scheme to our resource URLs
        if(!EnvUtils.isUniqueResourceURLs(FacesContext.getCurrentInstance())){
            return rez;
        }

        //Only version the resource types that make sense
        if (!isVersionableResource(rez)) {
            if (log.isLoggable(Level.FINE)) {
                log.fine("ignoring versioning for " +
                        "\n  resource    : " + rez.getResourceName() +
                        "\n  library     : " + rez.getLibraryName() +
                        "\n  content type: " + rez.getContentType()
                );
            }
            return rez;
        }

        //At some point we may only want to version files that actually include
        //a valid library name but since some of our resources aren't in libraries yet, we
        //can't exclude them.
//        if( libraryName == null || libraryName.trim().length() == 0){
//            return rez;
//        }

        if (log.isLoggable(Level.FINE)) {
            log.fine("adding versioning for " +
                    "\n  resource    : " + resourceName +
                    "\n  library     : " + libraryName +
                    "\n  content type: " + contentType
            );
        }
        return new VersionedResource(rez);
    }

    private boolean isVersionableResource(Resource rez) {

        if( rez == null ){
            return false;
        }

        String calculatedContentType = rez.getContentType();

        if (calculatedContentType == null) {
            return false;
        }

        if (calculatedContentType.equals("text/css") ||
                calculatedContentType.equals("application/javascript")) {
            return true;
        }

        if (calculatedContentType.startsWith("image")) {
            return true;
        }

        return false;
    }
}

class VersionedResource extends ResourceWrapper {

    private Resource wrapped;

    VersionedResource(Resource wrapped) {
        this.wrapped = wrapped;

        //Not sure why this is necessary but if we don't do this, the
        //Content-Type response header may not make it back to the browser.
        setResourceName(wrapped.getResourceName());
        setLibraryName(wrapped.getLibraryName());
        setContentType(wrapped.getContentType());
    }

    @Override
    public Resource getWrapped() {
        return wrapped;
    }

    @Override
    public String getRequestPath() {
        String requestPath = wrapped.getRequestPath();

        //In the unlikely event that the path is invalid or already has a 'v' parameter
        //then don't process this any further.
        if (requestPath == null ||
                requestPath.trim().length() == 0 ||
                requestPath.indexOf("?v=") >= 0 ||
                requestPath.indexOf("&v=") >= 0) {
            return requestPath;
        }

        FacesContext fc = FacesContext.getCurrentInstance();
        if (requestPath.indexOf('?') > 0) {
            requestPath = requestPath + "&v=" + EnvUtils.getResourceVersion(fc);
        } else {
            requestPath = requestPath + "?v=" + EnvUtils.getResourceVersion(fc);
        }

        return requestPath;
    }
}
