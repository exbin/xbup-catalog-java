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
import org.exbin.xbup.catalog.entity.XBEXUser;
import org.exbin.xbup.web.xbcatalogweb.base.XBCUserRecord;
import org.exbin.xbup.web.xbcatalogweb.base.manager.XBCUserRecordManager;
import org.exbin.xbup.web.xbcatalogweb.base.service.XBCUserRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * XBEUserRecord service.
 *
 * @version 0.1.23 2014/04/12
 * @author ExBin Project (http://exbin.org)
 */
@Service
public class XBEUserRecordService implements XBCUserRecordService {

    @Autowired
    private XBCUserRecordManager manager;

    public XBEUserRecordService() {
        super();
    }

    @Override
    public XBCUserRecord createItem() {
        return manager.createItem();
    }

    @Override
    public void persistItem(XBCUserRecord item) {
        manager.persistItem(item);
    }

    @Override
    public void removeItem(XBCUserRecord item) {
        manager.removeItem(item);
    }

    @Override
    public Optional<XBCUserRecord> getItem(long itemId) {
        return manager.getItem(itemId);
    }

    @Override
    public List<XBCUserRecord> getAllItems() {
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
    public List<XBCUserRecord> findAllPaged(int startFrom, int maxResults, String filterCondition, String orderCondition) {
        return manager.findAllPaged(startFrom, maxResults, filterCondition, orderCondition);
    }

    @Override
    public void persistUser(XBEXUser user) {
        manager.persistUser(user);
    }
}
