
/* First created by JCasGen Wed Sep 11 13:44:28 EDT 2013 */
package edu.cmu.deiis.types;

import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.cas.impl.CASImpl;
import org.apache.uima.cas.impl.FSGenerator;
import org.apache.uima.cas.FeatureStructure;
import org.apache.uima.cas.impl.TypeImpl;
import org.apache.uima.cas.Type;
import org.apache.uima.cas.impl.FeatureImpl;
import org.apache.uima.cas.Feature;

/** 
 * Updated by JCasGen Wed Oct 09 21:20:35 EDT 2013
 * @generated */
public class Answer_Type extends Annotation_Type {
  /** @generated */
  @Override
  protected FSGenerator getFSGenerator() {return fsGenerator;}
  /** @generated */
  private final FSGenerator fsGenerator = 
    new FSGenerator() {
      public FeatureStructure createFS(int addr, CASImpl cas) {
  			 if (Answer_Type.this.useExistingInstance) {
  			   // Return eq fs instance if already created
  		     FeatureStructure fs = Answer_Type.this.jcas.getJfsFromCaddr(addr);
  		     if (null == fs) {
  		       fs = new Answer(addr, Answer_Type.this);
  			   Answer_Type.this.jcas.putJfsFromCaddr(addr, fs);
  			   return fs;
  		     }
  		     return fs;
        } else return new Answer(addr, Answer_Type.this);
  	  }
    };
  /** @generated */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = Answer.typeIndexID;
  /** @generated 
     @modifiable */
  @SuppressWarnings ("hiding")
  public final static boolean featOkTst = JCasRegistry.getFeatOkTst("edu.cmu.deiis.types.Answer");
 
  /** @generated */
  final Feature casFeat_isCorrect;
  /** @generated */
  final int     casFeatCode_isCorrect;
  /** @generated */ 
  public boolean getIsCorrect(int addr) {
        if (featOkTst && casFeat_isCorrect == null)
      jcas.throwFeatMissing("isCorrect", "edu.cmu.deiis.types.Answer");
    return ll_cas.ll_getBooleanValue(addr, casFeatCode_isCorrect);
  }
  /** @generated */    
  public void setIsCorrect(int addr, boolean v) {
        if (featOkTst && casFeat_isCorrect == null)
      jcas.throwFeatMissing("isCorrect", "edu.cmu.deiis.types.Answer");
    ll_cas.ll_setBooleanValue(addr, casFeatCode_isCorrect, v);}
    
  
  
  /** @generated */
  final Feature casFeat_unigrams;
  /** @generated */
  final int     casFeatCode_unigrams;
  /** @generated */ 
  public int getUnigrams(int addr) {
        if (featOkTst && casFeat_unigrams == null)
      jcas.throwFeatMissing("unigrams", "edu.cmu.deiis.types.Answer");
    return ll_cas.ll_getRefValue(addr, casFeatCode_unigrams);
  }
  /** @generated */    
  public void setUnigrams(int addr, int v) {
        if (featOkTst && casFeat_unigrams == null)
      jcas.throwFeatMissing("unigrams", "edu.cmu.deiis.types.Answer");
    ll_cas.ll_setRefValue(addr, casFeatCode_unigrams, v);}
    
   /** @generated */
  public int getUnigrams(int addr, int i) {
        if (featOkTst && casFeat_unigrams == null)
      jcas.throwFeatMissing("unigrams", "edu.cmu.deiis.types.Answer");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_unigrams), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_unigrams), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_unigrams), i);
  }
   
  /** @generated */ 
  public void setUnigrams(int addr, int i, int v) {
        if (featOkTst && casFeat_unigrams == null)
      jcas.throwFeatMissing("unigrams", "edu.cmu.deiis.types.Answer");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_unigrams), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_unigrams), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_unigrams), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_bigrams;
  /** @generated */
  final int     casFeatCode_bigrams;
  /** @generated */ 
  public int getBigrams(int addr) {
        if (featOkTst && casFeat_bigrams == null)
      jcas.throwFeatMissing("bigrams", "edu.cmu.deiis.types.Answer");
    return ll_cas.ll_getRefValue(addr, casFeatCode_bigrams);
  }
  /** @generated */    
  public void setBigrams(int addr, int v) {
        if (featOkTst && casFeat_bigrams == null)
      jcas.throwFeatMissing("bigrams", "edu.cmu.deiis.types.Answer");
    ll_cas.ll_setRefValue(addr, casFeatCode_bigrams, v);}
    
   /** @generated */
  public int getBigrams(int addr, int i) {
        if (featOkTst && casFeat_bigrams == null)
      jcas.throwFeatMissing("bigrams", "edu.cmu.deiis.types.Answer");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_bigrams), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_bigrams), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_bigrams), i);
  }
   
  /** @generated */ 
  public void setBigrams(int addr, int i, int v) {
        if (featOkTst && casFeat_bigrams == null)
      jcas.throwFeatMissing("bigrams", "edu.cmu.deiis.types.Answer");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_bigrams), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_bigrams), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_bigrams), i, v);
  }
 
 
  /** @generated */
  final Feature casFeat_trigrams;
  /** @generated */
  final int     casFeatCode_trigrams;
  /** @generated */ 
  public int getTrigrams(int addr) {
        if (featOkTst && casFeat_trigrams == null)
      jcas.throwFeatMissing("trigrams", "edu.cmu.deiis.types.Answer");
    return ll_cas.ll_getRefValue(addr, casFeatCode_trigrams);
  }
  /** @generated */    
  public void setTrigrams(int addr, int v) {
        if (featOkTst && casFeat_trigrams == null)
      jcas.throwFeatMissing("trigrams", "edu.cmu.deiis.types.Answer");
    ll_cas.ll_setRefValue(addr, casFeatCode_trigrams, v);}
    
   /** @generated */
  public int getTrigrams(int addr, int i) {
        if (featOkTst && casFeat_trigrams == null)
      jcas.throwFeatMissing("trigrams", "edu.cmu.deiis.types.Answer");
    if (lowLevelTypeChecks)
      return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_trigrams), i, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_trigrams), i);
  return ll_cas.ll_getRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_trigrams), i);
  }
   
  /** @generated */ 
  public void setTrigrams(int addr, int i, int v) {
        if (featOkTst && casFeat_trigrams == null)
      jcas.throwFeatMissing("trigrams", "edu.cmu.deiis.types.Answer");
    if (lowLevelTypeChecks)
      ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_trigrams), i, v, true);
    jcas.checkArrayBounds(ll_cas.ll_getRefValue(addr, casFeatCode_trigrams), i);
    ll_cas.ll_setRefArrayValue(ll_cas.ll_getRefValue(addr, casFeatCode_trigrams), i, v);
  }
 



  /** initialize variables to correspond with Cas Type and Features
	* @generated */
  public Answer_Type(JCas jcas, Type casType) {
    super(jcas, casType);
    casImpl.getFSClassRegistry().addGeneratorForType((TypeImpl)this.casType, getFSGenerator());

 
    casFeat_isCorrect = jcas.getRequiredFeatureDE(casType, "isCorrect", "uima.cas.Boolean", featOkTst);
    casFeatCode_isCorrect  = (null == casFeat_isCorrect) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_isCorrect).getCode();
    
    
    casFeat_unigrams = jcas.getRequiredFeatureDE(casType, "unigrams", "uima.cas.FSArray", featOkTst);
    casFeatCode_unigrams  = (null == casFeat_unigrams) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_unigrams).getCode();

 
    casFeat_bigrams = jcas.getRequiredFeatureDE(casType, "bigrams", "uima.cas.FSArray", featOkTst);
    casFeatCode_bigrams  = (null == casFeat_bigrams) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_bigrams).getCode();

 
    casFeat_trigrams = jcas.getRequiredFeatureDE(casType, "trigrams", "uima.cas.FSArray", featOkTst);
    casFeatCode_trigrams  = (null == casFeat_trigrams) ? JCas.INVALID_FEATURE_CODE : ((FeatureImpl)casFeat_trigrams).getCode();
    
    
    
  }
}



    