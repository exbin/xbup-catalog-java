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
import org.exbin.xbup.web.xbcatalogweb.base.XBCFullItemRecord;
import org.exbin.xbup.web.xbcatalogweb.base.service.XBCItemRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

/**
 * Item edit controller.
 *
 * @version 0.1.23 2014/04/20
 * @author ExBin Project (http://exbin.org)
 */
@Controller
@Scope("view")
@Qualifier("itemEditBacking")
public final class ItemEditBacking implements Serializable {

    @Autowired
    private XBCItemRecordService itemRecordService;

    private XBCFullItemRecord editedItem;
    private Long editedItemId;
    private Boolean lastActionSuccess = false;

    public ItemEditBacking() {
    }

    @PostConstruct
    public void init() {
    }

    public void save() {
        lastActionSuccess = false;
        itemRecordService.persistItem(editedItem);
        lastActionSuccess = true;
    }

    public void editItem() {
        editedItem = itemRecordService.findForEditById(editedItemId);
    }

    public void createItem() {
        editedItem = itemRecordService.createForEdit();
    }

    public XBCFullItemRecord getEditedItem() {
        return editedItem;
    }

    public Boolean getLastActionSuccess() {
        return lastActionSuccess;
    }

    public Long getEditedItemId() {
        return editedItemId;
    }

    public void setEditedItemId(Long editedItemId) {
        this.editedItemId = editedItemId;
    }
}
