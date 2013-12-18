package edu.cmu.lti.hw2.annotators;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Iterator;

import org.apache.uima.UimaContext;
import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.util.Level;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.cas.FSArray;

import java.io.IOException;

import edu.cmu.deiis.types.Answer;
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

import edu.cmu.deiis.types.*;

/**
 * Homework 2 of 11791 F13: Designing Analysis Engine
 * 
 * @author Jung In Lee <junginl@cs.cmu.edu>
 */

public class QuestionAnnotator extends JCasAnnotator_ImplBase {
  
  /**
   * The question sentence. 
   */
  private Pattern questionPattern = Pattern.compile("Q [A-Za-z ']+");
  
  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // get document text
    String text = aJCas.getDocumentText();
    // search for questions
    Matcher matcher = questionPattern.matcher(text);
    int pos = 0;
    while (matcher.find(pos)) {
      Question question = new Question(aJCas);
      question.setBegin(matcher.start());
      question.setEnd(matcher.end());
     
      int numWords = matcher.group().split(" ").length - 1;
      // add ngrams to question
      int numUni = 0;
      int numBi = 0;
      int numTri = 0;
      question.setUnigrams(new FSArray(aJCas, numWords));
      question.setBigrams(new FSArray(aJCas, numWords - 1));
      question.setTrigrams(new FSArray(aJCas, numWords - 2));
  

      FSIndex ngramIndex = aJCas.getAnnotationIndex(NGram.type);
      // loop over ngrams
      Iterator ngramIter = ngramIndex.iterator();
      while (ngramIter.hasNext()) {
        // grab an ngram
        NGram ngram = (NGram) ngramIter.next();
        // check if ngram sentence ID is 0 (question is always first sentence)
        if (ngram.getSentenceId() == 0) {
          // check order of ngrams
          if (ngram.getOrder() == 1) {
            // add unigram to unigrams
            question.setUnigrams(numUni, ngram);
            numUni++;
            } 
          else if (ngram.getOrder() == 2) {
            // add bigram to bigrams
            question.setBigrams(numBi, ngram);
            numBi++;
            } 
          else {
            // add trigram to trigrams
            question.setTrigrams(numTri, ngram);
            numTri++;
            }
          }
        }
      // add question to indexes and iterate
      question.addToIndexes();
      pos = matcher.end();
      }
    }
  }
//    //Get the document text (input)
//    String docText = aJCas.getDocumentText();
//    
//    Matcher matcher = questionPattern.matcher(docText);
//    int pos = 0;
//    while (matcher.find(pos)) {
//      // found one - create annotation
//      Question question = new Question(aJCas);
//      question.setBegin(matcher.start());
//      question.setEnd(matcher.end());
//      question.setCasProcessorId("Question");
//      question.addToIndexes();
//      pos = matcher.end();
//    }
////    // Convert the input into arrays of strings, split by lines.
////    String[] lines = docText.split("/n");
////
////    Question question = new Question(aJCas);
////    question.setBegin(0);
////    question.setEnd(lines[0].length());
////    question.setCasProcessorId("Quesiton");
////    question.setConfidence(1.0);
////    question.addToIndexes();
//  }
//  
////private String questionPatternString;
////
////public void initialize(UimaContext aContext) throws ResourceInitializationException {
////     super.initialize(aContext);
////     // Read configuration parameter values
////     setQuestionPatternString((String) getContext().getConfigParameterValue("questionPatternString"));
////}
////
////@Override
////public void process(JCas arg0) throws AnalysisEngineProcessException {
////  // TODO Auto-generated method stub
////  // Get the document text (input)
////  String docText = arg0.getDocumentText();
////
////  Pattern questionPattern = Pattern.compile(this.getQuestionPatternString(), Pattern.CASE_INSENSITIVE);
////  
////  Matcher matcher = questionPattern.matcher(docText);
////  if (matcher.find()) {
////        // Create annotation of type Question
////         Question question = new Question(arg0);
////         question.setBegin(matcher.start());
////         question.setEnd(matcher.end());
////         question.setConfidence(1.0);
////         question.setCasProcessorId("Question");
////         question.addToIndexes();
////       }
//  
////  /**
////  +   * @return the questionPatternString
////  +   */
////   public String getQuestionPatternString() {
////     return questionPatternString;
////   }
////  
////   /**
////     * @param questionPatternString the questionPatternString to set
////     */
////   public void setQuestionPatternString(String questionPatternString) {
////     this.questionPatternString = questionPatternString;
////   }
//}
