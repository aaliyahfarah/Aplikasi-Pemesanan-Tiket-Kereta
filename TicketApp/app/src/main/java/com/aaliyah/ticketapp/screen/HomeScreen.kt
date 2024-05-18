package com.aaliyah.ticketapp.screen

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.aaliyah.ticketapp.R
import com.aaliyah.ticketapp.components.TimePickerScreen
import com.aaliyah.ticketapp.navigation.Screen
import com.kiranbahalaskar.drowpdownmenu.DropdownStasiun
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat.startActivity


//@Preview(name = "Pixel 2", device = Devices.PIXEL_2)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    navController: NavHostController
) {
    val context = LocalContext.current

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFFFFFFF)),
        //contentAlignment = Alignment.BottomCenter,
    ) {
        Image(
            painter = painterResource(R.drawable.kereta),
            contentDescription = null,
            modifier = Modifier
                .height(300.dp)
                .fillMaxWidth(),
            contentScale = ContentScale.FillBounds,
            alignment = Alignment.TopCenter
        )
        Surface(
            color = Color(0xFF29338E),
            modifier = Modifier
                .height(450.dp)
                .fillMaxWidth()
                .align(Alignment.BottomCenter),
            shape = RoundedCornerShape(
                topStart = CornerSize(40.dp),
                topEnd = CornerSize(40.dp),
                bottomEnd = CornerSize(0.dp),
                bottomStart = CornerSize(0.dp)
            )) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(Color(0xFF29338E)),
//                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(modifier = Modifier.height(20.dp))
                Text(
                    text = "Kereta Api",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
                Spacer(modifier = Modifier.height(20.dp))
                Column(
                    modifier = Modifier
                        .width(360.dp)
                        .background(Color(0xFFFFFFFF), shape = RoundedCornerShape(10.dp)),
                    horizontalAlignment = Alignment.CenterHorizontally
                ){
                    DropdownStasiun(
                        label = "Stasiun Asal",
                        leadIcon = Icons.Default.Home,
                        dataDropdown = R.array.nama_stasiun
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    DropdownStasiun(
                        label = "Stasiun Tujuan",
                        leadIcon = Icons.Default.LocationOn,
                        dataDropdown = R.array.nama_stasiun
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    TimePickerScreen()
                    Spacer(modifier = Modifier.height(10.dp))
                    DropdownStasiun(
                        label = "Jumlah Kursi",
                        leadIcon = Icons.Default.Person,
                        dataDropdown = R.array.jumlah_penumpang
                    )
                    Spacer(modifier = Modifier.height(30.dp))
                    Button(
                        modifier = Modifier.width(320.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Color(0xFFFF5722),
                            contentColor = Color.White
                        ),
                        onClick = {
                            val intent = Intent(context, SearchResultActivity::class.java)
                            context.startActivity(intent) },
                    ) {
                        Text(text = "Cari Tiket")
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                }
            }
        }
    }
}
