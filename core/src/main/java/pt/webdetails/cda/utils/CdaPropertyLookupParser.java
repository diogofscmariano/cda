
/*!
* Copyright 2002 - 2014 Webdetails, a Pentaho company.  All rights reserved.
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
package pt.webdetails.cda.utils;


import java.io.Serializable;

import org.pentaho.reporting.engine.classic.core.ClassicEngineBoot;
import org.pentaho.reporting.engine.classic.core.DataRow;
import org.pentaho.reporting.engine.classic.core.StaticDataRow;
import org.pentaho.reporting.libraries.base.config.Configuration;
import org.pentaho.reporting.libraries.base.util.FastStack;
import org.pentaho.reporting.engine.classic.core.util.PropertyLookupParser;



/**
 * this class extends org.pentaho.reporting.engine.classic.core.util.PropertyLookupParser
 */


public class CdaPropertyLookupParser extends PropertyLookupParser {


        private DataRow parameters = null;

        public CdaPropertyLookupParser(final DataRow parameters)
        {
            this.parameters = parameters;
        }



        public CdaPropertyLookupParser()
        {

        }

        protected String lookupVariable(final String property)
        {
            return parameters.get(property).toString();
        }
}
