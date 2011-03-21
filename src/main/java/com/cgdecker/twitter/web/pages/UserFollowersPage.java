package com.cgdecker.twitter.web.pages;

import com.cgdecker.twitter.messages.AppMessages;
import com.cgdecker.twitter.user.User;
import com.cgdecker.twitter.user.UserService;
import com.cgdecker.twitter.user.UserSession;
import com.google.inject.name.Named;
import com.google.sitebricks.At;
import com.google.sitebricks.http.Get;
import com.google.sitebricks.rendering.Decorated;

import java.util.Set;

import javax.inject.Inject;

/**
 * @author cgdecker@gmail.com (Colin Decker)
 */
@At("/:username/followers") @Decorated
public class UserFollowersPage extends PageBase {
  private final UserService userService;

  private User user;

  @Inject public UserFollowersPage(UserService userService, UserSession userSession,
                                   AppMessages appMessages) {
    super(userSession, appMessages);
    this.userService = userService;
  }

  @Override public String getTitle() {
    return user.getUsername() + "'s followers";
  }

  @Get public void get(@Named("username") String username) {
    user = userService.getUserByName(username);
  }

  public User getUser() {
    return user;
  }
}
