package com.example.kkneed.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.kkneed.R
import com.example.kkneed.ui.theme.KKNeedTheme

@Composable
fun DetailDialog(){


    val openDialog = remember { mutableStateOf(true) }

    if (openDialog.value) {
        AlertDialog(
            modifier = Modifier.size(360.dp,450.dp),
            onDismissRequest = {
                // Dismiss the dialog when the user clicks outside the dialog or on the back
                // button. If you want to disable that functionality, simply use an empty
                // onDismissRequest.

                openDialog.value = false
            },
            title = {
                Row(modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Start,
                verticalAlignment = Alignment.CenterVertically){
                    Icon(Icons.Default.MoreVert,null)
                    Text(text = "我们如何计算营养评分？",
                        style = MaterialTheme.typography.titleMedium,
                        color = MaterialTheme.colorScheme.onBackground)
                }
            },
            text = {
                Column(modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally) {
                    Image(
                        painter = painterResource(R.drawable.nutriscore),
                        contentDescription = "",
                        modifier = Modifier
                            .size(240.dp,150.dp),
                        contentScale = ContentScale.Crop,
                        alignment = Alignment.Center,
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(text = "Nutri-score营养评分",
                        style = MaterialTheme.typography.titleMedium.copy(fontWeight = FontWeight.Bold),
                        color = MaterialTheme.colorScheme.primary)
                    Spacer(modifier = Modifier.height(8.dp))
                    Text(text = "营养评分是指 100 克或 100 毫升的食物。营养“不利”营养价值N与“有利”营养价值P相抵消（营养评分= N - P）。钠中的糖含量、卡路里含量、饱和脂肪酸和转化盐含量属于不利成分（N）。有利的成分（P）包括水果，蔬菜，坚果，纤维，蛋白质和核桃，菜籽和橄榄油。",
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant)
                }

            },
            confirmButton = {
                GradientButton(modifier = Modifier
                    .height(40.dp)
                    .fillMaxWidth(),
                    textId = "我知道了", onClick = {
                        openDialog.value=false
                    }
                )
            }
        )
    }

}
@Composable
@Preview
fun DialogPreview() {
    KKNeedTheme {
        DetailDialog()
    }
}