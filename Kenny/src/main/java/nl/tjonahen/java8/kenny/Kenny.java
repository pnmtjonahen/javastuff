/*
 * Copyright (C) 2015 Philippe Tjon-A-Hen philippe@tjonahen.nl
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
package nl.tjonahen.java8.kenny;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 *
 * @author Philippe Tjon - A - Hen, philippe@tjonahen.nl
 */
public class Kenny {

    /**
     * The KENNYLETTERS in alphabetical order. Big Letters are the Same with the only difference That the First char is
     * UpperCase
     */
    private static final String[] KENNYLETTERS = {"mmm", "mmp", "mmf", "mpm",
        "mpp", "mpf", "mfm", "mfp", "mff", "pmm", "pmp", "pmf", "ppm",
        "ppp", "ppf", "pfm", "pfp", "pff", "fmm", "fmp", "fmf", "fpm",
        "fpp", "fpf", "ffm", "ffp"};

    public String encode(final String input) {
        return Arrays.asList(input.split("")).stream().map(s -> s.matches("[a-z]")
                ? KENNYLETTERS[s.charAt(0) - 'a']
                : (s.matches("[A-Z]")
                        ? KENNYLETTERS[s.charAt(0) - 'A'].substring(0, 1).toUpperCase() 
                                + KENNYLETTERS[s.charAt(0) - 'A'].substring(1)
                        : s))
                .reduce("", (t, u) -> t + u);
    }

    public String decode(final String input) {
        return Arrays.asList(input.split(" ")).stream().map(w -> Arrays.asList(
                Arrays.asList(w.split(""))
                .stream()
                .map(k -> "FMP".contains(k.toUpperCase()) ? k : k + k + k)
                .reduce("", (t, u) -> t + u).split("(?<=\\G...)"))
                .stream().map(k -> (char) IntStream.range(0, KENNYLETTERS.length)
                        .filter(i -> KENNYLETTERS[i].equals(k.toLowerCase()))
                        .map(i -> Character.isUpperCase(k.charAt(0)) ? (char) ('A' + i) : (char) ('a' + i))
                        .findFirst()
                        .orElse(k.charAt(0)))
                .map(k -> "" + k).reduce("", (t, u) -> t + u))
                .reduce("", (t, u) -> t.equals("") ? u : t + " " + u);
    }
}
