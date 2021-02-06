package net.vyl.crudclienteprovidercgm.ui.gallery;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import net.vyl.crudclienteprovidercgm.R;
import net.vyl.crudclienteprovidercgm.provider.MiProveedorContenidoContract;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    Button btnAceptar;
    TextView tbNombre;
    TextView tbCorreo;
    TextView tbContra;
    TextView tbTel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);

        btnAceptar = root.findViewById(R.id.btnAceptar);
        tbNombre  = root.findViewById(R.id.tbNombre);
        tbCorreo  = root.findViewById(R.id.tbEmail);
        tbContra  = root.findViewById(R.id.tbPas);
        tbTel  = root.findViewById(R.id.tbTel);



        ContentResolver cr = getContext().getContentResolver();
        ContentValues cv = new ContentValues();

        btnAceptar.setOnClickListener(l->{
            cv.put(MiProveedorContenidoContract.Usuarios.NOMBRE,tbNombre.getText().toString() );
            cv.put(MiProveedorContenidoContract.Usuarios.PASS, tbContra.getText().toString());
            cv.put(MiProveedorContenidoContract.Usuarios.EMAIL, tbCorreo.getText().toString());
            cv.put(MiProveedorContenidoContract.Usuarios.TELEFONO, tbContra.getText().toString());

            Uri resultado = cr.insert(MiProveedorContenidoContract.Usuarios.CONTENT_URI, cv);

        });
        return root;
    }
}