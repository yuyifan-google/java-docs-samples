/*
 * Copyright 2020 Google LLC
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

package com.example.asset;

// [START asset_quickstart_search_all_resources]
import com.google.cloud.asset.v1.AssetServiceClient;
import com.google.cloud.asset.v1.AssetServiceClient.SearchAllResourcesPagedResponse;
import com.google.cloud.asset.v1.SearchAllResourcesRequest;
import java.util.Arrays;

public class SearchAllResourcesExample {

  public static void searchAllResources(
      String scope,
      String query,
      String[] assetTypes,
      int pageSize,
      String pageToken,
      String orderBy) {
    SearchAllResourcesRequest request =
        SearchAllResourcesRequest.newBuilder()
            .setScope(scope)
            .setQuery(query)
            .addAllAssetTypes(Arrays.asList(assetTypes))
            .setPageSize(pageSize)
            .setPageToken(pageToken)
            .setOrderBy(orderBy)
            .build();
    try (AssetServiceClient client = AssetServiceClient.create()) {
      SearchAllResourcesPagedResponse response = client.searchAllResources(request);
      System.out.println("Search completed: \n" + response.getPage().getValues());
    } catch (Exception e) {
      System.out.println("Error during SearchAllResources: \n" + e.toString());
    }
  }
}
// [END asset_quickstart_search_all_resources]
