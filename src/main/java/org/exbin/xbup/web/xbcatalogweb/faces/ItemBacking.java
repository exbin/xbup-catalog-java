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
package org.exbin.xbup.web.xbcatalogweb.faces;

import java.io.Serializable;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import org.exbin.xbup.web.xbcatalogweb.base.XBCFullItemRecord;
import org.exbin.xbup.web.xbcatalogweb.base.service.XBCItemRecordService;
import org.exbin.xbup.web.xbcatalogweb.entity.XBEFullItemRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Browse controller.
 *
 * @version 0.1.24 2015/01/16
 * @author ExBin Project (http://exbin.org)
 */
@Controller
@Scope("view")
@Qualifier("itemBacking")
public final class ItemBacking implements Serializable {

    @Autowired
    private XBCItemRecordService itemService;

    private XBEFullItemRecord selectedItem;

    public ItemBacking() {
    }

    @PostConstruct
    public void init() {
        Map<String, String> requestParam = FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap();
        String node = requestParam.get("node");
        if (node != null) {
            setNode(node);
            return;
        }

        String format = requestParam.get("format");
        if (format != null && !format.isEmpty()) {
            setFormat(format);
            return;
        }

        String group = requestParam.get("group");
        if (group != null && !group.isEmpty()) {
            setGroup(group);
            return;
        }

        String block = requestParam.get("block");
        if (block != null && !block.isEmpty()) {
            setBlock(block);
        }
    }

    public void selectItem(Long selectedItemId) {
        selectedItem = (XBEFullItemRecord) itemService.findForEditById(selectedItemId);
    }

    public void setNode(String path) {
        selectedItem = (XBEFullItemRecord) itemService.findNodeByPath(itemService.stringToPath(path));
    }

    public void setFormat(String path) {
        selectedItem = (XBEFullItemRecord) itemService.findFormatSpecByPath(itemService.stringToPath(path));
    }

    public void setGroup(String path) {
        selectedItem = (XBEFullItemRecord) itemService.findGroupSpecByPath(itemService.stringToPath(path));
    }

    public void setBlock(String path) {
        selectedItem = (XBEFullItemRecord) itemService.findBlockSpecByPath(itemService.stringToPath(path));
    }

    public XBCFullItemRecord getSelectedItem() {
        return selectedItem;
    }
}
