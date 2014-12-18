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
package nl.tjonahen.jacocopoc.web;

import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import nl.tjonahen.jacocopoc.PocBusiness;
import nl.tjonahen.jacocopoc.PocBusinessImpl;
import nl.tjonahen.jacocopoc.dto.InputDto;

/**
 * REST Web Service
 *
 * @author Philippe Tjon-A-Hen philippe@tjonahen.nl
 */
@Path("generic")
public class GenericResource {

    @Context
    private UriInfo context;

    private final PocBusiness pocBusiness;
    private final InputBuilder inputBuilder;
    
    /**
     * Creates a new instance of GenericResource
     */
    public GenericResource() {
        this.pocBusiness = new PocBusinessImpl();
        this.inputBuilder = new InputBuilder();
    }

    /**
     * Retrieves representation of an instance of nl.tjonahen.jacocopoc.web.GenericResource
     * @return an instance of java.lang.String
     */
    @GET
    @Produces("application/xml")
    public String getXml() {
        return pocBusiness.doPerformBMethod(inputBuilder.buildDefault());

    }

    /**
     * PUT method for updating or creating an instance of GenericResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String aap, String noot) {
        pocBusiness.doPerformAMethod(new InputDto.Builder().aap(aap).noot(noot).build());
    }
}
