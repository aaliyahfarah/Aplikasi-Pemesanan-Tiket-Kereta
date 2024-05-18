package com.aaliyah.ticketapp.screen

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.remember
import androidx.compose.runtime.toMutableStateList
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.aaliyah.ticketapp.components.Seat
import com.aaliyah.ticketapp.components.SeatGrid

class SeatActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SeatSelectionScreen()
        }
    }
}



@Preview(name = "Pixel 2", device = Devices.PIXEL_2)
@Composable
fun SeatSelectionScreen(
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    val seats = remember {
        (0..9).flatMap { row ->
            (0..3).map { column ->
                val isUnavailable = (row == 2 && column == 2) ||
                        (row == 4 && column == 3) ||
                        (row == 5 && column == 1) ||
                        (row == 1 && column == 3) ||
                        (row == 0 && column == 2) ||
                        (row == 0 && column == 3) ||
                        (row == 0 && column == 1) ||
                        (row == 7 && column == 0) ||
                        (row == 0 && column == 0)
                Seat(id = row * 4 + column + 1, row = row, column = column, isAvailable = !isUnavailable)
            }
        }.toMutableStateList()
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(60.dp)
                .background(color = Color(0xFF29338E)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Pilih Kursi",
                fontSize = 22.sp,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )
        }
        Spacer(modifier = Modifier.height(20.dp))
        Box(
            modifier = modifier
                .fillMaxWidth()
                .fillMaxHeight(0.87f)
                .background(Color(0xFFF5F5F5)),
            contentAlignment = Alignment.TopCenter
        ) {
            Surface(color = MaterialTheme.colorScheme.background) {
                SeatGrid(seats = seats, rows = 10, columns = 4)
            }
        }
        Spacer(modifier = Modifier.height(10.dp))
        Button(
            modifier = Modifier.width(320.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF5722),
                contentColor = Color.White
            ),
            onClick = {
                val intent = Intent(context, BookingActivity::class.java)
                context.startActivity(intent)
            },
        ) {
            Text(text = "Lanjut Pembayaran")
        }
        Spacer(modifier = Modifier.height(10.dp))
    }
}


