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
import org.exbin.xbup.catalog.entity.XBEBlockCons;
import org.exbin.xbup.catalog.entity.XBEBlockJoin;
import org.exbin.xbup.catalog.entity.XBEBlockRev;
import org.exbin.xbup.catalog.entity.XBEBlockSpec;
import org.exbin.xbup.catalog.entity.XBEFormatCons;
import org.exbin.xbup.catalog.entity.XBEFormatJoin;
import org.exbin.xbup.catalog.entity.XBEFormatRev;
import org.exbin.xbup.catalog.entity.XBEFormatSpec;
import org.exbin.xbup.catalog.entity.XBEGroupCons;
import org.exbin.xbup.catalog.entity.XBEGroupJoin;
import org.exbin.xbup.catalog.entity.XBEGroupRev;
import org.exbin.xbup.catalog.entity.XBEGroupSpec;
import org.exbin.xbup.catalog.entity.XBEItem;
import org.exbin.xbup.catalog.entity.XBENode;
import org.exbin.xbup.catalog.entity.XBESpecDef;
import org.exbin.xbup.catalog.entity.XBEXDesc;
import org.exbin.xbup.catalog.entity.XBEXName;
import org.exbin.xbup.catalog.entity.XBEXStri;
import org.exbin.xbup.web.xbcatalogweb.modifiable.XBMItemRecord;

/**
 * Item record entity.
 *
 * @version 0.2.1 2020/08/24
 * @author ExBin Project (http://exbin.org)
 */
public class XBEItemRecord implements  Serializable, XBMItemRecord {

    private XBEItem item;
    private XBEXStri stri;
    private XBEXName name;
    private XBEXDesc desc;

    @Override
    public String getItemType() {
        if (item instanceof XBENode) {
            return "Node";
        }

        if (item instanceof XBEBlockSpec) {
            return "Block Specification";
        }

        if (item instanceof XBEGroupSpec) {
            return "Group Specification";
        }

        if (item instanceof XBEFormatSpec) {
            return "Format Specification";
        }

        if (item instanceof XBEBlockRev) {
            return "Block Revision";
        }

        if (item instanceof XBEGroupRev) {
            return "Group Revision";
        }

        if (item instanceof XBEFormatRev) {
            return "Format Revision";
        }

        if (item instanceof XBESpecDef) {
            return "SpecDef";
        }

        if (item instanceof XBEBlockJoin) {
            return "Block Join";
        }

        if (item instanceof XBEBlockCons) {
            return "Block Consist";
        }

        if (item instanceof XBEGroupJoin) {
            return "Group Join";
        }

        if (item instanceof XBEGroupCons) {
            return "Group Consist";
        }

        if (item instanceof XBEFormatJoin) {
            return "Format Join";
        }

        if (item instanceof XBEFormatCons) {
            return "Format Consist";
        }

        return "Item";
    }

    @Override
    public String getNameOrId() {
        if (name == null || name.getText() == null) {
            return "[" + getId() + "]";
        }

        return name.getText();
    }

    @Override
    public long getId() {
        if (item == null) {
            return 0;
        }
        return item.getId();
    }

    @Override
    public XBEItem getItem() {
        return item;
    }

    @Override
    public void setItem(XBEItem item) {
        this.item = item;
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
}
