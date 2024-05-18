package com.aaliyah.ticketapp.components

import android.content.Intent
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.aaliyah.ticketapp.screen.SearchResultActivity

data class Seat(
    val id: Int,
    val row: Int,
    val column: Int,
    var isSelected: Boolean = false,
    var isAvailable: Boolean = true
)


@Composable
fun Seat(
    seat: Seat,
    isSelected: Boolean,
    onSeatSelected: () -> Unit
) {
    val backgroundColor by rememberUpdatedState(
        if (isSelected) Color.Green else if (seat.isAvailable) Color.White else Color.Red
    )
    val textColor = if (isSelected) Color.White else Color.Black

    Box(
        modifier = Modifier
            .size(50.dp)
            .background(backgroundColor, shape = RoundedCornerShape(5.dp))
            .border(width = 1.5.dp, color = Color.DarkGray, shape = RoundedCornerShape(5.dp))
            .clickable(enabled = seat.isAvailable) {
                onSeatSelected()
            },
        contentAlignment = Alignment.Center
    ) {
        Text(text = seat.id.toString(), color = textColor)
    }
}


@Composable
fun SeatGrid(seats: List<Seat>, rows: Int, columns: Int) {
    val selectedSeats = remember { mutableStateListOf<Seat>() }

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxWidth()
    ) {
        items(rows) { row ->
            Row(
                horizontalArrangement = Arrangement.spacedBy(20.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                for (column in 0 until columns) {
                    if (column == 2) {
                        Spacer(modifier = Modifier.width(90.dp))
                    }
                    val seat = seats.find { it.row == row && it.column == column }
                    if (seat != null) {
                        val isSelected = selectedSeats.contains(seat)
                        Seat(
                            seat = seat,
                            isSelected = isSelected,
                            onSeatSelected = {
                                val newSelectionState = !isSelected
                                if (newSelectionState) {
                                    Log.d("SeatClick", "Seat ${seat.id} selected")
                                    selectedSeats.add(seat)
                                } else {
                                    Log.d("SeatClick", "Seat ${seat.id} deselected")
                                    selectedSeats.remove(seat)
                                }
                            }
                        )
                    }
                }
            }
        }
    }
}

