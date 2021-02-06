package net.vyl.crudclienteprovidercgm.data;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AdapdadorRecyclerCursor extends RecyclerView.Adapter <AdapdadorRecyclerCursor.ViewHolder> {


    Cursor cursor;
    Context contexto;
    LayoutInflater layoutInflater;
    private View.OnClickListener onClickListener;
    private View.OnLongClickListener onLongClickListener;

    public AdapdadorRecyclerCursor(Context context, Cursor cursor) {
        this.cursor = cursor;
        this.contexto = context;

        layoutInflater  = (LayoutInflater)
                contexto.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    public void setOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.onLongClickListener = onLongClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
          View layoutItem =
                  layoutInflater.inflate(android.R.layout.simple_list_item_2,null);
        layoutItem.setOnClickListener(this.onClickListener);
        layoutItem.setOnLongClickListener(this.onLongClickListener);
        return new ViewHolder(layoutItem);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        this.cursor.moveToPosition(position);

        holder.txtID.setText( String.valueOf(  cursor.getLong(0)));
        holder.txtNombre.setText(cursor.getString(1));

    }

    @Override
    public int getItemCount() {
        return cursor.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView txtID;
        TextView txtNombre;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtID = itemView.findViewById(android.R.id.text1);
            txtNombre = itemView.findViewById(android.R.id.text2);
        }
    }
}
