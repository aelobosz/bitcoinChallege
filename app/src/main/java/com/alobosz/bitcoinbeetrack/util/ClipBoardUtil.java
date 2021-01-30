package com.alobosz.bitcoinbeetrack.util;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.widget.Toast;

import com.alobosz.bitcoinbeetrack.R;

import static android.content.Context.CLIPBOARD_SERVICE;

public class ClipBoardUtil {
    public static void copyToClipboard(Context context, String address) {
        try {

            ClipboardManager clipboard = (ClipboardManager) context.getSystemService(CLIPBOARD_SERVICE);
            ClipData clip = ClipData.newPlainText(context.getString(R.string.btc_address), address);
            clipboard.setPrimaryClip(clip);
            Toast.makeText(context, context.getString(R.string.copied_clipboard), Toast.LENGTH_SHORT).show();

        }catch (NullPointerException ignored){}
    }
}
