package com.example.onsprofile

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.pager.PageSize
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Outline
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.Fill
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp



class CustomShapeCard(
    private val cornerRadius: Dp
) : Shape {

    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: androidx.compose.ui.unit.Density
    ): Outline {
        val cornerRadiusPx = with(density) { cornerRadius.toPx() }
        val lineLength1 = 720f
        val lineLength2 = 1f
        val path = Path().apply {
            moveTo(size.width, 0f)
            lineTo(lineLength1, 0f)
            arcTo(
                rect = Rect(
                    Offset(size.width - lineLength1 - cornerRadiusPx, 0f),
                    Size(cornerRadiusPx, cornerRadiusPx )
                ),
                startAngleDegrees = 270f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )

            lineTo(size.width - lineLength1 + 4f, cornerRadiusPx + lineLength2 )

            arcTo(
                rect = Rect(
                    Offset(size.width - lineLength1 + 6f, cornerRadiusPx + lineLength2),
                    Size(cornerRadiusPx, cornerRadiusPx)
                ),
                startAngleDegrees = 180f,
                sweepAngleDegrees = -90f,
                forceMoveTo = false
            )

            lineTo(size.width, cornerRadiusPx + lineLength2 + cornerRadiusPx)

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

            lineTo(cornerRadiusPx, size.height)

            arcTo(
                rect = Rect(
                    Offset(0f, size.height - cornerRadiusPx),
                    Size(cornerRadiusPx, cornerRadiusPx)
                ),
                startAngleDegrees = 90f,
                sweepAngleDegrees = 90f,
                forceMoveTo = false
            )

            lineTo(0f, cornerRadiusPx)

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
            .clip(CustomShapeCard(cornerRadius = 16.dp))
            .background(Color.Black)
    ) {

    }
}

@Preview
@Composable
fun PreviewCustomShapeCard() {

    CustomShapeCard()
}


@Composable
fun CustomShapeFilled() {
        Canvas(modifier = Modifier
            .width(48.dp)
            .height(83.dp)) {
            val path = Path().apply {
                // Convert dp to px
                val startX = 16.dp.toPx()
                val lineX = 48.dp.toPx()
                val arcRadius = 58.dp.toPx()
                val arc2Radius = 32.dp.toPx()
                val lineY = 83.dp.toPx()
                val arcStartY = 50.dp.toPx()

                // Start at (16.dp, 0.dp)
                moveTo(startX, 0f)

                // Draw a line to (48.dp, 0.dp)
                lineTo(lineX, 0f)

                // Draw a line to (48.dp, 48.dp)
                lineTo(lineX, arcRadius)

                // Draw the first arc from (48.dp, 48.dp)
                arcTo(
                    rect = Rect(
                        left = 0f,    // Left of the bounding box
                        top = 0f,     // Top of the bounding box
                        right = lineX,  // Right side of the bounding box (48.dp in px)
                        bottom = arcRadius // Bottom side of the bounding box (48.dp in px)
                    ),
                    startAngleDegrees = 0f,  // Starting angle of the arc (0 degrees)
                    sweepAngleDegrees = 50f, // Sweep the arc (50 degrees as an example)
                    forceMoveTo = false      // Don't force the move
                )

                // Draw a line down to (0.dp, 81.dp)
                lineTo(0f, lineY)

                // Draw a line to (0.dp, 50.dp)
                lineTo(0f, arcStartY)

                // Draw the second arc from (0.dp, 50.dp)
                arcTo(
                    rect = Rect(
                        left = 0f,      // Left of bounding box
                        top = 0f,       // Top of bounding box
                        right = arc2Radius,   // Right of bounding box (50.dp in px)
                        bottom = arc2Radius   // Bottom of bounding box (50.dp in px)
                    ),
                    startAngleDegrees = 180f,   // Starting angle at 180 degrees (left side)
                    sweepAngleDegrees = 90f,    // Sweep the arc 90 degrees clockwise
                    forceMoveTo = false         // Don't force the move
                )
            }

            // Fill the shape with black
            drawPath(
                path = path,
                color = Color(0xFFF2F9FF),
                style = Fill
            )
        }
    }

@Preview(showBackground = true)
@Composable
fun PreviewCustomShapeFilled() {
    CustomShapeFilled()
}