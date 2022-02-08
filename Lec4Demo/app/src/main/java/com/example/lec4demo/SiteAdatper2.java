package com.example.lec4demo;

import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.core.content.res.ResourcesCompat;

import java.util.List;

public class SiteAdatper2 extends BaseAdapter {
    //Data os list<SiteAttrction>
    List<SiteAttraction> siteAttractions;

    public SiteAdatper2(List<SiteAttraction> siteAttractions) {
        this.siteAttractions = siteAttractions;
    }

    @Override
    public int getCount() {
        return siteAttractions.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            LayoutInflater layoutInflater = LayoutInflater.from
                    (viewGroup.getContext());

            view = layoutInflater.inflate(R.layout.layout_siteitem,viewGroup,false);

        }

        TextView textViewSiteItem = view.findViewById(R.id.textViewSiteItem);
        textViewSiteItem.setText(siteAttractions.get(i).getSiteName());

        Drawable img = ResourcesCompat.getDrawable(
                viewGroup.getResources(),siteAttractions.get(i).getSitePic(),viewGroup.getContext().getTheme());
        img.setBounds(0,0,150,150);
        textViewSiteItem.setCompoundDrawables(img,null,null,null);
        textViewSiteItem.setCompoundDrawablePadding(8);

        textViewSiteItem.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);

        return view;
    }
}
