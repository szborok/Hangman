package hangman.logic;

import java.util.List;

public class WordDefinition {
    
    private String word;
    private String phonetic;
    private List<Phonetic> phonetics;
    private String origin;
    private Meaning meaning;
    
    // Getter methods...
    public String getWord() {
        return word;
    }
    
    public String getPhonetic() {
        return phonetic;
    }
    
    public List<Phonetic> getPhonetics() {
        return phonetics;
    }
    
    public String getOrigin() {
        return origin;
    }
    
    public Meaning getMeaning() {
        return meaning;
    }
    
    
    
    public class Phonetic {
        private String text;
        private String audio;
        
        // Getter methods...
        public String getText() {
            return text;
        }
        
        public String getAudio() {
            return audio;
        }
    }
    
    public class Meaning {
        private List<Definition> exclamation;
        private List<Definition> noun;
        private List<Definition> verb;
        
        // Getter methods...
        public List<Definition> getExclamation() {
            return exclamation;
        }
        
        public List<Definition> getNoun() {
            return noun;
        }
        
        public List<Definition> getVerb() {
            return verb;
        }
    }
    
    public class Definition {
        private String definition;
        private String example;
        private List<String> synonyms;
        private List<String> antonyms;
        
        // Getter methods...
        public String getDefinition() {
            return definition;
        }
        
        public String getExample() {
            return example;
        }
        
        public List<String> getSynonyms() {
            return synonyms;
        }
        
        public List<String> getAntonyms() {
            return antonyms;
        }
    }
}
