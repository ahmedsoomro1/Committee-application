package com.example.commiteeapp

import androidx.activity.ComponentActivity
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.commiteeapp.ui.theme.MyApplicationKotlinTheme
import kotlinx.coroutines.delay


class spinwheel_screen: ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    @Composable
    fun SpinWheelScreen() {
        var spinning by remember { mutableStateOf(false) }
        var result by remember { mutableStateOf(0) }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Spinning Wheel
            SpinWheel(
                modifier = Modifier
                    .size(200.dp)
                    .background(MaterialTheme.colorScheme.primary),
                spinning = spinning,
                onResult = { number ->
                    result = number
                    spinning = false
                }
            )

            Spacer(modifier = Modifier.height(16.dp))

            // Spin Button
            Button(
                onClick = {
                    if (!spinning) {
                        spinning = true
                    }
                },
                colors = ButtonDefaults.buttonColors()
            ) {
                Row(
                    modifier = Modifier.padding(8.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(imageVector = Icons.Default.Refresh, contentDescription = null)
                    Spacer(modifier = Modifier.width(4.dp))
                    Text(text = "Spin", style = MaterialTheme.typography.bodyMedium)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            // Result
            Text(
                text = "Result: $result",
                style = MaterialTheme.typography.bodyMedium
            )
        }

        // Automatic random stop after 5 seconds
        LaunchedEffect(spinning) {
            if (spinning) {
                delay(5000)
                spinning = false
            }
        }
    }



    @Composable
    fun SpinWheel(
        modifier: Modifier = Modifier,
        spinning: Boolean,
        onResult: (Int) -> Unit
    ) {
        val rotationAngle = remember { Animatable(0f) }

        LaunchedEffect(spinning) {
            if (spinning) {
                rotationAngle.animateTo(
                    targetValue = 3600f,
                    animationSpec = infiniteRepeatable(
                        animation = tween(5000, easing = LinearEasing),
                        repeatMode = RepeatMode.Restart
                    )
                )
                delay(5000)
                val result = (0..9).random()
                onResult(result)
                rotationAngle.stop()

            }
        }

        Canvas(
            modifier = modifier
        ) {
            drawCircle(
                color = Color.White,
                center = center,
                radius = size.minDimension / 2f,
                style = Stroke(8.dp.toPx())
            )

            val colors = listOf(
                Color.Red,
                Color.Green,
                Color.Blue,
                Color.Yellow,
                Color.Magenta,
                Color.Cyan,
                Color.Gray,
                Color.Black,
                Color.White,
                Color.DarkGray
            )

            val arcSize = 360f / 10
            val arcRadius = size.minDimension / 2f - 16.dp.toPx()
            val arcStart = 270f - arcSize / 2
            val arcPadding = 2.dp.toPx()

            repeat(10) { index ->
                val startAngle = arcStart + index * arcSize + arcPadding
                val endAngle = startAngle + arcSize - 2 * arcPadding

                drawArc(
                    color = colors[index],
                    startAngle = startAngle,
                    sweepAngle = arcSize - 2 * arcPadding,
                    useCenter = true,
                    size = Size(arcRadius * 2, arcRadius * 2),
                    topLeft = Offset(center.x - arcRadius, center.y - arcRadius),
                    style = Stroke(8.dp.toPx())
                )
            }

            drawRoundRect(
                color = Color.Black,
                size = Size(20.dp.toPx(), 80.dp.toPx()),
                cornerRadius = CornerRadius(10.dp.toPx()),
                topLeft = Offset(center.x - 10.dp.toPx(), center.y - arcRadius - 40.dp.toPx())
            )

            drawCircle(
                color = Color.Black,
                center = center,
                radius = 8.dp.toPx()
            )

            drawCircle(
                color = Color.White,
                center = center,
                radius = 4.dp.toPx()
            )

            drawLine(
                color = Color.White,
                start = Offset(center.x, center.y - arcRadius),
                end = Offset(center.x, center.y - arcRadius - 40.dp.toPx()),
                strokeWidth = 2.dp.toPx()
            )

            drawLine(
                color = Color.White,
                start = Offset(center.x, center.y + arcRadius),
                end = Offset(center.x, center.y + arcRadius + 40.dp.toPx()),
                strokeWidth = 2.dp.toPx()
            )

            drawLine(
                color = Color.White,
                start = Offset(center.x - arcRadius, center.y),
                end = Offset(center.x - arcRadius - 40.dp.toPx(), center.y),
                strokeWidth = 2.dp.toPx()
            )

            drawLine(
                color = Color.White,
                start = Offset(center.x + arcRadius, center.y),
                end = Offset(center.x + arcRadius + 40.dp.toPx(), center.y),
                strokeWidth = 2.dp.toPx()
            )

            drawArc(
                color = Color.Black,
                startAngle = rotationAngle.value,
                sweepAngle = 2f,
                useCenter = true,
                size = Size(arcRadius * 2, arcRadius * 2),
                topLeft = Offset(center.x - arcRadius, center.y - arcRadius),
                style = Stroke(4.dp.toPx())
            )
        }
    }

    @Preview(showBackground = true)
    @Composable
    fun SpinWheelPreview() {
        MyApplicationKotlinTheme {
            SpinWheel(spinning = true, onResult = {})
        }
    }
}