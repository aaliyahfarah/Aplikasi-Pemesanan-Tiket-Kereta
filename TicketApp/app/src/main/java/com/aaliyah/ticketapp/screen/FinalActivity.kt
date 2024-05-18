package com.aaliyah.ticketapp.screen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aaliyah.ticketapp.MainActivity
import com.aaliyah.ticketapp.screen.ui.theme.TicketAppTheme

class FinalActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FinalScreen()
        }
    }
}

@Preview(name = "Pixel 2", device = Devices.PIXEL_2)
@Composable
fun FinalScreen(modifier: Modifier = Modifier) {
    val context = LocalContext.current

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF29338E)),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = modifier.padding(23.dp)
        ) {
            Icon(
                imageVector = Icons.Default.CheckCircle,
                contentDescription = "Pembayaran Berhasil",
                tint = Color.Green,
                modifier = Modifier
                    .size(120.dp)
            )
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Rp 610.000",
                fontSize = 40.sp,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(20.dp))
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(0.45f)
                    .border(
                        width = 1.dp,
                        color = Color.White,
                        shape = RoundedCornerShape(10.dp)
                    )
                    .background(Color(0x4DFFFFFF))
            ) {
                Column(
                    modifier = Modifier.padding(20.dp)
                ){
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .width(350.dp)
                            .height(30.dp)
                    ){
                        Text(
                            text = "Jayabaya",
                            fontSize = 22.sp,
                            color = Color.White,
                            fontWeight = FontWeight.SemiBold
                        )
                        Spacer(modifier = Modifier.height(3.dp))
                        Text(
                            text = "1 Orang",
                            fontSize = 14.sp,
                            color = Color.White,
                            fontWeight = FontWeight.Normal
                        )
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .width(350.dp)
                            .height(30.dp)
                    ){
                        Text(
                            text = "Gambir (GMR)",
                            fontSize = 18.sp,
                            color = Color.White,
                        )
                        Icon(
                            imageVector = Icons.Default.ArrowForward,
                            contentDescription = "Arrow",
                            tint = Color.White,
                            modifier = Modifier
                                .size(18.dp)
                        )
                        Text(
                            text = "Surabaya Gubeng (SGU)",
                            fontSize = 18.sp,
                            color = Color.White,
                        )
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Sabtu, 18 May 2024",
                        fontSize = 18.sp,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Row(verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier
                            .width(350.dp)
                            .height(50.dp)
                    ){
                        Column{
                            Text(
                                text = "Berangkat",
                                fontSize = 14.sp,
                                color = Color.LightGray,
                                fontWeight = FontWeight.Normal
                            )
                            Text(
                                text = "17.25",
                                fontSize = 22.sp,
                                color = Color.White,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }
                        Box(
                            modifier = Modifier
                                .fillMaxWidth(0.4f)
                                .height(1.dp)
                                .background(Color.White)
                        )
                        Column{
                            Text(
                                text = "Sampai",
                                fontSize = 14.sp,
                                color = Color.LightGray,
                                fontWeight = FontWeight.Normal
                            )
                            Text(
                                text = "04.18",
                                fontSize = 22.sp,
                                color = Color.White,
                                fontWeight = FontWeight.ExtraBold
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Eksekutif (Kursi 14)",
                        fontSize = 18.sp,
                        color = Color.White,
                    )

                    //
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Button(
                modifier = Modifier.width(320.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFF5722),
                    contentColor = Color.White
                ),
                onClick = {
                    val intent = Intent(context, MainActivity::class.java)
                    context.startActivity(intent) },
            ) {
                Text(text = "Kembali ke Halaman Utama")
            }
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}

