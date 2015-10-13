package pt.webdetails.cpf.repository.api;

import org.apache.commons.io.FilenameUtils;
import pt.webdetails.cpf.Util;
import pt.webdetails.cpf.repository.impl.FileBasedResourceAccess;

import java.io.File;

public class TestRepositoryAccess extends FileBasedResourceAccess implements IUserContentAccess {

  private final File baseDir;

  public TestRepositoryAccess( File baseDir ) {
    this.baseDir = baseDir;
  }

  public TestRepositoryAccess( String path ) {
    this.baseDir = new File( FilenameUtils.separatorsToUnix( path ) );
  }

  protected File getFile( String path ) {
    return new File( Util.joinPath( FilenameUtils.separatorsToUnix( baseDir.getPath() ), path ) );
  }

  public boolean hasAccess( String filePath, FileAccess access ) {
    return true;
  }

}
