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
import java.util.ResourceBundle;

public class SitesAdapter extends BaseAdapter {
    List<String> SitesNamesList;
    List<Integer> SitesPicsList;

    public SitesAdapter(List<String> sitesNamesList, List<Integer> sitesPicsList) {
        SitesNamesList = sitesNamesList;
        SitesPicsList = sitesPicsList;
    }

    @Override
    public int getCount() {
        return SitesNamesList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
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
        textViewSiteItem.setText(SitesNamesList.get(i));

        Drawable img = ResourcesCompat.getDrawable(
                viewGroup.getResources(),SitesPicsList.get(i),viewGroup.getContext().getTheme());
        img.setBounds(0,0,150,150);
        textViewSiteItem.setCompoundDrawables(img,null,null,null);
        textViewSiteItem.setCompoundDrawablePadding(8);

        textViewSiteItem.setGravity(Gravity.LEFT | Gravity.CENTER_VERTICAL);

        return view;

    }
}
