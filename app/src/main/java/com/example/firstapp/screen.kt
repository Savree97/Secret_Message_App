package com.example.firstapp

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.selection.SelectionContainer
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
@Composable
fun EncoderDecoderApp() {

    var inputEncode by remember { mutableStateOf("") }
    var encodedResult by remember { mutableStateOf("") }

    var inputDecode by remember { mutableStateOf("") }
    var decodedResult by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()){
        Image(
            painter = painterResource(id = R.drawable.img),
            contentDescription = "Background Image",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize().alpha(0.2f)
        )

        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xBB000000))
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(24.dp),
            verticalArrangement = Arrangement.spacedBy(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Spacer(modifier = Modifier.height(40.dp))

            Text(
                text = "Secret Message App",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )

            Text(
                text = "Encode or decode your secret messages",
                fontSize = 13.sp,
                color = Color(0xFFAAAAAA),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(12.dp))

            OutlinedTextField(
                value = inputEncode,
                onValueChange = { inputEncode = it },
                label = { Text("Enter text to encode", color = Color.White) },
                textStyle = TextStyle(color = Color.White),
                modifier = Modifier.fillMaxWidth(),
            )

            Button(
                onClick = { encodedResult = encode(inputEncode) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color(0xFFFF6B3D)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Encode", color = Color.White, fontWeight = FontWeight.Bold, fontSize = 15.sp)
            }

            Text(
                text = encodedResult,
                fontSize = 15.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Text(
                text = "Decode Message",
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White
            )

            OutlinedTextField(
                value = inputDecode,
                onValueChange = { inputDecode = it },
                label = { Text("Enter text to decode", color = Color.White) },
                textStyle = TextStyle(color = Color.White),
                modifier = Modifier.fillMaxWidth(),
            )

            Button(
                onClick = { decodedResult = decode(inputDecode) },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(Color(0xFF9B6DFF)),
                shape = RoundedCornerShape(10.dp)
            ) {
                Text("Decode", color = Color.White, fontWeight = FontWeight.Bold)
            }

            Text(
                text = decodedResult,
                fontSize = 15.sp,
                color = Color.White,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

        }



    }
}
fun encode(input: String): String {
    return input.map { char ->
        (char.code + 2).toChar()
    }.joinToString("")
}

fun decode(input: String): String {
    return input.map { char ->
        (char.code - 2).toChar()
    }.joinToString("")
}