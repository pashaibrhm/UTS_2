package com.aquarian.uts;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import java.util.HashMap;

public class SessionManager {
    // Shared Preferences
    SharedPreferences pref;

    // Editor untuk Shared Preferences
    SharedPreferences.Editor editor;

    // Context
    Context _context;

    // Shared pref mode
    int PRIVATE_MODE = 0;

    // Shared pref file name
    private static final String PREF_NAME = "BelajarPref";

    // Semua Shared Preferences Keys
    private static final String IS_LOGIN = "IsLoggedIn";

    // Nama User (buat dengan variabel public agar dapat diakses dari luar)
    public static final String KEY_NAME = "name";

    // Alamat email address (buat dengan variable public agar dapat di akses dari luar)
    public  static final String KEY_EMAIL = "email";

    // Constructor
    public SessionManager (Context context) {
        this._context = context;
        pref = _context.getSharedPreferences (PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    /**
     * Membuat Login Session
     */
    public void createLoginSession (String nama, String email) {
        // Menyimpan login dengan nilai TRUE
        editor.putBoolean(IS_LOGIN, true);

        // Menyimpan nama di pref
        editor.putString(KEY_NAME, nama);

        // Menyimpan email di pref
        editor.putString(KEY_EMAIL, email);

        // Simpan perubahan
        editor.commit();
    }

    /**
     * Mendapatkan session data yang tersimpan
     */
    public HashMap<String, String> getUserDetails() {
        HashMap<String, String> user = new HashMap<String, String>();
        // Nama user
        user.put(KEY_NAME, pref.getString(KEY_NAME, null));

        // User email id
        user.put(KEY_EMAIL, pref.getString(KEY_EMAIL, null));

        // Return user
        return user;
    }

    /**
     * Metode Check Login akan mengecek login status
     * jika false maka akan mengarahkan ke page Login
     * jika tidak maka tidak ada perubahan
     */
    public void checkLogin() {
        // Check login status
        if (!this.isLoggedIn()) {
            // Jika user tidak login maka akan diarahkan ke Login Activity
            Intent i = new Intent(_context, LoginActivity.class);
            // Tutup semua Activity
            i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

            // Tambahan flag baru untuk memulai Activity baru
            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            // Membuka Activity Login
            _context.startActivity(i);
        }
    }

    /**
     * Cek user login
     */
    // Mendapatkan Login State
    public boolean isLoggedIn() {
        return pref.getBoolean(IS_LOGIN, false);
    }

    /**
     * Menghapus detail session
     */
    public void logOutUser() {
        // Menghapus semua data dari Shared Preferences
        editor.clear();
        editor.commit();

        // Setelah logout user diarahkan ke LoginActivity
        Intent i = new Intent(_context, LoginActivity.class);
        // Tutup semua Activity
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        // Tambahkan flag baru untuk memulai Activity baru
        i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

        // Membuka Activity Login
        _context.startActivity(i);
    }
}
