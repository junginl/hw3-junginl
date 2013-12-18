

/* First created by JCasGen Wed Sep 11 13:44:28 EDT 2013 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;

import org.apache.uima.jcas.cas.FSArray;

/** 
 * Updated by JCasGen Wed Oct 09 21:20:35 EDT 2013
 * XML source: /Users/junginlee/git/hw2-junginl/hw2-junginl/src/main/resources/descriptors/deiis_types.xml
 * @generated */
public class Question extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Question.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Question() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Question(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Question(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Question(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
//*--------------*
  //* Feature: unigrams

  /** getter for unigrams - gets Array of unigrams for this question.
   * @generated */
  public FSArray getUnigrams() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_unigrams == null)
      jcasType.jcas.throwFeatMissing("unigrams", "edu.cmu.deiis.types.Question");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Question_Type)jcasType).casFeatCode_unigrams)));}
    
  /** setter for unigrams - sets Array of unigrams for this question. 
   * @generated */
  public void setUnigrams(FSArray v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_unigrams == null)
      jcasType.jcas.throwFeatMissing("unigrams", "edu.cmu.deiis.types.Question");
    jcasType.ll_cas.ll_setRefValue(addr, ((Question_Type)jcasType).casFeatCode_unigrams, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for unigrams - gets an indexed value - Array of unigrams for this question.
   * @generated */
  public NGram getUnigrams(int i) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_unigrams == null)
      jcasType.jcas.throwFeatMissing("unigrams", "edu.cmu.deiis.types.Question");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Question_Type)jcasType).casFeatCode_unigrams), i);
    return (NGram)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Question_Type)jcasType).casFeatCode_unigrams), i)));}

  /** indexed setter for unigrams - sets an indexed value - Array of unigrams for this question.
   * @generated */
  public void setUnigrams(int i, NGram v) { 
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_unigrams == null)
      jcasType.jcas.throwFeatMissing("unigrams", "edu.cmu.deiis.types.Question");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Question_Type)jcasType).casFeatCode_unigrams), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Question_Type)jcasType).casFeatCode_unigrams), i, jcasType.ll_cas.ll_getFSRef(v));}
   
    
  //*--------------*
  //* Feature: bigrams

  /** getter for bigrams - gets Array of bigrams for this question.
   * @generated */
  public FSArray getBigrams() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_bigrams == null)
      jcasType.jcas.throwFeatMissing("bigrams", "edu.cmu.deiis.types.Question");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Question_Type)jcasType).casFeatCode_bigrams)));}
    
  /** setter for bigrams - sets Array of bigrams for this question. 
   * @generated */
  public void setBigrams(FSArray v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_bigrams == null)
      jcasType.jcas.throwFeatMissing("bigrams", "edu.cmu.deiis.types.Question");
    jcasType.ll_cas.ll_setRefValue(addr, ((Question_Type)jcasType).casFeatCode_bigrams, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for bigrams - gets an indexed value - Array of bigrams for this question.
   * @generated */
  public NGram getBigrams(int i) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_bigrams == null)
      jcasType.jcas.throwFeatMissing("bigrams", "edu.cmu.deiis.types.Question");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Question_Type)jcasType).casFeatCode_bigrams), i);
    return (NGram)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Question_Type)jcasType).casFeatCode_bigrams), i)));}

  /** indexed setter for bigrams - sets an indexed value - Array of bigrams for this question.
   * @generated */
  public void setBigrams(int i, NGram v) { 
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_bigrams == null)
      jcasType.jcas.throwFeatMissing("bigrams", "edu.cmu.deiis.types.Question");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Question_Type)jcasType).casFeatCode_bigrams), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Question_Type)jcasType).casFeatCode_bigrams), i, jcasType.ll_cas.ll_getFSRef(v));}
   
    
  //*--------------*
  //* Feature: trigrams

  /** getter for trigrams - gets Array of trigrams for this question.
   * @generated */
  public FSArray getTrigrams() {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_trigrams == null)
      jcasType.jcas.throwFeatMissing("trigrams", "edu.cmu.deiis.types.Question");
    return (FSArray)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefValue(addr, ((Question_Type)jcasType).casFeatCode_trigrams)));}
    
  /** setter for trigrams - sets Array of trigrams for this question. 
   * @generated */
  public void setTrigrams(FSArray v) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_trigrams == null)
      jcasType.jcas.throwFeatMissing("trigrams", "edu.cmu.deiis.types.Question");
    jcasType.ll_cas.ll_setRefValue(addr, ((Question_Type)jcasType).casFeatCode_trigrams, jcasType.ll_cas.ll_getFSRef(v));}    
    
  /** indexed getter for trigrams - gets an indexed value - Array of trigrams for this question.
   * @generated */
  public NGram getTrigrams(int i) {
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_trigrams == null)
      jcasType.jcas.throwFeatMissing("trigrams", "edu.cmu.deiis.types.Question");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Question_Type)jcasType).casFeatCode_trigrams), i);
    return (NGram)(jcasType.ll_cas.ll_getFSForRef(jcasType.ll_cas.ll_getRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Question_Type)jcasType).casFeatCode_trigrams), i)));}

  /** indexed setter for trigrams - sets an indexed value - Array of trigrams for this question.
   * @generated */
  public void setTrigrams(int i, NGram v) { 
    if (Question_Type.featOkTst && ((Question_Type)jcasType).casFeat_trigrams == null)
      jcasType.jcas.throwFeatMissing("trigrams", "edu.cmu.deiis.types.Question");
    jcasType.jcas.checkArrayBounds(jcasType.ll_cas.ll_getRefValue(addr, ((Question_Type)jcasType).casFeatCode_trigrams), i);
    jcasType.ll_cas.ll_setRefArrayValue(jcasType.ll_cas.ll_getRefValue(addr, ((Question_Type)jcasType).casFeatCode_trigrams), i, jcasType.ll_cas.ll_getFSRef(v));}
  }
  


    