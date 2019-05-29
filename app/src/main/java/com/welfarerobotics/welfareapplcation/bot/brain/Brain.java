package com.welfarerobotics.welfareapplcation.bot.brain;

import com.welfarerobotics.welfareapplcation.bot.Mouth;
import com.welfarerobotics.welfareapplcation.bot.brain.chat.intent.IntentClassifier;
import com.welfarerobotics.welfareapplcation.bot.brain.chat.preprocess.Preprocessor;
import com.welfarerobotics.welfareapplcation.bot.brain.chat.state.ChatState;

/**
 * @Author : Hyunwoong
 * @When : 3/23/2019 10:58 PM
 * @Homepage : https://github.com/gusdnd852
 * <p>
 * 뇌를 모방한 클래스
 * 모든 인공지능 처리의 중추
 * State Pattern 으로 구현됨
 */
public final class Brain {
    private static ChatState currentState = ChatState.NORMAL_STATE;
    public static Hippocampus hippocampus = new Hippocampus();
    private static String intent;

    public static void think(String speech) {
        try {
            System.out.println("입력 : " + speech);
            String preprocessedSpeech = Preprocessor.preprocess(speech);
            intent = IntentClassifier.classify(preprocessedSpeech);
            currentState = currentState.think(intent, preprocessedSpeech);
        } catch (Throwable ignore) {
            currentState = ChatState.FALLBACK_STATE
                    .think(intent, speech); // 엑셉션 발생시 FALLBACK 스테이트로 전환
        }
    }

    public static void speech(Mouth mouth) {
        currentState = currentState.speech(mouth);
    }

    public static void draw() {
        // Generative Adversarial Nets
    }
}