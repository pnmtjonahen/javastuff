/* 
 * Copyright (C) 2015 Philippe Tjon - A - Hen, philippe@tjonahen.nl
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

function split(line) {
    var objPattern = new RegExp("\"(.+?)\"", "gi");

    var splitted = [];
    var arrMatches = null;


    while (arrMatches = objPattern.exec(line)) {
        splitted.push(arrMatches[1]);
    }
    return splitted;
}
;

function parseToJson(line) {
    var splitted = split(line);
    return {"first": splitted[0],
        "second": splitted[1],
        "third": splitted[2],
        "fourth": splitted[3],
        "fifth": splitted[4],
        "sixth": splitted[5],
        "seventh": splitted[6],
        "eighth": splitted[7],
        "nineth": splitted[8]
    };
}
;

