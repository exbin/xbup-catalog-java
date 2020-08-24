/*
 * Copyright (C) ExBin Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.exbin.xbup.web.xbcatalogweb.entity;

import java.io.Serializable;
import org.exbin.xbup.catalog.entity.XBENode;
import org.exbin.xbup.catalog.entity.XBEXDesc;
import org.exbin.xbup.catalog.entity.XBEXName;
import org.exbin.xbup.catalog.entity.XBEXStri;
import org.exbin.xbup.web.xbcatalogweb.modifiable.XBMPackageRecord;

/**
 * Package record entity.
 *
 * @version 0.2.1 2020/08/24
 * @author ExBin Project (http://exbin.org)
 */
public class XBEPackageRecord implements  Serializable, XBMPackageRecord {

    private XBENode node;
    private XBEXStri stri;
    private XBEXName name;
    private XBEXDesc desc;
    private String prefix = "";
    private boolean hasChildren = false;

    @Override
    public String getFullName() {
        return prefix.isEmpty() ? getPackageName() : getPrefix() + "." + getPackageName();
    }

    @Override
    public String getPackageName() {
        return getName() == null ? "" : (getName().getText() == null ? "" : getName().getText());
    }

    @Override
    public long getId() {
        if (node == null) {
            return 0;
        }
        return node.getId();
    }

    @Override
    public XBENode getNode() {
        return node;
    }

    @Override
    public void setNode(XBENode node) {
        this.node = node;
    }

    @Override
    public XBEXStri getStri() {
        return stri;
    }

    @Override
    public void setStri(XBEXStri stri) {
        this.stri = stri;
    }

    @Override
    public XBEXName getName() {
        return name;
    }

    @Override
    public void setName(XBEXName name) {
        this.name = name;
    }

    @Override
    public XBEXDesc getDesc() {
        return desc;
    }

    @Override
    public void setDesc(XBEXDesc desc) {
        this.desc = desc;
    }

    @Override
    public String getPrefix() {
        return prefix;
    }

    @Override
    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public boolean isHasChildren() {
        return hasChildren;
    }

    @Override
    public void setHasChildren(boolean hasChildren) {
        this.hasChildren = hasChildren;
    }
}
