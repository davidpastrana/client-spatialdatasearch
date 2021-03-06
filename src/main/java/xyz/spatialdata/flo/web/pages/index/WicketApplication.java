package xyz.spatialdata.flo.web.pages.index;

import org.apache.wicket.RuntimeConfigurationType;
import org.apache.wicket.authroles.authentication.AbstractAuthenticatedWebSession;
import org.apache.wicket.authroles.authentication.AuthenticatedWebApplication;
import org.apache.wicket.core.util.file.WebApplicationPath;
import org.apache.wicket.markup.html.WebPage;
import org.apache.wicket.spring.injection.annot.SpringComponentInjector;
import org.apache.wicket.util.lang.Bytes;

import xyz.spatialdata.flo.web.pages.contact.AboutUsPage;
import xyz.spatialdata.flo.web.pages.contact.ContactPage;
import xyz.spatialdata.flo.web.pages.error.ErrorPage404;
import xyz.spatialdata.flo.web.pages.locations.LocationServicePage;
import xyz.spatialdata.flo.web.pages.properties.SetPropertiesPage;
import xyz.spatialdata.flo.web.pages.user.LoginUserPage;
import xyz.spatialdata.flo.web.pages.user.LogoutUserPage;
import xyz.spatialdata.flo.web.pages.user.RegisterUserPage;


public class WicketApplication extends AuthenticatedWebApplication {

  @Override
  public Class<? extends WebPage> getHomePage() {
    return LocationServicePage.class;
  }

  @Override
  protected Class<? extends AbstractAuthenticatedWebSession> getWebSessionClass() {
    return AppWebSession.class;
  }

  @Override
  protected Class<? extends WebPage> getSignInPageClass() {
    return LoginUserPage.class;
  }

  @Override
  public void init() {
    super.init();
    mountPage("/", LocationServicePage.class);
    mountPage("/config", SetPropertiesPage.class);
    mountPage("/about", AboutUsPage.class);
    mountPage("/contact", ContactPage.class);
    mountPage("/register", RegisterUserPage.class);
    mountPage("/login", LoginUserPage.class);
    mountPage("/logout", LogoutUserPage.class);
    mountPage("/error", ErrorPage404.class);
    
    getDebugSettings().setAjaxDebugModeEnabled(false);
    getComponentInstantiationListeners().add(new SpringComponentInjector(this));
    getResourceSettings().getResourceFinders().add(
        new WebApplicationPath(getServletContext(), "/src/main/resources/"));
    //getStoreSettings().setInmemoryCacheSize(50);
    //getStoreSettings().setMaxSizePerSession(Bytes.kilobytes(500));
    getApplicationSettings().setPageExpiredErrorPage(ErrorPage404.class);
  }

  @Override
  public RuntimeConfigurationType getConfigurationType() {
    return RuntimeConfigurationType.DEPLOYMENT;
  }
}
