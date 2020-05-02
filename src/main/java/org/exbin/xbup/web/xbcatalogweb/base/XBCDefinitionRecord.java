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
package org.exbin.xbup.web.xbcatalogweb.base;

/**
 * Full item record entity interface.
 *
 * @version 0.1.24 2014/11/11
 * @author ExBin Project (http://exbin.org)
 */
public interface XBCDefinitionRecord {

    Integer getXbIndex();

    String getStringId();

    String getName();

    void setXBIndex(Integer xbIndex);

    void setStringId(String stringId);

    void setName(String itemName);

}
