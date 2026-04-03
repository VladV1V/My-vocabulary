package com.example.myvocabulary.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = AccentSoft,
    onPrimary = DarkBackground,
    primaryContainer = AccentDark,
    onPrimaryContainer = DarkText,
    secondary = DarkMutedText,
    onSecondary = DarkBackground,
    secondaryContainer = DarkSurfaceVariant,
    onSecondaryContainer = DarkText,
    tertiary = Accent,
    onTertiary = DarkBackground,
    tertiaryContainer = AccentSoft,
    onTertiaryContainer = DarkBackground,
    background = DarkBackground,
    onBackground = DarkText,
    surface = DarkSurface,
    onSurface = DarkText,
    surfaceVariant = DarkSurfaceVariant,
    onSurfaceVariant = DarkMutedText,
    error = Danger,
    onError = DarkText,
    outline = DarkMutedText,
    outlineVariant = DarkSurfaceVariant
)

private val LightColorScheme = lightColorScheme(
    primary = Accent,
    onPrimary = SoftSurface,
    primaryContainer = AccentSoft,
    onPrimaryContainer = AccentDark,
    secondary = MutedText,
    onSecondary = SoftSurface,
    secondaryContainer = SoftSurfaceVariant,
    onSecondaryContainer = Ink,
    tertiary = AccentDark,
    onTertiary = SoftSurface,
    tertiaryContainer = AccentSoft,
    onTertiaryContainer = AccentDark,
    background = WarmBackground,
    onBackground = Ink,
    surface = SoftSurface,
    onSurface = Ink,
    surfaceVariant = SoftSurfaceVariant,
    onSurfaceVariant = MutedText,
    error = Danger,
    onError = SoftSurface,
    outline = Color(0xFFBEBEBE),
    outlineVariant = SoftSurfaceVariant
)

@Composable
fun MyVocabularyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
