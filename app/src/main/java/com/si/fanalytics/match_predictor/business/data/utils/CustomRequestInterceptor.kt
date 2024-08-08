package com.si.fanalytics.match_predictor.business.data.utils

import okhttp3.Interceptor
import okhttp3.Response

class CustomRequestInterceptor :Interceptor{
    override fun intercept(chain: Interceptor.Chain): Response {

        val builder = chain.request().newBuilder()

        builder.addHeader("entity", "d3tR0!t5m@sh")
        builder.addHeader("authorization","Bearer {\"afcfantasygame_RAW\":\"eyJTb2NpYWxJZCI6ImE3YWRjZGVhYzI0NDQ0NTg4YmY2M2Y2MDA0MDAzZjNlIiwiR1VJRCI6IjUwM2ExNDE2LTQ4ZGEtMTFlZi1hZWI0LTBlM2YyYTQ3YTg5OSIsIkNvdW50cnlJZCI6IjkxIiwiSXNWZXJpZmllZCI6MSwiSXNSZWdpc3RlcmVkIjoxLCJGYXZUZWFtSWQiOm51bGwsIkhhc1RlYW0iOiIwIiwiSGFzUHJlZGljdGlvbnMiOiIwIiwiVGVhbU5hbWUiOm51bGwsIkNvdW50cnlOYW1lIjpudWxsLCJGYXZUZWFtTmFtZSI6bnVsbCwiQ3VycmVudEdhbWVkYXlJZCI6IjEiLCJDdXJyZW50UGhhc2VJZCI6IiIsIklzVG91ckFjdGl2ZSI6IiIsIkNsaWVudElkIjowLCJQbGF0Zm9ybUlkIjowLCJGaXJzdFRlYW1HYW1lZGF5IjowLCJGdWxsTmFtZSI6bnVsbCwiRW1haWxJZCI6IkI5NzdGNjIxNTIzRTA5RDVBNzg1QzZCNkE0RUY1QzZBQTExNkMyMjc3MDQ3NUEyNkRBQjk3MDlEQkNDQ0MwQTdEMDYyNUU0NkYwOTBFNjkzNjAiLCJVc2VyTmFtZSI6IkFiaGlzaGVrIiwiQ291bnRyeSI6IklOIiwiVGVhbUlkIjowLCJQcmVkVGVhbUlkIjowLCJTaG93SW50ZXJlc3QiOjB9\",\"afcfantasygame_007\":\"A31FBE6803031FDBFB98C7FEFCAE163CF55A805F211B3F748EE14D96A9C4FBA2912C1712A59CA4FC3401770F9B5DBAB8D6BE0477C0C37A0BC6863039594D1412B873ECA0D030609330B350EF37742465E3B79B9D0D0C27FA930BD549304A2FF98E0A1CAA648083D7F44870BD54DCE33AE2443C28690EC447FCE4E6987BF366389B2DF356E2F705F15F586C54CCE8A3CE5510986F79BCC5CA27E5140C0CE981021329255F7811F13C041E0AB72CD81F957AF93BBACB81AD41D7790562F1F654802BB292DD0311996A675F37EC69475CBF1AA5E6681E7223963EE16B74F17146D7EB77451AF4631D035F726B444B9164B0350F5036176DF616E9BED735B49A83D250E84F414079BD7441C1332C1BCAE164003778C62B81D50AF94BA74B43AE5488AE54055484B87AE1C62F53DB04D50F155F7764A2616B19B504ABD48D\"}")
        builder.addHeader("referer", "https://www.afc.staging.digitalservices.sportradar.com/")


        return chain.proceed(builder.build())
    }
}