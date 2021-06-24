package com.example.inappkeyboard;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.PixelFormat;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.Keyboard;
import android.inputmethodservice.KeyboardView;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.view.inputmethod.InputConnection;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class MyInputMethodService extends InputMethodService implements KeyboardView.OnKeyboardActionListener{

    private String concatInputValue = "";
    private String[] badWords = {"מניאק","חרא", "אפס", "הומו"};

    @Override
    public View onCreateInputView() {
        KeyboardView keyboardView = (KeyboardView) getLayoutInflater().inflate(R.layout.keyboard_view, null);
        Keyboard keyboard = new Keyboard(this, R.xml.key_pad);
        keyboardView.setKeyboard(keyboard);
        keyboardView.setOnKeyboardActionListener(this);
        return keyboardView;
    }

    @Override
    public void onPress(int i) {

    }

    @Override
    public void onRelease(int i) {

    }

    @Override
    public void onKey(int code, int[] keyCodes) {
        /*InputConnection inputConnection = getCurrentInputConnection();

        if (inputConnection != null){
            Log.i("onKey", "Entered the if");
           switch(code) {
                case Keyboard.KEYCODE_DELETE :
                    CharSequence selectedText = inputConnection.getSelectedText(0);

                    if (TextUtils.isEmpty(selectedText)) {
                        inputConnection.deleteSurroundingText(1,0);
                    } else {
                        inputConnection.commitText("", 1);
                    }
                    break;
               case 80 :
                   inputConnection.commitText("פ", 1);
                default :

                    inputConnection.commitText(String.valueOf(code), 1);
            }
            System.out.println("Current code : " + code);*/


        }

    @Override
    public void onText(CharSequence charSequence){
        InputConnection inputConnection = getCurrentInputConnection();

        if (inputConnection != null) {
            switch ((String) charSequence) {
                case "א" :
                    updateConcatInputString("א", true);
                    inputConnection.commitText("א",1);
                    break;
                case "ב" :
                    updateConcatInputString("ב", true);
                    inputConnection.commitText("ב", 1);
                    break;
                case "ג" :
                    updateConcatInputString("ג", true);
                    inputConnection.commitText("ג", 1);
                    break;
                case "ד" :
                    updateConcatInputString("ד", true);
                    inputConnection.commitText("ד", 1);
                    break;
                case "ה" :
                    updateConcatInputString("ה", true);
                    inputConnection.commitText("ה", 1);
                    break;
                case "ו" :
                    updateConcatInputString("ו", true);
                    inputConnection.commitText("ו", 1);
                    break;
                case "ז" :
                    updateConcatInputString("ז", true);
                    inputConnection.commitText("ז", 1);
                    break;
                case "ח" :
                    updateConcatInputString("ח", true);
                    inputConnection.commitText("ח", 1);
                    break;
                case "ט" :
                    updateConcatInputString("ט", true);
                    inputConnection.commitText("ט", 1);
                    break;
                case "י" :
                    updateConcatInputString("י", true);
                    inputConnection.commitText("י", 1);
                    break;
                case "כ" :
                    updateConcatInputString("כ", true);
                    inputConnection.commitText("כ", 1);
                    break;
                case "ל" :
                    updateConcatInputString("ל", true);
                    inputConnection.commitText("ל", 1);
                    break;
                case "מ" :
                    updateConcatInputString("מ", true);
                    inputConnection.commitText("מ", 1);
                    break;
                case "נ" :
                    updateConcatInputString("נ", true);
                    inputConnection.commitText("נ", 1);
                    break;
                case "ס" :
                    updateConcatInputString("ס", true);
                    inputConnection.commitText("ס", 1);
                    break;
                case "ע" :
                    updateConcatInputString("ע", true);
                    inputConnection.commitText("ע", 1);
                    break;
                case "פ" :
                    updateConcatInputString("פ", true);
                    inputConnection.commitText("פ", 1);
                    break;
                case "צ" :
                    updateConcatInputString("צ", true);
                    inputConnection.commitText("צ", 1);
                    break;
                case "ק" :
                    updateConcatInputString("ק", true);
                    inputConnection.commitText("ק", 1);
                    break;
                case "ר" :
                    updateConcatInputString("ר", true);
                    inputConnection.commitText("ר", 1);
                    break;
                case "ש" :
                    updateConcatInputString("ש", true);
                    inputConnection.commitText("ש", 1);
                    break;
                case "ת" :
                    updateConcatInputString("ת", true);
                    inputConnection.commitText("ת", 1);
                    break;
                case "ף" :
                    updateConcatInputString("ף", true);
                    inputConnection.commitText("ף", 1);
                    break;
                case "ץ" :
                    updateConcatInputString("ץ", true);
                    inputConnection.commitText("ץ", 1);
                    break;
                case "ן" :
                    updateConcatInputString("ן", true);
                    inputConnection.commitText("ן", 1);
                    break;
                case "ם" :
                    updateConcatInputString("ם", true);
                    inputConnection.commitText("ם", 1);
                    break;
                case "ך" :
                    updateConcatInputString("ך", true);
                    inputConnection.commitText("ך", 1);
                    break;
                case "רווח":
                    inputConnection.commitText(" ",1);
                    // TODO: Check the `concatInputValue` if equals to an inappropriate word and then reset it
                    //checkIfBadWord();
                    try{
                        checkIfWordAppears();
                    }
                    catch (Exception ex){
                        //throw new Exception("File Not Found!");
                    }
                    //testAlert();
                    this.concatInputValue ="";
                    break;
                default:
                    CharSequence selectedText = inputConnection.getSelectedText(0);
                    if (TextUtils.isEmpty(selectedText)) {
                        updateConcatInputString("", false);
                        inputConnection.deleteSurroundingText(1,0);
                    } else {
                        inputConnection.commitText("",1);
                    }
                    break;
            }
        }
    }

    private void updateConcatInputString(String value, boolean addCase){
        this.concatInputValue = addCase ? this.concatInputValue += value : this.concatInputValue.substring(0,this.concatInputValue.length()-1);
    }

    private void checkIfBadWord(){
        if (Arrays.asList(this.badWords).contains(this.concatInputValue)){
            Toast.makeText(getApplicationContext(), "פוגעני!!!", Toast.LENGTH_SHORT).show();
//            Toast toast = Toast.makeText(getApplicationContext(), this.concatInputValue, Toast.LENGTH_LONG);
//            View view = toast.getView();
//            view.setBackgroundResource(R.color.design_default_color_error);
//            TextView text = (TextView) view.findViewById(android.R.id.message);
//            /*Here you can do anything with above textview like text.setTextColor(Color.parseColor("#000000"));*/
//            text.setTextColor(Color.parseColor("#000000"));
//            toast.show();
        }
    }

    private void alertInputText(){
        new AlertDialog.Builder(getApplicationContext())
                .setTitle("Input received:")
                .setMessage(this.concatInputValue)

                // Specifying a listener allows you to take an action before dismissing the dialog.
                // The dialog is automatically dismissed when a dialog button is clicked.
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // Continue with delete operation
                    }
                })

                // A null listener allows the button to dismiss the dialog and take no further action.
                .setNegativeButton(android.R.string.no, null)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }


    private void testAlert(){
        WindowManager windowManager2 = (WindowManager) getSystemService(WINDOW_SERVICE);
        LayoutInflater layoutInflater=(LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=layoutInflater.inflate(R.layout.xxact_copy_popupmenu, null);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_PHONE,
                WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE,
                PixelFormat.TRANSLUCENT);

        params.gravity= Gravity.CENTER|Gravity.CENTER;
        params.x=0;
        params.y=0;
        windowManager2.addView(view, params);
    }


    private void checkIfWordAppears () throws Exception {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("words.csv")));
            String csvfileString = this.getApplicationInfo().dataDir + File.separatorChar + "words.csv";
            FileReader csvfile = new FileReader(csvfileString);



            String row = "";
            BufferedReader csvReader = new BufferedReader(new FileReader(getAssets().open("words.csv")));
            while ((row = csvReader.readLine()) != null) {
                String[] data = row.split(",");
                // do something with the data

            }
            csvReader.close();
        }
        catch (Exception ex){
            throw new Exception("File Not Found!");
        }

//        BufferedReader reader = null;
//        try {
//            reader = new BufferedReader(
//                    new InputStreamReader(getAssets().open("words.csv"), "UTF-8"));
//
//            // do reading, usually loop until end of file reading
//            String mLine;
//            while ((mLine = reader.readLine()) != null) {
//                //process line
//
//            }
//        } catch (IOException e) {
//            //log the exception
//        } finally {
//            if (reader != null) {
//                try {
//                    reader.close();
//                } catch (IOException e) {
//                    //log the exception
//                }
//            }
//        }
    }


    @Override
    public void swipeLeft() {

    }

    @Override
    public void swipeRight() {

    }

    @Override
    public void swipeDown() {

    }

    @Override
    public void swipeUp() {

    }

}
