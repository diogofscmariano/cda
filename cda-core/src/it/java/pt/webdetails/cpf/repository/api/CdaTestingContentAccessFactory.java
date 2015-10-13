package pt.webdetails.cpf.repository.api;

import java.io.File;

/**
 * Content access factory used in test cases.
 */
public class CdaTestingContentAccessFactory implements IContentAccessFactory {

  public static final String DEFAULT_REPOSITORY = "repository";

  File baseSystem;
  File baseRepository;

  public CdaTestingContentAccessFactory() {
    // assumes test resources were copied to classpath
    File base =
      new File( CdaTestingContentAccessFactory.class.getProtectionDomain().getCodeSource().getLocation().getPath() );
    baseSystem = base;
    baseRepository = new File( base, DEFAULT_REPOSITORY );
  }

  public IUserContentAccess getUserContentAccess( String basePath ) {
    return new TestRepositoryAccess( new File( baseRepository, basePath ) );
  }

  public IReadAccess getPluginRepositoryReader( String basePath ) {
    return new TestRepositoryAccess( new File( baseRepository, basePath ) );
  }

  public IRWAccess getPluginRepositoryWriter( String basePath ) {
    return new TestRepositoryAccess( new File( baseRepository, basePath ) );
  }

  public IReadAccess getPluginSystemReader( String basePath ) {
    return new TestRepositoryAccess( new File( baseSystem, basePath ) );
  }

  public IRWAccess getPluginSystemWriter( String basePath ) {
    return new TestRepositoryAccess( new File( baseSystem, basePath ) );
  }

  public IReadAccess getOtherPluginSystemReader( String pluginId, String basePath ) {
    throw new UnsupportedOperationException();
  }

  public IRWAccess getOtherPluginSystemWriter( String pluginId, String basePath ) {
    throw new UnsupportedOperationException();
  }

  public String toString() {
    return getClass().getName() + ": " + "system= '" + baseSystem + "', repo='" + baseRepository + "'";
  }


}
