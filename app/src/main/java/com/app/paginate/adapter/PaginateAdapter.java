package com.app.paginate.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.app.paginate.R;
import com.app.paginate.model.RecyclerData;
import com.app.paginate.utils.ImageLoader;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class PaginateAdapter extends RecyclerView.Adapter<PaginateAdapter.RecyclerViewHolder> {

    private ArrayList<RecyclerData.RecyclerDatum> courseDataArrayList;
    private Activity mcontext;

    public PaginateAdapter(ArrayList<RecyclerData.RecyclerDatum> recyclerDataArrayList, Activity mcontext) {
        this.courseDataArrayList = recyclerDataArrayList;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate Layout
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_image, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        // Set the data to textview and imageview.
        RecyclerData.RecyclerDatum recyclerData = courseDataArrayList.get(position);
        holder.courseTV.setText(recyclerData.getThumbnail().getId());
        String imageURL = recyclerData.getThumbnail().getDomain() + "/" + recyclerData.getThumbnail().getBasePath() + "/0/" + recyclerData.getThumbnail().getKey();

        Log.e("IMAGE==", imageURL);

//        new ImageLoader(mcontext).DisplayImage(imageURL, holder.courseIV);

//        holder.courseIV.setImageResource(recyclerData.getKey());
        mcontext.runOnUiThread(new Runnable() {
            @Override
            public void run() {

//                holder.courseIV.setImageBitmap(getBitmapFromURL(imageURL));
                URL url = null;
                try {
                    url = new URL(imageURL);
                    Bitmap myBitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
                    holder.courseIV.setImageBitmap(myBitmap);
//                    userImage.setIcon(new BitmapDrawable(getResources(), myBitmap));

                } catch (MalformedURLException e) {
                    throw new RuntimeException(e);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
//                Bitmap myBitmap = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            }
        });
    }

    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            Bitmap image = BitmapFactory.decodeStream(url.openConnection().getInputStream());
            return image;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    } // Aut
    @Override
    public int getItemCount() {
        // this method returns the size of recyclerview
        return courseDataArrayList.size();
    }

    // View Holder Class to handle Recycler View.
    public class RecyclerViewHolder extends RecyclerView.ViewHolder {

        private TextView courseTV;
        private ImageView courseIV;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            courseTV = itemView.findViewById(R.id.idTVCourse);
            courseIV = itemView.findViewById(R.id.idIVcourseIV);
        }
    }
}