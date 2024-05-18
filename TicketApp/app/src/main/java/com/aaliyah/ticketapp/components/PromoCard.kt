package com.aaliyah.ticketapp.components


import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aaliyah.ticketapp.R

data class PromoItem(
    val id: Int,
    val judul: String,
    @DrawableRes val image: Int,
    val kodepromo: String,
    )

//data
val promoList = listOf(
    PromoItem(1, "Promo Spesial 12.12", R.drawable.satu,"KERETA1212"),
    PromoItem(2, "Promo Ramadhan Berkah", R.drawable.dua,"RAMADHANBERKAH"),
    PromoItem(3, "Spesial Hari Kemerdekaan", R.drawable.tiga,"MERDEKA77"),
    PromoItem(4, "Diskon Kereta Baru", R.drawable.empat,"KERETABARU3"),
    PromoItem(5, "Selamat Hari Kereta", R.drawable.lima,"HARIKERETANASIONAL"),
    PromoItem(6, "Promo Spesial 10.10", R.drawable.satu,"KERETA1212"),
    PromoItem(7, "Promo Libur Panjang", R.drawable.dua,"YUKLIBURAN"),
    PromoItem(8, "Spesial Hari Pahlawan", R.drawable.tiga,"HERODAYS24"),
    PromoItem(9, "Diskon Kereta Baru", R.drawable.empat,"KERETABARU5"),
    PromoItem(10, "Selamat Hari Kartini", R.drawable.empat,"KARTINIDAYS"),
)

@Composable
fun PromoCard(promoItem: PromoItem) {
    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RoundedCornerShape(10.dp),
        modifier = Modifier.padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(10.dp)
                .fillMaxHeight()
        ) {

            Image(
                painter = painterResource(id = promoItem.image),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(10.dp))
            )
            Spacer(modifier = Modifier.width(20.dp))
            Column(
                horizontalAlignment = Alignment.End,
                verticalArrangement = Arrangement.Top,
                modifier = Modifier
                    .weight(1f)
                    .height(100.dp)

            ) {
                PromoCopyButton(promoItem = promoItem)
                Column(
                    horizontalAlignment = Alignment.Start,
                    verticalArrangement = Arrangement.Top,
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxSize()

                ) {
                    Text(
                        text = promoItem.judul,
                        fontSize = 22.sp,
                        color = Color.DarkGray,
                        fontWeight = FontWeight.ExtraBold
                    )
                    Text(
                        text = "Kode promo: ${promoItem.kodepromo}",
                        fontSize = 16.sp,
                        color = Color.DarkGray
                    )
                }
            }
        }
    }
}

