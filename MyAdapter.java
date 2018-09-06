package graysone;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import graysone.com.amazonservice.R;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<String> strings;

    public MyAdapter(List<String>  stringList) {
        strings = stringList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from ( parent.getContext () ).inflate ( R.layout.row_name,parent,false );
        return  new MyViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {


        holder.tvName.setText ( strings.get ( position ));



    }

    @Override
    public int getItemCount() {
        return strings.size ();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tvName;

        public MyViewHolder(View itemView) {
            super ( itemView );

            tvName = itemView.findViewById ( R.id.textView );
        }
    }


}
