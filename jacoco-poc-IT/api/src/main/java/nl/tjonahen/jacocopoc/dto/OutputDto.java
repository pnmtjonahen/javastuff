/*
 * Copyright (C) 2013 Philippe Tjon-A-Hen philippe@tjonahen.nl
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
package nl.tjonahen.jacocopoc.dto;

public class OutputDto {

    private final String mies;
    private final String wim;

    private OutputDto(final Builder builder) {
        this.mies = builder.mies;
        this.wim = builder.wim;
    }

    public String getMies() {
        return mies;
    }

    public String getWim() {
        return wim;
    }

    public static class Builder {

        private String mies;
        private String wim;

        public Builder mies(final String mies) {
            this.mies = mies;
            return this;
        }

        public Builder wim(final String wim) {
            this.wim = wim;
            return this;
        }

        public OutputDto build() {
            return new OutputDto(this);
        }
    }
}
