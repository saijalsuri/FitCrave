package com.apps.saijestudio.fitcrave.viewadapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.apps.saijestudio.fitcrave.R;

//ResultListAdapter sets the listView of the results
public class ResultListAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] values;
    private final String[] titles;
    private final String[] snippets;
    private final String[] links;
    private final String[] urls;

    static class ViewHolder {
        public TextView title;
        public TextView desc;
        public TextView link;
        public TextView url;


    }

    //constructor to initialize arrays of result data
    public ResultListAdapter(Activity context, String[] values, String[] titles, String[] snippets, String[] links, String[] urls) {
        super(context, -1, values);
        this.context = context;
        this.values = values;
        this.titles = titles;
        this.snippets = snippets;
        this.links = links;
        this.urls = urls;


    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        // reuse views
        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(R.layout.list_item, null);

            // configure view holder
            ViewHolder viewHolder = new ViewHolder();
            viewHolder.title = (TextView) rowView.findViewById(R.id.title);
            viewHolder.desc = (TextView) rowView.findViewById(R.id.desc);
            viewHolder.link = (TextView) rowView.findViewById(R.id.link);
            viewHolder.url = (TextView) rowView.findViewById(R.id.url);
            rowView.setTag(viewHolder);
        }

        // fill data
        ViewHolder holder = (ViewHolder) rowView.getTag();
        String t = titles[position];
        holder.title.setText(t);

        String s = snippets[position];
        holder.desc.setText(s);

        String l = links[position];
        holder.link.setText(l);

        String u = urls[position];
        holder.url.setText(u);

        return rowView;
    }

}