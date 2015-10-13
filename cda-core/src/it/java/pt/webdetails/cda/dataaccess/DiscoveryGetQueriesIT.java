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
import pt.webdetails.cda.settings.CdaSettings;
import pt.webdetails.cda.CdaTestCase;

//TODO: Test is not asserting anything. Must be reviewed
public class DiscoveryGetQueriesIT extends CdaTestCase {

  private static final Log logger = LogFactory.getLog( DiscoveryGetQueriesIT.class );

  public void testGetQueries() throws Exception {

    final CdaSettings cdaSettings = parseSettingsFile( "sample-discovery.cda" );

    logger.debug( "Getting parameters info on CDA file" );
    final CdaEngine engine = CdaEngine.getInstance();

    logger.info( "Listing queries" );
    System.out.print( engine.listQueries( cdaSettings ) );
  }
}
