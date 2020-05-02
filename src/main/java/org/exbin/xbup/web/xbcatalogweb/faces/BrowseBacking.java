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
import java.util.List;
import javax.annotation.PostConstruct;
import org.exbin.xbup.web.xbcatalogweb.base.XBCItemRecord;
import org.exbin.xbup.web.xbcatalogweb.base.XBCPackageRecord;
import org.exbin.xbup.web.xbcatalogweb.base.service.XBCItemRecordService;
import org.exbin.xbup.web.xbcatalogweb.base.service.XBCPackageRecordService;
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
@Qualifier("browseBacking")
public final class BrowseBacking implements Serializable {

    @Autowired
    private XBCPackageRecordService packageService;
    @Autowired
    private XBCItemRecordService itemService;
    @Autowired
    private ItemBacking itemBacking;

    private Long selectedPackageId;
    private XBCPackageRecord selectedPackage;
    private Long selectedItemId;

    private List<XBCPackageRecord> packages;
    private List<XBCItemRecord> items;

    public BrowseBacking() {
        /* nodes = new ArrayList<XBENode>();
         XBENode node = new XBENode();
         node.setId(new Long(1));
         nodes.add(node); */
    }

    @PostConstruct
    public void init() {
        selectedPackageId = null;
        packages = packageService.findFullTree();
        items = itemService.findAllByParent(null);
    }

    public void selectPackage() {
        loadItems();
    }

    public void selectItem() {
        itemBacking.selectItem(selectedItemId);
    }

    public void loadItems() {
        selectedPackage = packageService.getItem(selectedPackageId);
        items = itemService.findAllByParent(selectedPackageId);
    }

    public List<XBCPackageRecord> getPackages() {
        return packages;
    }

    public List<XBCItemRecord> getItems() {
        return items;
    }

    public Long getSelectedPackageId() {
        return selectedPackageId;
    }

    public void setSelectedPackageId(Long selectedPackageId) {
        this.selectedPackageId = selectedPackageId;
    }

    public Long getSelectedItemId() {
        return selectedItemId;
    }

    public void setSelectedItemId(Long selectedItemId) {
        this.selectedItemId = selectedItemId;
    }

    public XBCPackageRecord getSelectedPackage() {
        return selectedPackage;
    }
}
