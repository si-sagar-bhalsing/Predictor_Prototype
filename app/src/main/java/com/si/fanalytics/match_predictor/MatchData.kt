package com.si.fanalytics.match_predictor

val dummyMatchDays = listOf(
    MatchDay(
        matchDay = "Matchday 1",
        dateRange = "15 - 19 Jun",
        matches = listOf(
            Match(
                homeTeam = "Germany",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 5,
                awayTeam = "Scotland",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 1,
                popularPredictions = listOf(
                    Prediction(score = "2 - 0", percentage = 35),
                    Prediction(score = "3 - 1", percentage = 17),
                    Prediction(score = "3 - 0", percentage = 16)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Hungary",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 1,
                awayTeam = "Switzerland",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 3,
                popularPredictions = listOf(
                    Prediction(score = "1 - 1", percentage = 20),
                    Prediction(score = "1 - 2", percentage = 40),
                    Prediction(score = "0 - 1", percentage = 40)
                ),
                isLive = false
            ),
            // More matches added here
            Match(
                homeTeam = "England",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 3,
                awayTeam = "France",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 2,
                popularPredictions = listOf(
                    Prediction(score = "2 - 2", percentage = 30),
                    Prediction(score = "1 - 3", percentage = 40),
                    Prediction(score = "3 - 2", percentage = 30)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Portugal",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 2,
                awayTeam = "Italy",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 2,
                popularPredictions = listOf(
                    Prediction(score = "2 - 2", percentage = 25),
                    Prediction(score = "1 - 2", percentage = 35),
                    Prediction(score = "2 - 1", percentage = 40)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Brazil",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 4,
                awayTeam = "Argentina",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 4,
                popularPredictions = listOf(
                    Prediction(score = "3 - 3", percentage = 50),
                    Prediction(score = "4 - 3", percentage = 25),
                    Prediction(score = "3 - 4", percentage = 25)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Netherlands",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 1,
                awayTeam = "Belgium",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 2,
                popularPredictions = listOf(
                    Prediction(score = "1 - 1", percentage = 30),
                    Prediction(score = "1 - 2", percentage = 40),
                    Prediction(score = "0 - 2", percentage = 30)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Croatia",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 3,
                awayTeam = "Serbia",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 3,
                popularPredictions = listOf(
                    Prediction(score = "2 - 3", percentage = 25),
                    Prediction(score = "3 - 3", percentage = 50),
                    Prediction(score = "2 - 2", percentage = 25)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Mexico",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 2,
                awayTeam = "USA",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 2,
                popularPredictions = listOf(
                    Prediction(score = "2 - 2", percentage = 30),
                    Prediction(score = "1 - 2", percentage = 40),
                    Prediction(score = "2 - 1", percentage = 30)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Chile",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 3,
                awayTeam = "Peru",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 1,
                popularPredictions = listOf(
                    Prediction(score = "2 - 1", percentage = 40),
                    Prediction(score = "3 - 0", percentage = 30),
                    Prediction(score = "3 - 1", percentage = 30)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Japan",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 1,
                awayTeam = "South Korea",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 1,
                popularPredictions = listOf(
                    Prediction(score = "1 - 1", percentage = 30),
                    Prediction(score = "0 - 1", percentage = 40),
                    Prediction(score = "1 - 0", percentage = 30)
                ),
                isLive = false
            )
        )
    ),
    MatchDay(
        matchDay = "Matchday 2",
        dateRange = "20 - 24 Sep",
        matches = listOf(
            Match(
                homeTeam = "Spain",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 5,
                awayTeam = "France",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 4,
                popularPredictions = listOf(
                    Prediction(score = "1 - 1", percentage = 25),
                    Prediction(score = "4 - 5", percentage = 50),
                    Prediction(score = "0 - 1", percentage = 25)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Italy",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 0,
                awayTeam = "Netherlands",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 1,
                popularPredictions = listOf(
                    Prediction(score = "1 - 0", percentage = 30),
                    Prediction(score = "0 - 1", percentage = 50),
                    Prediction(score = "1 - 1", percentage = 20)
                ),
                isLive = false
            ),
            // More matches added here
            Match(
                homeTeam = "England",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 3,
                awayTeam = "Germany",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 2,
                popularPredictions = listOf(
                    Prediction(score = "2 - 2", percentage = 30),
                    Prediction(score = "1 - 3", percentage = 40),
                    Prediction(score = "3 - 2", percentage = 30)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Portugal",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 2,
                awayTeam = "Italy",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 2,
                popularPredictions = listOf(
                    Prediction(score = "2 - 2", percentage = 25),
                    Prediction(score = "1 - 2", percentage = 35),
                    Prediction(score = "2 - 1", percentage = 40)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Brazil",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 4,
                awayTeam = "Argentina",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 4,
                popularPredictions = listOf(
                    Prediction(score = "3 - 3", percentage = 50),
                    Prediction(score = "4 - 3", percentage = 25),
                    Prediction(score = "3 - 4", percentage = 25)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Netherlands",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 1,
                awayTeam = "Belgium",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 2,
                popularPredictions = listOf(
                    Prediction(score = "1 - 1", percentage = 30),
                    Prediction(score = "1 - 2", percentage = 40),
                    Prediction(score = "0 - 2", percentage = 30)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Croatia",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 3,
                awayTeam = "Serbia",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 3,
                popularPredictions = listOf(
                    Prediction(score = "2 - 3", percentage = 25),
                    Prediction(score = "3 - 3", percentage = 50),
                    Prediction(score = "2 - 2", percentage = 25)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Mexico",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 2,
                awayTeam = "USA",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 2,
                popularPredictions = listOf(
                    Prediction(score = "2 - 2", percentage = 30),
                    Prediction(score = "1 - 2", percentage = 40),
                    Prediction(score = "2 - 1", percentage = 30)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Chile",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 3,
                awayTeam = "Peru",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 1,
                popularPredictions = listOf(
                    Prediction(score = "2 - 1", percentage = 40),
                    Prediction(score = "3 - 0", percentage = 30),
                    Prediction(score = "3 - 1", percentage = 30)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Japan",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 1,
                awayTeam = "South Korea",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 1,
                popularPredictions = listOf(
                    Prediction(score = "1 - 1", percentage = 30),
                    Prediction(score = "0 - 1", percentage = 40),
                    Prediction(score = "1 - 0", percentage = 30)
                ),
                isLive = false
            )
        )
    ),
    MatchDay(
        matchDay = "Matchday 3",
        dateRange = "20 - 24 Nov",
        matches = listOf(
            Match(
                homeTeam = "Spain",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 9,
                awayTeam = "France",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 6,
                popularPredictions = listOf(
                    Prediction(score = "5 - 7", percentage = 25),
                    Prediction(score = "1 - 8", percentage = 50),
                    Prediction(score = "1 - 5", percentage = 25)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Italy",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 0,
                awayTeam = "Netherlands",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 1,
                popularPredictions = listOf(
                    Prediction(score = "1 - 0", percentage = 30),
                    Prediction(score = "0 - 1", percentage = 50),
                    Prediction(score = "1 - 1", percentage = 20)
                ),
                isLive = false
            ),
            // More matches added here
            Match(
                homeTeam = "England",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 3,
                awayTeam = "Germany",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 2,
                popularPredictions = listOf(
                    Prediction(score = "2 - 2", percentage = 30),
                    Prediction(score = "1 - 3", percentage = 40),
                    Prediction(score = "3 - 2", percentage = 30)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Portugal",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 2,
                awayTeam = "Italy",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 2,
                popularPredictions = listOf(
                    Prediction(score = "2 - 2", percentage = 25),
                    Prediction(score = "1 - 2", percentage = 35),
                    Prediction(score = "2 - 1", percentage = 40)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Brazil",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 4,
                awayTeam = "Argentina",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 4,
                popularPredictions = listOf(
                    Prediction(score = "3 - 3", percentage = 50),
                    Prediction(score = "4 - 3", percentage = 25),
                    Prediction(score = "3 - 4", percentage = 25)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Netherlands",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 1,
                awayTeam = "Belgium",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 2,
                popularPredictions = listOf(
                    Prediction(score = "1 - 1", percentage = 30),
                    Prediction(score = "1 - 2", percentage = 40),
                    Prediction(score = "0 - 2", percentage = 30)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Croatia",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 3,
                awayTeam = "Serbia",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 3,
                popularPredictions = listOf(
                    Prediction(score = "2 - 3", percentage = 25),
                    Prediction(score = "3 - 3", percentage = 50),
                    Prediction(score = "2 - 2", percentage = 25)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Mexico",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 2,
                awayTeam = "USA",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 2,
                popularPredictions = listOf(
                    Prediction(score = "2 - 2", percentage = 30),
                    Prediction(score = "1 - 2", percentage = 40),
                    Prediction(score = "2 - 1", percentage = 30)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Chile",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 3,
                awayTeam = "Peru",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 1,
                popularPredictions = listOf(
                    Prediction(score = "2 - 1", percentage = 40),
                    Prediction(score = "3 - 0", percentage = 30),
                    Prediction(score = "3 - 1", percentage = 30)
                ),
                isLive = false
            ),
            Match(
                homeTeam = "Japan",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 1,
                awayTeam = "South Korea",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 1,
                popularPredictions = listOf(
                    Prediction(score = "1 - 1", percentage = 30),
                    Prediction(score = "0 - 1", percentage = 40),
                    Prediction(score = "1 - 0", percentage = 30)
                ),
                isLive = false
            )
        )
    ),
    MatchDay(
        matchDay = "Matchday 4",
        dateRange = "20 - 24 Dec",
        matches = listOf(
            Match(
                homeTeam = "Spain",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 4,
                awayTeam = "France",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 7,
                popularPredictions = listOf(
                    Prediction(score = "2 - 1", percentage = 25),
                    Prediction(score = "1 - 1", percentage = 50),
                    Prediction(score = "0 - 1", percentage = 25)
                ),
                isLive = true
            ),
            Match(
                homeTeam = "Italy",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 0,
                awayTeam = "Netherlands",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 1,
                popularPredictions = listOf(
                    Prediction(score = "1 - 0", percentage = 30),
                    Prediction(score = "0 - 1", percentage = 50),
                    Prediction(score = "1 - 1", percentage = 20)
                ),
                isLive = true
            ),
            // More matches added here
            Match(
                homeTeam = "England",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 3,
                awayTeam = "Germany",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 2,
                popularPredictions = listOf(
                    Prediction(score = "2 - 2", percentage = 30),
                    Prediction(score = "1 - 3", percentage = 40),
                    Prediction(score = "3 - 2", percentage = 30)
                ),
                isLive = true
            ),
            Match(
                homeTeam = "Portugal",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 2,
                awayTeam = "Italy",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 2,
                popularPredictions = listOf(
                    Prediction(score = "2 - 2", percentage = 25),
                    Prediction(score = "1 - 2", percentage = 35),
                    Prediction(score = "2 - 1", percentage = 40)
                ),
                isLive = true
            ),
            Match(
                homeTeam = "Brazil",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 4,
                awayTeam = "Argentina",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 4,
                popularPredictions = listOf(
                    Prediction(score = "3 - 3", percentage = 50),
                    Prediction(score = "4 - 3", percentage = 25),
                    Prediction(score = "3 - 4", percentage = 25)
                ),
                isLive = true
            ),
            Match(
                homeTeam = "Netherlands",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 1,
                awayTeam = "Belgium",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 2,
                popularPredictions = listOf(
                    Prediction(score = "1 - 1", percentage = 30),
                    Prediction(score = "1 - 2", percentage = 40),
                    Prediction(score = "0 - 2", percentage = 30)
                ),
                isLive = true
            ),
            Match(
                homeTeam = "Croatia",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 3,
                awayTeam = "Serbia",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 3,
                popularPredictions = listOf(
                    Prediction(score = "2 - 3", percentage = 25),
                    Prediction(score = "3 - 3", percentage = 50),
                    Prediction(score = "2 - 2", percentage = 25)
                ),
                isLive = true
            ),
            Match(
                homeTeam = "Mexico",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 2,
                awayTeam = "USA",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 2,
                popularPredictions = listOf(
                    Prediction(score = "2 - 2", percentage = 30),
                    Prediction(score = "1 - 2", percentage = 40),
                    Prediction(score = "2 - 1", percentage = 30)
                ),
                isLive = true
            ),
            Match(
                homeTeam = "Chile",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 3,
                awayTeam = "Peru",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 1,
                popularPredictions = listOf(
                    Prediction(score = "2 - 1", percentage = 40),
                    Prediction(score = "3 - 0", percentage = 30),
                    Prediction(score = "3 - 1", percentage = 30)
                ),
                isLive = true
            ),
            Match(
                homeTeam = "Japan",
                homeTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                homeScore = 1,
                awayTeam = "South Korea",
                awayTeamFlag = R.drawable.ic_flag,  // replace with actual resource ID
                awayScore = 1,
                popularPredictions = listOf(
                    Prediction(score = "1 - 1", percentage = 30),
                    Prediction(score = "0 - 1", percentage = 40),
                    Prediction(score = "1 - 0", percentage = 30)
                ),
                isLive = true
            )
        )
    )
)
