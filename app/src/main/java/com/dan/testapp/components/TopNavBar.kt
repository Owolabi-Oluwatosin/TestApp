package com.dan.testapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.dan.testapp.data.remotes.models.usersignin.UserSignInResponse

@Composable
fun TopNavBar(details: UserSignInResponse) {
    Column(
        modifier = Modifier
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Id: ${details.user._id}",
            color = Color.Black,
            fontSize = 26.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Text(
            text = "Username: ${details.user.firstName} ${details.user.lastName}",
            color = Color.Black,
            fontSize = 26.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Text(
            text = "Email: ${details.user.email}",
            color = Color.Black,
            fontSize = 26.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Text(
            text = "Handle: ${details.user.handle}",
            color = Color.Black,
            fontSize = 26.sp,
            fontWeight = FontWeight.Medium
        )
        Spacer(modifier = Modifier.padding(20.dp))
        Text(
            text = "Role: ${details.user.role}",
            color = Color.Black,
            fontSize = 26.sp,
            fontWeight = FontWeight.Medium
        )
    }
}