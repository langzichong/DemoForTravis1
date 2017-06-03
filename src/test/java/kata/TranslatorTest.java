package kata;

import org.junit.Assert;
import org.junit.Test;
import primegen.Day;
import primegen.Person;

import static junit.framework.TestCase.assertEquals;

public class TranslatorTest {

    public static final String Vowels = "aeiouyAEIOUY";

    @Test
    public void pig_latin_rules() {
        assertEquals("appleway", toPigLatin("apple"));
        assertEquals("ananabay", toPigLatin("banana"));
        assertEquals("Appleway", toPigLatin("Apple"));
        assertEquals("Ananabay", toPigLatin("Banana"));
    }

    String toPigLatin(String englishWord) {
        if (isVowel(englishWord, 0)) {
            return englishWord + "way";
        }

        int firstVowelPosition = 0;
        for (int i = 0; i < englishWord.length(); i++) {
            if (isVowel(englishWord, i)) {
                firstVowelPosition = i;
                break;
            }
        }

        String headWord = englishWord.substring(firstVowelPosition);
        String tailWord = englishWord.substring(0, firstVowelPosition).toLowerCase();

        String result = headWord + tailWord + "ay";

        if (Character.isUpperCase(englishWord.charAt(0))) {
            String word = result;
            Character ch = Character.toUpperCase(word.charAt(0));
            word = ch + word.substring(1);
            result = word;
        }else{
        }

        return result;
    }

    private boolean isVowel(String input, int i) {
        return Vowels.contains(((Character) input.charAt(i)).toString());
    }



    private boolean isValid(String password){
        return password==null||password.length()<10||hasDigit(password)?false:true;
    }
    private boolean hasDigit(String password){
        char[] passwordChars = password.toCharArray();
        for(int i=0;i<password.length();i++){
            if(Character.isLetter(passwordChars[i])){
                return true;
            }
        }
        return false;
    }
    @Test
    public void testValidPassword(){
        Assert.assertFalse(isValid("1234444a"));
    }

    public boolean canHaveHoliday(Person person, Day day){
//        if(person.age<=12&&day.month==6&&day.day==1){
//            return true;
//        }
//        if(person.gender.equals("woman")&&day.month==3&&day.day==8){
//            return true;
//        }
//        return false;
        if(person.isChild()&&day.isChildenDay()){
            return true;
        }
        if(person.isFemale()&&day.isWomenDay()){
            return true;
        }
        return false;
    }
    @Test
    public void testHoliday(){
        Assert.assertTrue(canHaveHoliday(new Person(33,"f"),new Day(3,8)));
        Assert.assertFalse(canHaveHoliday(new Person(33,"f"),new Day(3,9)));
        Assert.assertFalse(canHaveHoliday(new Person(33,"f"),new Day(6,1)));
        Assert.assertTrue(canHaveHoliday(new Person(5,"M"),new Day(6,1)));

    }

}