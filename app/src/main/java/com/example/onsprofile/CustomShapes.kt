package com.example.onsprofile

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp



class CustomShape(
    private val cornerRadius: Dp
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: androidx.compose.ui.unit.Density
    ): Outline {
        val cornerRadiusPx = with(density) { cornerRadius.toPx() }
        val lineLength1 = 720f
        val lineLength2 = 1f  // Updated line length from 6px to 4px

        val path = Path().apply {
            // Start at the top-right corner (0, 0)
            moveTo(size.width, 0f)

            // Move to (cornerRadius, 0)
            lineTo(lineLength1, 0f)

            // Draw the first arc (downward)
            arcTo(
                rect = Rect(
                    Offset(size.width - lineLength1 - cornerRadiusPx, 0f),
                    Size(cornerRadiusPx, cornerRadiusPx )
                ),
                startAngleDegrees = 270f, // 270 degrees to start downward
                sweepAngleDegrees = 90f, // 90 degrees arc
                forceMoveTo = false
            )

            // Draw the line with length of 4px downward (updated)
            lineTo(size.width - lineLength1 + 4f, cornerRadiusPx + lineLength2 )

            // Draw the second arc (towards right)
            arcTo(
                rect = Rect(
                    Offset(size.width - lineLength1 + 6f, cornerRadiusPx + lineLength2),
                    Size(cornerRadiusPx, cornerRadiusPx)
                ),
                startAngleDegrees = 180f, // 180 degrees to start rightward
                sweepAngleDegrees = -90f, // 90 degrees arc
                forceMoveTo = false
            )

            // Horizontal line to the top-right corner's arc start
            lineTo(size.width, cornerRadiusPx + lineLength2 + cornerRadiusPx)

            // Draw the arc at the top-right corner (downward)
            arcTo(
                rect = Rect(
                    Offset(size.width - cornerRadiusPx, cornerRadiusPx + lineLength2 + cornerRadiusPx),
                    Size(cornerRadiusPx, cornerRadiusPx)
                ),
                startAngleDegrees = 270f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )

            // Right vertical line to the bottom
            lineTo(size.width, size.height - cornerRadiusPx)

            // Bottom-right corner arc
            arcTo(
                rect = Rect(
                    Offset(size.width - cornerRadiusPx, size.height - cornerRadiusPx),
                    Size(cornerRadiusPx, cornerRadiusPx)
                ),
                startAngleDegrees = 0f, // 0 degrees to start moving leftward
                sweepAngleDegrees = 90f, // 90 degrees arc
                forceMoveTo = false
            )

            // Bottom horizontal line to the bottom-left arc start
            lineTo(cornerRadiusPx, size.height)

            // Bottom-left corner arc
            arcTo(
                rect = Rect(
                    Offset(0f, size.height - cornerRadiusPx),
                    Size(cornerRadiusPx, cornerRadiusPx)
                ),
                startAngleDegrees = 90f, // 90 degrees to start moving upward
                sweepAngleDegrees = 90f, // 90 degrees arc
                forceMoveTo = false
            )

            // Left vertical line to the top-left arc start
            lineTo(0f, cornerRadiusPx)

            // Draw the final arc to close the shape (top-left corner)
            arcTo(
                rect = Rect(
                    Offset(0f, 0f),
                    Size(cornerRadiusPx, cornerRadiusPx)
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )

            close()
        }

        return Outline.Generic(path)
    }
}


@Composable
fun CustomShapeCard() {
    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .height(113.dp)
            .clip(CustomShape(cornerRadius = 16.dp))
            .background(Color.Black)
    ) {

    }
}

@Preview
@Composable
fun PreviewCustomShapeCard() {

    CustomShapeCard()
}

