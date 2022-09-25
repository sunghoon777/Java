package chapter6_openchallenge;

class Word {

    private String koreanWord;
    private String englishWord;

    public Word(String koreanWord, String englishWord) {
        this.koreanWord = koreanWord;
        this.englishWord = englishWord;
    }

    public Word() {
        this("","");
    }

    public String getKoreanWord() {
        return koreanWord;
    }

    public void setKoreanWord(String koreanWord) {
        this.koreanWord = koreanWord;
    }

    public String getEnglishWord() {
        return englishWord;
    }

    public void setEnglishWord(String englishWord) {
        this.englishWord = englishWord;
    }

}
