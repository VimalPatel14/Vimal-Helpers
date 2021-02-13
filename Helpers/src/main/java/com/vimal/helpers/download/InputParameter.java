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
package com.vimal.helpers.download;


public class InputParameter {
    private final String baseUrl;
    private final String relativeUrl;
    private final String loadedFilePath;
    private final boolean isCallbackOnUiThread;

    private InputParameter(Builder builder) {
        this.baseUrl = builder.baseUrl;
        this.relativeUrl = builder.relativeUrl;
        this.loadedFilePath = builder.loadedFilePath;
        this.isCallbackOnUiThread = builder.isCallbackOnUiThread;
    }


    public String getBaseUrl() {
        return baseUrl;
    }

    public String getRelativeUrl() {
        return relativeUrl;
    }

    public String getLoadedFilePath() {
        return loadedFilePath;
    }

    public boolean isCallbackOnUiThread() {
        return isCallbackOnUiThread;
    }

    public static class Builder {
        String baseUrl;
        String relativeUrl;
        String loadedFilePath;
        boolean isCallbackOnUiThread;

        public Builder(String baseUrl, String relativeUrl, String loadedFilePath) {
            this.baseUrl = baseUrl;
            this.relativeUrl = relativeUrl;
            this.loadedFilePath = loadedFilePath;
        }


        public Builder setCallbackOnUiThread(boolean callbackOnUiThread) {
            isCallbackOnUiThread = callbackOnUiThread;
            return this;
        }


        public InputParameter build() {
            return new InputParameter(this);
        }
    }
}
