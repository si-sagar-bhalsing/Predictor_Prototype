package com.gaming.core.presentation

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.gaming.core.R
import com.gaming.core.ui.theme.TextColor
import com.gaming.core.data.model.Value
import com.gaming.core.ui.theme.Highlight

@Composable
fun MatchInfoCard(match: Value, onClick: (Int) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFF0B1E60)
        )
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("No Prediction Made", color = TextColor)
            Spacer(modifier = Modifier.height(10.dp))

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                //horizontalArrangement = Arrangement.SpaceEvenly,
                modifier = Modifier.fillMaxWidth()
            ) {
                match.teamAShortName?.let { TeamInfo(team = it, flag = com.gaming.core.R.drawable.ic_flag) }
                Spacer(modifier = Modifier.width(10.dp))
                match.awayTeamScore?.let {
                    match.homeTeamScore?.let { it1 ->
                        match.isLive?.let { it2 ->
                            ScoreBox(
                                homeScore = it1,
                                awayScore = it,
                                predictHomeScore = null,
                                predictAwayScore = null,
                                isLive = it2,
                                onClick = { match.matchId?.let { it3 -> onClick(it3.toInt()) } }
                            )
                        }
                    }
                }
                Spacer(modifier = Modifier.width(10.dp))
                match.teamBShortName?.let { TeamInfo(team = it, flag = R.drawable.ic_flag) }
            }

            Spacer(modifier = Modifier.height(10.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Popular Predictions", color = TextColor)
                Spacer(modifier = Modifier.height(5.dp))

//                Row(
//                    horizontalArrangement = Arrangement.Center,
//                    modifier = Modifier.fillMaxWidth()
//                ) {
//                    match.popularPredictions.forEach { prediction ->
//                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
//                            Text(text = prediction.score, color = TextColor)
//                            Text(text = "${prediction.percentage}%", color = TextColor)
//                        }
//                        Spacer(modifier = Modifier.width(25.dp))
//                    }
//                }
            }
        }
    }
}

@Composable
fun TeamInfo(team: String, flag: Int) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Image(
            painter = painterResource(id = flag),
            contentDescription = "$team flag",
            modifier = Modifier
                .size(50.dp)
                .clip(CircleShape)
        )
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = team, color = TextColor, fontWeight = FontWeight.Bold)
    }
}

@Composable
fun ScoreBox(homeScore: Int, awayScore: Int, predictHomeScore: Int?, predictAwayScore: Int?, isLive: Int, onClick: () -> Unit) {

    val boxNull = predictHomeScore == null || predictAwayScore == null

    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Row() {
            PredictScoreBox(isLive, predictHomeScore.toString(), boxNull, onClick)
            Spacer(modifier = Modifier.width(10.dp))
            PredictScoreBox(isLive, predictAwayScore.toString(), boxNull, onClick)
        }
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = "FT: $homeScore - $awayScore",
            color = TextColor,
            fontWeight = FontWeight.Bold
        )
    }
}

@Composable
fun PredictScoreBox(isLive: Int, predictScore: String?, boxNull: Boolean, onClick: () -> Unit) {
    val boxColor = if (isLive == 1) Highlight else TextColor
    val boxIcon = if (isLive == 1) R.drawable.ic_add else R.drawable.ic_minuss
    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(RoundedCornerShape(5.dp))
            .border(1.dp, boxColor, RoundedCornerShape(5.dp))
            .clickable {
                if (isLive == 1) onClick()
            }
    ) {
        if (boxNull) {
            Icon(
                painter = painterResource(id = boxIcon),
                contentDescription = null,
                tint = boxColor,
                modifier = Modifier.align(Alignment.Center)
            )
        } else {
            Text(
                text = predictScore.toString(),
                color = boxColor,
                fontWeight = FontWeight.Bold,
                fontSize = 35.sp,
                modifier = Modifier.align(Alignment.Center)
            )
        }
    }
}
