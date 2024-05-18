package com.aaliyah.ticketapp.components

import android.content.*
import android.content.Context.CLIPBOARD_SERVICE
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

// on below line creating a method to display UI.
@RequiresApi(Build.VERSION_CODES.M)
@Composable
fun PromoCopyButton(promoItem: PromoItem) {

    // on below line creating
    // a variable for message.
    val context = LocalContext.current
    val displayText = "COPY"

    ClickableText(
        text = AnnotatedString(displayText) ,
        onClick = {
            val clipboardManager =
                context.getSystemService(CLIPBOARD_SERVICE) as ClipboardManager
            var clipData: ClipData = ClipData.newPlainText("text", promoItem.kodepromo)

            clipboardManager.setPrimaryClip(clipData)

            Toast.makeText(context, "Copied to Clipboard", Toast.LENGTH_SHORT).show()

        },
        style = TextStyle(
            fontWeight = FontWeight.ExtraBold,
            fontSize = 16.sp,
            color = Color(0xFFFF5722)
        ),
    )
}