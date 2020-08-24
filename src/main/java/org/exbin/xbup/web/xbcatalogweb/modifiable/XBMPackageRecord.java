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
package org.exbin.xbup.web.xbcatalogweb.modifiable;

import org.exbin.xbup.web.xbcatalogweb.base.*;
import org.exbin.xbup.catalog.entity.XBENode;
import org.exbin.xbup.catalog.entity.XBEXDesc;
import org.exbin.xbup.catalog.entity.XBEXName;
import org.exbin.xbup.catalog.entity.XBEXStri;
import org.exbin.xbup.catalog.modifiable.XBMBase;

/**
 * Package record entity interface.
 *
 * @version 0.2.1 2020/08/24
 * @author ExBin Project (http://exbin.org)
 */
public interface XBMPackageRecord extends XBMBase, XBCPackageRecord {

    void setDesc(XBEXDesc desc);

    void setHasChildren(boolean hasChildren);

    void setName(XBEXName name);

    void setNode(XBENode node);

    void setPrefix(String prefix);

    void setStri(XBEXStri stri);
}
