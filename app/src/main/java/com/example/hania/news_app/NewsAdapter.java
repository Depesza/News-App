package com.example.hania.news_app;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class NewsAdapter extends ArrayAdapter<News> {
    public NewsAdapter(Context context, List<News> news){
        super(context, 0, news);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.news_list, parent, false);
        }
        News currentNews = getItem(position);

        TextView categoryView = listItemView.findViewById(R.id.category);
        categoryView.setText(currentNews.getCategory());

        TextView authorView = listItemView.findViewById(R.id.author);
        authorView.setText(currentNews.getAuthor());
        if (currentNews.getAuthor() == null){
            authorView.setVisibility(View.GONE);
        }

        TextView titleView = listItemView.findViewById(R.id.news_title);
        titleView.setText(currentNews.getTitle());

        TextView dateView = listItemView.findViewById(R.id.date);
        String dateText = formatTime(currentNews.getTime());
        dateView.setText(dateText);

        return listItemView;
    }

    private String formatTime(String dateInString) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
        try {
            Date date = dateFormat.parse(dateInString.replaceAll("Z$", "+0000"));
            SimpleDateFormat newDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
            return newDateFormat.format(date);
        } catch (ParseException e){
            Log.e("NewsAdapter", "Parsing date error.", e);
            return null;
        }
    }
}
