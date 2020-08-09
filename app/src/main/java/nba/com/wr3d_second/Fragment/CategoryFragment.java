package nba.com.wr3d_second.Fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.android.gms.common.internal.service.Common;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Callback;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

import nba.com.wr3d_second.Interface.ItemClickListener;
import nba.com.wr3d_second.Model.ModItem;
import nba.com.wr3d_second.R;
import nba.com.wr3d_second.ViewHolder.ModsViewHolder;


public class CategoryFragment extends Fragment {

    FirebaseDatabase database;
    DatabaseReference modsRencentItem;

    FirebaseRecyclerOptions<ModItem> options;
    FirebaseRecyclerAdapter<ModItem,ModsViewHolder> adapter;

    RecyclerView recyclerView;


    private static CategoryFragment INSTANCE = null;


    public CategoryFragment() {
        database = FirebaseDatabase.getInstance();
        modsRencentItem = database.getReference(nba.com.wr3d_second.Common.Common.Str_Mods_Rencent);

        options = new FirebaseRecyclerOptions.Builder<ModItem>()
                .setQuery(modsRencentItem,ModItem.class).build();

        adapter = new FirebaseRecyclerAdapter<ModItem, ModsViewHolder>(options) {
            @Override
            protected void onBindViewHolder(@NonNull final ModsViewHolder holder, int position, @NonNull final ModItem model) {
                Picasso.with(getActivity())
                        .load(model.getImageUrl())
                        .into(holder.modsImage, new Callback() {
                            @Override
                            public void onSuccess() {

                            }

                            @Override
                            public void onError() {

                                Picasso.with(getActivity())
                                        .load(model.getImageUrl())
                                        .error(R.drawable.ic_image_black_24dp)
                                        .into(holder.modsImage, new Callback() {
                                            @Override
                                            public void onSuccess() {

                                            }

                                            @Override
                                            public void onError() {

                                                Log.e("WR3D Image", "onError: can't load  Image");
                                            }
                                        });
                            }
                        });

                holder.modsName.setText(model.getName());

                holder.setItemClickListener(new ItemClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        // mod详细
                    }
                });
            }

            @NonNull
            @Override
            public ModsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.layout_mods_item,parent,false);
                return new ModsViewHolder(itemView);
            }
        };
    }

    public static CategoryFragment getInstance(){
        if (INSTANCE == null)
            INSTANCE = new CategoryFragment();
        return INSTANCE;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        recyclerView = (RecyclerView)view.findViewById(R.id.recycler_mods_rencent);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        setModsRencent();

        return view;
    }

    private void setModsRencent() {
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (adapter!=null)
            adapter.startListening();
    }

    @Override
    public void onStop() {
        if (adapter!=null)
            adapter.stopListening();
        super.onStop();
    }

    @Override
    public void onResume() {
        super.onResume();
        if (adapter!=null)
            adapter.startListening();
    }
}
