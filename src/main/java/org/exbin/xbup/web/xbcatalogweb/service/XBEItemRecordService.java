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
package org.exbin.xbup.web.xbcatalogweb.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.exbin.xbup.catalog.entity.XBEXHDoc;
import org.exbin.xbup.web.xbcatalogweb.base.XBCFullItemRecord;
import org.exbin.xbup.web.xbcatalogweb.base.XBCItemRecord;
import org.exbin.xbup.web.xbcatalogweb.base.manager.XBCItemRecordManager;
import org.exbin.xbup.web.xbcatalogweb.base.service.XBCItemRecordService;
import org.exbin.xbup.web.xbcatalogweb.entity.XBEItemRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * XBEItemRecord service.
 *
 * @version 0.1.24 2015/01/16
 * @author ExBin Project (http://exbin.org)
 */
@Service
public class XBEItemRecordService implements XBCItemRecordService {

    @Autowired
    private XBCItemRecordManager manager;

    public XBEItemRecordService() {
        super();
    }

    @Override
    public XBCItemRecord createItem() {
        return manager.createItem();
    }

    @Override
    public void persistItem(XBCItemRecord item) {
        manager.persistItem(item);
    }

    @Override
    public void removeItem(XBCItemRecord item) {
        manager.removeItem(item);
    }

    @Override
    public Optional<XBCItemRecord> getItem(long itemId) {
        return manager.getItem(itemId);
    }

    @Override
    public List<XBCItemRecord> getAllItems() {
        return manager.getAllItems();
    }

    @Override
    public long getItemsCount() {
        return manager.getItemsCount();
    }

    @Override
    public int findAllPagedCount(String filterCondition) {
        return manager.findAllPagedCount(filterCondition);
    }

    @Override
    public List<XBCItemRecord> findAllPaged(int startFrom, int maxResults, String filterCondition, String orderCondition) {
        return manager.findAllPaged(startFrom, maxResults, filterCondition, orderCondition);
    }

    @Override
    public XBCFullItemRecord findForEditById(Long selectedItemId) {
        return manager.findForEditById(selectedItemId);
    }

    public XBCFullItemRecord createForEdit() {
        return manager.createForEdit();
    }

    @Override
    public List<XBCItemRecord> findAllByParent(Long selectedPackageId) {
        return manager.findAllByParent(selectedPackageId);
    }

    @Override
    public XBEXHDoc getItemDoc(XBEItemRecord selectedItem) {
        return manager.getItemDoc(selectedItem);
    }

    public Long[] stringToPath(String path) {
        List<Long> pathList = new ArrayList<Long>();
        int pos = 0;
        while (pos < path.length()) {
            int nextPos = path.indexOf("/", pos);
            if (nextPos < 0) {
                nextPos = path.length();
            }
            pathList.add(Long.valueOf(path.substring(pos, nextPos)));
            pos = nextPos + 1;
        }
        return pathList.toArray(new Long[0]);
    }

    public XBCFullItemRecord findNodeByPath(Long[] path) {
        return manager.findNodeByPath(path);
    }

    public XBCFullItemRecord findFormatSpecByPath(Long[] path) {
        return manager.findFormatSpecByPath(path);
    }

    public XBCFullItemRecord findGroupSpecByPath(Long[] path) {
        return manager.findGroupSpecByPath(path);
    }

    public XBCFullItemRecord findBlockSpecByPath(Long[] path) {
        return manager.findBlockSpecByPath(path);
    }
}
