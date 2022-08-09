package com.example.quizapp

object Constants {

    const val USER_NAME: String = "user_name"
    const val TOTAL_QUESTIONS: String = "total_question"
    const val CORRECT_ANSWERS:String = "correct_answers"

    fun getQuestions(): ArrayList<Question>{
        val questionsList = ArrayList<Question>()

        val que1 = Question(
            1,
            "What country does this flag belong to?",
            R.drawable.ic_argent,
            "Argentina",
            "Australia",
            "Rwanda",
            "USA",
            1
        )
        questionsList.add(que1)

        val que2 = Question(
            2,
            "What country does this flag belong to?",
            R.drawable.ic_maldives,
            "Benin",
            "Maldives",
            "Oman",
            "Yemen",
            2
        )
        questionsList.add(que2)

        val que3 = Question(
            3,
            "What country does this flag belong to?",
            R.drawable.ic_bulgaria,
            "Bermuda",
            "Irland",
            "Bulgaria",
            "Gabon",
            3
        )
        questionsList.add(que3)

        val que4 = Question(
            4,
            "What country does this flag belong to?",
            R.drawable.ic_uk,
            "Armenia",
            "Austria",
            "Burundi",
            "UK",
            4
        )
        questionsList.add(que4)

        val que5 = Question(
            5,
            "What country does this flag belong to?",
            R.drawable.ic_rwanda,
            "Rwanda",
            "Romania",
            "Mozambique",
            "Italy",
            1
        )
        questionsList.add(que5)

        val que6 = Question(
            6,
            "What country does this flag belong to?",
            R.drawable.ic_india,
            "Norway",
            "India",
            "Yemen",
            "Samoa",
            2
        )
        questionsList.add(que6)

        val que7 = Question(
            7,
            "What country does this flag belong to?",
            R.drawable.ic_portugal,
            "Sweden",
            "Swaziland",
            "Portugal",
            "Canada",
            3
        )
        questionsList.add(que7)

        val que8 = Question(
            8,
            "What country does this flag belong to?",
            R.drawable.senegal,
            "Lebanon",
            "Niger",
            "Mali",
            "Senegal",
            4
        )
        questionsList.add(que8)

        val que9 = Question(
            9,
            "What country does this flag belong to?",
            R.drawable.south_africa,
            "South Africa",
            "Nigeria",
            "France",
            "Switzerland",
            1
        )
        questionsList.add(que9)

        return questionsList


    }
}