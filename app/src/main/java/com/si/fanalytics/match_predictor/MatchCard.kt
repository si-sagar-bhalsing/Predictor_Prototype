package com.si.fanalytics.match_predictor

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
import com.si.fanalytics.match_predictor.ui.theme.Highlight
import com.si.fanalytics.match_predictor.ui.theme.TextColor

@Composable
fun MatchInfoCard(match: Match, onClick: (Int) -> Unit) {
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
                TeamInfo(team = match.homeTeam, flag = match.homeTeamFlag)
                Spacer(modifier = Modifier.width(10.dp))
                ScoreBox(
                    homeScore = match.homeScore,
                    awayScore = match.awayScore,
                    predictHomeScore = match.predictedHomeScore,
                    predictAwayScore = match.predictedAwayScore,
                    isLive = match.isLive,
                    onClick = { onClick(match.matchId) }
                )
                Spacer(modifier = Modifier.width(10.dp))
                TeamInfo(team = match.awayTeam, flag = match.awayTeamFlag)
            }

            Spacer(modifier = Modifier.height(10.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text("Popular Predictions", color = TextColor)
                Spacer(modifier = Modifier.height(5.dp))

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    match.popularPredictions.forEach { prediction ->
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Text(text = prediction.score, color = TextColor)
                            Text(text = "${prediction.percentage}%", color = TextColor)
                        }
                        Spacer(modifier = Modifier.width(25.dp))
                    }
                }
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
fun ScoreBox(homeScore: Int, awayScore: Int, predictHomeScore: Int?, predictAwayScore: Int?, isLive: Boolean, onClick: () -> Unit) {

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
fun PredictScoreBox(isLive: Boolean, predictScore: String?, boxNull: Boolean, onClick: () -> Unit) {
    val boxColor = if (isLive) Highlight else TextColor
    val boxIcon = if (isLive) R.drawable.ic_add else R.drawable.ic_minuss
    Box(
        modifier = Modifier
            .size(50.dp)
            .clip(RoundedCornerShape(5.dp))
            .border(1.dp, boxColor, RoundedCornerShape(5.dp))
            .clickable {
                if (isLive) onClick()
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
//
//@Preview
//@Composable
//fun MatchInfoCardPreview() {
//    MatchInfoCard(match = match)
//}

val match = Match(
    homeTeam = "Germany",
    homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
    homeScore = 5,
    predictedAwayScore = null,
    predictedHomeScore = null,
    awayTeam = "Scotland",
    awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
    awayScore = 1,
    popularPredictions = listOf(
        Prediction(score = "2 - 0", percentage = 35),
        Prediction(score = "3 - 1", percentage = 17),
        Prediction(score = "3 - 0", percentage = 16),
        Prediction(score = "2 - 1", percentage = 11),

        ),
    isLive = true,
    matchId = 111
)
