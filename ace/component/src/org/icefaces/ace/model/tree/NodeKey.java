package org.icefaces.ace.model.tree;

import org.icefaces.ace.util.ArrayUtils;

import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;
import java.io.Serializable;
import java.util.Arrays;

/**
 * Created with IntelliJ IDEA.
 * User: Nils
 * Date: 8/15/12
 * Time: 9:15 PM
 * To change this template use File | Settings | File Templates.
 */
public class NodeKey implements Serializable {
    public static final NodeKey ROOT_KEY = new NodeKey();

    private Object[] keys;

    public NodeKey() {}

    public NodeKey(Object... keys) {
        this.keys = keys;
    }

    public Object[] getKeys() {
        return keys;
    }

    public void setKeys(Object[] keys) {
        this.keys = keys;
    }

    public NodeKey append(Object[] segments) {
        return new NodeKey((Object[])ArrayUtils.concat(keys, segments));
    }

    public NodeKey append(final Object segment) {
        return append(new Object[] {segment});
    }

    public NodeKey getParent() {
        if (keys.length == 0) return null;

        Object[] parentKeys = new Object[keys.length - 1];
        System.arraycopy(keys, 0, parentKeys, 0, parentKeys.length);
        if (parentKeys.length == 0) parentKeys = null;
        return new NodeKey(parentKeys);
    }

    @Override
    public int hashCode() {
        final int prime = 71;
        int hash = 1;
        hash = prime * hash + Arrays.hashCode(keys);
        return hash;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null) {
            return false;
        }
        if (getClass() != o.getClass()) {
            return false;
        }

        NodeKey other = (NodeKey) o;
        return (keys == null && other.getKeys() == null);
    }

    @Override
    public String toString() {
        if (keys != null)
            return join(keys,
                    UINamingContainer.getSeparatorChar(
                            FacesContext.getCurrentInstance()));
        return "";
    }

    private String join(Object[] objects, char sep) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < objects.length; i++) {
            b.append(objects[i].toString());
            if (i != (objects.length - 1)) b.append(sep);
        }
        return b.toString();
    }
}
