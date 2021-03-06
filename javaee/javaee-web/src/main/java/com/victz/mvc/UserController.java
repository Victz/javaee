/*
 * The MIT License
 *
 * Copyright 2016 Victz.com.
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package com.victz.mvc;

import com.victz.lib.entity.User;
import com.victz.model.UserModel;
import java.net.URI;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.MvcContext;
import javax.mvc.annotation.Controller;
import javax.mvc.annotation.View;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.Response;

/**
 *
 * @author Victz.com
 */
@Path("user")
@Controller
@RequestScoped
public class UserController {

    @Inject
    MvcContext mvcContext;
    @Inject
    UserModel userModel;

    @GET
    @Path("")
    @View("user.jsp")
    public void index() {
    }

    @POST
    @Path("save")
    public Response save(@BeanParam User user) {
        userModel.setUser(user);
        userModel.save();
        return Response.seeOther(URI.create(mvcContext.getBasePath() + "/user")).build();
    }

    @GET
    @Path("delete/{id}")
    public Response delete(@PathParam("id") String id) {
        userModel.delete(id);
        return Response.seeOther(URI.create(mvcContext.getBasePath() + "/user")).build();
    }
}
