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
import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import org.exbin.xbup.catalog.entity.service.XBEXUserService;
import org.exbin.xbup.web.xbcatalogweb.service.XBEUserRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

/**
 * Main Website Index controller.
 *
 * @version 0.1.24 2015/01/16
 * @author ExBin Project (http://exbin.org)
 */
@Controller
@Qualifier("indexController")
public final class IndexController implements Serializable {

    @Autowired
    private XBEXUserService userService;
    @Autowired
    private XBEUserRecordService userRecordService;

    public IndexController() {
    }

    @PostConstruct
    public void init() {
    }

    public String getRedirectTarget(HttpServletRequest request) {
        String node = request.getParameter("node");
        String format = request.getParameter("format");
        String group = request.getParameter("group");
        String block = request.getParameter("block");
        if (node != null) {
            return "views/item.xhtml?node=" + node;
        }

        if (format != null && !format.isEmpty()) {
            return "views/item.xhtml?format=" + format;
        }

        if (group != null && !group.isEmpty()) {
            return "views/item.xhtml?group=" + group;
        }

        if (block != null && !block.isEmpty()) {
            return "views/item.xhtml?block=" + block;
        }

        return "views/about.xhtml";
    }

}
