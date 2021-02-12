/*
 * Copyright (C) 2021 Vimal Patel
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.vimal.helpers.appupdate.enums;

public enum AppUpdaterError {
    /**
     * Google Play returned "Varies by device"
     */
    UPDATE_VARIES_BY_DEVICE,

    /**
     * GitHub user or repo is empty
     */
    GITHUB_USER_REPO_INVALID,

    /**
     * No Internet connection available
     */
    NETWORK_NOT_AVAILABLE,

    /**
     * URL for the XML file is not valid
     */
    XML_URL_MALFORMED,

    /**
     * XML file is invalid or is down
     */
    XML_ERROR,
    /**
     * URL for the JSON file is not valid
     */
    JSON_URL_MALFORMED,

    /**
     * JSON file is invalid or is down
     */
    JSON_ERROR


    }
