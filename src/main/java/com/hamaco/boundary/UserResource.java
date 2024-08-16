package com.hamaco.boundary;

import com.hamaco.dto.LoginUserData;
import com.hamaco.interactor.in.IUserService;
import jakarta.annotation.security.PermitAll;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.parameters.RequestBody;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

@Path("users")
@PermitAll
public class UserResource {
  private final IUserService userService;

  @Inject
  public UserResource(IUserService userService) {
    this.userService = userService;
  }

  @POST
  @Path("/login")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  @Operation(summary = "Login the user")
  @APIResponses({
    @APIResponse(responseCode = "200", description = "Login successfully"),
    @APIResponse(responseCode = "403", description = "Invalid username or password")
  })
  public Response login(
      @RequestBody(description = "Login body", required = true) LoginUserData userLoginData) {
    return Response.ok()
        .entity(userService.login(userLoginData.getUsername(), userLoginData.getPassword()))
        .build();
  }
}
