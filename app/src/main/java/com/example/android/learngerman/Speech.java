package com.example.android.learngerman;

import android.speech.tts.TextToSpeech;

import java.util.Locale;

public class Speech {
    private static TextToSpeech tts;
    private static String S_str;

    public static void talk(String str) {
        S_str = str;
        tts = new TextToSpeech(App.getContext(), status -> {
            if(status != TextToSpeech.ERROR) {
                tts.setLanguage(Locale.GERMANY);
                tts.setPitch(1.3f);
                tts.setSpeechRate(0.5f);
                tts.speak(S_str, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }
}
