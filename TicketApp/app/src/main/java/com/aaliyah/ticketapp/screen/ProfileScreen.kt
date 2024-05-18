package com.aaliyah.ticketapp.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aaliyah.ticketapp.components.DrawLine

@Preview(name = "Pixel 2", device = Devices.PIXEL_2)
@Composable
fun ProfileScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFF29338E)),
        contentAlignment = Alignment.Center,
    ) {
        Column(
            horizontalAlignment = Alignment.Start,
            modifier = modifier
                .fillMaxSize()
                .padding(30.dp),
        ){
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Profile",
                fontSize = 30.sp,
                color = Color.White,
                fontWeight = FontWeight.ExtraBold
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Info",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xE6FFFFFF)),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = modifier
                        .fillMaxSize()
                        .padding(20.dp),
                ){
                    Text(
                        text = "5025201070",
                        fontSize = 20.sp,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Normal
                    )
                    DrawLine()
                    Text(
                        text = "Aaliyah Farah Adibah",
                        fontSize = 20.sp,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Normal
                    )
                    DrawLine()
                    Text(
                        text = "aaliyahfarahadibah@gmail.com",
                        fontSize = 20.sp,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "Actions",
                fontSize = 24.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(10.dp))
            Box(
                modifier = modifier
                    .fillMaxWidth()
                    .height(160.dp)
                    .clip(RoundedCornerShape(10.dp))
                    .background(Color(0xE6FFFFFF)),
                contentAlignment = Alignment.Center,
            ) {
                Column(
                    horizontalAlignment = Alignment.Start,
                    modifier = modifier
                        .fillMaxSize()
                        .padding(20.dp),
                ){
                    Text(
                        text = "Change Password",
                        fontSize =20.sp,
                        color = Color(0xFF2196F3),
                        fontWeight = FontWeight.Normal
                    )
                    DrawLine()
                    Text(
                        text = "Sign Out",
                        fontSize = 20.sp,
                        color = Color(0xFF2196F3),
                        fontWeight = FontWeight.Normal
                    )
                    DrawLine()
                    Text(
                        text = "Delete Account",
                        fontSize = 20.sp,
                        color = Color.Red,
                        fontWeight = FontWeight.Normal
                    )
                }
            }
        }
    }
}