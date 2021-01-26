//package com.dean.tombasinproject.adapter;
//
//import android.content.Context;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.cardview.widget.CardView;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.bumptech.glide.Glide;
//import com.bumptech.glide.load.engine.DiskCacheStrategy;
//import com.dean.tombasinproject.R;
//import com.dean.tombasinproject.model.ProductItem;
//
//import java.util.List;
//
//public class TumbAdapter extends RecyclerView.Adapter<TumbAdapter.ViewHolder>{
//
//    private List<ProductItem> items;
//    private static TumbAdapter.onSelectData onSelectData;
//    private Context mContext;
//
//    public interface onSelectData {
//        void onSelected(ProductItem productItem);
//    }
//
//    public TumbAdapter(Context context, List<ProductItem> items, TumbAdapter.onSelectData xSelectData) {
//        this.mContext = context;
//        this.items = items;
//        this.onSelectData = xSelectData;
//    }
//
//
//    @NonNull
//    @Override
//    public TumbAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        return null;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull TumbAdapter.ViewHolder holder, int position) {
//        final ProductItem data = items.get(position);
//
//        //Get Image
//        Glide.with(mContext)
//                .load(data.getImages())
//                .diskCacheStrategy(DiskCacheStrategy.ALL)
//                .into(holder.imageProduct);
//
//        holder.tvName.setText(data.getName());
//        holder.tvPrice.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                onSelectData.onSelected(data);
//            }
//        });
//    }
//
//    @Override
//    public int getItemCount() {
//        return items.size();
//    }
//
//
//
//    class ViewHolder extends RecyclerView.ViewHolder {
//
//        public TextView tvName;
//        public TextView tvPrice;
//        public ImageView imageProduct;
//
//        public ViewHolder(@NonNull View itemView) {
//            super(itemView);
//            tvName = itemView.findViewById(R.id.tv_name);
//            tvPrice = itemView.findViewById(R.id.tv_price);
//            imageProduct = itemView.findViewById(R.id.img_product);
//        }
//    }
//}
