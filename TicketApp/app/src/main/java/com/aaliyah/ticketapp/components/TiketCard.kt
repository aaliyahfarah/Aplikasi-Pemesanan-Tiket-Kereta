package com.aaliyah.ticketapp.components

import android.content.Intent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aaliyah.ticketapp.screen.SeatActivity

data class TiketItem(
    val id: Int,
    val namakereta: String,
    val tipekereta: String,
    val jamberangkat: String,
    val jamsampai: String,
    val durasi: String,
    val harga: String,
)

//data
val tiketList = listOf(
    TiketItem(1, "Gaya Baru Malam Selatan", "Ekonomi",
        "11.00", "00.13", "13j 13m", "Rp 390.000"),
    TiketItem(2, "Gaya Baru Malam Selatan", "Eksekutif",
        "11.00", "00.13", "13j 13m", "Rp 540.000"),
    TiketItem(3, "Jayakarta", "Ekonomi",
        "17.10", "06.16", "13j 6m", "Rp 390.000"),
    TiketItem(4, "Jayabaya", "Ekonomi",
        "17.25", "04.18", "10j 53m", "Rp 430.000"),
    TiketItem(5, "Jayabaya", "Eksekutif",
        "17.25", "04.18", "10j 53m", "Rp 610.000"),
)


@Composable
fun TiketCard(
    tiketItem: TiketItem,
    onClick: () -> Unit
) {
    val context = LocalContext.current

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier.padding(10.dp).clickable(onClick = onClick)
    ) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(15.dp)
                .height(120.dp)
                .fillMaxWidth()
        ){
            Column(
                //verticalAlignment = Alignment.Top,
                //horizontalArrangement = Arrangement.SpaceBetween,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier
//                    .width(220.dp)
//                .padding(15.dp)
//                .height(150.dp)
            ) {
                Text(
                    text = tiketItem.namakereta,
                    fontSize = 18.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(3.dp))
                Text(
                    text = tiketItem.tipekereta,
                    fontSize = 14.sp,
                    color = Color.Gray,
                    fontWeight = FontWeight.Normal
                )
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .width(200.dp)
                        .height(30.dp)
                ){
                    Text(
                        text = tiketItem.jamberangkat,
                        fontSize = 22.sp,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .width(50.dp)
                            .fillMaxHeight()
                    ){
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(1.dp)
                                .background(Color.DarkGray)
                        )
                    }
                    Text(
                        text = tiketItem.jamsampai,
                        fontSize = 22.sp,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.ExtraBold
                    )
                }
                Spacer(modifier = Modifier.height(5.dp))
                Text(
                    text = "Durasi: ${tiketItem.durasi}",
                    fontSize = 16.sp,
                    color = Color.DarkGray,
                    fontWeight = FontWeight.Normal
                )
                //Spacer(modifier = Modifier.width(20.dp))
            }
            Box(
                contentAlignment = Alignment.BottomEnd,
                modifier = Modifier
                    .fillMaxHeight()
            ){
                Column(
                    horizontalAlignment = Alignment.End,
                ){
                    Text(
                        text = tiketItem.harga,
                        fontSize = 22.sp,
                        color = Color(0xFFFF5722),
                        fontWeight = FontWeight.ExtraBold
                    )
                    Button(
                        modifier = Modifier.width(90.dp),
                        shape = RectangleShape,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFF5722),
                            contentColor = Color.White
                        ),
                        onClick = {
                            val intent = Intent(context, SeatActivity::class.java)
                            context.startActivity(intent)
                        },
                    ) {
                        Text(text = "Pesan")
                    }
                }
            }
        }
    }
}