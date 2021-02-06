package net.vyl.crudclienteprovidercgm.ui.gallery;

import android.database.Cursor;
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
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import net.vyl.crudclienteprovidercgm.R;
import net.vyl.crudclienteprovidercgm.data.AdapdadorRecyclerCursor;
import net.vyl.crudclienteprovidercgm.provider.MiProveedorContenidoContract;

public class GalleryFragment extends Fragment {

    private GalleryViewModel galleryViewModel;
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(GalleryViewModel.class);
        View root = inflater.inflate(R.layout.fragment_gallery, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });

        layoutManager = new GridLayoutManager(getContext(), 2);

        recyclerView = root.findViewById(R.id.recyclerUsuarios);

        recyclerView.setLayoutManager(layoutManager);

        Cursor cursor = getContext().getContentResolver().query(MiProveedorContenidoContract.Usuarios.CONTENT_URI,
                null, null, null, null);

        AdapdadorRecyclerCursor adapdadorRecyclerCursor =
                new AdapdadorRecyclerCursor(
                        getContext(),
                        cursor
                );

        recyclerView.setAdapter(adapdadorRecyclerCursor);
        return root;
    }
}