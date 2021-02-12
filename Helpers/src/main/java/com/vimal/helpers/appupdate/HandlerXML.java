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
package com.vimal.helpers.appupdate;



import com.vimal.helpers.appupdate.objects.Update;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.net.MalformedURLException;
import java.net.URL;

class HandlerXML extends DefaultHandler {
    private Update update;
    private StringBuilder builder;

    public Update getUpdate() {
        return update;
    }

    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        super.characters(ch, start, length);

        if (this.update != null) {
            builder.append(ch, start, length);
        }
    }

    @Override
    public void endElement(String uri, String localName, String name) throws SAXException {
        super.endElement(uri, localName, name);

        if (this.update != null) {
            if (localName.equals("latestVersion")) {
                update.setLatestVersion(builder.toString().trim());
            } else if (localName.equals("latestVersionCode")) {
                update.setLatestVersionCode(Integer.valueOf(builder.toString().trim()));
            } else if (localName.equals("releaseNotes")) {
                update.setReleaseNotes(builder.toString().trim());
            } else if (localName.equals("url")) {
                try {
                    update.setUrlToDownload(new URL(builder.toString().trim()));
                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                }
            }

            builder.setLength(0);
        }
    }

    @Override
    public void startDocument() throws SAXException {
        super.startDocument();

        builder = new StringBuilder();
    }

    @Override
    public void startElement(String uri, String localName,
                             String name, Attributes attributes) throws SAXException {
        super.startElement(uri, localName, name, attributes);

        if (localName.equals("update")) {
            update = new Update();
        }
    }

}
