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
package org.exbin.xbup.web.xbcatalogweb.entity;

import java.io.Serializable;
import org.exbin.xbup.catalog.entity.XBEXUser;
import org.exbin.xbup.catalog.entity.XBEXUserInfo;
import org.exbin.xbup.web.xbcatalogweb.modifiable.XBMUserRecord;

/**
 * User record entity.
 *
 * @version 0.2.1 2020/08/24
 * @author ExBin Project (http://exbin.org)
 */
public class XBEUserRecord implements Serializable, XBMUserRecord {

    private XBEXUser user;
    private XBEXUserInfo info;

    @Override
    public long getId() {
        if (user == null) {
            return 0;
        }
        return user.getId();
    }

    @Override
    public XBEXUser getUser() {
        return user;
    }

    @Override
    public void setUser(XBEXUser user) {
        this.user = user;
    }

    @Override
    public XBEXUserInfo getInfo() {
        return info;
    }

    @Override
    public void setInfo(XBEXUserInfo info) {
        this.info = info;
    }
}
