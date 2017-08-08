package com.example.mayc.openmind.models;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by decam9 on 8/3/17.
 */

public class Keywords {



    public String [] gender = {
            "abortion", "body", "gender identity", "gender equality", "derived rights", "discrimination",
            "disadvantaged groups", "domestic violence", "double standards", "marriage", "Title IX",
            "family planning", "female", "feminism", "identify", "identity", "roles", "sex",
            "rights", "human trafficking", "intersex", "sexism", "transgender", "transphobia",
            "transsexual", "woman", "cisgender", "neutral", "androgyny", "equality", "diversity",
            "inclusion", "minority", "prejudices", "tokenism", "oppress", "injustice"
    };

    public String [] age = {
            "youth", "millennials", "senior citizen", "grey pound", "teens", "twenties", "thirties",
            "forties", "fifties", "sixties", "seventies", "eighties", "elder", "baby boomer", "children",
            "adulthood", "middle age", "age", "victim", "privilege", "injustice", "disparity"
    };

    public String [] sexualOrientation = {
            "bisexual", "gay", "LGBT", "homosexual", "lesbian", "pansexual", "queer", "same-sex",
            "sexual orientation", "swing", "SSM", "biphobia", "homophobia", "LGBTQ", "Pomosexual",
            "Omnisexual", "pansexual", "equality", "bullying", "diversity", "inclusion", "prejudices"
            , "tokenism", "victim", "oppress", "injustice"
    };

    public String [] race = {
            "alien", "color", "anti-semitic", "minority", "foreigner", "racism", "nativism",
            "race card", "race", "ethnicity", "white supremacy", "discrimination", "nationality",
            "Xenophobia", "equality", "bullying", "diversity", "inclusion", "stereotypes", "minority"
            , "prejudices", "tokenism", "victim", "privilege", "oppress", "injustice", "disparity"

    };

    public String[] income = {
            "middle class", "the have-nots", "net-worth", "poor", "gentrification", "homeless",
            "working class", "government housing", "gross income", "net income", "student loan",
            "economy", "recession", "income", "minority", "privilege", "oppress", "injustice", "disparity"
    };

    public String[] disability = {
            "accessiblility", "blind", "challenged", "mental health", "disability", "handicap",
            "impaired", "crippled", "invalid", "syndrome", "paraplegic", "retard", "mute",
            "special education", "special needs", "wheelchair", "depression", "suicidal", "bullying",
            "inclusion", "minority", "tokenism", "victim", "oppress", "injustice"

    };

    public Keywords(){};

    public Keywords(String[] gender, String[] age, String[] sexualOrientation, String[] race, String[] income, String[] disability){
        this.gender = gender;
        this.age = age;
        this.sexualOrientation = sexualOrientation;
        this.race = race;
        this.income = income;
        this.disability = disability;
    };


    public Set<String> getGender(){
        return new HashSet<String>(Arrays.asList(gender));
    }
    public Set<String> getAge(){
        return new HashSet<>(Arrays.asList(age));
    }
    public Set<String> getSexualOrientation(){
        return new HashSet<>(Arrays.asList(sexualOrientation));
    }
    public Set<String> getRace(){
        return new HashSet<>(Arrays.asList(race));
    }
    public Set<String> getIncome(){
        return new HashSet<>(Arrays.asList(income));
    }
    public Set<String> getDisability(){
        return new HashSet<>(Arrays.asList(disability));
    }

    public String[] setGender(){
        return this.gender = gender;
    }
    public String[] setAge(){
        return this.age = age;
    }
    public String[] setSexualOrientation(){
        return this.sexualOrientation = sexualOrientation;
    }
    public String[] setRace(){
        return this.race = race;
    }
    public String[] setIncome(){
        return this.income = income;
    }
    public String[] setDisability(){
        return this.disability = disability;
    }






}