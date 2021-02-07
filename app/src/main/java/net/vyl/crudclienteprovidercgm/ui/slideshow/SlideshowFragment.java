package net.vyl.crudclienteprovidercgm.ui.slideshow;

import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import net.vyl.crudclienteprovidercgm.R;
import net.vyl.crudclienteprovidercgm.provider.MiProveedorContenidoContract;

public class SlideshowFragment extends Fragment {

    private SlideshowViewModel slideshowViewModel;
    private TextView id;
    private TextView nombre;
    private TextView correo;
    private TextView telefono;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        slideshowViewModel =
                new ViewModelProvider(this).get(SlideshowViewModel.class);
        View root = inflater.inflate(R.layout.fragment_slideshow, container, false);

        id = root.findViewById(R.id.id_sliedeshow);
        nombre = root.findViewById(R.id.nombre_sliedeshow);
        correo = root.findViewById(R.id.correo_sliedeshow);
        telefono = root.findViewById(R.id.telefono_sliedeshow);

        if (getArguments() != null) {
            int index = getArguments().getInt("_ID");
            Uri uri = Uri.parse(MiProveedorContenidoContract.Usuarios.CONTENT_URI.toString() + "/" + index);
            Cursor cursor = getContext().getContentResolver().query(uri, null, null, null, null);
            if (cursor.moveToFirst()){
                id.setText("" + cursor.getInt(cursor.getColumnIndex(MiProveedorContenidoContract.Usuarios._ID)));
                nombre.setText("" + cursor.getString(cursor.getColumnIndex(MiProveedorContenidoContract.Usuarios.NOMBRE)));
                correo.setText("" + cursor.getString(cursor.getColumnIndex(MiProveedorContenidoContract.Usuarios.EMAIL)));
                telefono.setText("" + cursor.getString(cursor.getColumnIndex(MiProveedorContenidoContract.Usuarios.TELEFONO)));
            }
        }
        return root;
    }
}