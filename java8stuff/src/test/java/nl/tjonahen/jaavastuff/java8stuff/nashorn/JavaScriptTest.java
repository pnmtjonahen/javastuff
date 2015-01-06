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
package nl.tjonahen.jaavastuff.java8stuff.nashorn;

import java.io.InputStreamReader;
import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import jdk.nashorn.api.scripting.ScriptObjectMirror;
import org.junit.Test;

/**
 *
 * @author Philippe Tjon - A - Hen, philippe@tjonahen.nl
 */
public class JavaScriptTest {

    @Test
    public void test() throws ScriptException, NoSuchMethodException {

        ScriptEngineManager engineManager
                = new ScriptEngineManager();
        
        ScriptEngine engine
                = engineManager.getEngineByName("nashorn");
        
        
        engine.eval("function sum(a, b) { return a + b; }");
        Invocable invocable = (Invocable) engine;

        System.out.println(invocable.invokeFunction("sum", 1, 2));

    }
    
    @Test
    public void testParseToJson() throws ScriptException, NoSuchMethodException {
        ScriptEngineManager engineManager
                = new ScriptEngineManager();
        
        ScriptEngine engine
                = engineManager.getEngineByName("nashorn");
        engine.eval(new InputStreamReader(this.getClass().getResourceAsStream("/parse.js")));
        Invocable invocable = (Invocable) engine;
                                                      
        ScriptObjectMirror obj = (ScriptObjectMirror)invocable.invokeFunction("parseToJson","\"Aap\",\"Noot\",\"Mies\",\"Wim\",\"Zus\",\"Jet\",\"Vuur\",\"Gijs\",\"Tom\"");
        
        obj.entrySet().stream().forEach((entry) -> {
            System.out.println("" + entry.getKey() + " -> " + entry.getValue());
        });
        
        System.out.println("first:" + obj.getMember("first"));
        
    }
}
