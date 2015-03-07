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

import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author Philippe Tjon - A - Hen, philippe@tjonahen.nl
 */
public class KennyTest {

    /**
     * Test of encode method, of class Kenny.
     */
    @Test
    public void testEncode() {
        assertEquals("Fppmffmpp mfffmm pmpmppppppppffm pfm@ffm ppmmpp $300",
                new Kenny().encode("Wie is kenny p@y me $300"));
        assertEquals("MmmMmpMmfMpmMppMpfMfmMfpMffPmmPmpPmfPpmPppPpfPfmPfpPffFmmFmpFmfFpmFppFpfFfmFfp",
                new Kenny().encode("ABCDEFGHIJKLMNOPQRSTUVWXYZ"));
        assertEquals("mmmmmpmmfmpmmppmpfmfmmfpmffpmmpmppmfppmpppppfpfmpfppfffmmfmpfmffpmfppfpfffmffp",
                new Kenny().encode("abcdefghijklmnopqrstuvwxyz"));
    }

    /**
     * Test of decode method, of class Kenny.
     */
    @Test
    public void testDecode() {
        assertEquals("Wie is kenny p@y me $300",
                new Kenny().decode("Fppmffmpp mfffmm pmpmppppppppffm pfm@ffm ppmmpp $300"));
        assertEquals("ABCDEFGHIJKLMNOPQRSTUVWXYZ",
                new Kenny().decode("MmmMmpMmfMpmMppMpfMfmMfpMffPmmPmpPmfPpmPppPpfPfmPfpPffFmmFmpFmfFpmFppFpfFfmFfp"));
        assertEquals("abcdefghijklmnopqrstuvwxyz",
                new Kenny().decode("mmmmmpmmfmpmmppmpfmfmmfpmffpmmpmppmfppmpppppfpfmpfppfffmmfmpfmffpmfppfpfffmffp"));
    }

}
