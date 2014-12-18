/*
 * Copyright (C) 2014 Philippe Tjon-A-Hen
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package nl.tjonahen.jaavastuff.java8stuff;

import java.util.ArrayList;
import static java.util.Arrays.asList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;
import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Philippe Tjon - A - Hen
 */
public class WordCloudTest {
    private static final int MAX_WORDS = 250;

    @Test
    public void testWordCloud() {
        final Set<String> filteredWords = getFilteredWords();
        final Collection<Zin> inputCollection = getInputCollection();

                                                                                        // for een collectie van zinnen
        final Map<String, Long> collect = inputCollection.stream()
                .filter(z -> z.getData().contains("Lee"))                               // filter only sentence with Lee in it.
                .flatMap(z -> asList(z.getData()                                        // split de zin in woorden
                                            .toLowerCase()
                                            .replace(",", " ")
                                            .replace("(", " ")
                                            .replace(")", " ")
                                            .replace("\n", " ")
                                            .split(" ")) 
                            .stream()                                                   // filter alleen de toegestane woorden
                            .filter(word -> !"".equals(word))
                            .filter(word -> !"\n".equals(word))
                            .filter(word -> !filteredWords.contains(word))
                    )
                .collect(groupingBy(w -> w, counting()));                               // tel het aantal voorkomens van een woord

        // geef de top 250 woorden met het hoogste aantal voor komens.
         final List<Word> words = collect.entrySet().stream()
                    .map(entry -> new Word(entry.getKey(), entry.getValue().intValue()))// map the Map into a word list
                    .sorted((o1, o2) -> o2.getCount() - o1.getCount())                  // sort the list by wordt count
                    .limit(MAX_WORDS)                                                   // limit the list
                    .collect(toList());
         
         Assert.assertEquals(105, words.size());
         Assert.assertEquals("my", words.get(0).getText());
         Assert.assertEquals(8, words.get(0).getCount());

    }

    private Collection<Zin> getInputCollection() {
        final Collection<Zin> collection = new ArrayList<>();

        collection.add(new Zin("It was many and many a year ago,\nIn a kingdom by the sea,\nThat a maiden there lived whom you may know\nBy the name of ANNABEL LEE;\nAnd this maiden she lived with no other thought\nThan to love and be loved by me."));
        collection.add(new Zin("I was a child and she was a child,\nIn this kingdom by the sea;\nBut we loved with a love that was more than love-\nI and my Annabel Lee;\nWith a love that the winged seraphs of heaven\nCoveted her and me."));
        collection.add(new Zin("And this was the reason that, long ago,\nIn this kingdom by the sea,\nA wind blew out of a cloud, chilling\nMy beautiful Annabel Lee;\nSo that her highborn kinsman came\nAnd bore her away from me,\nTo shut her up in a sepulchre\nIn this kingdom by the sea."));
        collection.add(new Zin("The angels, not half so happy in heaven,\nWent envying her and me-\nYes!- that was the reason (as all men know,\nIn this kingdom by the sea)\nThat the wind came out of the cloud by night,\nChilling and killing my Annabel Lee."));
        collection.add(new Zin("But our love it was stronger by far than the love\nOf those who were older than we-\nOf many far wiser than we-\nAnd neither the angels in heaven above,\nNor the demons down under the sea,\nCan ever dissever my soul from the soul\nOf the beautiful Annabel Lee."));
        collection.add(new Zin("For the moon never beams without bringing me dreams\nOf the beautiful Annabel Lee;\nAnd the stars never rise but I feel the bright eyes\nOf the beautiful Annabel Lee;\nAnd so, all the night-tide, I lie down by the side\nOf my darling- my darling- my life and my bride,\nIn the sepulchre there by the sea,\nIn her tomb by the sounding sea."));

        return collection;
    }

    private Set<String> getFilteredWords() {
        final Set<String> words = new TreeSet<>();
        
        words.add("and");
        words.add("the");
        words.add("a");
        words.add("by");
        words.add("in");
        words.add("of");
        return words;
    }

}
