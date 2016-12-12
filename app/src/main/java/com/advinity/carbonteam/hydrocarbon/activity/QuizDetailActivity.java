package com.advinity.carbonteam.hydrocarbon.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.InterpolatorRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.advinity.carbonteam.hydrocarbon.R;
import com.advinity.carbonteam.hydrocarbon.modal.Quiz;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;

public class QuizDetailActivity extends AppCompatActivity {

    private TextView quizTime;
    private TextView quizQuestion;
    private TextView quizChoiceA;
    private TextView quizChoiceB;
    private TextView quizChoiceC;
    private TextView quizChoiceD;

    private ImageView quizImgChoiceA;
    private ImageView quizImgChoiceB;
    private ImageView quizImgChoiceC;
    private ImageView quizImgChoiceD;

    private CardView quizBtnChoiceA;
    private CardView quizBtnChoiceB;
    private CardView quizBtnChoiceC;
    private CardView quizBtnChoiceD;

    private List<Quiz> quizList = new ArrayList<>();

    private String myAnswer;
    private Integer CURRENT_SUM = 0;

    private String range;
    private Integer time;
    private Integer sum;

    private CountDownTimer downTimer;
    private CountDownTimer quizTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        quizTime = (TextView) findViewById(R.id.quiz_time);
        quizQuestion = (TextView) findViewById(R.id.quiz_question);
        quizChoiceA = (TextView) findViewById(R.id.quiz_choiceA);
        quizChoiceB = (TextView) findViewById(R.id.quiz_choiceB);
        quizChoiceC = (TextView) findViewById(R.id.quiz_choiceC);
        quizChoiceD = (TextView) findViewById(R.id.quiz_choiceD);

        quizImgChoiceA = (ImageView) findViewById(R.id.quiz_choiceA_img);
        quizImgChoiceB = (ImageView) findViewById(R.id.quiz_choiceB_img);
        quizImgChoiceC = (ImageView) findViewById(R.id.quiz_choiceC_img);
        quizImgChoiceD = (ImageView) findViewById(R.id.quiz_choiceD_img);

        quizBtnChoiceA = (CardView) findViewById(R.id.quiz_btn_ChoiceA);
        quizBtnChoiceB = (CardView) findViewById(R.id.quiz_btn_ChoiceB);
        quizBtnChoiceC = (CardView) findViewById(R.id.quiz_btn_ChoiceC);
        quizBtnChoiceD = (CardView) findViewById(R.id.quiz_btn_ChoiceD);

        range = (String) getIntent().getExtras().get("range");
        time = (Integer) getIntent().getExtras().get("time");
        sum = (Integer) getIntent().getExtras().get("sum");

        downTimer = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {}

            @Override
            public void onFinish() {
                setQuiz();
            }
        };

        quizTimer = new CountDownTimer(time*60000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                long minute = millisUntilFinished / 60000;
                long second = millisUntilFinished % 60000;

                quizTime.setText(minute +" : "+ second / 1000);
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(QuizDetailActivity.this, ResultActivity.class);
                startActivity(intent);
                finish();
            }
        }.start();

        prepareQuizData();

        setQuiz();
    }

    private void setQuiz() {
        CURRENT_SUM++;

        quizImgChoiceA.setVisibility(View.GONE);
        quizImgChoiceB.setVisibility(View.GONE);
        quizImgChoiceC.setVisibility(View.GONE);
        quizImgChoiceD.setVisibility(View.GONE);

        if (CURRENT_SUM <= sum) {
            randomQuestion();
        } else {
            quizTimer.cancel();
            Intent intent = new Intent(QuizDetailActivity.this, ResultActivity.class);
            startActivity(intent);
            finish();
        }
    }

    private void randomQuestion() {
        Random random = new Random();
        Integer index = random.nextInt(quizList.size());

        Quiz quiz = quizList.get(index);

        if (range.equals(quiz.getRange()) || range.equals("All")) {
            quizQuestion.setText(quiz.getQuestion());

            quizChoiceA.setText(quiz.getChoiceA());
            quizChoiceA.setVisibility(View.VISIBLE);

            quizChoiceB.setText(quiz.getChoiceB());
            quizChoiceB.setVisibility(View.VISIBLE);

            quizChoiceC.setText(quiz.getChoiceC());
            quizChoiceC.setVisibility(View.VISIBLE);

            quizChoiceD.setText(quiz.getChoiceD());
            quizChoiceD.setVisibility(View.VISIBLE);

        }else{
            randomQuestion();
        }

        setMyAnswer(quiz);
    }

    private void setMyAnswer(final Quiz quiz) {
        quizBtnChoiceA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAnswer = quiz.getChoiceA();

                if (myAnswer.equals(quiz.getAnswer())) {
                    quizChoiceA.setVisibility(View.GONE);
                    quizImgChoiceA.setImageResource(R.drawable.ic_correct);
                    quizImgChoiceA.setVisibility(View.VISIBLE);

                    downTimer.start();
                } else {
                    quizChoiceA.setVisibility(View.GONE);
                    quizImgChoiceA.setImageResource(R.drawable.ic_wrong);
                    quizImgChoiceA.setVisibility(View.VISIBLE);
                }
            }
        });

        quizBtnChoiceB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAnswer = quiz.getChoiceB();

                if (myAnswer.equals(quiz.getAnswer())) {
                    quizChoiceB.setVisibility(View.GONE);
                    quizImgChoiceB.setImageResource(R.drawable.ic_correct);
                    quizImgChoiceB.setVisibility(View.VISIBLE);

                    downTimer.start();
                } else {
                    quizChoiceB.setVisibility(View.GONE);
                    quizImgChoiceB.setImageResource(R.drawable.ic_wrong);
                    quizImgChoiceB.setVisibility(View.VISIBLE);
                }
            }
        });

        quizBtnChoiceC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAnswer = quiz.getChoiceC();

                if (myAnswer.equals(quiz.getAnswer())) {
                    quizChoiceC.setVisibility(View.GONE);
                    quizImgChoiceC.setImageResource(R.drawable.ic_correct);
                    quizImgChoiceC.setVisibility(View.VISIBLE);

                    downTimer.start();
                } else {
                    quizChoiceC.setVisibility(View.GONE);
                    quizImgChoiceC.setImageResource(R.drawable.ic_wrong);
                    quizImgChoiceC.setVisibility(View.VISIBLE);
                }
            }
        });

        quizBtnChoiceD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAnswer = quiz.getChoiceD();

                if (myAnswer.equals(quiz.getAnswer())) {
                    quizChoiceD.setVisibility(View.GONE);
                    quizImgChoiceD.setImageResource(R.drawable.ic_correct);
                    quizImgChoiceD.setVisibility(View.VISIBLE);

                    downTimer.start();
                } else {
                    quizChoiceD.setVisibility(View.GONE);
                    quizImgChoiceD.setImageResource(R.drawable.ic_wrong);
                    quizImgChoiceD.setVisibility(View.VISIBLE);
                }
            }
        });
    }

    private void prepareQuizData() {
        Quiz quiz = new Quiz(
                "Alkana",
                "Rumus umum dari Alkana adalah ...",
                "CnH2n+2",
                "CnH2n",
                "CnHn+2",
                "CnH2n+2",
                "CnHn"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkana",
                "Rumus kimia dari Butana adalah ...",
                "C4H10",
                "CH6",
                "C3H8",
                "C4H10",
                "C2H6"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkana",
                "Rumus kimia dari Metana adalah ...",
                "CH4",
                "CH4",
                "CH6",
                "C2H6",
                "C2HO"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkana",
                "Rumus kimia dari Etana adalah ...",
                "C2H6",
                "CH4",
                "CH6",
                "C2H6",
                "C2HO"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkana",
                "Senyawa C4H10 memiliki berapa kemungkinan rumus struktur ?",
                "2",
                "1",
                "2",
                "3",
                "4"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkana",
                "Angka oktan digunakan untuk mengekspresikan ...",
                "Jumlah oktan pada bensin",
                "Sebuah viskositas minyak",
                "Kendaraan dengan bahan bakar ber-oktan",
                "Kualitas gasoine sebagai afuel untuk mesin tegangan tinggi",
                "Jumlah oktan pada bensin"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkana",
                "Bensin premium memiliki angka oktan dari 80, berarti bensin tersebut terdiri dari ...",
                "80% isooktana dan 20% n-heptana",
                "80% isooktana dan 20% n-heptana",
                "80% heptana dan 20% isooktana",
                "80% butana dan 20% isooktana",
                "80% isooktana dan 20% n-butana"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkana",
                "Alkana yang digunakan sebagai LPG adalah ...",
                "Propana",
                "Metana",
                "Oktan",
                "Propana",
                "Pentana"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkana",
                "Nama lain dari Alkana adalah ...",
                "Parafin",
                "Parafin",
                "Asitelen",
                "Rantai Karbon",
                "Alifatik"
        );
        quizList.add(quiz);

        quiz = new Quiz(
                "Alkana",
                "Alkana tergolong senyawa hidrokarbon ...",
                "Alifatik jenuh",
                "Alifatik tidak jenuh",
                "Alifatik jenuh",
                "Alisiklik tidak jenuh",
                "Aromatik"
        );
        quizList.add(quiz);
    }

    @Override
    public void onBackPressed() {
        downTimer.cancel();
        quizTimer.cancel();

        finish();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();

        return super.onSupportNavigateUp();
    }
}
