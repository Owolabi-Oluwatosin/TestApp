package com.dan.testapp.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun PostCard(){
    var content by remember { mutableStateOf("Post content...") }

    Column(modifier = Modifier.fillMaxWidth()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .size(width = 240.dp, height = 180.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(10.dp)
            ) {
                Text(
                    text = "Whats new?",
                    color = Color.Black,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Medium
                )
                Spacer(modifier = Modifier.padding(3.dp))
                OutlinedTextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    value = content,
                    onValueChange = { content = it },
                    label = { Text("Post content...") }
                )
                Spacer(modifier = Modifier.padding(3.dp))
//                ButtonWithColor()
                Button( modifier = Modifier
                    .fillMaxWidth(),
                    onClick = {
//                        viewModel.createPost(UserPost(content))
                    },elevation =  ButtonDefaults.elevation(
                        defaultElevation = 10.dp,
                        pressedElevation = 15.dp,
                        disabledElevation = 0.dp
                    ),
                    shape = RoundedCornerShape(8.dp),
                    colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF00acee)))
                {
                    Text(
                        text = "Create Post",
                        color = Color.White,
                        fontSize = 18.sp,
                    )
                }
            }
        }
    }
}

@Composable
fun ButtonWithColor(){
    Button( modifier = Modifier
        .fillMaxWidth(),
        onClick = {
//            viewModel.getPost(1)
    },elevation =  ButtonDefaults.elevation(
            defaultElevation = 10.dp,
            pressedElevation = 15.dp,
            disabledElevation = 0.dp
        ),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(backgroundColor = Color(0xFF00acee)))
    {
        Text(
            text = "Create Post",
            color = Color.White,
            fontSize = 18.sp,
        )
    }
}

