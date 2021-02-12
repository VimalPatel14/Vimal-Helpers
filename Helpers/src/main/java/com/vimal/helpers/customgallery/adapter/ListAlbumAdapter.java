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

import com.bumptech.glide.Glide;
import com.vimal.helpers.R;
import com.vimal.helpers.customgallery.model.ImageModel;
import com.vimal.helpers.customgallery.myinterface.OnListAlbum;

import java.util.ArrayList;


public class ListAlbumAdapter extends ArrayAdapter<ImageModel> {
    Context context;
    ArrayList<ImageModel> data = new ArrayList();
    int layoutResourceId;
    OnListAlbum onListAlbum;
    int pHeightItem = 0;

    static class RecordHolder {
        ImageView click;
        ImageView imageItem;
        RelativeLayout layoutRoot;

        RecordHolder() {
        }
    }

    public ListAlbumAdapter(Context context, int layoutResourceId, ArrayList<ImageModel> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
        this.pHeightItem = getDisplayInfo((Activity) context).widthPixels / 3;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        RecordHolder holder;
        View row = convertView;
        if (row == null) {
            row = ((Activity) this.context).getLayoutInflater().inflate(this.layoutResourceId, parent, false);
            holder = new RecordHolder();
            holder.imageItem = (ImageView) row.findViewById(R.id.imageItem);
            holder.click = (ImageView) row.findViewById(R.id.click);
            holder.layoutRoot = (RelativeLayout) row.findViewById(R.id.layoutRoot);
            holder.layoutRoot.getLayoutParams().height = this.pHeightItem;
            holder.imageItem.getLayoutParams().width = this.pHeightItem;
            holder.imageItem.getLayoutParams().height = this.pHeightItem;
            holder.click.getLayoutParams().width = this.pHeightItem;
            holder.click.getLayoutParams().height = this.pHeightItem;
            row.setTag(holder);
        } else {
            holder = (RecordHolder) row.getTag();
        }
        final ImageModel item = (ImageModel) this.data.get(position);
        //  Glide.with(this.context).load(item.getPathFile()).asBitmap().override((int) Callback.DEFAULT_DRAG_ANIMATION_DURATION, (int) Callback.DEFAULT_DRAG_ANIMATION_DURATION).animate(R.anim.anim_fade_in).thumbnail((float) AppConst.ZOOM_MIN).error(R.drawable.piclist_icon_default).fallback(R.drawable.piclist_icon_default).placeholder(R.drawable.piclist_icon_default).into(holder.imageItem);

        Glide.with(context).load(item.getPathFile()).placeholder(R.drawable.piclist_icon_default).into(holder.imageItem);

       // Picasso.with(this.context).load(new File(item.getPathFile())).placeholder(R.drawable.piclist_icon_default).into(holder.imageItem);

        row.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                if (ListAlbumAdapter.this.onListAlbum != null) {
                    ListAlbumAdapter.this.onListAlbum.OnItemListAlbumClick(item);
                }
            }
        });
        return row;
    }

    public OnListAlbum getOnListAlbum() {
        return this.onListAlbum;
    }

    public void setOnListAlbum(OnListAlbum onListAlbum) {
        this.onListAlbum = onListAlbum;
    }

    public static DisplayMetrics getDisplayInfo(Activity activity) {
        DisplayMetrics dm = new DisplayMetrics();
        activity.getWindow().getWindowManager().getDefaultDisplay().getMetrics(dm);
        return dm;
    }
}
