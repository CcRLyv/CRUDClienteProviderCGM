package net.vyl.crudclienteprovidercgm.provider;

import android.net.Uri;
import android.provider.BaseColumns;

public class MiProveedorContenidoContract {
    public static final String AUTHORITY = "user_dictionary";
    public static final Uri CONTENT_URI = null;
// Pruevas de github 
    public MiProveedorContenidoContract() {
        throw new RuntimeException("Stub!");
    }

    public static class Usuarios implements BaseColumns {

        public static final String CONTENT_ITEM_TYPE = "vnd.android.cursor.item/vnd.net.ivanvega.actividadesenandorid.provider.usuarios";
        public static final String CONTENT_TYPE = "vnd.android.cursor.dir/vnd.net.ivanvega.actividadesenandorid.provider.usuarios";

        public static final Uri CONTENT_URI =
                Uri.parse( "content://net.ivanvega.actividadesenandorid.provider/usuarios");
        

        public static final String _ID = "_id";
        public static final String EMAIL = "email";
        public static final String NOMBRE = "nombre";
        public static final String TELEFONO = "tel";
        public static final String PASS = "password";
    }

}
