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

import java.util.List;
import java.util.Optional;
import org.exbin.xbup.web.xbcatalogweb.base.XBCPackageRecord;
import org.exbin.xbup.web.xbcatalogweb.base.manager.XBCPackageRecordManager;
import org.exbin.xbup.web.xbcatalogweb.base.service.XBCPackageRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * XBEPackageRecord service.
 *
 * @version 0.1.23 2014/05/08
 * @author ExBin Project (http://exbin.org)
 */
@Service
public class XBEPackageRecordService implements XBCPackageRecordService {

    @Autowired
    private XBCPackageRecordManager manager;

    public XBEPackageRecordService() {
        super();
    }

    @Override
    public XBCPackageRecord createItem() {
        return manager.createItem();
    }

    @Override
    public void persistItem(XBCPackageRecord item) {
        manager.persistItem(item);
    }

    @Override
    public void removeItem(XBCPackageRecord item) {
        manager.removeItem(item);
    }

    @Override
    public Optional<XBCPackageRecord> getItem(long itemId) {
        return manager.getItem(itemId);
    }

    @Override
    public List<XBCPackageRecord> getAllItems() {
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
    public List<XBCPackageRecord> findAllPaged(int startFrom, int maxResults, String filterCondition, String orderCondition) {
        return manager.findAllPaged(startFrom, maxResults, filterCondition, orderCondition);
    }

    @Override
    public List<XBCPackageRecord> findFullTree() {
        return manager.findFullTree();
    }
}
