/*
 * Copyright (c) 2017 Cody Engel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.codyengel.simplenetworking.ui.list;

import com.codyengel.flax.FlaxRenderer;
import com.codyengel.simplenetworking.ui.UserModel;

import java.util.List;

/**
 * @author cody
 */
class ListRenderer extends FlaxRenderer<ListModel, ListView> {

    private int usersAdded = 0;

    ListRenderer(ListView listView) {
        super(listView);
    }

    @Override
    protected void modelUpdated(ListModel updatedModel) {
        insertNewUsers(updatedModel.getUsers());
        navigateToUserProfile(updatedModel.getSelectedUser());
    }

    private void navigateToUserProfile(UserModel userModel) {
        if (userModel != null) {
            getView().navigateToUserProfile(userModel.hashCode());
        }
    }

    private void insertNewUsers(List<UserModel> userModels) {
        int newListSize = userModels.size();
        for (; usersAdded < newListSize; usersAdded++) {
            getView().addUser(userModels.get(usersAdded));
        }
        getView().scrollToPosition(usersAdded - 1);
    }

}
