package com.iyokan.geocapserver;

import org.json.JSONArray;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class QuizRound {
    private String question;
    private ArrayList<String> alternatives = new ArrayList<String>();

    public QuizRound(String question, ArrayList<String> alternatives){
        this.question = question;
        this.alternatives = alternatives;
    }

    public String getQuestion(){
        return question;
    }

    public ArrayList<String> getAlternatives(){
        return alternatives;
    }

    public ArrayList<String> getAlternativesRandom() {
        ArrayList<String> randomOrder = new ArrayList<>(alternatives);
        Collections.shuffle(randomOrder);
        return randomOrder;
    }

    public QuizRound(JSONObject object){
        this.question  = object.getString("question");
        JSONArray array = object.getJSONArray("alternatives");
        for(int i = 0; i < array.length(); i++) {
            this.alternatives.add(array.get(i).toString());
        }
    }

    public boolean checkAnswer(String playerAnswer){
        if (playerAnswer.equalsIgnoreCase(alternatives.get(0))){
            return true;
        }
        else {
            return false;
        }
    }

    public String getCorrectAnswer() {
        return alternatives.get(0);
    }
}
