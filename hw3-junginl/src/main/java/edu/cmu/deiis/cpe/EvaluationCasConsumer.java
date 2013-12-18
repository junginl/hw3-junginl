
package edu.cmu.deiis.cpe;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.ProcessTrace;
import org.cleartk.ne.type.NamedEntityMention;

import edu.cmu.deiis.types.AnswerScore;
import edu.cmu.deiis.types.NGram;
import edu.cmu.deiis.types.Question;

/**
 * Evaluation Cas Consumer.
 */
public class EvaluationCasConsumer extends CasConsumer_ImplBase {

  private double totalPrecision = 0.0;

  private int numCases = 0;

  /**
   * Initializes the CAS consumer.
   */
  public void initialize() throws ResourceInitializationException {
  }

  public void processCas(CAS aCAS) throws ResourceProcessException {
    JCas aJCas;
    try {
      aJCas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }
    // Question
    FSIndex questionIndex = aJCas.getAnnotationIndex(Question.type);
    Iterator questionIter = questionIndex.iterator();
    Question question = null;
    while (questionIter.hasNext())
      question = (Question) questionIter.next();
    // Name entities in question sentence
    
    ArrayList<NamedEntityMention> questionNE = new ArrayList<NamedEntityMention>();
    FSIndex neQind = aJCas.getAnnotationIndex(NamedEntityMention.type);
    Iterator neQIter = neQind.iterator();
    
    while (neQIter.hasNext()) {
      NamedEntityMention ne = (NamedEntityMention) neQIter.next();
    }
    
    
    // Answer scores
    FSIndex answerScoreIndex = aJCas.getAnnotationIndex(AnswerScore.type);
    
    int nn = 0;
  
    AnswerScore[] rank = new AnswerScore[answerScoreIndex.size()];
 
    ArrayList<AnswerScore> answerScores = new ArrayList<AnswerScore>();

    Iterator answerScoreIter = answerScoreIndex.iterator();
    
    while (answerScoreIter.hasNext()) {
    
      AnswerScore answerScore = (AnswerScore) answerScoreIter.next();
      
      if (answerScore.getAnswer().getIsCorrect())
        nn++;
      answerScores.add(answerScore);
    }
    
    
    for (AnswerScore answerScore : answerScores) {
      ArrayList<NamedEntityMention> answerNamedEntities = new ArrayList<NamedEntityMention>();
      FSIndex neAnswerIndex = aJCas.getAnnotationIndex(NamedEntityMention.type);
      Iterator neAnswerIter = neAnswerIndex.iterator();
      while (neAnswerIter.hasNext()) {
        NamedEntityMention ne = (NamedEntityMention) neAnswerIter.next();

      int matchNE = 0;
      for (int i = 0; i < questionNE.size(); i++) {
        for (int j = 0; j < answerNamedEntities.size(); j++) {
          NamedEntityMention qNE = (NamedEntityMention) questionNE.get(i);
          NamedEntityMention aNE = (NamedEntityMention) answerNamedEntities.get(j);
          if (qNE.getCoveredText().equals(aNE.getCoveredText())) {
            matchNE++;
          }
        }
      }

      double ngramScore = 0.5 * answerScore.getScore();
      double neScore = 0.5 * ((double) matchNE / (double) questionNE.size());
      answerScore.setScore(ngramScore + neScore);
    }
    
    // sort answerScores arrayList
    for (int i = 0; i < rank.length; i++) {
      double bestScore = 0.0;
      int bestIndex = 0;
      for (int j = 0; j < answerScores.size(); j++) {
        if (answerScores.get(j).getScore() > bestScore) {
          bestScore = answerScores.get(j).getScore();
          bestIndex = j;
        }
      }
      rank[i] = answerScores.get(bestIndex);
      answerScores.remove(bestIndex);
    }
    // count up correct answers in top N of ranking
    int numCorrect = 0;
    for (int i = 0; i < nn; i++) {
      if (rank[i].getAnswer().getIsCorrect() == true)
        numCorrect++;
    }
    
    // precision
    double precisionAtN = ((double) numCorrect / (double) nn);
    // print question to stdout
    System.out.println("Question: " + question.getCoveredText());
    // print each answerScore to stdout
    for (int i = 0; i < rank.length; i++) {
      AnswerScore answerScore1 = (AnswerScore) rank[i];
      // print "+" for isCorrect "-" otherwise
      if (answerScore1.getAnswer().getIsCorrect())
        System.out.print("+ ");
      else
        System.out.print("- ");
      System.out.print((Math.floor(answerScore1.getScore() * 100) / 100) + " ");
      System.out.println(answerScore1.getAnswer().getCoveredText());
    }
    System.out.println("Precision at " + nn + ": " + precisionAtN + "\n");
    
    totalPrecision += precisionAtN;
    numCases++;
    }
  }

  /**
   * Prints the average precision at the end of a batch of CASes.
   */
  public void collectionProcessComplete(ProcessTrace arg0) throws ResourceProcessException,
          IOException {
    System.out.println("Average Precision: " + (totalPrecision / numCases) + "\n");
  }
}