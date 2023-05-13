package com.delusional_bear.dessertmaniac

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.StringRes
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.AlertDialogDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.delusional_bear.dessertmaniac.data.Dessert
import com.delusional_bear.dessertmaniac.model.DataSource
import com.delusional_bear.dessertmaniac.ui.theme.DessertManiacTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DessertManiacTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    DessertManiacApp()
                }
            }
        }
    }
}

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun DessertManiacApp(modifier: Modifier = Modifier) {
    Scaffold(
        topBar = {
            DessertManiacTopAppBar()
        },
        content = { paddingValues ->
            LazyVerticalStaggeredGrid(
                contentPadding = paddingValues,
                columns = StaggeredGridCells.Fixed(2),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier
                    .fillMaxSize()
                    .padding(dimensionResource(id = R.dimen.padding_small)),
                verticalItemSpacing = 8.dp,
            ) {
                items(DataSource.dessertList) { dessert ->
                    DessertCard(dessert = dessert)
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DessertManiacTopAppBar(modifier: Modifier = Modifier) {
    CenterAlignedTopAppBar(
        title = {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.cake_icon),
                    contentDescription = null,
                )
                Text(
                    text = stringResource(id = R.string.app_name),
                    style = MaterialTheme.typography.displayLarge,
                )
            }
        },
        modifier = modifier,
    )
}

@Composable
fun DessertCard(
    dessert: Dessert,
    modifier: Modifier = Modifier,
) {
    var expanded by remember { mutableStateOf(false) }
    var isDialogCalled by remember { mutableStateOf(false) }

    val backgroundColor by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.tertiaryContainer else MaterialTheme.colorScheme.primaryContainer
    )
    val textColor by animateColorAsState(
        targetValue = if (expanded) MaterialTheme.colorScheme.onTertiaryContainer else MaterialTheme.colorScheme.onSurface
    )

    Card(
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        modifier = modifier.clickable { expanded = !expanded }
    ) {
        Column(
            modifier = modifier
                .animateContentSize(
                    spring(
                        dampingRatio = Spring.DampingRatioNoBouncy,
                        stiffness = Spring.StiffnessLow,
                    )
                )
                .background(color = backgroundColor)
        ) {
            Row(
                modifier = modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    text = stringResource(id = dessert.dessertName),
                    style = MaterialTheme.typography.labelMedium,
                    modifier = modifier
                        .width(135.dp)
                        .padding(
                            top = dimensionResource(id = R.dimen.padding_small),
                            bottom = dimensionResource(id = R.dimen.padding_small),
                            start = dimensionResource(id = R.dimen.padding_small),
                        ),
                    color = textColor,
                )
                Spacer(modifier = Modifier.weight(1f))
                IconButton(onClick = { isDialogCalled = true }) {
                    Icon(
                        painter = painterResource(id = R.drawable.bookmark),
                        contentDescription = null,
                    )
                }
            }
            if (isDialogCalled) { DessertManiacAlertDialog(dessert = dessert) { isDialogCalled = false } }
            Image(
                painter = painterResource(id = dessert.dessertImage), 
                contentDescription = stringResource(id = dessert.dessertName),
                modifier = modifier.size(width = 300.dp, height = 175.dp)
            )
            if (expanded) {
                dessert.ingredients.forEach {
                    DessertManiacIngredientText(ingredient = it)
                }
            }
        }
    }
}

@Composable
fun DessertManiacIngredientText(
    @StringRes ingredient: Int,
    modifier: Modifier = Modifier
) {
    Text(
        text = stringResource(id = ingredient),
        modifier = modifier.padding(
            horizontal = dimensionResource(id = R.dimen.padding_small),
            vertical = 2.dp,
        ),
        style = MaterialTheme.typography.bodySmall,
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DessertManiacAlertDialog(
    modifier: Modifier = Modifier,
    dessert: Dessert,
    onDialogClick: () -> Unit,
) {
    AlertDialog(
        onDismissRequest = onDialogClick,
        content = {
            Surface(
                modifier = modifier
                    .wrapContentWidth()
                    .wrapContentHeight(),
                shape = MaterialTheme.shapes.large,
                tonalElevation = AlertDialogDefaults.TonalElevation
            ) {
                Column(modifier = modifier.padding(16.dp)) {
                    Text(
                        text = "\"${stringResource(id = dessert.dessertName)}\" has been added to \"Favorites\"",
                        style = MaterialTheme.typography.bodyMedium,
                        lineHeight = 22.sp,
                    )
                    Spacer(modifier = modifier.height(24.dp))
                    Row(
                        modifier = modifier.align(Alignment.End),
                    ) {
                        TextButton(
                            onClick = onDialogClick,
                            modifier = modifier,
                        ) {
                            Text(
                                text = stringResource(id = R.string.cancel),
                                style = MaterialTheme.typography.labelMedium,
                            )
                        }
                        TextButton(
                            onClick = onDialogClick,
                            modifier = modifier,
                        ) {
                            Text(
                                text = stringResource(id = R.string.confirm),
                                style = MaterialTheme.typography.labelMedium,
                            )
                        }
                    }

                }
            }
        },
    )
}

@Preview
@Composable
fun DessertManiacLightThemePreview() {
    DessertManiacTheme {
        DessertManiacApp()
    }
}

@Preview
@Composable
fun DessertManiacDarkThemePreview() {
    DessertManiacTheme(darkTheme = true) {
        DessertManiacApp()
    }
}
