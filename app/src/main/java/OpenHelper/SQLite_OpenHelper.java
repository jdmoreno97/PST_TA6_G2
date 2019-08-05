package OpenHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLite_OpenHelper extends SQLiteOpenHelper {
    public SQLite_OpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query="create table usuarios(_ID integer primary key autoincrement, Nombre text, Telefono text, Usuario text, Password text, Correo text);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    //Abrir DB
    public void abrir(){
        this.getWritableDatabase();
    }

    public void cerrar(){
        this.close();
    }
    //Inseratr registros
    public void insertarReg(String nom,String tel,String cor,String pas,String mail){
        ContentValues valores=new ContentValues();
        valores.put("Nombre",nom);
        valores.put("Telefono",tel);
        valores.put("Usuario",cor);
        valores.put("Password",pas);
        valores.put("Correo",mail);
        this.getWritableDatabase().insert("usuarios",null,valores);
    }
    public Cursor ConsultarUsuPas(String usu,String pas) throws SQLException{
        Cursor mcursor=null;
        mcursor=this.getReadableDatabase().query("usuarios",new String[]{"_ID","Nombre","Telefono","Usuario","Password","Correo"},
                "Usuario like '"+usu+"' and Password like '"+pas+"'",null,null,null,null);
        return mcursor;

    }
}

