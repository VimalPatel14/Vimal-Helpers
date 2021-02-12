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
package com.vimal.helpers.customgallery.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.vimal.helpers.R;
import com.vimal.helpers.customgallery.model.ImageModel;
import com.vimal.helpers.customgallery.myinterface.OnAlbum;

import java.io.File;
import java.util.ArrayList;


public class AlbumAdapter extends ArrayAdapter<ImageModel> {
    Context context;
    ArrayList<ImageModel> data = new ArrayList();
    int layoutResourceId;
    OnAlbum onItem;
    int pHeightItem = 0;
    int pWHIconNext = 0;

    static class RecordHolder {
        ImageView iconNext;
        ImageView imageItem;
        RelativeLayout layoutRoot;
        TextView txtPath;
        TextView txtTitle;

        RecordHolder() {
        }
    }

    public AlbumAdapter(Context context, int layoutResourceId, ArrayList<ImageModel> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
        this.pHeightItem = getDisplayInfo((Activity) context).widthPixels / 6;
        this.pWHIconNext = this.pHeightItem / 4;
    }

    public View getView(final int position, View convertView, ViewGroup parent) {
        RecordHolder holder;
        View row = convertView;
        if (row == null) {
            row = ((Activity) this.context).getLayoutInflater().inflate(this.layoutResourceId, parent, false);
            holder = new RecordHolder();
            holder.txtTitle = (TextView) row.findViewById(R.id.name_album);
            holder.txtPath = (TextView) row.findViewById(R.id.path_album);
            holder.imageItem = (ImageView) row.findViewById(R.id.icon_album);
            holder.iconNext = (ImageView) row.findViewById(R.id.iconNext);
            holder.layoutRoot = (RelativeLayout) row.findViewById(R.id.layoutRoot);
            holder.layoutRoot.getLayoutParams().height = this.pHeightItem;
            holder.imageItem.getLayoutParams().width = this.pHeightItem;
            holder.imageItem.getLayoutParams().height = this.pHeightItem;
            holder.iconNext.getLayoutParams().width = this.pWHIconNext;
            holder.iconNext.getLayoutParams().height = this.pWHIconNext;
            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }
        ImageModel item = (ImageModel) this.data.get(position);
        holder.txtTitle.setText(item.getName());
        holder.txtPath.setText(item.getPathFolder());
        Glide.with(this.context).load(new File(item.getPathFile())).placeholder(R.drawable.piclist_icon_default).into(holder.imageItem);

        row.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (AlbumAdapter.this.onItem != null) {
                    AlbumAdapter.this.onItem.OnItemAlbumClick(position);
                }
            }
        });
        return row;
    }

    public OnAlbum getOnItem() {
        return this.onItem;
    }

    public void setOnItem(OnAlbum onItem) {
        this.onItem = onItem;
    }

    public static DisplayMetrics getDisplayInfo(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindow().getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm;
    }
}
