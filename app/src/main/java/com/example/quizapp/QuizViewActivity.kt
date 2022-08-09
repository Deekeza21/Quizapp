package com.example.quizapp

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.core.content.ContextCompat


class QuizViewActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrPosit: Int = 1
    private var mQuestionList: ArrayList<Question>? = null
    private var mSelectedOptPos: Int = 0
    private var mCorrectAnswers: Int = 0
    private var mUserName: String? = null

    private lateinit var txt_opt_1: TextView
    private lateinit var txt_opt_2: TextView
    private lateinit var txt_opt_3: TextView
    private lateinit var txt_opt_4: TextView
    private lateinit var txt_progress: TextView
    private lateinit var progress_bar:ProgressBar
    private lateinit var txt_question: TextView
    private lateinit var image_one: ImageView
    private lateinit var btn_submit: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_view)

        txt_opt_1 = findViewById(R.id.txt_opt_1)
        txt_opt_2 = findViewById(R.id.txt_opt_2)
         txt_opt_3 = findViewById(R.id.txt_opt_3)
         txt_opt_4= findViewById(R.id.txt_opt_4)
         txt_progress= findViewById(R.id.txt_progress)
         progress_bar= findViewById(R.id.prog_bar)
         txt_question = findViewById(R.id.txt_question)
         image_one = findViewById(R.id.image_one)
         btn_submit = findViewById(R.id.btn_submit)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionList = Constants.getQuestions()

        setQuestion()

        txt_opt_1.setOnClickListener(this)
        txt_opt_2.setOnClickListener(this)
        txt_opt_3.setOnClickListener(this)
        txt_opt_4.setOnClickListener(this)
        btn_submit.setOnClickListener(this)


    }

        fun setQuestion() {

            //mCurrPosit = 1
            val question = mQuestionList!![mCurrPosit - 1]

            defaultOptionview()

            if(mCurrPosit == mQuestionList!!.size) {
                btn_submit.text = "FINISH"
            }else{
                btn_submit.text = "SUBMIT"
            }

            //val progressBar = 0
            //val progress = 0
            progress_bar.progress = mCurrPosit
            txt_progress.text = "$mCurrPosit" + "/" + progress_bar.max

            txt_question.text = question!!.question
            image_one.setImageResource(question.image)
            txt_opt_1.text = question.optionOne
            txt_opt_2.text = question.optionTwo
            txt_opt_3.text = question.optionThree
            txt_opt_4.text = question.optionFour



        }

         fun defaultOptionview(){
            val options = ArrayList<TextView>()
            options.add(0, txt_opt_1)
            options.add(1, txt_opt_2)
            options.add(2, txt_opt_3)
            options.add(3, txt_opt_4)

            for (option in options) {
               // option.setTextColor(Color.parseColor("fgf"))
                option.typeface = Typeface.DEFAULT
                option.background = ContextCompat.getDrawable(
                    this,
                    R.drawable.default_opt_bord
                )

            }

        }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.txt_opt_1 -> {
                selectedOptionView(txt_opt_1, 1)
            }
            R.id.txt_opt_2 -> {
                selectedOptionView(txt_opt_2, 2)

            }
            R.id.txt_opt_3 -> {
                selectedOptionView(txt_opt_3, 3)

            }
            R.id.txt_opt_4 -> {
                selectedOptionView(txt_opt_4, 4)
            }

            R.id.btn_submit -> {
                if (mSelectedOptPos == 0) {
                    mCurrPosit++

                    when {
                        mCurrPosit <= mQuestionList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java )
                            intent.putExtra(Constants.USER_NAME, mUserName)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionList!!.size)
                            startActivity(intent)
                            finish()

                        }
                    }
                } else {
                    val question = mQuestionList?.get(mCurrPosit - 1)
                    if (question!!.correctAnswer != mSelectedOptPos) {
                        answerView(mSelectedOptPos, R.drawable.wrong_opt_bord)

                    }else{
                        mCorrectAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_opt_bord)

                    if (mCurrPosit == mQuestionList!!.size) {
                        btn_submit.text = "FINISH"

                    } else {
                        btn_submit.text = "GO TO NEXT QUESTION"
                    }
                    mSelectedOptPos = 0
                }

            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int){
        when(answer){
          1 ->{
              txt_opt_1.background = ContextCompat.getDrawable(this, drawableView)
          }
            2 ->{
                txt_opt_2.background = ContextCompat.getDrawable(this, drawableView)
            }

            3 ->{
                txt_opt_3.background = ContextCompat.getDrawable(this, drawableView)
            }

            4 ->{
                txt_opt_4.background = ContextCompat.getDrawable(this, drawableView)
            }

        }
    }

   private fun selectedOptionView(tv:TextView, selectedOptionNum: Int) {

        defaultOptionview()
        mSelectedOptPos = selectedOptionNum

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(
            this,
            R.drawable.selected_opt_bord
        )
    }
}


