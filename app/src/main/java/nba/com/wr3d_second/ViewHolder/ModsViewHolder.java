package nba.com.wr3d_second.ViewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import nba.com.wr3d_second.Interface.ItemClickListener;
import nba.com.wr3d_second.R;

public class ModsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView modsName;
    public ImageView modsImage;
    ItemClickListener itemClickListener;



    public void setItemClickListener(ItemClickListener itemClickListener) {
        this.itemClickListener = itemClickListener;
    }

    public ModsViewHolder(View itemView) {
        super(itemView);

        modsImage = (ImageView)itemView.findViewById(R.id.mods_image);
        modsName = (TextView)itemView.findViewById(R.id.mods_name);

        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        itemClickListener.onClick(v,getAdapterPosition());    }
}
