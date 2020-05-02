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
package org.exbin.xbup.web.xbcatalogweb.base.service;

import java.io.Serializable;
import java.util.List;
import org.exbin.xbup.catalog.entity.XBEXHDoc;
import org.exbin.xbup.core.catalog.base.service.XBCService;
import org.exbin.xbup.web.xbcatalogweb.base.XBCFullItemRecord;
import org.exbin.xbup.web.xbcatalogweb.base.XBCItemRecord;
import org.exbin.xbup.web.xbcatalogweb.entity.XBEItemRecord;

/**
 * XBEItemRecord service interface.
 *
 * @version 0.1.24 2015/01/16
 * @author ExBin Project (http://exbin.org)
 */
public interface XBCItemRecordService extends XBCService<XBCItemRecord>, Serializable {

    List<XBCItemRecord> findAllByParent(Long selectedPackageId);

    List<XBCItemRecord> findAllPaged(int startFrom, int maxResults, String filterCondition, String orderCondition);

    int findAllPagedCount(String filterCondition);

    XBCFullItemRecord findForEditById(Long selectedItemId);

    XBCFullItemRecord createForEdit();

    public XBEXHDoc getItemDoc(XBEItemRecord selectedItem);

    public Long[] stringToPath(String path);

    public XBCFullItemRecord findNodeByPath(Long[] path);

    public XBCFullItemRecord findFormatSpecByPath(Long[] path);

    public XBCFullItemRecord findGroupSpecByPath(Long[] path);

    public XBCFullItemRecord findBlockSpecByPath(Long[] path);
}
