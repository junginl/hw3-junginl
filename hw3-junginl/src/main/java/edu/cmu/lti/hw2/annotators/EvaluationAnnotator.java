package edu.cmu.lti.hw2.annotators;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.fit.util.JCasUtil;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Level;
import org.apache.uima.util.Logger;

import java.io.IOException;

import edu.cmu.deiis.types.Answer;
import edu.cmu.deiis.types.AnswerScore;
import edu.cmu.deiis.types.Question;
import edu.stanford.nlp.dcoref.CorefChain;
import edu.stanford.nlp.dcoref.CorefCoreAnnotations.CorefChainAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.NamedEntityTagAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.PartOfSpeechAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TextAnnotation;
import edu.stanford.nlp.ling.CoreAnnotations.TokensAnnotation;
import edu.stanford.nlp.ling.CoreLabel;
import edu.stanford.nlp.ling.Word;
import edu.stanford.nlp.pipeline.Annotation;
import edu.stanford.nlp.pipeline.StanfordCoreNLP;
import edu.stanford.nlp.process.PTBTokenizer.PTBTokenizerFactory;
import edu.stanford.nlp.process.Tokenizer;
import edu.stanford.nlp.process.TokenizerFactory;
import edu.stanford.nlp.tagger.maxent.MaxentTagger;
import edu.stanford.nlp.util.CoreMap;

/**
 * Homework 2 of 11791 F13: Designing Analysis Engine
 * 
 * @author Jung In Lee <junginl@cs.cmu.edu>
 */

public class EvaluationAnnotator extends JCasAnnotator_ImplBase {

  /**
   * Computes the precision.
   */
  
  private double avgPrecision = 0.0;
  private int nDoc = 0;
  
  public void initialize(UimaContext aContext) throws ResourceInitializationException {
    super.initialize(aContext);
}
  
  @Override
  public void process(JCas arg0) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    Question question = JCasUtil.selectSingle(arg0, Question.class);
    List<AnswerScore> answerScoreList = new ArrayList<AnswerScore>(JCasUtil.select(arg0,
    AnswerScore.class));
    // N used in Precision@N
    int nValue = 0;
    int cValue = 0;
    double precisionAtN = 0.0;
    
    System.out.println("Question: " + question.getCoveredText());
    
    Collections.sort(answerScoreList, new Comparator<AnswerScore>() {
      @Override
      public int compare(AnswerScore ansS1, AnswerScore ansS2) {
        return ansS1.getScore() > ansS2.getScore() ? -1 : 1;
      }
    });

    Iterator<AnswerScore> iter = answerScoreList.iterator();
    Answer answer = null;
    AnswerScore answerScore = null;

    while (iter.hasNext()) {
      answerScore = iter.next();
      answer = answerScore.getAnswer();
      if (answer.getIsCorrect()) {
        nValue++;
        System.out.println("+ " + this.roundTwoDecimals(answerScore.getScore()) + " "
                + answer.getCoveredText());
      } else {
        System.out.println("- " + this.roundTwoDecimals(answerScore.getScore()) + " "
                + answer.getCoveredText());
      }
    }

    for (int at = 0; at < nValue; at++) {
      answer = answerScoreList.get(at).getAnswer();
      if (answer.getIsCorrect()) {
        cValue++;
      }
    }

    precisionAtN = ((double) cValue) / nValue;
    System.out.println("Precision at " + nValue + ": " + this.roundTwoDecimals(precisionAtN));
    nDoc++;
    avgPrecision += precisionAtN;

  }

  /**
   * Perfrom Final statistic- Compute Average Precision
   */
  @Override
  public void collectionProcessComplete() throws AnalysisEngineProcessException {
    System.out.println("Average Precision: " + this.roundTwoDecimals(avgPrecision / nDoc));
  }

  /**
   * 
   * Get the 2 decimal point rounded double value for pretty print
   * 
   * @param d
   * @return
   */
  double roundTwoDecimals(double d) {
    DecimalFormat twoDForm = new DecimalFormat("#.##");
    return Double.valueOf(twoDForm.format(d));
    
   }
}
