package com.rodrigosnds.gitrepo.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class Dimensions(
    // Padding
    val extraSmallPadding: Dp = 4.dp,
    val smallPadding: Dp = 12.dp,
    val normalPadding: Dp = 16.dp,
    val largePadding: Dp = 24.dp,
    val extraLargePadding: Dp = 36.dp,
    val hugePadding: Dp = 40.dp,
    // Text
    val extraSmallText: TextUnit = 12.sp,
    val smallText: TextUnit = 14.sp,
    val normalText: TextUnit = 16.sp,
    val largeText: TextUnit = 24.sp,
    val extraLargeText: TextUnit = 48.sp,
    val topBarTitle: TextUnit = 20.sp,
    val tripHash: TextUnit = 20.sp,
    // Label
    val labelRadius: Dp = 40.dp,
    val smallLabelVerticalPadding: Dp = 4.dp,
    val smallLabelHorizontalPadding: Dp = 8.dp,
    val labelVerticalPadding: Dp = 8.dp,
    val labelHorizontalPadding: Dp = 16.dp,
    // Button
    val normalButtonWidth: Dp = 235.dp,
    val normalButtonHeight: Dp = 42.dp,
    val buttonCorners: Dp = 4.dp,
    // Image
    val smallLogoWidth: Dp = 108.dp,
    val productImageSize: Dp = 40.dp,
    // Card
    val cardNormalElevation: Dp = 4.dp,
    val cardLargeElevation: Dp = 8.dp,
    val cardRadius: Dp = 12.dp,
    // Icon,
    val normalIconSize: Dp = 18.dp,
    val largeIconSize: Dp = 24.dp,
    // Others
    val flagSize: TextUnit = 20.sp,
    val digitWidth: Dp = 38.dp,
    val amountWidth: Dp = 64.dp,
    val amountHeight: Dp = 54.dp,
    val emptyListTextTopPadding: Dp = 66.dp,
    val fontOffset: Dp = (-4).dp,
    val smallIconPadding: Dp = 8.dp,
    val smallButtonPadding: Dp = 8.dp,
)

val dimens: Dimensions
    @Composable
    get() {
        val configuration = LocalConfiguration.current
        return when {
            configuration.screenHeightDp <= 700 -> smallDimensions
            configuration.screenHeightDp <= 960 -> normalDimensions
            else -> sw360Dimensions
        }
    }

private val smallDimensions = Dimensions()
private val normalDimensions = Dimensions()
private val sw360Dimensions = Dimensions()