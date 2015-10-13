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

import org.junit.Test;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.pentaho.di.core.util.Assert;
import org.pentaho.metadata.model.concept.types.JoinType;
import pt.webdetails.cda.query.QueryOptions;
import pt.webdetails.cda.settings.CdaSettings;
import pt.webdetails.cda.CdaTestCase;

//TODO: Test is not asserting anything. Must be reviewed
public class JoinCompoundDataAccessIT extends CdaTestCase {

  private static final Log logger = LogFactory.getLog( JoinCompoundDataAccessIT.class );

  @Test
  public void testCompoundQuery() throws Exception {

    final CdaSettings cdaSettings = getSettingsManager().parseSettingsFile( "sample-join.cda" );
    logger.error( "Doing query on Cda - Initializing CdaEngine" );

    QueryOptions queryOptions = new QueryOptions();
    queryOptions.setDataAccessId( "3" );
    logger.info( "Doing query" );

    getEngine().doQuery( cdaSettings, queryOptions );
  }

  @Test
  public void testCDA43_CreationWithNullJoinType() throws Exception {

    CdaSettings cdaSettings = getSettingsManager().parseSettingsFile( "sample-join-null-jointype.cda" );
    JoinCompoundDataAccess jcda = (JoinCompoundDataAccess) cdaSettings.getDataAccess( "3" );

    Assert.assertTrue( jcda.getJoinType() == JoinType.FULL_OUTER );
  }

}
