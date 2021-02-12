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
package com.vimal.helpers.appupdate.objects;

public class GitHub {
    private String gitHubUser;
    private String gitHubRepo;

    public GitHub(String gitHubUser, String gitHubRepo) {
        this.gitHubUser = gitHubUser;
        this.gitHubRepo = gitHubRepo;
    }

    public String getGitHubUser() {
        return gitHubUser;
    }

    public void setGitHubUser(String user) {
        this.gitHubUser = user;
    }

    public String getGitHubRepo() {
        return gitHubRepo;
    }

    public void setGitHubRepo(String repo) {
        this.gitHubRepo = repo;
    }

    public static Boolean isGitHubValid(GitHub gitHub) {
        if (gitHub == null || gitHub.getGitHubUser().length() == 0 || gitHub.getGitHubRepo().length() == 0) {
            return false;
        } else {
            return true;
        }
    }

}
