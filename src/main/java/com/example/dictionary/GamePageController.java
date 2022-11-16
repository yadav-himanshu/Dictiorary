package com.example.dictionary;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.util.HashMap;

public class GamePageController {
    wordDictionary dictionaryList;
    @FXML
    TextField searchWord;
    @FXML
    TextField word;
    @FXML
    TextField meaning;
    @FXML
    public void newWord(MouseEvent event) throws IOException{
        System.out.println("New word Added");
        dictionaryList=new wordDictionary();
        dictionaryList.deserializeMap();
        Alert infoAlert=new Alert(Alert.AlertType.INFORMATION);
        if(word.textProperty().get().equals("")||meaning.textProperty().get().equals(""))
        {
            infoAlert.setContentText("Please enter a word/meaning");
            infoAlert.showAndWait();
        }
        else{
            infoAlert.setHeaderText("New Word Adding");
            dictionaryList.addWord(word.textProperty().get(), meaning.textProperty().get());
            dictionaryList.serializeMap();
            infoAlert.setContentText("New Word Has Added to Dictionary");
            infoAlert.showAndWait();
        }
    }
    @FXML
    public void search(MouseEvent event) throws IOException{
        System.out.println("Searching for a word");
        dictionaryList=new wordDictionary();
        dictionaryList.deserializeMap();
        Alert infoAlert=new Alert(Alert.AlertType.INFORMATION);
        infoAlert.setHeaderText("Search Result");

        if(searchWord.textProperty().get().equals(""))
        {
            infoAlert.setContentText(dictionaryList.getWordList().get("Please Enter a Word for search"));
            infoAlert.showAndWait();
        }
        if(dictionaryList.getWordList().containsKey(searchWord.textProperty().get()))
        {
            System.out.println(dictionaryList.getWordList().get(searchWord.textProperty().get()));
            infoAlert.setContentText(dictionaryList.getWordList().get(searchWord.textProperty().get()));
            infoAlert.showAndWait();
        }
        else{
            infoAlert.setHeaderText("Search Result");
            infoAlert.setContentText("Word is not Present");
            infoAlert.showAndWait();

        }
    }
}
