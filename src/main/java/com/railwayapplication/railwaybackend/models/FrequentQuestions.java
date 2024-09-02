package com.railwayapplication.railwaybackend.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class FrequentQuestions {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long fq_id;
    private String question;
    private String answers;
    private String feedback;

    public Long getFq_id() {
        return fq_id;
    }

    public void setFq_id(Long fq_id) {
        this.fq_id = fq_id;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getAnswers() {
        return answers;
    }

    public void setAnswers(String answers) {
        this.answers = answers;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}
