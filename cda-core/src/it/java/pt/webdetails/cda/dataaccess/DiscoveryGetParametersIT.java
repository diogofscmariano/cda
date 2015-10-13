/*!
* Copyright 2002 - 2013 Webdetails, a Pentaho company.  All rights reserved.
* 
* This software was developed by Webdetails and is provided under the terms
* of the Mozilla Public License, Version 2.0, or any later version. You may not use
* this file except in compliance with the license. If you need a copy of the license,
* please go to  http://mozilla.org/MPL/2.0/. The Initial Developer is Webdetails.
*
* Software distributed under the Mozilla Public License is distributed on an "AS IS"
* basis, WITHOUT WARRANTY OF ANY KIND, either express or  implied. Please refer to
* the license for the specific language governing your rights and limitations.
*/

package pt.webdetails.cda.dataaccess;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import pt.webdetails.cda.CdaEngine;
import pt.webdetails.cda.CdaTestCase;
import pt.webdetails.cda.settings.CdaSettings;

import java.io.OutputStream;

//TODO: Test is not asserting anything. Must be reviewed
public class DiscoveryGetParametersIT extends CdaTestCase {

  private static final Log logger = LogFactory.getLog( DiscoveryGetParametersIT.class );

  public void testGetParameters() throws Exception {
    // Define an outputStream
    OutputStream out = System.out;

    final CdaSettings cdaSettings = parseSettingsFile( "sample-discovery.cda" );
    logger.debug( "Doing discovery on the file" );
    final CdaEngine engine = CdaEngine.getInstance();

    // JSON
    logger.info( "Doing discovery, return xml" );
    engine.getExporter( "xml" ).export( out, engine.listParameters( cdaSettings, "2" ) );

    // XML
    logger.info( "Doing discovery, return json" );
    engine.getExporter( "json" ).export( out, engine.listParameters( cdaSettings, "2" ) );
  }
}
