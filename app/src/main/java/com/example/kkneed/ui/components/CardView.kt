package com.example.kkneed.ui

import android.annotation.SuppressLint
import androidx.annotation.StringRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.icons.outlined.Add
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.BlurredEdgeTreatment
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.example.kkneed.R
import com.example.kkneed.data.*
import com.example.kkneed.data.fake.fakeProduct
import com.example.kkneed.model.Product
import com.example.kkneed.navigation.AllScreen
import com.example.kkneed.ui.components.*
import com.example.kkneed.ui.theme.*
import com.example.kkneed.viewmodel.ProductViewModel

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SmallInfoCard(navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .height(108.dp)
            .clickable { },

        // ??????????????????????????????????????? CardDemo() ???????????? MaterialTheme ?????????
        // ???????????????????????????
        onClick = { navController.navigate(AllScreen.NoteDetail.route) },
        backgroundColor = Color.Transparent,
        elevation = 0.dp // ????????????
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(108.dp, 84.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.tiezi),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .size(95.dp),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopCenter,
                )
            }
            Column(
            ) {
                Text(
                    "??????????????????????????????????????????",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    "??????????????????????????????",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.outline
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp, 35.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Image(
                            painter = painterResource(R.drawable.dog),
                            contentDescription = "",
                            modifier = Modifier
                                .clip(RoundedCornerShape(50))
                                .size(32.dp),
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.TopCenter,
                        )
                    }
                    Text(
                        "??????Need",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }

    }
}

//??????????????????
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OrderInfoCard(
    orderNumber: String,
    state: String
) {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .clip(RoundedCornerShape(12.dp))
            .height(392.dp)
            .clickable { },

        // ??????????????????????????????????????? CardDemo() ???????????? MaterialTheme ?????????
        // ???????????????????????????
        onClick = {},
        backgroundColor = MaterialTheme.colorScheme.background,
        elevation = 0.dp // ????????????
    ) {
        Column() {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .size(380.dp, 39.dp)
            ) {
                Box(
                    contentAlignment = Alignment.CenterStart,

                    ) {
                    Text(
                        "????????????$orderNumber",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
                Box(
                    contentAlignment = Alignment.CenterEnd

                ) {
                    Text(
                        text = state,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.error
                    )
                }
            }
            SmallOrderInfoCard("????????????", 3, "??????:250ml", "???3.50")
            SmallOrderInfoCard("????????????", 3, "??????:250ml", "???3.50")
            SmallOrderInfoCard("????????????", 3, "??????:250ml", "???3.50")
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(
                    modifier = Modifier.size(24.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Icon(painter = painterResource(id = R.drawable.more_horiz), null)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Divider(modifier = Modifier.size(320.dp, 1.dp))
            }
            Box(modifier = Modifier.fillMaxSize())
            {
                Column(modifier = Modifier.padding(top = 16.dp)) {
                    Text(
                        text = "???4?????????",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onTertiaryContainer,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Text(
                        text = "????????????100.00",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onTertiaryContainer,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp),
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.Bottom
                    )
                    {
                        Text(
                            text = "????????????9???????????????",
                            style = MaterialTheme.typography.bodySmall,
                            color = MaterialTheme.colorScheme.outline
                        )
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color(0xFFFF897D)
                            ),
                            onClick = { /*TODO*/ }) {
                            Text(
                                "????????????",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.onError,
                            )
                        }
                    }
                }

            }


        }

    }
}


//???????????????????????????
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OrderInfoCard1(
    orderNumber: String,
    state: String
) {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .clip(RoundedCornerShape(12.dp))
            .height(392.dp)
            .clickable { },

        // ??????????????????????????????????????? CardDemo() ???????????? MaterialTheme ?????????
        // ???????????????????????????
        onClick = {},
        backgroundColor = MaterialTheme.colorScheme.background,
        elevation = 0.dp // ????????????
    ) {
        Column() {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .size(380.dp, 39.dp)
            ) {
                Box(
                    contentAlignment = Alignment.CenterStart,

                    ) {
                    Text(
                        "????????????$orderNumber",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
                Box(
                    contentAlignment = Alignment.CenterEnd

                ) {
                    Text(
                        text = state,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                }
            }
            SmallOrderInfoCard("????????????", 3, "??????:250ml", "???3.50")
            SmallOrderInfoCard("????????????", 3, "??????:250ml", "???3.50")
            SmallOrderInfoCard("????????????", 3, "??????:250ml", "???3.50")
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(
                    modifier = Modifier.size(24.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Icon(painter = painterResource(id = R.drawable.more_horiz), null)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Divider(modifier = Modifier.size(320.dp, 1.dp))
            }
            Box(modifier = Modifier.fillMaxSize())
            {
                Column(modifier = Modifier.padding(top = 16.dp)) {
                    Text(
                        text = "???4?????????",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onTertiaryContainer,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Text(
                        text = "????????????100.00",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onTertiaryContainer,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.Bottom
                    )
                    {
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            ),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground),
                            onClick = { /*TODO*/ }) {
                            Text(
                                "????????????",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.onBackground,
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            ),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                            onClick = { /*TODO*/ }) {
                            Text(
                                "????????????",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.primary,
                            )
                        }
                    }
                }

            }


        }

    }
}

//???????????????????????????
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OrderInfoCard2(
    orderNumber: String,
    state: String
) {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .clip(RoundedCornerShape(12.dp))
            .height(392.dp)
            .clickable { },

        // ??????????????????????????????????????? CardDemo() ???????????? MaterialTheme ?????????
        // ???????????????????????????
        onClick = {},
        backgroundColor = MaterialTheme.colorScheme.background,
        elevation = 0.dp // ????????????
    ) {
        Column() {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .size(380.dp, 39.dp)
            ) {
                Box(
                    contentAlignment = Alignment.CenterStart,

                    ) {
                    Text(
                        "????????????$orderNumber",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
                Box(
                    contentAlignment = Alignment.CenterEnd

                ) {
                    Text(
                        text = state,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }
            SmallOrderInfoCard("????????????", 3, "??????:250ml", "???3.50")
            SmallOrderInfoCard("????????????", 3, "??????:250ml", "???3.50")
            SmallOrderInfoCard("????????????", 3, "??????:250ml", "???3.50")
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(
                    modifier = Modifier.size(24.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Icon(painter = painterResource(id = R.drawable.more_horiz), null)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Divider(modifier = Modifier.size(320.dp, 1.dp))
            }
            Box(modifier = Modifier.fillMaxSize())
            {
                Column(modifier = Modifier.padding(top = 16.dp)) {
                    Text(
                        text = "???4?????????",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onTertiaryContainer,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Text(
                        text = "????????????100.00",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onTertiaryContainer,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.Bottom
                    )
                    {
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            ),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground),
                            onClick = { /*TODO*/ }) {
                            Text(
                                "????????????",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.onBackground,
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            ),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                            onClick = { /*TODO*/ }) {
                            Text(
                                "??????",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.primary,
                            )
                        }
                    }
                }

            }


        }

    }
}

//???????????????????????????
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun OrderInfoCard3(
    orderNumber: String,
    state: String
) {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .clip(RoundedCornerShape(12.dp))
            .height(392.dp)
            .clickable { },

        // ??????????????????????????????????????? CardDemo() ???????????? MaterialTheme ?????????
        // ???????????????????????????
        onClick = {},
        backgroundColor = MaterialTheme.colorScheme.background,
        elevation = 0.dp // ????????????
    ) {
        Column() {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .size(380.dp, 39.dp)
            ) {
                Box(
                    contentAlignment = Alignment.CenterStart,

                    ) {
                    Text(
                        "????????????$orderNumber",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
                Box(
                    contentAlignment = Alignment.CenterEnd

                ) {
                    Text(
                        text = state,
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.inversePrimary
                    )
                }
            }
            SmallOrderInfoCard("????????????", 3, "??????:250ml", "???3.50")
            SmallOrderInfoCard("????????????", 3, "??????:250ml", "???3.50")
            SmallOrderInfoCard("????????????", 3, "??????:250ml", "???3.50")
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(
                    modifier = Modifier.size(24.dp),
                    onClick = { /*TODO*/ }
                ) {
                    Icon(painter = painterResource(id = R.drawable.more_horiz), null)
                }
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Divider(modifier = Modifier.size(320.dp, 1.dp))
            }
            Box(modifier = Modifier.fillMaxSize())
            {
                Column(modifier = Modifier.padding(top = 16.dp)) {
                    Text(
                        text = "???4?????????",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.onTertiaryContainer,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Text(
                        text = "????????????100.00",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onTertiaryContainer,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 16.dp, end = 16.dp),
                        horizontalArrangement = Arrangement.End,
                        verticalAlignment = Alignment.Bottom
                    )
                    {
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            ),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground),
                            onClick = { /*TODO*/ }) {
                            Text(
                                "????????????",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.onBackground,
                            )
                        }
                        Spacer(modifier = Modifier.width(8.dp))
                        Button(
                            colors = ButtonDefaults.buttonColors(
                                containerColor = Color.Transparent
                            ),
                            border = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
                            onClick = { /*TODO*/ }) {
                            Text(
                                "?????????",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.primary,
                            )
                        }
                    }
                }

            }


        }

    }
}

//???????????????
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun SmallOrderInfoCard(
    title: String,
    number: Int,
    configuration: String,
    price: String
) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(12.dp))
            .height(72.dp)
            .clickable { },

        // ??????????????????????????????????????? CardDemo() ???????????? MaterialTheme ?????????
        // ???????????????????????????
        onClick = {},
        backgroundColor = MaterialTheme.colorScheme.background,
        elevation = 0.dp // ????????????
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, end = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(56.dp, 56.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.head),
                    contentDescription = "",
                    modifier = Modifier
                        .size(56.dp),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopCenter,
                )
            }
            Column(
                modifier = Modifier.size(188.dp, 56.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .size(188.dp, 24.dp)
                ) {
                    Box() {
                        Text(
                            text = title,
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                    Spacer(modifier = Modifier.height(12.dp))
                    Box() {
                        Text(
                            text = "x$number",
                            style = MaterialTheme.typography.titleMedium,
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }
                Text(
                    text = configuration,
                    style = MaterialTheme.typography.labelLarge,
                    color = MaterialTheme.colorScheme.outline
                )
            }
            Box(modifier = Modifier.size(64.dp, 56.dp), contentAlignment = Alignment.CenterEnd) {
                Text(
                    text = price,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onTertiaryContainer
                )
            }
        }


    }

}

@Composable
fun TestCard() {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .height(208.dp),
        backgroundColor = Color(0xFFFFFF),
        border = BorderStroke(1.dp, color = Color(0x25FFFFFF)),
        elevation = 0.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .alpha(1f)
                .blur(
                    radius = 28.dp,
                    edgeTreatment = BlurredEdgeTreatment.Unbounded
                )
                .background(
                    Brush.radialGradient(
                        listOf(
                            Color(0x12FFFFFF),
                            Color(0xDFFFFFF),
                            Color(0x9FFFFFFF)
                        ),
                        radius = 2200f,
                        center = Offset.Infinite
                    )
                )
        ) {}
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 16.dp)
        ) {
            Box(
                modifier = Modifier
                    .size(108.dp, 84.dp)
            ) {
                Image(
                    painter = painterResource(R.drawable.head),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .size(95.dp),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.TopCenter,
                )
            }
            Column(
            ) {
                Text(
                    "??????????????????????????????????????????",
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    "??????????????????????????????",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.outline
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Box(
                        modifier = Modifier
                            .size(40.dp, 35.dp),
                        contentAlignment = Alignment.CenterStart
                    ) {
                        Image(
                            painter = painterResource(R.drawable.head),
                            contentDescription = "",
                            modifier = Modifier
                                .clip(RoundedCornerShape(50))
                                .size(32.dp),
                            contentScale = ContentScale.Crop,
                            alignment = Alignment.TopCenter,
                        )
                    }
                    Text(
                        "??????Need",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.primary
                    )
                }
            }
        }
    }
}

//?????????????????????
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShopScreenMainCard(navController: NavController) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp) // ?????????
            .clickable { }
            .clip(RoundedCornerShape(12.dp))
            .height(160.dp),

        // ??????????????????????????????????????? CardDemo() ???????????? MaterialTheme ?????????
        // ???????????????????????????

        elevation = 1.dp, // ????????????
        onClick = { navController.navigate(AllScreen.ShopDetail.route) },
        backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 0.dp)
        )
        {
            Image(
                painter = painterResource(R.drawable.product),
                contentDescription = "",
                modifier = Modifier
                    .clip(RoundedCornerShape(12))
                    .size(160.dp),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter,
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .height(131.dp)
                    .width(197.dp)
                    .fillMaxHeight()
            ) {
                androidx.compose.material3.Text(
                    "??????????????????????????????????????????400g",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(Modifier.height(9.dp))
                Image(
                    painter = painterResource(R.drawable.alevel),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12))
                        .height(45.dp)
                        .width(84.dp),
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.TopCenter,
                )
                Spacer(Modifier.height(9.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .width(197.dp)
                        .fillMaxWidth()
                        .fillMaxHeight()
                        .height(28.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,

                    ) {
                    androidx.compose.material3.Text(
                        "???34.6",
                        style = MaterialTheme.typography.titleLarge,
                        color = MaterialTheme.colorScheme.error
                    )
                    androidx.compose.material3.Text(
                        "??????1.6w+",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.outline
                    )
                }
            }
        }
    }
}

//???????????????
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LabelCard1() {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .size(184.dp, 266.dp),
        backgroundColor = Color(0xFFFFFF),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.primary),
        elevation = 0.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.jichubing),
                contentDescription = "",
                modifier = Modifier
                    .size(184.dp, 134.dp),
                contentScale = ContentScale.Fit,
                alignment = Alignment.TopCenter,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "????????????",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
            Row() {
                QuestionChip(state = false, title = "?????????")
                Spacer(modifier = Modifier.width(4.dp))
                QuestionChip(state = true, title = "?????????")
            }
            Row() {
                QuestionChip(state = true, title = "????????????")
                Spacer(modifier = Modifier.width(4.dp))
                QuestionChip(state = true, title = "??????")
            }


        }
    }
}

//????????????
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LabelCard2() {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .size(184.dp, 210.dp),
        backgroundColor = Color(0xFFFFFF),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.primary),
        elevation = 0.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.jianfei),
                contentDescription = "",
                modifier = Modifier
                    .size(184.dp, 124.dp),
                contentScale = ContentScale.Fit,
                alignment = Alignment.TopCenter,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "????????????",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
            Row() {
                QuestionChip(state = false, title = "??????")
                Spacer(modifier = Modifier.width(4.dp))
                QuestionChip(state = false, title = "??????")
            }
        }
    }
}

//?????????????????????
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun LabelCard3() {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .size(184.dp, 210.dp),
        backgroundColor = Color(0xFFFFFF),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.primary),
        elevation = 0.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.nvxing),
                contentDescription = "",
                modifier = Modifier
                    .size(184.dp, 124.dp),
                contentScale = ContentScale.Fit,
                alignment = Alignment.TopCenter,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "???????????????",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
            Row() {
                QuestionChip(state = true, title = "??????/??????")
                Spacer(modifier = Modifier.width(4.dp))
                QuestionChip(state = false, title = "?????????")
            }

        }
    }
}

//??????????????????
@Composable
fun LabelCard4() {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .size(184.dp, 266.dp),
        backgroundColor = Color(0xFFFFFF),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.primary),
        elevation = 0.dp,
        shape = RoundedCornerShape(16.dp)
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Image(
                painter = painterResource(R.drawable.other),
                contentDescription = "",
                modifier = Modifier
                    .size(184.dp, 134.dp),
                contentScale = ContentScale.Fit,
                alignment = Alignment.TopCenter,
            )
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    "????????????",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold)
                )
            }
            Row() {
                QuestionChip(state = true, title = "??????")
                Spacer(modifier = Modifier.width(4.dp))
                QuestionChip(state = false, title = "????????????")
            }
            Row() {
                QuestionChip(state = false, title = "????????????")
            }
        }
    }
}

//??????????????????
@Composable
fun CommentCard() {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .size(380.dp, 98.dp)
            .clickable { },
        backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
        elevation = 1.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            Image(
                painter = painterResource(R.drawable.head),
                contentDescription = "",
                modifier = Modifier
                    .size(40.dp, 40.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter,
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "??????need",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        "29??????",
                        color = MaterialTheme.colorScheme.outline,
                        style = MaterialTheme.typography.titleSmall
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row() {
                    Icon(
                        painter = painterResource(id = R.drawable.fillstar), null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(12.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.fillstar), null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(12.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.fillstar), null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(12.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.fillstar), null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(12.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.outlinestar), null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(12.dp)
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    "???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????",
                    maxLines = 2,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    style = MaterialTheme.typography.bodySmall
                )


            }
        }
    }
}

//????????????????????????
@Composable
fun ImageCommentCard() {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .size(380.dp, 206.dp)
            .clickable { },
        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
        elevation = 1.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            Image(
                painter = painterResource(R.drawable.head),
                contentDescription = "",
                modifier = Modifier
                    .size(40.dp, 40.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter,
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 12.dp)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "??????need",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.titleSmall
                    )
                    Text(
                        "29??????",
                        color = MaterialTheme.colorScheme.outline,
                        style = MaterialTheme.typography.titleSmall
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Row() {
                    Icon(
                        painter = painterResource(id = R.drawable.fillstar), null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(12.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.fillstar), null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(12.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.fillstar), null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(12.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.fillstar), null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(12.dp)
                    )
                    Icon(
                        painter = painterResource(id = R.drawable.outlinestar), null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(12.dp)
                    )
                }
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    "???????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????????",
                    maxLines = 2,
                    color = MaterialTheme.colorScheme.onSecondaryContainer,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    "??????v",
                    maxLines = 2,
                    color = MaterialTheme.colorScheme.primary,
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                    Image(
                        painter = painterResource(R.drawable.cola),
                        contentDescription = "",
                        modifier = Modifier
                            .size(80.dp),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                    )
                    Image(
                        painter = painterResource(R.drawable.cola),
                        contentDescription = "",
                        modifier = Modifier
                            .size(80.dp),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                    )
                    Image(
                        painter = painterResource(R.drawable.cola),
                        contentDescription = "",
                        modifier = Modifier
                            .size(80.dp),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                    )
                }


            }
        }
    }
}

//?????????????????????
@Composable
fun DetailCard(title: String, description: String) {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .size(380.dp, 127.dp),
        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
        elevation = 1.dp,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(
            1.dp, brush = Brush.verticalGradient(
                listOf(
                    MaterialTheme.colorScheme.primary, // ????????????????????????
                    MaterialTheme.colorScheme.secondaryContainer,
                )
            )
        )
    ) {
        Column(
            modifier = Modifier.padding(start = 16.dp, top = 8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                title,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
            )
            Row() {
                Image(
                    painter = painterResource(R.drawable.dog),
                    contentDescription = "",
                    modifier = Modifier
                        .size(48.dp, 48.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    contentScale = ContentScale.Crop,
                    alignment = Alignment.CenterStart,
                )

                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 8.dp, end = 16.dp)
                        .clip(RoundedCornerShape(12.dp)),
                    color = Color.White
                ) {
                    Text(
                        description,
                        modifier = Modifier.padding(8.dp),
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.bodyMedium
                    )
                }
            }
        }
    }
}

//?????????????????????
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailShopCard() {
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .size(380.dp, 98.dp)
            .clickable { }
            .clip(RoundedCornerShape(12.dp)),

        // ??????????????????????????????????????? CardDemo() ???????????? MaterialTheme ?????????
        // ???????????????????????????

        elevation = 0.dp, // ????????????
        onClick = {},
        backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 16.dp, top = 8.dp, end = 16.dp)
        )
        {
            Image(
                painter = painterResource(R.drawable.cola),
                contentDescription = "",
                modifier = Modifier
                    .clip(RoundedCornerShape(12))
                    .size(64.dp),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
            ) {

                androidx.compose.material3.Text(
                    "??????????????????????????????????????????400g",
                    modifier = Modifier.width(200.dp),
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onBackground,
                    maxLines = 2
                )
                Spacer(modifier = Modifier.height(8.dp))
                androidx.compose.material3.Text(
                    "???34.6",
                    style = MaterialTheme.typography.titleLarge.copy(fontWeight = FontWeight.Bold),
                    color = MaterialTheme.colorScheme.error
                )
            }


            Column(
                modifier = Modifier
                    .width(45.dp)
                    .fillMaxWidth(),
            ) {

                Image(
                    painter = painterResource(R.drawable.alevel),
                    contentDescription = "",
                    modifier = Modifier
                        .size(45.dp, 26.dp),
                    contentScale = ContentScale.Fit
                )
                Spacer(modifier = Modifier.height(8.dp))
                androidx.compose.material.Surface(
                    shape = RoundedCornerShape(12),
                    modifier = Modifier.size(36.dp)
                ) {
                    IconButton(
                        colors = IconButtonDefaults.iconButtonColors(
                            containerColor = Color.White
                        ),
                        onClick = { /*TODO*/ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.shoppingcart), null,
                            tint = MaterialTheme.colorScheme.primary
                        )
                    }
                }

            }

        }
    }
}

//??????????????????
@Composable
fun ProductCard(title: String) {
    Card(
        modifier = Modifier
            .clip(RoundedCornerShape(12.dp))
            .size(148.dp, 170.dp),
        backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
        border = BorderStroke(1.dp, color = MaterialTheme.colorScheme.primary),
        elevation = 0.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(R.drawable.baishi),
                contentDescription = "",
                modifier = Modifier
                    .size(132.dp, 102.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Fit,
                alignment = Alignment.TopCenter,
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                title,
                color = MaterialTheme.colorScheme.onBackground,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(modifier = Modifier.height(4.dp))
            Row(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Image(
                    painter = painterResource(R.drawable.alevel),
                    contentDescription = "",
                    modifier = Modifier
                        .size(43.dp, 24.dp),
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.TopCenter,
                )
                GradientButton(modifier = Modifier
                    .height(24.dp)
                    .fillMaxWidth(0.6f),
                    textId = "??????", onClick = {

                    }
                )
            }
        }
    }
}

//??????????????????
@Composable
fun NutritionCard(product: Product, viewModel: ProductViewModel = hiltViewModel()) {
    val compareProduct = viewModel.queryProductScore(product.scoreGrade) ?: fakeProduct
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .size(360.dp, 260.dp),
        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
        elevation = 1.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 12.dp, end = 16.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier.size(30.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.balance), null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.Center)
                    )

                }
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    "????????????",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column() {
                    Text(
                        "????????????",
                        color = MaterialTheme.colorScheme.outline,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "??????",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "?????????",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "???????????????",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "??????",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "???",
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.bodySmall
                    )
                }

                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        "100g",
                        color = MaterialTheme.colorScheme.outline,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        product.nutriments.energyKj100g.toString() + product.nutriments.energyKjUnit,
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        product.nutriments.proteins100g.toString(),
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        product.nutriments.carbohydrates100g.toString(),
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        product.nutriments.fat100g.toString(),
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        product.nutriments.sodium100g.toString(),
                        color = MaterialTheme.colorScheme.onBackground,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Text(
                        "?????????????????????",
                        color = MaterialTheme.colorScheme.outline,
                        style = MaterialTheme.typography.titleMedium
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(
                        "-1.3%",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "+2%",
                        color = MaterialTheme.colorScheme.error,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "-5%",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "-100%",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodySmall
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        "-100%",
                        color = MaterialTheme.colorScheme.primary,
                        style = MaterialTheme.typography.bodySmall
                    )
                }
            }
        }
    }
}

//??????????????????
@Composable
fun ComponentCard(product: Product) {
    var ingredientText: String = ""
    for (ingredient in product.ingredients) {
        ingredientText = ingredientText + ingredient.text + ","
    }
    ingredientText = ingredientText.dropLast(1)
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .size(360.dp, 260.dp),
        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
        elevation = 1.dp,
        shape = RoundedCornerShape(12.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 16.dp, top = 12.dp, end = 16.dp),
            horizontalAlignment = Alignment.Start,
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Box(
                    modifier = Modifier.size(30.dp)
                ) {
                    Icon(
                        painter = painterResource(id = R.drawable.reference), null,
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier
                            .size(24.dp)
                            .align(Alignment.Center)
                    )

                }
                Spacer(modifier = Modifier.width(12.dp))
                Text(
                    "??????????????????${product.ingredients.size}????????????",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleMedium
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Column {
                Text(
                    ingredientText,
                    color = MaterialTheme.colorScheme.outline,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(8.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(12.dp))
                        .background(color = MaterialTheme.colorScheme.inverseOnSurface)
                ) {
                    Column(modifier = Modifier.padding(start = 16.dp, top = 12.dp)) {
                        Text(
                            "????????????",
                            color = MaterialTheme.colorScheme.onBackground,
                            style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
                        )
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(
                            product.categories,
                            color = MaterialTheme.colorScheme.primary,
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                }
            }
        }
    }
}

//??????????????????
@OptIn(ExperimentalCoilApi::class)
@Composable
fun CompareCard(
    navController: NavController,
    productName: String,
    productImage: String,
    productScore: String,
) {
    val matchLevel = findLevel(productScore)
    Card(
        modifier = Modifier
            .clickable { }
            //.padding(start = 16.dp, end = 16.dp)
            .size(176.dp, 300.dp),
        backgroundColor = Color.White,
        elevation = 0.dp,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(0.dp, color = Color.Transparent)
    ) {
        Column(
            modifier = Modifier.padding(top = 8.dp, bottom = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Image(
                painter = rememberImagePainter(
                    data = productImage,
                    builder = {
                        placeholder(R.drawable.logo)
                        error(R.drawable.logo)
                    },
                ),
                contentDescription = "",
                modifier = Modifier
                    .size(160.dp, 160.dp)
                    .clip(RoundedCornerShape(12.dp)),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter,
            )
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 8.dp, end = 8.dp),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(
                    productName,
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold)
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth(), horizontalArrangement = Arrangement.Center
            )
            {
                Image(
                    painter = painterResource(matchLevel.gradeImage),
                    contentDescription = "",
                    modifier = Modifier
                        .size(94.dp, 53.dp),
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.TopCenter,
                )
            }
        }
    }
}

//????????????????????????
@Composable
fun NutriCompareCard(productLeft: Product, productRight: Product) {
    val fat = productCalculator(productLeft.nutriments.fat100g!!, productRight.nutriments.fat100g!!)
    val sodium = productCalculator(productLeft.nutriments.sodium100g!!, productRight.nutriments.sodium100g!!)
    val energy = productCalculator(productLeft.nutriments.energyKj100g!!, productRight.nutriments.energyKj100g!!)
    val carbohydrates =
        productCalculator(productLeft.nutriments.carbohydrates100g!!, productRight.nutriments.carbohydrates100g!!)
    val proteins = productCalculator(productLeft.nutriments.proteins100g!!, productRight.nutriments.proteins100g!!)
    val list = listOf<Float>(
        randomNumFloat(),randomNumFloat(),
        randomNumFloat(),randomNumFloat(),
        randomNumFloat(),randomNumFloat(),
        randomNumFloat(),randomNumFloat(),
        randomNumFloat(),randomNumFloat(),
    )
    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .size(380.dp, 300.dp),
        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
        elevation = 1.dp,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(
            1.dp, brush = Brush.verticalGradient(
                listOf(
                    MaterialTheme.colorScheme.primary, // ????????????????????????
                    MaterialTheme.colorScheme.secondaryContainer,
                )
            )
        )
    ) {
        Column(
            modifier = Modifier.padding(top = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(
                    modifier = Modifier.width(66.dp),
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    "??????????????????",
                    modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                Divider(
                    modifier = Modifier.width(66.dp),
                    color = MaterialTheme.colorScheme.primary
                )
            }
            BarChart(
                data = mapOf(
                    Pair(list[0], list[1]),
                    Pair(list[2], list[3]),
                    Pair(list[4], list[5]),
                    Pair(list[6], list[7]),
                    Pair(list[8], list[9]),
                )
            )
        }
    }
}

//?????????????????????
@Composable
fun ComponentCompareCard(productLeft: Product, productRight: Product) {
    val isSugarLeft = ingredientAnalyserSugar(productLeft, R.drawable.checkfalse)
    val isSaFatLeft = ingredientAnalyserSaFat(productLeft, R.drawable.checkfalse)
    val isSugarRight = ingredientAnalyserSugar(productRight, R.drawable.checkfalse)
    val isSaFatRight = ingredientAnalyserSaFat(productRight, R.drawable.checkfalse)

    Card(
        modifier = Modifier
            .padding(start = 16.dp, end = 16.dp)
            .size(380.dp, 220.dp),
        backgroundColor = MaterialTheme.colorScheme.secondaryContainer,
        elevation = 1.dp,
        shape = RoundedCornerShape(12.dp),
        border = BorderStroke(
            1.dp, brush = Brush.verticalGradient(
                listOf(
                    MaterialTheme.colorScheme.primary, // ????????????????????????
                    MaterialTheme.colorScheme.secondaryContainer,
                )
            )
        )
    ) {
        Column(
            modifier = Modifier.padding(top = 8.dp),
            horizontalAlignment = Alignment.Start,
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Divider(
                    modifier = Modifier.width(66.dp),
                    color = MaterialTheme.colorScheme.primary
                )
                Text(
                    "???????????????",
                    modifier = Modifier.padding(start = 4.dp, end = 4.dp),
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold)
                )
                Divider(
                    modifier = Modifier.width(66.dp),
                    color = MaterialTheme.colorScheme.primary
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 8.dp, bottom = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    productLeft.ingredients.size.toString(),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    "????????????",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyLarge
                )
                Text(
                    productRight.ingredients.size.toString(),
                    color = MaterialTheme.colorScheme.onSurface,
                    style = MaterialTheme.typography.bodyLarge
                )
            }
            Divider()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = isSugarLeft),
                    null
                )
                Text(
                    "??????????????????",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyLarge
                )
                Image(
                    painter = painterResource(id = isSugarRight),
                    null
                )
            }
            Divider()
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = isSaFatLeft), null
                )
                Text(
                    "?????????????????????",
                    color = MaterialTheme.colorScheme.onBackground,
                    style = MaterialTheme.typography.bodyLarge
                )
                Image(
                    painter = painterResource(id = isSaFatRight), null
                )
            }
        }
    }
}

//??????????????????
@OptIn(ExperimentalCoilApi::class)
@Composable
fun HistoryCard(
    navController: NavController,
    productName: String,
    productImage: String,
    productCode: String,
    productScore: String,
) {
    val matchLevel = findLevel(productScore)
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 4.dp) // ?????????
            .clip(RoundedCornerShape(12.dp))
            .height(136.dp),
        elevation = 2.dp, // ????????????
        backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 16.dp)
        )
        {
            Image(
                painter = rememberImagePainter(
                    data = productImage,
                    builder = {
                        placeholder(R.drawable.logo)
                        error(R.drawable.logo)
                    },
                ),
                contentDescription = "",
                modifier = Modifier
                    .clip(RoundedCornerShape(12))
                    .size(80.dp),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, top = 8.dp)
                    .width(197.dp)
                    .fillMaxHeight()
            ) {
                androidx.compose.material3.Text(
                    text = productName,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(Modifier.height(8.dp))
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .width(197.dp)
                        .fillMaxWidth()
                        .height(20.dp),
                    horizontalArrangement = Arrangement.spacedBy(4.dp),

                    ) {
                    Box(
                        modifier = Modifier
                            .clip(CircleShape)
                            .background(matchLevel.matchColor)
                            .size(20.dp)
                    )
                    androidx.compose.material3.Text(
                        text = matchLevel.matchText,
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.onBackground
                    )
                }
                Spacer(Modifier.height(8.dp))
                Image(
                    painter = painterResource(matchLevel.gradeImage),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12))
                        .height(45.dp)
                        .width(84.dp),
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.TopCenter,
                )
            }
            IconButton(
                onClick = {
                    navController.navigate(AllScreen.ScanResult.route + "/${productCode}")
                }
            ) {
                Icon(Icons.Default.ArrowRight, "info")
            }

        }
    }
}

//??????????????????
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun EditCard() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp) // ?????????
            .clickable { }
            .clip(RoundedCornerShape(12.dp))
            .height(96.dp),

        // ??????????????????????????????????????? CardDemo() ???????????? MaterialTheme ?????????
        // ???????????????????????????

        elevation = 2.dp, // ????????????
        onClick = {},
        backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(start = 16.dp, end = 16.dp)
        )
        {
            Image(
                painter = painterResource(R.drawable.head),
                contentDescription = "",
                modifier = Modifier
                    .clip(RoundedCornerShape(12))
                    .size(60.dp),
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center,
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, end = 8.dp, top = 8.dp, bottom = 8.dp)
                    .fillMaxHeight(),
                verticalArrangement = Arrangement.SpaceBetween
            ) {
                androidx.compose.material3.Text(
                    "??????????????????????????????????????????400g",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(Modifier.height(8.dp))
                Image(
                    painter = painterResource(R.drawable.blevel),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12))
                        .height(45.dp)
                        .width(84.dp),
                    contentScale = ContentScale.Fit
                )
            }

        }
    }
}

//???????????????
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ShopCartCard() {

    val checkedState = remember {
        mutableStateOf(true)
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, bottom = 8.dp) // ?????????
            .clickable { }
            .clip(RoundedCornerShape(12.dp))
            .height(160.dp),

        // ??????????????????????????????????????? CardDemo() ???????????? MaterialTheme ?????????
        // ???????????????????????????

        elevation = 1.dp, // ????????????
        onClick = {},
        backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .padding(end = 4.dp)
                .fillMaxSize(),
            horizontalArrangement = Arrangement.SpaceAround
        )
        {
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                modifier = Modifier.padding(0.dp),
            )
            Image(
                painter = painterResource(R.drawable.head),
                contentDescription = "",
                modifier = Modifier
                    .clip(RoundedCornerShape(12))
                    .size(120.dp),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter,
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp, end = 0.dp)
                    .height(130.dp)
                    .width(150.dp)
                    .fillMaxHeight()
            ) {
                androidx.compose.material3.Text(
                    "??????????????????????????????????????????400g",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface
                )
                Spacer(Modifier.height(9.dp))
                Image(
                    painter = painterResource(R.drawable.alevel),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12))
                        .height(45.dp)
                        .width(84.dp),
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.TopCenter,
                )
                Spacer(Modifier.height(9.dp))
                androidx.compose.material3.Text(
                    "???34.6",
                    style = MaterialTheme.typography.titleLarge,
                    color = MaterialTheme.colorScheme.error
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .padding(start = 0.dp)
                    .background(MaterialTheme.colorScheme.background)
                    .height(128.dp)
                    .width(28.dp)
                    .clip(MaterialTheme.shapes.small),
                verticalArrangement = Arrangement.SpaceAround
            ) {
                androidx.compose.material3.Icon(Icons.Outlined.Add, null)
                androidx.compose.material3.Text(
                    "01",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                )
                androidx.compose.material3.Icon(Icons.Outlined.Add, null)
            }
        }
    }
}

//??????????????????
@SuppressLint("ResourceType")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeCommunityCard(@StringRes imageId: Int, title: String, description: String, navController: NavController) {


    Card(
        modifier = Modifier
            .padding(horizontal = 4.dp, vertical = 8.dp) // ?????????
            .clickable { }
            .clip(RoundedCornerShape(12.dp))
            .height(289.dp)
            .width(250.dp),

        // ??????????????????????????????????????? CardDemo() ???????????? MaterialTheme ?????????
        // ???????????????????????????

        elevation = 1.dp, // ????????????
        onClick = { navController.navigate(AllScreen.NoteDetail.route) },
        backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
    ) {
        Column() {
            Image(
                painter = painterResource(imageId),
                contentDescription = "",
                modifier = Modifier
                    .clip(RoundedCornerShape(12))
                    .width(250.dp)
                    .height(125.dp),
                contentScale = ContentScale.Crop,
                alignment = Alignment.TopCenter,
            )
            Column(
                modifier = Modifier
                    .padding(
                        start = 16.dp,
                        end = 16.dp,
                        top = 16.dp,
                        bottom = 12.dp
                    )
                    .fillMaxSize()
            ) {
                androidx.compose.material3.Text(
                    title,
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                )
                Spacer(modifier = Modifier.height(8.dp))
                androidx.compose.material3.Text(
                    description,
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.outline,
                )
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .width(126.dp)
                        .height(24.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(R.drawable.profile),
                        contentDescription = "",
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(24.dp),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.TopCenter,
                    )
                    androidx.compose.material3.Text(
                        "??????Need?????????",
                        modifier=Modifier.padding(start = 4.dp),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.outline,
                    )
                }
                Spacer(modifier = Modifier.height(8.dp))
                Row(
                    modifier = Modifier
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                )
                {
                    IconButton(onClick = {navController.navigate(AllScreen.NoteDetail.route) }) {
                        androidx.compose.material3.Icon(
                            painter = painterResource(id = R.drawable.tabs),
                            modifier = Modifier.size(24.dp),
                            contentDescription = "Localized description",
                            tint = MaterialTheme.colorScheme.onSecondaryContainer
                        )
                    }
                    androidx.compose.material3.Text(
                        "300",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.outline,
                    )
                    Spacer(modifier = Modifier.width(10.dp))
                    var change by remember { mutableStateOf(false) }
                    var flag by remember { mutableStateOf(false) }

                    val buttonSize by animateDpAsState(
                        targetValue = if (change) 32.dp else 24.dp
                    )
                    if (buttonSize == 32.dp) {
                        change = false
                    }
                    IconButton(
                        onClick = {
                            change = true
                            flag = !flag
                        }
                    ) {
                        androidx.compose.material3.Icon(
                            Icons.Rounded.Favorite,
                            contentDescription = null,
                            modifier = Modifier.size(buttonSize),
                            tint = if (flag) Color.Red else MaterialTheme.colorScheme.outline
                        )
                    }
                    androidx.compose.material3.Text(
                        "300",
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.outline,
                    )
                }
            }
        }
    }
}

//????????????????????????
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeFoodCard(navController: NavController) {
    Card(
        modifier = Modifier
            .clickable { }
            .clip(RoundedCornerShape(12.dp))
            .height(200.dp)
            .width(180.dp),
        elevation = 1.dp, // ????????????
        onClick = { navController.navigate(AllScreen.ShopDetail.route) },
        backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = painterResource(R.drawable.product),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Fit,
                alignment = Alignment.TopCenter,
            )
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(4.dp)
            ) {
                androidx.compose.material3.Text(
                    "??????????????????????????????????????????400g",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onBackground,
                    modifier = Modifier.padding(horizontal = 8.dp)
                )
                Spacer(modifier = Modifier.height(4.dp))
                Row(
                    modifier = Modifier
                        .height(36.dp)
                        .fillMaxWidth(),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween,
                ) {
                    Image(
                        painter = painterResource(R.drawable.alevel),
                        contentDescription = "",
                        modifier = Modifier
                            .clip(RoundedCornerShape(12))
                            .height(45.dp)
                            .width(84.dp),
                        contentScale = ContentScale.Fit,
                        alignment = Alignment.TopCenter,
                    )
                    var change by remember{ mutableStateOf(false) }
                    var flag by remember{ mutableStateOf(false) }

                    val buttonSize by animateDpAsState(
                        targetValue = if(change) 32.dp else 24.dp
                    )
                    if(buttonSize == 32.dp) {
                        change = false
                    }
                    IconButton(
                        onClick = {
                            change = true
                            flag = !flag
                        }
                    ) {
                        androidx.compose.material3.Icon(
                            Icons.Rounded.Favorite,
                            contentDescription = null,
                            modifier = Modifier.size(buttonSize),
                            tint = if (flag) Color.Red else MaterialTheme.colorScheme.outline
                        )
                    }
                }
            }
        }
    }
}

//??????????????????????????????
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HomeRecordCard(navController: NavController) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp) // ?????????
            .clip(RoundedCornerShape(12.dp))
            .height(409.dp)
            .width(380.dp),

        // ??????????????????????????????????????? CardDemo() ???????????? MaterialTheme ?????????
        // ???????????????????????????

        elevation = 4.dp, // ????????????
        onClick = { navController.navigate(AllScreen.Record.route) },
        backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            PieChart2(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(269.dp),
                input = listOf(
                    PieChartInput2(
                        color = LevelA,
                        value = 29,
                        description = "A????????????"
                    ),
                    PieChartInput2(
                        color = LevelB,
                        value = 21,
                        description = "B????????????"
                    ),
                    PieChartInput2(
                        color = LevelC,
                        value = 32,
                        description = "C????????????"
                    ),
                    PieChartInput2(
                        color = LevelD,
                        value = 18,
                        description = "D????????????"
                    ),
                    PieChartInput2(
                        color = LevelE,
                        value = 37,
                        description = "E????????????"
                    ),
                ),
                centerText = "????????????90???"
            )
            Spacer(modifier = Modifier.height(16.dp))
            androidx.compose.material3.Text(
                "????????????????????????????????????????????????????????????????????????????????????????????????",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.outline,
            )
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(40.dp),
                horizontalArrangement = Arrangement.End
            ) {
                GradientButton(
                    modifier = Modifier
                        .height(40.dp)
                        .width(105.dp),
                    textId = "????????????",
                    onClick = { navController.navigate(AllScreen.Record.route) }
                )
            }
        }
    }

}

//????????????
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CommunityCard(navController: NavController) {
    Card(
        modifier = Modifier
            .padding(horizontal = 0.dp, vertical = 4.dp) // ?????????
            .clip(RoundedCornerShape(12.dp))
            .height(210.dp)
            .width(174.dp),

        // ??????????????????????????????????????? CardDemo() ???????????? MaterialTheme ?????????
        // ???????????????????????????

        elevation = 4.dp, // ????????????
        onClick = { navController.navigate(AllScreen.NoteDetail.route) },
        backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
    ) {
        Column(modifier=Modifier.fillMaxSize()){
            Box(modifier = Modifier.height(138.dp)) {
                var change by remember{ mutableStateOf(false) }
                var flag by remember{ mutableStateOf(false) }

                val buttonSize by animateDpAsState(
                    targetValue = if(change) 32.dp else 24.dp
                )
                if(buttonSize == 32.dp) {
                    change = false
                }
                IconButton(
                    modifier=Modifier.zIndex(3f)
                        .align(Alignment.TopEnd),
                    onClick = {
                        change = true
                        flag = !flag
                    }
                ) {
                    androidx.compose.material3.Icon(
                        Icons.Rounded.Favorite,
                        contentDescription = null,
                        modifier = Modifier.size(buttonSize),
                        tint = if (flag) Color.Red else MaterialTheme.colorScheme.outline
                    )
                }
                Image(
                    painter = painterResource(R.drawable.tiezi),
                    contentDescription = "",
                    modifier = Modifier
                        .clip(RoundedCornerShape(12))
                        .height(130.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Fit,
                    alignment = Alignment.TopCenter,
                )

            }
            androidx.compose.material3.Text(
                "?????????????????????",
                modifier = Modifier
                    .padding(start = 8.dp),
                style = MaterialTheme.typography.titleSmall,
                color = MaterialTheme.colorScheme.onSurface,
            )
            Spacer(modifier = Modifier.height(8.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(24.dp)
                    .padding(start = 8.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Row(
                    modifier = Modifier
                        .width(126.dp)
                        .height(24.dp),
                    verticalAlignment = Alignment.CenterVertically,
                ) {
                    Image(
                        painter = painterResource(R.drawable.profile),
                        contentDescription = "",
                        modifier = Modifier
                            .clip(CircleShape)
                            .size(24.dp),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.TopCenter,
                    )
                    androidx.compose.material3.Text(
                        "??????Need?????????",
                        modifier=Modifier.padding(start = 4.dp),
                        style = MaterialTheme.typography.bodySmall,
                        color = MaterialTheme.colorScheme.outline,
                    )
                }
            }
        }

    }
}

//?????????????????????
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CustmizeCard() {
    var visible by remember { mutableStateOf(false) }
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 4.dp) // ?????????
            .clickable { }
            .clip(RoundedCornerShape(12.dp))
            .width(380.dp),

        // ??????????????????????????????????????? CardDemo() ???????????? MaterialTheme ?????????
        // ???????????????????????????

        elevation = 0.dp, // ????????????
        onClick = {},
        backgroundColor = MaterialTheme.colorScheme.surface,
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 20.dp),
            verticalArrangement = Arrangement.SpaceBetween
        ) {

            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Column(
                    modifier = Modifier
                        .height(50.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "????????????",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.secondary,
                    )
                    Text(
                        "??????",
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                }
                Column(
                    modifier = Modifier
                        .height(50.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "????????????",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.secondary,
                    )
                    Text(
                        "????????????",
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                }
                Column(
                    modifier = Modifier
                        .height(50.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "???????????????",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.secondary,
                    )
                    Text(
                        "??????",
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                }
                Column(
                    modifier = Modifier
                        .height(50.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.SpaceBetween
                ) {
                    Text(
                        "????????????",
                        style = MaterialTheme.typography.labelMedium,
                        color = MaterialTheme.colorScheme.secondary,
                    )
                    Text(
                        "????????????",
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onPrimaryContainer,
                    )
                }

            }
            AnimatedVisibility(visible = visible) {
                Card(
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(top = 8.dp),
                    backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp, horizontal = 8.dp),
                        verticalArrangement = Arrangement.spacedBy(16.dp)
                    ) {
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                "????????????",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.primary,
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                CustomizeInfoChip(false, "??????")
                                CustomizeInfoChip(true, "??????")
                                CustomizeInfoChip(false, "??????")
                            }
                        }
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                "????????????",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.primary,
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                CustomizeInfoChip(false, "?????????")
                                CustomizeInfoChip(true, "?????????")
                                CustomizeInfoChip(false, "????????????")
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                CustomizeInfoChip(false, "??????")
                            }
                        }
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                "???????????????",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.primary,
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                CustomizeInfoChip(false, "??????")
                                CustomizeInfoChip(true, "??????")
                                CustomizeInfoChip(false, "?????????")
                            }
                        }
                        Column(modifier = Modifier.fillMaxWidth()) {
                            Text(
                                "????????????",
                                style = MaterialTheme.typography.titleSmall,
                                color = MaterialTheme.colorScheme.primary,
                            )
                            Spacer(modifier = Modifier.height(8.dp))
                            Row(
                                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                CustomizeInfoChip(false, "?????????")
                                CustomizeInfoChip(false, "??????")
                                CustomizeInfoChip(false, "??????")
                                CustomizeInfoChip(false, "??????")
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                CustomizeInfoChip(false, "????????????")
                                CustomizeInfoChip(false, "????????????")
                                CustomizeInfoChip(false, "???????????????")
                            }
                            Row(
                                modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(8.dp)
                            ) {
                                CustomizeInfoChip(false, "??????")
                                CustomizeInfoChip(false, "??????")

                            }
                        }
                    }
                }
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically
            ) {
                GradientButton(modifier = Modifier.size(247.dp, 40.dp),
                    textId = if (visible) "????????????" else "????????????", onClick = {
                        visible = !visible
                    })
                TextButton(onClick = { /*TODO*/ }) {
                    Text(
                        "????????????",
                        style = MaterialTheme.typography.titleSmall,
                        color = MaterialTheme.colorScheme.primary,
                    )
                }
            }

        }
    }
}

//?????????????????????
@SuppressLint("ResourceType")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HealthCard(
    title: String,
    @StringRes iconId: Int,
    @StringRes imageId: Int,
    description: String,
    description2: String
) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 4.dp) // ?????????

            .clip(RoundedCornerShape(12.dp))
            .size(380.dp, 74.dp),

        // ??????????????????????????????????????? CardDemo() ???????????? MaterialTheme ?????????
        // ???????????????????????????

        elevation = 0.dp, // ????????????
        onClick = {},
        backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                ) {
                    Icon(
                        painter = painterResource(iconId),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        title,
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.primary,
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        description,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                    Text(
                        description2,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }
            Icon(
                painter = painterResource(id = imageId),
                null, modifier = Modifier.size(52.dp), tint = Color.Unspecified
            )
        }
    }
}

//????????????????????????????????????
@SuppressLint("ResourceType")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HealthCard2(title: String, @StringRes iconId: Int, description: String, description2: String) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 4.dp) // ?????????
            .clip(RoundedCornerShape(12.dp))
            .size(380.dp, 74.dp),

        // ??????????????????????????????????????? CardDemo() ???????????? MaterialTheme ?????????
        // ???????????????????????????

        elevation = 0.dp, // ????????????
        onClick = {},
        backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                ) {
                    Icon(
                        painter = painterResource(iconId),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        title,
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.primary,
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        description,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                    Text(
                        description2,
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }

        }
    }
}

//????????????????????????
@SuppressLint("ResourceType")
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun HealthCard3(title: String, @StringRes iconId: Int, description: String, description2: String) {
    Card(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 4.dp) // ?????????
            .clip(RoundedCornerShape(12.dp))
            .size(380.dp, 74.dp),

        // ??????????????????????????????????????? CardDemo() ???????????? MaterialTheme ?????????
        // ???????????????????????????

        elevation = 0.dp, // ????????????
        onClick = {},
        backgroundColor = MaterialTheme.colorScheme.surfaceVariant,
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp, vertical = 10.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.SpaceBetween
            ) {

                Row(
                ) {
                    Icon(
                        painter = painterResource(iconId),
                        contentDescription = null,
                        modifier = Modifier.size(20.dp),
                        tint = MaterialTheme.colorScheme.primary
                    )
                    Text(
                        title,
                        style = MaterialTheme.typography.titleSmall.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.primary,
                    )
                }
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text(
                        description,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                    Text(
                        "??????",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        description2,
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.onBackground,
                    )
                    Text(
                        "??????",
                        style = MaterialTheme.typography.bodyMedium,
                        color = MaterialTheme.colorScheme.secondary,
                        modifier = Modifier.padding(start = 4.dp)
                    )
                }
            }

        }
    }
}

//??????????????????
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ADListCard() {
    val checkedState = remember {
        mutableStateOf(true)
    }
    Card(
        modifier = Modifier
            .padding(horizontal = 0.dp, vertical = 4.dp) // ?????????
            .clickable { }
            .clip(RoundedCornerShape(12.dp))
            .height(80.dp)
            .fillMaxWidth(),

        // ??????????????????????????????????????? CardDemo() ???????????? MaterialTheme ?????????
        // ???????????????????????????

        elevation = 4.dp, // ????????????
        onClick = {},
        backgroundColor = MaterialTheme.colorScheme.surfaceColorAtElevation(1.dp),
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(start = 16.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Column() {
                androidx.compose.material3.Text(
                    "??????????????????  12312345678",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurface,
                )
                Spacer(modifier = Modifier.height(8.dp))
                androidx.compose.material3.Text(
                    "????????????????????? ????????? ?????????",
                    style = MaterialTheme.typography.titleSmall,
                    color = MaterialTheme.colorScheme.onSurface,
                )
            }
            Checkbox(
                checked = checkedState.value,
                onCheckedChange = { checkedState.value = it },
                modifier = Modifier.padding(0.dp),
            )
        }
    }
}

