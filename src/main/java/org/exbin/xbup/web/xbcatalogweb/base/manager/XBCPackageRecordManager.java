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
package org.exbin.xbup.web.xbcatalogweb.base.manager;

import java.io.Serializable;
import java.util.List;
import org.exbin.xbup.core.catalog.base.manager.XBCManager;
import org.exbin.xbup.web.xbcatalogweb.base.XBCPackageRecord;

/**
 * XBUP catalog XBEPackageRecord manager.
 *
 * @version 0.1.23 2014/05/23
 * @author ExBin Project (http://exbin.org)
 */
public interface XBCPackageRecordManager extends XBCManager<XBCPackageRecord>, Serializable {

    List<XBCPackageRecord> childPackages(XBCPackageRecord parentPackage, String prefix);

    List<XBCPackageRecord> findAllPaged(int startFrom, int maxResults, String filterCondition, String orderCondition);

    int findAllPagedCount(String filterCondition);

    List<XBCPackageRecord> findFullTree();

}
