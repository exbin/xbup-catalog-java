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
package org.exbin.xbup.web.xbcatalogweb.manager;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.exbin.xbup.catalog.entity.XBENode;
import org.exbin.xbup.catalog.entity.XBEXName;
import org.exbin.xbup.catalog.entity.XBEXStri;
import org.exbin.xbup.catalog.entity.manager.XBENodeManager;
import org.exbin.xbup.catalog.entity.manager.XBEXLangManager;
import org.exbin.xbup.web.xbcatalogweb.base.XBCPackageRecord;
import org.exbin.xbup.web.xbcatalogweb.base.manager.XBCPackageRecordManager;
import org.exbin.xbup.web.xbcatalogweb.entity.XBEPackageRecord;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * XBUP catalog XBEPackageRecord manager.
 *
 * @version 0.2.0 2017/01/13
 * @author ExBin Project (http://exbin.org)
 */
@Repository
public class XBEPackageRecordManager implements XBCPackageRecordManager {

    @PersistenceContext
    protected EntityManager em;
    @Autowired
    private XBEXLangManager langManager;
    @Autowired
    private XBENodeManager nodeManager;

    public XBEPackageRecordManager() {
        super();
    }

    @Override
    public XBCPackageRecord createItem() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void persistItem(XBCPackageRecord t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeItem(XBCPackageRecord t) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Optional<XBCPackageRecord> getItem(long itemId) {
        long languageId = langManager.getDefaultLang().getId();
        String queryString = "SELECT node, name, stri FROM XBNode node"
                + " LEFT JOIN XBXName name ON name.item = node AND name.lang.id = " + languageId
                + " LEFT JOIN XBXStri stri ON stri.item = node WHERE node.id = " + itemId;
        Query query = em.createQuery(queryString);
        Object row = query.getSingleResult();
        XBEPackageRecord packageRecord = new XBEPackageRecord();
        packageRecord.setNode((XBENode) ((Object[]) row)[0]);
        packageRecord.setName((XBEXName) ((Object[]) row)[1]);
        packageRecord.setStri((XBEXStri) ((Object[]) row)[2]);

        return Optional.of(packageRecord);
    }

    @Override
    public List<XBCPackageRecord> getAllItems() {
        long languageId = langManager.getDefaultLang().getId();
        String queryString = "SELECT node, name, stri FROM XBNode node"
                + " LEFT JOIN XBXName name ON name.item = node AND name.lang.id = " + languageId
                + " LEFT JOIN XBXStri stri ON stri.item = node ORDER BY node.id";
        Query query = em.createQuery(queryString);
        List<XBCPackageRecord> results = new ArrayList<>();
        for (Object row : query.getResultList()) {
            XBEPackageRecord packageRecord = new XBEPackageRecord();
            packageRecord.setNode((XBENode) ((Object[]) row)[0]);
            packageRecord.setName((XBEXName) ((Object[]) row)[1]);
            packageRecord.setStri((XBEXStri) ((Object[]) row)[2]);
            results.add(packageRecord);
        }

        return results;
    }

    @Override
    public long getItemsCount() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public int findAllPagedCount(String filterCondition) {
        long languageId = langManager.getDefaultLang().getId();
        String filterPrefix = "";
        String filterPostfix = "";
        if (filterCondition != null) {
            if (filterCondition.contains("name.")) {
                filterPrefix += "XBXName name";
                filterPostfix += " AND name.item = node AND name.lang.id = " + languageId;
            }
            if (filterCondition.contains("stri.")) {
                if (!filterPrefix.isEmpty()) {
                    filterPrefix += ", ";
                }
                filterPrefix += "XBXStri stri";
                filterPostfix += " AND stri.item = node";
            }
            if (!filterPrefix.isEmpty()) {
                filterPrefix = "EXISTS(SELECT 1 FROM " + filterPrefix
                        + " WHERE ";
                filterPostfix += ")";
            }
        }

        Query query = em.createQuery(
                "SELECT COUNT(node) from XBNode node"
                + (filterCondition == null
                || filterCondition.isEmpty() ? ""
                : " WHERE ")
                + filterPrefix
                + filterCondition
                + filterPostfix
        );
        return ((Long) query.getSingleResult()).intValue();
    }

    @Override
    public List<XBCPackageRecord> findAllPaged(int startFrom, int maxResults, String filterCondition, String orderCondition) {
        long languageId = langManager.getDefaultLang().getId();
        if (orderCondition == null) {
            orderCondition = "node.id";
        }

        Query query = em.createQuery(
                "SELECT node, name, stri FROM XBNode node"
                + " LEFT JOIN XBXName name ON name.item = node AND name.lang.id = " + languageId
                + " LEFT JOIN XBXStri stri ON stri.item = node"
                + (filterCondition == null
                || filterCondition.isEmpty() ? ""
                : " WHERE "
                + filterCondition)
                + " ORDER BY " + orderCondition);
        query.setFirstResult(startFrom);
        query.setMaxResults(maxResults);

        List<XBCPackageRecord> results = new ArrayList<>();
        for (Object row : query.getResultList()) {
            XBEPackageRecord packageRecord = new XBEPackageRecord();
            packageRecord.setNode((XBENode) ((Object[]) row)[0]);
            packageRecord.setName((XBEXName) ((Object[]) row)[1]);
            packageRecord.setStri((XBEXStri) ((Object[]) row)[2]);
            results.add(packageRecord);
        }

        return results;
    }

    @Override
    public List<XBCPackageRecord> findFullTree() {
        List<XBCPackageRecord> resultList = new ArrayList<>();
        List<List<XBCPackageRecord>> parentLists = new ArrayList<>();
        List<XBCPackageRecord> rootList = new LinkedList<>();
        XBEPackageRecord root = (XBEPackageRecord) getItem(nodeManager.getMainRootNode().getId()).get();
        root.setHasChildren(true);

        rootList.add(root);
        parentLists.add(rootList);

        while (parentLists.size() > 0) {
            if (parentLists.get(parentLists.size() - 1).size() > 0) {
                XBEPackageRecord parentPackage = (XBEPackageRecord) parentLists.get(parentLists.size() - 1).get(0);
                resultList.add(parentPackage);
                parentLists.get(parentLists.size() - 1).remove(0);
                if (parentPackage.isHasChildren()) {
                    List<XBCPackageRecord> childPackages = childPackages(parentPackage, parentLists.size() > 1 ? parentPackage.getFullName() : "");
                    if (childPackages != null && childPackages.size() > 0) {
                        parentLists.add(childPackages);
                    }
                }
            } else {
                parentLists.remove(parentLists.size() - 1);
            }
        }

        return resultList;
    }

    @Override
    public List<XBCPackageRecord> childPackages(XBCPackageRecord parentPackage, String prefix) {
        long languageId = langManager.getDefaultLang().getId();

        Query query = em.createQuery(
                "SELECT node, name, stri, (CASE WHEN EXISTS(SELECT 1 FROM XBNode sub WHERE sub.parent = node) THEN 1 ELSE 0 END) FROM XBNode node"
                + " LEFT JOIN XBXName name ON name.item = node AND name.lang.id = " + languageId
                + " LEFT JOIN XBXStri stri ON stri.item = node"
                + " WHERE node.parent.id = " + parentPackage.getId()
                + " ORDER BY name.text, node.id");

        List<XBCPackageRecord> results = new ArrayList<>();
        for (Object row : query.getResultList()) {
            XBEPackageRecord packageRecord = new XBEPackageRecord();
            packageRecord.setNode((XBENode) ((Object[]) row)[0]);
            packageRecord.setName((XBEXName) ((Object[]) row)[1]);
            packageRecord.setStri((XBEXStri) ((Object[]) row)[2]);
            packageRecord.setHasChildren((Long) ((Object[]) row)[3] == 1);
            packageRecord.setPrefix(prefix);
            results.add(packageRecord);
        }

        return results;
    }
}
