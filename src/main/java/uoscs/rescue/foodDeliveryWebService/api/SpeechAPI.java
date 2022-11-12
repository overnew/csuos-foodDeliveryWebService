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

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SpeechAPI {

  protected static List<String> syncRecognizeFile(String fileName) throws Exception {

    try (SpeechClient speech = SpeechClient.create()) {

      Path path = Paths.get(fileName);
      byte[] data = Files.readAllBytes(path);
      ByteString audioBytes = ByteString.copyFrom(data);

      SpeechContext speechContext = SpeechContext.newBuilder().addAllPhrases(Arrays.asList(TokenData.getAll())).build();

      RecognitionConfig config =
          RecognitionConfig.newBuilder()
              .setEncoding(AudioEncoding.LINEAR16)
              .setLanguageCode("ko-KR")
              .setSampleRateHertz(16000)
              .addSpeechContexts(speechContext)
              .build();
      RecognitionAudio audio = RecognitionAudio.newBuilder().setContent(audioBytes).build();

      RecognizeResponse response = speech.recognize(config, audio);
      List<SpeechRecognitionResult> results = response.getResultsList();

      List<String> res = new ArrayList();
      for (SpeechRecognitionResult result : results) {
        SpeechRecognitionAlternative alternative = result.getAlternativesList().get(0);
        String temp = alternative.getTranscript();
        String[] tempArr = temp.split(" ");

        res.addAll(Arrays.asList(tempArr));

        System.out.printf("Transcription: %s%n", alternative.getTranscript());
      }

      return res;
    }
  }
}