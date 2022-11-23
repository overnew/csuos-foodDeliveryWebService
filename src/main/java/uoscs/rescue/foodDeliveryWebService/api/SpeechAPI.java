package uoscs.rescue.foodDeliveryWebService.api;

import com.google.cloud.speech.v1.RecognitionAudio;
import com.google.cloud.speech.v1.RecognitionConfig;
import com.google.cloud.speech.v1.RecognitionConfig.AudioEncoding;
import com.google.cloud.speech.v1.RecognizeResponse;
import com.google.cloud.speech.v1.SpeechClient;
import com.google.cloud.speech.v1.SpeechContext;
import com.google.cloud.speech.v1.SpeechRecognitionAlternative;
import com.google.cloud.speech.v1.SpeechRecognitionResult;
import com.google.protobuf.ByteString;
import lombok.extern.slf4j.Slf4j;

import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
class SpeechAPI {

  protected static List<String> syncRecognizeFile(byte[] bytes) throws Exception {

    log.info("asdf");

    try (SpeechClient speech = SpeechClient.create()) {

      ByteString audioBytes = ByteString.copyFrom(bytes);

      SpeechContext speechContext = SpeechContext.newBuilder().addAllPhrases(TokenData.getAllKey()).build();

      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.WEBM_OPUS)
              .setLanguageCode("ko-KR")
              .setSampleRateHertz(48000)
              .addSpeechContexts(speechContext)
              .build();
      RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(audioBytes).build();

      RecognizeResponse response = speech.recognize(config, audio);
      List<SpeechRecognitionResult> results = response.getResultsList();

      log.info(response.getResultsList().toString());

      List<String> res = new ArrayList<>();
      for (SpeechRecognitionResult result : results) {
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        String temp = alternative.getTranscript();
        String[] tempArr = temp.split(" ");

        res.addAll(Arrays.asList(tempArr));
      }

      log.info(res.toString());

      return res;
    }
  }
}